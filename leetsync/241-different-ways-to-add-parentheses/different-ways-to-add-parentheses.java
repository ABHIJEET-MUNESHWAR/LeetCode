class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    public List<Integer> solve(String s){
        List<Integer> results = new ArrayList<>();        
        int expressionLength = s.length();
        for(int i=0;i<expressionLength; i++){
            char ch = s.charAt(i);
            // If the current character is an operator
            if(ch == '+' || ch == '-' || ch == '*'){
                // Recursively solve left and right substrings
                List<Integer> leftResults = solve(s.substring(0, i));
                List<Integer> rightResults = solve(s.substring(i+1));
                // Combine the results from left and right parts
                for(int x:leftResults){
                    for(int y: rightResults){
                        if(ch=='+'){
                            results.add(x+y);
                        } else if(ch=='-'){
                            results.add(x-y);
                        } else{
                            results.add(x*y);
                        }
                    }
                }
            }
        }
        // If no operator is found, it means the string is a number
        if(results.isEmpty()){
            results.add(Integer.parseInt(s));
        }
        return results;
    }
}