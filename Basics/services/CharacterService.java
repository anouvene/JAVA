package hb.java.services;

public interface CharacterService {
	/**
	 * Number of Character in String[]
	 * @return int
	 */
	public int getNumberOfCharacters();
	
	/**
	 * To retrieve String[] of characters by start with 'c'
	 * @param s char
	 * @return String[]
	 */
	public String[] getCharactersByStartLetter(char s);
	
	/**
	 * To retrieve String[] of characters by end with 'c'
	 * @param e char
	 * @return String[]
	 */
	public String[] getCharactersByEndLetter(char e);
	
}
