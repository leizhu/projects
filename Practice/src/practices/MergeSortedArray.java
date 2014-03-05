package practices;

/*
 Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively. 
 * */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int a=m-1, b=n-1, c=m+n-1;
        while (a>=0 && b>=0) {
			if(A[a] > B[b]){
				A[c--] = A[a--];
				
			}else {
				A[c--] = B[b--];
			}
		}
        if (a>=0){
        		for (int i = a; i >=0; i--) {
				A[i] = A[i];
			}
        }
        if (b>=0) {
        		for (int i = b; i >=0; i--) {
				A[i] = B[i];
			}
		}
    }
}
