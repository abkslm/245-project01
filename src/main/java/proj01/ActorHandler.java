package proj01;

import java.util.ArrayList;

/**
 * A class to handle Actor classes, allowing to access an ArrayList of Actors with customised methods
 */
public class ActorHandler {

    private final ArrayList<Actor> actors = new ArrayList<>();
    private int size = 0;

    public ActorHandler() {}

    /**
     * A getter for an Actor, by an Actor object. Not sure what this is for but something needs it :)
     * @param a -> An actor to be found.
     * @return -> The requested actor.
     */
    public Actor get_actor (Actor a) {
        int i;
        if ((i = contains(a)) != -1) {
            return this.actors.get(i);
        }
        return null;
    }

    /**
     * A getter for an Actor, by its index in the list.
     * @param i -> Index of the desired Actor
     * @return -> The Actor object, or null if none.
     */
    public Actor get_by_index (int i) {
        if (i < this.size) {
            return actors.get(i);
        }
        return null;
    }

    /**
     * Checks if an Actor exists within the list, using id values.
     * @param a -> Actor to be checked for presence
     * @return -> An int, the index of the actor if found. -1 if not found.
     */
    public int contains (Actor a) {
        for (int i = 0; i < this.actors.size(); i++) {
            if (actors.get(i).get_id() == a.get_id()) {
                return i;
            }
        } return -1;
    }

    /**
     * Adds an actor to the actor list
     * @param a -> Actor to be added
     */
    private void add_actor (Actor a) {
        if (!this.actors.contains(a)) {
            this.actors.add(a);
            this.size++;
        }
    }

    /**
     * Takes an actor object, checks if that actor exists:
     *      If not: adds the Actor to the running list.
     *      If so: attaches the contents of the object to the existing Actor.
     * @param a -> Actor to be attached
     */
    public void attach (Actor a) {
        Actor existing;
        if ((existing = get_actor(a)) != null) {
            existing.add_movie(a.get_movies().get(0));
        } else {
            add_actor(a);
        }
    }

    /**
     * A void wrapper for the sort function within ArrayHandler
     */
    public void sort() {
        ArrayHandler.Sorter.sort(this.actors);
    }

    /**
     * A wrapper for the search function within ArrayHandler
     * @param target -> Actor to be searched for (targeted by user).
     * @return -> An int, index of the Actor within the list.
     */
    public int search (String target) {
        return ArrayHandler.Searcher.actor(this.actors, target);
    }

}
