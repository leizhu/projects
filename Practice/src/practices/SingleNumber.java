package practices;
/*
 * *
 * Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class SingleNumber {
	public int singleNumber(int A[], int n) {
	    // IMPORTANT: Please reset any member data you declared, as
	    // the same Solution instance will be reused for each test case.
	    while (--n!=0) A[n-1]^=A[n];
	    return A[0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
