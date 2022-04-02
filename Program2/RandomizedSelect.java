import java.io.File;
import java.io.*;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class RandomizedSelect {
	public ArrayList<Store> data;
	private int rank;
	public double arr[];

	public RandomizedSelect(ArrayList<Store> data, int rank) {
		if (rank < 1 || rank > data.size()){
			throw new ArrayIndexOutOfBoundsException("rank out of bounds");
		}
		this.data =  new ArrayList<Store>();
		this.rank = rank;
		//this.arr = new double[];
		
	}
	public RandomizedSelect() {
		
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



/*	private int partition(int p, int r) {
		int i = p - 1;
		int j = p;
		int pivot = data[r];
		while(j <= r - 1) {
			if (data[j] <= pivot) {
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
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public int randomSelect(int p, int r, int i) {
		if (p == r) {
			return data[p];
		}
		int q = randomizedPartition(p, r);
		int k = q - p + 1;
		if (i == k) {
			return data[q];
		} else if (i < k) {
			return randomSelect(p, q - 1, i);
		} else {
			return randomSelect(q + 1, r, i - k);
		}
	}
	
	public int iterativeSelect() {
		int p = 0;
		int r = data.length - 1;
		int q = 0;
		int i = rank;
		int k = 0;
		while (p != r) {
			q = randomizedPartition(p, r);
			k = q - p + 1;
			if (i == k) {
				break;
			} else if (i < k) {
				r = q - 1;
			} else {
				p = q + 1;
				i = i - k;
			}
		}	
		if (p == r) {
			return data[p];
		} else {
			return data[q];
		}
	}
	
	public int select() {
		return randomSelect(0, data.length - 1, rank);
	}
	
*/
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
	public double randomSelect(double arr[], int left, int right, int i) {
		if (left == right) {
			return arr[left];
		}
		int q = randomizedPartition(arr, left, right);
		int k = q - (left-1);
		if (i == k) {
			return arr[q];
		} else if (i < k) {
			return randomSelect(arr, left, q - 1, i);
		} else {
			return randomSelect(arr, q + 1, right, i - k);
		}
	}
	public double iterativeSelect() {
		int p = 0;
		int r = arr.length - 1;
		int q = 0;
		int i = rank;
		int k = 0;
		while (p != r) {
			q = randomizedPartition(p, r);
			k = q - p + 1;
			if (i == k) {
				break;
			} else if (i < k) {
				r = q - 1;
			} else {
				p = q + 1;
				i = i - k;
			}
		}	
		if (p == r) {
			return data[p];
		} else {
			return data[q];
		}
	}
	
	public int select() {
		return randomSelect(0, data.length - 1, rank);
	}
	
   /* public double[] sortArray(double[] arr) {
        quickSort(arr, 0 , arr.length - 1);
        return arr;
    }
    
    public int partition(double[] arr, int start, int end) {
        int pIndex = (int) (Math.random() * (end - start + 1)) + start; // random-quick-sort
        double pivot = arr[pIndex];
        while (start < end) {
            // skip smaller in left
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            // skip larger in right
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        if (arr[start] < pivot) {
            swap(arr, pIndex, start);
        }
        return start;
    }
    
    */
	
	
	public void loadStore(String filename) throws IOException{
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
					//tempStore.computeDistance(29.5827351, -98.621094);
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
			scan.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String toString() {
		String ret = "";
		for(int i=0; i<this.getData().size(); i++)
		//for(int i=0; i<;i++)
			ret+= this.data.get(i)+ "\n";
		return ret;
	}
	
	//MAIN
	public static void main( String[] args ) throws IOException {
		RandomizedSelect sel = new RandomizedSelect();
		sel.loadStore("data/WhataburgerData.csv");
		//System.out.println(sel);
		
		
		/*int[] data = {1, 3, 6, 2, 5, 11, 8, 7, 0, -1};
		int rank = 3;
		RandomizedSelect selection = new RandomizedSelect(data, rank);
		System.out.println("The rank = " + rank + " of the array is " + selection.iterativeSelect());*/
	}
	

}