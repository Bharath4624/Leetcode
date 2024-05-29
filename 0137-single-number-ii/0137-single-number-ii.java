class Solution {
    public int singleNumber(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=1;i<n;i+=3){
            if(arr[i-1]!=arr[i]){
                return arr[i-1];
            }
        }
        return arr[n-1];
    }
}