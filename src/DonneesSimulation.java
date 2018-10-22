import java.util.Map;

public class DonneesSimulation {

    private Carte carte;
    private Map<Case, Incendie> incendies;
    private Robot[] robots;


    public Carte getCarte() {
        return carte;
    }

    public Map<Case, Incendie> getIncendies() {
        return incendies;
    }

    public Robot[] getRobots() {
        return robots;
    }
}
