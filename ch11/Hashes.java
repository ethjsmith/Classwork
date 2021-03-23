import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hashes {

	public static void main(String[] args) {
		
//		String filename = "Shakespeare_20_percent.txt"; 
//		String filename = "Shakespeare_40_percent.txt"; 
//		String filename = "Shakespeare_60_percent.txt"; 
//		String filename = "Shakespeare_80_percent.txt"; 
		String filename = "Shakespeare_100_percent.txt"; 
		String [] fnames = {"Shakespeare_20_percent.txt", "Shakespeare_40_percent.txt","Shakespeare_60_percent.txt","Shakespeare_80_percent.txt","Shakespeare_100_percent.txt"};
		
		//Maybe time your code at this level, you will need to time each file to make a nice graph
		for (int i=0;i< fnames.length;i++) {
			testArrayList(fnames[i]);
			testHashMap(fnames[i]);
		}
		


	}

	public static void testArrayList(String filename) {
		System.out.println("ArrayList: " + filename);
		try {
			Scanner in = new Scanner(new File(filename));
			//Maybe you need to read it in as UTF-8 NO
			//Scanner in = new Scanner(new File(filename), "UTF-8");
			long startTime, endTime, totalTime, avgtime=0,k=0;
			//Create an array list that can hold a string
			ArrayList<String> a = new ArrayList<String>();

			//TODO: You will need to code up some type of loop yourself - this code is just and example
			while (in.hasNext()) {
				String s = in.next();
				s = s.replaceAll("[^a-zA-Z0-9]", "");
				s = s.toLowerCase();
				if (!(a.contains(s))) {
					avgtime += 1;
					startTime = System.nanoTime();
					a.add(s);
					endTime = System.nanoTime();
					totalTime = endTime - startTime;
					k += totalTime;
				}
			}
			System.out.println("Intersertion:" + (k/avgtime) + " MS");
			//Add something to an ArrayList, see if we can find it
			//String s = "Hello%-";
			
			//Maybe time your code at this level.  You can probably make a nice graph using only the largest file
			//Hopefully it is constant, meaning no matter how large it is, this method takes the same time
			//a.add(s);

			//Maybe time your code at this level.  You can probably make a nice graph using only the largest file
			//Hopefully it is linear, meaning the more words you have in your list, the longer it takes
			
			
			
			
			startTime = System.nanoTime();
			if(a.contains("the")) {
				//System.out.println("\tThe word was found");
			}
			endTime   = System.nanoTime();
			totalTime = endTime - startTime;
			
			System.out.println("find" + totalTime + " MS ");
			
			
			
			//System.out.println("\tThere are " + a.size() + " unique words");
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testHashMap(String filename) {
		System.out.println("HashMap " + filename);
		try {
			Scanner in = new Scanner(new File(filename));
			//Maybe you need to read it in as UTF-8
			//Scanner in = new Scanner(new File(filename), "UTF-8");
			long startTime, endTime, totalTime, avgtime=0,k=0;
			//Create an array list that can hold a string.  We map it to an unused boolean value
			HashMap<String,Boolean> h = new HashMap<String,Boolean>();
			while (in.hasNext()) {
				String s = in.next();
				s = s.replaceAll("[^a-zA-Z0-9]", ""); //gets rid of everything except a-Z and 0-9
				s = s.toLowerCase(); //for easier matching
				avgtime += 1;
				startTime = System.nanoTime();
				h.put(s,true);
				endTime = System.nanoTime();
				totalTime = endTime - startTime;
				k += totalTime;
			}
			System.out.println("Intersertion:" + (k/avgtime) + " MS");
	//Add something to an ArrayList, see if we can find it
			
			
			
			
			
			
			
			
			//TODO: You will need to code up some type of loop yourself - this code is just and example
			
			//Add something to an ArrayList, see if we can find it
			String s = "Hello%-";
			
			//Maybe time your code at this level.  You can probably make a nice graph using only the largest file
			//Hopefully it is constant, meaning no matter how large it is, this method takes the same time
			h.put(s,true); //Adds the item to the HashMap with the unused value of true

			//Maybe time your code at this level.  You can probably make a nice graph using only the largest file
			//Hopefully it is constant, meaning no matter how large it is, this method takes the same time
			startTime = System.nanoTime();
			if(h.containsKey("hello")) {
				//System.out.println("\tThe word was found");
			}
			endTime   = System.nanoTime();
			totalTime = endTime - startTime;
			
			System.out.println("find " + totalTime + " MS");
			
			//System.out.println("\tThere are " + h.size() + " unique words");
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
