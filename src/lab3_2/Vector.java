package lab3_2;

import java.util.List;
import java.util.ArrayList;

public class Vector {
	
	private List<Integer> vectorList;
	private int dimension;
	
	public Vector() {
		vectorList = new ArrayList<Integer>();
		dimension = 2;
	}
	
	public Vector(int n) {
		vectorList = new ArrayList<Integer>();
		dimension = n;
	}
	
	public Vector(int[] vector) {
		vectorList = new ArrayList<Integer>();
		dimension = vector.length;
		for(int i = 0; i < dimension; i++) {
			vectorList.add(vector[i]);
		}
	}
	
	public List<Integer> getVector() {
		return vectorList;
	}
	
	public int getSize() {
		return dimension;
	}
	
	private void setVector(List<Integer> vector) {
		vectorList = vector;
	}
	
	public double length() {
		double abs = 0;
		for(int number : vectorList) {
			abs += Math.pow(number, 2);
		}
		abs = Math.sqrt(abs);
		return abs;
	}
	
	public int scalarMultiplication(Vector vector) {
		if(vector.getSize() != dimension) 
			throw new IllegalArgumentException();
		int result = 0;
		for(int i = 0; i < dimension; i++) {
			result += vectorList.get(i) * vector.getVector().get(i);
		}
		return result;
	}
		
	public Vector add(Vector vector) {
		if(vector.getSize() != dimension) 
			throw new IllegalArgumentException();
		Vector v = new Vector(dimension);
		v.setVector(vectorList);
		
		for(int i = 0; i < dimension; i++) {
			v.vectorList.set(i, vectorList.get(i) + vector.getVector().get(i));
		}
		return v;
	}
	
	public Vector substract(Vector vector) {
		if(vector.getSize() != dimension) 
			throw new IllegalArgumentException();
		Vector v = new Vector(dimension);
		v.setVector(vectorList);
		for(int i = 0; i < dimension; i++) {
			v.vectorList.set(i, vectorList.get(i) - vector.getVector().get(i));
		}
		return v;
	}
	
	public Vector multOnScalar(int scalar) {
		Vector v = new Vector(dimension);
		v.setVector(vectorList);
		for(int i = 0; i < dimension; i++) {
			v.vectorList.set(i, vectorList.get(i) * scalar);
		}
		return v;
	}
	
	public boolean isOrthogonal(Vector vector) {
		if(this.scalarMultiplication(vector) == 0)
			return true;
		return false;
	}
	
	public boolean isCollinear(Vector vector) {
		if(vector.getSize() != dimension) 
			throw new IllegalArgumentException();
		double result = vectorList.get(0) / vector.getVector().get(0);
		for(int i = 1; i < dimension; i++) {
			if(result != vectorList.get(i) / vector.getVector().get(i))
				return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String string = "[";
		for(int i = 0; i < dimension - 1; i++) {
			string = string + vectorList.get(i) + ", ";
		}
		string += vectorList.get(dimension - 1) + "]";
		return string;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dimension;
		result = prime * result + ((vectorList == null) ? 0 : vectorList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (dimension != other.dimension)
			return false;
		if (vectorList == null) {
			if (other.vectorList != null)
				return false;
		} else if (!vectorList.equals(other.vectorList))
			return false;
		return true;
	}
}
