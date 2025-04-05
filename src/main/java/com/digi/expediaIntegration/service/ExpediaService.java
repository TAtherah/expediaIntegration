package com.digi.expediaIntegration.service;

import java.util.List;
import java.util.Map;

import com.digi.expediaIntegration.vo.Package;

public interface ExpediaService {
	
	public List<Package> getPackageOffers(String originCity, String destinationCity)  throws Exception;

}
