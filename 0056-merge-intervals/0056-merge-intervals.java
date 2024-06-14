class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> merged=new ArrayList<>();
        int[] curr=intervals[0];
        merged.add(intervals[0]);
        for(int i=0;i<intervals.length;i++){
            int currend=curr[1];
            int begin=intervals[i][0];
            int end=intervals[i][1];
            if(currend>=begin){
                curr[1]=Math.max(end,currend);
            }
            else{
                curr=intervals[i];
                merged.add(curr);
            }
        }
        int[][] ans=new int[merged.size()][2];
        for(int i=0;i<merged.size();i++){
            ans[i]=merged.get(i);
        }
        return ans;
    }
}