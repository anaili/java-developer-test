package de.goeuro.internship.model;

/**
 * Model class for the location's json representation
 * 
 * @author Ayemn Naili
 */
public class Location {

	private int _id;
	private String key;
	private String name;
	private String fullName;
	private String iata_airport_code;
	private String type;
	private String country;
	private GeoPosition geo_position;
	private int location_id;
	private boolean inEurope;
	private String countryCode;
	private String coreCountry;
	private String distance;

	public Location() {
		this.geo_position = new GeoPosition();
	}

	public Location(int _id, String key, String name, String fullName,
			String iata_airport_code, String type, String country,
			GeoPosition geo_position, int location_id, boolean inEurope,
			String countryCode, String coreCountry, String distance) {
		super();
		this._id = _id;
		this.key = key;
		this.name = name;
		this.fullName = fullName;
		this.iata_airport_code = iata_airport_code;
		this.type = type;
		this.country = country;
		this.geo_position = geo_position;
		this.location_id = location_id;
		this.inEurope = inEurope;
		this.countryCode = countryCode;
		this.coreCountry = coreCountry;
		this.distance = distance;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIata_airport_code() {
		return iata_airport_code;
	}

	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeoPosition getGeo_position() {
		return geo_position;
	}

	public void setGeo_position(GeoPosition geo_position) {
		this.geo_position = geo_position;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public boolean isInEurope() {
		return inEurope;
	}

	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(String coreCountry) {
		this.coreCountry = coreCountry;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public class GeoPosition {
		private int latitude;
		private int longitude;

		public GeoPosition() {
		}

		public GeoPosition(int latitude, int longitude) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public int getLatitude() {
			return latitude;
		}

		public void setLatitude(int latitude) {
			this.latitude = latitude;
		}

		public int getLongitude() {
			return longitude;
		}

		public void setLongitude(int longitude) {
			this.longitude = longitude;
		}
	}
}
