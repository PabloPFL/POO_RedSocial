package es.imatia.redSocial;

import java.time.LocalDate;
import java.util.List;

public class VideoPost extends Post{
	
	//Atributes
	private String title;
	private String videoQuality;
	private int videoLength;
	
	//Getters & Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideoQuality() {
		return videoQuality;
	}
	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}
	public int getVideoLength() {
		return videoLength;
	}
	public void setVideoLength(int videoLength) {
		this.videoLength = videoLength;
	}
	
	//Constructor
	public VideoPost(LocalDate postDate, User postUser, List<Comment> commentList, String title, String videoQuality, int videoLength) {
		super(postDate,postUser, commentList);
		this.title = title;
		this.videoQuality = videoQuality;
		this.videoLength = videoLength;
			
	}
	

}
