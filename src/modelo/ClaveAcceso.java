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
public class ClaveAcceso {

	private String texto;

	public ClaveAcceso(String texto) {
		setTexto(texto);
	}

	public ClaveAcceso() {
		this("Miau#0");
	}

	public ClaveAcceso(ClaveAcceso ClaveAcceso) {
		this(ClaveAcceso.texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if (ClaveAccesoValida(texto)) {
			this.texto = encriptarCesar(texto);
		}
	}

	private boolean ClaveAccesoValida(String texto) {
		if (texto != null) {
			return texto.matches("([\\wñÑ$*-+&!?#]){5,}");
		}
		return false;
	}

	private String encriptarCesar(String texto) {
		String alfabetoNormal = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789?$%&#";
		String alfabetoDesplazado = "FGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789?$%&#ABCDE";
		StringBuilder claveEncriptada = new StringBuilder();
		for (int i = 0; i < texto.length(); i++) {
			int posicion = alfabetoNormal.indexOf(texto.charAt(i));
			claveEncriptada.append(alfabetoDesplazado.charAt(posicion));
		}
		return claveEncriptada.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (texto.equals(((ClaveAcceso) obj).texto)) {
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
	public ClaveAcceso clone() {
		return new ClaveAcceso(this);
	}

} // class