public class Case {


    /**
     * Coordonnées ligne et colonne sous forme d'entiers
     */

    private int ligne;
    private int colonne;
    private NatureTerrains nature;
    private boolean enFeu;


    public Case() {
        this.ligne = 0;
        this.colonne = 0;
        this.nature = NatureTerrains.TERRAIN_LIBRE;
        this.enFeu = false;
    }

    public Case(int ligne, int colonne, NatureTerrains terrain, boolean estEnFeu) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.nature = terrain;
        this.enFeu = estEnFeu;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public boolean isEnFeu() {
        return enFeu;
    }

    public NatureTerrains getNature() {
        return nature;
    }


    public void setEnFeu(boolean enFeu) {
        this.enFeu = enFeu;
    }
}
