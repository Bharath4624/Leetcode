class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if((s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U') && (s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' || s.charAt(j)=='o' || s.charAt(j)=='u' || s.charAt(j)=='A' || s.charAt(j)=='E' || s.charAt(j)=='I' || s.charAt(j)=='O' || s.charAt(j)=='U')){
                char ch=s.charAt(i);
                sb.setCharAt(i,s.charAt(j));
                sb.setCharAt(j,ch);
                i++;
                j--;
            }
            else if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U'){
                j--;
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }
}