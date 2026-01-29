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
    private Date data;
    private Stato stato;
    
    public Studente(String n, int m, Date d, Stato s){
        this.nome = n;
        this.matricola = m;
        this.data = d;
        this.stato = s;
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
    
    public Date getData(){
        return this.data;
    }
}
