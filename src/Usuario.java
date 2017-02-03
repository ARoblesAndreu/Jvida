
/**
 * Proyecto: Juego de la vida. Implementa el concepto de Usuario según el
 * modelo1. En esta versión no se han aplicado la mayoría de los estándares de
 * diseño OO dirigidos a conseguir un "código limpio". La implementación es la
 * más básica posible con el fin ilustrar cómo se evoluciona desde un
 * "código malo". Se pueden detectar varios defectos y antipatrones de diseño: -
 * Ausencia de encapsulación. - Clase sólo de datos. - Obsesión por los tipos
 * primitivos.
 * 
 * @since: prototipo1.0
 * @source: Usuario.java
 * @version: 1.0 - 2016/12/8
 * @author: ajp
 */

public class Usuario {

	// Atributos
	private String nif;
	private String nombre;
	private String apellidos;
	private String idUsr;
	private String domicilio;
	private String correo;
	private String fechaNacimiento;
	private String fechaAlta;
	private String claveAcceso;
	private String rol;

	/**
	 * @param nif
	 * @param nombre
	 * @param apellidos
	 * @param idUser
	 * @param domicilio
	 * @param correo
	 * @param fechaNacimiento
	 * @param fechaAlta
	 * @param claveAcceso
	 * @param rol
	 */
	public Usuario(String nif, String nombre, String apellidos, String idUser,
			String domicilio, String correo, String fechaNacimiento,
			String fechaAlta, String claveAcceso, String rol) {
		super();
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		generarIdUsr();
		setDomicilio(domicilio);
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setFechaAlta(fechaAlta);
		setClaveAcceso(claveAcceso);
		setRol(rol);
	}

	// Apartado4
	

	private void generarIdUsr() {
		String idUsr = "" + nombre.charAt(0) + apellidos.charAt(0)
				+ apellidos.charAt(apellidos.indexOf(" ") + 1)
				+ nif.substring(7);
			this.idUsr = idUsr;
	}//generarIdUsr
	public void generarVarianteIdUsr(){
		String alfabetoNif = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String letraNueva;
		String letraAnterior = "" + idUsr.charAt(4);
		if (idUsr.charAt(4) == 'Z'){
			letraNueva = "" + 'A';
		}//if
		else{
			letraNueva = "" + alfabetoNif.charAt(alfabetoNif.indexOf(letraAnterior));
		}//else
		idUsr = idUsr.substring(0,4)+letraNueva;
	}//generarVarianteIdUsr
	

	public Usuario(){
		this("23456790K" , "Pepe" , "López Pérez" , "C/Luna, 27 30132 Murcia" , "pepe"+"@gmail.com" , "1990.11.12" , "2016.12.3"
				+ "Miau#0" , "usuario normal");
	}

	public Usuario(String string, String string2, String string3,
			String string4, String string5, String string6, String string7,
			String string8) {
		// TODO Auto-generated constructor stub
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}
	
	private boolean nombreValido(String nombre){
		assert nombre != null;
		return nombre.matches("^[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+");
	}
	
	public void setNombre(String nombre) {
		if(nombreValido(nombre)){
		this.nombre = nombre;	
		}
		
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(String idUsr) {
		this.idUsr = idUsr;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		if (correoValido(correo)){
			this.correo = correo;
		}
		
	}
	
	private boolean correoValido(String correo){
		if (correo != null){
			return correo.matches("^[\\w-\\+]+(\\.[\\w-\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		}
		return false;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		if (contraseñaRobusta(claveAcceso)){
		this.claveAcceso = encriptarCesar(claveAcceso);
		}
	}
	
	private boolean contraseñaRobusta(String claveAcceso){
		if (claveAcceso != null){
			return claveAcceso.matches("([\\wñÑ$*#-+&!?]){5,}");
		}
		return false;
	}
	private String encriptarCesar(String claveEnClaro){
		String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789?$%&#";
		String alfabetoDesplazado = "FGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789?$%&#ABCDE";
		StringBuilder claveEncriptada = new StringBuilder();
		for (int i = 0; i <= claveEnClaro.length(); i++) {
			int posicion = alfabeto.indexOf(claveEnClaro.charAt(i));
			claveEncriptada.append(alfabetoDesplazado.charAt(posicion));
		}
		
		return claveEncriptada.toString();
	}
	
	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * 
	 * @return el texto formateado del estado -valores de atributos- de objeto
	 *         de la clase Usuario.
	 */
	@Override
	public String toString() {
		return super.toString()
				+ "\n" // Incluye identificador de objeto.
				+ "\n nif: \t\t" + getNif() + "\n nombre: \t" + getNombre()
				+ "\n apellidos: \t" + getApellidos() + "\n domicilio: \t"
				+ getDomicilio() + "\n idUsuario: \t" + getIdUsr()
				+ "\n correo: \t" + getCorreo() + "\n fechaNacimiento:"
				+ getFechaNacimiento() + "\n fechaAlta: \t" + getFechaAlta()
				+ "\n claveAcceso: \t" + getClaveAcceso() + "\n rol: \t\t"
				+ getRol();
	}

} // class

