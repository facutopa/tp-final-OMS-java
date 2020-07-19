package tp;

import java.util.*;

public class CajaTipo {
	
	private int id;
	private Enfermedad enfermedad;
	private Hashtable<Remedio, Integer> remediosCaja;
	
	public CajaTipo(int id, Enfermedad enfermedad, Hashtable<Remedio, Integer> remediosCaja)
	{
		
		this.id = id;
		this.enfermedad = enfermedad;
		this.remediosCaja = remediosCaja; 
		
	}
	
	public boolean sos(int valor)
	{
		return id == valor;
	}
	
	
	// CU 7
	public Hashtable<Remedio, Integer> getremedioCaja() 
	{
		return remediosCaja;
	}
	
	public boolean validarStock()
	{
		Enumeration<Remedio> enuRem = remediosCaja.keys(); 
		Remedio remedio; //
		boolean ok = true;
		int ctdCaja = 0;
		
		while (enuRem.hasMoreElements() && ok == true)
		{
			remedio = enuRem.nextElement();
			ctdCaja = remediosCaja.get(remedio);
			if(remedio.getStock() < ctdCaja)
			{
				ok = false;
			}
		}
		return ok;
	}
	
	public double armarCaja()
	{
		Enumeration<Remedio> enuRem = remediosCaja.keys(); 
		Remedio remedio;
		int ctdCaja = 0;
		double valor=0;
		
		while (enuRem.hasMoreElements())
		{
			remedio = enuRem.nextElement();
			ctdCaja = remediosCaja.get(remedio);
			valor += (remedio.darValor()*ctdCaja); 
			remedio.descontarStock(ctdCaja);
		}
		return valor;
	}
		
	public boolean noTieneStock ()
	{
		Enumeration<Remedio> enuRem = remediosCaja.keys(); 
		Remedio remedio; 
		int stock = 0; 
		boolean val = false;
		while (enuRem.hasMoreElements()) 
		{
			remedio = enuRem.nextElement();
			stock = remedio.getStock();
			if(stock==0)
				val= true;
		}
		return val;

	}
	
	
	public int getId() {
		return id;
	}
	
	public void listarRemedios()
	{
		Enumeration<Remedio> enuRem = remediosCaja.keys();
		Remedio remedio;
		while(enuRem.hasMoreElements())
		{
			remedio = enuRem.nextElement();
			System.out.println("-  Remedio: "+ remedio.darID()+" - "+remedio.darDescripcion()+" | Cantidad: "+ remediosCaja.get(remedio));
		}
	}
	
	public void modificarCantidad(Remedio rem, int cant)
	{
		
		
		if(remediosCaja.containsKey(rem))
		{
			System.out.println("Se actualizo a la cantidad: "+ cant +" al Remedio: "+ rem.darDescripcion());
		}
		else
		{
			System.out.println("Se agrego el remedio: "+ rem.darDescripcion() +" con la cantidad: "+ cant);
		}
		remediosCaja.put(rem, cant);
		
	}
	

	public void tieneVacuna()
	{
		Enumeration<Remedio> enuRem = remediosCaja.keys();
		boolean conVacuna = false;
		Remedio remedio;
		while(enuRem.hasMoreElements())
		{
			remedio = enuRem.nextElement();
			if(remedio.sosVacuna()==true)
				conVacuna = true;
		}	
		if(conVacuna)
			System.out.println("La Enfermedad: "+ enfermedad.darID() +" - "+ enfermedad.darNombre()+" tiene vacuna.");	
	}
	
	public String mostrarEnfermedad()
	{
		return enfermedad.darNombre();
	}
	
	
	

}
