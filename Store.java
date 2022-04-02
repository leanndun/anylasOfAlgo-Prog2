import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Store {
	public static ArrayList<Store> data;
	public double arr[];
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
	
	public ArrayList<Store> loadStore(String filename) throws IOException{
		try {
			Scanner scan = new Scanner(new File(filename));
			scan.nextLine();
			setData(this.data);
			
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens = line.split( "," );
				if( tokens!=null && tokens.length==7) {
					String id = tokens[0];
					String add= tokens[1];
					String city= tokens[2];
					String state= tokens[3];
					String zip= tokens[4];
					String lat= tokens[5];
					String longti= tokens[6];
					
					Store tempStore = new Store (id, add, city, state, zip, lat, longti);
					this.data.add(tempStore);
				}
			}
			
			
			scan.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return data;
		
	}
	public double[] makeArr(ArrayList<Store> data, double latit, double longtd) {
		this.arr= new double[data.size()];
		double hey;
		double hi;
		Store temp= new Store();
		for(int i=0; i<arr.length; i++) {
			hey=data.get(i).latitude;
			hi=data.get(i).longitude;
			temp=data.get(i);
			temp.computeDistance(latit, longtd);
			arr[i]=temp.getDistance();
			}
		return arr;
	}
	
	public void printArrayList() {
		String ret = "";
		for(int i=0; i<this.getData().size(); i++)
			ret+= this.data.get(i)+ "\n";
		System.out.println(ret);
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
		String ret= "Store #" + this.getId();
		ret+= ". " + this.getAddress();
		ret+= ", " + this.getCity();
		ret+= ", " + this.getState();
		ret+= ", " + this.getZipCode();
		ret+= ". - " + df.format(this.getDistance()) + " miles";
		return ret;
	}
	
	public void setData(ArrayList<Store> data) {
		this.data = new ArrayList<>();
	}
	
	public ArrayList<Store> getData() {
		return data;
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
