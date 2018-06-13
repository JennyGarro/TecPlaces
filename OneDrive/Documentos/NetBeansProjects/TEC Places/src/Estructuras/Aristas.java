/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author giank
 */
public class Aristas<T> {
    public T Nodo;
    public T origen;
    public int peso;
   public Aristas(){
       this.Nodo=null;
   this.peso=0;}
   public Aristas(T N,int P){
       this.Nodo=N;
       this.peso=P;
   }
   public Aristas(T origen,T destino, int p){
       this.origen=origen;
       this.Nodo=destino;
       this.peso=p;
   }
   
   public T getNodo(){
       return this.Nodo;
   }
   public void setNodo(T nodo){
       this.Nodo=nodo;
   }
   public int getPeso(){
       return this.peso;
   }
   public void setPeso(int num){
       this.peso=num;
   }
   public T getVecino(T Origen){
       if(this.origen==Origen){
           return this.Nodo;
       }
       else{
           return this.origen;
       }
   }

    public T getOrigen() {
        return origen;
    }

    public void setOrigen(T origen) {
        this.origen = origen;
    }
   
    
}
