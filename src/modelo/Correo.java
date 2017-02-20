package modelo;

/**
 * 
 * Proyecto: Juego de la vida.
 * 
 * @since: prototipo1.1
 * @source: Usuario.java
 * @version: 1.1 - 2017/18/1
 * @author: ajp
 * 
 */
public class Correo {

	private String texto;

	public Correo(String texto) {
		setTexto(texto);
	}

	public Correo() {
		this("pepe@gmail.com");
	}

	public Correo(Correo Correo) {
		this(Correo.texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if (correoValido(texto)) {
			this.texto=texto ;
		}
	}

	private boolean correoValido(String texto) {
		if (texto != null) {
			return texto.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (texto.equals(((Correo) obj).texto)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return texto;
	}

	@Override
	public Correo clone() {
		return new Correo(this);
	}

} // class