import java.sql.ResultSet;
import java.sql.SQLException;

public class Salle {

    private int id;
    private String nom;
    private String batiment;
    private int etage;

    public Salle(int id, String nom, String batiment, int etage) {
        this.id = id;
        this.nom = nom;
        this.batiment = batiment;
        this.etage = etage;
    }


    /*
    ____________________________
           REQUETES SQL
    ____________________________
    */


    public static Salle create(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String batiment = resultSet.getString("batiment");
            int etage = resultSet.getInt("etage");

            Salle salle;
            salle = new Salle(id, nom, batiment, etage);
            return salle;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }
}
