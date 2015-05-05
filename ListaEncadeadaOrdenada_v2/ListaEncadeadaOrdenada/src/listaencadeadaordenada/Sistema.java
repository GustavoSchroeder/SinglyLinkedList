package listaencadeadaordenada;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gschroeder
 */
public class Sistema {

    public static void main(String[] args) {
        try {
            ReadDate rd = new ReadDate();
            SinglyLinkedListInOrder sll = new SinglyLinkedListInOrder();
            
            /* INSERSÃO AUTOMÁTICA */
            sll.insertHead(new Pessoa("a", "32423", 56, "01/01/2013"));
            sll.insertHead(new Pessoa("h", "45453234234", 32, "02/01/2013"));
            sll.insertHead(new Pessoa("z", "671231", 23, "03/01/2013"));
            sll.insertHead(new Pessoa("g", "7913", 78, "04/01/2013"));          
            
            while (true) {
                int prog = rd.readInt("Operacao: 1 - Add Pessoa  2 - Coloca em ordem  3 - Sair");
                if (prog == 1) {
                    int n = rd.readInt("Numero de pessoas a adicionar: ");
                    for (int i = 0; i < n; i++) {
                        Pessoa p = new Pessoa(rd.readString("Nome: "), rd.readString("CPF: "),
                        rd.readInt("Idade: "), rd.readString("Data: (DD/MM/AAAA"));
                        sll.insertHead(p);
                    }

                } else if (prog == 2) {
                    int index = 0;
                    int compare = 0;
                    int size = sll.numElements();
                    System.out.println("Elementos Ate o Momento: " + sll.numElements() + " \nNodos: " + sll.numElements());
                    System.out.println("Lista desordenada:");
                    for (int i = 0; i < sll.numElements(); i++) {
                        Pessoa p = (Pessoa) sll.getNode(i).getElement();
                        System.out.println(p.nome);
                    }
                    
                    try{
                        sll.OrdernarComPessoa(sll);
                    }catch(UnderFlowException exc){
                        System.out.println("Erro: "+exc.getMessage());
                    }
                    /*
                    while (size != 0) {
                        compare = index;
                        Pessoa p = (Pessoa) sll.getNode(index).getElement();
                        System.out.println("Pessoap " + p.getNome());
                        int contToSeIfItsTrue = 0;
                        for (int i = 0; i < sll.numElements(); i++) {
                            if (sll.getNode(i) != null) {
                                contToSeIfItsTrue++;
                            }
                            System.out.println("esta null: " + i);
                        }
                        System.out.println("numero de elementos: " + sll.numElements());
                        Pessoa pessoaCompareTo = (Pessoa) sll.getNode(size).getElement();
                        System.out.println("pessoacompareto " + pessoaCompareTo.getNome());
                        int n = p.compareTo(pessoaCompareTo);
                        sll.inOrder(p, n);
                        index++;
                        size--;
                    }*/
                    System.out.println("Lista ordenada:");
                    for (int i = 0; i < sll.numElements(); i++) {
                        Pessoa p = (Pessoa) sll.getNode(i).getElement();
                        System.out.println(p.nome);
                    }

                } else if (prog == 3) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Option required does not exist");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
