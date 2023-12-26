package Business;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;


public class GestionReservation {

    public static void main(String[] args) {
        System.out.println("hello");
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("5b0f324abbff4feda79ea888b6472ae6");
        JOpenCageForwardRequest request = new JOpenCageForwardRequest("375 Albert Rd, Woodstock, Cape Town, 7915, South Africa");
        //request.setRestrictToCountryCode("za"); // restrict results to a specific country
        //request.setBounds(18.367, -34.109, 18.770, -33.704); // restrict results to a geographic bounding box (southWestLng, southWestLat, northEastLng, northEastLat)

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition(); // get the coordinate pair of the first result
        System.out.println("Latitude: "  + firstResultLatLng.getLat().toString() + ",Longitude" + firstResultLatLng.getLng().toString());
// prints -33.9275623,18.4571101

    }
}
