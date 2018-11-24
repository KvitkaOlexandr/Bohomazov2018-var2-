package lab3_2;

import java.util.List;
import java.util.ArrayList;

public class Vector {
	
	private List<Integer> VectorList;
	final int N;
	
	public Vector() {
		VectorList = new ArrayList<Integer>();
		N = 2;
	}
	
	public Vector(int n) {
		VectorList = new ArrayList<Integer>();
		N = n;
	}
	
	public Vector(int[] vector) {
		VectorList = new ArrayList<Integer>();
		N = vector.length;
		for(int i = 0; i < N; i++) {
			VectorList.add(vector[i]);
		}
	}
	
	public List<Integer> getVector() {
		return VectorList;
	}
	
	public int getSize() {
		return N;
	}
	
	public double absolute() {
		double abs = 0;
		for(int number : VectorList) {
			abs += Math.pow(number, 2);
		}
		abs = Math.sqrt(abs);
		return abs;
	}
	
	public int scalarMultiplication(Vector vector) {
		if(vector.getSize() != N) 
			throw new IllegalArgumentException();
		int result = 0;
		for(int i = 0; i < N; i++) {
			result += VectorList.get(i) * vector.getVector().get(i);
		}
		return result;
	}
		
	public void add(Vector vector) {
		if(vector.getSize() != N) 
			throw new IllegalArgumentException();
		for(int i = 0; i < N; i++) {
			VectorList.set(i, VectorList.get(i) + vector.getVector().get(i));
		}
	}
	
	public void substract(Vector vector) {
		if(vector.getSize() != N) 
			throw new IllegalArgumentException();
		for(int i = 0; i < N; i++) {
			VectorList.set(i, VectorList.get(i) - vector.getVector().get(i));
		}
	}
	
	public void multOnScalar(int scalar) {
		for(int i = 0; i < N; i++) {
			VectorList.set(i, VectorList.get(i) * scalar);
		}
	}
	
	public boolean isOrthogonal(Vector vector) {
		if(this.scalarMultiplication(vector) == 0)
			return true;
		return false;
	}
	
	public boolean isCollinear(Vector vector) {
		if(vector.getSize() != N) 
			throw new IllegalArgumentException();
		double result = VectorList.get(0) / vector.getVector().get(0);
		for(int i = 1; i < N; i++) {
			if(result != VectorList.get(i) / vector.getVector().get(i))
				return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String string = "[";
		for(int i = 0; i < N - 1; i++) {
			string = string + VectorList.get(i) + ", ";
		}
		string += VectorList.get(N - 1) + "]";
		return string;
	}
}
