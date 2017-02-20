package modelo;

/**
 * Proyecto: Juego de la vida. Implementa el concepto de Nif según el modelo 1.2
 * 
 * @author daw16-19 @ *
 */
public class Nif {
	private String texto;

	public Nif(String texto){
		setTexto(texto);
	}
	
	public Nif(){
		this("00000000T");
	}
	
	public Nif(Nif nif) {
	this(nif.texto);
	}

	public String getTexto(){
		return texto;
	}

	@Override
	public String toString() {
		return texto;
	}

	public void setTexto(String texto){
		if (nifValido(texto)){
			this.texto=texto;
		}
	}
	
	private boolean nifValido(String texto) {
		if (texto != null) {
			return texto.matches("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]")
					&& letraNIFValida(texto);
		}
		return false;
	}
	
	private boolean letraNIFValida(String texto){
		int numeroNIF = Integer.parseInt(texto.substring(0,8));
		if(texto.charAt(8)== "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numeroNIF % 23)){
			return true;
		}
		return false;
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
