package tp;

import java.util.*;

public class Vacuna extends Remedio {
	
	private double valor;
	private int dosis;
	
	public Vacuna(int id, String descripion, int stock, double valor,
			int dosis) {
		super(id, descripion, stock);
		this.valor = valor;
		this.dosis = dosis;
	}
	
	public void mostraStock()
	{
		System.out.print("Vacuna      ");
		super.mostraStock();
	}
	
	public double darValor()
	{
		return this.valor;
	}
	
	public boolean sosVacuna()
	{
		return true;
	}

}
