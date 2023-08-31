/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABB_Arbol_Binario;

/**
 *
 * @author ricar
 */
public class ABB_metodo_reflexivo {
    
    private nodo raiz;

    public nodo getRaiz() {
        return raiz;
    }
    
    public ABB_metodo_reflexivo() {
        this.raiz=null;//se incializa el arbol
    }
    
    public void insertarReflexivo(int dato){       
        nodo nuevo = new nodo(dato);
        if(this.raiz == null){
            this.raiz = nuevo;
        }else{
            insertarRecursivoReflexivo(raiz, nuevo);
        }
    }
    private void insertarRecursivoReflexivo(nodo raiz, nodo nuevo){
        if (nuevo.info<raiz.info){ 
            if(raiz.der == null){
                raiz.der = nuevo;
            }else{
                insertarRecursivoReflexivo(raiz.der, nuevo);
            }
        } else if(nuevo.info > raiz.info){
            if(raiz.izq == null) {
                raiz.izq = nuevo;
            }else{
                insertarRecursivoReflexivo(raiz.izq, nuevo);
            }
        }
    }
    String datospre2="";

    public String preOrden(){
        return preOrden(this.raiz);
    }
    private String preOrden(nodo raiz){
        //raiz, izq, der = recursivos
        if(raiz != null){
            datospre2+= " => " + raiz.info;
            preOrden(raiz.izq);
            preOrden(raiz.der);
        }
        return datospre2;
    }
    
    String datosin2 = "";
    
    public String InOrden2() {
        return InOrden2(this.raiz);
    }

    private String InOrden2(nodo raiz){
        
        if (raiz != null) {
            InOrden2(raiz.izq);
            datosin2 += " => " + raiz.info;
            InOrden2(raiz.der);
        }
        return datosin2;
    }
    
    String datospos = "";

    public String PosOrden() {
        return PosOrden(this.raiz);
    }
    private String PosOrden(nodo raiz){
        if(raiz != null){
            PosOrden(raiz.izq);
            PosOrden(raiz.der);
            datospos += " => " + raiz.info;
        }
        return datospos;
    }  
    
    String hojas="";
    int cantHojas;
    
    public String nodosHojas(){
        return nodosHojas(this.raiz);
    }
    private String nodosHojas(nodo raiz){
        if(raiz!=null){
            if(raiz.der==null && raiz.izq==null){
                hojas+=raiz.info+", ";
                cantHojas++;
            }
            nodosHojas(raiz.izq);
            nodosHojas(raiz.der);
        }
        return "\nArbol 2 Reflexivo: Existe un total de "+cantHojas+" hojas"
                +" de los cuales se tiene: ("+hojas+")";
    }
    
    public boolean numPrimo(int numero){
        boolean validar=false;
        int cont=0;
        for(int i=1; i<numero+1; i++){
            if(numero%i==0){
                cont++;
            }
        }
        if(cont==2){
            validar=true;
        }else{
            validar=false;
        }
        return validar;
    }
    
    String datosPrimos="";
    
    public String nodosPrimos(){
        return nodosPrimos(this.raiz);
    }
    public String nodosPrimos(nodo raiz){
        if(raiz!=null){
            if(numPrimo(raiz.info)==true){
                datosPrimos+=raiz.info+", ";
                }
            nodosPrimos(raiz.izq);
            nodosPrimos(raiz.der);
        }
        return datosPrimos;
    }
    
    int contnodos=-1;
    public String Nodos(){
        return Nodos(this.raiz);
    }
    private String Nodos(nodo raiz){
        if(raiz!=null){
            contnodos++;
            Nodos(raiz.izq);
            Nodos(raiz.der);
        }
        return "\nArbol2 Reflexivo: La cantidad de nodos en el arbol es de: "+contnodos+" Sin contar la raiz.";
    }
    
    public nodo Buscar2(int datoBuscar){
        nodo raizAux=this.raiz;
        
        while(raizAux!=null){
            if(datoBuscar==raizAux.info){
                return raizAux;                 //rompe ciclo
            }else{
                if(datoBuscar<raizAux.info){
                    raizAux=raizAux.izq;
                }else{
                    raizAux=raizAux.der;
                }
            }
        }
        return null;
    }
    
    int valorAltura;
    public String altura(){
        valorAltura=0;
        altura(this.raiz, 1);
        return "\nArbol Reflexivo: El valor de la altura en el arbol es de: "+valorAltura;
    }
    private void altura(nodo aux, int nivel){
        if(aux!=null){
            altura(aux.izq, nivel+1);
            if (nivel > valorAltura) {
                valorAltura=nivel;
            }
            altura(aux.der, nivel+1);
        }
    }
    
    //Ejercicio 1
    int cont=-1, cont2=-1; //no cuenta la raiz
    public int pesoRaizIzq(){
        return pesoRaizIzq(this.raiz);
    }
    private int pesoRaizIzq(nodo raiz){
        if(raiz!=null){
            pesoRaizIzq(raiz.izq);
            cont++;
        }
        return cont;
    }
    public int pesoRaizDer(){
        return pesoRaizDer(this.raiz);
    }
    private int pesoRaizDer(nodo raiz){
        if(raiz!=null){
            pesoRaizDer(raiz.der);
            cont2++;
        }
        return cont2;
    }
    String pesoRama="";
    int pesoIzq, pesoDer;
    
    public String ramaPeso2(){
        pesoIzq=pesoRaizIzq();
        pesoDer=pesoRaizDer();
        
        if(pesoIzq<pesoDer){
            pesoRama="La rama derecha";
        }else if(pesoDer<pesoIzq){
            pesoRama="La rama izquierda";
        }else if(pesoDer==pesoIzq){
            pesoRama="Son iguales";
        }
        
        return "La ramaIzq tiene un peso de: "+pesoIzq
                + "\n La ramaDer tiene un peso de: "+pesoDer
                + "\nPor ende, la rama con mayor peso es: "+pesoRama;
    }

    
}
