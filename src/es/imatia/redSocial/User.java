package es.imatia.redSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	
	//Atributos
	private String userName;
	private List<Post> postList;
	private List<User> friendList;
	private List<Comment> commentList;
	private List<User> commentedFriendsList;
	private List<Post> commentedPostsList;

	
	//Getters & Setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	
	public List<User> getFriendList() {
		return friendList;
	}
	public void setFriendList(List<User> friendList) {
		this.friendList = friendList;
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	public List<User> getcommentedFriendsList() {
		return commentedFriendsList;
	}
	public void setcommentedFriendsList(List<User> commentedFriendsList) {
		this.commentedFriendsList = commentedFriendsList;
	}
	public List<Post> getCommentedPostsList() {
		return commentedPostsList;
	}
	public void setCommentedPostsList(List<Post> commentedPostsList) {
		this.commentedPostsList = commentedPostsList;
	}
	
	
	//Constructores
	
	public User(String userName) {
		this.userName = userName;
		this.friendList = new ArrayList<User>();
		this.postList = new ArrayList<Post>();
		this.commentList = new ArrayList<Comment>();
		this.commentedFriendsList = new ArrayList<User>();
		this.commentedPostsList = new ArrayList<Post>();
	}
	
	public User(String userName, List<User> friendList, List<Post> postList, List<Comment> commentList, List<User> commentedFriendsList, List<Post> commentedPostsList) {
		this.userName = userName;
		this.friendList = friendList;
		this.postList = postList;
		this.commentList = commentList;
		this.commentedFriendsList = commentedFriendsList;
		this.commentedPostsList = commentedPostsList;
	}
	

	//Métodos
	
	public void addFriend(User friendUser) {
		if(!friendList.contains(friendUser)) {
			friendList.add(friendUser);
			System.out.println(friendUser + " ha sido añadido a tu lista de amigos.");
		} else {
			System.out.println("El usuario que intentas añadir ya es tu amigo.");
		}
	}
	
	public void removeFriend(User friendUser) {
		if(friendList.contains(friendUser)) {
			friendList.remove(friendUser);
			System.out.println(friendUser + " ha sido eliminado de tu lista de amigos");
		} else {
			System.out.println(friendUser + " no está en tu lista de amigos.");
		}
	}
	
	public void allUsers(List<User> usersList, String userName) {
		for (User s: usersList) {
			if (s.getUserName().equals(userName)) {
				usersList.remove(s);
			}
		}
	}
	
	public void postsList() {
		int i=1;
		for (Post p : postList) {
			if (p instanceof TextPost) {
				System.out.println(i + ".  (TP)" + p.getPostDate() + "  -  " + ((TextPost) p).getContent());
			} else if(p instanceof PhotoPost) { 
				System.out.println(i + ".  (PP)" + p.getPostDate() + "  -  " + ((PhotoPost) p).getTitle());
			} else if(p instanceof VideoPost) {
				System.out.println(i + ".  (VP)" + p.getPostDate() + "  -  " + ((VideoPost) p).getTitle());
			}
			
			i++;
		}
	}
	
	public void removePost(int i) {
		if (i>0 && i<=postList.size()) {
			postList.remove(i-1);
		}
	}
	
	public void viewCommentList() {
		int i = 1;
		for(Comment c : commentList) {
			System.out.println(i + ". (" + c.getCommentTime() + ") - " + c.getCommentContain());
			i++;
		}
	}
	
	
	public void removeComment(int i, User postOwner) {

		int j = 0;
		int k = 0;
		
		if (i>0 && i<=commentList.size()) {	
			for(Post p : postOwner.getPostList()) {
				for(Comment c: p.getCommentList()) {
					if (c.equals(commentList.get(i-1))) {
						j = p.getCommentList().indexOf(c);
						k = postOwner.getPostList().indexOf(p);
						System.out.println("Comentario borrado");
					}
				}
				
			}
			
			postOwner.getPostList().get(k).getCommentList().remove(j);
			commentedFriendsList.remove(i-1);
			commentList.remove(i-1);
		}
	}
	
	public void removeUserComment(int postNumber, int commentNumber) {
		
		postList.get(postNumber-1).getCommentList().get(commentNumber-1).getCommentUser();
	
	}
	
	public void recommendFriends( ) {
		List<String> recommendedFriendsName = new ArrayList<>();
		List<Integer> recommendedFriendsTimes = new ArrayList<>();
		String friendName = null;
		int i = 0;
		
		for (User f : friendList) {
			for (User ff : f.getFriendList()) {
				System.out.println("Bucles ok");
				if (!friendList.contains(ff)) {
					friendName = ff.getUserName();
					if (recommendedFriendsName.contains(friendName)) {
						i = recommendedFriendsName.indexOf(friendName);
						recommendedFriendsTimes.set(i, recommendedFriendsTimes.get(i)+1);
											
					} else {
						recommendedFriendsName.add(friendName);
						recommendedFriendsTimes.add(1);
					}
				}
			}
		}
		
		
		System.out.println("Recomendaciones de amistad: ");
		i=0;
		final int MAX_LIST_SIZE = 20;
		while (i<recommendedFriendsName.size() && i < MAX_LIST_SIZE) {
			System.out.println(recommendedFriendsName.get(i) + " (" + recommendedFriendsTimes.get(i) + " amigos en común).");	
			i++;
		}
		
		
	}
	
//	public void userWall(PostsList postsList) {
//		List<Post> wallPostsList = new ArrayList<>();
//		
//		for(Post p : postsList.getPostsList()) {
//			if(friendList.contains(p.getPostUser())) {
//				wallPostsList.add(p);				
//			}
//		}
//		
//		int i = 0;
//		int wallPostsListSize = wallPostsList.size();
//		while(i<wallPostsListSize && i<10) {
//			
//			if (wallPostsList.get(wallPostsListSize-i) instanceof TextPost) {
//				System.out.println(i + ".  (TP)" + wallPostsList.get(wallPostsListSize-i).getPostDate() + "  -  " + ((TextPost) wallPostsList.get(wallPostsListSize-i)).getContent());
//			} else if(wallPostsList.get(wallPostsListSize-i) instanceof PhotoPost) { 
//				System.out.println(i + ".  (PP)" + wallPostsList.get(wallPostsListSize-i).getPostDate() + "  -  " + ((PhotoPost) wallPostsList.get(wallPostsListSize-i)).getTitle());
//			} else if(wallPostsList.get(wallPostsListSize-i) instanceof VideoPost) {
//				System.out.println(i + ".  (VP)" + wallPostsList.get(wallPostsListSize-i).getPostDate() + "  -  " + ((VideoPost) wallPostsList.get(wallPostsListSize-i)).getTitle());
//			}
//			
//			i++;
//			}
//		}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
