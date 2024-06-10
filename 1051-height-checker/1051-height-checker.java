class Solution {
    public int heightChecker(int[] heights) {
        int[] ans=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            ans[i]=heights[i];
        }
        int count=0;
        Arrays.sort(heights);
        for(int i=0;i<heights.length;i++){
            if(ans[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
}