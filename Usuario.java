package tp;

public abstract class Usuario 
{
	private String nombreUsuario;
	private String contrasena;
	private String denominacion;

	public Usuario(String nombreUsuario, String contrasena, String denominacion)
	{
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.denominacion = denominacion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public boolean sos(String valor){
		return nombreUsuario.equalsIgnoreCase(valor);
	}

	public void mostrarDatos(){
		System.out.printf("Usuario: %s - Denominaci�n: %s \n", this.getNombreUsuario(), this.getDenominacion());
	}
	
	public boolean validarUsuario(String nombreUsuario)
	{
		return this.getNombreUsuario().equalsIgnoreCase(nombreUsuario);
	}
	
	public boolean validarPass(String contrasena)
	{
		return this.getContrasena().equalsIgnoreCase(contrasena);
	}

	public boolean sosSuperUsuario()
	{
		return false;
	}

}
