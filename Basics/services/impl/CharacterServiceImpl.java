package hb.java.services.impl;

import java.util.Arrays;

import hb.java.services.CharacterService;

public class CharacterServiceImpl implements CharacterService {

	private String[] characters;
	
	
	/**
	 * @param characters
	 */
	public CharacterServiceImpl(String[] characters) {
		this.characters = characters;
	}

	/**
	 * Number of Character in String[]
	 * @return int
	 */
	public int getNumberOfCharacters() {
		return this.characters.length;
	}

	/**
	 * To retrieve String[] of characters by start with 'c'
	 * @param s char
	 * @return String[]
	 */
	public String[] getCharactersByStartLetter(char s) {
		char c = Character.toLowerCase(s);
		StringBuilder charactersFound = new StringBuilder();
		for(int i=0; i<this.characters.length; i++) {
			if(this.characters[i].toLowerCase().charAt(0) == c) {
				charactersFound.append(this.characters[i]).append("-");
			}
		}
		return charactersFound.toString().split("-");
	}

	/**
	 * To retrieve String[] of characters by end with 'c'
	 * @param e char
	 * @return String[]
	 */
	public String[] getCharactersByEndLetter(char e) {
		char c = Character.toLowerCase(e);
		StringBuilder charactersFound = new StringBuilder();
		for(int i=0; i<this.characters.length; i++) {
			if(this.characters[i].toLowerCase().charAt(this.characters[i].length()-1) == c) {
				charactersFound.append(this.characters[i]).append("-");
			}
		}
		return charactersFound.toString().split("-");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CharacterServiceImpl [characters=");
		builder.append(Arrays.toString(characters));
		builder.append(", getNumberOfCharacters()=");
		builder.append(getNumberOfCharacters());
		builder.append("]");
		return builder.toString();
	}
	
	

}
