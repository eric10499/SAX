/*
 * PruebaSax2.java
 * 
 * Copyright 2018 ERIC <ERIC@DESKTOP-5T1N085>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * Crea un programa que devuelva el número de discos registrados en “discoteca.xml” de un determinado autor que le pasamos por consola. Si el autor carece de discos en el archivo, el programa devolverá un mensaje del estilo: “El autor <xxxxxx> no aparece en el archivo.
 * 
 * Fet per Eric Visier Sánchez
 * 
 */

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


public class PruebaSax2 {   

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
		GestionContenido2 gestor = new GestionContenido2(artista); 
		reader.setContentHandler(gestor);
		/* Por último, se define el fichero que se va leer mediante InputSource y se procesa el documento XML mediante el método parse() de XMLReader */    
		InputSource fileXML = new InputSource ("C:\\\\Users\\\\ERIC\\\\Desktop\\\\discoteca.xml");
		reader.parse(fileXML); 
	} 
}
