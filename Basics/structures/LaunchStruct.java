package hb.java.structures;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
// import java.util.Set;
// import java.util.Set;




public class LaunchStruct {

	public static void main(String[] args) {
		// trouverla position d'un element dans un tableau
		StructData sd = new StructData();
		int [] tab = {11, 33, 55, 8, 0, 12};
		
		int position = sd.findValueInSortedTab(tab, 33);
		// {0, 8, 11, 12, 33, 55}
		System.out.println("33 se trouve à la position " + position + " du tableau");

		// Redimensionner un tableau dynamiquement
		System.out.println("Taille du tableau avant redimension " + tab.length);
		int[] resizeTab = sd.resizeTab(tab, 3);
		
		System.out.println("Taille du tableau apres redimension " + resizeTab.length);
		System.out.println("Elements du nouveau tableau: ");
		for(int i=0; i<resizeTab.length; i++) {
			System.out.println("[" + i + "] = " + resizeTab[i]);
		}
		
		// Tester une liste chaine avec for
		List<String> names = new ArrayList<String>();
		names.add("safia");
		names.add("nouvene");
		names.add("nono");
		names.add("bido");
		names.add("facho");
		
		sd.printListWithFor(names);
		
		// Tester une liste chaine avec while
		sd.printListWithWhile(names);
		
		// trier une Collection de Strings
		System.out.println("\n----- Noms triés -----");
		Collections.sort(names);
		sd.printListWithFor(names);
		
		
		// Implémentation du dictionnaire
		// Parcours des clés avec for et while
		// Parcours des valeurs avec for et while
		// Parcours des entrées avec for et while
		// Une entrée est un couple clé/valeur.
		
		Map<String, String> dico = new HashMap<String, String>();
		dico.put("pomme", "apple");
		dico.put("banane", "banana");
		dico.put("ananas", "pineaple");
		dico.put("cerise", "cherry");
		dico.put("fraise", "stramberry");
		
		// Clé avec for
		System.out.println("\nClés du dictionnaire (FR) avec for :");
		for(String key: dico.keySet()){
			System.out.println(key);
		}
		
		// Clé avec while
		System.out.println("\nClés du dictionnaire (FR) avec while :");
		// Set<String> sDico = dico.keySet();
		// Iterator<String> iDicoKey = sDico.iterator();
		Iterator<String> iDicoKey = dico.keySet().iterator();
		while(iDicoKey.hasNext()){
			System.out.println(iDicoKey.next());
		}
		
		// Valeur avec for
		System.out.println("\nValeurs du dictionnaire (EN) avac for :");
		for(String value: dico.values()){
			System.out.println(value);
		}
		
		// Valeur avec while
		System.out.println("\nValeurs du dictionnaire (EN) with while :");
		// Collection<String> cDico = dico.values();
		// Iterator<String> iDicoVal = cDico.iterator();
		Iterator<String> iDicoVal = dico.values().iterator();		
		while(iDicoVal.hasNext()){
			System.out.println(iDicoVal.next());
		}
				
		// --- Entry clé/valeur avec for ---
		System.out.println("\nClés/Valeurs du dictionnaire (FR/EN) avec for :");
		// With for
		for(Entry<String, String> entry: dico.entrySet()){
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		// --- Entry clé/valeur avec while ---		
		System.out.println("\nClés/Valeurs du dictionnaire (FR/EN) avec while :");
		// Set<Entry<String, String>> dicoEntries = dico.entrySet(); // Initialiser un Set de type Entry<String, String>
		// Iterator<Entry<String, String>> iterDicoEntries = dicoEntries.iterator(); // Initailiser un Iterator du meme Type		
		Iterator<Entry<String, String>> iterDicoEntries = dico.entrySet().iterator();
				
		while(iterDicoEntries.hasNext()) {
			// System.out.println(iterDicoEntries.next());
			Map.Entry<String, String> me = (Map.Entry<String, String>)iterDicoEntries.next();
			System.out.println(me.getKey() + "/ " + me.getValue());			
		}
		System.out.println("\n");
		
		
		
		// Tester les méthodes isKeyInMap et isValueInMap
		if(sd.isKeyInMap(dico, "pomme")){
			System.out.println("La clé pomme est dans le dictionnaire");
		}
		
		if(!sd.isKeyInMap(dico, "toto")){
			System.out.println("La clé toto n'est pas dans le dictionnaire");
		}

		if(sd.isValueInMap(dico, "apple")){
			System.out.println("La valeur apple est dans le dictionnaire");
		}
		
		if(!sd.isValueInMap(dico, "titi")){
			System.out.println("La valeur titi n'est pas dans le dictionnaire");
		}
		
		// Tester classe User
		User user1 = new User(1, "NOUVENE", "Antoine");
		User user2 = new User(11, "JOLIE", "Angelina");
		User user3 = new User(8, "NGUYEN", "Minh Tuan");
		User user4 = new User(5, "VO", "Thi Lanh");
		User user5 = new User(2, "KIM", "Sandra");
		
		// Initialiser une listes d'utilisateurs
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		// List users avant tri :
		System.out.println("\nListe des utilisateurs avant le tri :");
		sd.printListUser(users);
		
		// List users apres tri par idUser:
		Collections.sort(users, new User());
		System.out.println("Liste des utilisateurs apres le tri :");
		sd.printListUser(users);
		
		/* ================ Hasmap login/User ======================*/
		
		Map<String, User> usersLogin = new HashMap<String, User>();
		
		// Add login to users
		user1.setLogin("anouv");
		user2.setLogin("angie");
		
		// Add login/user into a map
		usersLogin.put(user1.getLogin(), user1);
		usersLogin.put(user2.getLogin(), user2);
		
		// Parcourir un Map Login/User :
		
		// Clé
		System.out.println("\nlogin :");
		for(String login: usersLogin.keySet()){
			System.out.println(login);
		}
		
		// Valeur
		System.out.println("\nUser :");
		for(User user: usersLogin.values()){
			System.out.println(user);
		}
		
		// Couple clé/valeur
		System.out.println("\nClés/Valeurs: Login/User :");
		for(Entry<String, User> entry: usersLogin.entrySet()){
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		
		
		
	}

}
