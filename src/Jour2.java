import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jour2 {
    static ArrayList <String> listeTexte = new ArrayList<String>();

    public static int etapeUn(ArrayList<String> liste){

        int horizontal = 0;
        int profondeur = 0;
        int multiplication;
        
        for (int i = 0; i < liste.size(); i = i+2) {
            if(liste.get(i).equals("forward")){
                horizontal = horizontal + Integer.parseInt(liste.get(i+1));
            }
            else if(liste.get(i).equals("up")){
                profondeur = profondeur - Integer.parseInt(liste.get(i+1));
            }
            else if(liste.get(i).equals("down")){
                profondeur = profondeur + Integer.parseInt(liste.get(i+1));
            }
        }

        multiplication = horizontal * profondeur;

        return multiplication;
    }

    public static int etapeDeux(ArrayList<String> liste){

        int horizontal = 0;
        int profondeur = 0;
        int visee = 0;
        int multiplication;
        
        for (int i = 0; i < liste.size(); i = i+2) {
            if(liste.get(i).equals("forward")){
                horizontal = horizontal + Integer.parseInt(liste.get(i+1));
                profondeur = profondeur + visee * Integer.parseInt(liste.get(i+1));;
            }
            else if(liste.get(i).equals("up")){
                visee = visee - Integer.parseInt(liste.get(i+1));
            }
            else if(liste.get(i).equals("down")){
                visee = visee + Integer.parseInt(liste.get(i+1));
            }
        }

        multiplication = horizontal * profondeur;


        return multiplication;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("../Jeu de caractère/nombreJour1.txt"));
        
        while (s.hasNext()){
            listeTexte.add(s.next());
        }

        System.out.println(etapeUn(listeTexte));
        System.out.println(etapeDeux(listeTexte));
    }
}