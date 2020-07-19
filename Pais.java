package tp;

public class Pais {
	
	private String id;
	private String nombre;
	
	public Pais(String id, String nombre) {
	
		this.id = id;
		this.nombre = nombre;
	}
	
	public boolean sos(String valor)
	{
		return id.equalsIgnoreCase(valor);
	}
	
	public String darNombre()
	{
		return nombre;
	}
	
	public String darID()
	{
		return id;
	}

}
