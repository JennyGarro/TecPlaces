/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.places;

/**
 *
 * @author giank
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import maps.java.MapsJava;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
public abstract class MapasCR 
{
    private static int tiempodePrueba=300;
    private static String APIKey="";
    private static String region="";
    private static String Idioma="es";
    private static boolean Bandera=false;
    
    
    private static String[][] pedidos=new String[0][6];
    protected abstract void Error(URL Pagina,String estado,Exception ex);
    protected abstract String getESTADO(XPath x,Document Documento);
    protected abstract void GuardarInfo(URL Pagina,String informacion,String estado,Exception excp);
    private static int NumeroPedido=0;
    protected Object tamaño(Object elemento,int tam){
        int VTamaño=java.lang.reflect.Array.getLength(elemento);
        Class tipoE=elemento.getClass().getComponentType();
        Object nuevo=java.lang.reflect.Array.newInstance(tipoE, tam);
        int Guardar=Math.min(tam, VTamaño);
        if(Guardar>0){
            System.arraycopy(elemento, 0, nuevo, 0, Guardar);
            
        }
        return nuevo;
    }
      protected String getSelectPropertiesRequest(){
        return "&region=" + MapasCR.region + "&language=" + MapasCR.Idioma + 
                "&sensor=" + MapasCR.Bandera;
    }
    
    protected void GuardarPedido(String URL,String info,String Estado, Exception excp){
        Date fecha=new Date();
        NumeroPedido+=1;
        MapasCR.pedidos=(String[][])(this.tamaño(MapasCR.pedidos, NumeroPedido));
        int num=NumeroPedido-1;
        if(MapasCR.pedidos[num]==null){
            MapasCR.pedidos[num]=new String[6];
            
        }
        MapasCR.pedidos[num][0]=String.valueOf(NumeroPedido);
        MapasCR.pedidos[num][1]=fecha.toString();
        MapasCR.pedidos[num][2]=Estado;
        MapasCR.pedidos[num][3]=URL;
        MapasCR.pedidos[num][4]=info;
        if(excp==null){
            MapasCR.pedidos[num][5]="Sin Excepcion";
        }
        MapasCR.pedidos[num][5]=excp.toString();
       
                
    }
    protected ArrayList<String> getNodosString(NodeList nodos){
        ArrayList<String> r=new ArrayList<>();
        for(int j=0,n=nodos.getLength();j<n;j++){
            String nodoString=nodos.item(j).getTextContent();
            r.add(nodoString);
        
    }
       return r;
    }
    protected ArrayList<Double> getNodosDouble(NodeList Nodos){
        ArrayList<Double> R=new ArrayList<>();
        for(int j=0,n=Nodos.getLength();j<n;j++){
            String nodoString=Nodos.item(j).getTextContent();
            R.add(Double.valueOf(nodoString));
            
        }
        return R;
        
    }
    protected ArrayList<Integer> getNodosInt(NodeList Nodos){
         ArrayList<Integer> R=new ArrayList<>();
        for(int j=0,n=Nodos.getLength();j<n;j++){
        String nodoString=Nodos.item(j).getTextContent();
            R.add(Integer.valueOf(nodoString));
    }
        return R;
    }
    public static String RevisionLLave(String llave){
        System.out.print(MapsJava.APIkeyCheck(llave));
        return "ok";
        
    }

    public static int getTiempodePrueba() {
        return tiempodePrueba;
    }

    public static void setTiempodePrueba(int tiempodePrueba) {
        MapasCR.tiempodePrueba = tiempodePrueba;
    }

    public static String getAPIKey() {
        return APIKey;
    }

    public static void setAPIKey(String APIKey) {
        MapasCR.APIKey = APIKey;
        MapsJava.setKey(APIKey);
    }

    public static String getIdioma() {
        return Idioma;
    }

    public static void setIdioma(String Idioma) {
        MapasCR.Idioma = Idioma;
    }

    public static boolean isBandera() {
        return Bandera;
    }

    public static void setBandera(boolean Bandera) {
        MapasCR.Bandera = Bandera;
    }

    public static String[][] getPedidos() {
        return pedidos;
    }

    public static void setPedidos(String[][] pedidos) {
        MapasCR.pedidos = pedidos;
    }

    public static int getNumeroPedido() {
        return NumeroPedido;
    }

    public static void setNumeroPedido(int NumeroPedido) {
        MapasCR.NumeroPedido = NumeroPedido;
    }
    
    
    
    
    
}
