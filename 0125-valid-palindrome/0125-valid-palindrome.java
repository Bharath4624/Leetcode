class Solution {
     public boolean isPalindrome(String s) {
        StringBuilder stringBuilder= new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
               stringBuilder.append(ch);
            }
        }
        if((stringBuilder.toString().toLowerCase()).equals(stringBuilder.reverse().toString().toLowerCase())){
            return true;
        }
        return false;

    }
}