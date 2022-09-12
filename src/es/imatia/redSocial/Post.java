package es.imatia.redSocial;

import java.time.LocalDate;
import java.util.List;

public class Post {
	
	//Atributos
	protected LocalDate postDate;
	protected List<Comment> commentList;
	protected User postUser;
	
	//Getters & Setters
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	public User getPostUser() {
		return postUser;
	}
	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}
	
	//Constructor
	public Post(LocalDate postDate, User postUser, List<Comment> commentList) {
		this.postDate = postDate;
		this.postUser = postUser;
		this.commentList = commentList;
	}
	
	
	//Methods
	public void viewComments() {
		int i = 1;
		for (Comment c : commentList) {
			System.out.println(i+ "- (" + c.getCommentTime() + "). " + c.getCommentUser().getUserName() + " comentó:");
			System.out.println(c.getCommentContain());
			i++;
		}
	}

	
	
	
	
	

}
