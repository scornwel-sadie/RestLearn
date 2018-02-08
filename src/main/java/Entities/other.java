package Entities;

public class other {
    private int id = -1;
    private int main_id = -1;  // forgien key
    private String icecream = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMain_id() {
		return main_id;
	}
	public void setMain_id(int main_id) {
		this.main_id = main_id;
	}
	public String getIcecream() {
		return icecream;
	}
	public void setIcecream(String icecream) {
		this.icecream = icecream;
	}



}
