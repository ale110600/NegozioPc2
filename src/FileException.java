/**
 * Eccezione, indica il verificarsi di una eccezione nella gestione dei un file di testo.
 * @author Alessio Broghetti
 *
 */
public class FileException extends Exception
{
	
	private String motivoEccezione;
	public FileException(String message)
	{
		motivoEccezione=message;
	}
	
	public String getMessage()
	{
		return motivoEccezione;
	}
	

}

