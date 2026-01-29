/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzestudenti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author paolucci.sara
 */
public class GestioneFile {
    private String csvFile;
    private ArrayList<Studente> presenze;
    
    public GestioneFile(String csv){
        this.csvFile = csv;
        this.presenze = new ArrayList();
    }
    
    public void addStudente(Studente s){
        if(s != null){
            presenze.add(s);
        }
    }
    
    public void leggiFile() throws FileNotFoundException, IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
            String line;
            reader.readLine();
        }
    }
}
