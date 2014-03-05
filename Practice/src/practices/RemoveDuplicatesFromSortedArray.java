package practices;

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] A) {
        int n=A.length;
        if(n==0 || n==1) 
        		return n;
        int i=0, j=1;
        while(j<n){
            while(j<n && A[i]==A[j]){
                j++;
            }
            i++;
            if(i==j) {
                j++;
            }else{
                int steps=j-i;
                for(int r=j; r<n; ++r){
                    A[r-steps] = A[r];
                }
                j=i+1;
            }
            
        }
        
        for (int p = 0; p < A.length-1; p++) {
			if (A[p]>=A[p+1]) {
				return p+1;
			}
		}
        return A.length;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
		int[] A = {0,0,0,0,0,1,2,2,3,3,4,4};
		System.out.println(test.removeDuplicates(A));
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]+" ");
		}
		
	}

}
