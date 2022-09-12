package es.imatia.redSocial;

import java.util.ArrayList;
import java.util.List;

public class PostsList {
	
	//Atributes
	private List<Post> postsList;

	
	//Getters & Setters	
	public List<Post> getPostsList() {
		return postsList;
	}
	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}
	

	//Constructor
	public PostsList() {
		this.postsList = new ArrayList<>();
		
	}
	
	
	
	

}
