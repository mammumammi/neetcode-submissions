class Solution {
    public int reverse(int x) {
        

        
        String str = String.valueOf(x);
        char[] array = str.toCharArray();
        String res = "";
        boolean negative = false;
        
        for (int i = array.length - 1;i>=0;i--){
            if (i == 0 && array[i]== '-'){
                negative = true;
                break;
            }
            res += array[i];
            
        }
        System.out.print(res);
        try{

       
        int result = Integer.parseInt(new String(res));
        if (negative){
            result = 0 - result;
        }
        // if (result > 999999999) return 0;
        return result;

         }
         catch(Exception e){ return 0;}
        }
        
    
}
