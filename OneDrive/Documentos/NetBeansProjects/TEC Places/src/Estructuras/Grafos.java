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
import Estructuras.Aristas;
import Estructuras.Vertices;
import java.util.LinkedList;
public class Grafos<T> {
    public LinkedList<Vertices> vertices;
    public int distancia;
    public LinkedList<Aristas> arista;
    public Grafos(){
        this.vertices=new LinkedList<>();
        this.distancia=0;
    }
      public void agregarVertice(T v){
        vertices.add(new Vertices(v));  
    }
      public Vertices buscarV(T V){
        for(int indice = 0; indice < this.vertices.size(); indice++){
            if(this.vertices.get(indice).Vertice== V)  //Si encuentra el vértice lo retorna
                return this.vertices.get(indice);
        }
        return null;
    }
      public Vertices BuscarV(Object V){
                 for(int indice = 0; indice < this.vertices.size(); indice++){
            if(this.vertices.get(indice).Vertice== V)  //Si encuentra el vértice lo retorna
                return this.vertices.get(indice);
        }
        return null;
    } 
      
      public void agregarArista(T origen, T destino, int peso){
          Aristas nuevo=new Aristas(destino,peso);
       
       //Buscar el vértice origen y agrega un nodo al final de la lista de aristas de ese vértice
    }
      public Aristas buscarArista(T origen, T destino){
        Vertices<T> temp = buscarV(origen);  //Busca el vértice de origen
        //Busca en la lista de aristas de ese vértice para identificar si se encuentra la arista buscada
        for(int i = 0; i < temp.aristas.size(); i++){
            if(temp.getElementfrom(i).getNodo() == destino){
                return temp.getAristas().get(i);
            }
        }
        return null;
    }
      public Vertices buscarVerticeNOVisitado(){

        //Recorre la lista de vértices
        for(int indice = 0; indice < this.vertices.size(); indice++){
            if(this.vertices.get(indice).getVisitados()==false ){ //Si encuentra una no visitado lo retorna
                return this.vertices.get(indice);
            }
        }
        return null; //Si todos están visitados retorna null
    }
      public void StringGrafo(){
        Vertices actual;
        for(int i = 0; i < this.vertices.size(); i++){
            actual = vertices.get(i);
            System.out.println("Vertice : " + actual.Vertice);
            for(int j = 0; j < actual.aristas.size(); j++){
                System.out.println("Arista de "+actual.Vertice+ " a " + actual.getElementfrom(j).getNodo()+ " con peso " + actual.getElementfrom(j).getPeso());
            }
        }
    }
      public void inicializarVisitados(){
        for(int i = 0; i < this.vertices.size(); i++)
            this.vertices.get(i).visitado = false;
    }
      public boolean todosVisitados(){
        for(int i = 0; i < this.vertices.size(); i++){
            if(this.vertices.get(i).getVisitados()!=true)    //Si encuentra uno sin visitar retorna false
                return false;
        }
        return true;    //Si encuentra uno visitado retorna true
    }
        public void eliminarArista(T origen, T destino){
        //Verifica si el grafo es no dirigido
        if((buscarArista(origen,destino) != null) && (buscarArista(destino,origen) != null)){ //Busca si existe arista de origen a destino y viceversa
            //Verifica si el peso de ambas aristas es igual con lo que se asume que es un grafo no dirigido
            if(buscarArista(origen,destino).peso == buscarArista(destino,origen).peso){
                buscarV(destino).aristas.remove(buscarArista(destino, origen));
            }
        }
        //Elimina el arista de la lista de aristas del vértice origen
        buscarV(origen).aristas.remove(buscarArista(origen, destino));

    }
         public void eliminarVertice(T v){
        this.vertices.remove(buscarV(v));  //Elimina el vértice de la lista de vértices
        //Elimina todas las aristas en las que el vértice eliminado aparezca como destino
        for(int i = 0; i < vertices.size(); i++)
            eliminarArista((T) vertices.get(i).getVertice(), v);
    }
        public void recorridoProfundidad(T inicial){
        inicializarVisitados();  //Inicializa todos los nodos como no visitados
        System.out.println("Recorrido en profundidad");
        DFS(inicial); //Hace la llamada al método que realiza el algoritmo
        System.out.println();
    }



    private void DFS(T inicial){

        Vertices actual = buscarV(inicial); //Busca el vértice inicial para el recorrido en la lista de vértices

        while(actual != null)  //Ciclo para verificar que todos los vértices estén visitados
        {
            //Si el nodo inicial no está visitado
            if(!actual.visitado){
                System.out.print(actual.Vertice + " "); //Imprime el vértice
                actual.visitado = true;    //Lo actualiza como visitado
            }

            //Revisa todos los nodos adyacentes del nodo recién visitado
            for(int j = 0; j < actual.aristas.size(); j++){
                if(buscarV((T) actual.getElementfrom(j).getNodo()).getVisitados()!=true)  //Si el nodo adyacente no está visitado
                    DFS((T) actual.getElementfrom(j).getNodo()); //Hace la llamada recursiva para realizar el recorrido en el nodo adyacente
            }
            //Verifica si queda algún nodo sin visitar
            actual = buscarVerticeNOVisitado();
        }
    }
    public void recorridoAnchura(T inicial){

        Vertices actual;
        LinkedList <Vertices> Cola = new LinkedList<>();    //Estructura auxiliar para hacer el recorrido

        inicializarVisitados(); //Inicializa todos los nodos como no visitados

        System.out.println("Recorrido en anchura");
        actual = buscarV(inicial); //Busca el vértice para iniciar el recorrido en la lista de vértices del grafo

        //Ciclo para verificar que todos los nodos estén visitados
        while(actual != null)
        {
            //Si el nodo actual no ha sido visitado
            if(!actual.visitado){
                System.out.print(actual + " "); //Imprime el vértice
                actual.visitado = true; //Indica que el vértice fue visitado
                Cola.add(actual);  //Agrega el vértice a la cola(estructura auxiliar)
            }
            //Busca todos los vértices adyacentes al vértice recién visitado
            for(int j = 0; j < actual.aristas.size(); j++){
                if(! buscarV((T) actual.getElementfrom(j).getNodo()).visitado){ //Si el vértice no se ha visitado aun
                    System.out.print(actual.getElementfrom(j).getNodo() + " ");  //Se imprime el vértice
                    Cola.add(buscarV((T) actual.getElementfrom(j).Nodo));    //Se agrega el vértice a la cola
                    buscarV((T) actual.getElementfrom(j).Nodo).visitado = true;  //Se indica que el vértice ha sido visitado
                }
            }

            //Mientras la cola no esté vacía
            while(Cola.size() > 0)
            {
                Vertices temp1;

                for(int x = 0; x < Cola.getFirst().aristas.size(); x++){
                    //Obtiene el primer vértice en la cola
                    temp1 = buscarV((T) Cola.getFirst().getElementfrom(x).Nodo);
                    if(!temp1.visitado){  //Verifica si el primero de la cola no ha sido visitado
                        System.out.print(temp1.getVertice() + " "); //Imprime el vértice
                        temp1.visitado = true;    //Indica que el vértice se ha visitado
                        Cola.add(temp1);    //Agrega el vértice al final de la cola
                    }
                }
                //Elimina el primer vértice de la cola
                Cola.removeFirst();
            }
            actual = buscarVerticeNOVisitado();//Verifica si aun quedan vértices sin visitar
        }
        System.out.println();
    }

    public LinkedList<Vertices> getVertices() {
        return vertices;
    }

    public void setVertices(LinkedList<Vertices> vertices) {
        this.vertices = vertices;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public LinkedList<Aristas> getArista() {
        LinkedList<Vertices> tempo=this.vertices;
        while(tempo.size()>0){
            Vertices V=tempo.getFirst();
           int num=0;
            while(V.getAristas().size()>=num){
                Aristas A=V.getElementfrom(num);
                this.arista.add(A);
                num++;
            }
            tempo.remove();
        }
        return arista;
    }

    public void setArista(LinkedList<Aristas> arista) {
        this.arista = arista;
    }
    
    
     
      
         
         

      

      
      
      }

    


