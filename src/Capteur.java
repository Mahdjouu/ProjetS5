public class Capteur {

    private int id;
    private int valeur;
    private int seuilMin;
    private int seuilMax;
    private boolean connecte;

    public Capteur(int id, int valeur, int seuilMin, int seuilMax, boolean connecte) {
        this.id = id;
        this.valeur = valeur;
        this.seuilMin = seuilMin;
        this.seuilMax = seuilMax;
        this.connecte = connecte;
    }


    /*
    ____________________________
        GETTERS & SETTERS
    ____________________________
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getSeuilMin() {
        return seuilMin;
    }

    public void setSeuilMin(int seuilMin) {
        this.seuilMin = seuilMin;
    }

    public int getSeuilMax() {
        return seuilMax;
    }

    public void setSeuilMax(int seuilMax) {
        this.seuilMax = seuilMax;
    }

    public boolean isConnecte() {
        return connecte;
    }

    public void setConnecte(boolean connecte) {
        this.connecte = connecte;
    }

}
