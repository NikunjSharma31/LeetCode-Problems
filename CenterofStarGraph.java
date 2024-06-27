// 1791. Find Center of Star Graph
// Solved
// Easy
// Topics
// Companies
// Hint
// There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

// You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 

// Example 1:


// Input: edges = [[1,2],[2,3],[4,2]]
// Output: 2
// Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
// Example 2:

// Input: edges = [[1,2],[5,1],[1,3],[1,4]]
// Output: 1
 

// Constraints:

// 3 <= n <= 105
// edges.length == n - 1
// edges[i].length == 2
// 1 <= ui, vi <= n
// ui != vi
// The given edges represent a valid star graph.


// MIne Solution ::::: 22 ms 

class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        for(int i = 0 ;i<edges.length;i++){
            for(int j = 0;j<edges[0].length;j++){
               map.put(edges[i][j] , map.getOrDefault(edges[i][j] , 0) +1);
            }
        }
        int min = Integer.MIN_VALUE;
        for(HashMap.Entry<Integer , Integer> entry : map.entrySet()){
            if(entry.getValue() > min){
                min = entry.getKey();
            }
        }
        return min;
        
    }
}


// 0 ms solution : 

class Solution {
    public int findCenter(int[][] edges) {
     
        HashSet<Integer> set = new HashSet<>();
        for(int edge[] : edges){
            if(set.contains(edge[0])) return edge[0];
            else if(set.contains(edge[1])) return edge[1];
            set.add(edge[0]);
            set.add(edge[1]);
        }
        return -1;
    }
}
  
