class pair{
    String string;
    int steps;
    pair(String string,int steps){
        this.string=string;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> queue=new LinkedList<>();
        Set<String> set=new HashSet<>(wordList);
        queue.offer(new pair(beginWord,1));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            pair p=queue.poll();
            String word=p.string;
            int steps=p.steps;
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                char[] arr=word.toCharArray();
                for(char j='a';j<='z';j++){
                    arr[i]=j;
                    String s=new String(arr);
                    if(set.contains(s)){
                        set.remove(s);
                        queue.add(new pair(s,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}