/**
 * Welcome to our Balloon Tester!
 * This checks that the Balloon class is working right
 * @Author Ethan Adams + 1004
 * @Version 1.0
 */
public class BalloonTester
{
	public static void main(String[] args)
	{
		Balloon b = new Balloon(100);
		b.addAir(100);
		System.out.println("Volume: " + b.getVolume());
		System.out.println("Surface Area: " + b.getSurfaceArea());
		System.out.println("Radius: " + b.getRadius());
	}
}
