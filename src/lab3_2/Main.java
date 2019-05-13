package lab3_2;

public class Main {

	public static void main(String[] args) {
		task2();
	}
	
	public static void task2() {
		Vector [] vectors = {new Vector(new int[]{2, -1, 10}),
							new Vector(new int[]{1, 2, 0}),
							new Vector(new int[]{4, -2, 20})};
		System.out.println("Module");
		for(int i = 0; i < vectors.length; i++) {
			System.out.println(vectors[i].length());
		}
		
		System.out.println("\nOrtogonal");
		for(int i = 1; i < vectors.length; i++) {
			if((vectors[0].isOrthogonal(vectors[i])))
				System.out.println(vectors[0].toString() + "is ortogonal" + vectors[i].toString());
		}
		
		System.out.println("\nCollinear");
		for(int i = 1; i < vectors.length; i++) {
			if((vectors[0].isCollinear(vectors[i])))
				System.out.println(vectors[0].toString() + " is collinear " + vectors[i].toString());
		}		
	}

}
