public class Giraffe extends Animal
{
	private int height;

	// Giraffe inherits Animal's constructor

	// set height
	public void setHeight(int height)
	{
		this.height = height;
	}

	// get height
	public int getHeight()
	{
		return this.height;
	}

	// We can override Animal's makeNoise() method,
	// but also call the Animal's makeNoise()
	// by using the keyword super, which refers to the superclass of Animal.
	public void makeNoise()
	{
		super.makeNoise();
		System.out.println("*cough cough*");
	}
}