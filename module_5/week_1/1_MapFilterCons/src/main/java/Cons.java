
public class Cons {
    // the item inside this list node
    public int v;
    // The next element, null if nothing
    public Cons next;
    // creates a new Cons that applies function f on all elements
    public Cons map(F f) {
        return new Cons( f.apply(v), next == null ? null : next.map( f ));
    }
    // creates a new Cons with all elements that matches predicate p
    public Cons filter(P p) {
        if (p.filter(v)) return new Cons(v, next == null ? null : next.filter( p ));
        else return next == null ? null : next.filter( p );
    }
    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}