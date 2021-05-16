package object;

import math.vectors.Vector3D;


public class Triangle {
	private Vector3D normal;
	private Vector3D[] verts;
	
	public Triangle(Vector3D normal,Vector3D vert1,Vector3D vert2,Vector3D vert3){
		this.normal = normal;
		this.verts = new Vector3D[]{vert1, vert2, vert3};
	}
	public Triangle(Vector3D vert1,Vector3D vert2,Vector3D vert3){
		this.verts = new Vector3D[]{vert1, vert2, vert3};
		this.normal = calculateNormal();
	}
	
	/**
	 * Calculates a normal vector based on triangle points
	 * @return Calculated normal direction for triangle
	 */
	public Vector3D calculateNormal(){
		return (Vector3D)Vector3D.cross(
			(Vector3D)verts[1].subtract(verts[0]),
			(Vector3D)verts[2].subtract(verts[0])
		).normalize();
	}
	
	public Vector3D normal(){
		return this.normal;
	}
	
	public Vector3D[] verts(){
		return this.verts;
	}
	public Vector3D vert0(){
		return this.verts[0];
	}
	public Vector3D vert1(){
		return this.verts[1];
	}
	public Vector3D vert2(){
		return this.verts[2];
	}
}
