package day13.exam;

public class LocationVO implements Comparable<LocationVO> {
	
	public static LocationVO target;

	private String regionName;
	private double latitude;
	private double longitude;
	
	public LocationVO(String regionName, double latitude, double longitude) {
		this.regionName = regionName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double calcDistance(LocationVO position){
		return Math.sqrt( 
			Math.pow((position.latitude - this.latitude),2) +
			Math.pow((position.longitude - this.longitude),2));
	}

	public String getRegionName() {
		return regionName;
	}
	
	@Override
	public String toString() {
		return "LocationVO [regionName=" + regionName + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

	@Override
	public int compareTo(LocationVO other) {
		double myDistance    = calcDistance(target);
		double otherDistance = other.calcDistance(target);

		if (myDistance == otherDistance) return 0;
		return myDistance > otherDistance ? 1 : -1;
	}
}








