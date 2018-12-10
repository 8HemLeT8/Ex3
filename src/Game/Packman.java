package Game;

import Geom.Point3D;
import GIS.*;

public class Packman implements Types{
	private Point3D p ;
	private double speed;
	private double r;
	//constructor
	public Packman(String Lat1 ,String Lon1 ,String Alt1, String Speed1, String radius1) {
		double Lat=Double.parseDouble(Lat1);
		double Lon=Double.parseDouble(Lon1);
		double Alt=Double.parseDouble(Alt1);
		double Speed=Double.parseDouble(Speed1);
		double radius=Double.parseDouble(radius1);
		this.p = new Point3D(Lat,Lon,Alt);
		this.speed=Speed;
		this.r=radius;
	}
	public Packman(double Lat ,double Lon ,double Alt, double Speed, double radius) {
		this.p = new Point3D(Lat,Lon,Lat);
		this.speed=Speed;
		this.r=radius;

	}

	//getters and setters (START)
	public Point3D getLocation() {
		return p;
	}
	public void setP(Point3D p) {
		this.p = p;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	//(END)






}
