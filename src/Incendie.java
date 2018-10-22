public class Incendie {

    private Case position;
    private int eauNecessaire;

    public Incendie(Case position, int eauNecessaire) {
        this.position = position;
        this.eauNecessaire = eauNecessaire;
    }

    public Case getPosition() {
        return position;
    }

    public int getEauNecessaire() {
        return eauNecessaire;
    }

    public void setEauNecessaire(int eauNecessaire) {
        this.eauNecessaire = eauNecessaire;
    }
}
