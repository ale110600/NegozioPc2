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
	
	public Pc(int identificativo, String nome,int quantit‡Disponibile)
	{
		setIdentificativo(identificativo);
		setNome(nome);
		setQuantitaDisponibile(quantit‡Disponibile);
	}
	
	public Pc(Pc p)
	{
		setIdentificativo(p.getIdentificativo());
		setNome(p.getNome());
		setQuantitaDisponibile(p.getQuantitaDisponibile());
	}
		
	//metodi getter e setter
	
	public int getIdentificativo() 
	{
		return identificativo;
	}
	public void setIdentificativo(int identificativo) 
	{
		this.identificativo = identificativo;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public int getQuantitaDisponibile() 
	{
		return quantitaDisponibile;
	}
	public void setQuantitaDisponibile(int quantit‡Disponibile) 
	{
		this.quantitaDisponibile = quantit‡Disponibile;
	}
	
	//altri metodi
	
	public String toString()
	{
		return(getIdentificativo()+" "+getNome()+" "+getQuantitaDisponibile());
	}
	
	
}
