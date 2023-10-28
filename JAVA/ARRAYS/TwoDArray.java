package arrays;

public class TwoDArray {
	
	public static void main(String[] args) {
		int[][] twoDimArray = new int[3][3];
		for (int i = 0; i < twoDimArray.length; i++) {
		 for (int j = 0; j < twoDimArray[i].length; j++) {
		  twoDimArray[i][j] = j;
		  System.out.print(twoDimArray[i][j] + " ");
		 }
		 System.out.println("");
		}
	}

}
