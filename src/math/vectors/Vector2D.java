package math.vectors;

public class Vector2D extends Vector {
	
	public double x(){return array[0];}
	public double y(){return array[1];}
	
	public Vector2D(double x, double y){
		super(new double[]{x,y});
	}
}
