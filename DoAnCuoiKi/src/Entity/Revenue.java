package Entity;

import java.sql.Date;

public class Revenue {
	private Date date;
	private int Type;
	private Float Value;
	
	public Revenue() {
		
	}
	public Revenue(Date date, int type, float value) {
		this.date = date;
		this.Type = type;
		this.Value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public Float getValue() {
		return Value;
	}
	public void setValue(Float value) {
		Value = value;
	}
}
