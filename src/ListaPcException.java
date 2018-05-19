/**
 * Eccezione. Indica che la lista dei pc non è presente
 * @author Alessio Broghetti
 *
 */
public class ListaPcException extends Exception 
{
	private String messaggio;
	
	public ListaPcException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio; 
	}
}
