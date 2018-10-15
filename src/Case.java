public class Case {


    /**
     * Coordonnées x et y sous forme d'entiers
     */

    private int x;
    private int y;
    private NatureTerrains terrain;


    public Case() {
        this.x = 0;
        this.y = 0;
    }

    public Case(int x, int y, NatureTerrains terrain) {
        this.x = x;
        this.y = y;
        this.terrain = terrain;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public NatureTerrains getTerrain() {
        return terrain;
    }

}
