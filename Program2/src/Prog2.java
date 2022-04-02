import java.io.File;
import java.io.*;
import java.util.List;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Prog2 {
	private int rank;
	public double arr[];
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public Prog2(double[]arr, int rank)
	{
		if (rank < 1 || rank > arr.length){
			throw new ArrayIndexOutOfBoundsException("rank out of bounds");
		}
		this.rank = rank;
		this.arr=arr;
		
	}
	public Prog2() {
		
	}
	
	
	public void setRank(int rank) {
		this.rank = rank;
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

	
	//MAIN
	public static void main( String[] args ) throws IOException {
		Store go= new Store();
		go.loadStore("data/WhataburgerData.csv");
		ArrayList<Store> myList = go.getData();
		double[] fun= go.makeArr(myList);
		
		int n= fun.length;
		int rank=30;
		Prog2 hop= new Prog2(fun,rank);
		for(int i=1; i<rank+1; i++) {
			double comp= hop.randomSelect(0,n-1,i);
			for(int j=0; j<myList.size(); j++) {
				if(comp == myList.get(j).getDistance()) {
					System.out.println(myList.get(j));
			}
			}
		}
		

	}
	

}
