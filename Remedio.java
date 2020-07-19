package tp;

public abstract class Remedio {

	private int id;
	private String descripcion;
	private int stock;
	
	public Remedio(int id, String descripion, int stock) 
	{
		this.id = id;
		this.descripcion = descripion;
		this.stock = stock;
	}
	
	public boolean sos(int valor)
	{
		return id == valor;
	}

	public int getStock() 
	{
		return stock;
	}
	
	public void mostraStock()
	{
		System.out.println("- ID: "+id+" - Descripcion: "+descripcion+" - Stock: "+ stock);
	}
	
	public void agregarStock(int val)
	{
		this.stock += val;
	}
	
	public void descontarStock(int val)
	{
		this.stock -= val;
	}
	
	public int darID()
	{
		return id;
	}
	
	public String darDescripcion()
	{
		return descripcion;
	}

	public abstract double darValor();
	
	public abstract boolean sosVacuna();
	
	
}
