package aleatorio;



/**
 * @author Eva Royo
 *
 */
public class Persona {

	protected int edad;
	protected String nombre;

	public Persona(int edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		
	
	@Override
	public boolean equals(Object otraCosa) {
		// TODO Auto-generated method stub
	       if (otraCosa == null) {
	            return false;
	        }

	        if (otraCosa.getClass() != this.getClass()) {
	            return false;
	        }

	        if (((Persona)otraCosa).getNombre() == null) {
	            return false;
	        }

	        if (((Persona)otraCosa).getNombre().equalsIgnoreCase(this.getNombre())) {
		        if (this.edad != ((Persona)otraCosa).edad) {
		            return false;
		        }
	        }

	        return true;
	}
	
	@Override
	public int hashCode() {
		//tengo que generar un entero que sea único basado en las propiedades de este objeto
		// me puedo inventar la manera, siempre que se genere un número diferente
	    int hash=3;
	    hash = (hash + this.getEdad()) * this.getNombre().hashCode();   
	    return hash;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (this.getNombre() + " tiene " + this.getEdad());		
	}
}
