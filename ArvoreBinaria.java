import java.util.*;

public class ArvoreBinaria {
    
    No raiz;
    List<No> nohs;

    public ArvoreBinaria(){ 
        raiz = null;
        nohs = new ArrayList<>();
    }

    public void add(int value) {
        raiz = addNewNo(raiz, value);
    }

    public void remove(int value){
        raiz = removeNo(raiz, value);
    }

    public void imprimeArvore(){
        List<Integer> valores = new ArrayList<>();
        ordenaLista(raiz, valores);
        for (Integer valor : valores) {
            System.out.println(valor);
        }
    }

    private void ordenaLista(No no, List<Integer> valores) {
        if (no != null) {
            ordenaLista(no.esquerda, valores);
            valores.add(no.valor);
            ordenaLista(no.direita, valores);
        }
    }

    public No addNewNo(No noRecebido, int value) {
        
        if (noRecebido == null) {
            return new No(value);
        }
        if (value < noRecebido.valor) {
            noRecebido.esquerda = addNewNo(noRecebido.esquerda, value);
        }
        else if (value > noRecebido.valor) {
            noRecebido.direita = addNewNo(noRecebido.direita, value);
        }

        return noRecebido;
    }

    public No removeNo(No noRecebido, int value) {
        
        if (noRecebido == null) {
            return null;
        }
        if (value < noRecebido.valor) {
            noRecebido.esquerda = removeNo(noRecebido.esquerda, value);
        }
        else if (value > noRecebido.valor) {
            noRecebido.direita = removeNo(noRecebido.direita, value);
        }
        else{
            
            if (noRecebido.esquerda == null && noRecebido.direita == null){
                noRecebido = null;
            }
            else if(noRecebido.esquerda  == null){
                noRecebido = null;
            }
            else if(noRecebido.direita  == null){
                noRecebido = null;
            }

            else {
                
                No menorNo = encontraMenor(noRecebido.direita);
                noRecebido.valor = menorNo.valor;
                noRecebido.direita = removeNo(noRecebido.direita, menorNo.valor);
            }
        }

        return noRecebido;
    }

    private No encontraMenor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
    
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        arvore.add(5);
        arvore.add(3);
        arvore.add(7);
        arvore.add(2);
        arvore.add(4);
        arvore.add(6);
        arvore.add(8);

        System.out.println("Árvore em ordem:");
        arvore.imprimeArvore();

        arvore.remove(3);
        System.out.println("Árvore após remover 3:");
        arvore.imprimeArvore();
    }
}
