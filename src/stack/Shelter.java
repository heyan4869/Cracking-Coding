package stack;

import java.util.LinkedList;
import java.util.Random;

public class Shelter {
	
		class Animal {
			String itsKind;
			String itsName;
			int date;
			
			public Animal(String itsKind, String itsName) {
				this.itsKind = itsKind;
				this.itsName = itsName;
			}
			
			public String toString(String itsKind, String itsName) {
				return itsKind + ": " + itsName;
			}
			
		}
		
		LinkedList<Animal> dog = new LinkedList<Animal>();
	    LinkedList<Animal> cat = new LinkedList<Animal>();
	    int time = 0;
		
		public void enqueue(Animal a) {
			a.date = time++;
			if(a.itsKind.equals("Dog")) {
				dog.add(a);
			} else {
				cat.add(a);
			}
		}
		
		public Animal dequeueDog() {
			if (dog.isEmpty()) 
	            throw new IllegalStateException("No dog left in the shelter");
	        return dog.removeFirst();
		}
		
		public Animal dequeueCat() {
			if (cat.isEmpty()) 
	            throw new IllegalStateException("No cat left in the shelter");
	        return cat.removeFirst();
		}
		
		public Animal dequeueAny() {
			if(dog.isEmpty() && cat.isEmpty()) {
				throw new IllegalStateException("No dog or cat left in the shelter");
			}
			if(dog.isEmpty()) {
				return dequeueCat();
			} else if(cat.isEmpty()) {
				return dequeueDog();
			} else if(dog.getFirst().date>cat.getFirst().date) {
				return dequeueDog();
			} else {
				return dequeueCat();
			}
			
		}
		public static void main(String[] args){
			Shelter s = new Shelter();
			
//			Random r = new Random();
//			int n = r.nextInt();
		}
		
}