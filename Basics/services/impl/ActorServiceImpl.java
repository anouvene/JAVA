package hb.java.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import hb.java.services.ActorService;
import hb.java.testHashmap.Actor;
import hb.java.testHashmap.Identity;

public class ActorServiceImpl implements ActorService {
	private Collection<Identity> identities;
	private Map<Identity, Actor> actors;

	public ActorServiceImpl() {
		identities = new ArrayList();
		actors = new TreeMap<Identity, Actor>();
	}
	
	/**
	 * To retrieve a list of identities
	 * @return Collection of Identity
	 */
	public Collection<Identity> getActorIdentities() {
		return identities;
	}
	
	/**
	 * @return the actors
	 */
	public Map<Identity, Actor> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(Map<Identity, Actor> actors) {
		this.actors = actors;
	}

	/**
	 * To find an Actor by Identity
	 * @return Actor
	 */
	public Actor getActorByIdentity(Identity ident) {
		Iterator<Entry<Identity, Actor>> iter = actors.entrySet().iterator();
		Actor actor = null;
		while(iter.hasNext()) {
			Map.Entry<Identity, Actor> me = (Entry<Identity, Actor>)(iter).next();
			if(me.getKey().getLastName().compareTo(ident.getLastName()) == 0 ){
				actor = me.getValue();
				break;
			}
		}
		
		return actor;
	}

	/**
	 * To Get Number Of Actor Which Lastname Start With Char
	 * @return Actor
	 */
	public int getNumberOfActorWhichLastnameStartWithChar(char c) {
		Iterator<Entry<Identity, Actor>> iter = actors.entrySet().iterator();
		int nbActors = 0;
		while(iter.hasNext()) {
			Map.Entry<Identity, Actor> me = (Entry<Identity, Actor>)(iter).next();
			if(Character.toLowerCase(c) == me.getKey().getLastName().toLowerCase().charAt(0)){
				nbActors++;
			}
		}
		
		return nbActors;
	}


}
