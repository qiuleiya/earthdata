package pojo;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

public class Earthquake {
	private Date date;//����
	private Time time;//ʱ��
	private String[] value;//��γ��
	private double depth;//���
	private double magnitude;//��
	private String magnitudetype;//����
	private String source;//��Դ
	private String statu;//״̬

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String[] getValue() {
		return value;
	}
	public void setValue(String[] value) {
		this.value = value;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public double getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	public String getMagnitudetype() {
		return magnitudetype;
	}
	public void setMagnitudetype(String magnitudetype) {
		this.magnitudetype = magnitudetype;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return statu;
	}
	public void setStatus(String status) {
		this.statu = status;
	}
	@Override
	public String toString() {
		return "Earthquake [date=" + date + ", time=" + time + ", value=" + Arrays.toString(value) + ", depth=" + depth
				+ ", magnitude=" + magnitude + ", magnitudetype=" + magnitudetype + ", source=" + source + ", status="
				+ statu + "]";
	}
	
	
}
