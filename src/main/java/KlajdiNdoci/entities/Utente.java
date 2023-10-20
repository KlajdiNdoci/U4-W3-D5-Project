package KlajdiNdoci.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Utente {
    private String nome;
    private String cognome;
    private LocalDate DataDiNascita;
    @Id
    @GeneratedValue
    private long NumeroDiTessera;
    @ManyToMany
    @JoinTable(name = "prestito_utente",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id"))
    private Set<Prestito> prestiti;

    public Utente(String nome, String cognome, LocalDate dataDiNascita, long numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        DataDiNascita = dataDiNascita;
        NumeroDiTessera = numeroDiTessera;
    }

    public Utente() {
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", DataDiNascita=" + DataDiNascita +
                ", NumeroDiTessera=" + NumeroDiTessera +
                '}';
    }
}
