package hb.java.flux_xml;

import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlReader {

	public static Element racine;
	
	public static void main(String[] args) {
		// Import fichier xml pour lecture
		File file = new File("C:\\Users\\HB\\workspace\\Initiation_Java\\ressources\\trainees.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document document = null;
		
		try {
			db = dbf.newDocumentBuilder();
			document = (Document) db.parse(file);
		} catch (SAXException | IOException | ParserConfigurationException e ) {
			e.printStackTrace();
		}
		
		// Element racine
		final Element racine = document.getDocumentElement();
		
		// Noeuds enfant
		final NodeList trainees = racine.getChildNodes();

		
		// Elements
		Element trainee, lastname, firstname, email, hobbies, hobby, title, director, singer;
		
		// Parcourir les noeuds
		for (int i=0; i<trainees.getLength(); i++) {
			if (trainees.item(i).getNodeType() == Node.ELEMENT_NODE) { // Si Noeud du type Element
				// Noeud trainee
				trainee = (Element) trainees.item(i);
				System.out.println("\nsexe : " + trainee.getAttribute("sexe"));
					// Noeud lastname
					lastname = (Element) trainee.getElementsByTagName("lastname").item(0);
					System.out.println("lastname : " + lastname.getTextContent());
					// Noeud firstname
					firstname = (Element) trainee.getElementsByTagName("firstname").item(0);
					System.out.println("firstname : " + firstname.getTextContent());
					// Noeud email
					email = (Element) trainee.getElementsByTagName("email").item(0);
					System.out.println("email : " + email.getTextContent());
					
					// Noeud Hobbies
					NodeList hobbiesNodes = null;
					hobbiesNodes = trainee.getElementsByTagName("hobbies");						
					for (int j=0; j<hobbiesNodes.getLength(); j++) {
						
						hobbies = (Element) hobbiesNodes.item(j);
						System.out.println("hobbies : " + "\n{");
						
						// Noeud Hobby
						NodeList hobbyNodes = null;
						hobbyNodes = hobbies.getElementsByTagName("hobby");
						for (int k = 0; k < hobbyNodes.getLength(); k++) {
							hobby = (Element) hobbyNodes.item(k);
							
							if (hobby.getAttribute("category").equals("cinema")) { // cinema
								title = (Element) hobby.getElementsByTagName("title").item(0);
								director = (Element) hobby.getElementsByTagName("director").item(0);
								System.out.println("  cinema : " + title.getTextContent() + ", director : " + director.getTextContent());
							}
							if (hobby.getAttribute("category").equals("music")) { // music
								title = (Element) hobby.getElementsByTagName("title").item(0);
								singer = (Element) hobby.getElementsByTagName("singer").item(0);
								System.out.println("  music : " + title.getTextContent() + ", singer : " + singer.getTextContent());
							}
							if (hobby.getAttribute("category").equals("sport")) { // sport
								System.out.println("  sport : " + hobby.getTextContent());
							}
							
						}
						
						System.out.println("}");
		
					}
			
						
			}
		}

	}

}
