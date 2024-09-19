
import java.io.Console;

public class ArvoreBinaria {
    
    No raiz;

    public ArvoreBinaria(){ 
        raiz = null;
    }

    public void add(int value) {
        raiz = addNewNo(raiz, value);
    }

    public void remove(int value){
        raiz = removeNo(raiz, value);
    }

    public void imprimeArvore(){
        raiz = printArvore(raiz);
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
                noRecebido = noRecebido.direita;
            }
            else if(noRecebido.direita  == null){
                noRecebido = noRecebido.esquerda;
            }
        }

        return noRecebido;
    }

    public No printArvore(No noRecebido){

        if(noRecebido == null){
            System.out.println(noRecebido);
        }
        if(noRecebido.esquerda != null && noRecebido.direita != null){
            
            
            System.out.println("/ \"");
        }
    }

}
