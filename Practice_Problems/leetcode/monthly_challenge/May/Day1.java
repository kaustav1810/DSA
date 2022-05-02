// link: https://leetcode.com/problems/backspace-string-compare/submissions/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c=='#'){
                if(st1.isEmpty()) continue;
                
                else st1.pop();
                
            }
            
            else st1.push(c);
        }
        
        
        for(char c:t.toCharArray()){
            if(c=='#'){
                if(st2.isEmpty()) continue;
                
                else st2.pop();
            } 
            
            else st2.push(c);
        }
        
        String a = "",b = "";
        
        while(!st1.isEmpty()) a += st1.pop();
        
        while(!st2.isEmpty()) b += st2.pop();
        
        return a.equals(b)?true:false;
    }
}
