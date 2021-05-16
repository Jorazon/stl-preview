package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import math.vectors.*;

public class VectorTest {
	
	final double DELTA = 0.000000000000001;
	
	Vector3D vector1 = new Vector3D(1, 0, 0);
	Vector3D vector2 = new Vector3D(0, 1, 0);
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
		
		assertEquals(1.5707963267948966, vector1.angle(vector2), DELTA);
	}
	
	@Test
	@DisplayName("Length")
	public void lengthTest(){
		
		assertEquals(1.5707963267948966, vector1.angle(vector2), DELTA);
	}
	
	@Test
	@DisplayName("Normalize")
	public void normalizeTest(){
		
		Vector3D vector3 = new Vector3D(1, 1, 0);
		
		assertEquals(1, vector3.normalize().length(), DELTA);
	}
	
	@Test
	@DisplayName("Vector sum")
	public void additionTest(){
		
		expected = new Vector3D(1, 1, 0);
		
		assertEquals(expected, vector1.add(vector2));
	}
	
	@Test
	@DisplayName("Vector product")
	public void multiplyTest(){
		
		expected = new Vector3D(3, 0, 0);
		
		assertEquals(expected, vector1.multiply(3));
	}
	
	@Test
	@DisplayName("Dot product")
	public void dotTest(){
		
		vector1 = new Vector3D(2, 7, 1);
		vector2 = new Vector3D(8, 2, 8);
		
		assertEquals(38, vector1.dot(vector2), DELTA);
	}
		/*
		vector1 = new Vector3D(1, 1, 0);
		
		System.out.println("length");
		System.out.println(vector1.length());
		
		System.out.println("normalize");
		System.out.println(vector1.normalize());
		
		System.out.println("multiply");
		
		System.out.println(vector1.multiply(3));
		System.out.println("add");
		System.out.println(vector1.add(vector2));
		
		
		System.out.println("dot");
		System.out.println(Vector.dot(vector1,vector2));
		*/
}
