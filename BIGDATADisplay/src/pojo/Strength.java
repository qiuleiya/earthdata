package pojo;


//地震强度信息
public class Strength {
	private String dateperiod; //
	private String[] value;//经纬度
	private double magnitude;//震级
	private int flag;
	public String getDateperiod() {
		return dateperiod;
	}
	public void setDateperiod(String dateperiod) {
		this.dateperiod = dateperiod;
	}
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	

	
	
}
