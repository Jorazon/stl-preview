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
	private double fov;
	private FOVtype fovType;
	
	
}
