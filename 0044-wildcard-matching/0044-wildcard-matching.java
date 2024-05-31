class Solution {
    public boolean isMatch(String s, String p) {
        char[] str=s.toCharArray();
        char[] pattern=p.toCharArray();
        int index=0;
        boolean flag=true;
        for(int i=0;i<pattern.length;i++){
            if(pattern[i]=='*'){
                if(flag){
                    pattern[index++]=pattern[i];
                    flag=false;
                }
            }
            else{
                pattern[index++]=pattern[i];
                flag=true;
            }
        }
        boolean dp[][]=new boolean[str.length+1][index+1];
        dp[0][0]=true;
        if(index>0 && pattern[0]=='*'){
            dp[0][1]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(pattern[j-1]==str[i-1] || pattern[j-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pattern[j-1]=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[str.length][index];
    }
}