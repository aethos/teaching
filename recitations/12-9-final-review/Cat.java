public class Cat extends Animal
{
	// We can also define our own Cat constructor
	public Cat(String name)
	{
		// Here we need to use the setName(String) method.
		// this.name = name; // will not work (try it!)
		// This is because name is a private varible.
		// Although Cat is a subclass of Animal, it has the same permissions
		// as any other class, so we can't access any private variables.

		this.setName(name);
	}

	public void knead()
	{
		System.out.println("...kneading...");
	}
}