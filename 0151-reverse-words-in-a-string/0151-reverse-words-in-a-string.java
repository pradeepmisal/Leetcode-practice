class Solution {
    public String reverseWords(String s) {
        s = s.trim();// 
        Stack<String> stack = new Stack<>();
    
        StringBuilder word = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != ' '){
                word.append(c);
            }
            else if( word.length() > 0){
                stack.push(word.toString());
                word.setLength(0);
            }
        }
        
            stack.push(word.toString());
             StringBuilder result = new StringBuilder();
            while(!stack.isEmpty()){
                result.append(stack.pop());
                if(!stack.isEmpty()){
                    result.append(" ");
                }
            }
             return result.toString();
        }
    }
