import sun.jvm.hotspot.memory.PlaceholderEntry;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

    public abstract class FList<A> implements Iterable<A>{

        public final boolean isNotEmpty() {
            return this instanceof Cons;
        }

        public final boolean isEmpty() {
            return this instanceof Nil;
        }

        public abstract int length();

        public abstract A head();

        public abstract FList<A> tail();

        public static <A> FList<A> nil() {
            return (Nil<A>) Nil.INSTANCE;
        }

        public final FList<A> cons(final A a) {
            return new Cons(a, this);
        }

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

        public static final class Nil<A> extends FList<A> {
            private static  final Nil<Object> INSTANCE = new Nil();

            @Override
            public int length() {
                return 0;
            }

            @Override
            public A head() { return null; }

            @Override
            public FList<A> tail() { return FList.nil(); }

        }

        public static final class Cons<A> extends FList<A> {

            private A head;
            private FList<A> tail;
            private int length;

            public Cons(A head, FList<A> tail){
                this.head = head;
                this.tail = tail;
                length = tail.length() + 1;
            }

            @Override
            public int length() {
                return length;
            }

            @Override
            public A head() {
                if ( isEmpty() ) throw new NoSuchElementException();
                return head;
            }

            @Override
            public FList<A> tail() {
                if ( isEmpty() ) throw new NoSuchElementException();
                return tail;
            }

        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append('[');
            for (A item: this) {
                output.append(item.toString()).append(", ");
            }

            output.append(']');
            return output.toString();
        }

    }

