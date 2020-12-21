package entity;

/**
 * class định nghĩa một tag
 * 
 * @author Meow
 *
 */
public class Tag {

    private int id;
    private String name;

    public Tag(int id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public Tag() {
	// TODO Auto-generated constructor stub
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return this.getId() + " : " + this.getName();
    }

}
