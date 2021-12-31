/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatlearning.service;

/**
 *
 * @author asus
 */
public class BinarySearch {
    
    private double arr[];
		private int size;
		
		public BinarySearch() 
		{
			arr = new double[0];
			size = 0;
		}
		
		public BinarySearch(double arr[], int size) 
		{
			this.arr = arr;
			this.size = size;
		}
		
		private int find(int beg, int end, double value) 
		{
			if (end >= beg) {
	            int mid = beg + (end - beg) / 2;

	            if (arr[mid] == value)
	                return mid;
	            if (arr[mid] > value)
	                return find(beg, mid - 1, value);

	            return find(mid + 1, end, value);

	        }
	        return -1;
		}
		
		public boolean isFound(double value) 
		{
			int status = find(0, size - 1, value);
			return status == -1 ? false : true;
		}
    
}
