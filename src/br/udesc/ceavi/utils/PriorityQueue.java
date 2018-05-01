package br.udesc.ceavi.utils;

public abstract class PriorityQueue<T> extends Queue<T> {

    @Override
    public void enqueue(T element) {

        @SuppressWarnings("unchecked")
        Comparable<T> chave = (Comparable<T>) element;

        int i;
        for (i = 0; i < this.size; i++) {
            if (chave.compareTo(this.elements[i]) < 0) {
                break;
            }
        }
        this.add(i, element);
    }
}
