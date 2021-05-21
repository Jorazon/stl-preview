package rendering;

import math.vectors.Vector3D;
import object.Triangle;

public class Camera {
	
	public enum FOVtype {
		HORIZONTAL,
		VERTICAL,
		DIAGONAL
	}
	
	private int width;
	private int height;
	private double fovHorizontal;
	private double fovVertical;
	
	public Camera(int width, int height){
		this(width, height, 90);
	}
	public Camera(int width, int height, double fov){
		this(width, height, fov, FOVtype.HORIZONTAL);
	}
	public Camera(int width, int height, double fov, FOVtype fovType){
		this.width = width;
		this.height = height;
		
		switch (fovType) {
			case HORIZONTAL:{
				this.fovHorizontal = fov;
				this.fovVertical = fov/aspect();
			}break;
			case VERTICAL:{
				this.fovHorizontal = fov;
				this.fovVertical = fov/aspect();
			}break;
			case DIAGONAL:{
				this.fovHorizontal = Math.sqrt(fov*fov - width*width);
				this.fovVertical = Math.sqrt(fov*fov - height*height);
			}break;
		}
	}
	
	public double aspect(){
		return width/(double)height;
	}
}
