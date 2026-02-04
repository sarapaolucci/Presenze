/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presenzestudenti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author paolucci.sara
 */
public class PresenzeStudenti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException{
        Gestore gestore = new Gestore("0_PresenzeStudenti.csv");
        gestore.leggiFile();
        gestore.calcolaAssenze();
        gestore.stampaStudentiSemprePresenti();
        gestore.presenzeDaA();
    }
    
}
