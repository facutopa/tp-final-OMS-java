package tp;

public class Enfermedad 
{

	private int id;
	private String nombre;
	private CajaTipo cajaTipo;

	
	public CajaTipo getCajaTipo() {
		return cajaTipo;
	}

	public Enfermedad(int id, String nombre) 
	{
		
		this.id = id;
		this.nombre = nombre;
	}
	
	public boolean sos(int valor)
	{
		return id == valor;
	}
	
	public void agregarCaja(CajaTipo caja)
	{
		cajaTipo = caja;
	}
	
	public String darNombre()
	{
		return nombre;
	}
	
	public CajaTipo darCajaTipo()
	{
		return cajaTipo;
	}
	
	public int darID()
	{
		return id;
	}
	
	public boolean noTenesStock()
	{
		return cajaTipo.noTieneStock();
	}
	

	
}
