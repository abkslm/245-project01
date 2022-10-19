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

    public Actor get_by_index (int i) {
        if (i < this.size) {
            return actors.get(i);
        }
        return null;
    }

    public Actor get_last () {
        if (size >= 1) {
            return this.actors.get(size - 1);
        } else return this.actors.get(0);
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
            //System.out.println("Actor " + a.get_name() + " already exists!!");
            existing.add_movie(a.get_movies().get(0));
        } else {
            //System.out.println("Actor " + a.get_name() + " does not yet exist!!");
            add_actor(a);
            //System.out.println("Made actor: " + get_last().get_name());
        }
    }

    private boolean add_actor (Actor a) {
        if (!this.actors.contains(a)) {
            this.actors.add(a);
            this.size++;
            return true;
        } else return false;
    }
}
