package tp;


public class Pedido {

	 private int id;
	 private Fecha fecha;
	 private int cantSolicitada;
	 private Envio envio;
	 private Enfermedad enfermedad;
	 private Pais paisDestino;
	 
	

	public Pedido (int id, int cantSolicitada, Enfermedad enfermedad, Pais paisDestino)
	{
		
		this.id = id;
		this.fecha = Fecha.hoy();
		//PARA PRUEBAS SE CREO LA SIGUIENTE LINEA PARA CREAR ENVIOS MAYORES A LOS ULTIMOS 3 ANIOS
		//this.fecha = new Fecha(01,01,2016);
		this.cantSolicitada = cantSolicitada;
		this.enfermedad = enfermedad;
		this.paisDestino = paisDestino;
	}
	
	public boolean sos(int valor)
	{
		return id == valor;
	}
	 
	public void setCantSolicitada(int val)
	{
		cantSolicitada = val;
	}
	
	public int darID()
	{
		return this.id;
	}
	
	public boolean check3anios()
	{
		Fecha hoy = fecha.hoy();
		int tresAnios = hoy.getAn() - 3;
		return ( this.fecha.getAn() >= tresAnios );
	}
	
	public Pais getPaisDestino()
	{
		return paisDestino;
	}
	
	public void setPaisDestino(Pais p)
	{
		paisDestino = p;
		System.out.println("Se actualizo el Pais de Destino. El nuevo es: "+ p.darNombre());
	}
	
	public int getCantSolicitada()
	{
		return cantSolicitada;
	}
	
	public void darFecha()
	{
		System.out.print(fecha.getDia()+"/"+fecha.getMes()+"/"+fecha.getAn());
		
	}
	
	public void agregarEnvio(Envio env)
	{
		envio = env;
	}
	
	public boolean tieneEnvio() 
	{
		return envio!=null;
	}
		 
	public CajaTipo getCajaTipo()
	{
		return this.enfermedad.getCajaTipo();
	}
	
	public void modificarEnfermedad(Enfermedad e)
	{
		this.enfermedad = e;
		System.out.println("Se actualizo la Enfermedad del Pedido. La nueva Enfermedad es: "+e.darID()+" - " +e.darNombre());
	}
	
	public Enfermedad getEnfermedad()
	{
		return enfermedad;
	}
	
}
