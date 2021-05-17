package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import math.vectors.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class VectorTest {
	
	static final double DELTA = 0.0000001;
	
	Vector3D vector1 = new Vector3D(1, 0, 0);
	Vector3D vector2 = new Vector3D(0, 1, 0);
	Vector3D vector3 = new Vector3D(1, 1, 0);
	Vector3D expected;
	
	@Test
	@DisplayName("Cross product")
	public void crossTest(){
		
		expected = new Vector3D(0, 0, 1);
		
		assertEquals(expected, vector1.cross(vector2));
	}
	
	@Test
	@DisplayName("Angle")
	public void angleTest(){
		
		assertEquals(1.57079632679, vector1.angle(vector2), DELTA);
	}
	
	@Test
	@DisplayName("Length")
	public void lengthTest(){
		
		assertEquals(1.41421356237, vector3.length(), DELTA);
	}
	
	@Test
	@DisplayName("Normalize")
	public void normalizeTest(){
		
		assertEquals(1, vector3.normalize().length(), DELTA);
	}
	
	@Test
	@DisplayName("Vector sum")
	public void additionTest(){
		
		expected = new Vector3D(1, 1, 0);
		
		assertEquals(expected, vector1.add(vector2));
	}
	
	@Test
	@DisplayName("Vector scaling")
	public void multiplyTest(){
		
		expected = new Vector3D(3, 0, 0);
		
		assertEquals(expected, vector1.multiply(3));
	}
	
	@Test
	@DisplayName("Dot product for parallel vectors")
	public void dotParallelTest(){
		
		vector1 = new Vector3D(1, 0, 0);
		vector2 = new Vector3D(3, 0, 0);
		
		assertEquals(3, vector1.dot(vector2), DELTA);
	}
	
	@Test
	@DisplayName("Dot product for antiparallel vectors")
	public void dotAntiparallelTest(){
		
		vector1 = new Vector3D(1, 0, 0);
		vector2 = new Vector3D(-1, 0, 0);
		
		assertEquals(-1, vector1.dot(vector2), DELTA);
	}
	
	@Test
	@DisplayName("Dot product for perpendicular vectors")
	public void dotPerpendicularTest(){
		
		vector1 = new Vector3D(1, 0, 0);
		vector2 = new Vector3D(0, 1, 0);
		
		assertEquals(0, vector1.dot(vector2), DELTA);
	}
	
	@Test
	@DisplayName("Dot product for complicated vectors")
	public void dotComplexTest(){
		
		vector1 = new Vector3D(2, 7, 1);
		vector2 = new Vector3D(8, 2, 8);
		
		assertEquals(38, vector1.dot(vector2), DELTA);
	}
}
