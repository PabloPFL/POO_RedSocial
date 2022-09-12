package es.imatia.redSocial;

import java.time.LocalDate;
import java.util.List;

public class PhotoPost extends Post{
	
	//Atributes
	private String title;
	private int photoHeight;
	private int photoWidth;
	
	//Getters & Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPhotoHeight() {
		return photoHeight;
	}
	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}
	public int getPhotoWidth() {
		return photoWidth;
	}
	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}
	
	//Constructor
	public PhotoPost(LocalDate postDate, User postUser, List<Comment> commentList, String title, int photoWidth, int photoHeight) {
		super(postDate, postUser, commentList);
		this.title = title;
		this.photoWidth = photoWidth;
		this.photoHeight = photoHeight;
	}
	
	
	
	
	
	
	
	
	

}
