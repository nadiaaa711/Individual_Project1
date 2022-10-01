package individualproject1;

/**
 * @author Nadia Konadu Afriyie
 *
 */

public class Routes {

    /**
     * @param args
     */

    /**
     * Instance variables/Fields
     */

    private String airlineCode;
    private String airlineID;
    private String destinationAirportCode;
    private int stops;

    /**
     * Constructor:
     * Building an object of class Routes
     * @param airlineCode
     * @param airlineID
     * @param destinationAirportCode
     * @param stops
     */
    public Routes(String airlineCode, String airlineID,
                  String destinationAirportCode, int stops){
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;

        this.destinationAirportCode = destinationAirportCode;

        this.stops = stops;

    }

    /**
     * accessor method for AirlineCode
     * @return
     */
    public String getAirlineCode() {
        return airlineCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public int getStops() {
        return stops;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "airlineCode='" + airlineCode + '\'' +
                ", airlineID='" + airlineID + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", stops=" + stops +
                '}';
    }

}
