import java.io.Serializable;

/**
 * Classe per la creazione di un oggetto Pc
 * @author Alessio Broghetti
 */
public class Pc implements Serializable
{
	private int identificativo;
	private String nome;
	private int quantitaDisponibile;
	
	//metodi costruttore
	
	/**
	 * Costruttore della classe Pc.
	 * Richiede l'identificativo,il nome e la quantita disponibile di un determianto pc.
	 * @param identificativo nome quantitaDisponibile
	 */
	public Pc(int identificativo, String nome,int quantit‡Disponibile)
	{
		setIdentificativo(identificativo);
		setNome(nome);
		setQuantitaDisponibile(quantit‡Disponibile);
	}
	
	/**
	 * Costruttore di copia. Restituisce un oc copiando un altro pc passatogli come parametro
	 * @param pc da cui creare una copia
	 */
	public Pc(Pc p)
	{
		setIdentificativo(p.getIdentificativo());
		setNome(p.getNome());
		setQuantitaDisponibile(p.getQuantitaDisponibile());
	}
		
	//metodi getter e setter
	
	/**
	 * Metodo getter che restituisce l'identificativo del pc
	 * @return codice identificativo del pc
	 */
	public int getIdentificativo() 
	{
		return identificativo;
	}
	/**
	 * Metodo setter che consente di dare il codice identificativo al pc
	 * @param Identificativo codice identificativo del pc
	 */
	public void setIdentificativo(int identificativo) 
	{
		this.identificativo = identificativo;
	}
	/**
	 * Metodo getter che restituisce il nome del pc
	 * @return nome del pc
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * Metodo setter che consente di dare il nome al pc
	 * @param nome del pc
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	/**
	 * Metodo getter che restituisce la quanita disponibile del pc
	 * @return quantitaDisponible del pc
	 */
	public int getQuantitaDisponibile() 
	{
		return quantitaDisponibile;
	}
	/**
	 * Metodo setter che consente di asseganre una quantita disponibile al pc
	 * @param quantitaDisponibile del pc
	 */
	public void setQuantitaDisponibile(int quantit‡Disponibile) 
	{
		this.quantitaDisponibile = quantit‡Disponibile;
	}
	
	//altri metodi
	
	/**
	 * Restituisce una stringa contenente le informazioni sul pc: identificativo, nome, quantitaDisponibile
	 *se non esistono oggetti pc verr‡ mostrato : "...";
	 */		
	public String toString()
	{
		return(getIdentificativo()+" "+getNome()+" "+getQuantitaDisponibile());
	}
	
	
}
