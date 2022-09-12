package es.imatia.redSocial;

import java.time.*;

public class Comment {
	
	//Atributes
	private String commentContain;
	private LocalDate commentTime;
	private User commentUser;
	
	
	//Getters & Setters
	public String getCommentContain() {
		return commentContain;
	}
	public void setCommentContain(String commentContain) {
		this.commentContain = commentContain;
	}
	public LocalDate getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(LocalDate commentTime) {
		this.commentTime = commentTime;
	}
	public User getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}
	
	//Constructor
	public Comment(String commentContain, LocalDate commentTime, User commentUser) {
		this.commentContain = commentContain;
		this.commentTime = commentTime;
		this.commentUser = commentUser;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
