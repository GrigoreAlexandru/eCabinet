package Grigilia;

public class Programare {
    private String tip, pacient;

    public Programare(String tip, String pacient) {
        this.tip = tip;
        this.pacient = pacient;
    }

    public String getTip() {
        return tip;
    }

    public String getPacient() {
        return pacient;
    }

    @Override
    public String toString() {
        return pacient + " - " + tip;
    }
}
