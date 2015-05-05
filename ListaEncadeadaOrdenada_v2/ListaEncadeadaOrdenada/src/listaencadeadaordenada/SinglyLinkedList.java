package listaencadeadaordenada;

/**
 *
 * @author gschroeder
 */
public class SinglyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    Node<E> iterador;
    int numElements;

    public SinglyLinkedList() {
        head = tail = null; // é setado como head e tail pois quando começa a lista os dois são os mesmos
        numElements = 0;
        iterador = null;
    }

    public int numElements() {
        return numElements;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return false; // uma lista com alocação dinâmica nunca vai estar cheia!
    }

    public void insertHead(E element) {
        Node<E> node = new Node(element);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.setNext(head);  // seta a proximo como head pois agora o node será o primeiro
            head = node; // seta o node como primeiro nó
        }
        numElements++;
    }

    public void insertTail(E element) {
        Node<E> node = new Node(element);
        if (isEmpty()) {
            tail = head = node;
        } else {
            tail.setNext(node); // declara o next da ultima posição o novo node
            tail = node; // declara o node como ultima posição
        }
        numElements++;
    }

    public E removeHead() throws UnderFlowException {
        E element = head.getElement();
        if (isEmpty()) {
            throw new UnderFlowException();
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
        }
        numElements--;
        return element;
    }

    public E removerTail() throws UnderFlowException {
        E element = tail.getElement();
        if (isEmpty()) {
            throw new UnderFlowException();
        } else if (tail == head) {
            tail = head = null;
        } else {
            Node<E> previo = head; //Auxiliar para achar o último NODE
            while (previo.getNext() != tail) {
                previo = previo.getNext();
            }
            tail = previo;
            previo.setNext(null);
        }
        numElements--;
        return element;
    }

    public Node getNode(int pos) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Pocição não existe!");
        }
        Node<E> atual = head;
        for (int i = 0; i < pos; i++) {
            atual = atual.getNext(); // Pega a posição atual (ou seja a posição POS)
        }
        return atual;
    }

    public void insertAnyPos(int i, E element) {
        Node<E> node = new Node(element);
        if (isEmpty()) {
            tail = head = node;
        } else {
            Node<E> atual = getNode(i);
            if (atual == head) {
                Node<E> tmp = head;
                head = node;
                head.setNext(tmp);
            } else {
                Node<E> anterior = getNode(i - 1);
                Node<E> proxima = anterior.getNext();
                anterior.setNext(node);
                node.setNext(proxima);
            }
        }
        numElements++;
    }

    public E removeAnyPos(int pos) throws UnderFlowException {

        Node<E> aux = getNode(pos);
        if (isEmpty()) {
            throw new UnderFlowException();
        } else {
            if (aux == head) {
                head = head.getNext();
            } else {
                getNode(pos - 1).setNext(getNode(pos).getNext());
            }
        }
        numElements--;
        return aux.getElement();
    }

    public boolean contais(E element) {
        Node<E> atual = head;
        while (atual != null) {
            if (atual.getElement().equals(element)) {
                return true;
            }
            atual = atual.getNext();
        }
        return false;
    }

    public void revert() throws Exception {
        SinglyLinkedList<E> list = new SinglyLinkedList<E>();
        int aux = numElements;
        while (head != null) {
            list.insertHead(removerTail());
        }
        System.out.println(list.numElements());
        for (int i = 0; i < aux; i++) {
            insertHead(list.removeHead());
        }
    }

    public E search(int pos) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Pocição não existe!");
        }
        return (E) getNode(pos).getElement();
    }

    public boolean remove(Node<E> obj) {
        Node<E> var = head;
        int cont = 0;
        while (var != null) {
            if (obj.equals(var)) {
                getNode(cont - 1).setNext(getNode(cont).getNext());
                numElements--;
                return true;
            }
            var = var.getNext();
            cont++;
        }
        return false;
    }

    public boolean insertAfter(E obj1, Node<E> obj2) {
        Node<E> var = head;
        for (int i = 0; i < numElements; i++) {
            if (var.getElement().equals(obj1)) {
                obj2.setNext(getNode(i + 1).getNext());
                getNode(i).setNext(obj2);
                numElements++;
                return true;
            }
            var = var.getNext();

        }
        return false;
    }

    public int find(E key) throws Exception {
        for (int i = 0; i < numElements; i++) {
            if (search(i).equals(key)) {
                return i;
            }
        }
        throw new Exception("A chave nao foi encontrado!");
    }

    @Override
    public String toString() {
        String auxiliary;
        Node<E> current = null;
        auxiliary = "[";
        int n = numElements();
        if (n > 0) {
            current = head;
            auxiliary += current.getElement();
        }
        if (n > 1) {
            for (int i = 1; i <= n - 1; i++) {
                current = current.getNext();
                auxiliary += ", " + current.getElement();
            }
        }
        return auxiliary;
    }

    public Node<E> next() {
        if (iterador == null) {
            iterador = head;
        } else if (iterador.getNext() == null) {
            iterador = head;
        } else {
            iterador = iterador.getNext();
        }
        return iterador;
    }

    public void merge(SinglyLinkedList<E> list) throws UnderFlowException {
        for (int i = 0; i < list.numElements(); i++) {
            insertTail(list.search(i));
        }
        int n = numElements();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                Pessoa elemA = (Pessoa) getNode(j - 1).getElement();
                Pessoa elemB = (Pessoa) getNode(j).getElement();
                System.out.println(elemA.nome + " > " + elemB.nome + " = " + elemA.compareTo(elemB));

                if (elemA.compareTo(elemB) > 0) {
                    removeAnyPos(j - 1);
                    removeAnyPos(j - 1);
                    insertAnyPos(j - 1, (E)elemA);
                    insertAnyPos(j - 1, (E)elemB);
                }
            }
        }
    }
}
