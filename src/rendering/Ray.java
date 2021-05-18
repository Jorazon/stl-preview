package rendering;

import math.vectors.Vector3D;

public class Ray {
	
	private Vector3D origin;
	private Vector3D direction;
	
	public Ray(Vector3D origin, Vector3D direction) {
		this.origin = origin;
		this.direction = new Vector3D(direction.normalize());
	}
	
	public Vector3D origin() {
		return this.origin;
	}
	public Vector3D direction() {
		return this.direction;
	}
}
