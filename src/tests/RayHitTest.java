package tests;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import camera.Ray;
import camera.RayHit;
import math.vectors.Vector3D;
import object.Triangle;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class RayHitTest {
	
	Triangle tri = new Triangle(
		new Vector3D( 0, 3, 3),
		new Vector3D(-3,-2, 3),
		new Vector3D( 3,-2, 3));
	
	Ray ray;
	
	@Test
	@DisplayName("Ray and triangle with intersection point")
	void rayTriangleIntersectTest(){
		ray = new Ray(
			new Vector3D(0, 0, 0),
			new Vector3D(0, 0, 1),
			100);
		
		RayHit hit = RayHit.rayTriangleIntersect(ray, tri);
		Vector3D expected = new Vector3D(0, 0, 3);
		
		assertEquals(expected, hit.position(), "Ray should hit triangle");
	}
	
	@Test
	@DisplayName("Ray and triangle without intersection point")
	void rayTriangleNoIntersectTest(){
		ray = new Ray(
			new Vector3D(0, 0, 0),
			new Vector3D(0, 0,-1),
			100);
		
		RayHit hit = RayHit.rayTriangleIntersect(ray, tri);
		
		assertNull(hit, "Ray should not hit triangle");
	}
	
	@Test
	@DisplayName("Ray and parallel triangle without intersection point")
	void rayTriangleParallelIntersectTest(){
		ray = new Ray(
			new Vector3D(0, 0, 0),
			new Vector3D(1, 1, 0),
			100);
		
		RayHit hit = RayHit.rayTriangleIntersect(ray, tri);
		
		assertNull(hit, "Ray should not hit triangle");
	}
}
