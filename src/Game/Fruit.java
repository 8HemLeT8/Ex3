package Game;
import GIS.*;
import Geom.Point3D;

public class Fruit implements Types{
	private Point3D p;
	private double weight;
	private Map N = new Map();
	
	public Fruit(double Lat, double Lon, double Alt ,double weight) {
		this.p=new Point3D(Lat,Lon,Alt);
	this.weight=weight;
	}
	public Fruit(String Lat1 ,String Lon1 ,String Alt1, String weight1) {
		double Lat=Double.parseDouble(Lat1);
		double Lon=Double.parseDouble(Lon1);
		double Alt=Double.parseDouble(Alt1);
		double weight=Double.parseDouble(weight1);
		this.p=new Point3D(Lat,Lon,Alt);
		this.weight=weight;
		
	}
	public Fruit(Point3D p) {
		this.p=p;
	}
	public Fruit(int PixelsX,int PixelsY) {
		this.p=N.pixels2polar(PixelsX,PixelsY);
		this.weight=1;

	}

	public Point3D getLocation() {
		return p;
	}
	public Point3D getLocationInPixels() {
		return N.polar2pixels(p);
	}
	public void setP(Point3D p) {
		this.p = p;
	}

}