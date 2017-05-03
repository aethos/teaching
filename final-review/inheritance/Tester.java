/***********
Inheritance!

Ethan Adams
COMS W1004 Fall 2016
************/

import java.util.ArrayList;

public class Tester
{
	public static void main(String[] args)
	{
		// make one of each
		Animal monkey = new Animal();
		monkey.setName("King Kong");

		Dog doggo = new Dog();
		doggo.setGoodBoy(true);

		Cat kitten = new Cat("Felix");

		Giraffe tallBoy = new Giraffe();

		// We can call Animal methods on Animals, Cats and Dogs (and Giraffes)
		// because they inherit from Animals.
		// We can also call Cat and Dog methods on their respective objects.
		System.out.println("Who\'s that climbing the empire state builing? " + 
							"It\'s: " + monkey.getName());

		doggo.setName("Skittles");
		System.out.println(doggo.getName() + 
							" is a good boy?: " + doggo.isGoodBoy());

		System.out.println("Our cat is named: " + kitten.getName());


		// Our superclass Animal still only has the Animal methods,
		// and does not have Dog's isGoodBoy() for example.

		// monkey.setGoodBoy(); // this will fail.


		// how does each animal sound?
		// Monkey will make animal noises
		monkey.makeNoise();
		// doggo will bark, as Dog overode the method
		doggo.makeNoise();
		// Cat did not overrode the method, so it will use the animal one
		kitten.makeNoise();
		// Giraffe has overridden the method, but also calls the animal one.
		tallBoy.makeNoise();


		/*
		This is kinda confusing.
		This is constructing a new Cat object, and storing in a reference
		of type Animal, namely "katto".
		We're allowed to do this because Animal is a superclass of Cat.
		*/

		Animal katto = new Cat("Felix");

		/*
		But now since "katto" is a reference to an Animal,
		we can only call Animal methods on it.
		We can't call Cat's method knead(), because all we know about katto
		is that it points to an Animal or some subclass of Animal.
		So katto could point to a Dog, which does not have the knead() method.
		That's the reason Java will not let you call knead() here.
		*/

		// katto.knead(); // doesn't work!

		
		// What we can do is to cast katto as a Cat.
		// Then we can all the Cat methods on it.
		
		((Cat)katto).knead();

		/* 
		What we have seen here is that the methods you can call depend
		not on the object type, but rather the reference type.
		'katto' is a reference to an Animal, so we can only call Animal methods
		on it. If we want to call Cat specific methods, we must cast.
		*/

		/*
		As a bit of a bonus, what happens when we try and cast our Cat object
		into a Dog, like this?
		*/

		// ((Dog)katto).makeNoise();  // ClassCastException!
		
		/*
		Surprise surprise, this will generate a runtime exception!
		The exception we get is a ClassCastException, and it says
		"Cat cannot be cast to Dog". 
		This makes total sense -- Java has no defined way to turn a Cat into
		a Dog. They have different methods, different instance varaibles,
		it's too complicated.
		*/


		// We can define an ArrayList of Animals, and put all the animals in it
		// We can do this because all of these objects "are" animals.
		ArrayList<Animal> friends = new ArrayList<Animal>();
		friends.add(monkey);
		friends.add(doggo);
		friends.add(kitten);
		friends.add(tallBoy);
		friends.add(katto);


		// We can iterate over this list, and call each objects makeNoise()
		// This works because of polymorphism!
		for (Animal a: friends)
		{
			a.makeNoise();
		}


	}
}
