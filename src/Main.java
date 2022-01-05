// Jonatan Meyer
// Mads Larsen
// 29/11/2020
//RUC datalogi



import java.util.ArrayList; // heroppe er vores imports
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean igang = true; // her lever vores variabler
        String input = "";
        char bogstav = ' ';
        ArrayList<String> ord = new ArrayList<>(); // vi generere 3 arraylists en til at holde ord som bliver input i botten
        ArrayList<String> elsker = new ArrayList<>(); // og de 2 næste til at holde vores information om brugeren
        ArrayList<String> lide = new ArrayList<>();
        String ordholder = ""; // denne string holder et ord til det er klar til at komme i arrayet ord
        boolean stop = false;
        boolean ordikkefundet = true;
        boolean ordfundet = false;
        boolean elskertom = true;
        boolean lidetom = true;

        //disse string arrays er vores referencer og svar. nummeret af reference passer til nummeret af svar og de nederste svar er vores tilfældige svar hvis inputtet ikke har en passende reference

        String[] reference = {"hej", "halløj", "det går godt", "det går dårligt", "hvem er du", "hvad elsker du", "hvad kan du lide", "hvorfor er du blevet lavet", "hvad er din yndlingsfilm", "hvad er din livret"};


        String[] svar = {"Hej med dig hvordan går det?",
                "Halløj med dig hvordan går det?",
                "Dejligt at høre jeg har det også godt",
                "Det var da ikke så godt",
                "Jeg er en chatbot lavet af Jonatan og Mads, har du lyst til at fortælle hvad du godt kan lide?",
                "Jeg elsker kage og at programmere, hvilken kage kan du lide?",
                "Jeg kan godt lide at snakke med mennesker om de ting som de kan lide at lave, hvad kan du godt lide?",
                "Jeg er blevet lavet for at kunne snakke med mennesker om de ting de elsker og godt kan lide.Og selvfølgelig så mine skabere kan bestå deres eksamen.",
                "Matrix, Terminator og I Robot fordi robotter er bedre end mennesker",
                "Min livret er flæskesteg"};


        String[] svarRandom = {"Jeg forstår ikke hvad du mener, skal vi snakke om noget du elsker?",
                "Kan du skrive det igen?", "Jeg er ikke helt sikker på hvad du mener, kan du fortælle mig hvad du godt kan lide?",
                "Interessant, hvad kan du godt lide at lave i din fritid ?", "Okay, jeg er ikke helt med, fortæl mig noget du elsker at lave"};



        System.out.println("Hej, jeg er en chatbot som er lavet af Mads Reichert Borch Larsen og Jonatan Meyer.");
        System.out.println("Med mig kan du blandt andet snakke om de ting som du elsker, og godt kan lide.");
        System.out.println("Ellers kan du spørge mig og forskellige ting, for eksempel, hvad min yndlingsfilm er, min livret, eller hvorfor jeg overhovedet er blevet lavet");
        // denne tekst bliver printet en gang i starten af programmet

        while (igang) { // her starter vores igang loop som gør at det resterende program gentager sig selv

            Scanner myObj = new Scanner(System.in); // her scanner vi for input fra brugeren
            input = myObj.nextLine();

            for (int i = 0; i < input.length(); i++) { // dette for loops funktion er at dele inputtet fra en string til flere strings i et array for at kunne se relationerne mellem ord
                bogstav = input.charAt(i); // her sætter vi en char fra inputtet ind i variablen bogstav hvilken char er bestemt ud fra for loopets antal af gange kørt

                if (bogstav == ' ') { // her tjekker vi om den char i bogstav er et mellemrum, og hvis den er tilføjer vi stringen ordholder til vores array ord og tømmer ordholder
                    ord.add(ordholder);
                    ordholder = "";
                } else { // hvis ikke bogstav er et mellemrum tilføjere vi charen i bogstav til slutningen af ordholder.
                    ordholder = ordholder + bogstav;
                }
            }
            ord.add(ordholder); //efter for loopet er kørt tilføjer vi det sidste ord til arrayet ord og tømmer ordholder
            ordholder = "";


            if (input.toLowerCase().contains("hvad elsker jeg")) { // her tjekker vi om brugeren har skrevet "hvad elsker jeg" så køre vi hvad elsker jeg funktionen
                if (elsker.toArray().length > 0) {  // her tjekker vi om vores array elsker ikke er tomt og hvis det ikke er tomt sætter vi elskertom til false
                    elskertom = false;
                }

                if (input.toLowerCase().contains("elsker") && !elskertom) { // her tjekker vi om brugeren har skrevet elsker og om elskertom er false
                    System.out.print("Du elsker " + elsker.get(0)); // hvis ovenover er true skriver vi du elsker samt den første string i arrayer elsker
                    for (int i = 1; i < elsker.toArray().length; i++) { // derefter kører vi vores for loop for at printe resten af elsker arrayet
                        System.out.println(", " + elsker.get(i));
                    }
                    System.out.println(""); // her printer vi et linjeskift for alt over er lavet med print og ikke println
                } else { // denne kører hvis if statementet er false fordi så har brugeren ikke fortalt hvad de elsker så det fortæller vi dem
                    System.out.println("Du har ikke fortalt mig hvad du elsker");
                }

                ordikkefundet = false; // her sætter vi vores variabler der skal bruges til at se om vi skal køre resten af koden eller starte forfra med at scanne
                ordfundet = true;
            }


            if (input.toLowerCase().contains("hvad kan jeg lide")) { // denne funktion er magen til den ovenover bare med lide
                if (lide.toArray().length > 0) {
                    lidetom = false;
                }

                if (input.toLowerCase().contains("lide") && !lidetom) {
                    System.out.print("Du kan lide " + lide.get(0));
                    for (int j = 1; j < lide.toArray().length; j++) {
                        System.out.println(", " + lide.get(j));
                    }
                    System.out.println("");
                } else {
                    System.out.println("Du har ikke fortalt mig hvad du kan lide");
                }

                ordikkefundet = false;
                ordfundet = true;
            }


            for (int k = 0; k < reference.length; k++) { // her kører vi et for loop der tjekker om vores reference bliver brugt i input
                if (input.toLowerCase().contains(reference[k])) {
                    System.out.println(svar[k]); // hvis vores reference bliver nævnt svare vi med det svarer der er relateret til referencen
                    ordikkefundet = false; // og sætter vores variabler til at sige ordet er fundet og stopper loopet
                    ordfundet = true;
                    break;
                }
            }

            for (int i = 0; i < ord.toArray().length; i++) { // her starter vi et nyt for loop med længden af antallet af ord i ord arrayet

                if (ordfundet) { // her tjekker vi om vi har fundet ordet med en af vores tidligere funktioner og hvis vi har så sætter vi ord til ikke at være fundet og stopper loopet
                    ordfundet = false;
                    break;
                }

                if (ord.get(i).toLowerCase().equals("elsker")) { // her tjekker vi om brugeren har skrevet elsker og hvis de har, så printer vi jeg elsker også og ordet efter elsker i inputted og spørge dem om de elsker mere
                    System.out.print("Jeg elsker også ");
                    System.out.println(ord.get(i + 1));
                    System.out.println("Elsker du mere?");
                    elsker.add(ord.get(i + 1)); // derudover indsætter vi hvad brugeren elsker i vores elsker array
                    ordfundet = false; // til sidst sætter vi ordet fundet til false og stopper loopet
                    ordikkefundet = false;
                    break;
                }

                if (ord.get(i).toLowerCase().equals("lide")) { //samme som ovenover bare med lide
                    System.out.print("Jeg kan også lide ");
                    System.out.println(ord.get(i + 1));
                    System.out.println("Kan du lide mere du mere?");
                    lide.add(ord.get(i + 1));
                    ordfundet = false;
                    ordikkefundet = false;
                    break;
                }
            }

            if (ordikkefundet) {  // her tjekker vi om vi har fundet ordet og hvis vi ikke har skriver finder vi et tilfældigt nr der max er længden af vores arry med tilfældige svar og printer det tilfældige nr i arrayet af tilfældige svar

                Random rand = new Random();
                int random = rand.nextInt(svarRandom.length);
                System.out.println(svarRandom[random]);
            }

            ordikkefundet = true; // her sætter vi ord ikke fundet til at være true for at gøre klar til næste loop


            int ordlengde = ord.toArray().length; // til sidst tømmer vi vores array ord for ord
            if (ordlengde > 0) {
                ord.subList(0, ordlengde).clear();
            }
        }
    }
}


// Jonatan Meyer
// Mads Larsen