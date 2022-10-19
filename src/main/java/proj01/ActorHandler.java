package proj01;

import java.util.ArrayList;

public class ActorHandler {

    private static ArrayList<Actor> actors = new ArrayList<>();
    private int size = 0;

    public ActorHandler() {}

    public int length() {
        return this.size;
    }

    public Actor get_actor (Actor a) {
        int i;
        if ((i = contains(a)) != -1) {
            return this.actors.get(i);
        }
        return null;
    }

    public Actor get_actor_index (int i) {
        if (i < this.size) {
            return actors.get(i);
        }
        return null;
    }

    public int contains (Actor a) {
        for (int i = 0; i < this.actors.size(); i++) {
            if (actors.get(i).get_id() == a.get_id()) {
                return i;
            }
        } return -1;
    }

    public void attach (Actor a) {
        Actor existing;
        if ((existing = get_actor(a)) != null) {
            existing.add_movie(a.get_movies().get(0));
        } else {
            add_actor(a);
        } this.size++;
    }

    private boolean add_actor (Actor a) {
        if (this.actors.contains(a)) {
            this.actors.add(a);  // THIS IS WRONG< FIX IT!!!
            return true;
        } else return false;
    }
}
