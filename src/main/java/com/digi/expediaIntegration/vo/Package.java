package com.digi.expediaIntegration.vo;

public class Package {
	
	private Destination destination;
	private Origin origin;
	private OfferDateRange offerDateRange;
	private PackagePricingInfo packagePricingInfo;
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Origin getOrigin() {
		return origin;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	public OfferDateRange getOfferDateRange() {
		return offerDateRange;
	}
	public void setOfferDateRange(OfferDateRange offerDateRange) {
		this.offerDateRange = offerDateRange;
	}
	public PackagePricingInfo getPackagePricingInfo() {
		return packagePricingInfo;
	}
	public void setPackagePricingInfo(PackagePricingInfo packagePricingInfo) {
		this.packagePricingInfo = packagePricingInfo;
	}

}
