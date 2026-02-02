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
    private ArrayList <Studente> presenze;
    
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
            while((line = reader.readLine()) != null){
                String[] colonne = line.split(",");
                Studente s = new Studente(colonne[2],Integer.parseInt(colonne[1]),colonne[0],colonne[3]);
                presenze.add(s);
            }
        }
    }
    
    public int calcolaAssenze(Studente s){
        int count = 0;
        for(int i = 0; i < presenze.size();i++){
            if(presenze.get(i).getStato()== Stato.ASSENTE){
                count++;
            }
        }
        return count;
    }
    
    public void stampaStudentiSemprePresenti(){
        ArrayList<String> semprePres = new ArrayList();
        ArrayList<String> sempreAss = new ArrayList();
        for(int i = 0; i < presenze.size();i++){
            if(presenze.get(i).getStato()== Stato.ASSENTE){
               sempreAss.add(presenze.get(i).getNome());
               semprePres.remove(presenze.get(i).getNome());
            }
            else if(presenze.get(i).getStato()== Stato.PRESENTE && sempreAss.contains(presenze.get(i).getNome()) == false){
                semprePres.add(presenze.get(i).getNome());
            }
        }
        for(int i = 0; i < semprePres.size(); i++){
            System.out.println(semprePres.get(i));
        }
    }
     
}
