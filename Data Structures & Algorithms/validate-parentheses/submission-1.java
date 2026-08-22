class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if (stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            System.out.println(stack.peek());
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
                continue;
            }

            char last = stack.peek();
            if (ch == ')'){
                if (last != '(') return false;
                stack.pop();
            }
            else if (ch == '}'){
                if (last != '{') return false;
                stack.pop();
            }
            else if (ch == ']'){
                if (last != '[') return false;
                stack.pop();
            }
            

            
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
