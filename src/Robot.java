import java.util.Map;

public abstract class Robot {

    private Case position;
    private Map<NatureTerrains, Integer> vitesses;
    private int capacite;

    public Robot(Case position, Map<NatureTerrains, Integer> vitesses, int capacite) {
        this.position = position;
        this.vitesses = vitesses;
        this.capacite = capacite;
    }

    public Case getPosition() {
        return position;
    }

    public Map<NatureTerrains, Integer> getVitesses() {
        return vitesses;
    }

    public int getVitesse(NatureTerrains terrain)    {
        return vitesses.get(terrain);
    }

    public int getCapacite() {
        return capacite;
    }
}
