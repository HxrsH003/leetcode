/*
Problem statement
You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.
Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.

Note:
You are allowed to break the items.
Example:
If 'N = 4' and 'W = 10'. The weights and values of items are weights = [6, 1, 5, 3] and values = [3, 6, 1, 4]. 
Then the best way to fill the knapsack is to choose items with weight 6, 1 and  3. The total value of knapsack = 3 + 6 + 4 = 13.00 
*/


import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (a,b)-> Double.compare((double)b.value/b.weight , (double)a.value/a.weight));
		double totValue = 0;
		for(int i =0;i<n;i++){
			if(items[i].weight<= w){
				totValue += items[i].value;
				w = w- items[i].weight;
			}
			else{
				totValue += ((double)items[i].value/items[i].weight)*w;
				break;
			}
		}
		return totValue;
    }
}
