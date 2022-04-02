import java.io.File;
import java.io.*;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Prog2 {
	public ArrayList<Store> data;
	private int rank;
	public static double arr[];

	//public Prog2(ArrayList<Store> data, int rank)
	public Prog2(double[]arr, int rank)
	{
		if (rank < 1 || rank > arr.length){
			throw new ArrayIndexOutOfBoundsException("rank out of bounds");
		}
		//this.data =  new ArrayList<Store>();
		this.rank = rank;
		this.arr=arr;
		//this.arr = new double[];
		
	}
	public Prog2() {
		
	}
	
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setData(ArrayList<Store> data) {
		this.data = new ArrayList<>();
	}
	
	public ArrayList<Store> getData() {
		return data;
	}
	/**
	 * @return the arr
	 */
	public double[] getArr() {
		return arr;
	}
	/**
	 * @param arr the arr to set
	 */
	public void setArr(double[] arr) {
		this.arr = arr;
	}
	
	private int partition(int p, int r) {
		int i = p - 1;
		int j = p;
		double pivot = arr[r]; 
		while(j <= r - 1) {
			if (arr[j] <= pivot) {
				i++;
				swap(i, j);
			}
			j++;
		}
		swap(r, i + 1);
		return i + 1;
	}
	
	private int randomizedPartition(int p, int r) {
		int pivotIndex = (int)(Math.random() * (r - p) + p);
		swap(pivotIndex, r);
		return partition(p, r);
	}
	
	private void swap(int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public double randomSelect(int p, int r, int i) {
		if (p == r) {
			return arr[p];
		}
		int q = randomizedPartition(p, r);
		int k = q - p + 1;
		if (i == k) {
			return arr[q];
		} else if (i < k) {
			return randomSelect(p, q - 1, i);
		} else {
			return randomSelect(q + 1, r, i - k);
		}
	}

	
	public double select() {
		return randomSelect(0, arr.length - 1, rank);
	}

	public double[] loadStore(String filename) throws IOException{
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
			
			// declare array with size of stores
			// for store in stores
			// compute distance
			// add to size arrays
			this.arr= new double[data.size()];
			double hey;
			double hi;
			Store temp= new Store();
			for(int i=0; i<arr.length; i++) {
				//hey= data.get(i);
				hey=data.get(i).latitude;
				hi=data.get(i).longitude;
				temp=data.get(i);
				temp.computeDistance(29.5827351, -98.621094);
				arr[i]=temp.getDistance();
				
			
				
			}	
			
			//int rank=30;
			
			scan.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	
	
	
	public String toString() {
		String ret = "";
		for(int i=0; i<this.getData().size(); i++)
		//for(int i=0; i<30;i++)
			ret+= this.data.get(i)+ "\n";
		return ret;
	}
	
	//MAIN
	public static void main( String[] args ) throws IOException {
		Prog2 sel = new Prog2();
		double[] data= sel.loadStore("data/WhataburgerData.csv");
		int n= data.length;
		int rank=30;
		//Prog2 hop= new Prog2(data,rank);
		//sel= new Prog2(data,rank);
		for(int i=1; i<rank+1; i++) {
			//System.out.println(data[i]);
			System.out.println("The rank = " + rank + " of the array is " + sel.randomSelect(0,n-1,i));
			//hop.randomSelect(0,n-1,i);
			//if(sel.)
		}
		//sel.loadStore("data/WhataburgerData.csv");
		//System.out.println(sel);
		

	}
	

}
