package individualproject1;

/**
 * @author Nadia Konadu Afriyie
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Node {

    /**
     * @param args
     */

    /**
     * Instance variables/Fields
     */

    private String airportCode;
    private Node parent;
    private String airlineCode;
    private int stops;

    /**
     * Constructor:
     * Building an object of class Routes
     * @param parent
     * @param airportCode
     * @param airlineCode
     * @param stops
     */
    public Node(Node parent, String airportCode, String airlineCode, int stops) {
        this.airportCode = airportCode;
        this.parent = parent;
        this.airlineCode = airlineCode;
        this.stops = stops;
    }

    /**
     * accessor method for Node
     * @return
     */
    public String getAirportCode() {
        return airportCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public int getStops() {
        return stops;
    }


    public ArrayList<String>solutionPath(){
        /**This method reads creates a solution path that shows the
         * start and destination airport codes and the airline ID for that flight
         *as well as the number of stops
         */

        //declaring three arraylists for the instance variables
        ArrayList<String> airportCodesList = new ArrayList<String>();
        ArrayList<String> airlineCodesList = new ArrayList<String>();
        ArrayList<Integer> stopsList = new ArrayList<Integer>();
        ArrayList<String> pathList = new ArrayList<String>();

        Node changingNode = this;

        //adding the values to the lists
        while (changingNode !=null){
            airportCodesList.add(changingNode.getAirportCode());
            airlineCodesList.add(changingNode.getAirlineCode());
            stopsList.add(changingNode.getStops());

            changingNode=changingNode.parent;
        }

        //reversing the order of the list
        Collections.reverse(airlineCodesList);
        Collections.reverse(airportCodesList);
        Collections.reverse(stopsList);

        //creating the solution print statement
        for(int i = 0; i < airlineCodesList.size() - 1; i++){
            String solutionStatement = i+1 + ". " + airlineCodesList.get(i+1) + " from " + airportCodesList.get(i) +
                                        " to " + airportCodesList.get(i+1) +" "+ stopsList.get(i) + " stops.";
//            String numberOfFlights = "Total number of flights: " + solutionPath().size();

            pathList.add(solutionStatement);
//            pathList.add(numberOfFlights);
        }

        return pathList;
    }

    @Override
    public String toString() {
        /**This method creates a string representation of the class
         */
        return "Node{" +
                "airportCode='" + airportCode + '\'' +
                ", parent=" + parent +
                ", airlineCode='" + airlineCode + '\'' +
                ", stops=" + stops +
                '}';
    }
}
