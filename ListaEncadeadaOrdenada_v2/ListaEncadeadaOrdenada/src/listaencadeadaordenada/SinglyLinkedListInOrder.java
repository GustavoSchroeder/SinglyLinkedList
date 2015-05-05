package listaencadeadaordenada;

/**
 *
 * @author gschroeder
 */
public class SinglyLinkedListInOrder<E> extends SinglyLinkedList<E> {

    public void OrdernarComPessoa(SinglyLinkedListInOrder sll) throws UnderFlowException {
  
        System.out.println("------Debug-------");
        int n = super.numElements();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                Pessoa elemA = (Pessoa) getNode(j - 1).getElement();
                Pessoa elemB = (Pessoa) getNode(j).getElement();
                System.out.println(elemA.nome + " > " + elemB.nome + " = " + elemA.compareTo(elemB));

                if (elemA.compareTo(elemB) > 0) {
                    sll.removeAnyPos(j - 1);
                    sll.removeAnyPos(j - 1);
                    sll.insertAnyPos(j - 1, elemA);
                    sll.insertAnyPos(j - 1, elemB);
                }
            }
        }
    }
}
