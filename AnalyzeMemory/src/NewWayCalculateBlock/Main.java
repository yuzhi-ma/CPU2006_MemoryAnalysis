package NewWayCalculateBlock;
import java.util.Arrays; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Time Spend sorting: 9
//Loading first dump: 
//Start comparison: 
//Time Spend Comparing: 17
//total lines: 14431054
//total equal lines: 5852697
//total lines: 39321600

//1400mb: total lines:91750400
//page:358400
public class Main {

    public static void main(String[] args) throws IOException {
    	run(args[1],args[2]);
    }
    
    public static void run(String file1, String file2) throws IOException {
    	BufferedReader reader10 = new BufferedReader(new FileReader(file1));
        BufferedReader reader20 = new BufferedReader(new FileReader(file2));
        int length1 = 0;
        int length2 = 0;
        String str20;
    	while((str20 = reader10.readLine()) != null) {
    		if(str20.length() == 67) {
    			length1++;
    		}
    	}
    	length1 = length1/4;
    	
    	while((str20 = reader20.readLine()) != null) {
    		if(str20.length() == 67) {
    			length2++;
    		}
    	}
    	length2 = length2/4;
    	reader10.close();
        reader20.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        
        try{
        	System.out.println("Start dump files:" + file1 + "  " + file2);
        	String str1;
        	String str2;
        	String[] array2 = new String[length2];
        	
        	int index1 = 0;
        	int index2 = 0;
        	int numEqual = 0;
        	String[] temp = new String[4];
        	int tempIndex = 0;
        	while((str2 = reader2.readLine()) != null) {
        		if(str2.length() == 67) {
        			str2 = str2.substring(8, 45);
        			temp[tempIndex++] = str2;
        		}
        		if(tempIndex == 4) {
        			tempIndex = 0;
        			for(int i = 0; i < 4; i++) {
        				if(!temp[i].equals("00000000 00000000 00000000 00000000")) {
        					array2[index2++] = temp[0].concat(temp[1]).concat(temp[2]).concat(temp[3]);
        					break;
                		}
        			}
        		}
        	}
        	System.out.println("Sorting:");
//        	long start = System.nanoTime();
        	Arrays.sort(array2,0,index2);
//        	long end = System.nanoTime() - start;
//        	System.out.println("Time Spend sorting: " + end/1000000000);
        	System.out.println("Start comparison: ");
        	tempIndex = 0;
        	while((str1 = reader1.readLine()) != null) {
        		if(str1.length() == 67) {
        			str1 = str1.substring(8, 45);
        			temp[tempIndex++] = str1;
        		}
        		if(tempIndex == 4) {
        			tempIndex = 0;
        			for(int i = 0; i < 4; i++) {
        				if(!temp[i].equals("00000000 00000000 00000000 00000000")) {
        					index1++;
        					str1 = temp[0].concat(temp[1]).concat(temp[2]).concat(temp[3]);
        					if(binarySearch(array2, str1, index2) != -1) {
                    			numEqual++;
                    		}
        					break;
                		}
        			}
        		}
        	}
        	reader1.close();
            reader2.close();
            
        	System.out.println("total non-zero block in first dump: " + index1);
        	System.out.println("total equal block in first dump: " + numEqual);
        	long percentage = numEqual*100/index1;
            System.out.println("Percentage equal block: " + percentage+"%");
            System.out.println("");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static int binarySearch(String[] arr, String x, int index) 
    { 
        int l = 0, r = index - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(arr[m]); 
            if (res == 0) 
                return m; 
            if (res > 0) 
                l = m + 1; 
            else
                r = m - 1; 
        } 
        return -1; 
    } 

}
