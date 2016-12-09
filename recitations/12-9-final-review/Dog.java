public class Dog extends Animal
{
	
	private boolean goodBoy;


	// Dog will inherit Animal's constructor


	// you're a good boy!
	public void setGoodBoy(boolean b)
	{
		this.goodBoy = b;
	}

	// who's a good boy?
	public boolean isGoodBoy()
	{
		return this.goodBoy;
	}

	// we can override Animal's makeNoise() with our own
	public void makeNoise()
	{
		System.out.println("ARF ARF");
	}
	
}