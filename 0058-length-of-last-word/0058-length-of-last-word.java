class Solution {
    public int lengthOfLastWord(String s) {
        String arr[]=s.split("\\s");
        String ch=arr[arr.length-1];
        int count=ch.length();
        return count;
    }
}