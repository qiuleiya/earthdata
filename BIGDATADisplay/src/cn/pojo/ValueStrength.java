package cn.pojo;

import java.util.Arrays;
import java.util.Date;

public class ValueStrength {

	@Override
	public String toString() {
		return "ValueStrength [value=" + Arrays.toString(value) + ", magnitude=" + magnitude + ", date=" + date
				+ ", flag=" + flag + "]";
	}
	private String[] value;//¾­Î³¶È
	private double magnitude;//Õð¼¶
	private Date date; 
	private int flag;
	public String[] getValue() {
		return value;
	}
	public void setValue(String[] value) {
		this.value = value;
	}
	public double getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
