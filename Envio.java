package tp;

import java.util.*;

public class Envio {
	
	private int id;
	private Fecha fecha;
	private CajaTipo cajatipo;
	private int cant;
	private double valorTotal;
	private static double costoEnvio;
	
	public Envio(int id, CajaTipo cajatipo, int cant, double valorTotal)
	{
		
		this.id = id;
		this.fecha = Fecha.hoy();
		this.cajatipo = cajatipo;
		this.cant = cant;
		this.valorTotal = valorTotal;
	}
	
	public boolean sos(int valor)
	{
		return id == valor;
	}
	
	public static void setCostoEnvio(double val)
	{
		costoEnvio = val;
	}
	
	public int darID()
	{
		return this.id;
	}
	public void darFecha()
	{
		System.out.print(fecha.getDia()+"/"+fecha.getMes()+"/"+fecha.getAn());
		
	}
	public int darCant()
	{
		return this.cant;
	}
	public static double darCostoEnvio()
	{
		if(costoEnvio == 0)
		{
			Scanner entrada=new Scanner(System.in);
			System.out.println("Por favor, indique el Costo de Envio: ");
			double valor=entrada.nextInt();
			while(valor==0)
			{
				System.out.println("Por favor, indique el Costo de Envio diferente de 0: ");
				valor = entrada.nextInt();
			}
			Envio.setCostoEnvio(valor);
		}
		return costoEnvio;
	}
	
	public double darValorTotal()
	{
		return valorTotal;
	}

}
