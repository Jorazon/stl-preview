package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import math.vectors.*;

public class VectorTest {
	
	Vector3D vector1;
	Vector3D vector2;
	Vector3D expected;
	
	@Test
	@DisplayName("Cross product")
	public void crossTest(){
		
		vector1 = new Vector3D(1, 0, 0);
		vector2 = new Vector3D(0, 1, 0);
		
		expected = new Vector3D(0, 0, 1);
		
		assertEquals(expected, vector1.cross(vector2));
	}
		/*
		System.out.println("angle");
		System.out.println(Vector3D.angle(vector1, vector2));
		
		vector1 = new Vector3D(1, 1, 0);
		
		System.out.println("length");
		System.out.println(vector1.length());
		
		System.out.println("normalize");
		System.out.println(vector1.normalize());
		
		System.out.println("multiply");
		
		System.out.println(vector1.multiply(3));
		System.out.println("add");
		System.out.println(vector1.add(vector2));
		
		vector1 = new Vector3D(2, 7, 1);
		vector2 = new Vector3D(8, 2, 8);
		System.out.println("dot");
		System.out.println(Vector.dot(vector1,vector2));
		*/
}
