package DAO;

public class Conducteur extends Personne{

    public Conducteur(String nom, String prenom, String telephone, String email) {
        super(nom, prenom, telephone, email);
    }
    public int getIntClient() {
        return super.getNbr();
    }
}
