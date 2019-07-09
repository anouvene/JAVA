package hb.java.hashmap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LaunchHashMap {

	public static void main(String[] args) {
		
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
		// Set<Entry<String, String>> dicoEntries = dico.entrySet(); // Récupérer les entrées
		// Iterator<Entry<String, String>> iterDicoEntries = dicoEntries.iterator(); // Placer un Iterator sur les entrées		
		Iterator<Entry<String, String>> iterDicoEntries = dico.entrySet().iterator();
				
		while(iterDicoEntries.hasNext()) {
			// System.out.println(iterDicoEntries.next());
			Map.Entry<String, String> me = (Map.Entry<String, String>)iterDicoEntries.next();
			System.out.println(me.getKey() + "/" + me.getValue());			
		}
		
		// Trier par clé avec TreeMap
		Map<String, String> tm = new TreeMap<String, String>(dico);
        System.out.println("\nMap trié avec while :");
        Iterator<Entry<String, String>> iterDicoEntries2 = tm.entrySet().iterator();
        while(iterDicoEntries2.hasNext()){
            Map.Entry<String, String> me2 = (Map.Entry<String, String>)iterDicoEntries2.next();
            System.out.println(me2.getKey() + "/" + me2.getValue());
        }
        
        System.out.println("\nMap trié avec for :");
        Iterator<Entry<String, String>> iterDicoEntries3 = tm.entrySet().iterator();
        for(String fruit:tm.values()) {
        	Map.Entry<String, String> me3 = (Map.Entry<String, String>)iterDicoEntries3.next();
        	System.out.println(me3.getKey() + "/" + fruit);
        }
	}

}
