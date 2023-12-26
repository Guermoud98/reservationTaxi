package Business;

import DAO.IReservationDAO;
import DAO.IReservationDAOImplement;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;


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
        //request
        JOpenCageForwardRequest requestSource = new JOpenCageForwardRequest(lieuSource);
        //response
        JOpenCageResponse responseSource = key.forward(requestSource);
        //firstPosition : // get the coordinate pair of the first result
        JOpenCageLatLng firstResultLatLngSource = responseSource.getFirstPosition();
        /*********Destination*******/
        //request
        JOpenCageForwardRequest requestDestination = new JOpenCageForwardRequest(lieuDestination);
        //response
        JOpenCageResponse responseDestination = key.forward(requestDestination);
        //firstPosition :  get the coordinate pair of the first result
        JOpenCageLatLng firstResultLatLngDestination = responseDestination.getFirstPosition();
        /*********Affichage LongLati Source*******/
        System.out.println("Source info: \n Latitude: "  + firstResultLatLngSource.getLat().toString() + ",Longitude: " + firstResultLatLngSource.getLng().toString() + "\n");
        /*********Affichage LongLati Destination*******/
        System.out.println("Destination info: \n Latitude: "  + firstResultLatLngDestination.getLat().toString() + ",Longitude: " + firstResultLatLngDestination.getLng().toString() + "\n");





    }

}
