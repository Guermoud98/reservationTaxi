package Business;

public class Client extends Personne {
    public Client(String nom, String prenom, String telephone, String email) {
        super(nom, prenom, telephone, email);
    }
    public int getIdClient() {
        return super.getNbr();
    }
}
