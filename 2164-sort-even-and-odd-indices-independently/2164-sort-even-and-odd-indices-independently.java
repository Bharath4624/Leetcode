class Solution {
    public int[] sortEvenOdd(int[] arr) {
        PriorityQueue<Integer> odd=new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> even=new PriorityQueue<>((a,b)->(a-b));
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                even.offer(arr[i]);
            }
            else{
                odd.offer(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                arr[i]=even.poll();
            }
            else{
                arr[i]=odd.poll();
            }
        }
        return arr;
    }
}