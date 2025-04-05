package com.digi.expediaIntegration.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Offer {
	@JsonProperty("Package")
	private List<Package> packageInfo;

	public List<Package> getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(List<Package> packageInfo) {
		this.packageInfo = packageInfo;
	}
	

}
