package rendering;

import math.vectors.Vector3D;

public class Light {
	private Vector3D position;
	
	public Light(Vector3D position){
		this.position = position;
	}
	
	public Vector3D position(){
		return this.position;
	}
}
