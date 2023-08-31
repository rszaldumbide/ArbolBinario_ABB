/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABB_Arbol_Binario;

/**
 *
 * @author ricardo
 */
public class recorridos {
    
    String resultado="";
    String resultado1="";
    String resultado2="";
    
    public String preOrden(nodo raiz){
    //recorre por la raiz, izqu, dere
    if(raiz!=null){
        resultado+=("-> "+raiz.info+"\n\r");
        preOrden(raiz.izq);
        preOrden(raiz.der);
        }    
    return resultado;
    }
    
    public String inOrden(nodo raiz){
    //recorre por la izq, raiz, der
    if(raiz!=null){
        inOrden(raiz.izq);
        resultado1+=("-> "+raiz.info+"\n\r");
        inOrden(raiz.der);
        }     
    return resultado1;
    }
    
    public String posOrden(nodo raiz){
    //recorre por la izq, der, raiz
    if(raiz!=null){
        posOrden(raiz.izq);
        posOrden(raiz.der);
        resultado2+=("-> "+raiz.info+"\n\r");
        }   
    return resultado2;
    }
    
}
