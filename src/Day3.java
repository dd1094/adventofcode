import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    static ArrayList<String> listN = new ArrayList<String>();

    public static int etapeUn(ArrayList<String> liste) {
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        int bitPosition = 0;
        int indBit = 0;
        char char0 = '0';

        for (bitPosition = 0; bitPosition < 12; bitPosition++) {

            int nbDeZero = 0;
            int nbDeUn = 0;

            for (int i = 0; i < liste.size(); i++) {
                if (Character.compare(liste.get(i).charAt(indBit), char0) == 0) {
                    nbDeZero++;
                } else {
                    nbDeUn++;
                }

            }
            if (nbDeZero <= nbDeUn) {
                gammaRate.append("1");
                epsilonRate.append("0");
            } else {
                gammaRate.append("0");
                epsilonRate.append("1");
            }

            indBit++;

        }
        int epsilonInt = Integer.parseInt(epsilonRate.toString(), 2);
        int gammaInt = Integer.parseInt(gammaRate.toString(), 2);

        return epsilonInt * gammaInt;
    }

    public static String partTwo(ArrayList<String> list) {

        ArrayList<String> oxygenList = list;

        ArrayList<String> c02List = list;

        for (int bitPosition = 0; oxygenList.size() > 1; bitPosition++) {

            int zeroCount = 0;
            int oneCount = 0;
            ArrayList<String> oxygenListBis = new ArrayList<String>();

            for (int indexList = 0; indexList < oxygenList.size(); indexList++) {
                String slice = oxygenList.get(indexList).substring(bitPosition, bitPosition + 1);
                if (slice.equals("1")) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            if (oneCount >= zeroCount) {

                for (int indexList = 0; indexList < oxygenList.size(); indexList++) {
                    String slice = oxygenList.get(indexList).substring(bitPosition, bitPosition + 1);
                    if (slice.equals("1")) {
                        oxygenListBis.add(oxygenList.get(indexList));
                    }
                }
            } else {
                for (int indexList = 0; indexList < oxygenList.size(); indexList++) {
                    String slice = oxygenList.get(indexList).substring(bitPosition, bitPosition + 1);
                    if (slice.equals("0")) {
                        oxygenListBis.add(oxygenList.get(indexList));
                    }
                }
            }

            oxygenList = oxygenListBis;
            oxygenListBis = new ArrayList<String>();
        }

        for (int bitPosition = 0; c02List.size() > 1; bitPosition++) {

            int zeroCount = 0;
            int oneCount = 0;
            ArrayList<String> c02ListBis = new ArrayList<String>();

            for (int indexList = 0; indexList < c02List.size(); indexList++) {
                String slice = c02List.get(indexList).substring(bitPosition, bitPosition + 1);
                if (slice.equals("1")) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            if (oneCount < zeroCount) {

                for (int indexList = 0; indexList < c02List.size(); indexList++) {
                    String slice = c02List.get(indexList).substring(bitPosition, bitPosition + 1);
                    if (slice.equals("1")) {
                        c02ListBis.add(c02List.get(indexList));
                    }
                }
            } else {
                for (int indexList = 0; indexList < c02List.size(); indexList++) {
                    String slice = c02List.get(indexList).substring(bitPosition, bitPosition + 1);
                    if (slice.equals("0")) {
                        c02ListBis.add(c02List.get(indexList));
                    }
                }
            }
            c02List = c02ListBis;
            c02ListBis = new ArrayList<String>();

        }
        int CO2ScrubberRating = Integer.parseInt(c02List.get(0), 2);
        int oxygenGeneratorRating = Integer.parseInt(oxygenList.get(0), 2);
        return "CO2ScrubberRating = " + CO2ScrubberRating + "\noxygenGeneratorRating =  " + oxygenGeneratorRating
                + "\nresult = " + CO2ScrubberRating * oxygenGeneratorRating;
    }

    public static void main(String[] args) throws IOException {
        try (final Scanner s = new Scanner(new File("./Jeu de caractère/nombreJour3.txt"))) {
            while (s.hasNext()) {
                listN.add(s.next());
            }

        }

        System.out.println(etapeUn(listN));
        System.out.println(partTwo(listN));
    }
}
