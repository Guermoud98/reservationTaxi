package DAO;
import Business.*;

public interface IPersonneDAO {
    public void register(Personne p);
    public void isValidEmail(String email);
    public void isValidPassword(String password);
    public int passwordContainsUpperLetters(String password);
    public int passwordContainsLowerLetters(String password);
    //public void login(String email, String password);
   //public void consulterHistoriqueReservation();
    //public void updateInfo();
}
