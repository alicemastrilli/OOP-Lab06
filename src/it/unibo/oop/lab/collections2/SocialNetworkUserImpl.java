package it.unibo.oop.lab.collections2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

	HashMap <U, String> mappa;
	
    public SocialNetworkUserImpl(final String firstName,final String surname,final String user, final int userAge) {
		super(firstName, surname, user, userAge);
		this.mappa = new HashMap<>();
	}

    public SocialNetworkUserImpl(final String firstName,final String surname,final String user) {
		super(firstName, surname, user, -1);
		this.mappa = new HashMap<>();
	}
	/*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
  
    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

   
    public boolean addFollowedUser(final String circle, final U user) {
    	if (!mappa.containsKey(user)) {
    		mappa.put(user, circle);
    		return true;
    	}
        return false;
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Collection <U> Seguiti  = new ArrayList<>();
    	for (U elem : mappa.keySet() ) {
    		if(mappa.get(elem) == groupName) {
    			Seguiti.add(elem);
    		}
    	}
        return Seguiti;

    }

    @Override
    public List<U> getFollowedUsers() {
    	ArrayList <U> Seguiti  = new ArrayList<>();
    	for(U elem : mappa.keySet()) {
    		Seguiti.add(elem);
    	}
    	return Seguiti;
    }

}
