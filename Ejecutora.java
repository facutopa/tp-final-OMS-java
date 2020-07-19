package tp;

import java.util.Scanner;



public class Ejecutora {

	public static void main(String[] args) 
	{
		Oms o = new Oms();
		
		Scanner entrada = new Scanner(System.in);
		entrada.useDelimiter(System.getProperty("line.separator"));
		
		byte opc = 0;
		o.precargoAdmin();
		do 
		{
			System.out.println(" --- OMS --- ");
			System.out.println("1 - Ingresar");
			System.out.println("2 - Salir");
			opc = entrada.nextByte();
	
			switch (opc) 
			{
				case 1:
				{
					o.logIn();
				}break;
				default:
					break;
			}
		}while (opc != 2);
		
	}
}
	

