/*

Sort a nearly sorted (or K sorted) array

Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

Examples:

Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
            k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
         k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
*/

import java.util.Iterator; 
import java.util.PriorityQueue; 
  
class kSortArray { 
    private static void kSort(int[] arr, int n, int k) { 
  
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 
   
        for(int i = 0; i < k + 1; i++) { 
            priorityQueue.add(arr[i]); 
        } 
  
        int index = 0; 
        for(int i = k + 1; i < n; i++) { 
            arr[index++] = priorityQueue.peek(); 
            priorityQueue.poll(); 
            priorityQueue.add(arr[i]); 
        } 
  
        Iterator<Integer> itr = priorityQueue.iterator(); 
  
        while(itr.hasNext()) { 
            arr[index++] = priorityQueue.peek(); 
            priorityQueue.poll(); 
        } 
  
    } 
  
    private static void printArray(int[] arr, int n) { 
        for(int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    public static void main(String[] args) { 
        int k = 3; 
        int arr[] = { 2, 6, 3, 12, 56, 8 }; 
        int n = arr.length; 
        kSort(arr, n, k); 
        System.out.println("Following is sorted array :"); 
        printArray(arr, n); 
    } 
} 