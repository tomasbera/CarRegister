import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author id.111
 * Denne klassen beskriver et registrer til klassen bil
 * <p>
 *     her har vi flere metoder for å regisrere/endre og finne spesifikke egenskaper til en bil
 *     i denne klassen bruker jeg også arraylist som min liste av biller
 *     grunnen til det er fordi jeg da kan ha uendelig mange biler registrert
 *     og fordi arraylust gir meg letter hondtering og bruk i denne oppgaven
 * </p>
 */
public class CarRegister {

    private final ArrayList<Car> cars;

    public CarRegister() {
        cars = new ArrayList<>();
    }

    /**
     * En metode som registrere en bil bare etter pris årsmodel type drivstoff girkasse og hestekraft
     * @param newPrice
     * @param newYearmodul
     * @param newFuel
     * @param newGear
     * @param newHourspow
     * @return alle biler registrert ettersom jeg ønsker at bilforhandleren ser alle biler han jobber med
     */
    public ArrayList<Car> registerNewCar(int newPrice, int newYearmodul, String newFuel, String newGear, int newHourspow) throws Exception {
       cars.add(new Car(newYearmodul, newGear, newFuel, newPrice, newHourspow));
       return cars;
    }

    /**
     * metode som finner en bil etter merke/type farge og drivstoff
     * @param findModuel
     * @param findColor
     * @param findFuel
     * @return en arraylist med aller biler etter disse kravene
     * @throws Exception hvis den ikke finner en bil med kravsspesefikasjoner vil den kaste en exceprion
     */
    public ArrayList<Car> findMCF(int findModuel, String findColor, String findFuel) throws Exception {
        ArrayList<Car> mCFCars = new ArrayList<>();
        for (Car c : cars){
            if (c.getColor().equals(findColor) && c.getFUEL().equals(findFuel) && c.getYEARMODUL() == findModuel){
                mCFCars.add(c);
            }
        }
        if (mCFCars.size() == 0){
            throw new Exception("Ingen biler etter denne beskrivelsen ble funnet");
        }
        return deepCopyMethod(mCFCars);
    }

    /**
     * en metode som finner aller biler etter en pris
     * @param findPrice
     * @return en arrayliste med alle biler emd denne prisen
     * @throws Exception hvis den ikke finner noen biler med denne prisen vil den kaste en exceprion
     */
    public ArrayList<Car> findP(int findPrice) throws Exception {
        ArrayList<Car> carByPrice = new ArrayList<>();
        for (Car c : cars){
            if (c.getPrice() == findPrice){
                carByPrice.add(c);
            }
        }

        if(carByPrice.size() == 0){
            throw new Exception("Biler med denne prisen ble ikke funnet");
        }

        return deepCopyMethod(carByPrice);
    }

    /**
     * en metode som fjerner en bil etter registreringnummer
     * <p>
     *     her er problemet at en bil ikke alltid har et registreringnummer
     *     det jeg tenker da at en bil først må bli solg, og for da et registreringnummer (via set metoden)
     *     så kan man lete etter den her og slette den
     * </p>
     * @param soldRegisterNum
     * @throws Exception hvis registreringsnummert ikke finnes vil den kaste en exceprion
     */
    public void deleteSoldCar(String soldRegisterNum) throws Exception {
        for (Car c : cars){
            if (!c.getRegisternum().equals(soldRegisterNum)){
                throw new Exception("En bil med dette regstreringnummer ble ikke funnet" +
                        "pass på at bilen er solgt før du prøver å fjerne den");
            }
        }

        cars.removeIf(c -> c.getRegisternum().equals(soldRegisterNum));
    }

    /**
     * en metode som printer ut alle biler som er registrert
     * @return alle biler i registeret
     */
    public ArrayList<Car> soutAllCars(){
        ArrayList<Car> allCars;
        allCars = deepCopyMethod(cars);
        return allCars;
    }

    /**
     * metode som finner alle biler med årsmodel lik eller lavere enn årsmodel valg i klienten
     * @param findModuel året du leter etter
     * @return alle biler som har lavere eller lik årsmodell
     * @throws Exception kaster en exception hvis ingen biler etter årsmodellen ble funnet
     */
    public ArrayList<Car> cByYearModuel(int findModuel) throws Exception {
        ArrayList<Car> allcWTYearModuel = new ArrayList<>();
        for (Car c : cars){
            if (c.getYEARMODUL() <= findModuel){
                allcWTYearModuel.add(c);
            }
        }
        if (allcWTYearModuel.size() == 0){
            throw new Exception("Ingen biler etter denne årsmodelen ble funnet");
        }
        return deepCopyMethod(allcWTYearModuel);
    }

    /**
     * en deepcopy metode som vil kopiere alle elementer til en liste over til en anne i form av en deep copy
     * @param copyMe arrayliste du vil kopiere
     * @return deep copy av listen
     */
    public ArrayList<Car> deepCopyMethod(ArrayList<Car> copyMe){
        ArrayList<Car> theCopy = new ArrayList<>();
        for (Car c : copyMe){
            theCopy.add(new Car(c.getRegisternum(), c.getYEARMODUL(), c.getColor(), c.getGEAR(), c.getFUEL(),
                    c.getPrice(), c.getHOURSEPOW(), c.getType()));
        }
        return theCopy;
    }

    /**
     * denne metoden finner en bil basert på dens index i registeret og så setter den en gitt registreringnummer
     * @param findNum indexen du leter etter
     * @param newRegisternum
     */
    public void registerANumber(int findNum, String newRegisternum) throws Exception {
        String keyRegNum = "[A-Z]{2}\\d{5}";
        Pattern pt = Pattern.compile(keyRegNum);
        Matcher mt = pt.matcher(newRegisternum);
        boolean result = mt.matches();
        if (!result){
            throw new Exception("""
                    
                    Registreringnummeret er feil skrevet
                    Husk at det må være på formatet
                    AAXXXXX
                    """);
        }

        for (Car c : cars){
            if (c.getRegisternum().equals(newRegisternum)){
                throw new Exception("Dette registreringnummeret er alelrede registrert");
            }
        }

        cars.get(findNum).setRegisternum(newRegisternum);
    }

    /**
     * en setmoetode for å endre registreringnummeret til en bil
     * @param newRegisternum
     * @param oldRegisternum
     */
    public void setRegisternum(String newRegisternum, String oldRegisternum) {
        for (Car c : cars){
            if (c.getRegisternum().equals(oldRegisternum)){
                c.setRegisternum(newRegisternum);
            }
        }
    }

    /**
     * en setmetode for å endre prisen til en bil med spesifikt registreringsnummer
     * @param newPrice
     * @param findRegisternum
     */
    public void setPrice(int newPrice, String findRegisternum) {
        for (Car c : cars){
            if (c.getRegisternum().equals(findRegisternum)){
                c.setPrice(newPrice);
            }
        }
    }

    /**
     * en setmetode for å endre fargen til en bil med spesifikt registreringsnummer
     * @param newColor
     * @param findRegisternum
     */
    public void setColor(String newColor, String findRegisternum) {
        for (Car c : cars){
            if (c.getRegisternum().equals(findRegisternum)){
                c.setColor(newColor);
            }
        }
    }

    /**
     * en setmetode fpr å endre bilmerket til bilen spesifikt valgt av klienten
     * @param newType
     * @param findRegisternum
     */
    public void setType(String newType, String findRegisternum){
        for (Car c : cars){
            if (c.getRegisternum().equals(findRegisternum)){
                c.setType(newType);
            }
        }
    }

    /**
     * denne metoden henter alle biler
     * <p>
     *     Jeg liker egnetlig ikke denne metoden
     *     siden den egentlig ødeleger litt for composisjon
     * </p>
     * @return alle biler i cars
     */
    //TODO: Finn en lur måte å bli kvitt denne på; liker ikke denne.
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * en to string metode som sender en stringbuiler til to string i Car
     * @return returener en string definsert etter string builder i car
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car c : cars) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}
