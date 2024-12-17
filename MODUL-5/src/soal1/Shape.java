package soal1;

public abstract class Shape {
    protected String shapeName;
    
    public Shape (String name){
    	shapeName = name;
    	}
    
    protected abstract Double area();
    
    public String toString(){
    	return shapeName;
    	}
}