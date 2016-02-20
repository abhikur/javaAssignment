import java.util.Arrays;
class Matrix {
	private int rows;
	private int column;
	private int[][] elements;

	Matrix (int rows, int column) {
		this.rows = rows;
		this.column = column;
		this.elements = new int[rows][column];
	}

	public void populate(int[] values) {
		int counter = 0;
		for (int i=0; i<this.rows; i++) {
			for (int j=0; j<this.column; j++) {
				this.elements[i][j] = values[counter++];
			}
		}
	}

	public int getValueAt(int row, int column){
		return this.elements[row][column];
	}

	public Matrix add(Matrix matrixToAdd) {
		if(this.rows == matrixToAdd.rows && this.column == matrixToAdd.column){
			Matrix result = new Matrix(this.rows, this.column);
			for (int i=0; i<this.rows; i++) {
				for (int j=0; j<this.column; j++) {
					result.elements[i][j] = this.elements[i][j] + matrixToAdd.elements[i][j];
				}
			}
			return result;
		}
		return new Matrix(1,1); 
	}

	public boolean equals(Object matrix) {
		if(matrix instanceof Matrix) return true;
		Matrix otherMatrix = (Matrix) matrix;
		if(this == otherMatrix) return true;
		return Arrays.deepEquals(this.elements, otherMatrix.elements);
	}

	public Matrix multiply(int num) {
		Matrix result = new Matrix(this.rows, this.column);
		for (int i=0; i<this.rows; i++) {
			for (int j=0; j<this.column; j++) {
				result.elements[i][j] = this.elements[i][j]*num;
			}
		}
		return result;
	}

	public Matrix multiply(Matrix matrixToMultiply) {
		if(this.column == matrixToMultiply.rows){
			Matrix result = new Matrix(this.rows, matrixToMultiply.column);
			for (int i=0; i<this.elements.length; i++) {
				for(int k=0; k<matrixToMultiply.elements[0].length; k++){
					int sum=0;
					for (int j=0; j<this.elements[0].length; j++)
						sum += this.elements[i][j]*matrixToMultiply.elements[j][k];
					result.elements[i][k] = sum;
				}
			}
			return result;
		}
		return new Matrix(1,1);
	}

	public Matrix subMatrix(int parent_j) {
		Matrix result = new Matrix(this.rows-1,this.column-1);
		int m=0;
		for (int i=1; i<this.rows; i++) {
			int n=0;
			for (int j=0; j<this.column; j++) {
				if(j != parent_j){
					result.elements[m][n] = this.elements[i][j];
					n++;
				}
			}
			m++;
		}
		return result;
	}

	public int determinant() {
		int result = 0;
		for(int i=0; i<this.rows; i++){
			if(this.rows < 2)
				return this.elements[0][0];
			if(i%2 == 0)
				result = result+(this.elements[0][i] * this.subMatrix(i).determinant());
			else
				result = result-(this.elements[0][i] * this.subMatrix(i).determinant());
		}
		return result;
	}

}