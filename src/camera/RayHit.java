package camera;

import math.vectors.Vector3D;
import object.Triangle;

/**
 * 
 */
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
	 * @param ray Triangle to test intersection for.
	 * @param triangle Triangle to test intersection with.
	 * @return RayHit object if ray and triangle intersect, NULL otherwise.
	 */
	public static RayHit rayTriangleIntersect(Ray ray, Triangle triangle){
		final double EPSILON = 0.0000001;
		Vector3D edge1, edge2, h, s, q;
		double a, f, u, v;
		
		edge1 = (Vector3D)triangle.vert1().subtract(triangle.vert0());
		edge2 = (Vector3D)triangle.vert2().subtract(triangle.vert0());
		h = ray.direction().cross(edge2);
		a = edge1.dot(h);
		
		if (a > -EPSILON && a < EPSILON) return null; // Ray is parallel to triangle. Intersection not possible.
		
		f = 1/a;
		s = (Vector3D)ray.origin().subtract(triangle.vert0());
		u = f * s.dot(h);
		
		if (u < 0 || u > 1) return null;
		
		q = s.cross(edge1);
		v = f * ray.direction().dot(q);
		
		if (v < 0 || u + v > 1) return null;
		
		double distance = f * edge2.dot(q);
		
		Vector3D position = (Vector3D) ray.origin().add(ray.direction().multiply(distance));
		
		if (distance > EPSILON) return new RayHit(position, triangle.normal(), distance);
		
		return null;
	}
}
	
