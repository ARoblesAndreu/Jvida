package modelo;

/**
 * Proyecto: Juego de la vida. Implementa el concepto de Usuario según el
 * modelo1. En esta versión no se han aplicado la mayoría de los estándares de
 * diseño OO dirigidos a conseguir un "código limpio". La implementación es
 * básica con el fin ilustrar cómo se evoluciona desde un "código malo". Se
 * pueden detectar varios defectos y antipatrones de diseño: - Obsesión por los
 * tipos primitivos.
 * 
 * @since: prototipo1.0
 * @source: Usuario.java
 * @version: 1.1 - 2017/01/21
 * @author: ajp
 */

public class Usuario {

	public static final String[] ROLES = { "NORMAL", "INVITADO",
			"ADMINISTRADOR" };
	// Apartado 2:
	private Nif nif;
	private String nombre;
	private String apellidos;
	private String idUsr;
	private String domicilio;
	private Correo correo;
	private String fechaNacimiento;
	private String fechaAlta;
	private ClaveAcceso claveAcceso;
	private String rol;

	/**
	 * Constructor convencional. Utiliza métodos set...()
	 * 
	 * @param nif
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param correo
	 * @param fechaNacimiento
	 * @param fechaAlta
	 * @param claveAcceso2
	 * @param rol
	 */
	public Usuario(Nif nif, String nombre, String apellidos,
			String domicilio, Correo correo, String fechaNacimiento,
			String fechaAlta, ClaveAcceso claveAcceso, String rol) {
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

	// Apartado 4:
	/**
	 * Genera el idUsr con las letras iniciales del nombre, primer y segundo
	 * apellido; seguido del el último dígito del dni y la letra del nif.
	 */
	private void generarIdUsr() {
		if (nombre != null && apellidos != null && nif != null) {
			String idUsr = "" + nombre.charAt(0) + apellidos.charAt(0)
					+ apellidos.charAt(apellidos.indexOf(" ") + 1)
					+ Nif.getTexto().substring(7);
			this.idUsr = idUsr;
		}
	}

	/**
	 * Genera una variante cambiando la última letra del idUsr por la siguiente
	 * en el alfabeto.
	 */
	public void generarVarianteIdUsr() {
		String alfabetoNif = "ABCDEFGHJKLMNPQRSTUVWXYZ";
		String letraNueva;
		if (idUsr != null) {
			String letraAnterior = "" + idUsr.charAt(4);
			if (idUsr.charAt(4) == 'Z') {
				letraNueva = "" + 'A';
			} else {
				letraNueva = ""
						+ alfabetoNif
								.charAt(alfabetoNif.indexOf(letraAnterior) + 1);
			}
			idUsr = idUsr.substring(0, 4) + letraNueva;
		}
	}

	// Apartado 2:
	/**
	 * Constructor por defecto. Utiliza constructor convencional.
	 */
	public Usuario() {
		this(new Nif(), "Nombre", "Apellidos1 Apellido2", "Domicilio",
				new Correo(), "2016.01.27", "2016.01.27",
				new ClaveAcceso("Miau#0"), ROLES[0]);
	}

	/**
	 * Constructor copia. Utiliza constructor convencional.
	 * 
	 * @param usr
	 */
	public Usuario(Usuario usr) {
		this(usr.getNif(), usr.nombre, usr.apellidos, usr.domicilio, usr.correo,
				usr.fechaNacimiento, usr.fechaAlta, usr.getClaveAcceso(),
				usr.rol);
	}

	public ClaveAcceso getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(ClaveAcceso claveAcceso) {
		this.claveAcceso = claveAcceso;

	}

	// Apartado 2:
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (NombreValido(nombre)) {
			this.nombre = nombre;
		}
	}

	// Apartado 6:
	private boolean NombreValido(String nombre) {
		if (nombre != null) {
			return nombre.matches("^[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+");
		}
		return false;
	}

	// Apartado 2:
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Nif getNif() {
		return nif;
	}

	public void setNif(Nif nif) {
		this.nif = nif;
	}

	public String getIdUsr() {
		return idUsr;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Correo getCorreo() {
		return correo;
	}

	public void setCorreo(Correo correo) {
			this.correo = correo;
	}

	// Apartado 2:
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
		this.rol = rol.toUpperCase();
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * 
	 * @return el texto formateado del estado -valores de atributos- de objeto
	 *         de la clase Usuario.
	 */
	@Override
	public String toString() {
		return String.format("%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n"
				+ "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n"
				+ "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n", "nif:", nif,
				"nombre:", nombre, "apellidos:", apellidos, "idUsr:", idUsr,
				"domicilio:", domicilio, "correo:", correo, "fechaNacimiento:",
				fechaNacimiento, "fechaAlta:", fechaAlta, "claveAcceso:",
				claveAcceso, "rol:", rol);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (nif.equals(((Usuario) obj).nif)
					&& nombre.equals(((Usuario) obj).nombre)
					&& apellidos.equals(((Usuario) obj).apellidos)
					&& idUsr.equals(((Usuario) obj).idUsr)
					&& domicilio.equals(((Usuario) obj).domicilio)
					&& correo.equals(((Usuario) obj).correo)
					&& fechaNacimiento.equals(((Usuario) obj).fechaNacimiento)
					&& fechaAlta.equals(((Usuario) obj).fechaAlta)
					&& claveAcceso.equals(((Usuario) obj).claveAcceso)
					&& rol.equals(((Usuario) obj).rol)) {
				return true;
			}
		}
		return false;
	}
} // class
