package KlajdiNdoci.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utenti")
public class Utente {

    @Id
    @GeneratedValue
    private long NumeroDiTessera;
    private String nome;
    private String cognome;
    private LocalDate DataDiNascita;
    @GeneratedValue

    @ManyToMany
    @JoinTable(name = "prestito_utente",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "prestito_id"))
    private Set<Prestito> prestiti = new HashSet<>();

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        DataDiNascita = dataDiNascita;
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
