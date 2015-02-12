package string;

import java.util.HashSet;

public class RowAndColumn {
	public static void setZero(int[][] matrix) {
		HashSet<Integer> hsrow = new HashSet<Integer>();
		HashSet<Integer> hscolumn = new HashSet<Integer>();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					hsrow.add(i);
					hscolumn.add(j);
				}
			}
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; i++) {
				if(hsrow.contains(i) || hscolumn.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}