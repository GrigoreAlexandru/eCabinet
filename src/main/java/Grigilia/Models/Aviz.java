package Grigilia.Models;

import java.util.Objects;

public class Aviz {
    private String numeDoctor, numePacient, tip;
    private int cnp;

    public Aviz(String numeDoctor, String numePacient, String tip, int cnp) {
        this.numeDoctor = numeDoctor;
        this.numePacient = numePacient;
        this.tip = tip;
        this.cnp = cnp;
    }

    public String getNumeDoctor() {
        return numeDoctor;
    }

    public String getNumePacient() {
        return numePacient;
    }

    public String getTip() {
        return tip;
    }

    public int getCnp() {
        return cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aviz aviz = (Aviz) o;
        return cnp == aviz.cnp &&
                Objects.equals(numeDoctor, aviz.numeDoctor) &&
                Objects.equals(numePacient, aviz.numePacient) &&
                Objects.equals(tip, aviz.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeDoctor, numePacient, tip, cnp);
    }

    @Override
    public String toString() {
        return tip + " - \n " + numeDoctor + " \n " + numePacient + " - \n" + cnp;
    }
}
