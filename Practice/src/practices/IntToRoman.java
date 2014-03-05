package practices;

public class IntToRoman {

	public String intToRoman(int num) {
		StringBuffer sb = new StringBuffer();
		String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
		for(int i=0;num!=0;++i){
			while(num>=value[i]){
				num-=value[i];
				sb.append(symbol[i]);
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToRoman testIntToRoman = new IntToRoman();
		System.out.println(testIntToRoman.intToRoman(3999));
	}

}

