package rendering;

import math.vectors.Vector3D;

public class Light {
	private Vector3D position;
	private Vector3D color;
	private double strength;
	
	public Light(Vector3D position, Vector3D color, double strength){
		this.position = position;
		this.color = color;
		this.strength = strength;
	}
	
	public Vector3D position(){
		return this.position;
	}
	
	public Vector3D value(Vector3D position, Vector3D normal){
		
		double dot = normal.dot(position.subtract(this.position));
		if (dot <= 0) return new Vector3D(0,0,0);
		
		double distance = this.position.distance(position);
		
		double intensity;
		
		if (distance == 0){
			intensity = strength;
		}
		else {
			intensity = strength * (1 / distance);
		}
		
		return new Vector3D(color.multiply(intensity));
	}
}
