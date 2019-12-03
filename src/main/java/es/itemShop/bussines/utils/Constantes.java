package es.itemShop.bussines.utils;


public class Constantes {
	//Tipos de usuario
	public static final String ADMIN 						= "ADMIN";
	public static final String USER 	    				= "USER";
	
	//Añadir rol de seguridad
		//Grupos de usuarios
		public static final String USER_ALLOW_ALL          = "hasAnyRole('ADMIN', 'USER')";
		public static final String USER_ALLOW_ALL_REG      = "hasAnyRole('ADMIN')";
		
		//Usuarios solo
		public static final String USER_ALLOW_ADMIN         = "hasAuthority('ADMIN')";
		public static final String USER_ALLOW_USER       	= "hasAuthority('USER')";
}
