class Solution {
    public int[] rearrangeArray(int[] a) {
        int[] ans=new int[a.length];
        int p=0;
        int n=1;
        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                ans[n]=a[i];
                n+=2;
            }
            else{
                ans[p]=a[i];
                p+=2;
            }
        }
        return ans;
    }
}