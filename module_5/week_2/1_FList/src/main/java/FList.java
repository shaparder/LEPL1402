import java.awt.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FList<A> implements Iterable<A> {
    /**
     * Returns an empty FList
     */
    public static <A> FList<A> nil() {
        return (Nil<A>) Nil.INSTANCE;
    }

    /**
     * Creates a new list with a prepended to this list
     */
    public final FList<A> cons(final A a) {
        return new Cons(a, this);
    }

    /**
     * @return the number of elements in the list
     */
    public abstract int length();

    /**
     * @return true if the list is empty, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * @return the head of the list.
     * Throws NoSuchElementException if the list is empty
     */
    public abstract A head();

    /**
     * @return the tail of the list (i.e. the sublist without the first element of this list)
     * Throws NoSuchElementException if the list is empty
     */
    public abstract FList<A> tail();

    /**
     * Returns a new list with the output of the function f applied to each element of this list
     */
    public abstract <B> FList<B> map(Function<A,B> f);

    /**
     * Creates a new list with only the element that fullfill the predicate f (i.e. f(elem) == true).
     */
    public abstract FList<A> filter(Predicate<A> f);


    public Iterator<A> iterator() {
        return new Iterator<A>() {

            private FList<A> list = FList.this;

            public boolean hasNext() {
               return list.length() > 0;
            }

            public A next() {
                if (hasNext()) {
                    A nxt = list.head();
                    list = list.tail();
                    return nxt;
                } else {
                    throw  new NoSuchElementException();
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // empty list methods etc
    private static final class Nil<A> extends FList<A> {
        public static final Nil<Object> INSTANCE = new Nil();

        @Override
        public int length() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public A head() {
            throw new NoSuchElementException();
        }

        @Override
        public FList<A> tail() {
            throw new NoSuchElementException();
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return FList.nil();
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            return FList.nil();
        }


    }

    // immutable list implementation
    private static final class Cons<A> extends FList<A> {
        A head;
        FList<A> tail;
        int length;

        Cons(A head, FList<A> tail) {
            this.head = head;
            this.tail = tail;
            this.length = tail.length() + 1;
        }

        @Override
        public int length() {
            return length;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public A head() {
            if (isEmpty()) throw new NoSuchElementException();
            else return head;
        }

        @Override
        public FList<A> tail() {
            if (isEmpty()) throw new NoSuchElementException();
            else return tail;
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return new Cons<B>( f.apply( head ), tail.isEmpty() ? FList.nil() : tail.map( f ) );
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            return f.test( head ) ? new Cons<A>(head, tail.isEmpty() ? FList.nil() : tail.filter( f )) : tail.isEmpty() ? FList.nil() : tail.filter( f );
        }

    }

}
