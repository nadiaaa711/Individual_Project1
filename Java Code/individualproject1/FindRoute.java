package individualproject1;

/**
 * @author Nadia Konadu Afriyie
 *
 */

import java.io.*;
import java.util.*;

import static individualproject1.FileReadAndWrite.*;

public class FindRoute {

    public static ArrayList<String> breadthFirstSearch(String startState, String goalState) throws FileNotFoundException {
        /**This method implements the breadth first search algorithm
         */
        System.out.println("Performing a Breadth First Search");

        //creating a queue for the frontier and a set for the explored
        Queue<Node> frontierQueue = new LinkedList<>();
        Set<String> exploredSet = new HashSet<>();

        //creating return values of the methods in the file read and write class
        HashMap<String, ArrayList<String>> cityAirportMap = AirportReadAndWrite();
        HashMap<String, String> airportCityMap = AirportReadAndWrite1();
        HashMap<String, ArrayList<Routes>> routeMap = RouteReadAndWrite();

        //creating a list containing values from the city airport map (airport codes)
        ArrayList<String> airportCodesList = cityAirportMap.get(startState);

        //adding nodes to the frontier
        for (String airportCodes : airportCodesList) {
            frontierQueue.add(new Node(null, airportCodes, null, 0));
        }
        //implementing the breadth first search
        while(frontierQueue.size() > 0){
            Node nodeObj = frontierQueue.remove();
            exploredSet.add(nodeObj.getAirportCode());
            ArrayList<Routes> routes = routeMap.get(nodeObj.getAirportCode());
            if (routes != null) {
                for (Routes route : routes){
                    Node childNodeObj = new Node(nodeObj,route.getDestinationAirportCode(),route.getAirlineCode(),route.getStops());
                    String cityCountry = airportCityMap.get(childNodeObj.getAirportCode());
                    if (! frontierQueue.contains(childNodeObj)&& !exploredSet.contains(childNodeObj.getAirportCode())){
                        if (cityCountry != null){
                            if(cityCountry.equals(goalState)) {
                                return childNodeObj.solutionPath();
                            }
                            frontierQueue.add(childNodeObj);
                        }
                    }
                }
            }

        } return null;
        }


    public static void main(String[] args) throws IOException {

        //reading from an input file and using its content to test the code
        BufferedReader inputFile = new BufferedReader(new FileReader("accra-wajir.txt"));
        String line1 = inputFile.readLine();
        String line2 = inputFile.readLine();
        ArrayList<String> finalSolution = breadthFirstSearch(line1, line2);
        FileWriter fw = new FileWriter("accra-wajir_output.txt");

        for(String line: finalSolution){
            fw.write(line);
            fw.write("\n");
        }
        fw.write("Total flights: " + finalSolution.size());
        fw.write("\n");
        fw.write("Total additional stops: 0");

        fw.close();
        inputFile.close();

    }

}
