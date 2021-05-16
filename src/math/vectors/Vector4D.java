package math.vectors;

public class Vector4D extends Vector {
	
	public double x(){return array[0];}
	public double y(){return array[1];}
	public double z(){return array[2];}
	public double w(){return array[3];}
	
	public Vector4D(double x, double y, double z, double w){
		super(new double[]{x,y,z,w});
	}
	public Vector4D(double x, double y, Vector2D vector2d){
		super(new double[]{x, y, vector2d.x(), vector2d.y()});
	}
	public Vector4D(double x, Vector2D vector2d, double w){
		super(new double[]{x, vector2d.x(), vector2d.y(), w});
	}
	public Vector4D(Vector2D vector2d, double z, double w){
		super(new double[]{vector2d.x(), vector2d.y(), z, w});
	}
	public Vector4D(Vector2D vector2dA, Vector2D vector2dB){
		super(new double[]{vector2dA.x(), vector2dA.y(), vector2dB.x(), vector2dB.y()});
	}
	public Vector4D(double x, Vector3D vector3d){
		super(new double[]{x, vector3d.x(), vector3d.y(), vector3d.z()});
	}
	public Vector4D(Vector3D vector3d, double w){
		super(new double[]{vector3d.x(), vector3d.y(), vector3d.z(), w});
	}
}
