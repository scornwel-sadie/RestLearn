package Entities;

public class PrimaryKey {
    int key = -1;
    String name = "";

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

   public void setKey(int key){
       this.key =key;

    }

    public int getKey(){
       return this.key;
    }


}
