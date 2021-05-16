package math.vectors;

import java.util.Arrays;

import math.Matrix;

public class Vector{
	
	protected double[] array;
	
	public int dimension(){
		return array.length;
	}
	
	public Vector(double[] array){
		this.array = array;
	}
	public Vector(int dimension){
		this.array = new double[dimension];
	}
	public Vector(Matrix matrix){
		this.array = matrix.toVector().array;
	}
	
	public static double length(Vector vector){
		double lengthSum = 0;
		
		for (double d : vector.array) {
			lengthSum += d * d;
		}
		
		lengthSum = Math.sqrt(lengthSum);
		
		return lengthSum;
	}
	public double length(){
		return length(this);
	}
	
	public static Vector multiply(Vector vector, double scalar){
		return new Vector(Matrix.multiply(vector.toMatrix(), scalar));
	}
	public Vector multiply(double scalar){
		return multiply(this, scalar);
	}
	
	public static Vector add(Vector vectorA, Vector vectorB){
		return new Vector(Matrix.add(vectorA.toMatrix(),vectorB.toMatrix()));
	}
	public Vector add(Vector vector){
		return add(this, vector);
	}
	
	public static Vector subtract(Vector vectorA, Vector vectorB){
		return add(vectorA ,vectorB.multiply(-1));
	}
	public Vector subtract(Vector vector){
		return subtract(this, vector);
	}
	
	public static Vector normalize(Vector vector){
		return multiply(vector, 1 / length((vector)));
	}
	public Vector normalize(){
		return normalize(this);
	}
	
	public static double dot(Vector vectorA, Vector vectorB){
		return Matrix.dot(vectorA.array, vectorB.array);
	}
	public double dot(Vector vector){
		return dot(this, vector);
	}
	
	public static double angle(Vector vectorA, Vector vectorB){
		return Math.acos(dot(vectorA, vectorB)/(vectorA.length()*vectorB.length()));
	}
	public double angle(Vector vector){
		return angle(this, vector);
	}
	
	public static Matrix toMatrix(Vector vector){
		return new Matrix(new double[][]{vector.array});
	}
	public Matrix toMatrix(){
		return toMatrix(this);
	}
	
	@Override
	public String toString(){
		return toMatrix().toString();
	}
	
	@Override
	public int hashCode(){
		return Arrays.hashCode(array);
	}
	
	@Override
	public boolean equals(Object object){
		if (object == this) return true;
		if (object == null || this.getClass() != object.getClass()) return false;
		Vector vectorObject = (Vector)object;
		return Arrays.equals(array, vectorObject.array);
	}
}
