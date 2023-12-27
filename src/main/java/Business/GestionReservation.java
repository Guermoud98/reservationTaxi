package Business;

import DAO.IReservationDAO;
import DAO.IReservationDAOImplement;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;

import java.util.HashMap;


public class GestionReservation {
    private String lieuDestination;
    private String lieuSource;
    private JOpenCageGeocoder key = new JOpenCageGeocoder("5b0f324abbff4feda79ea888b6472ae6");

    public GestionReservation(String lieuDestination, String lieuSource) {
        this.lieuDestination = lieuDestination;
        this.lieuSource = lieuSource;
    }
    public GestionReservation() {

    }
    public void Reserver(String lieuSource, String lieuDestination) {
        /*********Source*******/
        convertirDestSrcEnLongLat(lieuSource, lieuDestination);



    }
    //cette methode fait la conversion du lieuSource en latitude et longitude
    public void convertirDestSrcEnLongLat(String lieuSource, String lieuDestination) {
        /*********Source*******/
        //request
        JOpenCageForwardRequest requestSource = new JOpenCageForwardRequest(lieuSource);
        //response
        JOpenCageResponse responseSource = key.forward(requestSource);
        //firstPosition : // get the coordinate pair of the first result
        JOpenCageLatLng firstResultLatLngSource = responseSource.getFirstPosition();
        /*********Affichage LongLati Source*******/
        System.out.println("Source info: \n Latitude: "  + firstResultLatLngSource.getLat().toString() + ",Longitude: " + firstResultLatLngSource.getLng().toString() + "\n");
        /*********Destination*******/
        JOpenCageForwardRequest requestDestination = new JOpenCageForwardRequest(lieuDestination);
        //response
        JOpenCageResponse responseDestination = key.forward(requestDestination);
        //firstPosition :  get the coordinate pair of the first result
        JOpenCageLatLng firstResultLatLngDestination = responseDestination.getFirstPosition();
        /*********Affichage LongLati Destination*******/
        System.out.println("Destination info: \n Latitude: "  + firstResultLatLngDestination.getLat().toString() + ",Longitude: " + firstResultLatLngDestination.getLng().toString() + "\n");
    }
    //cette methode fait la conversion du lieuDestination en latitude etlongitude

    //public float calculerDistance()

    //cette methode retourne un hashmap qui stock la longitude et sa valeur du lieu passe en parametre
    public HashMap<String, Float> getLongitudeLieu(String lieu) {
        HashMap<String, Float> srcLongitude = new HashMap<String, Float>();
        //request
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(lieu);
        //response
        JOpenCageResponse response = key.forward(request);
        //firstPosition : // get the coordinate pair of the first result
        JOpenCageLatLng firstResult = response.getFirstPosition();
        srcLongitude.put("Longitude", Float.parseFloat(firstResult.getLng().toString())); // on fait le parse car firstResultLatLngSource.getLng().toString() retourne un string
        return srcLongitude;
    }
    public HashMap<String, Float> getLatitudeLieu(String lieu) {
        HashMap<String, Float> srcLatitude = new HashMap<String, Float>();
        //request
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(lieu);
        //response
        JOpenCageResponse response = key.forward(request);
        //firstPosition : // get the coordinate pair of the first result
        JOpenCageLatLng firstResult = response.getFirstPosition();
        srcLatitude.put("Longitude", Float.parseFloat(firstResult.getLat().toString())); // on fait le parse car firstResult.getLng().toString() retourne un string
        return srcLatitude;
    }

}
