/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzestudenti;

import java.util.Date;

/**
 *
 * @author paolucci.sara
 */
public class Studente {
    private String nome;
    private int matricola;
    private String data;
    private Stato stato;
    
    public Studente(String n, int m, String d, String s){
        this.nome = n;
        this.matricola = m;
        this.data = d;
        this.stato = Stato.valueOf(s.toUpperCase());
    }
    
    public Studente(){
        
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getMatricola(){
        return this.matricola;
    }
    
    public Stato getStato(){
        return this.stato;
    }
    
    public String getData(){
        return this.data;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public void setMatricola(int m){
        this.matricola = m;
    }
    
    public void setStato(Stato s){
        this.stato = s;
    }
    
    public void setData(String d){
        this.data =d;
    }
    
    public String ToString(){
        return "Nome: " + nome + " Matricola: " + matricola + " Data: " + data + " Stato: " + stato;
    }
}
