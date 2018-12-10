package Game;

import GIS.*;
import Geom.Point3D;

public class Map {

	 public double getRangeXpixels() {
		return rangeXpixels;
	}

	public void setRangeXpixels(double rangeXpixels) {
		this.rangeXpixels = rangeXpixels;
	}

	public double getRangeYpixels() {
		return rangeYpixels;
	}

	public void setRangeYpixels(double rangeYpixels) {
		this.rangeYpixels = rangeYpixels;
	}

	public double getRangeXpolar() {
		return rangeXpolar;
	}

	public void setRangeXpolar(double rangeXpolar) {
		this.rangeXpolar = rangeXpolar;
	}

	public double getRangeYpolar() {
		return rangeYpolar;
	}

	public void setRangeYpolar(double rangeYpolar) {
		this.rangeYpolar = rangeYpolar;
	}

	double rangeXpixels=1433;
	 double rangeYpixels=-642;
	 double rangeXpolar=0.0100;
	 double rangeYpolar=0.0038;
	 double PolarX0=35.2023;
	 double PolarY0=32.1057;

	public  Point3D pixels2polar(int x,int y) {
		double newX = rangeXpolar*(x/rangeXpixels)+PolarX0;
		double newY = rangeYpolar*(y/rangeYpixels)+PolarY0;
		return new Point3D(newX,newY,0);
	}

	public  Point3D polar2pixels(Point3D temp) {
		double newX = Math.round(((temp.x()-PolarX0)/rangeXpolar)*rangeXpixels);
		double newY = Math.round(((temp.y()-PolarY0)/rangeYpolar)*rangeYpixels);
		return new Point3D(newX,newY,0);
	}

	public static void main(String[] args) {
		int x=1433;
		int y=642;
		Point3D n= new Point3D(35.2123,32.1019,0);
		Map p =new Map();
		System.out.println((p.pixels2polar(x,y)));
		System.out.println((p.polar2pixels(n)));
	}

}
