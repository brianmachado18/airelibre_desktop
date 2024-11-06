package servidor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import datatype.DtActividad;
import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.ws.Endpoint;
import logica.*;

@WebService
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) // Acceso a nivel de campo
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {

	 	Fabrica fab = Fabrica.getInstance();Fabrica fabrica = Fabrica.getInstance(); 
	 	IControladorUsuario ICU = fabrica.getIControladorUsuario();
	 	IControladorActividad ICA = fabrica.getIControladorActividad();
	 	IControladorClaseDeportiva ICC = fabrica.getIControladorClaseDeportiva();
	 	
	    private Endpoint endpoint = null;
	    //Constructor
	    public Publicador(){}

	    //OPERACIONES DE ICU

	    @WebMethod(exclude = true)
	    public void publicar(){
	         endpoint = Endpoint.publish("http://localhost:9139/publicador", this);
	    }

	    @WebMethod(exclude = true)
	    public Endpoint getEndpoint() {
	            return endpoint;
	    }
	    @WebMethod
	    public  String obtenerNickname(String mail) throws PersistenciaException{
	    	return ICU.obtenerNickname(mail);
	    }
	    @WebMethod
		public  boolean traerPass(String nickname, String pass) throws PersistenciaException{
	    	return ICU.traerPass(nickname, null, pass);
	    }
	    @WebMethod
		public  void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, String fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web, String imagen)throws PersistenciaException{
	    	   DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	           LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
	           
	    	ICU.AltaUsuario(nickname, contrasena, nombre, apellido, email, fecha, tipoUsuario, esProfesional, disciplina, web, imagen);
	    }

	    @WebMethod
		public  boolean usuarioExiste(String nickname) throws PersistenciaException{
	    	return ICU.usuarioExiste(nickname);
	    }
	    
	    @WebMethod
		public  boolean esEntrenador(String nickname) throws PersistenciaException{
	    	return ICU.esEntrenador(nickname);
	    }
	    @WebMethod
		public  DtEntrenador obtenerEntrenador(String nickname) throws PersistenciaException{
	    	return ICU.obtenerEntrenador(nickname);
	    }
	    @WebMethod
		public  DtDeportista obtenerDeportista(String nickname) throws PersistenciaException{
	    	return ICU.obtenerDeportista(nickname);
	    }

	    @WebMethod
		public  void modifiarUsuario(String nickname, String contrasena, String nombre, String apellido, String email, String fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException{
	    	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
	    	ICU.modifiarUsuario(nickname, contrasena, nombre, apellido, email, fecha, tipoUsuario, esProfesional, disciplina, web);
	    }
	    
	    //VECTORES
	    
	    @WebMethod
		public  Vector<String> obtenerVectorUsuarios() throws PersistenciaException{
			return ICU.obtenerVectorUsuarios();
		}
		
	    // OPERACIONES DE ICA
	    @WebMethod
	    public Vector<String> obtenerArrayActividadesEntrenador(String nickname){
	    	return ICA.obtenerArrayActividadesEntrenador(nickname);
	    }
	    
	    @WebMethod
	    public  Vector<String> obtenerArrayActividadesAceptadasEntrenador(String nickname){
	    	//System.out.println("ACT: " + ICA.obtenerArrayActividadesAceptadasEntrenador(nickname).get(0).get(0));
			return ICA.obtenerArrayActividadesAceptadasEntrenador(nickname);
			
		}
	    
	    @WebMethod
	    public boolean actividadExiste(String nom){
			return ICA.actividadExiste(nom);
		}
	    
	    @WebMethod
	    public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, String fAlta, String img, String nick) throws PersistenciaException{
	    	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate fecha = LocalDate.parse(fAlta, formatoFecha);
	        
	        DtEntrenador ent = ICU.obtenerEntrenador(nick);
	        
			ICA.AltaActividad(nombre, desc, dHoras, costo, lugar, fecha, img, ent);
		}
	    
	    @WebMethod
		public Vector<String> obtenerVectorActividad() throws PersistenciaException{
			return ICA.obtenerVectorActividades();
		}
	    
	    @WebMethod
		public DtActividad obtenerActividad(String nom) {
	    	 DtActividad aux = ICA.obtenerActividad(nom);
	    	 aux.setClasesDeportivas(null);
	    	 aux.setEntrenador(null);
	    	 return aux;
		}
	    
	    @WebMethod
		public Vector<String> obtenerVectorClasesActividad(String nom){
			return ICA.obtenerVectorClasesActividad(nom);
		}
	    
		//OPERACIONES DE ICC
		
	    @WebMethod
		public  Vector<String> obtenerClasesDeportista(String nickname){
			return ICC.obtenerClasesDeportista(nickname);
		}
	    @WebMethod
		public  Vector<String> obtenerInscrpcionesDeportista(String nickname){
			return ICC.obtenerInscrpcionesDeportista(nickname);
		}
		
}
