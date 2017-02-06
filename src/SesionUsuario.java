/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de SesionUsuario según el modelo1
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  La implementación es la más básica posible con el fin ilustrar 
 *  cómo se evoluciona desde un "código malo".
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Ausencia de encapsulación.
 *  	- Clase sólo de datos.
 *  @since: prototipo1.1
 *  @source: SesionUsuario.java 
 *  @version: 1.1 - 2017/18/1 
 *  @author: ajp
 */



public class SesionUsuario {
	
	// Atributos	
	private Usuario usr;   //materializa la relación de composición del modelo UML
	private String fecha; 
	
	public SesionUsuario(Usuario usu,String fech){
		
		this.usr=usu;
		this.fecha=fech;
	}
	
	
	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * de objeto de la clase SesionUsuario  
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" 			// Incluye identificador de objeto
				+ "\n" + getUsr()
				+ "\n fecha:" + getFecha();
	}
	//Apartado3
	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario user) {
		usr = user;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String date) {
		fecha = date;
	}

} // class