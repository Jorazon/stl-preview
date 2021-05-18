package math.vectors;

import math.Matrix;

public class Vector3D extends Vector {
	
	public double x(){return array[0];}
	public double y(){return array[1];}
	public double z(){return array[2];}
	
	public Vector3D(double x, double y, double z){
		super(new double[]{x,y,z});
	}
	public Vector3D(double x, Vector2D vector2d){
		super(new double[]{x, vector2d.x(), vector2d.y()});
	}
	public Vector3D(Vector2D vector2d, double z){
		super(new double[]{vector2d.x(), vector2d.y(), z});
	}
	public Vector3D(Vector vector){
		super(padTo3(vector.array));
	}
	
	private static double[] padTo3(double[] array){
		double[] newArray = new double[3];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = i < array.length ? array[i] : 0;
		}
		return newArray;
	}
	
	public static Vector3D cross(Vector vectorA, Vector vectorB){
		
		if (vectorA.dimension() != 3 || vectorB.dimension() != 3){
			throw new IllegalArgumentException("Vector(s) are not Vector3D");
		}
		
		Matrix matrix = new Matrix(new double[][]{{1,1,1},vectorA.array,vectorB.array});
		
		return new Vector3D(
			matrix.minor(1, 1),
			matrix.minor(1, 2),
			matrix.minor(1, 3)
		);
	}
	public Vector3D cross(Vector3D vector){
		return cross(this, vector);
	}
	
	public static double tripleProduct(Vector3D vectorA, Vector3D vectorB,Vector3D vectorC){
		return dot(vectorA, cross(vectorB, vectorC));
	}
}
