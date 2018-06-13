/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author giank
 */
import java.util.Vector;
public class ArbolB<T> {
    Integer Raiz;
    ArbolB subABizq;
    ArbolB subABder;
    public ArbolB(){
        Raiz=null;
        this.subABder=null;
        this.subABizq=null;
    }
    public ArbolB(int elemento){
        this.Raiz=elemento;
         this.subABder=null;
        this.subABizq=null;
    }
    public boolean Esvacio(){
        boolean B=true;
        if(Raiz!=null){
            B=false;
        }
        return B;
    }
    
    public void insertar( Integer nuevo ) {
        if( this.Esvacio()==true ) {
            Raiz = new Integer(nuevo);
            subABizq = new ArbolB();
            subABder = new ArbolB();
        } else {
            if(nuevo<this.Raiz){
             subABizq.insertar(nuevo);
            }
            else if (nuevo>Raiz){
                this.subABder.insertar(nuevo);
            }
        }}
    

   

        
       private ArbolB buscarMin() {
        ArbolB arbolActual = this;

        while( arbolActual.Esvacio()!=true ) {
            arbolActual = arbolActual.subABizq;
        }

        return arbolActual;
    }

    private boolean esHoja() {
        boolean hoja = false;

        if( subABizq.Esvacio() && subABder.Esvacio()==true ) {
            hoja = true;
        }

        return hoja;
    }



    public void preOrden() {
        if( this.Esvacio()!=true ) {
            System.out.println( Raiz );
            subABizq.preOrden();
            subABder.preOrden();
        }
    }

    public void enOrden() {
        if( this.Esvacio()!=true ) {
            subABizq.enOrden();
            System.out.println( Raiz );
            subABder.enOrden();
        }
    }

    public void postOrden() {
        if( this.Esvacio()!=true ) {
            subABizq.postOrden();
            subABder.postOrden();
            System.out.println( Raiz );
        }
    }


    public int porNivel() {
        Vector<ArbolB> cola = new Vector<ArbolB>();
        ArbolB arbol;
        int numD=0;
         int numI=0;
        cola.add(this);
        while( !cola.isEmpty() ) {
            
            arbol = cola.elementAt(0);
            cola.remove(0);
            System.out.println( arbol.Raiz );
            if ( arbol.subABizq.Esvacio()!=true ){
                cola.add( arbol.subABizq );
                numI++;
            }
            if (arbol.subABder.Esvacio()!=true ){
                cola.add( arbol.subABder );
                numD++;
            }
        }
        if(numI>numD){
            return numI;
        }
        else{
            return numD;
        }
    }

    public boolean compara(ArbolB a, ArbolB b){
         boolean bandera=false;
         if(a.porNivel()==b.porNivel()){
             bandera=true;
         }
         return bandera;
    }

}
    

