package Coords;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import File_format.CsvReader;
import File_format.List2Layer;
import GIS.Layer;
import Geom.Point3D;

public class JUINT {
	
	static MyCoords m =new MyCoords();
	Point3D gps0=new Point3D(32.103315,35.209039,670);
	Point3D gps1 =new Point3D(32.106352,35.205225,650);
	
	
	@Test
	public void isValidTest() {
		
		Point3D p =new Point3D(0 ,0,-5);
		boolean b =m.isValid_GPS_Point(p);
		assertTrue("should return true" , b==true);
		
	}
	
	@Test
	public void distanceTest() {
		double result = m.distance3d(gps0, gps1);	
		assertTrue("distance should be approximatly 493.xxx", result <494&&result>492.9);
	}
	
	
	@Test
	public void addTest() {
		Point3D vecMet=new Point3D(337.6989921,-359.2492069,-20);
		Point3D result =m.add(gps0, vecMet);
		assertTrue("",result.x()<33&&result.x()>32&&result.y()<36&&result.y()>35&&result.z()==650);
	}
	
	@Test
	public void azimuthTest() {
		double [] arr= m.azimuth_elevation_dist(gps0, gps1);
		assertTrue("result should be :", arr[1]<-1&&arr[1]>-3);
		
	}
	
	@Test
	public void vectorTest() {
		Point3D result= m.vector3D(gps0, gps1);
		assertTrue("should have the result of the excel:", result.x()==337.6989920612881
						&&result.y()==-359.24920693881893
						&&result.z()==-20);
	}
	
}
