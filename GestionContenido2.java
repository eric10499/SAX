package FicherosAleatorios;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;


class GestionContenido2 extends DefaultHandler {  
	String artista = "";
	int contador = 0;
	public GestionContenido2(String artista){   
		super(); 
		this.artista = artista;
	} 
	public void startDocument(){
		System.out.println("Comienzo del documento XML");  
	}   
	public void endDocument(){ 
		System.out.println("Final del documento XML");  
		if (contador>0) {

			System.out.println("Este artista tiene " + contador + " disco/s.");

		}else {

			System.out.println("No hay discos de este autor");

		}
	}    
	public void startElement (String uri, String nombre, String nombreC, Attributes atts) {   
		System.out.printf("\tPrincipio Elemento: %s %n", nombre);
	}   
	public void endElement (String uri, String nombre, String nombreC){  
		System.out.printf("\tFin Elemento: %s %n",nombre);   
	}   
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {   
		String car = new String (ch, inicio, longitud);           
		car = car.replaceAll("[\t\n]","");            
		System.out.printf("\tCaracteres: %s %n", car);  
		if (car.equals(artista)) {

			contador++;

		}
	}
}
