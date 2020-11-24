package entity;

public class Sentence {

    private Tag tag;
    private static int id;
    private String content;

    public Sentence() {
	id++;
    }

    public Tag getTag() {
	return tag;
    }

    public void setTag(Tag tag) {
	this.tag = tag;
    }

    public static int getId() {
	return id;
    }

    public static void setId(int id) {
	Sentence.id = id;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    @Override
    public String toString() {
	return this.getContent();
    }

}
