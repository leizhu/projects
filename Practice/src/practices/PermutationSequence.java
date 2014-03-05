package practices;

/*
 * 
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
1. 找没用过的里面的第(k – 1) / (n – 1)!个数字，放第一位上
2. k = (k – 1) % (n – 1)!，第一个数字确定了，剩下这些里面重新找第k个。
3. n每次-1，比如第一位确定后有(n-1)!种后面数字的排法，第二位也确定了后面的数字排法就又少了一位(n – 1 – 1)!
 */
public class PermutationSequence {

	public String getPermutation(int n, int k) {
	    boolean[] used = new boolean[n];
	    // used[i] means the digit i + 1 is used, e.g. used[0] means digit '1' is used
	    StringBuilder sb = new StringBuilder();
	    int factorial = getFactorial(n - 1);
	    int originalN = n;
	    while (k > 0) {
	        int index = (k - 1) / factorial;
	        int count = 0;
	        for (int i = 0; i < originalN; i++) {
	            if (used[i] == false)
	                count++;
	            if (index == count - 1) {
	                sb.append(i + 1);
	                used[i] = true;
	                break;
	            }
	        }
	        n--;
	        k = (k - 1) % factorial + 1;
	        if (n == 0)
	            break;
	        factorial /= n;
	    }
	    return sb.toString();
	}
	private int getFactorial(int n) {
	    if (n == 1 || n == 0)
	        return 1;
	    return n * getFactorial(n - 1);
	}
	


	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(4, 7));
	}

}
