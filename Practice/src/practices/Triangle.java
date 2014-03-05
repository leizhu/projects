package practices;

import java.util.ArrayList;

/*
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * */
public class Triangle {
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Integer[] array = triangle.get(triangle.size()-1).toArray(new Integer[0]);
        for (int i=triangle.size()-2; i>=0; i--) {
            ArrayList<Integer> row = triangle.get(i);
            for (int j=0; j<row.size(); j++) {
                array[j] = row.get(j) + Math.min(array[j], array[j+1]);
            }
        }
        return array[0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[-1],[2,3],[1,-1,-3]]
		Triangle test = new Triangle();
		ArrayList<ArrayList<Integer>> triangleList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(-1);
		triangleList.add(l1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		triangleList.add(l2);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		triangleList.add(l3);
		System.out.print(test.minimumTotal(triangleList));
	}

}
