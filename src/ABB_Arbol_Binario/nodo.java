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
public class nodo {
    
    public nodo izq;
    public nodo der;
    public int info;

    public nodo(int info) {
        this.info = info;
        this.izq=null;
        this.der=null;
    }
    
}
