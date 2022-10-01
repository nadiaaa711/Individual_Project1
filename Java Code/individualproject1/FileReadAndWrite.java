package individualproject1;

/**
 * @author Nadia Konadu Afriyie
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReadAndWrite {

    /**
     * Constructor:
     * Building an object of class FileReadAndWrite
     */
    FileReadAndWrite(){}

    // declaring a map and an arraylist
    static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    static ArrayList<String> newAirlineValues = new ArrayList<String>();
    public static HashMap<String, ArrayList<String>> AirlineReadAndWrite() throws FileNotFoundException {
        /**This method reads from the airline csv file and splits each line at the comma,
        *appending the individual entries into an array, then creates a hashmap,
        *with airline ID as the key an arraylist of the remaining entries as the values
         */

        //reading from the airlines file
        Scanner airlinesFile = new Scanner(new File("C:\\Users\\SWIFT 3\\OneDrive - Ashesi University\\Nadia\\Academic\\Year2\\Year 2 Sem 2\\Intermediate Computer Programming\\Java Code\\Airlines.csv"));

        //splitting the airline file at every comma and appending each entry into an array
        while (airlinesFile.hasNext()) {
            String[] airlineArray = airlinesFile.nextLine().split(",");

            //putting all values except the airline ID into the arraylist
            newAirlineValues.add(airlineArray[1]);
            newAirlineValues.add(airlineArray[2]);
            newAirlineValues.add(airlineArray[3]);
            newAirlineValues.add(airlineArray[4]);
            newAirlineValues.add(airlineArray[5]);
            newAirlineValues.add(airlineArray[6]);

            //making the airlineID the key of the map, with an arraylist of the remaining entries the values
            map.put(airlineArray[0], newAirlineValues);

        }

        //closing the file stream
        airlinesFile.close();
        return map;
    }


    // declaring two maps, an arraylist and an array
    static HashMap<String, ArrayList<String>> generalMap = new HashMap<String, ArrayList<String>>();
    static ArrayList<String> newAirportValues = new ArrayList<String>();
    static HashMap<String, ArrayList<String>> cityAirportMap = new HashMap<String, ArrayList<String>>();
    static HashMap<String, String> airportCityMap = new HashMap<String, String>();
//    static ArrayList<String> destCities = new ArrayList<String>();
    static ArrayList<String> airportCodesOnly = new ArrayList<String>();

    static String[] airportArray = new String[14];
    public static HashMap<String, ArrayList<String>> AirportReadAndWrite() throws FileNotFoundException {
        /**This method reads from the airports csv file and splits each line at the comma,
         *appending the individual entries into an array, then creates two hashmaps,
         * with the city and country as the key and an arraylist containing specific entries from the file as the values
         */

        //reading from the airports file
        Scanner airportsFile = new Scanner(new File("C:\\Users\\SWIFT 3\\OneDrive - Ashesi University\\Nadia\\Academic\\Year2\\Year 2 Sem 2\\Intermediate Computer Programming\\Java Code\\Airports.csv"));

        //splitting the airports file at every comma and appending each entry into an array
        while (airportsFile.hasNext()) {
            String[] airportArray = airportsFile.nextLine().split(",");
//
            //adding remaining entries to the arraylist
            newAirportValues.add(airportArray[0]);
            newAirportValues.add(airportArray[1]);
            newAirportValues.add(airportArray[4]);
            newAirportValues.add(airportArray[5]);
            newAirportValues.add(airportArray[6]);
            newAirportValues.add(airportArray[7]);
            newAirportValues.add(airportArray[8]);
            newAirportValues.add(airportArray[9]);
            newAirportValues.add(airportArray[10]);
            newAirportValues.add(airportArray[11]);
            newAirportValues.add(airportArray[12]);
            newAirportValues.add(airportArray[13]);

            //making city and country the key and the arraylist with all other entries the values
            generalMap.put(airportArray[2]+", "+airportArray[3], newAirportValues);

            //making city and country the key and the airport code the value
            //adding the airport code to the arraylist if the city and country are a key
            if(cityAirportMap.containsKey(airportArray[2]+", "+airportArray[3])){
                airportCodesOnly.add(airportArray[4]);
                cityAirportMap.put(airportArray[2]+", "+airportArray[3], airportCodesOnly);
            }
            //making the start ID the key if is not and adding its corresponding destination ID to the arraylist
            else{
                airportCodesOnly = new ArrayList<String>();
                airportCodesOnly.add(airportArray[4]);
                cityAirportMap.put(airportArray[2]+", "+airportArray[3], airportCodesOnly);
            }
        }
        //closing the file stream
        airportsFile.close();
        return cityAirportMap;
    }


    public static HashMap<String, String> AirportReadAndWrite1() throws FileNotFoundException {
        /**This method reads from the airports csv file and splits each line at the comma,
         *appending the individual entries into an array, then creates two hashmaps,
         * with the city and country as the key and an arraylist containing specific entries from the file as the values
         */

        //reading from the airports file
        Scanner airportsFile = new Scanner(new File("C:\\Users\\SWIFT 3\\OneDrive - Ashesi University\\Nadia\\Academic\\Year2\\Year 2 Sem 2\\Intermediate Computer Programming\\Java Code\\Airports.csv"));

        //splitting the airports file at every comma and appending each entry into an array
        while (airportsFile.hasNext()) {
            String[] airportArray = airportsFile.nextLine().split(",");
//
            //adding remaining entries to the arraylist
            newAirportValues.add(airportArray[0]);
            newAirportValues.add(airportArray[1]);
            newAirportValues.add(airportArray[4]);
            newAirportValues.add(airportArray[5]);
            newAirportValues.add(airportArray[6]);
            newAirportValues.add(airportArray[7]);
            newAirportValues.add(airportArray[8]);
            newAirportValues.add(airportArray[9]);
            newAirportValues.add(airportArray[10]);
            newAirportValues.add(airportArray[11]);
            newAirportValues.add(airportArray[12]);
            newAirportValues.add(airportArray[13]);

            //making city and country the key and the arraylist with all other entries the values
            generalMap.put(airportArray[2]+", "+airportArray[3], newAirportValues);

            //making airport codes the key and city the value
            airportCityMap.put(airportArray[4], airportArray[2]+", "+airportArray[3]);

        }
        //closing the file stream
        airportsFile.close();
        return airportCityMap;
    }


    // declaring a map, an arraylist and an arrays
    static ArrayList<String> destAirports = new ArrayList<String>();
    static HashMap<String, ArrayList<Routes>> routeMap = new HashMap<String, ArrayList<Routes>>();
    static String[] routeArray;
    public static HashMap<String, ArrayList<Routes>> RouteReadAndWrite() throws FileNotFoundException {
        /**This method reads from the airports csv file and splits each line at the comma,
         *appending the individual entries into an array, then creates three hashmaps,
         * with the airport ID as the key and an arraylist containing specific entries from the file as the values
         */

        //reading from the routes file
        Scanner routesFile = new Scanner(new File("C:\\Users\\SWIFT 3\\OneDrive - Ashesi University\\Nadia\\Academic\\Year2\\Year 2 Sem 2\\Intermediate Computer Programming\\Java Code\\Routes.csv"));

        //splitting the routes file at every comma and appending each entry into an array
        while (routesFile.hasNext()) {
            String[] routeArray = routesFile.nextLine().split(",");

            //creating a route object with the needed arguments
            Routes routeObj = new Routes(routeArray[0],routeArray[1],routeArray[4],Integer.parseInt(routeArray[7]));

            //checking to see if the key is already in the hashmap
            ArrayList<Routes> newRoutesList = routeMap.get(routeArray);

            if (newRoutesList == null) {
                ArrayList<Routes> routeList = new ArrayList<Routes>();
                routeList.add(routeObj);
                routeMap.put(routeArray[2], routeList);
            }else{
                newRoutesList.add(routeObj);
                routeMap.put(routeArray[2], newRoutesList); //key is the airport code
            }
        }
        //closing the file stream
        routesFile.close();
        return routeMap;
    }


    public static void main(String[] args) throws FileNotFoundException {
        AirlineReadAndWrite();
        AirportReadAndWrite();
        RouteReadAndWrite();
    }
}
