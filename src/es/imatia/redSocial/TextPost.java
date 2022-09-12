package es.imatia.redSocial;

import java.time.LocalDate;
import java.util.List;

public class TextPost extends Post{
	
	//Atributes
	private String content;
	
	//Getters & Setters
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	//Constructor
	public TextPost(LocalDate postDate, User postUser, List<Comment> commentList, String content) {
		super(postDate, postUser, commentList);
		this.content = content;
	}
	
	
	
	
	
	
	
	

}
