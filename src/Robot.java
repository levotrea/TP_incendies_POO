import java.util.Map;

import static java.lang.Math.max;


public abstract class Robot {

    private Case position;
    private Map<NatureTerrains, Double> vitesses;
    private int capacite;
    private int contenuReservoir;

    /**
     * Initialisation d'un robot.
     * @param position
     * @param vitesses
     * @param capacite
     */
    public Robot(Case position, Map<NatureTerrains, Double> vitesses, int capacite, int contenuReservoir) {
        this.position = position;
        this.vitesses = vitesses;
        this.capacite = capacite;
        this.contenuReservoir = contenuReservoir;
    }

    /**
     * Renvoie la position d'un robot
     * @return Case
     */
    public Case getPosition() {
        return position;
    }

    /**
     * Renvoie la table de hachage des vitesses du robot suivant le type de terrain.
     * @return Map
     */
    public Map<NatureTerrains, Double> getVitesses() {
        return vitesses;
    }

    /**
     * Renvoie la vitesse correspondant au type de terrain pour le type de robot en question.
     * @param nature
     * @return double : vitesse
     */
    public double getVitesse(NatureTerrains nature)    {
        return vitesses.get(nature);
    }

    /**
     * Revoie la capacité du robot en question.
     * @return int : capacité
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Renvoie le contenu en litres d'eau du reservoir à l'instant courant.
     * @return int : contenu du reservoir
     */
    public int getContenuReservoir() {
        return contenuReservoir;
    }

    /**
     * Place le robot à une position donnée.
     * @param position
     */
    public void setPosition(Case position) {
        // Très basique, devra prendre en compte la vitesse (donc le temps de trajet) plus tard
        this.position = position;
    }

    /**
     * Fixe le contenu du reservoir d'eau du robot à la valeur donnée en paramètre.
     * @param contenuReservoir
     */
    public void setContenuReservoir(int contenuReservoir) {
        this.contenuReservoir = contenuReservoir;
    }

    /**
     * Deverse de l'eau sur une case en feu (ou affiche un message si la case n'est pas en feu)
     * @param vol : volume d'eau à deverser
     * @param donneesSimulation
     */
    public void deverserEau(int vol, DonneesSimulation donneesSimulation)   {

        if (this.position.isEnFeu())    {
            Incendie incendieCourant = donneesSimulation.getIncendies().get(this.position);

            int eauNecessaireApres = max(0, incendieCourant.getEauNecessaire() - vol);
            incendieCourant.setEauNecessaire(eauNecessaireApres);

            if (eauNecessaireApres == 0)    {

                // Si l'incendie a été éteint, on marque la case comme n'étant plus en feu.
                this.position.setEnFeu(false);
            }

        }

        else    {
            System.out.println("La case n'était pas en feu, on a déversé de l'eau pour rien !");
        }

        this.contenuReservoir = this.contenuReservoir - vol;
    }

    /**
     * Remplit le reservoir d'eau du robot, en le plaçant sur la case de la reserve d'eau s'il n'y était pas déjà.
     * @param carte
     */
    public void remplirReservoir(Carte carte){

        // On considère dans un premier temps que la reserve d'eau est en (0,0), on pourrait rajouter un argument "reserve" de type case.
        if (this.position == carte.getMatriceCases()[0])   {
            this.setPosition(carte.getMatriceCases()[0]);
        }

        // On remet le contenu du reservoir à sa capacité max (donc on le remplit)
        this.contenuReservoir = this.capacite;
    }
}
