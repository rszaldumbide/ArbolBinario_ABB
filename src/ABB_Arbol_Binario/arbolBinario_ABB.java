/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABB_Arbol_Binario;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ricardo
 */
public class arbolBinario_ABB {
    
    private nodo raiz;

    public nodo getRaiz() {
        return raiz;
    }
    
    public arbolBinario_ABB() {
        this.raiz=null;//se incializa el arbol
    }
    //pARA INSERTAR
        //1. crear nodo nuevo
        //2. verificar si el arbol esta vacio, raiz != null
        //3. verificar si es menor o mayor, a partir de la raiz
        //4. ir enlazando a la izq o der, pero comprobando si es espacio esta disponible...por medio instruccion recursiva
    
    public void insertar(int dato){
        
        nodo nuevo = new nodo(dato);

        if(this.raiz == null){
            this.raiz = nuevo;
        }else{
            insertarRecursivo(raiz, nuevo);
        }
    }
    //indirecto
    private void insertarRecursivo(nodo raiz, nodo nuevo){
        //a la izq menores, der mayores
        if (nuevo.info<raiz.info){   //enlaza iz
            if(raiz.izq == null){
                raiz.izq = nuevo;
            }else{
                //mueve raiz forma recursiva
                insertarRecursivo(raiz.izq, nuevo);
            }
        } else if(nuevo.info > raiz.info){    //a la der mayores
            if(raiz.der == null) {
                raiz.der = nuevo;
            }else{
                //mueve raiz forma recursiva
                insertarRecursivo(raiz.der, nuevo);
            }
        }
    }
    //recorridos  
    //recorrer en preorden (raiz, izq, der)
    String datospre="";

    public String preOrden(){
        return preOrden(this.raiz);
    }
    private String preOrden(nodo raiz){
        //raiz, izq, der = recursivos
        if(raiz != null){
            datospre+= " => " + raiz.info;
            preOrden(raiz.izq);
            preOrden(raiz.der);
        }
        return datospre;
    }
    
    //recorrer en inorden (izq, raiz, der)
    String datosin = ""; 

    public String InOrden() {
        return InOrden(this.raiz);
    }
    private String InOrden(nodo raiz){
        
        if (raiz != null) {
            InOrden(raiz.izq);
            datosin += " => " + raiz.info;
            InOrden(raiz.der);
        }
        return datosin;
    }
    //recorrer en posorden (izq, der, raiz)
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
    //1.Para contar Hojas//   
    //variables
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
        return "Existe un total de "+cantHojas+" hojas"
                +" de los cuales se tiene: ("+hojas+")";
    }

    //2.Para guardar de acuerdo si es primo//
    //variables
    String datosPrimos="";
    
    //metodo que verifica si es primo
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
        return "La cantidad de nodos en el arbol es de: "+contnodos+" Sin contar la raiz.";
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
        return "El valor de la altura en el arbol es de: "+valorAltura;
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
    //peso de las ramas
    int cont=-1, cont2=-1; //No se cuenta la raiz
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
    
    public String ramaPeso(){
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
    
    //Ejercicio 2
    //Camino mas cercano
    
    public String caminoCorto(int datoBuscar){
        nodo buscar=Buscar2(datoBuscar);
        String camino="";
        if(buscar==null){
            camino+="No existe el nodo dentro del arbol.";
        }else{
            nodo raizAux=this.raiz;
        
            while(raizAux!=null){
                camino+="=> "+raizAux.info;
                if(datoBuscar==raizAux.info){
                    break;//rompe ciclo
                }else{
                    if(datoBuscar<raizAux.info){
                        raizAux=raizAux.izq;
                    }else{
                        raizAux=raizAux.der;
                    }
                }
            }
        }  
        return "El recorrido al nodo: "+datoBuscar+": es\n"
                + camino;
    }
    

//    //3.para contar el numero de nodos que existe
//    
//    //String numeroNodos="";
//    Queue numeroNodos=new LinkedList();
//    
//    public Queue numNodos(){
//        return numNodos(this.raiz);
//    }
//    private Queue numNodos(nodo raiz){
//        if(raiz!=null){
//            numeroNodos.add(raiz.info);
//            numNodos(raiz.izq);
//            numNodos(raiz.der);
//        }
//        return numeroNodos;
//    }
//    //metodo para determinar la cantidad de nodos 
//    //de acuerdo con las hojas
//    int cantidadDeHojas, cantNodos=0;
//    
//    public String cantNodosHojas(){
//        return cantNodosHojas(this.raiz);
//    }
//    private String cantNodosHojas(nodo raiz){
//        if(raiz!=null){
//            if(raiz.der==null && raiz.izq==null){
//                cantidadDeHojas++;
//            }
//            cantNodosHojas(raiz.izq);
//            cantNodosHojas(raiz.der);
//        }
//        if(cantidadDeHojas%2==0){
//            cantNodos=((cantidadDeHojas*2)-1);
//        }else{
//            cantNodos=((cantidadDeHojas*2)+1);
//        }
//        return "Existe un total de "+cantNodos+" nodos";           
//    }   
    
}
    
