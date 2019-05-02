package hb.harrypotter.services.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import hb.harrypotter.pojos.Actor;
import hb.harrypotter.pojos.Identity;
import hb.harrypotter.services.ActorService;
import hb.harrypotter.utils.DateUtil;



public class ActorServiceImpl implements ActorService {
	private Map<Identity, Actor> actors = new TreeMap<>();
	private DateUtil dateUtil = new DateUtil();
	
	public ActorServiceImpl() {}

	// Set actors
	@Override
	public void setActors(String lastname, String firstname, String birthcity, String role, String birthdate) {
		this.actors.put(new Identity(lastname, firstname), new Actor(birthcity, role, dateUtil.getDateFromString(birthdate), lastname, firstname));
	}

	/**
	 * Liste d'objets Identity
	 */
	@Override
	public Collection<Identity> getIdentities() {
		List<Identity> identities = new ArrayList<>();
		for(Identity identity : actors.keySet()) {
			identities.add(identity);
		}
		return identities;
	}
	
	/**
	 * Récupérer un Actor par son Identity
	 */
	@Override
	public Actor getActorByIdentity(Identity identity) {
		Actor actor = null;
		if(actors.containsKey(identity)) {
			actor =  actors.get(identity);
		}
		
		return actor;
	}
	
	/**
	 * Récupérer le nombre d'acteurs dont le nom commence par ...
	 */
	@Override
	public int getNumberOfActorWichLastnameStartWithChar(char c) {
		c = Character.toUpperCase(c);
		int nombre = 0;
		for(Actor actor : actors.values()) {
			if(actor.getIdentity().getLastname().charAt(0) == c) {
				nombre++;
			}
		}
		return nombre;
	}


	

}
