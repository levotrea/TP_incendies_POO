public class Carte {

    private int n;
    private int m;
    private Case[] cases;

    public Carte(int n, int m, Case[] cases) {
        this.n = n;
        this.m = m;
        this.cases = cases;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public Case[] getCases() {
        return cases;
    }

    public Case getCaseAuxCoordonnees(int x, int y) {
        return cases[x + this.m*y];
    }

    public Case getCaseDirection(Case case_courante, Directions direction)  {

        Case nouvelle_case = new Case();

        switch (direction)  {
            case NORD:
                if (case_courante.getY() > 0)   {
                    nouvelle_case = cases[case_courante.getX() + m * (case_courante.getY() - 1)];
                }
                else    {
                    throw new IndexOutOfBoundsException("Already at the top of the map, can't go higher !");
                }
            case SUD:
                if (case_courante.getY() < n)   {
                    nouvelle_case = cases[case_courante.getX() + m * (case_courante.getY() + 1)];
                }
                else    {
                    throw new IndexOutOfBoundsException("Already at the bottom of the map, can't go lower !");
                }
            case EST:
                if (case_courante.getX() < m)   {
                    nouvelle_case = cases[(case_courante.getX() + 1) + m * case_courante.getY()];
                }
                else    {
                    throw new IndexOutOfBoundsException("Already at the end of the map, can't go further on the right !");
                }
            case OUEST:
                if (case_courante.getX() < 0)   {
                    nouvelle_case = cases[(case_courante.getX() - 1) + m * case_courante.getY()];
                }
                else    {
                    throw new IndexOutOfBoundsException("Already at the end of the map, can't go further on the left !");
                }
        }

        return nouvelle_case;
    }
}
