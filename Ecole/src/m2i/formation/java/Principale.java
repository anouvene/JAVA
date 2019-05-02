package m2i.formation.java;


public class Principale {

	public static void main(String[] args) {
		// Ecole, Classe
		Ecole ecole1 = new Ecole("St Exupery");
		Classe classe1 = new Classe("S001");
		
		// Eleves
		Eleve eleve1 = new Eleve("Nguyen", "Minh Tuan");
		Eleve eleve3 = new Eleve("Nouvene", "Antoine");
				
		// Matieres
		eleve1.addMatiere(Matiere.ANGLAIS);
		eleve1.addMatiere(Matiere.JAVA);
		eleve1.addMatiere(Matiere.FRANCAIS);
		
		eleve3.addMatiere(Matiere.ANGLAIS);
		eleve3.addMatiere(Matiere.JAVA);
		
		// Notes
		Note note1 = new Note(Matiere.ANGLAIS, 15.00f, Devoirs.DM);
		Note note2 = new Note(Matiere.ANGLAIS, 17.00f, Devoirs.DM);
		Note note7 = new Note(Matiere.ANGLAIS, 13.00f, Devoirs.DM);
		Note note8 = new Note(Matiere.ANGLAIS, 18.00f, Devoirs.DM);

		Note note3 = new Note(Matiere.JAVA, 5.00f, Devoirs.DM);

		eleve1.addNote(note1);
		eleve1.addNote(note8);
		eleve1.addNote(note3);
		
		eleve3.addNote(note7);
		eleve3.addNote(note2);
		eleve3.addNote(note3);
		
		// Ajouter les eleves
		classe1.addEleve(eleve1);
		classe1.addEleve(eleve3);	
				
		// Afficher ecole1
		ecole1.addClasse(classe1);
		System.out.println(ecole1);
		
		// Afficher classe1
		System.out.println(classe1);
		
		// Afficher la moyenne de eleve1
		System.out.println("Moyenne generale de eleve1 => " +eleve1.moyenne() +"\n");		

		// Moyenne d'un eleve par matiere
		System.out.println("\nNotes de eleve1: " + eleve1.getNotes());
		
//		System.out.println("Moyenne de eleve1 en anglais " + eleve1.moyenneParMatiere(Matiere.ANGLAIS));
//		System.out.println("Moyenne de eleve1 en java " + eleve1.moyenneParMatiere(Matiere.JAVA));
//		System.out.println("Moyenne de eleve1 en francais " + eleve1.moyenneParMatiere(Matiere.FRANCAIS));
		
		// Parcourie la liste des matieres et afficher seulement la moyenne des matires qui sont notees	
		for(Matiere m : eleve1.getMatieres()) {
			if(eleve1.moyenneParMatiere(m) != -1)
				System.out.print("\nMoyenne de eleve1 en " + m + ": "+ eleve1.moyenneParMatiere(m) +"\n");				
		}

		// Eleve2
		Eleve eleve2 = new Eleve("Lennon", "Bob");
		Note note4, note5, note6;
		note4 = new Note(Matiere.MATHS, 12f, Devoirs.DM);
		note5 = new Note(Matiere.ANGLAIS, 10f, Devoirs.DS);
		note6 = new Note(Matiere.JAVA, 19.5f, Devoirs.DM);
		eleve2.addNote(note4);
		eleve2.addNote(note5);
		eleve2.addNote(note6);
		
		// TODO Ameliorer la methode addMatiere() de la classe Eleve
		// Faire en sorte d'ajouter aussi les matieres liées aux notes
		
		classe1.addEleve(eleve2);
		System.out.println("\nEleve 2 " + eleve2);

		// Moyenne classe1
		System.out.println("Moyenne generale de la classe1: " + classe1.moyenne());
		System.out.println("Moyenne de la classe1 en anglais: " + classe1.moyenneParMatiere(Matiere.ANGLAIS));

		// Classement des eleves selon leur moyenne générale
		Classement classement1 = classe1.classementGeneral();

		System.out.println("\nClassement general des eleves de classe1:");
		System.out.println(classement1);

		eleve2.addNote(note4);
		eleve2.addNote(new Note(Matiere.JAVA, 8.5f, Devoirs.DM));

		Classement classement2 = classe1.classementGeneral();
		
		System.out.println("\nClassement2 general");
		System.out.println(classement2);
		
		System.out.println("\nClassement1 general");
		System.out.println(classement1);

		Classement classement3 = classe1.classementParMatiere(Matiere.ANGLAIS);
		System.out.println("Classement3 en Anglais");
		System.out.println(classement3);

		Classement classementFiltre;
		
		NoteFilter<Note> filter = (Note n) -> n.getMatiere() == Matiere.ANGLAIS || n.getMatiere() == Matiere.JAVA;
		NoteFilter<Note> filter2 = (Note n) -> n.getMatiere() == Matiere.ANGLAIS && n.getValeur() < 0;
		NoteFilter<Note> filter3 = (Note n) -> n.getMatiere() == Matiere.ANGLAIS && n.getValeur() > 13;
		
		classementFiltre = classe1.classementFiltre(filter3);
		System.out.println("Classement filtre ");
		System.out.println(classementFiltre);

//		class Args {
//			int x;
//			Object o;
//		}
//		Args a = new Args();
//		a.x = 0;
//		a.o = note1;
//		System.out.println("a.o " + a.o + " " + Integer.toHexString((a.o.hashCode())));
//
//		NoteFilter<Args> filter3 = new NoteFilter<Args>() {
//
//			@Override
//			public boolean filter(Args t) {
//				t.x = 1;
//				t.o = 3;
//				return t.o.hashCode() == t.x;
//			}
//
//		};

		
	}

}
