package Entities;

import java.util.ArrayList;
import java.util.List;

public class main {
	private int id = -1;
	private String name = "";
	private List<other> icecreams = new ArrayList<other>();


	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public void addOther(other ice){
	    icecreams.add(ice);
    }
    public List<other> getOther(){
	    return icecreams;
    }
	
	
			

}
