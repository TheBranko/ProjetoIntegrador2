package br.udesc.ceavi.utils;

public abstract class StaticStructure<T> {

    protected T[] elements;
    protected int size;

    @SuppressWarnings("unchecked")
    public StaticStructure(int capacity){
        this.elements = (T[]) new Object[capacity]; //solução do livro effective Java
        this.size = 0;
    }

    public StaticStructure(){
        this(10);
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    protected boolean add(T element) {
        this.increaseCapacity();
        if (this.size < this.elements.length){
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    protected boolean add(int position, T element){

        if (position < 0 || position > size){
            throw new IllegalArgumentException("Invalid Position");
        }

        this.increaseCapacity();

        //mover todos os elements
        System.arraycopy(this.elements, position, this.elements, position + 1, this.size - position);
        this.elements[position] = element;
        this.size++;

        return true;
    }

    protected void remove(int position){
        if (!(position >= 0 && position < size)){
            throw new IllegalArgumentException("Invalid Position");
        }
        System.arraycopy(elements, position + 1, elements, position, size - 1 - position);
        size--;
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity(){
        if (this.size == this.elements.length){
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
            this.elements = newElements;
        }
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i<this.size -1; i++){
            s.append(this.elements[i]);
            s.append(", ");
        }

        if (this.size >0){
            s.append(this.elements[this.size -1]);
        }

        s.append("]");

        return s.toString();
    }
}
