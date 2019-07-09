package hb.java.testHashmap;

import java.util.List;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import hb.java.exceptions.SchoolNotExistsException;
import hb.java.services.impl.ActorServiceImpl;
import hb.java.services.impl.BookServiceImpl;
import hb.java.services.impl.CharacterServiceImpl;
import hb.java.services.impl.SchoolServiceImpl;

public class LaunchMyMap {

	public static void main(String[] args) throws SchoolNotExistsException {
		// Instancier MyMap
		MyMap mymap = new MyMap();
		
		// Init Fruits
		mymap.getFruits().put("pom", "Pomme");
		mymap.getFruits().put("poi", "Poire");
		mymap.getFruits().put("cer", "Cerise");
		mymap.getFruits().put("kiw", "Kiwi");
		mymap.getFruits().put("kak", "Kaki");
		mymap.getFruits().put("ora", "Orange");
		
		// Display fruits
		Iterator<Entry<String, String>> iterFruits1 = mymap.getFruits().entrySet().iterator();
		
		while(iterFruits1.hasNext()) {
			Map.Entry<String, String> me1 = (Entry<String, String>)iterFruits1.next();
			System.out.println(me1.getKey() + ": " + me1.getValue());
		}
		
		// Sort fruits : sort key/value
		System.out.println("\nFruits triés par mot clé :");
		Iterator<Entry<String, String>> iterFruits2 = new TreeMap<String, String>(mymap.getFruits()).entrySet().iterator();
		while(iterFruits2.hasNext()) {
			Map.Entry<String, String> me2 = (Entry<String, String>)iterFruits2.next();
			System.out.println(me2.getKey() + ": " + me2.getValue());
		}
		
		// Sort fruits
		System.out.println("\n" + mymap);
		
		
		/*
		 * =========================================
		 * Test class Actor & ActorServiceImpl
		 * =========================================
		 */
		Calendar cal = Calendar.getInstance();
		ActorServiceImpl actorService = new ActorServiceImpl();
		
		cal.set(1971,01,27);
		Identity ident1 = new Identity("Jolie", "Angelina", cal.getTime(), "American");
		actorService.getActorIdentities().add(ident1);
		Actor a1 = new Actor(ident1, "Salt", "Evelyn Salt");
		actorService.getActors().put(ident1, a1);
				
		cal.set(1985,15,5);
		Identity ident2 = new Identity("Dujardin", "Jean", cal.getTime(), "French");
		actorService.getActorIdentities().add(ident2);
		Actor a2 = new Actor(ident2, "The artist", "George Valentin");
		actorService.getActors().put(ident2, a2);
		
		cal.set(1990,12,12); 
		Identity ident3 = new Identity("Danila", "Kozlovski", cal.getTime(), "Russian");
		actorService.getActorIdentities().add(ident3);
		Actor a3 = new Actor(ident3, "Matilda", "Vorontsov");
		actorService.getActors().put(ident3, a3);
		
		cal.set(1983,5,15);
		Identity ident4 = new Identity("Ullerup", "Emilie", cal.getTime(), "Danish");
		actorService.getActorIdentities().add(ident4);
		Actor a4 = new Actor(ident4, "Life On The Line", "Becky");
		actorService.getActors().put(ident4, a4);
		
		cal.set(2001,12,5);
		Identity ident5 = new Identity("Radcliffe", "Daniel", cal.getTime(), "Danish");
		actorService.getActorIdentities().add(ident5);
		Actor a5 = new Actor(ident5, "Harry Potter à l'école des sorciers", "Harry Potter");
		actorService.getActors().put(ident5, a5);

		
		// Display Entity & Actor
		System.out.println("\n"+ ident1);
		System.out.println(a1);
		
		// Test ActorServiceImpl
		
		// Identities
		System.out.println("\nIdentities: ");
		Iterator<Identity> iter = actorService.getActorIdentities().iterator();	
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// Actor by Identity
		System.out.println("\nNom et prénom de l'acteur que vous souhaitez récupérer: ");
		System.out.println(ident1.getLastName() + " " + ident1.getFirstName());
		System.out.println(actorService.getActorByIdentity(ident1));
		
		System.out.println(ident3.getLastName() + " " + ident3.getFirstName());
		System.out.println(actorService.getActorByIdentity(ident3));
		
		// Nombre d'acteurs dont le nom de famille commence par "R": 
		System.out.println("\nNombre d'acteurs dont le nom de famille commence par R: " + actorService.getNumberOfActorWhichLastnameStartWithChar('D'));
		
		/*
		 * =========================================
		 * Test class Book & BookServiceImpl
		 * =========================================
		 */
		BookServiceImpl bookService = new BookServiceImpl();
		cal.set(1981, 11, 30);
		Book b1 = new Book("La belle et la bête", "Jeanne-Marie Leprince de Beaumont", 360, 50, cal.getTime());
		b1.setDescription("Emma Watson se tient bien dans le rôle de Belle");
		bookService.addBook(b1);
		
		cal.set(1992, 11, 30);
		Book b2 = new Book("American Psycho", "Bret Easton Ellis", 220, 25, cal.getTime());
		b2.setDescription("American Psycho est un film réalisé par Mary Harron avec Christian Bale, Willem Dafoe. Synopsis : Au coeur des années Reagan, Patrick Bateman est un pur ...");
		bookService.addBook(b2);

		cal.set(2010, 1, 7);
		Book b3 = new Book("Long Week-end", "Joyce Maynard", 220, 25, cal.getTime());
		b3.setDescription("Cette année 1987, une chaleur caniculaire s'abat sur la côte Est pendant le long week-end de Labor Day. Henry a treize ans, vit avec sa mère, ne supporte pas la nouvelle épouse de son père, aimerait s’améliorer au base-ball et commence à être obsédé par les filles. Jusque-là, rien que de très ordinaire, sauf que sa mère, elle, ne l’est pas. Encore jeune et jolie, Adèle vit pratiquement retirée du monde et ne sort qu’en de rares circonstances. La rentr...");
		bookService.addBook(b3);
		
		cal.set(2008, 11, 6);
		Book b4 = new Book("Into the Wild", "Jon Krakauer", 220, 25, cal.getTime());
		b4.setDescription("Into the Wild ou Vers l'inconnu au Québec (Into the Wild en version originale) est un film américain réalisé par Sean Penn, sorti en 2007. Il s'agit de l'adaptation ...");
		bookService.addBook(b4);
		
		cal.set(1998, 9, 7);
		Book b5 = new Book("The Hours", "Michael Cunningham", 288, 12, cal.getTime());
		b5.setDescription("Hantés par le fantôme de Virginia Woolf et de son héroïne Mrs Dalloway, un roman magistral de Michael Cunningham et un film où rayonnent les actrices Meryl Streep, Nicole Kidman et Julianne Moore.");
		bookService.addBook(b5);
		
		cal.set(2011, 9, 29);
		Book b6 = new Book("Harry Potter à l'école des sorciers", "J. K. Rowling", 320, 15, cal.getTime());
		b5.setDescription("Pour et Mrs Dursley, qui habitaient au 4, Privet Drive, avaient toujours affirmé avec la plus grande fierté qu'ils étaient parfaitement nor­maux, merci pour eux. Jamais quiconque n'aurait imaginé qu'ils puissent se trouver impliqués dans quoi que ce soit d'étrange ou de mystérieux. Ils n'avaient pas de temps à perdre avec des sornettes.");
		bookService.addBook(b6);

		
		
		// Test BookService
		System.out.println("\nBooks:" );
		
		// tous les livres
		Iterator<Book> booksIter = bookService.getBooks().iterator();
		while(booksIter.hasNext()) {
			System.out.println(booksIter.next());		
		}
		
		// Livre à partir de son titre
		System.out.println("\nDétails du livre intitulé: 'Long Week-end' ");
		System.out.println(bookService.findBook("Long Week-end"));
		
		// Les id de tous les livres
		System.out.println("\nListe des clés des livres :");
		for(Book b:bookService.getBooks()) {
			System.out.println(b.getId());
		}
		System.out.println("\n");
		for(long key:bookService.getKeys()) {
			System.out.println(key);
		}
		
		
		/*
		 * =========================================
		 * Test class CharacterServiceImpl
		 * =========================================
		 */
		String[] characters = {
				"Harry Potter",
				"Ron Weasly",
				"Hermione Granger",
				"Albus Dumbledore",
				"Lord Voldemort",
				"Severus Rogue",
				"Ginny Weasly",
				"Drago Malefoy"
		};
		
		// All characters
		CharacterServiceImpl characterService = new CharacterServiceImpl(characters);
		System.out.println("\nLes personnages: ");
		System.out.println(characterService);
		
		// Characters start by 'H'
		System.out.println("\nLes personnages commençant par la lettre H : ");
		// System.out.println(characterService.getCharactersByStartLetter('H').length);
		for(String s:characterService.getCharactersByStartLetter('h')) {
			System.out.println(s);
		}
		
		// Characters end by 'Y'
		System.out.println("\nLes personnages commençant par la lettre Y : ");
		for(String e:characterService.getCharactersByEndLetter('Y')) {
			System.out.println(e);
		}
		
		/*
		 * =========================================
		 * Test class Scholl & SchoolServiceImpl
		 * =========================================
		 */
		// "C:\\Users\\HB\\workspace\\ExamJavaG8\\ressources\\schools.xml"
		
		SchoolServiceImpl schoolService = new SchoolServiceImpl();		
		List<School> schools = schoolService.getSchoolXml("C:\\Users\\HB\\workspace\\ExamJavaG8\\ressources\\schools.xml");
		
		// All schools
		System.out.println("\nToutes les écoles : ");
		for(School school:schools) {
			System.out.println(school);
		}
		
		// Find school "Serdaigle"
		System.out.println("\nDétails école Serdaigle: " + schoolService.getSchool("serdaigle"));
		
		
		
		
		
		
		
	}

}
