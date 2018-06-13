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
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
public class Sitios extends MapasCR{
    private double lat;
    private double longitud;
    private int radio;
    private final String URLR="https://maps.googleapis.com/maps/api/place/search/xml";
    private final String URLDetalles="https://maps.googleapis.com/maps/api/place/details/xml";
    private final String URLFoto="https://maps.googleapis.com/maps/api/place/photo";
    private final String pathStatus="PlaceSearchResponse/status";
    private final String pathDetailsStatus="PlaceDetailsResponse/status";
    private ArrayList<String> Referencias;
    public Sitios(){
   
}
    public enum Rankby{prominence,distance}
    @Override
    protected void Error(URL Pagina, String estado, Exception ex) {
       super.GuardarPedido(Pagina.toString(), "Lugares pedidos", estado, ex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getESTADO(XPath x, Document Documento) {
        NodeList nodes;
        try {
            nodes = (NodeList) x.evaluate(this.pathStatus,Documento, XPathConstants.NODESET);
            return nodes.item(0).getTextContent();
        } catch (Exception ex) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void GuardarInfo(URL Pagina, String informacion, String estado, Exception excp) {
        super.GuardarPedido(Pagina.toString(), informacion, estado, excp); //To change body of generated methods, choose Tools | Templates.
    }
    private String[][] getNodosSitios(ArrayList<NodeList> Sitios){
        String[][] resultado=new String[1000][6];
        for(int i=0;i<Sitios.size();i++){
            for(int j=0,n=Sitios.get(i).getLength();j<n;j++){
            String SitioString=Sitios.get(i).item(j).getTextContent();
            System.out.print(SitioString);
            resultado[i][j]=SitioString;
            
            
        }}
            resultado=(String[][])super.tamaño(resultado, Sitios.get(0).getLength());
            System.out.print(resultado);
            return resultado;
        }
    private URL Pagina(double lat, double longi,int R, String Lugartipo,String nombre,Rankby rank, ArrayList<String> tipos  ) throws UnsupportedEncodingException, MalformedURLException{
    String _location= this.URLR+"?location="+lat+","+longi;
    String _radius="";
     if(!rank.equals(Rankby.distance)){
        _radius= "&radius=" + R;
        }
     String _keyword="";
     String _namePlace ="";
     String _rankby="&rankby="+rank.toString();
     String _types="";
     if(Lugartipo!=null&&!Lugartipo.isEmpty()){
         _keyword="&keyword"+URLEncoder.encode(Lugartipo,"utf-8" );
         
     }
     if(nombre!=null&&!nombre.isEmpty()){
         _namePlace="&namePlace="+URLEncoder.encode(nombre,"utf-8" );
         
     }
     if(tipos!=null&&tipos.size()>0){
         _types="&types=";
         for(String item:tipos){
                _types+=item;
            }
         
     }
     URL urlR=new URL(_location + _radius + _keyword + _namePlace + _rankby +_types + super.getSelectPropertiesRequest() + "&key=" + MapasCR.getAPIKey());
        return urlR;
             
    }
    public String[][] getSitios(double latitude, double longitude,int radius,String keyword,String namePlace,
      Rankby rankby,ArrayList<String> types) throws UnsupportedEncodingException, MalformedURLException{
        URL url=this.Pagina(latitude,longitude,radius,keyword,namePlace,rankby,types);
    
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document document = builder.parse(url.openStream()); 

            XPathFactory xpathFactory = XPathFactory.newInstance(); 
            XPath xpath = xpathFactory.newXPath();
            
            NodeList nodeName = (NodeList) xpath.evaluate("PlaceSearchResponse/result/name", 
                         document, XPathConstants.NODESET);
            System.out.print("Nombe¿re="+nodeName);
            NodeList nodeVicinity = (NodeList) xpath.evaluate("PlaceSearchResponse/result/vicinity", 
                         document, XPathConstants.NODESET);
            System.out.print("Vcinity="+nodeVicinity);
            NodeList nodeLatitude = (NodeList) xpath.evaluate("PlaceSearchResponse/result/geometry/location/lat", 
                         document, XPathConstants.NODESET);
            NodeList nodeLongitude = (NodeList) xpath.evaluate("PlaceSearchResponse/result/geometry/location/lng", 
                         document, XPathConstants.NODESET);
            NodeList nodeIcon = (NodeList) xpath.evaluate("PlaceSearchResponse/result/icon", 
                         document, XPathConstants.NODESET);
            NodeList nodeReference = (NodeList) xpath.evaluate("PlaceSearchResponse/result/reference", 
                         document, XPathConstants.NODESET);
                
            ArrayList<NodeList> allNodes=new ArrayList<>();
            allNodes.add(nodeName);allNodes.add(nodeVicinity);allNodes.add (nodeLatitude);
            allNodes.add(nodeLongitude);allNodes.add(nodeIcon);allNodes.add(nodeReference);
            String[][] result=this.getNodosSitios(allNodes);
            this.getDertalles(allNodes);
            String[][] copia=result;
            if(copia[1][1]==null){
                System.out.print("esta vacia");
            }
            
            
            this.GuardarInfo(url, "Places request", this.getESTADO(xpath, document), null);
            return result;
        } catch (Exception e) {
            this.Error(url,"NO STATUS",e);
            return null;
        }
    }
    private String[] getDertalles(ArrayList<NodeList> lista){
        String resultado[]=new String[8];
        for(int i=0;i<lista.size();i++){
            try{
                resultado[i]=lista.get(i).item(0).getTextContent();
                 System.out.print(resultado[i]);
                
            }
            catch(Exception Ex){
                resultado[i]="no data;";
            }
            
        }
     return resultado;   
    }
    protected String getEstadoDetalles(XPath xpath, Document documento){
        NodeList Lista;
        try{
            Lista=(NodeList)xpath.evaluate(this.pathDetailsStatus, 
                documento,XPathConstants.NODESET);
             return Lista.item(0).getTextContent();
        }catch (Exception ex) {
            return null;
    }}
    private URL crearUrl(String elemento)throws UnsupportedEncodingException, MalformedURLException{
        URL nuevo=new URL(this.URLDetalles+"?reference="+URLEncoder.encode(elemento, "utf-8")+super.getSelectPropertiesRequest()+"&key="+MapasCR.getAPIKey());
       System.out.print("URL="+nuevo);
        return nuevo;
    }
     public String[] getSitiosDetalles(String referenciaPlace) throws UnsupportedEncodingException, MalformedURLException{
        URL url=this.crearUrl(referenciaPlace);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document document = builder.parse(url.openStream()); 

            XPathFactory xpathFactory = XPathFactory.newInstance(); 
            XPath xpath = xpathFactory.newXPath();

            NodeList nodeName = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/name", 
                         document, XPathConstants.NODESET);
            NodeList nodeVicinity = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/vicinity", 
                         document, XPathConstants.NODESET);
            NodeList nodePhone = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/formatted_phone_number", 
                         document, XPathConstants.NODESET);
            NodeList nodeAddress = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/formatted_address", 
                         document, XPathConstants.NODESET);
            NodeList nodeUrlGoogle = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/url", 
                         document, XPathConstants.NODESET);
            NodeList nodeRating = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/rating", 
                         document, XPathConstants.NODESET);
            NodeList nodeIcon = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/icon", 
                         document, XPathConstants.NODESET);
            NodeList nodeWebsite = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/website", 
                         document, XPathConstants.NODESET);
            
            ArrayList<NodeList> allNodes=new ArrayList<>();
            allNodes.add(nodeName);allNodes.add(nodeVicinity);allNodes.add(nodePhone);
            allNodes.add(nodeAddress);allNodes.add(nodeUrlGoogle);allNodes.add(nodeRating);
            allNodes.add(nodeIcon);allNodes.add(nodeWebsite);
            System.out.print("Tamaño"+allNodes.size());
            String[] resultado=this.getDertalles(allNodes);
            
            this.GuardarInfo(url, "Places details request", this.getEstadoDetalles(xpath, document), null);
            return resultado;
            
        } catch (Exception e) {
            this.Error(url,"NO STATUS",e);
            return null;
        }
    }
     private String[][] getRevisiondeSitio(ArrayList<NodeList> nodos){
          String[][] result=new String[1000][4];
        for(int i = 0; i < nodos.size();i++){
             for (int j = 0, n = nodos.get(i).getLength(); j < n; j++) {
                 String nodeString = nodos.get(i).item(j).getTextContent();
                 result[j][i]=nodeString;
             }
        }
        result=(String[][])super.tamaño(result, nodos.get(0).getLength());
        return result;
    }
     private ArrayList<String> getNodosFoto(NodeList node){
       ArrayList<String> result=new ArrayList<>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(nodeString);
             }
        return result;
    }
     public String[][] getPlaceReview(String R) throws UnsupportedEncodingException, MalformedURLException{
        URL url=this.crearUrl(R);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document document = builder.parse(url.openStream()); 

            XPathFactory xpathFactory = XPathFactory.newInstance(); 
            XPath xpath = xpathFactory.newXPath();

            NodeList nodeTime = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/review/time", 
                         document, XPathConstants.NODESET);
            NodeList nodeAuthor= (NodeList) xpath.evaluate("PlaceDetailsResponse/result/review/author_name", 
                         document, XPathConstants.NODESET);
            NodeList nodeText = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/review/text", 
                         document, XPathConstants.NODESET);
            NodeList nodeURL = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/review/author_url", 
                         document, XPathConstants.NODESET);
            System.out.print("Detalles"+nodeURL.toString());
            
            ArrayList<NodeList> allNodes=new ArrayList<>();
            allNodes.add(nodeTime);allNodes.add(nodeAuthor);allNodes.add(nodeText);
            allNodes.add(nodeURL);
            
            String[][] result=this.getRevisiondeSitio(allNodes);
            
            this.GuardarInfo(url, "Places review request", this.getEstadoDetalles(xpath, document), null);
            
            NodeList nodePhoto = (NodeList) xpath.evaluate("PlaceDetailsResponse/result/photo/photo_reference", 
                         document, XPathConstants.NODESET);
            this.Referencias=this.getNodosFoto(nodePhoto);
            
            return result;
            
        } catch (Exception e) {
            System.out.print("YO NO SIRTVIO!!!!!!");
            this.Error(url,"NO STATUS",e);
            return null;
        }
    }
     private URL GenerarUrl(String photoreference,int maxWidth) throws MalformedURLException{
        URL urlReturn=new URL(this.URLFoto+ "?maxwidth=" + maxWidth + "&photoreference=" + 
                photoreference + super.getSelectPropertiesRequest() + "&key=" + MapasCR.getAPIKey());
        return urlReturn;
    }
      public Image getImagen(String photoreference,int maxWidth) throws MalformedURLException{
        URL url=this.GenerarUrl(photoreference,maxWidth);
        try {
            Image imageReturn;
            imageReturn=ImageIO.read(url);
            this.GuardarInfo(url,"Photo request","OK",null);
            return imageReturn;
        } catch (Exception e) {
            this.Error(url, "NO STATUS", e);
            return null;
        }
    }
     
     
     
     
     }
     
    
    
    
    
        
    
    
    
    
    
    

