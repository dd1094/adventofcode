import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jour3 {

    static ArrayList <String> listN = new ArrayList<String>();

    public static int etapeUn(ArrayList<String> liste){
        String consumption = "";
        String submarine ="";
        int nbBoucle = 0;
        int indBit = 0;
        char char0 = '0';

        for (nbBoucle = 0; nbBoucle < 12; nbBoucle++) {

            int nbDeZero = 0;
            int nbDeUn = 0;
            
            for (int i = 0; i < liste.size(); i++) {
                if (Character.compare(liste.get(i).charAt(indBit),char0)==0){
                    nbDeZero++;
                }
                else{
                    nbDeUn++;
                }
                
            }
            if (nbDeZero <= nbDeUn){
                consumption = consumption + "1";
                submarine = submarine + "0";
            }
            else if (nbDeZero > nbDeUn){
                consumption = consumption + "0";
                submarine = submarine + "1";
            }
            
            indBit++;

    }
    Integer.parseInt(consumption,2); 
    int decimal1 = Integer.parseInt(submarine,2); 
    int decimal2 = Integer.parseInt(consumption,2);

    int resultat = decimal1 * decimal2;
    return resultat;
}
    

    /*public static String etapeDeux(ArrayList<String> listeO){
        int nbBoucle = 0;
        int nbBoucle1 = 0;
        int indBit = 0;
        char char0 = '0';
        ArrayList<String> liste = listeO;
        ArrayList<String> liste2 = listeO;
        int tailleListe = liste.size();
        int nbDeZero = 0;
        int nbDeUn = 0;
        for (int i = 0; tailleListe > 1; i++) {
            for (nbBoucle1 = 0; nbBoucle1 < tailleListe; nbBoucle1++) {
            if (Character.compare(liste.get(i).charAt(indBit),char0)==0){
                    nbDeZero++;
                }
                else{
                    nbDeUn++;
                }}
                
                
            if (nbDeZero <= nbDeUn){
                for (nbBoucle = 0; nbBoucle<liste.size(); nbBoucle++) {
                    if (Character.compare(liste.get(nbBoucle).charAt(indBit),char0)==0){
                        liste.remove(nbBoucle);
                    }
                }
            }
            else if (nbDeZero > nbDeUn){
                for (nbBoucle = 0; nbBoucle<liste.size(); nbBoucle++) {
                    if (Character.compare(liste.get(nbBoucle).charAt(indBit),char0)!=0){
                        liste.remove(nbBoucle);
                    }
                }
         }
        indBit++;
        tailleListe = liste.size();*/
       

    

    
        

    
    /*if (Character.compare(liste.get(2).charAt(indBit),char0)==0){
        liste.remove(2);
    }
    //int decimal1 = Integer.parseInt(liste.get(0)); 
    
    System.out.println(liste);
    System.out.println(liste2);
    System.out.println(listeO);
    return "a";}*/


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("../Jeu de caractère/nombreJour3.txt"));
    

    while (s.hasNext()){
        listN.add(s.next());
    }

    System.out.println(etapeUn(listN));
    //System.out.println(etapeDeux(listN));
}}

