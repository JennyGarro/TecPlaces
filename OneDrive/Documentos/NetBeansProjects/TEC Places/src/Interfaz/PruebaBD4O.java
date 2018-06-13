package Interfaz;

import Estructuras.Destino;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class PruebaBD4O {
	
	static ObjectContainer BDDestino;
	
	public PruebaBD4O() {
		this.BDDestino=Db4o.openFile("Destino.yap");
	}
	
	public ObjectSet Consultar() {
		ObjectSet result=BDDestino.queryByExample(null);
		return result;
	}
	
	public ObjectSet Consultar(Object obj) {
		ObjectSet result=BDDestino.queryByExample(obj);
		return result;
	}
	
	public void Insertar(Object obj) {
		BDDestino.store(obj);
	}
	
	public void Borrar(Object obj) {
		ObjectSet result=Consultar(obj);
		while(result.hasNext()) {
			BDDestino.delete(result.next());
		}
	}
	
	public void Modificar(Object obj,String ID, String DirecExacta, String Latitud, String Longitud, String Desplazamiento) {
		
		ObjectSet result=Consultar(obj);
		while(result.hasNext()) {
			Destino d1=(Destino) result.next();
			d1.modificarDestino(ID, DirecExacta, Latitud, Longitud, Desplazamiento);
			BDDestino.store(d1);
		}
	}
	public static void main(String[] args) {

		PruebaBD4O BD=new PruebaBD4O();
		
		Destino destino1=new Destino("1","Manuel","Loaiza","Sánchez","20");
		Destino destino2=new Destino("2","Josué","Solís","Blanco","20");
		Destino destino3=new Destino("3","Jose","Ortega","Vargas","19");
		
		//Aquí se insertan los objetos en la base de datos.
		BD.Insertar(destino1);
		BD.Insertar(destino2);
		BD.Insertar(destino3);
		
		System.out.println("\n*Aquí se hace un SELECT donde la Cédula de la persona es 2.*");
		ObjectSet resultado=BD.Consultar(new Destino("2",null,null,null,null));
		while(resultado.hasNext()) {
			System.out.println(resultado.next().toString());
		}
		
		System.out.println("\n*Aquí se hace un SELECT donde la persona tiene 20 años.*");
		resultado=BD.Consultar(new Destino(null,null,null,null,"20"));
		while(resultado.hasNext()) {
			
			System.out.println(resultado.next().toString());
		}
		
		System.out.println("\n*Aquí consulta todos los objetos de la base de datos.*");
		resultado=BD.Consultar();
		while(resultado.hasNext()) {
			System.out.println(resultado.next().toString());
		}
	
		System.out.println("\n*Aquí consulta todos los objetos de la base de datos.*");
		resultado=BD.Consultar();
		while(resultado.hasNext()) {
			System.out.println(resultado.next().toString());
		}
		
		//Aqui modifica a la persona con Cédula 1 y le cambia los valores.
		BD.Modificar(new Destino("1",null,null,null,null), "1", "Osvaldo", "Loaiza", "Sánchez", "22");
		
		System.out.println("\n*Aquí se hace un SELECT donde la Cédula de la persona es 1.*");
		resultado=BD.Consultar(new Destino("1",null,null,null,null));
		while(resultado.hasNext()) {
			System.out.println(resultado.next().toString());
		}
		
		//Aquí borrará a la persona con la Cédula 3 en la base de datos.
		BD.Borrar(new Destino("3",null,null,null,null));
		
		System.out.println("\n*Aquí consulta todos los objetos de la base de datos.*");
		resultado=BD.Consultar();
		while(resultado.hasNext()) {
			System.out.println(resultado.next().toString());
		}
	}

}
