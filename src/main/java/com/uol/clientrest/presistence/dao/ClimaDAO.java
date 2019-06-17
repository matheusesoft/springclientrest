package com.uol.clientrest.presistence.dao;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClimaDAO {

	private String id;

	@JsonProperty("weather_state_name")
	private String weatherStateName;

	@JsonProperty("weather_state_abbr")
	private String weatherStateAbbr;

	@JsonProperty("wind_direction_compass")
	private String windDirectionCompass;

	private String created;

	@JsonProperty("applicable_date")
	private String applicableDate;

	@JsonProperty("min_temp")
	private BigDecimal minTemp;

	@JsonProperty("max_temp")
	private BigDecimal maxTemp;

	@JsonProperty("the_temp")
	private Float theTemp;

	@JsonProperty("wind_speed")
	private Float windSpeed;

	@JsonProperty("wind_direction")
	private Float windDirection;
	
	@JsonProperty("air_pressure")
	private Float airPressure;
	
	private Integer humidity;

	private Object visibility;

	private Integer predictability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeatherStateName() {
		return weatherStateName;
	}

	public void setWeatherStateName(String weatherStateName) {
		this.weatherStateName = weatherStateName;
	}

	public String getWeatherStateAbbr() {
		return weatherStateAbbr;
	}

	public void setWeatherStateAbbr(String weatherStateAbbr) {
		this.weatherStateAbbr = weatherStateAbbr;
	}

	public String getWindDirectionCompass() {
		return windDirectionCompass;
	}

	public void setWindDirectionCompass(String windDirectionCompass) {
		this.windDirectionCompass = windDirectionCompass;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getApplicableDate() {
		return applicableDate;
	}

	public void setApplicableDate(String applicableDate) {
		this.applicableDate = applicableDate;
	}

	public BigDecimal getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(BigDecimal minTemp) {
		this.minTemp = minTemp;
	}

	public BigDecimal getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(BigDecimal maxTemp) {
		this.maxTemp = maxTemp;
	}

	public Float getTheTemp() {
		return theTemp;
	}

	public void setTheTemp(Float theTemp) {
		this.theTemp = theTemp;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Float getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Float windDirection) {
		this.windDirection = windDirection;
	}

	public Float getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(Float airPressure) {
		this.airPressure = airPressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Object getVisibility() {
		return visibility;
	}

	public void setVisibility(Object visibility) {
		this.visibility = visibility;
	}

	public Integer getPredictability() {
		return predictability;
	}

	public void setPredictability(Integer predictability) {
		this.predictability = predictability;
	}

}