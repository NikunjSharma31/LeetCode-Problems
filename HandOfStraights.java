package ProblemsLeetCode;

import java.util.PriorityQueue;

// 846. Hand of Straights Solved Medium Topics Companies Alice has some number of cards and she wants to rearrange the cards 
// into groups so that each group is of size groupSize,and consists of groupSize consecutive cards.

// Given an integer array hand where hand[i]is the value written on the ith card and an integer groupSize,return true if she can
// rearrange the cards,or false otherwise.

// Example 1:

// Input:hand=[1,2,3,6,2,3,4,7,8],groupSize=3 Output:true Explanation:Alice'shand can be rearranged as[1,2,3],[2,3,4],[6,7,8]

// Example 2:

// Input:hand=[1,2,3,4,5],groupSize=4 Output:false Explanation:Alice'shand can not be rearranged into groups of 4.

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
        
    }
    public static boolean isNStraightHand(int hand[] , int groupSize){
        // if(hand.length % groupSize != 0){
        //     return false;
        // }
        // int n = hand.length;
        // int[] freq = new int[n];
        // for(int i = 0; i < n; i++){
        //     freq[hand[i]]++;
        // }
        // for(int i = 0; i < n; i++){
        //     if(freq[i] > 0){
        //         for(int j = groupSize - 1; j >= 0; j--){
        //             if(freq[i+j] < freq[i]){
        //                 return false;
        //             }
        //             freq[i+j] -= freq[i];
        //         }
        //     }
        // }
        // return true;
         int n = hand.length;
        if(n % groupSize != 0 ) return false;
        if(groupSize == 1) return true;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : hand){
            pq.add(num);
        }
        while(!pq.isEmpty()){
            int min = pq.poll();
            for(int i = 1; i<groupSize;i++){
                if(pq.remove(min+i)) continue;
                else return false;
            }
        }
        return true;
    }
}
