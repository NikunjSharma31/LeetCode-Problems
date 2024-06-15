// 502. IPO
// Solved
// Hard
// Topics
// Companies
// Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

// You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

// Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

// Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

// The answer is guaranteed to fit in a 32-bit signed integer.

 

// Example 1:

// Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
// Output: 4
// Explanation: Since your initial capital is 0, you can only start the project indexed 0.
// After finishing it you will obtain profit 1 and your capital becomes 1.
// With capital 1, you can either start the project indexed 1 or the project indexed 2.
// Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
// Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
// Example 2:

// Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
// Output: 6
 

// Constraints:

// 1 <= k <= 105
// 0 <= w <= 109
// n == profits.length
// n == capital.length
// 1 <= n <= 105
// 0 <= profits[i] <= 104
// 0 <= capital[i] <= 109




class Solution {
  public static void main(String[] args){
    int k = 2 ; 
    int w = 0;
    int profits[] = {1,2,3};
    int capital[] = {0,1,1};
    System.out.println(findMaximizedCapital(k , w , profits , capital));
  }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         // minC will store pairs of (capital, profit) sorted by capital ascending
        PriorityQueue<int[]> minC = new PriorityQueue<>((a,b)-> a[0]-b[0]);
      // maxP will store profits sorted by profit descending
        PriorityQueue<Integer> maxP = new PriorityQueue<>((a,b) -> b-a);
        
        // Fill the minC priority queue with (capital, profit) pairs
        for(int i=0;i<capital.length;i++){
            minC.offer(new int[]{capital[i] , profits[i]});
        }
      
        // Execute the following k times
        while(k-- > 0){
           // Add all projects that have capital <= current available capital (w) to maxP
           
            while(!minC.isEmpty() && minC.peek()[0] <= w){
                maxP.add(minC.poll()[1]);
            }
          
            // If no projects can be added (maxP is empty), break the loop
            if(maxP.isEmpty()){
                break;
            } 
          
          // Select the project with the maximum profit from maxP and add its profit to current capital
            w += maxP.poll();
        }

        // Return the final available capital after executing k projects
        return w;
    }
}
