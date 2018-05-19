import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe di utilità per la gestione della scrittura di un file di testo.
 * La lasse consente di aprire e chiudere un file di testo in lettura o in scrittura e fornisce
 * i metodi per la scrittura di una stringa sul file (metodo toFile) e per la lettura di una stringa 
 * dal file (metodo fromFile)
 * @author Alessio Broghetti
 *
 */
public class TextFile 
{

	private BufferedReader reader;
	private BufferedWriter writer;
	private char mode;
	
	/**
	 * Costruttore
	 * @param filename pathname del file da aprire
	 * @param mode modalità di apertura del file R per sola lettura, W per sola scrittura
	 * @throws IOException nel caso non sia possibile accedere al file
	 * @throws FileException se il file è aperto in lettura
	 */
	public TextFile (String filename, char mode) throws IOException
	{
		//di default è aperto in lettura
		this.mode='R';
		if (mode=='w' || mode=='W')
		{
			this.mode='W';
			writer= new BufferedWriter(new FileWriter(filename,true));
		}
		else
			reader = new BufferedReader(new FileReader(filename));
	}
	
	/**
	 * Scrive una stringa sul file di testo
	 * @param line stringa da scrivere
	 * @throws IOException nel caso non sia possibile accedere al file
	 * @throws FileException 
	 */
	
	public void toFile(String line) throws IOException, FileException
	{
		if (mode=='R')
		{
			throw new FileException("Only write file!");	
		}
		writer.write(line);
		writer.newLine();
	}
	
	/**
	 * Legge una riga di testo dal file.
	 * @return riga letta
	 * @throws IOException nel caso non sia possibile accedere al file
	 * @throws FileException se il file è aperto in scrittura
	 * @throws FileException se è stata raggiunta la fine del file
	 */
	public String fromFile() throws IOException, FileException
	{
		String stringaLetta;
		
		if (mode=='w' || mode=='W')
		{
			 throw new FileException("Only read file!");
		}
		stringaLetta=reader.readLine();
		
		if (stringaLetta==null)
		{
			throw new FileException ("End of File!");
		}
		return stringaLetta;		
	}
	
	/**
	 * Chiude il file aperto
	 * @throws IOException nel caso non sia possibile accedere al file
	 */
	public void close() throws IOException
	{
		if (mode=='R')
			reader.close();
		else
			writer.close();
	}
}


