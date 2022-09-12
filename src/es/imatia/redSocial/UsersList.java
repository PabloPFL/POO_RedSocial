package es.imatia.redSocial;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
	
	//Atributes
	private List<User> usersList;
	
	
	//Getters & Setters
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> userList) {
		this.usersList = userList;
	}
	
	
	//Constructor
	public UsersList() {
		this.usersList = new ArrayList<>();
	}
	
	
	//Methods
	public User selectedUser(String userName) {
		
		User SelectedUser = null;
		for (User s: usersList) {
			if (s.getUserName().equals(userName)) {
				SelectedUser = s;
			}
		}
		return SelectedUser;
		
	}
	
	
	

}
