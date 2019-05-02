package hb.harrypotter.services;

import java.util.Collection;

import hb.harrypotter.pojos.Actor;
import hb.harrypotter.pojos.Identity;

public interface ActorService {

	Collection<Identity> getIdentities();

	Actor getActorByIdentity(Identity identity);

	int getNumberOfActorWichLastnameStartWithChar(char c);

	void setActors(String firstname, String lastname, String birthcity, String role, String birthdate);

}
