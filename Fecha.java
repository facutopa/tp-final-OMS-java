package tp;

import java.util.Scanner;
import java.util.Calendar; 



public class Fecha {
	private int dia,mes,anio;
	public Fecha(int d,int m,int a){
		dia=d;
		mes=m;
		anio=a;		
	}
	public boolean estaVacia() {
         if(dia == 0  &&  mes == 0  && anio == 0)
             return true;
         else
             return false;
      }

      public static Fecha hoy() {
	  Calendar fecha = Calendar.getInstance();
	  int dd   = fecha.get(fecha.DAY_OF_MONTH);
	  int mm   = fecha.get(fecha.MONTH) + 1;
	  int aaaa = fecha.get(fecha.YEAR);
		
        Fecha hoy = new Fecha(dd, mm, aaaa);
        return hoy;
	}


      public static Fecha nueva() {
        Scanner entrada = new Scanner(System.in);
        int dd, mm, aaaa;
        boolean valida = false;
        do {
        	do {
                System.out.print("Ingrese dia");
                dd = entrada.nextInt();
        	}
        	while((dd < 01) || (dd > 31));
        	do {
                System.out.print("Ingrese mes");
                mm = entrada.nextInt();
        	}
        	while((mm < 01) || (mm > 12));
        	do {
                System.out.print("Ingrese año (AAAA)");
                aaaa = entrada.nextInt();
        	}
        	while((aaaa < 1492) || (aaaa > 2050));
        	
        	if(mm == 02)
        		if(dd > 29)
        			valida = false;
        		else {
        			if(dd < 29)
        				valida = true;
        			else {
        				if((aaaa % 4) == 0) 
   if(((aaaa % 100) == 0) && ((aaaa % 400) == 0))
        					valida = true;
					   else
                                    valida = false;
        				else
        				   valida = false;
        			}
        		}
        	else {
        		if((mm == 04) || (mm == 06) || (mm == 9) || (mm == 11))
        			if(dd > 30)
        				valida = false;
        			else
        				valida = true;
        		else {
        			valida = true;
        		}
        	}
        }
        while(valida == false);
        Fecha nueva = new Fecha(dd, mm, aaaa);
        return nueva;
      } 
      
      public int getDia(){
  		return dia;
  	}
  	
  	public int getMes(){
  		return mes;
  	}
  	
  	public int getAn(){
  		return anio;
  	}
  	
      public static boolean compareDate(Fecha fecha1, Fecha fecha2){
  		
  		boolean igual=true;
  		
  		if(fecha1.getDia()!=fecha2.getDia())
  			igual=false;
  		
  		if(fecha1.getMes()!=fecha2.getMes())
  			igual=false;
  		
  		if(fecha1.getAn()!=fecha2.getAn())
  			igual=false;
  		
  		return igual;
  		
  	}

}
