package tp;
import java.util.*;


public class Oms {

	    private ArrayList<Pedido> pedidos;
		private ArrayList<Envio> envios;
		private ArrayList<Remedio> remedios;
		private ArrayList<CajaTipo> cajasTipo;
		private ArrayList<Pais> paises;
		private ArrayList<Enfermedad> enfermedades;
		private ArrayList<Usuario> usuarios;

		
		public Oms() 
		{
			pedidos = new ArrayList <Pedido>();
			envios = new ArrayList <Envio>();
			remedios = new ArrayList <Remedio>();
			cajasTipo = new ArrayList <CajaTipo>();
			paises = new ArrayList <Pais>();
			enfermedades = new ArrayList <Enfermedad>();
			usuarios = new ArrayList <Usuario>();
		}
		
		
		
/* ---------------------------------------------------------------------------------------------*/
/* ------------------------------------ BUSCADORES ---------------------------------------------*/
/* ---------------------------------------------------------------------------------------------*/

		public Pedido buscarPedido(int val)
		{
			int i = 0;
		    while((i < pedidos.size()) && !(pedidos.get(i).sos(val))){
		    	i++;
		    }
		    if(i < pedidos.size())
		    	return pedidos.get(i); 
		    else
		    	return null; 
		}
		
		public Envio buscarEnvio(int val)
		{
			int i = 0;
		    while((i < envios.size()) && !(envios.get(i).sos(val))){
		    	i++;
		    }
		    if(i < envios.size())
		    	return envios.get(i); 
		    else
		    	return null; 
		}
		
		public Enfermedad buscarEnfermedad(int val)
		{
			int i = 0;
		    while((i < enfermedades.size()) && !(enfermedades.get(i).sos(val))){
		    	i++;
		    }
		    if(i < enfermedades.size())
		    	return enfermedades.get(i); 
		    else
		    	return null; 
		}
		
		public Remedio buscarRemedio(int val)
		{
			int i = 0;
		    while((i < remedios.size()) && !(remedios.get(i).sos(val))){
		    	i++;
		    }
		    if(i < remedios.size())
		    	return remedios.get(i);
		    else
		    	return null; 
		}
		
		public CajaTipo buscarCajaTipo(int val)
		{
			int i = 0;
		    while((i < cajasTipo.size()) && !(cajasTipo.get(i).sos(val))){
		    	i++;
		    }
		    if(i < cajasTipo.size())
		    	return cajasTipo.get(i); 
		    else
		    	return null; 
		}
		
		public Pais buscarPais(String val)
		{
			int i = 0;
		    while((i < paises.size()) && !(paises.get(i).sos(val))){
		    	i++;
		    }
		    if(i < paises.size())
		    	return paises.get(i); 
		    else
		    	return null; 
		}
		
		
		
		public Usuario buscarUsuario(String nombreUsuario)
		{
			int i = 0;
			while((i < usuarios.size()) && !(usuarios.get(i).validarUsuario(nombreUsuario)))
				i++;
			if(i < usuarios.size())
			{
				return usuarios.get(i);
			}
			else
			{
				return null;
			}
		}
		
		public Usuario buscarPass(String contrasena)
		{
			int i = 0;
			while((i < usuarios.size()) && !(usuarios.get(i).validarPass(contrasena)))
				i++;
			if(i < usuarios.size())
			{
				return usuarios.get(i);
			}
			else
			{
				return null;
			}
		}


/* ---------------------------------------------------------------------------------------------*/
/* ------------------------------------ CREADORES ----------------------------------------------*/
/* ---------------------------------------------------------------------------------------------*/
		
//1) Registrar una donacion de un determinado remedio que ya puede o no existir en stock.

		public void registrarDonacionRemedio()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- REGISTRAR DONACION DE REMEDIOS -----------------\n");
			System.out.println("Ingrese el ID de remedio: ");
			int id = entrada.nextInt();
			
			int cant = 0;
			Remedio r = this.buscarRemedio(id);
			
			if(r!=null)
			{
				System.out.println("Remedio registrado, por favor indique la cantidad de la donacion.");
				System.out.println("Cantidad: ");
				cant = entrada.nextInt();
				r.agregarStock(cant); // Sumamos al stock
				
				System.out.println("--------------------------------------------------------------");
				System.out.println("Se ha actualizado el Medicamento/Vacuna con éxito.");
				System.out.println("- ID: "+id);
				System.out.println("- Descripción: "+ r.darDescripcion());
				System.out.println("- Stock: "+ cant);
				System.out.println("--------------------------------------------------------------\n");
			}
			else
			{
				System.out.println("Ingrese la descripcion del remedio ");
				String descripcion = entrada.next();
				System.out.println("Ingrese el stock ");
				cant = entrada.nextInt();
				int opc;
				do
				{
					System.out.println("Ingrese el tipo de remedio que desea donar: (1: Vacuna | 2: Medicamento)");
					opc = entrada.nextInt();
					
				} while ( (opc!=1) && (opc!=2) );
				
				if(opc==1)
				{
					System.out.println("Ingrese el valor de la Vacuna: ");
					int valor = entrada.nextInt();
					System.out.println("Ingrese la dosis que debe proveerse (en Mililitros (ml)): ");
					int dosis = entrada.nextInt();
					r = new Vacuna(id, descripcion, cant, valor, dosis);
					System.out.println("--------------------------------------------------------------");
					System.out.println("Se ha registrado la Vacuna con éxito.");
					System.out.println("- ID: "+id);
					System.out.println("- Descripción: "+ descripcion);
					System.out.println("- Stock: "+ cant);
					System.out.println("- Valor: U$D "+valor);
					System.out.println("- Dosis: "+dosis+" ml");
					System.out.println("--------------------------------------------------------------\n");
				}
				else
				{
					r = new Medicamento(id, descripcion, cant);
					System.out.println("--------------------------------------------------------------");
					System.out.println("Se ha registrado el Medicamento con éxito.");
					System.out.println("- ID: "+id);
					System.out.println("- Descripción: "+ descripcion);
					System.out.println("- Stock: "+ cant);
					System.out.println("--------------------------------------------------------------\n");
				}
				remedios.add(r);
				
			}
		}
		

		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//2) Registrar nueva Enfermedad y Caja-Tipo

		public void registrarEnfermedad()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- REGISTRAR ENFERMEDAD NUEVA -----------------\n");
			
			if(remedios.isEmpty())
			{
				System.out.println("No existen remedios registrados, por lo tanto no pueden crearse enfermedades.");
				System.out.println("Debido a que las enfermedades necesitan una Caja Tipo, este dato es obligatorio.");
			}
			else
			{
				int idE = enfermedades.size()+1;
				
				System.out.println("Ingrese el nombre de la enfermedad: ");
				String nombre = entrada.next();
				
				Enfermedad e = new Enfermedad(idE, nombre);
				
				Remedio r;
				int ctdR;
				
				System.out.println("Se esta creando una Enfermedad con el ID: "+ idE);
				System.out.println("Toda enfermedad en el sistema debera poseer un listado de remedios que sera considerado como Caja Tipo");
					
				int idCaja = cajasTipo.size()+1;
				System.out.println("La caja tipo generada automaticamente para esta enfermedad es: "+idCaja);
				Hashtable<Remedio, Integer> remediosCaja = new Hashtable<Remedio, Integer>();
					
				int salir=0;
				int idr=0;
				do
				{
					System.out.println("Indique el ID del remedio que desea agregar a la caja");
					idr = entrada.nextInt();
					
					r = this.buscarRemedio(idr);
						
					if(r==null)
						System.out.println("El remedio ingresado no existe.");
					else
					{
						if(remediosCaja.contains(r))
						{
							System.out.println("El remedio ya se encuentra en la caja, ingrese la cantidad que desea adicionarle: ");
							ctdR = entrada.nextInt();
							if(ctdR == 0)
								System.out.println("Ha ingresado 0, no se actualizara el remedio.");
							else
							{
								ctdR += remediosCaja.get(r);
								remediosCaja.put(r, ctdR);
							}
						}
						else
						{
							System.out.println("Indique la cantidad de este remedio que le corresponde a esta caja");
							ctdR = entrada.nextInt();
							if(ctdR == 0)
								System.out.println("Ha ingresado 0, no se agregara el remedio a la caja.");
							else
								remediosCaja.put(r, ctdR);
						}
					}
					if(remediosCaja.isEmpty())
						System.out.println("Es obligatoria la carga de al menos un remedio.");

					else
					{
						do 
						{
							System.out.println("---------------------------------------------------");
							System.out.println("Desea continuar agregando remedios?");
							System.out.println("1 - Si");
							System.out.println("0 - No");
							salir = entrada.nextInt();
						}while (salir != 0 && salir != 1) ;
					}
					
				}while(remediosCaja.isEmpty() || (salir != 0)); 
					
					
					
					// CajaTipo(int id, Enfermedad enfermedad, Hashtable<Remedio, Integer> remediosCaja)
					CajaTipo c = new CajaTipo(idCaja, e, remediosCaja);
					
					e.agregarCaja(c);
					
					enfermedades.add(e);
					cajasTipo.add(c);
					
					System.out.println("--------------------------------------------------------------\n");
					System.out.println("La enfermedad se ha registrado con éxito.");
					System.out.println("- ID: "+ idE);
					System.out.println("- Descripción: " + nombre);
					System.out.println("- Caja Tipo: ");
					c.listarRemedios();
					System.out.println("--------------------------------------------------------------\n");
				
			}				
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//3) Registrar nuevo Pedido de Pais
		public void registrarPedido()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- REGISTRAR NUEVO PEDIDO DE PAIS -----------------\n");
			
			if(!enfermedades.isEmpty() || !remedios.isEmpty())
			{
				int idPedido = pedidos.size()+1;
				System.out.println("Se inicia la carga del Pedido: "+ idPedido);
				
				Pedido ped;
				Pais p;
				do
				{
					System.out.println("Ingrese el pais afectado que requiere el pedido: (formato abreviado, ejemplo: AR)");
					String idPais = entrada.next();
					p = this.buscarPais(idPais);
					
					if(p==null)
						System.out.println("El pais ingresado es incorrecto.");
						
				}while (p==null);
				
				System.out.println("Para el pais: "+ p.darNombre());
				System.out.println("Ingrese el codigo de la Enfermedad que afecta al Pais: ");
				int idEnfermedad = entrada.nextInt();
				int cant = 0;
				Enfermedad enf;
				do
				{
					enf = this.buscarEnfermedad(idEnfermedad);
					if(enf==null)
					{
						System.out.println("La enfermedad ingresada no existe.");
						System.out.println("Ingrese el codigo de la Enfermedad que afecta al Pais: (0=salir)");
						idEnfermedad = entrada.nextInt();
					}
					else
					{
						System.out.println("Ingrese la cantidad de remedios que requiere: ");
						cant = entrada.nextInt();
						while(cant==0)
						{
							System.out.println("Ingrese un valor diferente de 0: ");
							cant = entrada.nextInt();
						}
						ped = new Pedido(idPedido, cant, enf,p);
						pedidos.add(ped);

						System.out.println("\n--------------------------------------------------------------");
						System.out.println("Pedido registrado con éxito.");
						System.out.println("- ID: "+ idPedido);
						System.out.println("- Pais: "+p.darNombre());
						System.out.println("- Enfermedad: " + enf.darNombre());
						System.out.println("- Cantidad solicitada: "+cant);
						System.out.println("--------------------------------------------------------------\n");
					}
				}while(enf==null && idEnfermedad!=0);
				
			}
			else
				System.out.println("No se registran Enfermedades ni Remedios. Por favor, creelos antes de generar un pedido.");
			
		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//4) Registrar envio ante pedido pendiente
		public void registrarEnvioPedidoPend()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- REGISTRAR ENVIO ANTE PEDIDO PENDIENTE -----------------\n");
			
			if(!pedidos.isEmpty())
			{
				System.out.println("Ingrese el ID del Pedido: ");
				int idPed = entrada.nextInt();
				
				Pedido p = this.buscarPedido(idPed);
				
				
				if(p==null)
					System.out.println("El pedido no existe.");		
				else
				{
					System.out.println("Pedido encontrado OK");
					
					if(!p.tieneEnvio())
					{
						int cajasSolicitadas = p.getCantSolicitada();
						int i = 0;
						double valor = 0;
						
						System.out.println("La cantidad de cajas solicitadas es de "+ cajasSolicitadas);
						
						CajaTipo cajaTipo = p.getCajaTipo(); 
						
						boolean fin=false;
						
						while(i < cajasSolicitadas && fin == false)
						{
							if(cajaTipo.validarStock())
							{
								i++;
								valor += cajaTipo.armarCaja();
							}
							else
								fin = true;
						}
						
						valor += Envio.darCostoEnvio();
						
						System.out.println("El costo definido fue de: U$S "+ valor);
						
						int idE = envios.size()+1;
						
						Envio e = new Envio(idE, cajaTipo, i, valor);
						
						if(i == cajasSolicitadas)
						{
							System.out.println("\n--------------------------------------------------------------");
							System.out.println("Envío registrado con éxito.");
							System.out.println("- ID Envío: "+idE);
							System.out.println("- ID Pedido correspondiente: "+idPed);
							System.out.println("- Costo total: "+valor);
							System.out.println("- El envío se ha generado por el total de cajas del pedido.");
							System.out.println("--------------------------------------------------------------\n");
							envios.add(e);
							p.agregarEnvio(e);
						}
						else
						{
							if(i!=0)
							{
								
								System.out.println("\n--------------------------------------------------------------");
								System.out.println("Envío registrado con éxito.");
								System.out.println("- ID Envío: "+idE);
								System.out.println("- ID Pedido correspondiente: "+idPed);
								System.out.println("- Costo total: "+valor);
								System.out.println("- El envío se ha generado de forma parcial, no pudieron armarse " +i+ " cajas.");
								System.out.println("--------------------------------------------------------------\n");
								envios.add(e);
								p.agregarEnvio(e);
							}
							else
							{
								System.out.println("\n--------------------------------------------------------------");
								System.out.println("Envío no registrado.");
								System.out.println("- ID Pedido correspondiente: "+idPed);
								System.out.println("- No hay stock suficiente para poder armar las cajas.");
								System.out.println("--------------------------------------------------------------\n");
							}
								
						}					
					}
					else
					{
						System.out.println("--------------------------------------------------------------");
						System.out.println("- El pedido ya posee envio registrado.");			
						System.out.println("--------------------------------------------------------------\n");
					}
						
				}
			}
			else
				System.out.println("No hay pedidos registrados en el sistema, primero registre Pedidos para poder crear envios.");
			
			
				
		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//97 Easter Egg
		public void printEaster() 
		{
		    int steps = 3;
		    System.out.println("\n              MUY BIEN 10!!!");
		    System.out.println("Saludos Lungarella, Garofalo, Topa \n");
		    for (int x = 0; x < steps; x++) {
		        System.out.format(((steps == (x + 1)) ? "" : ("%"
		                + ((steps - x - 1) * 5) + "s"))
		                + "  o  ******"
		                + ((x == 0) ? "" : ("%" + (x * 5) + "s"))
		                + "*\n", " ", " ");
		        System.out.format(((steps == (x + 1)) ? "" : ("%"
		                + ((steps - x - 1) * 5) + "s"))
		                + " /|\\ *     "
		                + ((x == 0) ? "" : ("%" + (x * 5) + "s"))
		                + "*\n", " ", " ");
		        System.out.format(((steps == (x + 1)) ? "" : ("%"
		                + ((steps - x - 1) * 5) + "s"))
		                + " / \\ *     "
		                + ((x == 0) ? "" : ("%" + (x * 5) + "s"))
		                + "*\n", " ", " ");
		    }
		    for (int i = 0; i < (steps + 1) * 5 + 2; i++) {
		        System.out.print("*");
		    }
		}
		
		
		//98 - Agregar empleado
		public void agregarEmpleado()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- REGISTRAR EMPLEADO -----------------\n");
			System.out.println("Ingrese el usuario: ");
			String user = entrada.next();
			Usuario usuario = this.buscarUsuario(user);
			
			if(usuario != null)
			{
				System.out.println("El usuario ya existe.");
			}
			else
			{
				System.out.println("Ingrese la contrase�a: (alfabetica)");
				String clave = entrada.next();
				System.out.println("Ingrese Nombre: ");
				String denominacion = entrada.next();
				usuario = new Empleado(user, clave, denominacion);
				this.usuarios.add(usuario);
				System.out.println("--------------------------------------------------------------");
				System.out.println("- El usuario ha sido generado con exito.");			
				System.out.println("--------------------------------------------------------------\n");
				
				
			}
		}
		
/* -------------------------------------------------------------------------------------------------*/
/* ------------------------------------ MODIFICADORES ----------------------------------------------*/
/* -------------------------------------------------------------------------------------------------*/		
		
		//5) Modificar Caja-Tipo 
		public void modificarCajaTipo()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- MODIFICAR CAJA TIPO -----------------\n");
			
			if(!cajasTipo.isEmpty())
			{
				System.out.println("Ingrese el ID de la Caja Tipo a modificar: ");
				int val = entrada.nextInt();
				
				CajaTipo cT = this.buscarCajaTipo(val);
				Remedio rem;
				
				if(cT==null)
					System.out.println("Error! El codigo ingresado no pertenece a ninguna Caja Tipo.");
				else
				{
					
					int id = 0;
					int nuevaCant =0;
					System.out.println("La Caja ingresada tiene los siguientes Remedios: ");
					cT.listarRemedios();
					
					 //este buscar lo deberiamos estar haciendo en Caja Tipo porque ahi deberiamos buscar si la CT tiene ese remedio
					System.out.println("Estimado usuario: Si el remedio ingresado, no existe, sera agregado.");
					System.out.println("Ingrese el ID del remedio que desea modificar: (0=Salir)");
					id = entrada.nextInt();
					
					while(id!=0)
					{
						rem = this.buscarRemedio(id);
						if(rem==null)
							System.out.println("El remedio indicado no existe.");
						else
						{
							System.out.println("Ingrese la cantidad: ");
							nuevaCant = entrada.nextInt();
							cT.modificarCantidad(rem, nuevaCant);
						}
						System.out.println("Si lo desea, ingrese otro ID de remedio para modificar: (0 = Salir)");
						id = entrada.nextInt();
					}
					
					System.out.println("\n--------------------------------------------------------------");					
					System.out.println("La caja-tipo queda de la siguiente manera:");
					cT.listarRemedios();
					System.out.println("--------------------------------------------------------------\n");
				}
			}
			else
				System.out.println("No existen cajas-tipo registradas para modificar.");
			
			
		}
		
		//6) Modificar pedido de Pais
		public void modificarPedidoPais()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- MODIFICAR PEDIDO DE PAIS-----------------\n");
			
			if(!pedidos.isEmpty())
			{
				System.out.println("Ingrese el ID del Pedido a modificar: ");
				int val = entrada.nextInt();
				
				Pedido ped = this.buscarPedido(val);
				
				if(ped == null)
					System.out.println("Error! El Pedido ingresado no existe");
				else
				{
					if(!ped.tieneEnvio())
					{
						System.out.println("Que desea modificar?");
			
						byte opc = 0;
						do 
						{
							System.out.println("1) La cantidad solicitada");
							System.out.println("2) La Enfermedad");
							System.out.println("3) El pais de destino");
							System.out.println("0) Salir");
							opc = entrada.nextByte();
							switch (opc) 
							{
								case 1:  
								{
									System.out.println("La actual cantidad pedida es: "+ ped.getCantSolicitada());
									System.out.println("Desea modificarlo? (S=si|N=no)");
									String resp = entrada.next();
									if(resp.equalsIgnoreCase("s"))
									{
										System.out.println("Ingrese la nueva cantidad solicitada: ");
										int cant = entrada.nextInt();
										ped.setCantSolicitada(cant);
										System.out.println("Se actualizo para el Pedido "+val+" la cantidad solicitada. La nueva es: "+ ped.getCantSolicitada());
									}
									else
										System.out.println("No modifica.");
									
								}break;
								case 2: 
								{
									System.out.println("La actual enfermedad es: "+ ped.getEnfermedad().darNombre());
									System.out.println("Desea modificarlo? (S=si|N=no)");
									String resp = entrada.next();
									if(resp.equalsIgnoreCase("s"))
									{
										System.out.println("Indique el ID de la enfermedad: ");
										int idEnf = entrada.nextInt();
										
										Enfermedad e = this.buscarEnfermedad(idEnf);
										if (e==null)
											System.out.println("La enfermedad no existe");
										else
										{
											ped.modificarEnfermedad(e);
										}
									}
									else
										System.out.println("No modifica.");
									
									
								}break;
								case 3: 
								{
									System.out.println("El actual Pais definido para el Pedido ingresado es: "+ ped.getPaisDestino().darNombre());
									System.out.println("Desea modificarlo? (S=si|N=no)");
									String resp = entrada.next();
									if(resp.equalsIgnoreCase("s"))
									{
										System.out.println("Ingrese el nuevo Pais de destino: ");
										String nuevoPais = entrada.next();
										
										Pais p = this.buscarPais(nuevoPais);
										
										if(p==null)
											System.out.println("El pais ingresado no existe.");
										else
										{
											ped.setPaisDestino(p);
										}
									}
									else
										System.out.println("No modifica.");
								}break;
								
							}
						}while (opc !=0);
					}
					else
						System.out.println("El pedido tiene envios, no se puede modificar.");
				}
			}
			else
				System.out.println("No existen Pedidos registrados para modificar.");
				
		}
		
		//7) Modificar costo de Envios
		public void modificarCostoEnvio()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- MODIFICAR COSTO ENVIO -----------------\n");
			double val = Envio.darCostoEnvio();
			if(val!=0)
			{
				System.out.println("El Costo de Envio esta fijado en: U$S "+val);
				System.out.println("Desea modificarlo? (S|N)");
				String resp = entrada.next();
				if(resp.equalsIgnoreCase("N"))
					System.out.println("Permanece el valor: U$S "+val);
				else
				{
					System.out.println("Ingrese el nuevo valor del Costo de Envio: U$S ");
					double nuevoVal = entrada.nextDouble();
					Envio.setCostoEnvio(nuevoVal);		
					System.out.println("\n--------------------------------------------------------------");
					System.out.println("Se actualizo el valor a: U$S "+nuevoVal);
					System.out.println("--------------------------------------------------------------\n");
				}
			}
				
			
			
		}
		
/* ---------------------------------------------------------------------------------------------*/
/* ------------------------------------ REPORTES -----------------------------------------------*/
/* ---------------------------------------------------------------------------------------------*/
		
		

				
		//8) Informar cual seria el costo total de un envio ya armado dado su codigo
		public void informaCostoTotal()
		{
			Scanner input = new Scanner(System.in);
			input.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- INFORMAR COSTO TOTAL DE ENVIO -----------------\n");
			if(!envios.isEmpty())
			{
				System.out.println("Ingrese ID del Envio a informar: ");
				int idEnv = input.nextInt();
				Envio env = this.buscarEnvio(idEnv);
				if(env==null)
					System.out.println("Error! El ID ingresado no corresponde a ningun envio.");
				else
				{
					System.out.println("\n--------------------------------------------------------------");			
					System.out.println("El costo flete es: U$S: "+Envio.darCostoEnvio());
					System.out.println("El valor total es: U$S"+ env.darValorTotal());
					System.out.println("--------------------------------------------------------------\n");
				}
			}
			else
				System.out.println("No hay envios registrados.");
			
		}
		
		//9) Informar cuantos envios se le han hecho en los ultimos 3 anios, dado el nombre de un pais.
		
		public void informarEnviosTresAnios ()
		{
			Scanner input = new Scanner(System.in);
			input.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- INFORMAR ENVIOS DE ULTIMOS 3 ANIOS-----------------\n");
			if(!envios.isEmpty())
			{
				System.out.println("Ingrese nombre de pais");
				String nombrePais = input.next();
				
				// Busco el pais que me pasaron por parametro
				Pais pais = this.buscarPais(nombrePais);

				// Pregunto si existe
				if (pais != null)
				{
					// Si el pais existe, recien ahi actualizo el contador de envio. Si no existe el pais
					int cantidadEnvios = 0;

					// Recorro los pedidos
					for(Pedido pedido: pedidos)
					{
						// Pregunto por si el pedido en el que estoy posicionado tiene el pais que busco
						if (pedido.getPaisDestino() == pais)
						{
							// Preguntar si hay envios para este pedido
							if (pedido.tieneEnvio())
								// pregunto si la fecha del pedido está dentro de los 3 anios...
								if(pedido.check3anios())
									cantidadEnvios++;
						}
					}

					// Informar numero de envios (o pedidos)
					System.out.println("En los ultimos 3 anios se ha hecho " + cantidadEnvios + " a " + pais.darNombre());
				}
				else
					System.out.println("El pais no existe.");
			}
			else
				System.out.println("No existen envios registrados.");
			
			
			
		}
		
		
		//10) Informar Enfermedades con vacuna.
		public void informarEnfermedadesConVacuna()
		{
			Scanner entrada = new Scanner(System.in);
			entrada.useDelimiter(System.getProperty("line.separator"));
			System.out.println("\n----------------- INFORMAR ENFERMEDADES CON VACUNA -----------------\n");
			
			if(enfermedades.isEmpty())
				System.out.println("No hay enfermedades registradas.");
			else
			{
				System.out.println("\n--------------------------------------------------------------");
				for(CajaTipo ct: cajasTipo) // recorremos cajas tipo porque no creamos cajas sin enfermedades
				{
					ct.tieneVacuna();
				}
				System.out.println("--------------------------------------------------------------\n");
			}
			
			
		}
		
		//11) Informar el Stock existente de todos remedios.
        public void informarStockDeRemedios()
		{
        	System.out.println("\n----------------- INFORMAR EL STOCK DE REMEDIOS-----------------");
        	if(!remedios.isEmpty())
        	{
        		System.out.println("--------------------------------------------------------------");
        		for(Remedio elem: remedios)
    			{
    				elem.mostraStock();
    			}	
        		System.out.println("--------------------------------------------------------------");
        	}
        	else
        		System.out.println("No existen remedios registrados.");
			
			
		}
        
      //12) Informar los codigo de las caja-tipo que no pueden armarse por falta de stock
      public void informarCajaSinStock()
      {
    	  System.out.println("\n----------------- INFORMAR CAJA-TIPOS NO ARMABLES-----------------\n");
    	  if(!enfermedades.isEmpty())
    	  {
    		  System.out.println("\n--------------------------------------------------------------");
    		  for(Enfermedad enf: enfermedades)
        		{
        		    if(enf.noTenesStock())
        		    	System.out.println("La caja-tipo " + enf.getCajaTipo().getId() +" no puede armarse por falta de stock.");
        		}
    		  System.out.println("--------------------------------------------------------------\n");
    	  }
    	  else
    		  System.out.println("No hay Enfermedades registradas.");
      		
      }
      
    //13) Informar Enfermedades con su ID de Caja Tipo.
    		public void listarEnfermedadesYCajasTipo()
    		{
    			Scanner entrada = new Scanner(System.in);
    			entrada.useDelimiter(System.getProperty("line.separator"));
    			System.out.println("\n----------------- INFORMAR ENFERMEDADES CON SUS CAJAS TIPO -----------------\n");
    			if(enfermedades.isEmpty())
    				System.out.println("No hay enfermedades registradas.");
    			else
    			{
    				System.out.println("\n--------------------------------------------------------------");
    				for(Enfermedad elem: enfermedades) // recorremos cajas tipo porque no creamos cajas sin enfermedades
    				{
    					System.out.println("---------------------------------------------");
    					System.out.println("Enfermedad: "+elem.darID()+" - "+elem.darNombre()+" posee Caja Tipo: "+elem.darCajaTipo().getId() );
    					elem.darCajaTipo().listarRemedios();
    				}
    				System.out.println("--------------------------------------------------------------\n");
    			}
    			

    			
    		}
    		//14) Listar pedidos.
    		public void listarPedidos()
    		{
    			Scanner entrada = new Scanner(System.in);
    			entrada.useDelimiter(System.getProperty("line.separator"));
    			System.out.println("\n----------------- LISTAR PEDIDOS -----------------\n");
    			if(pedidos.isEmpty())
    				System.out.println("No hay pedidos registrados.");
    			else
    			{
    				System.out.println("\n--------------------------------------------------------------");
    				for(Pedido elem: pedidos) // recorremos todos los pedidos
    				{
    					System.out.println("--------------------------------------------------------------");
    					System.out.print("Fecha: ");
    					elem.darFecha();
    					System.out.print("- Pedido: "+elem.darID()+" - Pais: " + elem.getPaisDestino().darNombre()+" - Enfermedad: "+elem.getEnfermedad().darNombre() +" - Cant. cajas: "+ elem.getCantSolicitada() +"\n");
    					
    				}
    				System.out.println("--------------------------------------------------------------\n");
    			}
    			

    			
    		}
    		//13) Listar Envios.
    		public void listarEnvios()
    		{
    			Scanner entrada = new Scanner(System.in);
    			entrada.useDelimiter(System.getProperty("line.separator"));
    			System.out.println("\n----------------- LISTAR ENVIOS -----------------\n");
    			if(envios.isEmpty())
    				System.out.println("No hay envios registrados.");
    			else
    			{
    				System.out.println("\n--------------------------------------------------------------");
    				for(Envio elem: envios) // recorremos todos los envios
    				{
    					System.out.println("--------------------------------------------------------------");
    					System.out.print("Fecha: ");
    					elem.darFecha();
    					System.out.print(" - Envio: "+elem.darID()+" - Valor Total: "+elem.darValorTotal() + " - Cant. cajas: "+ elem.darCant()+ "\n");
    					
    				}
    				System.out.println("--------------------------------------------------------------\n");
    			}
    			

    			
    		}
      
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    
/* --------------------------------------------------------------------------------------------------*/
/* ------------------------------------- MENU-USUARIO -----------------------------------------------*/
/* --------------------------------------------------------------------------------------------------*/  
        
    		public void logIn()
        	{
        		Scanner entrada = new Scanner(System.in);
        		entrada.useDelimiter(System.getProperty(("line.separator")));

        		System.out.println("Ingrese nombre de usuario: ");
        		String nombreUsuario = entrada.next();
        		
        		Usuario usuario = this.buscarUsuario(nombreUsuario);
        		String clave;
        		
        		if(usuario == null)
        		{
        			do 
    				{
    					System.out.println("Ha ingresado un usuario incorrecto");
    					System.out.println("Ingrese usuario nuevamente: ");
    					nombreUsuario = entrada.next();
    					usuario = this.buscarUsuario(nombreUsuario);
    					
    				} while (usuario == null);
        		}
        		System.out.println("Ingrese contrase�a: ");
        		clave = entrada.next();
        		
        		usuario = this.buscarPass(clave);
        		if(usuario == null)
        		{
        			do 
        			{
        				System.out.println("Ha ingresado una clave incorrecta");
        				System.out.println("Ingrese clave nuevamente: ");
        				clave = entrada.next();
        				usuario = this.buscarPass(clave);
        			} while (usuario == null);
        		}
        		
    			this.mostrarMenu(usuario);
        	}
        
        public void mostrarMenu(Usuario usuarioActual)
    	{
    		Scanner entrada = new Scanner(System.in);
    		byte opc = 0;
    		if (usuarioActual.sosSuperUsuario()) 
    		{ 
    			this.cargoPaises();
    			do
    			{
    				System.out.println("\n---------------------------------------------------------------------------------------------");
    				System.out.println("---- TRANSACCIONES DE CREACION ----");
    				System.out.println("1) Registrar una donacion de un determinado remedio.");
    				System.out.println("2) Registrar nueva Enfermedad y Caja-Tipo");
    				System.out.println("3) Registrar nuevo Pedido de Pais");
    				System.out.println("4) Registrar envio ante pedido pendiente");
    				
    				System.out.println("\n---------------------------------------------------------------------------------------------");
    				System.out.println("---- TRANSACCIONES DE MODIFICACION ----");
    				System.out.println("5) Modificar Caja-Tipo");
    				System.out.println("6) Modificar pedido de Pais");
    				System.out.println("7) Modificar costo de Envios");
    				
    				System.out.println("\n---------------------------------------------------------------------------------------------");
    				System.out.println("---- REPORTES ----");
    				System.out.println("8) Informar cual seria el costo total de un envio ya armado dado su codigo");
    				System.out.println("9) Informar cuantos envios se le han hecho en los ultimos 3 años, dado el nombre de un pais.");
    				System.out.println("10) Informar Enfermedades con vacuna.");
    				System.out.println("11) Informar el Stock existente de todos remedios.");
    				System.out.println("12) Informar los codigo de las caja-tipo que no pueden armarse por falta de stock. ");
    				System.out.println("13) Listar enfermedades y sus caja tipo. ");
    				System.out.println("14) Listar pedidos. ");
    				System.out.println("15) Listar envios. ");
    				
    				System.out.println("\n---------------------------------------------------------------------------------------------");
    				System.out.println("---- ADMINISTRACION ----");
    				System.out.println("98) Registrar nuevo empleado.");
    				System.out.println("99) Precargar datos Test (paises, enfermedades, remedios y cajas tipo)");
    				System.out.println("0) Salir");
    				System.out.print("\nIngrese opc:");
    				opc = entrada.nextByte();
    				switch(opc)
    				{
	    				case 1:
	    				{
	    					this.registrarDonacionRemedio();
	    				}break;
	    				case 2:
	    				{
	    					this.registrarEnfermedad();
	    				}break;
	    				case 3:
	    				{
	    					this.registrarPedido();
	    				}break;
	    				case 4:
	    				{
	    					this.registrarEnvioPedidoPend();
	    				}break;	    				
	    				case 5:
	    				{
	    					this.modificarCajaTipo();
	    				}break;	    				
	    				case 6:
	    				{
	    					this.modificarPedidoPais();
	    				}break;	    				
	    				case 7:
	    				{
	    					this.modificarCostoEnvio();
	    				}break;	    				
	    				case 8:
	    				{
	    					this.informaCostoTotal();
	    				}break;	    				
	    				case 9:
	    				{
	    					this.informarEnviosTresAnios();
	    				}break;	    				
	    				case 10:
	    				{
	    					this.informarEnfermedadesConVacuna();
	    				}break;
	    				case 11:
	    				{
	    					this.informarStockDeRemedios();
	    				}break;
	    				case 12:
	    				{
	    					this.informarCajaSinStock();
	    				}break;
	    				case 13:
	    				{
	    					this.listarEnfermedadesYCajasTipo();
	    				}break;
	    				case 14:
	    				{
	    					this.listarPedidos();
	    				}break;
	    				case 15:
	    				{
	    					this.listarEnvios();
	    				}break;
	    				case 97:
	    				{
	    					this.printEaster();
	    				}break;
	    				case 98:
	    				{
	    					this.agregarEmpleado();
	    				}break;
	    				case 99:
	    				{
	    					this.cargoPaises();
	    					this.crearDatosPruebas();
	    				}break;
    				}
    			} while (opc != 0);
    		}
    		else
    		{
    			do
    			{
    				System.out.println("\n---------------------------------------------------------------------------------------------");
    				System.out.println("---- REPORTES ----");
    				System.out.println("8) Informar cual seria el costo total de un envio ya armado dado su codigo");
    				System.out.println("9) Informar cuantos envios se le han hecho en los ultimos 3 años, dado el nombre de un pais.");
    				System.out.println("10) Informar Enfermedades con vacuna.");
    				System.out.println("11) Informar el Stock existente de todos remedios.");
    				System.out.println("12) Informar los codigo de las caja-tipo que no pueden armarse por falta de stock");
    				System.out.println("13) Listar enfermedades y sus caja tipo");
    				System.out.println("14) Listar pedidos");
    				System.out.println("15) Listar envios");
    				System.out.println("0) Salir");
    				System.out.print("\nIngrese opc:");
    				opc = entrada.nextByte();
    				switch(opc)
    				{
	    				case 8:
	    				{
	    					this.informaCostoTotal();
	    				}break;	    				
	    				case 9:
	    				{
	    					this.informarEnviosTresAnios();
	    				}break;	    				
	    				case 10:
	    				{
	    					this.informarEnfermedadesConVacuna();
	    				}break;
	    				case 11:
	    				{
	    					this.informarStockDeRemedios();
	    				}break;
	    				case 12:
	    				{
	    					this.informarCajaSinStock();
	    				}break;
	    				case 13:
	    				{
	    					this.listarEnfermedadesYCajasTipo();
	    				}break;
	    				case 14:
	    				{
	    					this.listarPedidos();
	    				}break;
	    				case 15:
	    				{
	    					this.listarEnvios();
	    				}break;
    				}
    			} while(opc != 0);
    		}
    	}
   
        
        
/* ---------------------------------------------------------------------------------------------*/
/* ------------------------------------ PRECARGA -----------------------------------------------*/
/* ---------------------------------------------------------------------------------------------*/        

 
    public void precargoAdmin()
    {
    	//precargo siempre el usuario admin
    	Usuario mega = new Admin("admin", "admin", "Super usuario");
    	//usuario: admin - pass: admin
    	this.usuarios.add(mega);
    }
        
	@SuppressWarnings("null")
	public void crearDatosPruebas()
	{
		remedios.add(new Medicamento(1,"Ranitidina",100));
		remedios.add(new Medicamento(2,"Omeprazol",89));
		remedios.add(new Medicamento(3,"Sucralfato",0));//<-------27 valor anterior de stock
		remedios.add(new Medicamento(4,"Atropina",19));
		remedios.add(new Medicamento(5,"Metoclopramida",24));
		remedios.add(new Medicamento(6,"Domperidona",56));
		remedios.add(new Medicamento(7,"Simeticona",123));
		remedios.add(new Medicamento(8,"Insulina",53));
		remedios.add(new Medicamento(9,"Metformina",31));
		remedios.add(new Medicamento(10,"Glimepirida",45));
		remedios.add(new Medicamento(11,"Repaglinida",667));
		remedios.add(new Medicamento(12,"Tocoferol",32));
		remedios.add(new Medicamento(13,"Vitamina A",436));
		remedios.add(new Medicamento(14,"Vitamina B",353));
		remedios.add(new Medicamento(15,"Vitamina C",1100));
		remedios.add(new Medicamento(16,"Vitamina D",200));
		remedios.add(new Medicamento(17,"Calcio",34));
		remedios.add(new Medicamento(18,"Zinc",444));
		remedios.add(new Medicamento(19,"Multivitamina",120));
		remedios.add(new Medicamento(20,"Enoxaparina",19));
		System.out.println("*** Medicamentos cargados OK");
		remedios.add(new Vacuna(100,"BCG",900,40,10));
		remedios.add(new Vacuna(101,"Hepatitis B",800,50,30));
		remedios.add(new Vacuna(102,"Neumococo",700,30,20));
		remedios.add(new Vacuna(103,"Quintuple",260,60,30));
		remedios.add(new Vacuna(104,"Polio IPV",160,80,15));
		remedios.add(new Vacuna(105,"Meningcoco",180,100,20));
		remedios.add(new Vacuna(106,"Refuerzo antigripal",200,50,40));
		remedios.add(new Vacuna(107,"Hepatitis A",220,30,20));
		remedios.add(new Vacuna(108,"Triple Viral",240,60,10));
		remedios.add(new Vacuna(109,"Varicela",260,80,20));
		remedios.add(new Vacuna(110,"Polio OPV",280,100,15));
		remedios.add(new Vacuna(111,"Colera",300,50,20));
		remedios.add(new Vacuna(112,"Aviar",560,30,40));
		remedios.add(new Vacuna(113,"Influenza ",820,60,20));
		remedios.add(new Vacuna(114,"H1N1",1080,80,10));
		remedios.add(new Vacuna(115,"H3N2",1340,100,20));
		remedios.add(new Vacuna(116,"Bacteriana",890,50,45));
		remedios.add(new Vacuna(117,"Rotavirus",440,30,10));
		remedios.add(new Vacuna(118,"Acelular",100,60,20));
		remedios.add(new Vacuna(119,"Virales criticas",780,30,45));
		System.out.println("*** Vacunas cargadas OK");
		enfermedades.add(new Enfermedad(900,"Difteria"));
		enfermedades.add(new Enfermedad(901,"Tetanos"));
		enfermedades.add(new Enfermedad(902,"Colera"));
		enfermedades.add(new Enfermedad(903,"Poliomielitis"));
		enfermedades.add(new Enfermedad(904,"Tosferina"));
		enfermedades.add(new Enfermedad(905,"Sarampion"));
		enfermedades.add(new Enfermedad(906,"Rubeola"));
		enfermedades.add(new Enfermedad(907,"Parotiditis"));
		enfermedades.add(new Enfermedad(908,"Varicela"));
		enfermedades.add(new Enfermedad(909,"Papiloma"));
		enfermedades.add(new Enfermedad(910,"Gripe Aviar"));
		enfermedades.add(new Enfermedad(911,"Gripe H3N2"));
		enfermedades.add(new Enfermedad(912,"Gripe H1N1"));
		enfermedades.add(new Enfermedad(913,"Hepatitis"));
		System.out.println("*** Enfermedades cargadas OK");
		
		Hashtable<Remedio, Integer> remediosCaja = new Hashtable<Remedio, Integer>();
		CajaTipo c = null;
		Enfermedad e = null;

		//1er caja
		e = this.buscarEnfermedad(900);
		remediosCaja.put(this.buscarRemedio(101),1);
		remediosCaja.put(this.buscarRemedio(3),1);
		remediosCaja.put(this.buscarRemedio(4),2);
		c = new CajaTipo(cajasTipo.size()+1, e, remediosCaja);
		e.agregarCaja(c);
		cajasTipo.add(c);

		//System.out.println("Caja 1 creada OK");

		Hashtable<Remedio, Integer> remediosCaja2 = new Hashtable<Remedio, Integer>();
		CajaTipo c2 = null;
		Enfermedad e2 = null;
		//2da caja
		e2 = this.buscarEnfermedad(901);
		remediosCaja2.put(this.buscarRemedio(102),1);
		remediosCaja2.put(this.buscarRemedio(3),1);
		remediosCaja2.put(this.buscarRemedio(4),2);
		c2 = new CajaTipo(cajasTipo.size()+1, e2, remediosCaja2);
		cajasTipo.add(c2);
		e2.agregarCaja(c2);


		//System.out.println("Caja 2 creada OK");

		Hashtable<Remedio, Integer> remediosCaja3 = new Hashtable<Remedio, Integer>();
		CajaTipo c3 = null;
		Enfermedad e3 = null;
		//3er caja
		e3 = this.buscarEnfermedad(902);
		remediosCaja3.put(this.buscarRemedio(103),1);
		remediosCaja3.put(this.buscarRemedio(5),1);
		remediosCaja3.put(this.buscarRemedio(6),2);
		c3 = new CajaTipo(cajasTipo.size()+1, e3, remediosCaja3);
		cajasTipo.add(c3);
		e3.agregarCaja(c3);

		//System.out.println("Caja 3 creada OK");

		Hashtable<Remedio, Integer> remediosCaja4 = new Hashtable<Remedio, Integer>();
		CajaTipo c4 = null;
		Enfermedad e4 = null;
		//4ta caja
		e4 = this.buscarEnfermedad(903);
		remediosCaja4.put(this.buscarRemedio(104),2);
		remediosCaja4.put(this.buscarRemedio(7),1);
		remediosCaja4.put(this.buscarRemedio(8),2);
		c4 = new CajaTipo(cajasTipo.size()+1, e4, remediosCaja4);
		cajasTipo.add(c4);
		e4.agregarCaja(c4);

		//System.out.println("Caja 4 creada OK");

		Hashtable<Remedio, Integer> remediosCaja5 = new Hashtable<Remedio, Integer>();
		CajaTipo c5 = null;
		Enfermedad e5 = null;
		//5ta caja
		e5 = this.buscarEnfermedad(904);
		remediosCaja5.put(this.buscarRemedio(9),10);
		remediosCaja5.put(this.buscarRemedio(10),2);
		c5 = new CajaTipo(cajasTipo.size()+1, e5, remediosCaja5);
		cajasTipo.add(c5);
		e5.agregarCaja(c5);

		//System.out.println("Caja 5 creada OK");

		Hashtable<Remedio, Integer> remediosCaja6 = new Hashtable<Remedio, Integer>();
		CajaTipo c6 = null;
		Enfermedad e6= null;
		//6ta caja
		e6 = this.buscarEnfermedad(905);
		remediosCaja6.put(this.buscarRemedio(106),1);
		remediosCaja6.put(this.buscarRemedio(105),1);
		remediosCaja6.put(this.buscarRemedio(11),5);
		c6 = new CajaTipo(cajasTipo.size()+1, e6, remediosCaja6);
		cajasTipo.add(c6);
		e6.agregarCaja(c6);

		//System.out.println("Caja 6 creada OK");

		Hashtable<Remedio, Integer> remediosCaja7 = new Hashtable<Remedio, Integer>();
		CajaTipo c7 = null;
		Enfermedad e7 = null;

		//7ma caja
		e7 = this.buscarEnfermedad(906);
		remediosCaja7.put(this.buscarRemedio(107),2);
		remediosCaja7.put(this.buscarRemedio(101),2);
		remediosCaja7.put(this.buscarRemedio(12),2);
		c7 = new CajaTipo(cajasTipo.size()+1, e7, remediosCaja7);
		cajasTipo.add(c7);
		e7.agregarCaja(c7);

		//System.out.println("Caja 7 creada OK");

		Hashtable<Remedio, Integer> remediosCaja8 = new Hashtable<Remedio, Integer>();
		CajaTipo c8 = null;
		Enfermedad e8 = null;

		//8va caja
		e8 = this.buscarEnfermedad(907);
		remediosCaja8.put(this.buscarRemedio(13),1);
		remediosCaja8.put(this.buscarRemedio(14),4);
		remediosCaja8.put(this.buscarRemedio(15),7);
		c8 = new CajaTipo(cajasTipo.size()+1, e8, remediosCaja8);
		cajasTipo.add(c8);
		e8.agregarCaja(c8);


		//System.out.println("Caja 8 creada OK");

		Hashtable<Remedio, Integer> remediosCaja9 = new Hashtable<Remedio, Integer>();
		CajaTipo c9 = null;
		Enfermedad e9 = null;

		//9va caja
		e9 = this.buscarEnfermedad(908);
		remediosCaja9.put(this.buscarRemedio(101),1);
		remediosCaja9.put(this.buscarRemedio(109),4);
		remediosCaja9.put(this.buscarRemedio(111),2);
		c9 = new CajaTipo(cajasTipo.size()+1, e9, remediosCaja9);
		cajasTipo.add(c9);
		e9.agregarCaja(c9);

		//System.out.println("Caja 9 creada OK");

		Hashtable<Remedio, Integer> remediosCaja10 = new Hashtable<Remedio, Integer>();
		CajaTipo c10 = null;
		Enfermedad e10 = null;

		//10ma caja
		e10 = this.buscarEnfermedad(909);
		remediosCaja10.put(this.buscarRemedio(113),1);
		remediosCaja10.put(this.buscarRemedio(119),6);
		remediosCaja10.put(this.buscarRemedio(17),4);
		c10 = new CajaTipo(cajasTipo.size()+1, e10, remediosCaja10);
		cajasTipo.add(c10);
		e10.agregarCaja(c10);

		//System.out.println("Caja 10 creada OK");

		Hashtable<Remedio, Integer> remediosCaja11 = new Hashtable<Remedio, Integer>();
		CajaTipo c11 = null;
		Enfermedad e11 = null;

		//11va caja
		e11 = this.buscarEnfermedad(910);
		remediosCaja11.put(this.buscarRemedio(18),2);
		remediosCaja11.put(this.buscarRemedio(15),4);
		remediosCaja11.put(this.buscarRemedio(11),3);
		c11 = new CajaTipo(cajasTipo.size()+1, e11, remediosCaja11);
		cajasTipo.add(c11);
		e11.agregarCaja(c11);

		//System.out.println("Caja 11 creada OK");

		Hashtable<Remedio, Integer> remediosCaja12 = new Hashtable<Remedio, Integer>();
		CajaTipo c12 = null;
		Enfermedad e12 = null;

		//12va caja
		e12 = this.buscarEnfermedad(911);
		remediosCaja12.put(this.buscarRemedio(1),1);
		remediosCaja12.put(this.buscarRemedio(12),1);
		remediosCaja12.put(this.buscarRemedio(14),2);
		c12 = new CajaTipo(cajasTipo.size()+1, e12, remediosCaja12);
		cajasTipo.add(c12);
		e12.agregarCaja(c12);

		//System.out.println("Caja 12 creada OK");

		Hashtable<Remedio, Integer> remediosCaja13 = new Hashtable<Remedio, Integer>();
		CajaTipo c13 = null;
		Enfermedad e13 = null;

		//13va caja
		e13 = this.buscarEnfermedad(912);
		remediosCaja13.put(this.buscarRemedio(104),1);
		remediosCaja13.put(this.buscarRemedio(102),1);
		remediosCaja13.put(this.buscarRemedio(113),2);
		c13 = new CajaTipo(cajasTipo.size()+1, e13, remediosCaja13);
		cajasTipo.add(c13);
		e13.agregarCaja(c13);

		//System.out.println("Caja 13 creada OK");

		Hashtable<Remedio, Integer> remediosCaja14 = new Hashtable<Remedio, Integer>();
		CajaTipo c14 = null;
		Enfermedad e14 = null;

		//14va caja
		e14 = this.buscarEnfermedad(913);
		remediosCaja14.put(this.buscarRemedio(9),1);
		remediosCaja14.put(this.buscarRemedio(2),1);
		remediosCaja14.put(this.buscarRemedio(19),2);
		c14 = new CajaTipo(cajasTipo.size()+1, e14, remediosCaja14);
		cajasTipo.add(c14);
		e14.agregarCaja(c14);

		System.out.println("*** Cajas Tipo asociadas a Enfermedades creadas OK");
		Scanner entrada = new Scanner(System.in);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	 public void cargoPaises() 
     {
			paises.add(new Pais("AD","Andorra"));
			paises.add(new Pais("AE","Emiratos Arabes Unidos"));
			paises.add(new Pais("AF","Afganistán"));
			paises.add(new Pais("AG","Antigua y Barbuda"));
			paises.add(new Pais("AI","Anguilla"));
			paises.add(new Pais("AL","Albania"));
			paises.add(new Pais("AM","Armenia"));
			paises.add(new Pais("AN","Antillas Holandesas"));
			paises.add(new Pais("AO","Angola�"));
			paises.add(new Pais("AQ","Antartida"));
			paises.add(new Pais("AR","Argentina"));
			paises.add(new Pais("AS","Samoa Americana"));
			paises.add(new Pais("AT","Austria�"));
			paises.add(new Pais("AU","Australia"));
			paises.add(new Pais("AW","Aruba"));
			paises.add(new Pais("AZ","Azerbayan"));
			paises.add(new Pais("BA","Bosnia-Herzegovina"));
			paises.add(new Pais("BB","Barbados"));
			paises.add(new Pais("BD","Bangladesh"));
			paises.add(new Pais("BE","Belgica"));
			paises.add(new Pais("BF","Burkina Faso"));
			paises.add(new Pais("BG","Bulgaria"));
			paises.add(new Pais("BH","Bahrain"));
			paises.add(new Pais("BI","Burundi"));
			paises.add(new Pais("BJ","Benan"));
			paises.add(new Pais("BM","Islas Bermudas"));
			paises.add(new Pais("BN","Brunei Darussalam"));
			paises.add(new Pais("BO","Bolivia"));
			paises.add(new Pais("BR","Brasil"));
			paises.add(new Pais("BT","Bahamas"));
			paises.add(new Pais("BS","Butan"));
			paises.add(new Pais("BV","Islas Buvet"));
			paises.add(new Pais("BW","Botswana"));
			paises.add(new Pais("BY","Bielorrusia"));
			paises.add(new Pais("BZ","Belice"));
			paises.add(new Pais("CA","Canada"));
			paises.add(new Pais("CC","Isla de Cocos"));
			paises.add(new Pais("CD","Republica Democratica del Congo"));
			paises.add(new Pais("CF","Republica Centroafricana"));
			paises.add(new Pais("CG","Republica del Congo"));
			paises.add(new Pais("CH","Suiza"));
			paises.add(new Pais("CI","Costa de marfil"));
			paises.add(new Pais("CK","Islas Cook"));
			paises.add(new Pais("CL","Chile"));
			paises.add(new Pais("CM","Camerun"));
			paises.add(new Pais("CN","China"));
			paises.add(new Pais("CO","Colombia"));
			paises.add(new Pais("CR","Costa Rica"));
			paises.add(new Pais("CU","Cuba"));
			paises.add(new Pais("CV","Cabo Verde"));
			paises.add(new Pais("CX","Islas Christmas"));
			paises.add(new Pais("CY","Chipre"));
			paises.add(new Pais("CZ","Republica Checa"));
			paises.add(new Pais("DE","Alemania"));
			paises.add(new Pais("DJ","Djibouti"));
			paises.add(new Pais("DK","Dinamarca"));
			paises.add(new Pais("DM","Dominica"));
			paises.add(new Pais("DO","Republica Dominicana"));
			paises.add(new Pais("DZ","Argelia"));
			paises.add(new Pais("EC","Ecuador"));
			paises.add(new Pais("EE","Estonia"));
			paises.add(new Pais("EG","Egipto"));
			paises.add(new Pais("ER","Eritrea"));
			paises.add(new Pais("ES","España"));
			paises.add(new Pais("ET","Etiopía"));
			paises.add(new Pais("FI","Finlandia"));
			paises.add(new Pais("FJ","Fiji "));
			paises.add(new Pais("FK","Islas Malvinas"));
			paises.add(new Pais("FM","Micronesia "));
			paises.add(new Pais("FO","Islas Feroe"));
			paises.add(new Pais("FR","Francia"));
			paises.add(new Pais("GD","Granada"));
			paises.add(new Pais("GE","Georgia"));
			paises.add(new Pais("GF","Guyana Francesa"));
			paises.add(new Pais("GG","Guernsey"));
			paises.add(new Pais("GH","Ghana"));
			paises.add(new Pais("GI","Gibraltar"));
			paises.add(new Pais("GL","Groenlandia"));
			paises.add(new Pais("GM","Gambia"));
			paises.add(new Pais("GN","Guinea"));
			paises.add(new Pais("GP","Guadalupe"));
			paises.add(new Pais("GQ","Guinea Ecuatorial"));
			paises.add(new Pais("GR","Grecia"));
			paises.add(new Pais("GT","Guatemala"));
			paises.add(new Pais("GU","Guam"));
			paises.add(new Pais("GW","Guinea-Bissau"));
			paises.add(new Pais("GY","Guayana"));
			paises.add(new Pais("HK","Hong Kong"));
			paises.add(new Pais("HN","Honduras"));
			paises.add(new Pais("HR","Croacia"));
			paises.add(new Pais("HT","Haiti"));
			paises.add(new Pais("HU","Hungria"));
			paises.add(new Pais("ID","Indonesia"));
			paises.add(new Pais("IE","Irlanda"));
			paises.add(new Pais("IL","Israel"));
			paises.add(new Pais("IM","Isla de Man"));
			paises.add(new Pais("IN","India"));
			paises.add(new Pais("IQ","Iraq"));
			paises.add(new Pais("IR","Iran"));
			paises.add(new Pais("IS","Islandia"));
			paises.add(new Pais("IT","Italia"));
			paises.add(new Pais("JM","Jamaica"));
			paises.add(new Pais("JE","Jersey"));
			paises.add(new Pais("JO","Jordania"));
			paises.add(new Pais("JP","Japon"));
			paises.add(new Pais("KE","Kenia"));
			paises.add(new Pais("KG","Kyrgystán"));
			paises.add(new Pais("KH","Camboya"));
			paises.add(new Pais("KI","Kiribati"));
			paises.add(new Pais("KM","Islas Comores"));
			paises.add(new Pais("KN","San Kitts y Nevis"));
			paises.add(new Pais("KP","Corea del Norte"));
			paises.add(new Pais("KR","Corea del Sur"));
			paises.add(new Pais("KW","Kuwait"));
			paises.add(new Pais("KY","Islas Caimán"));
			paises.add(new Pais("KZ","Kazajistán"));
			paises.add(new Pais("LA","Laos"));
			paises.add(new Pais("LB","Líbano"));
			paises.add(new Pais("LC","Santa Lucía"));
			paises.add(new Pais("LI","Liechtenstein"));
			paises.add(new Pais("LK","Sri Lanka"));
			paises.add(new Pais("LR","Liberia"));
			paises.add(new Pais("LS","Lesoto"));
			paises.add(new Pais("LT","Lituania"));
			paises.add(new Pais("LU","Luxemburgo"));
			paises.add(new Pais("LV","Letonia"));
			paises.add(new Pais("LY","Libia"));
			paises.add(new Pais("MA","Marruecos"));
			paises.add(new Pais("MC","Mónaco"));
			paises.add(new Pais("MD","Moldavia"));
			paises.add(new Pais("MG","Madagascar"));
			paises.add(new Pais("MK","Macedonia"));
			paises.add(new Pais("MH","Islas Marshall"));
			paises.add(new Pais("ML","Mali "));
			paises.add(new Pais("MM","Birmania"));
			paises.add(new Pais("MN","Mongolia"));
			paises.add(new Pais("MO","Macao"));
			paises.add(new Pais("MP","Islas Marianas"));
			paises.add(new Pais("MQ","Martinica"));
			paises.add(new Pais("MR","Mauritania"));
			paises.add(new Pais("MS","Montserrat"));
			paises.add(new Pais("MT","Malta"));
			paises.add(new Pais("MU","Mauricio"));
			paises.add(new Pais("MV","Maldivas"));
			paises.add(new Pais("MW","Malawi"));
			paises.add(new Pais("MX","México"));
			paises.add(new Pais("MY","Malasia"));
			paises.add(new Pais("MZ","Mozambique"));
			paises.add(new Pais("NA","Namibia"));
			paises.add(new Pais("NC","Nueva Caledonia"));
			paises.add(new Pais("NE","Níger"));
			paises.add(new Pais("NF","Islas Norfolk"));
			paises.add(new Pais("NG","Nigeria"));
			paises.add(new Pais("NI","Nicaragua"));
			paises.add(new Pais("NL","Países Bajos"));
			paises.add(new Pais("NO","Noruega"));
			paises.add(new Pais("NP","Nepal"));
			paises.add(new Pais("NR","Nauru"));
			paises.add(new Pais("NT","Zona Neutral"));
			paises.add(new Pais("NU","Niue"));
			paises.add(new Pais("NZ","Nueva Zelanda"));
			paises.add(new Pais("OM","Omán"));
			paises.add(new Pais("PA","Panamá"));
			paises.add(new Pais("PE","Perú"));
			paises.add(new Pais("PF","Polinesia Francesa"));
			paises.add(new Pais("PG","Papúa Nueva Guinea"));
			paises.add(new Pais("PH","Filipinas"));
			paises.add(new Pais("PK","Pakistán"));
			paises.add(new Pais("PL","Polonia"));
			paises.add(new Pais("PM","San Pedro y Miquelón"));
			paises.add(new Pais("PN","Pitcairn"));
			paises.add(new Pais("PR","Puerto Rico"));
			paises.add(new Pais("PS","Territorios Palestinos"));
			paises.add(new Pais("PT","Portugal"));
			paises.add(new Pais("PW","Palau"));
			paises.add(new Pais("PY","Paraguay"));
			paises.add(new Pais("QA","Qatar"));
			paises.add(new Pais("RE","Isla Reunión"));
			paises.add(new Pais("RO","Rumanía"));
			paises.add(new Pais("RU","Rusia"));
			paises.add(new Pais("RW","Ruanda"));
			paises.add(new Pais("SA","Arabia Saudí"));
			paises.add(new Pais("SB","Islas Salomón"));
			paises.add(new Pais("SC","Islas Seychelles"));
			paises.add(new Pais("SD","Sudán"));
			paises.add(new Pais("SE","Suecia"));
			paises.add(new Pais("SG","Singapur"));
			paises.add(new Pais("SH","Santa Helena"));
			paises.add(new Pais("SI","Eslovenia"));
			paises.add(new Pais("SJ","Islas Svalbard y Jan Mayens"));
			paises.add(new Pais("SK","Eslovaquia"));
			paises.add(new Pais("SL","Sierra Leona"));
			paises.add(new Pais("SM","San Marino"));
			paises.add(new Pais("SN","Senegal"));
			paises.add(new Pais("SO","Somalia"));
			paises.add(new Pais("SR","Surinam"));
			paises.add(new Pais("SU","URSS"));
			paises.add(new Pais("ST","Santo Tomé y Príncipe"));
			paises.add(new Pais("SV","El Salvador"));
			paises.add(new Pais("SY","Siria"));
			paises.add(new Pais("SZ","Suazilandia"));
			paises.add(new Pais("TC","Islas Turks y Caicos"));
			paises.add(new Pais("TD","Chad"));
			paises.add(new Pais("TF","Tierras Australes y Antárticas Francesas"));
			paises.add(new Pais("TG","Togo"));
			paises.add(new Pais("TH","Tailandia"));
			paises.add(new Pais("TJ","Tayikistán"));
			paises.add(new Pais("TK","Tokelau"));
			paises.add(new Pais("TM","Turkmenistán"));
			paises.add(new Pais("TN","Túnez"));
			paises.add(new Pais("TO","Tonga"));
			paises.add(new Pais("TP","Timor Oriental"));
			paises.add(new Pais("TR","Turquía"));
			paises.add(new Pais("TT","Trinidad y Tobago"));
			paises.add(new Pais("TV","Tuvalu"));
			paises.add(new Pais("TW","Taiwán"));
			paises.add(new Pais("TZ","Tanzania"));
			paises.add(new Pais("UA","Ucrania"));
			paises.add(new Pais("UG","Uganda"));
			paises.add(new Pais("UK","Reino Unido"));
			paises.add(new Pais("UM","Islas Ultramarinas de Estados Unidos "));
			paises.add(new Pais("US","Estados Unidos de América"));
			paises.add(new Pais("UY","Uruguay"));
			paises.add(new Pais("UZ","Uzbekistán"));
			paises.add(new Pais("VA","Vaticano"));
			paises.add(new Pais("VC","San Vicente y las Granadinas"));
			paises.add(new Pais("VE","Venezuela"));
			paises.add(new Pais("VG","Islas Vírgenes Británicas"));
			paises.add(new Pais("VI","Islas Vírgenes Americanas"));
			paises.add(new Pais("VN","Vietnam"));
			paises.add(new Pais("VU","Vanuatu"));
			paises.add(new Pais("WF","Islas Wallis y Futuna"));
			paises.add(new Pais("WS","Samoa"));
			paises.add(new Pais("YE","Yemen"));
			paises.add(new Pais("YT","Mayotte"));
			paises.add(new Pais("YU","Yugoslavia (antiguo país)"));
			paises.add(new Pais("ZA","Sudáfrica"));
			paises.add(new Pais("ZM","Zambia"));
			paises.add(new Pais("ZR","Zaire (antiguo país)"));
			paises.add(new Pais("ZW","Zimbabwe"));
			
			
			Random rand = new Random(); 
			int index= rand.nextInt(paises.size());
			Pais p = paises.get(index);
     }
}
