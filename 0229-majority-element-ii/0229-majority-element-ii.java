class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int count1=0;
        int count2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=ele2){
                ele1=nums[i];
                count1=1;
            }
            else if(count2==0 && nums[i]!=ele1){
                ele2=nums[i];
                count2=1;
            }
            else if(ele1==nums[i]){
                count1++;
            }
            else if(ele2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
        }
        int n=(int)(nums.length/3);
        if(count1>n){
            list.add(ele1);
        }
        if(count2>n){
            list.add(ele2);
        }
        return list;
    }
}