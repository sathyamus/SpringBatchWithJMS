package com.snsystems.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

	private DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	private Date date;
	private String impressions;
	private int clicks;
	private double Earning;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImpressions() {
		return impressions;
	}

	public void setImpressions(String impressions) {
		this.impressions = impressions;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public double getEarning() {
		return Earning;
	}

	public void setEarning(double earning) {
		Earning = earning;
	}

	@Override
	public String toString() {
		return dateFormat.format(date) + ", \"" + impressions
				+ "\", " + clicks + ", " + Earning + "";
	}

}