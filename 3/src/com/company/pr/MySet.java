package com.company.pr;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MySet<T> implements Set<T> {

    private Semaphore semaphore;
    private Set<T> data = new HashSet<>();

    MySet(){
        semaphore = new Semaphore(1);
    }

    @Override
    public int size() {
        int result = 0;
        try {
            semaphore.acquire();
            result = data.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> result = null;
        try {
            semaphore.acquire();
            result = data.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public Object[] toArray() {
        Object[] result = null;
        try {
            semaphore.acquire();
            result = data.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        T1[] result = null;
        try {
            semaphore.acquire();
            result = data.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean add(T t) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.add(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = data.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            data.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
