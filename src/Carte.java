public class Carte {

    private int tailleCases;
    private int n;
    private int m;
    private Case[] matriceCases;

    public Carte(int tailleCases, int n, int m, Case[] cases) {
        this.tailleCases = tailleCases;
        this.n = n;
        this.m = m;
        this.matriceCases = cases;
    }

    public int getTailleCases() {
        return tailleCases;
    }

    public int getNbLignes() {
        return n / tailleCases;
    }

    public int getNbColonnes() {
        return m / tailleCases;
    }

    public Case[] getMatriceCases() {
        return matriceCases;
    }

    public Case getCase(int ligne, int colonne) {
        return matriceCases[ligne + this.getNbColonnes()*colonne];
    }

    public boolean voisinExiste(Case case_courante, Directions direction) {

        boolean existe = true;
        switch (direction)  {
            case NORD:
                if (case_courante.getColonne() <= 0)   {
                    existe = false;
                }
                break;
            case SUD:
                if (case_courante.getColonne() >= getNbLignes())   {
                    existe = false;
                }
            case EST:
                if (case_courante.getLigne() >= getNbColonnes())   {
                    existe = false;
                }
            case OUEST:
                if (case_courante.getLigne() <= 0)   {
                    existe = false;
                }
        }
        return existe;
    }

    public Case getVoisin(Case case_courante, Directions direction)  {

        Case nouvelle_case = new Case();

        if (voisinExiste(case_courante, direction)) {

            switch (direction)  {
                case NORD:
                    nouvelle_case = matriceCases[case_courante.getLigne() + getNbColonnes() * (case_courante.getColonne() - 1)];
                    break;
                case SUD:
                    nouvelle_case = matriceCases[case_courante.getLigne() + getNbColonnes() * (case_courante.getColonne() + 1)];
                    break;
                case EST:
                    nouvelle_case = matriceCases[(case_courante.getLigne() + 1) + getNbColonnes() * case_courante.getColonne()];
                    break;
                case OUEST:
                    nouvelle_case = matriceCases[(case_courante.getLigne() - 1) + getNbColonnes() * case_courante.getColonne()];
                    break;
            }
        }

        else    {
            throw new IndexOutOfBoundsException("Vous ne pouvez pas aller dans cette direction car vous etes deja au bord de la carte !");
        }

        return nouvelle_case;
    }
}
