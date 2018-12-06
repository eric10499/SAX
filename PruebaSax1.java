package FicherosAleatorios;
import java.io.*;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


public class PruebaSax1 {   

	public static void main (String [] args)           
			throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Indica el nombre del artista: ");
		String artista = scanner.nextLine();
		/* A continuación se crea objeto procesador XML - XMLReader -. 
		 * Durante la creación de este objeto se puede producir una excepción SAXException. */
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		
		/* A continuación, mediante setContentHandler establecemos que la clase que gestiona los eventos provocados por la lectura del XML será GestionContenido */ 
		GestionContenido gestor = new GestionContenido(); 
		reader.setContentHandler(gestor);
		/* Por último, se define el fichero que se va leer mediante InputSource y se procesa el documento XML mediante el método parse() de XMLReader */    
		InputSource fileXML = new InputSource ("C:\\\\Users\\\\ERIC\\\\Desktop\\\\discoteca.xml");
		reader.parse(fileXML); 
	} 
}
