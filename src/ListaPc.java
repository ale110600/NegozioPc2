import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe per la creazione di una lista di pc e per appositi interventi su di essa
 * @author Alessio Broghetti
 */
public class ListaPc implements Serializable
{
	static ConsoleInput tastiera=new ConsoleInput();
	private Nodo head;
	private int elementi;

	/**
	 * Costruttore della ListaPc
	 */
	public ListaPc ()
	{
		head=null;
		elementi=0;
	}

	/**
	 * Metodo getter che restituisce il numero di elementi(pc)
	 * @return
	 */
	public int getElementi() 
	{
		return elementi;
	}
	
	/**
	 * Metodo che consente di creare un nodo passando l'oggetto(pc) e il link del nodo 
	 * @param computer è l'oggetto pc della ListaPc
	 * @param link
	 * @return il nodo;
	 */
	private Nodo creaNodo(Pc computer,Nodo link)
	{
		Nodo nodo=new Nodo(computer);
		nodo.setLink(link);
		return nodo;	
	}
	
	/**
	 *  Restituisce il nodo nella posizione inserita come parametro
	 * @param posizione
	 * @return
	 * @throws ListaPcException  Eccezione sollevata nel caso in cui nella ListaPC non siano presenti pc
	 */
	private Nodo getLinkPosizione(int posizione) throws ListaPcException
	{
			
		Nodo p;
		p=head;
		int n=1;
		if(posizione<1 || posizione>getElementi())
			throw new ListaPcException ("posizione non valida");
		if(elementi==0)
			throw new ListaPcException ("Lista Vuota");
		while(p.getLink()!=null && n<posizione)
			{
				p=p.getLink();//p va a puntare al  nodo successivo
				n++;
			}
		return p;
	}
	
	/**
	 * Permette di inserire in testa alla lista della ListaPc un Pc
	 * @param Pc
	 */
	public void InserisciComputer(Pc pc)

	{
		Nodo p=creaNodo(pc, head);//il mio nodo avra il link che punta a cio che puntava head(nodo successivo)
		head=p;//head ora avra il link che punta  p
		elementi++;	
	}
	
	/**
	 * Consente di eliminare un pc all'interno della lista inserendo il nome
	 * @throws ListaPcException  Eccezione sollevata nel caso in cui nella lista non siano presenti computer
	  * @throws IOException che si verifica con una mancata lettura
	 * @throws NumberFormatException che si verifica con un inserimento dato non conforme
	 */
	public int eliminaComputer1() throws ListaPcException, NumberFormatException, IOException
	{
		if(elementi==0)
			throw new ListaPcException("lista pc vuota");
		Nodo p;
		String nome;
		System.out.println("Inserisci il nome del pc ");
		nome=(tastiera.readString());
		if (elementi==1)
		{
			head=null;
		}
		for (int i = 1; i <= getElementi(); i++) 
		{
			p=getLinkPosizione(i);
			if (p.getInfo().getNome().compareTo(nome)==0)
			{
				if (elementi==1)
				{
					head=null;
					return 1;
				}
				Nodo precedente=getLinkPosizione(i-1);
				precedente.setLink(p.getLink());
				elementi--;		
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * Consente di eliminare un pc all'interno della lista inserendo il nome
	 * @throws ListaPcException  Eccezione sollevata nel caso in cui nella lista non siano presenti computer
	 * @throws IOException che si verifica con una mancata lettura
	 * @throws NumberFormatException che si verifica con un inserimento dato non conforme
	 */
	public int eliminaComputer2(int identificativo) throws ListaPcException, NumberFormatException, IOException
	{
		if(elementi==0)
			throw new ListaPcException("lista pc vuota");
		Nodo p;
		for (int i = 1; i <= getElementi(); i++) 
		{
			p=getLinkPosizione(i);
			if (p.getInfo().getIdentificativo()==identificativo)
			{
				if (elementi==1)
				{
					head=null;
					return 1;
				}
				Nodo precedente=getLinkPosizione(i-1);
				precedente.setLink(p.getLink());
				elementi--;		
				return 1;
			}
		}	
		return 0;
	}
	
	/**	 
	 * Esporta su un file di testo il nome e l'identificativo del pc eliminato.
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e 
	 * dell'estensione del file di testo.
	 * @throws IOException Eccezione che vien sollevata nel caso non sia possibile accedere al file di testo
	 * @throws FileException Eccezione che si verifica nel caso in cui il file su cui scrivere è già aperto in lettura.
	 */
	public void esportaCSV1(String nomeFile) throws IOException, ListaPcException , FileException 
	{
		TextFile file=new TextFile(nomeFile,'W');
		String computerCSV;
		Pc computer;
		Nodo p;
		String nome;
		System.out.println("Inserisci il nome del pc ");
		nome=(tastiera.readString());
		for (int i = 1; i <= getElementi(); i++) 
			{
				p=getLinkPosizione(i);
				if (p.getInfo().getNome().compareTo(nome)==0)
				{
					computer=getPc(i);
					computerCSV=computer.getNome()+";"+computer.getIdentificativo()+";";
					file.toFile(computerCSV);	
				}
			}
		file.close();
	}
	
	/**	 
	 * Esporta su un file di testo il nome e l'identificativo del pc eliminato.
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e 
	 * dell'estensione del file di testo.
	 * @throws IOException Eccezione che vien sollevata nel caso non sia possibile accedere al file di testo
	 * @throws FileException Eccezione che si verifica nel caso in cui il file su cui scrivere è già aperto in lettura.
	 */
	public void esportaCSV2(int identificativo,String nomeFile) throws IOException, ListaPcException , FileException  
	{
		TextFile file=new TextFile(nomeFile,'W');
		String computerCSV;
		Pc computer;
		Nodo p;
		for (int i = 1; i <= getElementi(); i++) 
			{
				p=getLinkPosizione(i);
				if (p.getInfo().getIdentificativo()==identificativo)
				{
					computer=getPc(i);
					computerCSV=computer.getNome()+";"+computer.getIdentificativo()+";";
					file.toFile(computerCSV);	
				}
			}
		file.close();
	}
	
	/**
	 * Consente di vendere una quantità id pc in base all'identificativo
	 * @return
	 * @throws ListaPcException Eccezione sollevata nel caso in cui nella ListaPc non siano 
	 * presenti computer o la posizione non sia valida
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int Vendi() throws ListaPcException, NumberFormatException, IOException
	{
		int identificativo;
		int quantita;
		System.out.println("Inserisci l'identificativo della tipologia di pc da vendere ");
		identificativo=(tastiera.readInt());
		System.out.println("Inserisci il numero di pc da vendere ");
		quantita=(tastiera.readInt());
		if (elementi==0)
		{
			throw new ListaPcException("Lista vuota");
		}
		Nodo p;
		for (int i = 1; i <= getElementi(); i++) 
		{
			p=getLinkPosizione(i);
			if (p.getInfo().getIdentificativo()==identificativo)
			{
				if (p.getInfo().getQuantitaDisponibile()<quantita)
				{
					return 0;
				}
				int x;
				x=p.getInfo().getQuantitaDisponibile()-quantita;
				p.getInfo().setQuantitaDisponibile(x);
				return 1;
			}
		}
		return 2;
	}
	
	/**
	 * Consente di acquistare una quantità id pc in base all'identificativo
	 * @return
	 * @throws ListaPcException Eccezione sollevata nel caso in cui nella ListaPc non siano 
	 * presenti computer o la posizione non sia valida
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int Acquista() throws ListaPcException, NumberFormatException, IOException
	{
		int identificativo;
		int quantita;
		System.out.println("Inserisci l'identificativo della tipologia di pc da acquistare ");
		identificativo=(tastiera.readInt());
		System.out.println("Inserisci il numero di pc da acquistare ");
		quantita=(tastiera.readInt());
		if (elementi==0)
		{
			throw new ListaPcException("Lista vuota");
		}
		Nodo p;
		for (int i = 1; i <= getElementi(); i++) 
		{
			p=getLinkPosizione(i);
			if (p.getInfo().getIdentificativo()==identificativo)
			{
				int x;
				x=p.getInfo().getQuantitaDisponibile()+quantita;
				p.getInfo().setQuantitaDisponibile(x);
				return 1;
			}
		}
		return 2;
	}
	
	/**
	 * Consente di restituire un pc scelto in base alla sua posizione nella lista
	 * @param posizione del pc
	 * @return
	 * @throws ListaPcException Eccezione sollevata nel caso in cui nella ListaPc non siano 
	 * presenti computer o la posizione non sia valida
	 */
	public Pc getPc(int posizione) throws ListaPcException
	{
		if (elementi==0)
		{
			throw new ListaPcException("Lista vuota");
		}
		if(posizione<=0 ||posizione>elementi)
		{
			throw new ListaPcException("posizione non valida");
		}
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();
	}

	/**
	 * Consente di restituire il link di un pc in base al suo nome
	 * @param nome del computer da cercare
	 * @return oggetto cercato
	 * @throws ListaPcException  Eccezione sollevata nel caso in cui nella ListaPc 
	 * non siano presenti computer 
	 * @throws PcNonPresente il Pc non è presente
	 */
	public Pc getPcNome(String nome) throws ListaPcException, PcNonPresente
	{
		if (elementi==0)
		{
			throw new ListaPcException("Nessun pc trovato");
		}
		Nodo p=head;
		while(p!=null)
		{
			if(p.getInfo().getNome().compareTo(nome)==0)
				return p.getInfo();
			p=p.getLink();
		}
		
		throw new PcNonPresente("Nessun pc corriponde al nome indicato");
	}	
	
	/**
	 * Converte la lista dei Pc  della ListaPc in un array di Pc 
	 * @return array di Pc
	 * @throws ListaPcException  Eccezione sollevata nel caso in cui nella ListaPc 
	 * non siano computer
	 */
	public Pc[] convertiListaPc() throws ListaPcException
	{
		Nodo n;
		Pc[] arrayListaPc=new Pc[elementi];
		for (int i = 0; i < elementi; i++) 
		{
			n=getLinkPosizione(i+1);
			arrayListaPc[i]=n.getInfo();
		}
		return arrayListaPc;
	
	}
	
	/**
	 * Converte un array di Pc in una lista(ListaPc) 
	 * @param Pc
	 */
	void convertiPc(Pc[] pc)
	{
		for (int i = pc.length; i >0; i--) 
		{
			InserisciComputer(pc[i-1]);
		}
	}

	/**
	 * Scambia di posizione due Pc presenti in un array di Pc
	 * @param array
	 * @param pos1
	 * @param pos2
	 * @return valore intero che può essere:
	 *  -1 se la posizione inserita non è valida;
	 *  0 se l'operazione è andata a buon fine;
	 */
	public static int scambia(Pc[]array,int pos1,int pos2)
	{
		Pc p;
		if(pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			p=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=p;
			return 0;
		}
	}
	
	/**
	 * Crea una copia di un array di Pc
	 * @param array
	 * @return array di Pc
	 */
	private static Pc[] copiaArray(Pc[] array)
	{
		Pc[]arrayCopia=new Pc[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
			arrayCopia[i]=array[i];
		return arrayCopia;
	}
	
	/**
	 * Ordina un array di pc in base alla quantita disponile di ogni pc in ordine crescente
	 * @param array
	 * @return array di metodi ordinato in ordine crescente
	 */
	public static Pc[] OrdinaPcPerQuantitaDisponbile(Pc[] array) throws NumberFormatException, IOException
	{
		Pc[] arrayCopia=copiaArray(array);
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if(arrayCopia[i].getQuantitaDisponibile()>=arrayCopia[j].getQuantitaDisponibile())
				{
					scambia(arrayCopia,i,j);
				}
				else 
				{
				scambia(arrayCopia,i,i);
				}
			}
		}
		return arrayCopia;
	}
	/*
	public void CopiaLista(Pc computer) throws ListaPcException
	{
		if (elementi==0)
		{
			throw new ListaPcException("Nessun pc trovato");
		}
		ListaPc listaPcCopia=new ListaPc();
		for (int i = 1; i <=getElementi(); i++)
		{
			for (int j = i; j <=getElementi(); j++) 
			
		}
	}
	
	public void OrdinaPcPerQuantitàDisponbile2()
	{
		
	}
	*/
	
	/**
	 * Restituisce una stringa che contiene  l'elenco di tutti i Pc con quantità disponibile inferiore a un 
	 * valore inserito
	 * @throws IOException che si verifica con una mancata lettura
	 * @throws NumberFormatException che si verifica con un inserimento dato non conforme
	 */
	public String VisualizzaPcQuantitaInferiore() throws NumberFormatException, IOException
	{
		String risultato="listaPc";
		if(elementi==0)
			return risultato+="-->";
		Nodo p=head;
		int quantita;
		System.out.println("Inserisci il valore ");
		quantita=(tastiera.readInt());
		while(p!=null)
		{
			if (p.getInfo().getQuantitaDisponibile()<quantita)
			{
			risultato+="-->"+p.getInfo().toString()+'\n';
			}
			p=p.getLink();
		}
		return risultato;
	}
	
	/**
	 * Restituisce una stringa contenente l'elenco dei pc presenti nella lista pc
	 * 
	 */
	public String toString()
	{
		String risultato="ListaPc ";
		if(elementi==0)
			return risultato+="--> ";//se non ho elementi avro head con la freccia
		Nodo p=head;
		while(p!=null)
		{
			risultato+="--> "+p.getInfo().toString()+'\n';
			p=p.getLink();
		}
		return risultato;
	}

	/**
	 * Si occupa di serializzare la lista pc in esecuzione su un file di tipo .bin Eccezione sollevata nel 
	 * caso in cui nella ListaPc non siano presenti computer 
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e 
	 * dell'estensione del file di testo.
	 * @throws IOException Eccezione che viene sollevata nel caso non sia possibile accedere al file di testo
	 */
	public void salvaListaPc(String nomeFile) throws IOException
	{
		FileOutputStream file=new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);//salva l oggetto sul quale invoco il metodo
		writer.flush();
		file.close();
	}
	
	
	/**
	 *  Si occupa di deserializzare una lista di pc da un file .bin ciò è necessario per rendere persistente un ogetto
	 * @param nomeFile Nome del file in cui salvare le attività. Il nome deve essere comprensivo del path e 
	 * dell'estensione del file di testo.
	 * @throws  IOException Eccezione che vien sollevata nel caso non sia possibile accedere al file di testo
	 * @throws ClassNotFoundException sollevata quando il reference e l’oggetto letto sono di classi diverse
	 */
	public ListaPc caricaListaPc(String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader=new ObjectInputStream(file);
		ListaPc listaPc;
		listaPc=(ListaPc)(reader.readObject());//casting
		file.close();
		return listaPc;
	}
}
