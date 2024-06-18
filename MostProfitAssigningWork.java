class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0;i<profit.length;i++){
            map.put(difficulty[i] , profit[i]);
        }
        int ans = 0;
        for(int w : worker){
            for(int key : map.keySet()){
                if(key <= w){
                    ans += map.get(key);
                }
                break;
            }
        }
        return ans;
        // PriorityQueue<int[]> minC = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // PriorityQueue<Integer> minW = new PriorityQueue<>();
        // for(int i = 0 ;i< profit.length;i++){
        //     minC.offer(new int[] {difficulty[i], profit[i]});
        // }
        // for(int i = 0;i< worker.length;i++){
        //     minW.offer(worker[i]);
        // }
        // int ans = 0;
        // while(!minW.isEmpty()){
        //     int curr = minW.poll();
        //     if(minC.peek()[0] <= curr){
        //         ans += minC.peek()[1];
        //     }
        // }
        // return ans;

        //  List<int[]> jobs = new ArrayList<>();
        // int n = difficulty.length;
        // for (int i = 0; i < n; i++) {
        //     jobs.add(new int[]{difficulty[i], profit[i]});
        // }
        
        // // Sort jobs based on difficulty
        // Collections.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // // Sort workers based on ability
        // Arrays.sort(worker);
        
        // int totalProfit = 0;
        // int maxProfit = 0;
        // int jobIndex = 0;
        
        // // Iterate through each worker
        // for (int ability : worker) {
        //     // Find the maximum profit job this worker can handle
        //     while (jobIndex < n && jobs.get(jobIndex)[0] <= ability) {
        //         maxProfit = Math.max(maxProfit, jobs.get(jobIndex)[1]);
        //         jobIndex++;
        //     }
        //     totalProfit += maxProfit;
        // }
        
        // return totalProfit;
    }
}
