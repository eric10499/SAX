package FicherosAleatorios;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;


class GestionContenido extends DefaultHandler {  
	
	int contador = 0;
	public GestionContenido(String caracter){   
		super();  
		} 
	public void startDocument(){
			System.out.println("Comienzo del documento XML");  
			}   
	public void endDocument(){ 
		System.out.println("Final del documento XML");  
		System.out.println("Hay " + contador + " discos.");
		}    
	public void startElement (String uri, String nombre, String nombreC, Attributes atts) {   
		System.out.printf("\tPrincipio Elemento: %s %n", nombre);
		if(nombreC.equals("CD")) {
			contador++;
		}
		}   
	public void endElement (String uri, String nombre, String nombreC){  
		System.out.printf("\tFin Elemento: %s %n",nombre);   
		}   
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {   
		String car = new String (ch, inicio, longitud);           
		car = car.replaceAll("[\t\n]","");            
		System.out.printf("\tCaracteres: %s %n", car);    
    }
	}
