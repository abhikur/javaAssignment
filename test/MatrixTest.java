import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixTest {
	@Test
	public void populate() {
		Matrix matrix = new Matrix(2,2);
		int[] values = {2,3,3,2};
		matrix.populate(values);
		assertEquals(matrix.getValueAt(0,0),2);
		assertEquals(matrix.getValueAt(0,1),3);
		assertEquals(matrix.getValueAt(1,1),2);
	}

	@Test
	public void addMatrices() {
		Matrix matrix1 = new Matrix(2,2);
		Matrix matrix2 = new Matrix(2,2);
		Matrix expected = new Matrix(2,2);
		int[] values1 = {2,3,3,2};
		int[] values2 = {3,2,2,3};
		int[] values3 = {5,5,5,5};
		matrix1.populate(values1);
		matrix2.populate(values2);
		expected.populate(values3);
		Matrix resultant = matrix1.add(matrix2);
		assertEquals(resultant, expected);
	}

	@Test
	public void addUnequalMatrices() {
		Matrix matrix1 = new Matrix(2,3);
		Matrix matrix2 = new Matrix(2,2);
		Matrix expected = new Matrix(1,1);
		int[] values1 = {2,3,3,2,4,2};
		int[] values2 = {3,2,2,3};
		matrix1.populate(values1);
		matrix2.populate(values2);
		Matrix resultant = matrix1.add(matrix2);
		assertEquals(resultant, expected);
	}


	@Test
	public void multiplyMatrices() {
		Matrix matrix1 = new Matrix(2,3);
		Matrix matrix2 = new Matrix(3,2);
		Matrix expected = new Matrix(2,2);
		int[] values1 = {2,3,3,2,1,3};
		int[] values2 = {3,2,2,3,4,2};
		int[] values3 = {24,19,20,13};
		matrix1.populate(values1);
		matrix2.populate(values2);
		expected.populate(values3);
		Matrix result = matrix1.multiply(matrix2);
		assertEquals(result, expected);
	}

	@Test
	public void scalerMultiplication() {
		Matrix matrix1 = new Matrix(2,3);
		Matrix expected = new Matrix(2,3);
		int[] values1 = {2,3,3,2,1,3};
		int[] values3 = {12,18,18,12,6,18};
		matrix1.populate(values1);
		expected.populate(values3);
		Matrix result = matrix1.multiply(6);
		assertEquals(result, expected);
	}

	@Test
	public void multiplyMatricesWhenNotPosible() {
		Matrix matrix1 = new Matrix(2,2);
		Matrix matrix2 = new Matrix(3,2);
		Matrix expected = new Matrix(1,1);
		int[] values1 = {2,3,3,2};
		int[] values2 = {3,2,2,3,4,2};
		matrix1.populate(values1);
		matrix2.populate(values2);
		Matrix result = matrix1.multiply(matrix2);
		assertEquals(result, expected);
	}

	@Test
	public void subMatrixFromLeftMostElement() {
		Matrix matrix = new Matrix(3,3);
		Matrix expected = new Matrix(2,2);
		int[] values = {2,3,1,4,5,2,3,4,2};
		int[] values1 = {5,2,4,2};
		matrix.populate(values);
		expected.populate(values1);
		Matrix resultantMatrix = matrix.subMatrix(0);
		assertEquals(resultantMatrix.getValueAt(0,0),5);
		assertEquals(resultantMatrix.getValueAt(1,1),2);
	}

	@Test
	public void subMatrixFromMiddleElement() {
		Matrix matrix = new Matrix(3,3);
		Matrix expected = new Matrix(2,2);
		int[] values = {2,3,1,4,5,2,3,4,2};
		int[] values1 = {4,2,3,2};
		matrix.populate(values);
		expected.populate(values1);
		Matrix resultantMatrix = matrix.subMatrix(1);
		assertEquals(resultantMatrix.getValueAt(0,0),4);
		assertEquals(resultantMatrix.getValueAt(1,1),2);
	}

	@Test
	public void subMatrixFromRightMostElement() {
		Matrix matrix = new Matrix(3,3);
		Matrix expected = new Matrix(2,2);
		int[] values = {2,3,1,4,5,2,3,4,2};
		int[] values1 = {4,5,3,4};
		matrix.populate(values);
		expected.populate(values1);
		Matrix resultantMatrix = matrix.subMatrix(2);
		assertEquals(resultantMatrix.getValueAt(0,0),4);
		assertEquals(resultantMatrix.getValueAt(1,1),4);
	}

	@Test
	public void subMatrixOfOrder1() {
		Matrix matrix = new Matrix(2,2);
		Matrix expected = new Matrix(1,1);
		int[] values = {2,3,1,4};
		int[] values1 = {4};
		matrix.populate(values);
		expected.populate(values1);
		Matrix resultantMatrix = matrix.subMatrix(0);
		assertEquals(resultantMatrix.getValueAt(0,0),4);
	}

	@Test
	public void determinantOfMatrix() {
		Matrix matrix = new Matrix(2,2);
		int[] values = {2,4,3,2};
		matrix.populate(values);
		int result = matrix.determinant();
		assertEquals(result, -8);
	}

	@Test
	public void determinantOfMatrixOfOrder3() {
		Matrix matrix = new Matrix(3,3);
		int[] values = {2,4,3,2,4,1,2,3,2};
		matrix.populate(values);
		int result = matrix.determinant();
		assertEquals(result, -4);
	}

	@Test
	public void determinantOfMatrixOfOrder() {
		Matrix matrix = new Matrix(3,3);
		int[] values = {2,1,4,3,2,4,3,2,5};
		matrix.populate(values);
		int result = matrix.determinant();
		assertEquals(result, 1);
	}

	@Test
	public void determinantOfMatrixOfOrder4() {
		Matrix matrix = new Matrix(4,4);
		int[] values = {2,3,2,3,3,2,1,4,5,3,2,4,1,3,2,5};
		matrix.populate(values);
		int result = matrix.determinant();
		assertEquals(result, -7);
	}

	@Test
	public void determinantOfMatrixOfOrder5() {
		Matrix matrix = new Matrix(5,5);
		int[] values = {2,3,2,3,3,2,1,4,5,3,2,4,1,3,2,5,3,3,4,1,2,3,4,5,3};
		matrix.populate(values);
		int result = matrix.determinant();
		assertEquals(result, 64);
	}

	@Test
	public void determinantOfMatrixOfOrder8() {
		Matrix matrix = new Matrix(8,8);
		int[] values = {2,3,2,3,3,2,1,4,5,3,2,4,1,3,2,5,3,3,4,1,2,3,4,5,3,6,7,8,6,5,4,3,2,3,4,5,6,7,2,8,9,2,3,4,5,6,9,2,5,6,4,8,7,6,4,6,4,8,9,4,3,6,7,9};
		matrix.populate(values);
		int result = matrix.determinant();
		assertEquals(result, -2080);
	}
}