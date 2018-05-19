/**
 * Eccezione, indica che un computer non è presente nel progetto
 * @author Alessio Broghetti
 *
 */
public class PcNonPresente extends Exception 
{
private String messaggio;
	
	public PcNonPresente(String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio; 
	}
}
