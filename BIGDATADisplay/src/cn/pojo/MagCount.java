package cn.pojo;

import java.util.Arrays;

public class MagCount {
	private String[] value;
	int five;
	int six;
	int seven;
	int eight;
	int nine;
	
	

	public int getFive() {
		return five;
	}
	public void setFive(int five) {
		this.five = five;
	}
	public int getSix() {
		return six;
	}
	public void setSix(int six) {
		this.six = six;
	}
	public int getSeven() {
		return seven;
	}
	public void setSeven(int seven) {
		this.seven = seven;
	}
	public int getEight() {
		return eight;
	}
	public void setEight(int eight) {
		this.eight = eight;
	}
	public int getNine() {
		return nine;
	}
	public void setNine(int nine) {
		this.nine = nine;
	}
	public String[] getValue() {
		return value;
	}
	public void setValue(String[] value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MagCount [value=" + Arrays.toString(value) + ", five=" + five + ", six=" + six + ", seven=" + seven
				+ ", eight=" + eight + ", nine=" + nine + "]";
	}
	


	

}
