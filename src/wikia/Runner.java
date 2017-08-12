package wikia;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.*;
//import java.io.*;


import wikia.scenarios.Scenario1;
import wikia.scenarios.Scenario2;

public class Runner {
	
	int zzz;
	
	static final String myArray[]= {"a","b"};
	
	static final ArrayList <String> newArr= new ArrayList<String>();//{"a","b"};

	

	static final String Broswer = "safari";
	public static int anInput1[] = {2,3,6,7,15, 1, 1, 9};
	public static int anInput2[] = {3,7,15,7,15, 77};
	int [] testsc = new int [6];
	public static int anInputResult[] = new int [15];
	public static ArrayList<String> ArrList = new ArrayList<String>();
	public static Clock [] myClocks= new Clock[5];
	
	public static void main(String[] args) throws ParseException {
		
		double [][] temperatures = new double [2][]; // Allocate two rows.
		temperatures [0] = new double [3]; // Allocate three columns for row 0
		temperatures [1] = new double [3]; // Alllocate three columns for row 1
		temperatures [0][0] = 20.5; // Populate row 0
		temperatures [0][1] = 30.6;
		temperatures [0][2] = 28.3;
		temperatures [1][0] = -38.7; // Populate row 1
		temperatures [1][1] = -18.3;
		temperatures [1][2] = -16.2;
	
		int m, srch=34;
		
		int [] findin = new int [] {1, 5, 6, 34, 7};
		
		for (m=0;m<findin.length; m++){
			if (findin[m]==srch){
				System.out.println("found");
				return;
			}
					
		}
			
		
		
		
		myArray.getClass().getName();
		
		for (int zzz=0;zzz<=myArray.length; zzz++){
			myArray.getClass().getName();

				System.out.println(myArray[zzz] + " "+ myArray.getClass().getName());
			
		}
		
		
		int iiii;
		int nn=6;
		int sum=0;
		       
	        for (iiii = 1; iiii <= nn; iiii++) {
	            if (nn % iiii == 0){

	                sum = sum+iiii;
	            }
	        } 
	       	
		
		Dancer Sing1 = new Dancer();
		
		Sing1.Walk();
		Sing1.Sing();
		Sing1.Dance();
		Sing1.job.put("Teacher", "College");
		
	      Enumeration <String> els;
	      els = Sing1.job.keys();
	      
	      while(els.hasMoreElements()){
	    	 String  str = els.nextElement();
	    	 System.out.println(str + ": " + Sing1.job.get(str));
	      }
		
		System.out.println(Sing1.getClass().getSuperclass().getSuperclass().getName() + " " + Sing1.job.get("Teacher"));
		

		//HashTableDemo hd1 = new HashTableDemo();
		
		System.out.println(HashTableDemo.MyDemoName="ME");

		HashTableDemo.RunDemo();
		
	
		String addNumbers = "";
		
		
		for (int i=0;i<anInput1.length;i++ ) {
		      
		      for (int ii=0;ii<anInput2.length;ii++ ){
		        
		        if (anInput1[i]==anInput2[ii]){
		        	
		        if (addNumbers.contains(String.valueOf(anInput1[i]))==false){	
		        	addNumbers = addNumbers + anInput1[i] + ",";
		        	anInputResult[ii]=anInput1[i];
		        	ArrList.add(String.valueOf(anInput1[i]));
		        }
		        
		      }
		    } 
		    }
		
		    System.out.println(addNumbers);
		    System.out.println(ArrList.toString());
		    for (int yyy=0;yyy<ArrList.size();yyy++)
			    System.out.println(ArrList.get(yyy));

		
			String input_date="05"+"/"+"08"+"/"+"2015";
	        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
	        Date dt1 = format1.parse(input_date);
	        DateFormat format2=new SimpleDateFormat("EEEE"); 
	        String newDay=format2.format(dt1);
	        System.out.println(newDay.toUpperCase().trim());		

		        Scanner in = new Scanner(System.in);
		        System.out.print("Enter number t: ");
		        int t=in.nextInt();
		        for(int i=0;i<t;i++){
			        System.out.print("Enter number a: ");
		            int a = in.nextInt();
			        System.out.print("Enter number b: ");
		            int b = in.nextInt();
			        System.out.print("Enter number n: ");
		            int n = in.nextInt();
		            String ppp = String.valueOf(a+b);
		            double addnumber=a+Math.pow(2.0,0.0)*b;
		            
		            for (int c=1;c<n;c++){ 
		            	
		                addnumber= addnumber + Math.pow(2.0,c)*b;
		                ppp = ppp+ " " +String.valueOf((int)addnumber); 
		             
		            }
		        System.out.println (ppp);
		        }
		        in.close();
		        
		
		Scenario1 rs1 = new Scenario1();
		Scenario2 rs2 = new Scenario2();

		try {
			rs1.Run(Broswer);
			rs2.Run(Broswer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
