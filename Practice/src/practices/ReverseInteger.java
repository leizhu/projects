package practices;


/*
Example1: x = 123, return 321
Example2: x = -123, return -321
 * 
 * */

public class ReverseInteger {
	private int multiply(int n){
        int value = 1;
        for(int i=0; i<n ; ++i){
            value *= 10;
        }
        return value;
    }
    
    public int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        int flag = 1;
        if (x<0){
        		flag = -1;
        		x = -x;
        }
        
        while(x/10 > 0){
            int mod = x % 10;
            sb.append(mod);
            x /= 10;
        }
        sb.append(x);
        String reversedString = sb.toString();
        int len = reversedString.length();
        int ret = 0;
        for(int i=0; i<len; i++){
            ret += (reversedString.charAt(i)-'0')*multiply(len-i-1);
        }
        
        return ret*flag;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(-123));
	}

}
