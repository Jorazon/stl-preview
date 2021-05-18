package camera;

import math.vectors.Vector3D;

public class Ray {
	
	private Vector3D origin;
	private Vector3D direction;
	private double length;
	
	public Ray(Vector3D origin, Vector3D direction, double length) {
		this.origin = origin;
		this.direction = new Vector3D(direction.normalize());
		this.length = length;
	}
	
	public Vector3D origin() {
		return this.origin;
	}
	public Vector3D direction() {
		return this.direction;
	}
	public double length() {
		return this.length;
	}
}
