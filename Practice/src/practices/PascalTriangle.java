package practices;

import java.util.ArrayList;

public class PascalTriangle {
	
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ptArrayList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<numRows; ++i){
            ArrayList<Integer> pArray = new ArrayList<Integer>();
            if(i==0){
                pArray.add(1);
            }else{
                ArrayList<Integer> lastRowArray = ptArrayList.get(i-1);
                pArray.add(0+lastRowArray.get(0));
                for(int j=0; j<lastRowArray.size()-1; ++j){
                		pArray.add(lastRowArray.get(j)+lastRowArray.get(j+1));
                }
                pArray.add(0+lastRowArray.get(lastRowArray.size()-1));
            }
            ptArrayList.add(pArray);
        }
        return ptArrayList;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle pt = new PascalTriangle();
		ArrayList<ArrayList<Integer>> ptArrayList = pt.generate(2);
		for(int i=0; i<ptArrayList.size(); ++i){
			ArrayList<Integer> rowArray = ptArrayList.get(i);
			System.out.println(rowArray.toString());
		}
	}

}
