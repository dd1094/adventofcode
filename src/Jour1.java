import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Jour1 {
    
    static ArrayList <Integer> listeTexte = new ArrayList<Integer>();

     public static int etapeUn(ArrayList<Integer> liste){

        int nbaugmentation = 0;
        
        for (int i = 1; i < liste.size(); i++) {
            if(liste.get(i) > liste.get(i-1)){
            nbaugmentation = nbaugmentation+1;
            }
        }
        return nbaugmentation;
    }

    public static int etapeDeux(ArrayList<Integer> liste){
        int addition;
        ArrayList <Integer> listeAddition = new ArrayList<>() ;

        for (int i = 2; i < liste.size(); i++) {
            addition = liste.get(i)+liste.get(i-1)+liste.get(i-2);
            listeAddition.add(addition);
        }

        return etapeUn(listeAddition);

    }                        
	
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("../Jeu de caractère/nombreJour1.txt"));
        
        while (s.hasNextInt()){
            listeTexte.add(s.nextInt());
        }

        System.out.println(etapeUn(listeTexte));
        System.out.println(etapeDeux(listeTexte));
    }
}
