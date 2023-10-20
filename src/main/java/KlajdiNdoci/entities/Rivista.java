package KlajdiNdoci.entities;

import KlajdiNdoci.enums.Periodicitá;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Random;

@Entity
@DiscriminatorValue("Rivista")
public class Rivista extends Catalogo {

    @Enumerated(EnumType.STRING)
    private Periodicitá periodicitá;

    public Rivista(String titolo, Periodicitá periodicitá) {
        super(titolo);
        Random random = new Random();
        this.periodicitá = periodicitá;
        this.numeroPagine = random.nextInt(20, 100);
    }

    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicitá periodicitá) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        Random random = new Random();
        this.periodicitá = periodicitá;
        this.numeroPagine = random.nextInt(20, 100);
    }


    public Rivista() {
    }

    public Periodicitá getPeriodicitá() {
        return periodicitá;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicitá=" + periodicitá +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

}
