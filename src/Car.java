import java.util.Objects;

/**
 * @author id.111
 * denne klassen brukes til å definere bil
 * <p>
 *     består av variabler som definere en bil
 *     inneholder flere metode for å hente og endre på en bil
 * </p>
 */
public class Car {
    private String registernum;
    private final int YEARMODUL;
    private String color;
    private final String GEAR;
    private final String FUEL;
    private int price;
    private final int HOURSEPOW;
    private String Type;

    /**
     * Konstruktør som inneholder alle vraibalene som definere en bil
     * @param registernum registreringsnummer
     * @param YEARMODUL
     * @param color
     * @param GEAR girkasse
     * @param FUEL type drivstoff
     * @param price
     * @param HOURSEPOW hestekrefter
     * @param type
     */
    public Car(String registernum, int YEARMODUL, String color, String GEAR, String FUEL, int price, int HOURSEPOW, String type) {
        this.registernum = registernum;
        this.YEARMODUL = YEARMODUL;
        this.color = color;
        this.GEAR = GEAR;
        this.FUEL = FUEL;
        this.price = price;
        this.HOURSEPOW = HOURSEPOW;
        this.Type = type;
    }

    /**
     * Konstruktør som definerer en bil
     * <p>
     *     Denne konstruktøren definerer en bil bare på årsmodel, girkasse, drivstoff, pris og hestekraft
     * </p>
     * @param YEARMODUL
     * @param GEAR
     * @param FUEL
     * @param price
     * @param HOURSEPOW
     * @throws Exception hvis noe an spesifikasjonene ikke blir fulgt vil en Exception bli kastet ut
     */
    //TODO: Her der det flere ting som kan blir throwed som Exception
    public Car(int YEARMODUL, String GEAR, String FUEL, int price, int HOURSEPOW) throws Exception {
        if(YEARMODUL < 1900 || YEARMODUL > 2021){
            throw new Exception("Skriv inn Riktig Årsmodell");
        }
        this.YEARMODUL = YEARMODUL;

        this.GEAR = GEAR;

        if (!Objects.equals(FUEL, "bensin") || Objects.equals(FUEL, "diessel")){
            throw new Exception("Skriv inn riktig Drivstoff");
        }
        this.FUEL = FUEL;

        if (price < 0){
            throw new Exception("Pris på bil kan ikke være negativ");
        }
        this.price = price;
        this.HOURSEPOW = HOURSEPOW;
        this.Type = "";
        this.registernum = "";
        this.color = "";
    }


    /**
     * getmetode for å hente ut registreringsnummer
     * @return registreringsnymmeret til bilen
     */
    public String getRegisternum() {
        return registernum;
    }

    /**
     * getmetode for å hente ut bilens prsmoduel
     * @return årsmodulen til bilen
     */
    public int getYEARMODUL() {
        return YEARMODUL;
    }

    /**
     * en getmetode gor fargen til bilen
     * @return string for fargen til bilen
     */
    public String getColor() {
        return color;
    }

    /**
     * getmetode for å hente ut gerkassen til bilen
     * @return string som består av girkassen tl bilen
     */
    public String getGEAR() {
        return GEAR;
    }

    /**
     * en getmetode for å hente ut type drivstoff bilen bruker
     * @return string med drifstoffet til bilen
     */
    public String getFUEL() {
        return FUEL;
    }

    /**
     * en getmetode for å hente ut prisen til bilen
     * @return int med prisen til bilen
     */
    public int getPrice() {
        return price;
    }

    /**
     * en getmetode for å hente ut hestekreftene til bilen
     * @return int med hestekrefter til bilen
     */
    public int getHOURSEPOW() {
        return HOURSEPOW;
    }

    /**
     * en getmetode for å hente ut bilmerket til bilen
     * @return bilmerket til bilen i en string
     */
    public String getType() {
        return Type;
    }

    /**
     * en set metode for å endre fargen til bilen
     * <p>
     *     Ettersom fargen til bilen er noe en salgsperson kan gjøre mener jeg at dette kan derfor endres
     * </p>
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * en set metode for å endre bilmerket
     * @param Type
     */
    public void setType(String Type){
        this.Type = Type;
    }

    /**
     * metode som endrer reistreringnummeret til en bil
     * @param registernum
     */
    public void setRegisternum(String registernum) {
        this.registernum = registernum;
    }

    /**
     * en setmetode for å endre prisen til bilen
     * <p>
     *     brisen på bilen er også noe som er avhengig av forhandleren ikke av bilen selv,
     *     derfor velger jeg å ha en set metode på dette
     * </p>
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * en to string metode som skriver ut verdiene til bilen i form av
     * <p>
     *      Bilmerket fargen og prisen
     * </p>
     * @return string som definerer bilen, med de variablenen som ble etterspurt i oppgavesettet
     */
    @Override
    public String toString() {
        return "\n" + Type + "-" + color + "-" + FUEL;
    }
}
