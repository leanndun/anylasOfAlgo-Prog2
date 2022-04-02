import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Store {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public int id;
	public String address;
	public String city;
	public String state;
	public int zipCode;
	public double latitude;
	public double longitude;
	public double distance;
	
	public Store() {
		
	}
	
	public Store (String theId, String theAddress, String theCity, String theState, String theZip, String theLat, String theLongti) {
		id=Integer.parseInt(theId);
		address=theAddress;
		city=theCity;
		state=theState;
		zipCode=Integer.parseInt(theZip);
		latitude= Double.parseDouble(theLat);
		longitude=Double.parseDouble(theLongti);
		distance=-1;

	
	}
	
	
	public void computeDistance (double otherLat, double otherLong) {
		//Haversine Formula
		double radiusOfEarthInMiles= 3958.8;
		
		//First we convert the latitudes and longitudes to radians
		double lat1= Math.toRadians(latitude);
		double lat2= Math.toRadians(otherLat);
		double long1= Math.toRadians(longitude);
		double long2= Math.toRadians(otherLong);
		
		//Then we can apply the Haverine Formula to get the distance in miles
		double a = Math.pow(Math.sin((lat2-lat1)/2), 2) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin((long2-long1)/2), 2);
		double c= 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		distance= radiusOfEarthInMiles*c;
	}
	

	public String toString() {
		String ret= "id- " + this.getId();
		ret+= "; add- " + this.getAddress();
		ret+= "; city- " + this.getCity();
		ret+= "; state- " + this.getState();
		ret+= "; zip- " + this.getZipCode();
		ret+= "; lat- " + this.getLatitude();
		ret+= "; long- " + this.getLongitude() + "\n";
		ret+= "distance- "+ df.format(this.getDistance()) +"\n";
		return ret;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}



	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}



	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}



	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}



	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}



	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
	
	

}
