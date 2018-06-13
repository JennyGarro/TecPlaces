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
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArbolB ab=new ArbolB();
      ab.insertar(5);
      ab.insertar(3);
      ab.insertar(6);
      ab.insertar(7);
      ArbolB ac=new ArbolB();
      ac.insertar(2);
      ac.insertar(1);
      ac.insertar(3);
      ac.insertar(5);
      ac.insertar(10);
      System.out.print(ac.compara(ac, ab));

    }
    
}
