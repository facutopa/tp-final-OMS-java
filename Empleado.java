package tp;

public class Empleado extends Usuario
{

	public Empleado(String nombreUsuario, String contrasena, String denominacion) {
		super(nombreUsuario, contrasena, denominacion);
		// TODO Auto-generated constructor stub
	}
	
	public boolean sosSuperUsuario()
	{
		return false;
	}
	
	
	
}
