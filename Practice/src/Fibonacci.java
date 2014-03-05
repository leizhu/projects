
public class Fibonacci {

	void printF(int n){
		if (n<=0) return;
		if (n==1) {
			System.out.println(n);
			return;
		}
		if (n==2) {
			System.out.println(n-1);System.out.println(n);
			return;
		}
		int a=1,b=2,i=0;
		while(i<n){
			System.out.println(a);
			int c = b;
			b = a + b;
			a = c;
			i++;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fibonacci().printF(4);
	}

}
