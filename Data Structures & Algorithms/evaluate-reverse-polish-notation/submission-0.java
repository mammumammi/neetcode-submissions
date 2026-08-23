class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        for (String token:tokens){
            if (operators.contains(token)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if (token.equals("+"))
                    res = num1 + num2;
                else if (token.equals("-"))
                    res = num1 - num2;
                else if (token.equals("*"))
                    res = num1 * num2;
                else if (token.equals("/"))
                    res = num1 / num2;

                stack.push(res);
                
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
