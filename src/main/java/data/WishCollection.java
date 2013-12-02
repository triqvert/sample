package data;

import java.util.LinkedList;
import java.util.List;

public class WishCollection {
	private List<Wish> _wishes;

    public WishCollection() {
        this._wishes = new LinkedList<Wish>();
    }

    public List<Wish> getWishes() {
        return this._wishes;
    }

    public void addWish(Wish wish) {
        this._wishes.add(wish);
    }

    public void deleteMovie(Wish wish) {
        this._wishes.remove(wish);
    }

}
