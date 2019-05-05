package m2i.formation.java;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import m2i.formation.java.business.Eleve;
import m2i.formation.java.business.Matiere;
import m2i.formation.java.business.Note;
import m2i.formation.java.idao.IDAO_Eleve;
import m2i.formation.java.idao.IDAO_Note;
import m2i.formation.java.idao.impl.DAO_Eleve;
import m2i.formation.java.idao.impl.DAO_Note;
import m2i.formation.java.utilities.Utilitaire;


public class Principale {

	public static void main(String[] args) {
//		DAO_Eleve daoE = new DAO_Eleve();
//		IDAO_Note daoN = new DAO_Note();
		
		//======== Eleve ==============
		// Instancier un eleve
//		Eleve e1 = new Eleve(100, "PIPO", "Vanessa");
		
		// Affecter les notes a eleve e1
//		Note n1 = new Note(6, 12.5f, 1.0f, new Date(), Matiere.ANGLAIS, e1);
//		Note n2 = new Note(7, 15.5f, 1.0f, new Date(), Matiere.FRANCAIS, e1);
//		Note n3 = new Note(8, 16.0f, 1.0f, new Date(), Matiere.JAVA, e1);
//		e1.ajouterNote(n1);
//		e1.ajouterNote(n2);
//		e1.ajouterNote(n3);
		
		// Inserer eleve e1 et ses notes dans la base
//		System.out.println("Un Eleve a ete ajoute : " + daoE.create(e1));
		
		// Rechercher un Eleve avec son id
		//Eleve eleve4 = daoE.retreive(4);
		//System.out.println("\n============= Eleve portant id=1 est: ============\n" + eleve4);
		
		// Lister tous les eleves de la base
//		List<Eleve> eleves = new ArrayList<>();
//		eleves = daoE.retreiveAll();
//		System.out.println("\n============= Tous les eleves: ================");
//		for(Eleve e : eleves) {
//			System.out.println(e);
//		}
		
		// Mettre a jour un eleve
//		Eleve eleve2 = daoE.retreive(2);
		// Modifier Eleve 1
//		eleve2.setNom("VIVIAN");
//		eleve2.setPrenom("Thi Lanh");
		
//		System.out.println("\nNotes de eleve 2 avant la modif : " + eleve2.getNotes());
		
		// Modifier note numero 10
//		Note noteEleve1 = eleve2.getNotes().get(0);
//		noteEleve1.setValeur(15.50f);
		
		
			
//		System.out.println("============= Eleve portant id=1 a ete mis a jour: ============\n" + daoE.update(eleve2));
//		
//		System.out.println("\nNotes de eleve 2 apres la modif : " + eleve2.getNotes());
		
		// Supprimer un Eleve
//		System.out.println("\n============= Eleve portant id=100 a ete supprime: ============\n" + daoE.delete(100));
		
		//======== Note ==============
		// Rechercher une note dans la base
//		System.out.println("\n============= Note portant id=4 est: ============\n" + daoN.retreive(4));
		
		// Toutes les notes d'un eleve
//		System.out.println("\n============= Notes de Eleve 4 est: ============");
//		List<Note> notes = new ArrayList<>();
//		notes = daoE.retreiveToutesLesNotesDunEleve(4);
//		for(Note n : notes) {
//			System.out.println(n);
//		}
		
		// Lister toutes les notes
//		System.out.println("\n============= Notes : ============");
//		List<Note> AllNotes = new ArrayList<>();
//		AllNotes = daoN.retreiveAll();
//		for(Note n : AllNotes) {
//			System.out.println(n + " - " + n.getEleve().getNom());
//		}
		
		// Update Note
//		System.out.println("\n============= Notes updated: ============");
//		Note noteToUpdate = (Note) daoN.retreive(5);
//		noteToUpdate.setValeur(10f);
//		noteToUpdate.setCoef(2f);
//		noteToUpdate.setDate(new Date());
//		noteToUpdate.setMatiere(Matiere.MATHS);
//		System.out.println(daoN.update(noteToUpdate));
		
		//==================================================================
		// Tester le Map des requetes et java.lang.reflect.Field
		//==================================================================
		try {		
			Map<String, String> requetes = Utilitaire.ListeDesRequetes("m2i.formation.java.business.Eleve");
			for(Entry<String, String> entry : requetes.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			System.out.println("\n");
			
			Map<String, String> requetesBis = Utilitaire.ListeDesRequetes("m2i.formation.java.business.Eleve");
			for(Entry<String, String> entry : requetesBis.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			
			// createSql
			System.out.println("\n" + Utilitaire.genererCreateSql("m2i.formation.java.business.Eleve"));
			
			// retrieveAllSql
			System.out.println("\n" + Utilitaire.genererRetreiveAllSql("m2i.formation.java.business.Eleve"));
			
			// retrieveSql
			System.out.println("\n" + Utilitaire.genererRetreiveSql("m2i.formation.java.business.Eleve"));
			
			// updateSql
			System.out.println("\n" + Utilitaire.genererUpdateSql("m2i.formation.java.business.Eleve"));
			
			// deleteSql
			System.out.println("\n" + Utilitaire.genererDeleteSql("m2i.formation.java.business.Eleve"));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
