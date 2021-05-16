package tests;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

import math.Matrix;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MatrixTest{
	
	Matrix matrix1;
	Matrix matrix2;
	Matrix expected;
	
	@Test
	@DisplayName("Adding two matrises")
	void addTest(){
		matrix1 = new Matrix(new double[][]
		{{1,3,1}
		,{1,0,0}});
		
		matrix2 = new Matrix(new double[][]
		{{0,0,5}
		,{7,5,0}});
		
		expected = new Matrix(new double[][]
		{{1,3,6}
		,{8,5,0}});
		
		assertEquals(expected, matrix1.add(matrix2), "Incorrect sum");
	}
	
	@Test
	@DisplayName("Subtracting two matrises")
	void subtractTest(){
		matrix1 = new Matrix(new double[][]
		{{2,3,1}
		,{5,4,7}});
		
		matrix2 = new Matrix(new double[][]
		{{1,1,1}
		,{2,2,2}});
		
		expected = new Matrix(new double[][]
		{{1,2,0}
		,{3,2,5}});
		
		assertEquals(expected, matrix1.subtract(matrix2), "Incorrect difference");
	}
	
	@Test
	@DisplayName("Multiplying matrix by positive scalar")
	void multiplyScalarPositiveTest(){
		matrix1 = new Matrix(new double[][]
		{{1, 8,-3}
		,{4,-2, 5}});
		
		expected = new Matrix(new double[][]
		{{ 2,16,-6}
		,{ 8,-4,10}});
		
		assertEquals(expected,matrix1.multiply(2), "Incorrect product with positive value");
	}
	
	@Test
	@DisplayName("Multiplying matrix by negative scalar")
	void multiplyScalarNegativeTest(){
		matrix1 = new Matrix(new double[][]
		{{1, 8,-3}
		,{4,-2, 5}});
		
		expected = new Matrix(new double[][]
		{{-1,-8, 3}
		,{-4, 2,-5}});
		
		assertEquals(expected,matrix1.multiply(-1), "Incorrect product with negative value");
	}
	
	@Test
	@DisplayName("Multiplying matrix by zero")
	void multiplyScalarZeroTest(){
		matrix1 = new Matrix(new double[][]
		{{1, 8,-3}
		,{4,-2, 5}});
		
		expected = new Matrix(new double[][]
		{{0,0,0}
		,{0,0,0}});
		
		assertEquals(expected,matrix1.multiply(0), "Incorrect product with zero");
	}
	
	@Test
	@DisplayName("Transpose")
	void transposeTest(){
		matrix1 = new Matrix(new double[][]
		{{1, 2, 3}
		,{4, 5, 6}
		,{7, 8, 9}});
		
		expected = new Matrix(new double[][]
		{{1, 4, 7}
		,{2, 5, 8}
		,{3, 6, 9}});
		
		assertEquals(expected, matrix1.transpose());
	}
	
	@Test
	@DisplayName("Multiplying two matrises")
	void multiplyMatrixTest(){
		matrix1 = new Matrix(new double[][]
		{{1,2,3}
		,{4,5,6}});
		
		matrix2 = new Matrix(new double[][]
		{{10,11}
		,{20,21}
		,{30,31}});
		
		expected = new Matrix(new double[][]
		{{140, 146}
		,{320, 335}});
		
		assertEquals(expected, Matrix.multiply(matrix1, matrix2), "Incorrect product");
	}
	
	@Test
	@DisplayName("Submatrix")
	void submatrixTest(){
		matrix1 = new Matrix(new double[][]
		{{1, 2, 3}
		,{4, 5, 6}
		,{7, 8, 9}});
		
		expected = new Matrix(new double[][]
		{{5, 6}
		,{8, 9}});
		assertEquals(expected ,matrix1.submatrix(1, 1));
		
		expected = new Matrix(new double[][]
		{{4, 6}
		,{7, 9}});
		assertEquals(expected ,matrix1.submatrix(1, 2));
		
		expected = new Matrix(new double[][]
		{{4, 5}
		,{7, 8}});
		assertEquals(expected ,matrix1.submatrix(1, 3));
		
		expected = new Matrix(new double[][]
		{{2, 3}
		,{8, 9}});
		assertEquals(expected ,matrix1.submatrix(2, 1));
		
		expected = new Matrix(new double[][]
		{{1, 3}
		,{7, 9}});
		assertEquals(expected ,matrix1.submatrix(2, 2));
		
		expected = new Matrix(new double[][]
		{{1, 2}
		,{7, 8}});
		assertEquals(expected ,matrix1.submatrix(2, 3));
		
		expected = new Matrix(new double[][]
		{{2, 3}
		,{5, 6}});
		assertEquals(expected ,matrix1.submatrix(3, 1));
		
		expected = new Matrix(new double[][]
		{{1, 3}
		,{4, 6}});
		assertEquals(expected ,matrix1.submatrix(3, 2));
		
		expected = new Matrix(new double[][]
		{{1, 2}
		,{4, 5}});
		assertEquals(expected ,matrix1.submatrix(3, 3));
		
		expected = new Matrix(new double[][]
		{{5, 6}
		,{8, 9}});
		assertEquals(expected ,matrix1.submatrix(1, 1));
		
		expected = new Matrix(new double[][]
		{{5, 6}
		,{8, 9}});
		assertEquals(expected ,matrix1.submatrix(1, 1));
		
		expected = new Matrix(new double[][]
		{{5, 6}
		,{8, 9}});
		assertEquals(expected ,matrix1.submatrix(1, 1));
		
		
		matrix1 = new Matrix(new double[][]
		{{1,2}
		,{3,4}});
		
		expected = new Matrix(new double[][]{{4}});
		assertEquals(expected, Matrix.submatrix(matrix1, 1, 1));
		
		expected = new Matrix(new double[][]{{3}});
		assertEquals(expected, Matrix.submatrix(matrix1, 1, 2));
		
		expected = new Matrix(new double[][]{{2}});
		assertEquals(expected, Matrix.submatrix(matrix1, 2, 1));
		
		expected = new Matrix(new double[][]{{1}});
		assertEquals(expected, Matrix.submatrix(matrix1, 2, 2));
	}
	
	@Test
	@DisplayName("Determinant")
	void determinantTest(){
		matrix1 = new Matrix(new double[][]
		{{3, 0, 2,-1}
		,{1, 2, 0,-2}
		,{4, 0, 6,-3}
		,{5, 0, 2, 0}});
		
		assertEquals(20, matrix1.determinant());
	}
	
	@Test
	@DisplayName("Minor")
	void minorTest(){
		matrix1 = new Matrix(new double[][]
		{{ 1, 4, 7}
		,{ 3, 0, 5}
		,{-1, 9,11}});
		
		assertEquals(13, matrix1.minor(2,3));
	}
	
	@Test
	@DisplayName("Cofactor")
	void cofactorTest(){
		matrix1 = new Matrix(new double[][]
		{{ 1, 4, 7}
		,{ 3, 0, 5}
		,{-1, 9,11}});
		
		assertEquals(-13, matrix1.cofactor(2,3));
	}
	
	@Test
	@DisplayName("Adjoint")
	void adjointTest(){
		matrix1 = new Matrix(new double[][]
		{{ 5,-2, 2, 7}
		,{ 1, 0, 0, 3}
		,{-3, 1, 5, 0}
		,{ 3,-1,-9, 4}});
		
		expected = new Matrix(new double[][]
		{{-12, 76,-60,-36}
		,{-56,208,-82,-58}
		,{  4,  4, -2,-10}
		,{  4,  4, 20, 12}});
		
		assertEquals(expected, matrix1.adjoint());
	}
	
	@Test
	@DisplayName("Inverse")
	void inverseTest(){
		matrix1 = new Matrix(new double[][]
		{{4,7}
		,{2,6}});
		
		expected = new Matrix(new double[][]
		{{ 0.6,-0.7}
		,{-0.2, 0.4}});
		
		assertEquals(expected, matrix1.inverse());
	}
	
	@Test
	@DisplayName("Power")
	void powerTest(){
		matrix1 = new Matrix(new double[][]
		{{4,7}
		,{2,6}});
		
		expected = new Matrix(new double[][]
		{{30,70}
		,{20,50}});
		
		assertEquals(expected, matrix1.power(2));
	}
}
