package sbitneva;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SyncArrayList<E> extends ArrayList<E> {

    public SyncArrayList(int i) {
        super(i);
    }

    public SyncArrayList() {
        super();
    }

    public SyncArrayList(Collection<? extends E> collection) {
        super(collection);
    }

    @Override
    public void trimToSize() {
        synchronized (this) {
            super.trimToSize();
        }
    }

    @Override
    public Object clone() {
        synchronized (this) {
            return super.clone();
        }
    }

    @Override
    public void ensureCapacity(int i) {
        synchronized (this) {
            super.ensureCapacity(i);
        }
    }

    @Override
    public int size() {
        synchronized (this) {
            return super.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (this) {
            return super.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (this) {
            return super.contains(o);
        }
    }

    @Override
    public int indexOf(Object o) {
        synchronized (this) {
            return super.indexOf(o);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        synchronized (this) {
            return super.lastIndexOf(o);
        }
    }

    @Override
    public Object[] toArray() {
        synchronized (this) {
            return super.toArray();
        }
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        synchronized (this) {
            return super.toArray(ts);
        }
    }

    @Override
    public E get(int i) {
        synchronized (this) {
            return super.get(i);
        }
    }

    @Override
    public E set(int i, E e) {
        synchronized (this) {
            return super.set(i, e);
        }
    }

    @Override
    public boolean add(E e) {
        synchronized (this) {
            return super.add(e);
        }
    }

    @Override
    public void add(int i, E e) {
        synchronized (this) {
            super.add(i, e);
        }
    }

    @Override
    public E remove(int i) {
        synchronized (this) {
            return super.remove(i);
        }
    }

    @Override
    public boolean remove(Object o) {
        synchronized (this) {
            return super.remove(o);
        }
    }

    @Override
    public void clear() {
        synchronized (this) {
            super.clear();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        synchronized (this) {
            return super.addAll(collection);
        }
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        synchronized (this) {
            return super.addAll(i, collection);
        }
    }

    @Override
    protected void removeRange(int i, int i1) {
        synchronized (this) {
            super.removeRange(i, i1);
        }
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        synchronized (this) {
            return super.removeAll(collection);
        }
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        synchronized (this) {
            return super.retainAll(collection);
        }
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        synchronized (this) {
            return super.listIterator(i);
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        synchronized (this) {
            return super.listIterator();
        }
    }

    @Override
    public Iterator<E> iterator() {
        synchronized (this) {
            return super.iterator();
        }
    }

    @Override
    public List<E> subList(int i, int i1) {
        synchronized (this) {
            return super.subList(i, i1);
        }
    }

    @Override
    public void forEach(Consumer<? super E> consumer) {
        synchronized (this) {
            super.forEach(consumer);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        synchronized (this) {
            return super.spliterator();
        }
    }

    @Override
    public boolean removeIf(Predicate<? super E> predicate) {
        synchronized (this) {
            return super.removeIf(predicate);
        }
    }

    @Override
    public void replaceAll(UnaryOperator<E> unaryOperator) {
        synchronized (this) {
            super.replaceAll(unaryOperator);
        }
    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        synchronized (this) {
            super.sort(comparator);
        }
    }

    @Override
    public boolean equals(Object o) {
        synchronized (this) {
            return super.equals(o);
        }
    }

    @Override
    public int hashCode() {
        synchronized (this) {
            return super.hashCode();
        }
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        synchronized (this) {
            return super.containsAll(collection);
        }
    }

    @Override
    public String toString() {
        synchronized (this) {
            return super.toString();
        }
    }
}
