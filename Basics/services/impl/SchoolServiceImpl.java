package hb.java.services.impl;

import java.util.ArrayList;
import java.util.List;

import hb.java.exceptions.SchoolNotExistsException;
import hb.java.services.SchoolService;
import hb.java.testHashmap.School;

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

public class SchoolServiceImpl implements SchoolService {
	List<School> schoolsList;
	
	public SchoolServiceImpl() {
		schoolsList = new ArrayList<School>();
	}
	
	
	@Override
	public School getSchool(String schoolName) throws SchoolNotExistsException {
		School schoolFound = null;
		for(School school:schoolsList) {
			int compare = school.getName().compareToIgnoreCase(schoolName);
			if(compare == 0) {
				System.out.println(school.getName());
				schoolFound = school;			
				return schoolFound;			
			}			
		}		
		throw new SchoolNotExistsException("L'école " + schoolName + " que vous recherchez n'existe pas");	
	}

	@Override
	public List<School> getSchoolXml(String schoolFileName) {
		// Import fichier xml pour lecture
		File file = new File(schoolFileName);
		
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
		final NodeList schools = racine.getChildNodes();		
		// Elements
		Element school, id, name, desc, keywords;
		
		// Objet School 
		
		// Parcourir les noeuds
		for (int i=0; i<schools.getLength(); i++) {
			if (schools.item(i).getNodeType() == Node.ELEMENT_NODE) { // Si Noeud du type Element
				// Noeud school
				school = (Element) schools.item(i);
				
				// Noeud id
				id = (Element) school.getElementsByTagName("id").item(0);
				// Noeud name
				name = (Element) school.getElementsByTagName("name").item(0);				
				// Noeud desc
				desc = (Element) school.getElementsByTagName("desc").item(0);				
				// Noeud keywords
				keywords = (Element) school.getElementsByTagName("keywords").item(0);
				
				// Add school to schoolsList
				schoolsList.add(new School(
					Integer.parseInt(id.getTextContent()),
					name.getTextContent(),
					desc.getTextContent(),
					keywords.getTextContent().split(" ")
				));
			}
		}
		
		return schoolsList;
	}

}
