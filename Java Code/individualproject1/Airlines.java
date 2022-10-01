package individualproject1;

/**
 * @author Nadia Konadu Afriyie
 *
 */

public class Airlines {

    /**
     * @param args
     */

    /**
     * Instance variables/Fields
     */

    private String airlineID;
    private String name;
    private String alias;
    private String IATACode;
    private String ICAOCode;
    private String callSign;
    private String country;
    private String active;

    /**
     * Constructor:
     * Building an object of class Music
     * @param airlineID
     * @param name
     * @param alias
     * @param IATACode
     * @param ICAOCode
     * @param callSign
     * @param country
     * @param active
     */

    public Airlines(String airlineID, String name,
                    String alias, String IATACode,
                    String ICAOCode, String callSign,
                    String country, String active) {
        this.airlineID = airlineID;
        this.name = name;
        this.alias = alias;
        this.IATACode = IATACode;
        this.ICAOCode = ICAOCode;
        this.callSign = callSign;
        this.country = country;
        this.active = active;
    }
    /**
     * accessor method for airlineID
     * @return
     */

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return null;
    }
}
