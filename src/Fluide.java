public class Fluide {

    private String unite;
    private int seuilDefautMin;
    private int seuilDefautMax;
    private TYPEFLUIDE type_fluide;

    public Fluide(String unite, int seuilDefautMin, int seuilDefautMax, TYPEFLUIDE type_fluide) {
        this.unite = unite;
        this.seuilDefautMin = seuilDefautMin;
        this.seuilDefautMax = seuilDefautMax;
        this.type_fluide = type_fluide;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getSeuilDefautMin() {
        return seuilDefautMin;
    }

    public void setSeuilDefautMin(int seuilDefautMin) {
        this.seuilDefautMin = seuilDefautMin;
    }

    public int getSeuilDefautMax() {
        return seuilDefautMax;
    }

    public void setSeuilDefautMax(int seuilDefautMax) {
        this.seuilDefautMax = seuilDefautMax;
    }

    public TYPEFLUIDE getType_fluide() {
        return type_fluide;
    }

    public void setType_fluide(TYPEFLUIDE type_fluide) {
        this.type_fluide = type_fluide;
    }
}
