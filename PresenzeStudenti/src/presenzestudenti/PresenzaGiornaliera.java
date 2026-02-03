/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzestudenti;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paolucci.sara
 */
public class PresenzaGiornaliera {
    private String nome;
    private int matricola;
    private Date data;
    private Stato stato;
    
    public PresenzaGiornaliera(String n, int m, Date d, String s){
        this.nome = n;
        this.matricola = m;
        this.data = d;
        this.stato = Stato.valueOf(s.toUpperCase());
    }
    
    public PresenzaGiornaliera(){
        
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
    
    public String getDataString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(data);
    }
    
    public Date getData(){
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
    
    public void setData(Date d){
        this.data =d;
    }
    
    public String ToString(){
        return "Nome: " + nome + " Matricola: " + matricola + " Data: " + getDataString() + " Stato: " + stato;
    }
}
