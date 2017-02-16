package modelo;

/**
 * Proyecto: Juego de la vida. Implementa el concepto de Nif según el modelo 1.2
 * 
 * @author daw16-19 @ *
 */
public class Nif {
	private String texto;

	public Nif(Nif nif) {
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (texto.equals(((Nif) obj).texto)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Nif clone() {
		return new Nif(this);
	}
}// class
