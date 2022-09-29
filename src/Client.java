import static javax.swing.JOptionPane.*;

/**
 * @author id.111
 * Dette er er da klientprogrammet mitt
 * det klienten har flere valgmuligheter som å registrere/endre/finne verdier til biler
 * og bilene selv
 */

public class Client {
    public static CarRegister carReg = new CarRegister();
    public static boolean finished = true;

    public static void main(String[] args) throws Exception {
        carReg.getCars().add(new Car("AA63128", 2014, "black", "M", "bensin", 120, 90000, "Volvo"));
        carReg.getCars().add(new Car("ZZ63128", 2018, "white", "A", "bensin", 120, 90000, "Mercedes"));
        menu();
    }

    public static void menu() {
        while (finished){

            try {
                String[] choices = {"List all informasjon", "Registrer ny Bil", "Finn bil basert på MCF",
                        "Finn bil etter pris", "Slett solgdt bil", "Finn bil etter Årsmodel" + "\n", "Register nummer på bilen",
                        "Endre verdier til bil", "Avslutt"};

                final int LIST_ALLE = 0;
                final int REGISTRER_BIL = 1;
                final int FINN_ETTER_MCF = 2;
                final int FINN_ETTER_PRIS = 3;
                final int SLETT_BIL = 4;
                final int FINN_BIL_YEAR = 5;
                final int REGISTRER_NUMMER = 6;
                final int ENDRE_VERDIER = 7;
                final int AVSLUTT = 8;

                int choice = showOptionDialog(null, "***** Nilsens Automobil (Kirkenes) Car Register Application *****" + "\nVelg funksjon",
                        "Eksamen des 2020", YES_NO_OPTION, INFORMATION_MESSAGE, null, choices, choices[0]);

                switch (choice) {
                    case LIST_ALLE -> {
                        System.out.println(carReg.soutAllCars().toString());
                    }

                    case REGISTRER_BIL -> {
                        String priceRead = showInputDialog("Hvor mye koster bilen i antall 1000kr");
                        int price = Integer.parseInt(priceRead);
                        String yearModuelRead = showInputDialog("Skriv inn årsmodellen til bilen");
                        int yearModuel = Integer.parseInt(yearModuelRead);
                        String fuel = showInputDialog("Skriv inn type drivstoff bilen bruker");
                        String gear = showInputDialog("Skriv inn girkassen til bilen (A eller M)");
                        String hoursPowRead = showInputDialog("Skriv inn hestekreftene til Bilen");
                        int hoursepow = Integer.parseInt(hoursPowRead);

                        System.out.println(carReg.registerNewCar(price, yearModuel, fuel, gear, hoursepow).toString());
                    }

                    case FINN_ETTER_MCF -> {
                        String findYMR = showInputDialog("Skriv inn årsmodellen du leter etter");
                        int findYM = Integer.parseInt(findYMR);
                        String findColor = showInputDialog("skriv inn fargen på bilen du leter etter");
                        String findFuel = showInputDialog("Skriv inn drivstofftypen du ønsker å se etter");

                        System.out.println(carReg.findMCF(findYM, findColor, findFuel).toString());
                    }

                    case FINN_ETTER_PRIS -> {
                        String findPriceRead = showInputDialog("Skriv inn prisen du ønsker å lete etter");
                        int findPrice = Integer.parseInt(findPriceRead);

                        System.out.println(carReg.findP(findPrice));
                    }

                    case SLETT_BIL -> {
                        String deletNum = showInputDialog("skriv inn registreringsnummeret til bilen som skal slettes");
                        carReg.deleteSoldCar(deletNum);
                    }

                    case FINN_BIL_YEAR -> {
                        String findYearRead = showInputDialog("Skriv inn årsmodulen du ønsker å lete etter");
                        int findYear = Integer.parseInt(findYearRead);

                        System.out.println(carReg.cByYearModuel(findYear).toString());
                    }

                    case REGISTRER_NUMMER -> {
                        String carCoiceRead = showInputDialog("""
                                Skriv inn nummeret til bilen du ønsker å legge registerringsnummer til
                                Pass på at du velger riktig bil                          
                                """);
                        int carChoice = Integer.parseInt(carCoiceRead);
                        String newRegisterNum = showInputDialog("""
                                Skriv inn registerringnummeret til bilen.
                                "Husk at et bilskilt har formatet AAXXXXX
                                """);
                        carReg.registerANumber(carChoice, newRegisterNum);
                    }

                    case ENDRE_VERDIER -> {
                        String[] change = {"Endre registreringsnummer", "Endre Prisen", "Endre farge", "Endre Merket"};
                        final int SET_REG_NUM = 0;
                        final int SET_NEW_PRICE = 1;
                        final int SET_NEW_COLOR = 2;
                        final int SET_NEW_TYPE = 3;

                        int changeChoice = showOptionDialog(null, "***** Nilsens Automobil (Kirkenes) Car Register Application *****" + "\nVelg funksjon",
                                "Eksamen des 2020", YES_NO_OPTION, INFORMATION_MESSAGE, null, change, change[0]);

                        switch (changeChoice) {
                            case SET_REG_NUM -> {
                                String newRegNum = showInputDialog("skriv inn det nye Registreringnummeret");
                                String oldRegNum = showInputDialog("Skriv inn det registreringnummeret du skal endre");

                                carReg.setRegisternum(newRegNum, oldRegNum);
                            }

                            case SET_NEW_PRICE -> {
                                String oldRegNum = showInputDialog("Skriv inn det registreringnummeret du skal endre");
                                String newPriceRead = showInputDialog("Skriv inn den nye prisen");
                                int newPrice = Integer.parseInt(newPriceRead);

                                carReg.setPrice(newPrice, oldRegNum);
                            }

                            case SET_NEW_COLOR -> {
                                String oldRegNum = showInputDialog("Skriv inn det registreringnummeret du skal endre");
                                String newColor = showInputDialog("skriv inn den nye fargen på bilen");

                                carReg.setColor(newColor, oldRegNum);
                            }

                            case SET_NEW_TYPE -> {
                                String oldRegNum = showInputDialog("Skriv inn det registreringnummeret du skal endre");
                                String newType = showInputDialog("skriv inn det nye merket på bilen");

                                carReg.setType(newType, oldRegNum);
                            }
                        }

                    }

                    case AVSLUTT -> {
                        System.out.println("Thank you for using car register application!");
                        finished = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
