/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzestudenti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author paolucci.sara
 */
public class FileManager {
    private String csvFile;
    
    
    public FileManager(String csv){
        this.csvFile = csv;
    }
    
    public void leggiFile(ArrayList<PresenzaGiornaliera> presenze) throws FileNotFoundException, IOException, ParseException{
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] colonne = line.split(",");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date data = sdf.parse(colonne[0]);
                PresenzaGiornaliera s = new PresenzaGiornaliera(colonne[2],Integer.parseInt(colonne[1]),data,colonne[3]);
                presenze.add(s);
                
            }
        }
    }
    
    
}
