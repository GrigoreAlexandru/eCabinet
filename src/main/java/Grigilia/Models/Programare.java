package Grigilia.Models;

import java.util.Objects;

public class Programare {
    private String tip, pacient;
    private int cost;

    public Programare(String tip, String pacient, int cost) {
        this.tip = tip;
        this.pacient = pacient;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getTip() {
        return tip;
    }

    public String getPacient() {
        return pacient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programare that = (Programare) o;
        return cost == that.cost &&
                Objects.equals(tip, that.tip) &&
                Objects.equals(pacient, that.pacient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tip, pacient, cost);
    }

    @Override
    public String toString() {
        return pacient + " - " + tip+" - "+cost+" lei";
    }
}
