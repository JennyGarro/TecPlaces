/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author nenis
 */
public class Destino {
    
    public String ID;
    public String DirecExacta;
    public String Latitud;
    public String Longitud;
    public String Desplazamiento;

    public Destino(String ID, String DirecExacta, String Latitud, String Longitud, String Desplazamiento) {
        this.ID = ID;
        this.DirecExacta = DirecExacta;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
        this.Desplazamiento = Desplazamiento;
    }

    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDirecExacta() {
        return DirecExacta;
    }

    public void setDirecExacta(String DirecExacta) {
        this.DirecExacta = DirecExacta;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

    public String getDesplazamiento() {
        return Desplazamiento;
    }

    public void setDesplazamiento(String Desplazamiento) {
        this.Desplazamiento = Desplazamiento;
    }
    
    public void modificarDestino(String ID, String DirecExacta, String Latitud, String Longitud, String Desplazamiento) {
		this.setID(ID);
		this.setDirecExacta(DirecExacta);
		this.setLatitud(Latitud);
		this.setLongitud(Longitud);
		this.setDesplazamiento(Desplazamiento);
	}

    
    @Override
    public String toString() {
	String Dato= "\n| ID: "+this.ID+"\t| Dirección Exacta: "+this.DirecExacta+
			"\n| Latitud"+this.Latitud+"\t| Longitud: "+this.Longitud+"\t| Desplazamiento: "+this.Desplazamiento+
			"\n------------------------------------------------------------";
	return Dato;
	}
   
}


