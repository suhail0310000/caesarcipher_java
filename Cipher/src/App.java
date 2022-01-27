import javax.swing.*;
import java.io.File;

public class App {
    public static void main(String[] args){
        String filNavn = JOptionPane.showInputDialog("Skriv inn navn på fil du ønsker å kryptere/dekryptere: ");
        filNavn += ".txt";
        //chckAllFields(filNavn.getAbsolutePath());
        int innKey = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn verdien på nøkkelen du ønsker:"));
        int method = Integer.parseInt(JOptionPane.showInputDialog("Ønsker du å kryptere eller dekryptere:\n1: Kryptere\n2: Dekryptere\n\nSkriv inn 1 eller 2"));
        try{
            printOut(filNavn,innKey,method);
        }
        catch (Exception e){
            JOptionPane.showInputDialog("Vennligst skriv inn gyldig input");
        }
    }

    public static void printOut(String filNavn, int innKey, int method){
        ReadFile red = new ReadFile();
        String data = red.handleFileUpload(filNavn);
        CaesarCipher cipher = new CaesarCipher();
        String ut = "Du har valgt følgende:\n";
        ut+="Filnavn: "+filNavn+"\n";
        ut+="Nøkkel: "+innKey+"\n";
        ut+="Metode: "+method+"\n\n";


        String encryptedTxt = cipher.encrypt(data,innKey);
        String decryptedTxt = cipher.decrypt(data,innKey);
        if(method == 1){
            System.out.println("Krypererfil .........");
            ut+="Filinnhold: "+data+"\n";
            ut+="Kryptert: "+ encryptedTxt;
            JOptionPane.showMessageDialog(null,ut);
            System.out.println("Skriver ut i terminal: ");
            System.out.print(ut);
        }else if(method == 2){
            System.out.println("Dekrypterer ....... ..");
            ut+="Filinnhold: "+filNavn;
            ut+="Dekryptert: "+ decryptedTxt;
            JOptionPane.showMessageDialog(null,ut);
            System.out.print(ut);
        }
    }


}
