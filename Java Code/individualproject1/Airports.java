package individualproject1;

/**
 * @author Nadia Konadu Afriyie
 */

import java.io.FileNotFoundException;

public class Airports {

    /**
     * @param args
     */

    /**
     * Instance variables/Fields
     */

    private String airportID;
    private String name;
    private String city;
    private String country;
    private String IATACode;

    /**
     * accessor method for Airports
     * @return
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static void main(String[] args) throws FileNotFoundException {


    }
}
