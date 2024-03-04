package accidentpack;

/**
 * Represents an accident record with various attributes such as id, severity,
 * start time, end time, street, city, county, state, temperature, humidity,
 * visibility, weather condition, and daytime indication.
 */

public class AccidentRecord {
	private String id;
	private int severity;
	private String startTime;
	private String endTime;
	private String street;
	private String city;
	private String county;
	private String state;
	private double temperature;
	private double humidity;
	private double visibility;
	private String weatherCondition;
	private String isDaytime;

	public AccidentRecord() {
		this.id = null;
		this.severity = 0;
		this.startTime = null;
		this.endTime = null;
		this.street = null;
		this.city = null;
		this.county = null;
		this.state = null;
		this.temperature = 0.0;
		this.humidity = 0.0;
		this.visibility = 0.0;
		this.weatherCondition = null;
		this.isDaytime = null;
	}
	
    public AccidentRecord(AccidentRecord other) {
        this.id = other.id;
        this.severity = other.severity;
        this.startTime = other.startTime;
        this.endTime = other.endTime;
        this.street = other.street;
        this.city = other.city;
        this.county = other.county;
        this.state = other.state;
        this.temperature = other.temperature;
        this.humidity = other.humidity;
        this.visibility = other.visibility;
        this.weatherCondition = other.weatherCondition;
        this.isDaytime = other.isDaytime;
    }

	public AccidentRecord(String id, int severity, String startTime, String endTime, String street, String city,
			String county, String state, double temperature, double humidity, double visibility,
			String weatherCondition, String isDaytime) {
		this.id = id;
		this.severity = severity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.street = street;
		this.city = city;
		this.county = county;
		this.state = state;
		this.temperature = temperature;
		this.humidity = humidity;
		this.visibility = visibility;
		this.weatherCondition = weatherCondition;
		this.isDaytime = isDaytime;
	}

	/**
	 * Gets the street attribute of the accident record.
	 * 
	 * @return The street of the accident.
	 */
	public String getStreet() {
		return this.street;
	}

	public String getCounty() {
		return this.county;
	}

	/**
	 * Gets the street attribute of the accident record.
	 * 
	 * @return The start time of the accident.
	 */
	public String getStartTime() {
		return this.startTime;

	}
	
	/**
	 * Gets the street attribute of the accident record.
	 * 
	 * @return The start time of the accident.
	 */
	public String getState() {
		return this.state;

	}	
	
	public String getID() {
		return this.id;
	}
	
	public String getDate() {
		return this.startTime;
	}

	@Override
	public String toString() {
		return "AccidentRecord{" + "id='" + id + '\'' + ", severity=" + severity + ", startTime='" + startTime + '\''
				+ ", endTime='" + endTime + '\'' + ", street='" + street + '\'' + ", city='" + city + '\''
				+ ", county='" + county + '\'' + ", state='" + state + '\'' + ", temperature=" + temperature
				+ ", humidity=" + humidity + ", visibility=" + visibility + ", weatherCondition='" + weatherCondition
				+ '\'' + ", isDaytime=" + isDaytime + '}';
	}
}