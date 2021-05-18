package rendering;

import math.vectors.Vector3D;
import object.Triangle;

public class RayHit {
	private Vector3D position;
	private Vector3D normal;
	private double distance;
	
	public RayHit(Vector3D position, Vector3D normal, double distance) {
		this.position = position;
		this.normal = normal;
		this.distance = distance;
	}
	
	public Vector3D position(){
		return this.position;
	}
	public Vector3D normal(){
		return this.normal;
	}
	public double distance(){
		return this.distance;
	}
	
	/**
	 * Tests if a given ray intersects a given triangle.
	 * Implemantation of https://courses.cs.washington.edu/courses/csep557/10au/lectures/triangle_intersection.pdf
	 * @param ray Triangle to test intersection for.
	 * @param triangle Triangle to test intersection with.
	 * @return RayHit object if ray and triangle intersect, NULL otherwise.
	 */
	public static RayHit rayTriangleIntersect(Ray ray, Triangle triangle){
		final double EPSILON = 1e-6;
		
		//ray is parallel. Zero or infinite intersectoions.
		if (triangle.normal().dot(ray.direction()) < EPSILON) return null;
		
		//distance of plane intersection from ray origin in direction of ray
		double distance = (triangle.normal().dot(triangle.vert0()) - triangle.normal().dot(ray.origin()))/(triangle.normal().dot(ray.direction()));
		
		//ray plane intersection point
		Vector3D position = new Vector3D(ray.origin().add(ray.direction().multiply(distance)));
		
		//check if ray plane intersection is inside triangle
		if(
			Vector3D.cross(
				triangle.vert1().subtract(triangle.vert0()),
				position.subtract(triangle.vert0())
			).dot(triangle.normal()) >= 0
			&&
			Vector3D.cross(
				triangle.vert2().subtract(triangle.vert1()),
				position.subtract(triangle.vert1())
			).dot(triangle.normal()) >= 0
			&&
			Vector3D.cross(
				triangle.vert0().subtract(triangle.vert2()),
				position.subtract(triangle.vert2())
			).dot(triangle.normal()) >= 0
			
		){
			return new RayHit(position, triangle.normal(), distance);
		}
		
		//intersection is outside triangle
		return null;
	}
}
	
