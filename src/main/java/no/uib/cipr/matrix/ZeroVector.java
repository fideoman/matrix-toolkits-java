package no.uib.cipr.matrix;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ZeroVector implements Vector {

    private int size;

    public ZeroVector(int size) {
        this.size = size;
    }

    public ZeroVector(Vector x) {
        this(x.size());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, double value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, double value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double get(int index) {
        return 0;
    }

    @Override
    public Vector copy() {
        return new ZeroVector(this);
    }

    @Override
    public Vector zero() {
        // Already zero!
        return this;
    }

    @Override
    public Vector scale(double alpha) {
        return this;
    }

    @Override
    public Vector set(Vector y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vector set(double alpha, Vector y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vector add(Vector y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vector add(double alpha, Vector y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double dot(Vector y) {
        return 0;
    }

    @Override
    public double norm(Norm type) {
        return 0;
    }

    @Override
    public Iterator<VectorEntry> iterator() {
        return new ZeroVectorIterator();
    }

    private class ZeroVectorIterator implements Iterator<VectorEntry> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public VectorEntry next() {
            throw new NoSuchElementException();
        }
    }
}
