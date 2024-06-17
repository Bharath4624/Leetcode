class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low=0;
        int high=mat[0].length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int max=max(mat,mid);
            int left=mid-1>=0?mat[max][mid-1]:-1;
            int right=mid+1<mat[0].length?mat[max][mid+1]:-1;
            if(mat[max][mid]> left && mat[max][mid]>right){
                return new int[]{max,mid};
            }
            else if(mat[max][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int max(int[][] mat,int mid){
        int max=-1;
        int index=-1;
        for(int i=0;i<mat.length;i++){
            if(max<mat[i][mid]){
                max=mat[i][mid];
                index=i;
            }
        }
        return index;
    }
}