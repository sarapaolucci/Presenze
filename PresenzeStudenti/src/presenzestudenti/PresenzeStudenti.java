/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presenzestudenti;

import java.io.IOException;

/**
 *
 * @author paolucci.sara
 */
public class PresenzeStudenti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GestioneFile g = new GestioneFile("0_PresenzeStudenti.csv");
        g.leggiFile();
        g.stampaStudentiSemprePresenti();
    }
    
}
