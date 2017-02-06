/**
 * 
 * Proyecto: Juego de la vida. Implementa el concepto de Usuario según el
 * modelo1. En esta versión no se han aplicado la mayoría de los estándares de
 * diseño OO dirigidos a conseguir un "código limpio". La implementación es la
 * más básica posible con el fin ilustrar cómo se evoluciona desde un "código
 * malo". Se pueden detectar varios defectos y antipatrones de diseño: -
 * Ausencia de encapsulación. - Clase sólo de datos. - Obsesión por los tipos
 * primitivos.
 * 
 * @since: prototipo1.1
 * @source: Usuario.java
 * @version: 1.1 - 2017/18/1
 * @author: ajp
 * 
 */



import java.util.Random;

public class Usuario {

	private static final Usuario Usuario = null;
	// Atributos
	private String nif;
	private String nombre;
	private String apellidos;
	private String domicilio;
	private String correo;
	private String fechaNacimiento;
	private String fechaAlta;
	private String claveAcceso;
	private String rol;
	private String idUsr;
	
	// Apartado 2

	/**
	 * Constructor convencional.
	 * 
	 * @param nif
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param correo
	 * @param fechaNacimiento
	 * @param fechaAlta
	 * @param claveAcceso
	 * @param rol
	 * @param idUsr
	 */
	public Usuario(String nif, String nombre, String apellidos, String domicilio, String correo, String fechaNacimiento,
			String fechaAlta, String claveAcceso, String rol) {
	
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		setDomicilio(domicilio);
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setFechaAlta(fechaAlta);
		claveAcceso=encriptarCesar(claveAcceso);
		setClaveAcceso(claveAcceso);
		setRol(rol);
		generarIdUsr();

	}

			
		
		
	// Apartado 4
	private void generarIdUsr() {
		String id = "" + nombre.charAt(0) 
					+ apellidos.charAt(0) 
					+ apellidos.charAt(apellidos.indexOf(" ") + 1)
					+ nif.substring(nif.length() - 2);
		idUsr = id;	
		
		
		
		}// generarIdUsr

	
	public void generarVarianteIdUsr(String id) {
		int veces = 0;
		 String alfabeto = "ABCDEFGHIJKMNLÑOPQRSTUVWXYZ";
		 int posicion= alfabeto.indexOf(id.charAt(4));
		 StringBuilder idAux=new StringBuilder(id);
		
		
		idAux.setCharAt(4, alfabeto.charAt((posicion+1)%alfabeto.length()));	
		idUsr=idAux.toString();
					
	
		
	}// generarVarianteIdUsr
	
	

	public Usuario() {
		this("2344556K","Pepe","López Pérez","C/Luna, 27 30132 Murcia","pepe@gmail.com","1990.11.12","2014.12.3"
			,"Miau#0","usuario normal");

	}

	
	
	//	Apartado 5
	private String encriptarCesar(String claveEnClaro) {
		String alfabetoCesar = "abcdefghijklmnlñopqrstuvwxyz" 
				+ "ªº!|·#@$~%½&¬/{([)]=}?¿" + "0123456789" + "ABCDEFGHIJKMNLÑOPQRSTUVWXYZ";
		String alfabetoDesplazado = "fghijklmnlñopqrstuvwxyz" + "#@$~%½&¬/{([)]=}?¿" + "56789"
				+ "FGHIJKMNLÑOPQRSTUVWXYZ" + "abcdeªº!|·01234ABCDE";
		int desplazamiento=4;
		StringBuilder claveEncriptada = new StringBuilder();
		for (int i = 0; i < claveEnClaro.length(); i++) {
			int posicion=alfabetoCesar.indexOf(claveEnClaro.charAt(i));
			claveEncriptada.append(alfabetoDesplazado.charAt(posicion));
		}
		return claveEncriptada.toString();
	}
	
	// Apartado 2

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getCorreo() {
		return correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public String getRol() {
		return rol;
	}

	public String getIdUsr() {
		return idUsr;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	public boolean nifValido(String nif) {
		assert nif != null;

		return nif.matches("^[A-ZÑÁÉÍÓÚ][a-zñáóúíé \\d]+");

	}
	public void setNombre(String nombre) {
		assert nombre != null;
		if (nombreValido(nombre)) {

			this.nombre = nombre;
		}
	}

	public boolean nombreValido(String nombre) {
		assert nombre != null;

		return nombre.matches("^[A-ZÑÁÉÍÓÚ][a-zñáóúíé \\d]+");

	}
	public void setApellidos(String apellidos) {
		assert apellidos!=null;
		if (apellidosValidos(apellidos)) {
		this.apellidos = apellidos;
		}
	}
	public boolean apellidosValidos(String apellidos) {
		assert apellidos != null;

		return apellidos.matches("^[A-ZÑÁÉÍÓÚ][A-ZÑÁÉÍÓÚa-zñáóúíé \\d]+");

	}
	public void setDomicilio(String domicilio) {
		assert domicilio !=null;
		if(direccionValida(domicilio)){
		this.domicilio = domicilio;
		}
	}
	public boolean direccionValida(String domicilio) {
		assert domicilio != null;

		return domicilio.matches("^C/[,A-ZÑÁÉÍÓÚa-zñáóúíé \\d]+");

	}
	public void setCorreo(String correo) {
		if(correoValido(correo)){
		this.correo = correo;
		}
	}
	public boolean correoValido(String correo) {
		assert correo != null;

		return correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,})$");

	}
	public void setFechaNacimiento(String fechaNacimiento) {
		if (fechaNacimientoValida(fechaNacimiento)){
		this.fechaNacimiento = fechaNacimiento;
		}
	}
	public boolean fechaNacimientoValida(String fechaNacimiento) {
		assert fechaNacimiento != null;

		return fechaNacimiento.matches("\\d{4}.\\d{2}.\\d{2}");

	}
	public void setFechaAlta(String fechaAlta) {
		if(fechaAltaValida(fechaAlta)){
			this.fechaAlta = fechaAlta;
		}
	}
	public boolean fechaAltaValida(String fechaAlta) {
		assert fechaAlta != null;

		return fechaAlta.matches("\\d{4}.\\d{2}.\\d{1,2}");

	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}
	public boolean  contraseñaRobusta(String claveAcceso) {
		assert claveAcceso != null;

		return claveAcceso.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setIdUsr(String idUsr) {
		this.idUsr = idUsr;
	}

	@Override
	public String toString() {
		return 	"Usuario\n"
				+ "nif\t\t\t" + nif + "\n"
				+ "nombre\t\t\t" + nombre + "\n"
				+ "apellidos\t\t" + apellidos + "\n"
				+ "domicilio\t\t" + domicilio + "\n"
				+ "correo\t\t\t" + correo+ "\n"
				+ "fechaNacimiento\t\t" + fechaNacimiento + "\n"
				+ "fechaAlta\t\t" + fechaAlta + "\n"
				+ "claveAcceso\t\t" + claveAcceso+ "\n"
				+ "rol\t\t\t" + rol + "\n"
				+ "idUsr\t\t\t" + idUsr + "\n";
	}

	
} // class