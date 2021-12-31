/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatlearning.driver;
import java.util.Scanner;

import com.greatlearning.service.BinarySearch;
import com.greatlearning.service.MergeSort;

/**
 *
 * @author asus
 */
public class Driver {
    
    public static void display(double arr[], int n) 
		{
			for(int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}
		
		public static int getShareStatusCount(boolean arr[], int n, boolean toCompare) 
		{
			int count = 0;
			for(int i = 0; i < n; i++) 
				if(arr[i] == toCompare)	
					count++;
				
			return count;
		}
		
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the no of companies");
			int companies = sc.nextInt();
			
			double sharePrices[] = new double[companies];
			boolean shareStatus[] = new boolean[companies];
			
			
			for(int i = 0; i < companies; i++) 
			{
				System.out.println("Enter current stock price of company " + (i + 1));
				sharePrices[i] = sc.nextDouble();
				
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				shareStatus[i] = sc.nextBoolean();
			}
			
			int choice = -1;
			MergeSort mObj = new MergeSort(sharePrices, companies);
			
			do 
			{
				System.out.println("\n-----------------------------------------------\n "
                                                                        +"Enter the operation that you want to perform\n1. "
									+ "Display the companies stock prices in ascending order\n2. "
									+ "Display the companies stock prices in descending order\n3. "
									+ "Display the total no of companies for which stock prices rose today\n4. "
									+ "Display the total no of companies for which stock prices declined today\n5."
									+ " Search a specific stock price\n6. press 0 to exit\n-----------------------------------------------");
				choice = sc.nextInt();
				
				switch(choice) 
				{
					case 0: System.out.println("Exited Successfully");
							break;
							
					case 1: mObj.startMerge(0, companies - 1, 'A');
							double ascending[] = mObj.sorted();
							System.out.println("Stock prices in ascending order are :");
							display(ascending, companies);
							break;
							
					case 2: mObj.startMerge(0, companies - 1, 'D');
							double descending[] = mObj.sorted();
							System.out.println("Stock prices in descending order are :");
							display(descending, companies);
							break;
							
					case 3: System.out.println("Total no of companies whose stock price rose today : " + getShareStatusCount(shareStatus, companies, true));
							break;
							
					case 4: System.out.println("Total no of companies whose stock price declined today : " + getShareStatusCount(shareStatus, companies, false));
							break;
							
					case 5: System.out.println("Enter the key value");
							double value = sc.nextDouble();
							
							mObj.startMerge(0, companies - 1, 'A');
							double ascendingShares[] = mObj.sorted();
							
							BinarySearch bObj = new BinarySearch(ascendingShares, companies);
												
							boolean flag = bObj.isFound(value);
							if (flag == true)
								System.out.println("Stock of value " + value + " is present");
							else
								System.out.println("Stock of value " + value + " is not present");
							break;
							
					default:System.out.println("Invalid Choice! Re-enter");
							break;
				}
				
			} while (choice != 0);
			
			sc.close();
		}
    
}
