package com.company.pr;

import java.util.*;

public class  MyList<T> implements List<T> {

    ArrayList<T> data;

    MyList()
    {
        data = new ArrayList<>();
    }

    @Override
    synchronized public int size() {
        return data.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    synchronized public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return data.toArray();
    }

    @Override
    synchronized public boolean add(T o) {
        return data.add(o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection c) {
        return data.addAll(c);
    }

    @Override
    synchronized public boolean addAll(int index, Collection c) {
        return data.addAll(index, c);
    }

    @Override
    synchronized public void clear() {
        data.clear();
    }

    @Override
    synchronized public T get(int index) {
        return data.get(index);
    }

    @Override
    synchronized public T set(int index, T element) {
        return data.set(index, element);
    }

    @Override
    synchronized public void add(int index, T element) {
        data.add(index, element);
    }

    @Override
    synchronized public T remove(int index) {
        return data.remove(index);
    }

    @Override
    synchronized public int indexOf(Object o) {
        return data.indexOf(o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {
        return data.lastIndexOf(o);
    }

    @Override
    synchronized public ListIterator<T> listIterator() {
        return data.listIterator();
    }

    @Override
    synchronized public ListIterator<T> listIterator(int index) {
        return data.listIterator(index);
    }

    @Override
    synchronized public List<T> subList(int fromIndex, int toIndex) {
        return data.subList(fromIndex, toIndex);
    }

    @Override
    synchronized public boolean retainAll(Collection c) {
        return data.retainAll(c);
    }

    @Override
    synchronized public boolean removeAll(Collection c) {
        return data.removeAll(c);
    }

    @Override
    synchronized public boolean containsAll(Collection c) {
        return data.containsAll(c);
    }

    @Override
    synchronized public Object[] toArray(Object[] a) {
        return data.toArray(a);
    }
}
