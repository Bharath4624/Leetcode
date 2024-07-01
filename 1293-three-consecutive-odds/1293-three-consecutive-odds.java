class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int i=0;
        int j=i+1;
        int k=j+1;
        while(k<arr.length){
            if(arr[i]%2==1 && arr[j]%2==1 && arr[k]%2==1){
                return true;
            }
            i++;
            j++;
            k++;
        }
        return false;
    }
}