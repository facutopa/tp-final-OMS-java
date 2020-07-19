package tp;

public class Admin extends Usuario
{
	public Admin(String nombreUsuario, String contrasena, String denominacion) {
		super(nombreUsuario, contrasena, denominacion);
		// TODO Auto-generated constructor stub
	}

	public boolean sosSuperUsuario()
	{
		return true;
	}

}
