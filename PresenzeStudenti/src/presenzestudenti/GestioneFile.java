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
    
    public void leggiFile() throws FileNotFoundException, IOException, ParseException{
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] colonne = line.split(",");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date data = sdf.parse(colonne[0]);
                Studente s = new Studente(colonne[2],Integer.parseInt(colonne[1]),data,colonne[3]);
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
        System.out.println("Gli studenti sempre presenti sono:");
        for(int i = 0; i < semprePres.size(); i++){
            System.out.println(semprePres.get(i));
        }
    }
    
    public void presenzeDaA() throws FileNotFoundException, IOException, ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date inizio = sdf.parse("2026-01-14");
        Date fine   = sdf.parse("2026-01-16");
        System.out.println("I presenti dal 2026-01-14 al 2026-01-16 sono:");
        for(int i = 0; i < presenze.size();i++){
            if(presenze.get(i).getStato() == Stato.PRESENTE && !presenze.get(i).getData().before(inizio) && !presenze.get(i).getData().after(fine)){
                System.out.println(presenze.get(i).getNome());
            }
        }
    }
}
