/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaencadeadaordenada;

/**
 *
 * @author gschroeder
 */
public class Node<E> {

    protected E element;
    protected Node<E> next;

    public Node(E element) {
        this.element = element;
        this.next = null;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
