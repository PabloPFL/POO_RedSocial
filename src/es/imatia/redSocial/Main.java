package es.imatia.redSocial;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Main {
	public static void main(String[] args) {
		
		//List<User>UL.usersList = new ArrayList<>();
		UsersList UL = new UsersList();
		Scanner keyBoard = new Scanner(System.in);
		
		
		//Usuarios
		User pepe = new User("pepe");
		User manolita = new User("manolita");
		User juan = new User("juan");
		User julia = new User("julia");
		User sandra = new User("sandra");
		User diego = new User("diego");
		User carlos = new User("carlos");
		
		
		//Lista usuarios Red social
		UL.getUsersList().add(pepe);
		UL.getUsersList().add(manolita);
		UL.getUsersList().add(juan);
		UL.getUsersList().add(julia);
		UL.getUsersList().add(sandra);
		UL.getUsersList().add(diego);
		UL.getUsersList().add(carlos);
		
		//seguidores de pepe
		List<User> followedpepe = new ArrayList<>();
		followedpepe.add(manolita);
		followedpepe.add(diego);
		pepe.setFriendList(followedpepe);
		
		//seguidores de manolita
		List<User> followedmanolita = new ArrayList<>();
		followedmanolita.add(juan);
		followedmanolita.add(diego);
		manolita.setFriendList(followedmanolita);
		
		//Post de pepe
		Post imagpepe = new PhotoPost(LocalDate.of(2022, 5, 4), pepe, new ArrayList<Comment>(),  "Selfie.jpg", 1230, 1480);
		Post textpepe = new TextPost(LocalDate.of(2022,8, 9), pepe, new ArrayList<Comment>(), "Hoy salí de acampada");
		List<Post> postlistpepe = new ArrayList<>();
		postlistpepe.add(imagpepe);
		postlistpepe.add(textpepe);
		
		//Comentarios Post de pepe
		Comment commenttextpepediego = new Comment("Menuda suerte!", LocalDate.of(2022, 4, 2), diego);
		Comment commenttextpepemanolita = new Comment("Espero que no lloviese", LocalDate.of(2022, 4, 2), manolita);
		
		List<Comment> commentList = new ArrayList<>();
		commentList.add(commenttextpepemanolita);
		commentList.add(commenttextpepediego);
		
		textpepe.setCommentList(commentList);
		
		
		// Menú principal
		
		boolean exit = false;			
		User SelectedUser = new User("");
		SelectedUser = null;
		String userName = null;
		
		User userFriend = new User("");
		userFriend = null;
		String friendName = null;
		int postNumber = 0;
		int commentNumber = 0;
		
		PostsList PL = new PostsList();
		
		
		System.out.println("¡Bienvenido a DualGram!");
		do {
			System.out.println("Selecciona una opción: ");
			System.out.println("(1) Login \n(2) Crear nuevo usuario \n(3) Eliminar usuario \n(4) Lista de usuarios \n(9) Salir");
			
			int option = keyBoard.nextInt();
			
			switch (option) {
				case 1:
					keyBoard.nextLine();
					System.out.println("Introduce nombre de usuario");
					userName = keyBoard.nextLine();
					SelectedUser = UL.selectedUser(userName);
					
					if(SelectedUser != null ) {

						//Menú usuario registrado
						System.out.println("Bienvenido " + SelectedUser.getUserName());
						SelectedUser.recommendFriends();
//						SelectedUser.userWall(PL);
						
						
						do {
							System.out.println("Selecciona una opción");
							System.out.println("(1) Añadir un amigo   (2) Eliminar un amigo de la lista   (3) Lista de amigos "
									+ "\n(4) Crear una publicación   (5) Eliminar una publicación   (6) Ver mis publicaciones"
									+ "\n(7) Comentar una publicación   (8) Eliminar un comentario"
									+ "\n(9) Logout");

							option = keyBoard.nextInt();
							switch (option) {
							case 1: 
								keyBoard.nextLine();
								System.out.println("Introduce nombre de usuario");
								friendName = keyBoard.nextLine();
								
								if(UL.selectedUser(friendName) != null) {
									SelectedUser.getFriendList().add(UL.selectedUser(friendName));
									System.out.println(friendName + " Ha sido añadido a la lista de amigos de " + userName);
								} else {
									System.out.println("El usuario seleccionado no existe.");
								}
								
								break;
								
							case 2:
								keyBoard.nextLine();
								System.out.println("Introduce nombre de usuario");
								friendName = keyBoard.nextLine();
								
								if(SelectedUser.getFriendList().contains(UL.selectedUser(friendName) )) {
									SelectedUser.getFriendList().remove(UL.selectedUser(friendName));
									System.out.println(friendName + " ha sido eliminado de tu lista de amigos.");
								} else {
									System.out.println("El usuario seleccionado ya no estaba en tu lista de amigos");
								}
								break;
								
							case 3:
								for (User s : SelectedUser.getFriendList()) {
									System.out.println(s.getUserName());
								}
								break;
								
							case 4: 
								System.out.println("Elige tipo de publicación:");
								System.out.println("(1) Texto, (2) Imagen, (3) Video, (9) Cancelar");
								int optionPost = keyBoard.nextInt();
								
								//Menú Posts
								switch(optionPost) {
								case 1:
									keyBoard.nextLine();
									System.out.println("Escribe tu publicación: ");
									String content = keyBoard.nextLine();
									
									Post TP = new TextPost(LocalDate.now(), SelectedUser, new ArrayList<Comment>(), content);
									SelectedUser.getPostList().add(TP);
									
									PL.getPostsList().add(TP);
									
									break;
								case 2:
									keyBoard.nextLine();
									System.out.println("Título de la foto: ");
									String photoTitle = keyBoard.nextLine();
									
									//keyBoard.nextInt();
									System.out.println("Ancho de la foto: ");
									int photoWidth = keyBoard.nextInt();
									
									//keyBoard.nextInt();
									System.out.println("Alto de la foto: ");
									int photoHeight = keyBoard.nextInt();
									
									Post PP = new PhotoPost(LocalDate.now(), SelectedUser, new ArrayList<Comment>(), photoTitle, photoWidth, photoHeight);
									SelectedUser.getPostList().add(PP);
									
									PL.getPostsList().add(PP);
									
									break;
								case 3:
									keyBoard.nextLine();
									System.out.println("Título del vídeo: ");
									String videoTitle = keyBoard.nextLine();
									
									//keyBoard.nextLine();
									System.out.println("Calidad del vídeo: ");
									String videoQuality = keyBoard.nextLine();
									
									System.out.println("Duración del vídeo: ");
									int videoLength = keyBoard.nextInt();
									
									Post VP = new VideoPost(LocalDate.now(), SelectedUser, new ArrayList<Comment>(), videoTitle, videoQuality, videoLength);
									SelectedUser.getPostList().add(VP);
									
									PL.getPostsList().add(VP);
									
									break;
								case 9:
									break;
								}
								break;
								
								
							case 5:
								System.out.println("Elige la publicación que deseas eliminar: ");
								SelectedUser.postsList();
								System.out.println("0. - Para salir");
								postNumber = keyBoard.nextInt();
								SelectedUser.removePost(postNumber);				
								
								break;
								
							case 6:
								System.out.println("Elige la publicación que quieras ver: ");
								SelectedUser.postsList();
								System.out.println("0. - Para salir");
								postNumber = keyBoard.nextInt();
								
								if (postNumber != 0) {
									SelectedUser.getPostList().get(postNumber-1).viewComments();
									System.out.println("Elige el comentario que quieras eliminar: ");
									System.out.println("0. - Para salir");
								}
								commentNumber = keyBoard.nextInt();
								if (postNumber != 0) {
									//								SelectedUser.getPostList().get(postNumber-1).getCommentList().get(commentNumber-1)
									//								SelectedUser.getPostList().get(postNumber-1).getCommentList().remove(commentNumber-1);								
									SelectedUser.getPostList().get(postNumber-1).getCommentList().get(commentNumber-1).getCommentUser().removeComment(postNumber, SelectedUser);
								}
								
								break;
								
							case 7:
								keyBoard.nextLine();
								System.out.println("¿A quién le quieres dejar un comentario?");
								friendName = keyBoard.nextLine();
								
								System.out.println("Estos son los post de " + friendName + ". Selecciona uno.");
								UL.selectedUser(friendName).postsList();
								postNumber = keyBoard.nextInt();
								
								keyBoard.nextLine();
								System.out.println("Deja aquí tu comentario: ");
								String userComment = keyBoard.nextLine();
								
								Comment myComment = new Comment(userComment, LocalDate.now(), SelectedUser);
								UL.selectedUser(friendName).getPostList().get(postNumber-1).getCommentList().add(myComment);
								SelectedUser.getCommentList().add(myComment);
								SelectedUser.getcommentedFriendsList().add(UL.selectedUser(friendName));
								SelectedUser.getCommentedPostsList().add(UL.selectedUser(friendName).getPostList().get(postNumber-1));
								UL.selectedUser(friendName).getPostList().get(postNumber-1).viewComments();
								
								break;
								
							case 8:
								
								System.out.println("Elige el comentario que deseas eliminar: ");
								SelectedUser.viewCommentList();
								System.out.println("0. - Para salir");
								commentNumber = keyBoard.nextInt();
								if (commentNumber != 0) {
									SelectedUser.removeComment(commentNumber, SelectedUser.getcommentedFriendsList().get(postNumber));	
								}
								
								break;
								
							case 9:
								exit = true;
								break;
								
							}
							
						} while(!exit);
						exit = false;
					} else {
						System.out.println("El usuario seleccionado no existe");
					}
					
					if(SelectedUser !=null) {
						
					
					}
					break;
					
				case 2:
					keyBoard.nextLine();
					System.out.println("Introduce nombre de usuario");
					userName = keyBoard.nextLine();
					
					if(UL.selectedUser(userName) == null) {
						SelectedUser = new User(userName);
						UL.getUsersList().add(SelectedUser);
						System.out.println("El usuario " + userName + " ha sido creado");
					} else {
						System.out.println("El nombre de usuario ya existe.");
					}
					
					break;
					
				case 3:
					keyBoard.nextLine();
					System.out.println("Introduce nombre de usuario");
					userName = keyBoard.nextLine();
					
					if(UL.selectedUser(userName) != null) {
						SelectedUser = UL.selectedUser(userName);
						UL.getUsersList().remove(SelectedUser);
						System.out.println(userName + " ha sido eliminado.");
					} else {
						System.out.println("El usuario que intentas eliminar no existe.");
					}
							
					break;
					
				case 4:
					for (User s: UL.getUsersList()) {
						System.out.println(s.getUserName());
					}
					
					break;
					
				case 9:
					exit=true;
					break;
			}
			
			
		} while(!exit);
				
				
				
				
				
				
				
				
		
		
		
	}
	
	
	
	

}
