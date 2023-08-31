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
public class MainArboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        arbolBinario_ABB abb=new arbolBinario_ABB();
        ABB_metodo_reflexivo abb_re=new ABB_metodo_reflexivo();
        
        ////ejercicio para los recorridos
//        nodo isla=new nodo(1);
//        nodo sol= new nodo(2);
//        nodo mes= new nodo(3);
//        nodo te= new nodo(4);
//        nodo cal= new nodo(5);
//        nodo bar= new nodo(6);
//        
//        //enlazar por la izq y por der
//        isla.izq=sol;
//        isla.der=cal;
//        sol.izq=mes;
//        sol.der=te;      
//        cal.izq=bar;
//        
//        //recorridos
//        recorridos rec=new recorridos();
//        System.out.println("recorrido de preorden");
//        System.out.println(rec.preOrden(isla));
//        System.out.println("recorrido de inorden");
//        System.out.println(rec.inOrden(raiz));
//        System.out.println("recorrido de posorden");
//        System.out.println(rec.posOrden(raiz));

        //Ejercicio para insertar manualmente
        System.out.println("Ejercicio 4");
        //arbol binario busqueda
        //manera de busqueda
        abb.insertar(51);
        abb.insertar(30);
        abb.insertar(65);
        abb.insertar(100);
        abb.insertar(70);
        System.out.println("ABB Recorrido inorden en busqueda");
        System.out.println(abb.InOrden());
        //manera reflexiva
        abb_re.insertarReflexivo(51);
        abb_re.insertarReflexivo(30);
        abb_re.insertarReflexivo(65);
        abb_re.insertarReflexivo(100);
        abb_re.insertarReflexivo(70);
        System.out.println("ABB Recorrido inorden en reflexivo");
        System.out.println(abb_re.InOrden2());
        //System.out.println("=> 100 => 70 => 65 => 51 => 30");
//        System.out.println("ABB cantidad de nodos");
//        System.out.println(abb.Nodos());


//        System.out.println("ABB inorden");
//        System.out.println(abb.InOrden());
//        System.out.println("ABB postOrden");
//        System.out.println(abb.PosOrden());
//        System.out.println("ABB preOrden");
//        System.out.println(abb.preOrden());
//        System.out.println("ABB cantidad de nodos");
//        System.out.println(abb.numeroNodos.size());
        
        
        ////arbol binario busqueda generado automaticamente
        
//        for (int i = 0; i < 10; i++) {
//            int random=(int)(Math.floor((Math.random())*(i-25+2)+50));
//            abb.insertar(random);
//        }
//        System.out.println("ABB preOrden:");
//        System.out.println(abb.preOrden());
//        System.out.println("ABB inOrden:");
//        System.out.println(abb.InOrden());
//        System.out.println("ABB posOrden:");
//        System.out.println(abb.PosOrden());
//        System.out.println("ABB Hojas:");
//        System.out.println(abb.nodosHojas());
//        System.out.println("ABB Primos:");
//        System.out.println(abb.nodosPrimos());
        
    }
}
