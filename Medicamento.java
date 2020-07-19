package tp;

import java.util.*;

public class Medicamento extends Remedio {

	public Medicamento(int id, String descripion, int stock) {
		super(id, descripion, stock);
		
	}

	public double darValor() 
	{
		return 0;
	}
	
	public boolean sosVacuna()
	{
		return false;
	}
	
	public void mostraStock()
	{
		System.out.print("Medicamento ");
		super.mostraStock();
	}

	
}
