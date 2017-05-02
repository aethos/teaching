public class Animal
{
	private String name;

	// construct an animal, initialize name to null
	public Animal()
	{
		this.name = null;
	}

	// give that animal a name
	public void setName(String name)
	{
		this.name = name;
	}

	// get the animal's name
	public String getName()
	{
		return this.name;
	}

	// make some noise!
	public void makeNoise()
	{
		System.out.println("ANIMAL NOISES");
	}
}