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
import java.util.LinkedList;
public class Vertices<T> {
    public T Vertice;
    public boolean visitado;
    public LinkedList<Aristas> aristas;
    public T labelV;
    public int labelPeso;
   public Vertices(){
       this.Vertice=null;
       this.visitado=false;
       this.aristas=new LinkedList<>();
       this.labelV=null;
       this.labelPeso=0;
   }
   public Vertices(T V){
       this.Vertice=V;
       this.visitado=false;
       this.aristas=new LinkedList<>(); 
       this.labelV=null;
       this.labelPeso=0;
   }
   public T getVertice(){
       return this.Vertice;
   }
   public void setVertice(T element){
       this.Vertice=element;
   }
   public boolean getVisitados(){
       return this.visitado;
   }
   public void setVisitados(boolean estado){
       this.visitado=estado;
   }
   public LinkedList<Aristas> getAristas(){
       return this.aristas;
   }
   public Aristas getElementfrom(int num){
       return this.aristas.get(num);
   }

    public T getLabelV() {
        return labelV;
    }

    public void setLabelV(T labelV) {
        this.labelV = labelV;
    }

    public int getLabelPeso() {
        return labelPeso;
    }

    public void setLabelPeso(int labelPeso) {
        this.labelPeso = labelPeso;
    }
   
   
  
   
   
   public String CadenaV(){
       return "|" + this.Vertice + "|" + "|->";
   }
}
