package com.digi.expediaIntegration.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.digi.expediaIntegration.service.ExpediaService;
import com.digi.expediaIntegration.vo.ExpediaResponse;
import com.digi.expediaIntegration.vo.Package;

/**
 * service to handle Expedia integration
 * @author Lenovo
 *
 */
@Service
class ExpediaServiceImpl implements ExpediaService {
	@Value("${expedia.api.url}")
	private String expediaApiUrl;

	private final RestTemplate restTemplate;

	public ExpediaServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	//filtering based on input
	public List<Package> getPackageOffers(String originCity, String destinationCity) throws Exception {
		return getPackageOffers().stream()
				.filter(packageInfo -> packageInfo.getOrigin().getCity().toLowerCase().equals(originCity)
						&& packageInfo.getDestination().getCity().toLowerCase().equals(destinationCity))
				.toList();
	}

	//Expedia integration
	private List<Package> getPackageOffers() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		try {

			ResponseEntity<ExpediaResponse> response = restTemplate.exchange(expediaApiUrl, HttpMethod.GET, entity,
					ExpediaResponse.class);
			return response.getBody().getOffers().getPackageInfo();
		} catch (HttpClientErrorException e) {
			throw new Exception("External client error occurred: " + e.getStatusCode());
		}

	}
}
