package br.udesc.ceavi.utils;

public abstract class Queue<T> extends StaticStructure<T>{

    public Queue(){
        super();
    }

    public Queue(int capacidade){
        super(capacidade);
    }

    public void enqueue(T element){
        this.add(element);
    }

    public T spy(){
        if (this.isEmpty()){
            return null;
        }
        return this.elements[0];
    }

    public T dequeue(){
        final int POS = 0;

        if (this.isEmpty()){
            return null;
        }
        T elementoASerRemovido = this.elements[POS];
        this.remove(POS);
        return elementoASerRemovido;
    }
}
