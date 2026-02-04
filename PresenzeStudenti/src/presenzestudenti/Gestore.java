/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzestudenti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author paolucci.sara
 */
public class Gestore {
    private ArrayList <PresenzaGiornaliera> presenze;
    private FileManager f;
    
    public Gestore(String csvFile){
        this.presenze = new ArrayList();
        this.f = new FileManager(csvFile);
    }
    
    public void leggiFile() throws IOException, FileNotFoundException, ParseException{
        f.leggiFile(presenze);
    }
    
    public void calcolaAssenze(){
        int count = 0;
        ArrayList<String>conta = new ArrayList();
        for(int i = 0; i < presenze.size();i++){
            String nome = presenze.get(i).getNome();
            for(int j = 0; j < presenze.size();j++){
                if(presenze.get(j).getNome().equals(nome)== true && presenze.get(j).getStato() == Stato.ASSENTE){
                count++;
                }   
            }
            if(!conta.contains(nome)){
                System.out.println("Lo studente "+ nome + " ha fatto "+ count + " assenze");
            }
            conta.add(nome);
            count = 0;
        }
        
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
        ArrayList<String>conta = new ArrayList();
        int count = 0;
        System.out.println("Presenze dal 2026-01-14 al 2026-01-16 sono:");
        for(int i = 0; i < presenze.size();i++){
            if(!presenze.get(i).getData().before(inizio) && !presenze.get(i).getData().after(fine)){
                String nome = presenze.get(i).getNome();
                for(int j = 0; j < presenze.size();j++){
                   if(presenze.get(j).getNome().equals(nome)== true && presenze.get(j).getStato() == Stato.PRESENTE){
                   count++;
                   }   
                }
                if(!conta.contains(nome)){
                   System.out.println("Lo studente "+ nome + " ha fatto "+ count + " presenze");
                }
                conta.add(nome);
                count = 0;
            }
        }
    }
}
