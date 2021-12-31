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
public class MergeSort {
    
    private double arr[];
		private int n;
		
		public MergeSort() 
		{
			arr = new double[0];
			n = 0;
		}
		
		public MergeSort(double arr[], int n) 
		{
			this.arr = arr;
			this.n = n;
		}
		
		private void mergeDescending(int start, int mid, int end) 
		{
			int i = start, j = mid + 1, index = start;
			double temp[] = new double[n];
			
			while(i <= mid && j <= end) 
			{
				if(arr[i] > arr[j])
					temp[index] = arr[i++];
				else
					temp[index] = arr[j++];
				index++;
			}
			
			if(i > mid) 
				while(j <= end)
					temp[index++] = arr[j++];
			else
				while (i <= mid)
					temp[index++] = arr[i++];
			
			for(int k = start; k < index; k++)
				arr[k] = temp[k];
		}

		private void mergeAscending(int start, int mid, int end) 
		{
			int i = start, j = mid + 1, index = start;
			double temp[] = new double[n];
			
			while(i <= mid && j <= end) 
			{
				if(arr[i] < arr[j])
					temp[index] = arr[i++];
				else
					temp[index] = arr[j++];
				index++;
			}
			
			if(i > mid) 
				while(j <= end)
					temp[index++] = arr[j++];
			else
				while (i <= mid)
					temp[index++] = arr[i++];
			
			for(int k = start; k < index; k++)
				arr[k] = temp[k];
		}
		
		public void startMerge(int start, int end, char order) 
		{
			if(start < end) 
			{			
				int mid = start + (end - start) / 2;
				startMerge(start, mid, order);
				startMerge(mid + 1, end, order);
				if(order == 'A')
					mergeAscending(start, mid, end);
				else 
					mergeDescending(start, mid, end);
			}
		}
		
		public double[] sorted() 
		{
			return arr;
		}
    
}
