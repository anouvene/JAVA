package hb.java.services;

import java.util.Collection;
import hb.java.testHashmap.Actor;
import hb.java.testHashmap.Identity;

public interface ActorService {
	/**
	 * To retrieve a list of Identity
	 * @return Collection of Identity
	 */
	public Collection<Identity> getActorIdentities();
	
	/**
	 * To find an Actor by Identity
	 * @return Actor
	 */
	public Actor getActorByIdentity(Identity iden);
	
	/**
	 * To Get Number Of Actor Which Lastname Start With Char
	 * @return Actor
	 */
	public int getNumberOfActorWhichLastnameStartWithChar(char c);
}

