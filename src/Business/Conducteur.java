package Business;

public class Conducteur extends Personne{

    public Conducteur(String nom, String prenom, String telephone, String email, String password)
    {
        super(nom, prenom, telephone, email, password);
    }
    public int getIntClient() {

        return super.getId();
    }
}
