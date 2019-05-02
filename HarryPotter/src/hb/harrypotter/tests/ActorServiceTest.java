package hb.harrypotter.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import hb.harrypotter.pojos.Actor;
import hb.harrypotter.pojos.Identity;
import hb.harrypotter.services.ActorService;
import hb.harrypotter.services.impl.ActorServiceImpl;

public class ActorServiceTest {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ActorService as = new ActorServiceImpl();
		
		String filePath = new File("").getAbsolutePath();
		JSONParser parser = new JSONParser();
		
        try {
        	// Get json file
            Object jsonReader = parser.parse( new FileReader (filePath +  "/resources/actors.json" ) );
            
            // Json object
            JSONObject jsonObject = (JSONObject) jsonReader;
            
            // Get actors list
            JSONArray actorList = (JSONArray) jsonObject.get("actors");
            
            // Acrors list to array
            Object[] arr = actorList.toArray();
            
            for(int i=0; i<actorList.size(); i++) {
            	JSONObject actor = (JSONObject) actorList.get(i);
            	
            	// Display data
            	String lastname = (String) actor.get("lastname");
            	String firstname = (String) actor.get("firstname");            	
            	String role = (String) actor.get("role");
            	String birthdate = (String) actor.get("birthdate");
            	String birthcity = (String) actor.get("birthcity");
            	
            	// Set actors list
            	as.setActors(lastname, firstname, birthcity, role, birthdate);
           }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
        // ========= Liste des nom/prenom des acteurs dans Harry Potter =============
        System.out.println("Liste des nom/prenom des acteurs dans Harry Potter");
        for(Identity identity : as.getIdentities()) {
        	System.out.println(identity);
        }
        
        // Fiche détaillée d'un acteur
        List<String> lstStr = new ArrayList<>();
        
        System.out.println("Nom et prénom de l\'acteur que vous souhaitez récupérer et taper y pour finir la saisie:");
        String lastnameFirstname;
        do {
        	lastnameFirstname = "";
            lastnameFirstname = sc.nextLine();

        } while (lastnameFirstname.trim().equals(""));
        
        // Stoker lastname et firtname dans dans un arrayList lstStr
        StringTokenizer tokens = new StringTokenizer(lastnameFirstname, " ");
        while(tokens.hasMoreTokens()) {
        	lstStr.add(tokens.nextToken().toString());   	
        }
        
        // Lancer la recherche d'un Actor via l'objet Identity(lastname, firstname)
        
        if(!lstStr.isEmpty() && lstStr.size() > 1) {
        	Actor actor = as.getActorByIdentity(new Identity(lstStr.get(0), lstStr.get(1)));       	
        	if(actor != null) {
        		System.out.println(actor);     		
        	} else {
        		System.out.println("Pas trouvé");
        	}
        	
        } else {
        	System.out.println("Pas trouvé");
        }
        
        
        // ========= Nombre d'ateurs dont le nom de famille commence par la lettre R =============
        
        System.out.println("Nombre d'ateurs dont le nom de famille commence par la lettre R: " + as.getNumberOfActorWichLastnameStartWithChar('R'));
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
