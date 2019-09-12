

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Formatter;

public class myFile {

	public myFile() {
	}
	public static void main(String[] args) {
		try{
			File x = new File("C:\\input.txt");
			Formatter f = new Formatter("C:\\output.txt");
			Scanner sc = new Scanner(x);
			while(sc.hasNext()){
				
				String partString = sc.next();
				String part = partString.substring(partString.lastIndexOf(":")+1);
				
								
				String cmd1 = new String(partString.substring(0, partString.lastIndexOf(":")));
															
				String[] part1 = part.split(",");
				String calc = "";
								
				if(cmd1.indexOf("min") ==0){
					calc = mininum(part1);
				}
				
				if(cmd1.indexOf("max") ==0){
					calc = maximum(part1);
				}
				
				if(cmd1.indexOf("avg") ==0){
					calc = average(part1);
				}
				
				if(cmd1.indexOf("P90") ==0){
					calc = percent90(part1);
				}
				
				if(cmd1.indexOf("Sum") ==0){
					calc = sumOf(part1);
				}
				
				if(cmd1.indexOf("P70") ==0){
					calc = percent70(part1);
				}
												
				f.format(calc + "\r\n");	
				
			}
			sc.close();
			f.close();
			}catch(FileNotFoundException e){
				System.out.println("Error");
			}
		}
	public static String mininum(String[] min){
		
		Arrays.sort(min);
		String min1 = min[0];
		
		return "The min of " + Arrays.deepToString(min)+ " is " + min1;
	}
	
	public static String maximum(String[] max){
		
		Arrays.sort(max);
		String max1 = max[max.length -1];
		
		return "The max of " + Arrays.deepToString(max)+ " is " + max1;
	}

	public static String average(String[] avg){
		
		int a[] = new int[avg.length]; 
		for(int i = 0; i < a.length; i++){
		    a[i] = Integer.parseInt(avg[i]);
		}
		double sum = IntStream.of(a).sum();		
		
		return "The avg of " + Arrays.deepToString(avg) + " is " + sum/avg.length;
	}
	
	public static String percent90(String[] P90th){
		
		int[] result = new int[P90th.length];
		   for (int i = 0; i < P90th.length; i++) {
		      result[i] = Integer.parseInt(P90th[i]);
		   }
		   
		Arrays.sort(result);
				
		int P90th1 = P90th.length;
		
		double calcper = P90th1*0.9;
		
		int x = (int)(calcper * 100/100);
			
		return ("The 90th percentile of " + Arrays.deepToString(P90th) + " is " + x);
		
	}
	
	public static String sumOf(String[] sum){
		
		int a[] = new int[sum.length]; 
		for(int i = 0; i < a.length; i++){
		    a[i] = Integer.parseInt(sum[i]);
		}
		double sum1 = IntStream.of(a).sum();		
		
		return "The sum of " + Arrays.deepToString(sum) + " is " + sum1;
		
	}
	
public static String percent70(String[] P70th){
		
		int[] result1 = new int[P70th.length];
		   for (int i = 0; i < P70th.length; i++) {
		      result1[i] = Integer.parseInt(P70th[i]);
		   }
		   
		Arrays.sort(result1);
				
		int P90th1 = P70th.length;
		
		double calcper1 = P90th1*0.7;
		
		int x = (int)(calcper1 * 100/100);
			
		return ("The 70th percentile of " + Arrays.deepToString(P70th) + " is " + x);
		
	}
	
	
}