import java.io.IOException;

/**
 * Rappresenta la main class della ListaPc, visualizza il menu e permette di scegliere le operazione da svolgere sul singolo pc.
 * @author Alessio Broghetti
 *
 */
public class MainClass {

	static ConsoleInput tastiera=new ConsoleInput();
	/**
	 * Visualizza il menu e che consente di scegliere le operazione da svolgere sui pc.
	 * @param args Non sono previsti argomenti nell'ivocazione della classe.
	 */
	public static void main(String[] args)
	{

				String[] elencoFunzioni=new String[9];
				elencoFunzioni[0]="0-->Aggiungi pc";
				elencoFunzioni[1]="1-->Elimina pc attraverso il nome";
				elencoFunzioni[2]="2-->Elimina pc attraverso il codice identificativo";
				elencoFunzioni[3]="3-->Vendi pc";
				elencoFunzioni[4]="4-->Acquista pc";
				elencoFunzioni[5]="5-->Visualizza i pc con specifiche in ordine alfabetico";
				elencoFunzioni[6]="6-->Visualizza i pc con specifiche ordinati per quantità disponibile crescente";
				elencoFunzioni[7]="7-->Visualizza i pc la cui quantità disponibile è inferiore a un valore";
				elencoFunzioni[8]="8-->Esci";
				
				ListaPc listaPc=new ListaPc();
				
				try 
				{
					listaPc=listaPc.caricaListaPc("listaPc.bin");
					System.out.println("file caricati");
				} catch (ClassNotFoundException e1) 
				{
					System.out.println("Impossibile caricare oggetti Pc");
				}
				catch (IOException e1) 
				{
					System.out.println("Errore nel caricamento del file");
				}
				
				Menu menu=new Menu(elencoFunzioni);
				int scelta=0;
				
				do 
				{
					scelta=menu.scelta();
					switch (scelta) 
					{
					case 0:
					{
						Pc p=new Pc(0, "", 0);
						try 
						{
						//	do
						//	{
							System.out.println("Inserisci il codice identificativo del pc ");
							p.setIdentificativo(tastiera.readInt());
						//	for (int j = 1; j <= getElementi(); j++) 
						//	{
						//		if (p.getIdentificativo()==listaPc.Pc.getInfo().getIdentificativo(j))
						//				System.out.println("Codice identificativo già presente");
						//				i=1;
						//	}
						//	}while (i!=0);
							System.out.println("Inserisci il nome del pc ");
							p.setNome(tastiera.readString());
							System.out.println("Inserisci la quantità disponibile del pc ");
							p.setQuantitaDisponibile(tastiera.readInt());
							listaPc.InserisciComputer(p);
							System.out.println("pc aggiunto");
						} 
						catch (NumberFormatException e) 
						{
							System.out.println("Errore, il formato dei dati è errato ");	
						}
						catch (IOException e) 
						{
							System.out.println("Errore di sorgente informativa ");
						}
						
					}
					break;
					case 1:
					{	
						try
						{
							listaPc.eliminaComputer1("pcEliminati.txt");
						}
						catch (IOException e)
						{
							System.out.println("Errore, non è possbile accedere al file");
						}
						catch (ListaPcException e) 
						{
							System.out.println("Non esistono pc da eliminare nella lista ");
						}	
						catch(FileException e)
						{
							System.out.println("errore, il file su cui deve scrivere è già aperto in una operazione di lettura ");
						}
						catch(NumberFormatException e)
						{
							System.out.println("Errore, inserimento di un dato non conforme ");
						}
					}
					break;
					case 2:
					{
							try
							{
								listaPc.eliminaComputer2("pcEliminati.txt");
							}
							catch (IOException e)
							{
								System.out.println("Errore, non è possbile accedere al file");
							}
							catch (ListaPcException e) 
							{
								System.out.println("Non esistono pc da eliminare nella lista ");
							}	
							catch(FileException e)
							{
								System.out.println("errore, il file su cui deve scrivere è già aperto in una operazione di lettura ");
							}
							catch(NumberFormatException e)
							{
								System.out.println("Errore, inserimento di un dato non conforme ");
							}
					}
					break;
					case 3:
					{
						try
						{
							if (listaPc.Vendi()==2)
								System.out.println("Identificativo del pc inesistente ");
							else if (listaPc.Vendi()==1)
								System.out.println("Operazione riuscita ");
							else
								System.out.println("Numero di pc da vendere superiore al numero di pc disponibili ");
						}
						catch (IOException e)
						{
							System.out.println("Errore, non è possbile accedere al pc");
						}
						catch (ListaPcException e) 
						{
							System.out.println("Non esistono pc da vendere nella lista ");
						}
						catch(NumberFormatException e)
						{
							System.out.println("Errore, inserimento di un dato non conforme ");
						}
					}
					break;
					case 4:
					{
						try
						{
							if (listaPc.Acquista()==2)
								System.out.println("Identificativo del pc inesistente ");
							else
								System.out.println("Operazione riuscita ");
						}
						catch (IOException e)
						{
							System.out.println("Errore, non è possbile accedere al pc");
						}
						catch (ListaPcException e) 
						{
							System.out.println("Non esistono pc da vendere nella lista ");
						}
						catch(NumberFormatException e)
						{
							System.out.println("Errore, inserimento di un dato non conforme ");
						}
					}
					break;
					case 5:
					{
						
					}
					break;
					case 6:
					{
					try {
						Pc[] ArrayLista=listaPc.convertiListaPc();
						ArrayLista=ListaPc.OrdinaPcPerQuantitaDisponbile(ArrayLista);
						ListaPc listaordinata=new ListaPc();
						listaordinata.convertiPc(ArrayLista);
						System.out.println(listaordinata.toString());
					}
						
					catch (NumberFormatException e) 
					{
						System.out.println("Errore, inserimento di un dato non conforme ");
						
					} 
					catch (ListaPcException e) 
					{
						System.out.println("Non è presente alcun pc nella lista ");
					} catch (IOException e) 
					{
						System.out.println("Errore, non è possbile accedere ala lista ");
					} 
					}
					break;
					case 7:
					{
						try
						{
							System.out.println(listaPc.VisualizzaPcQuantitaInferiore());
						}
						catch(NumberFormatException e)
						{
							System.out.println("Errore, inserimento di un dato non conforme ");
						}
						catch(IOException e)
						{
							System.out.println("Errore, mancata lettura della lista ");
						}						
					}
					break;
					case 8:
					{
						try 
						{
							listaPc.salvaListaPc("listaPc.bin");
							System.out.println("salvataggio della lista di pc eseguito con successo");
						} 
						catch (IOException e) 
						{
							System.out.println("Errore, operazione annullata");
						}
					}
					break;
					default:
						System.out.println("Scelta non consentita");
						break;
					}
					System.out.println("Premi un tasto per continuare...");
					try
				 	{
						tastiera.readString();
					}
					 catch (NumberFormatException e)
					 {
						System.out.println(" ");
					}
					 catch (IOException e) 
					{
						
						 System.out.println(" ");
					}	
				} while (scelta!=8);	
	}
}

