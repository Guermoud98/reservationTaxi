package DAO;

import Business.Taxi;

public interface IConducteurDAO extends IPersonneDAO {
    //public Conducteur SelectConductParId(int id );
    public String selectRandomMatricule();
    public int getRandomConducteur(); //cette methode retourne l'id d'un conducteur aléatoirement (util pour une reservation)
    //public void updateTaxiStatus();
    //public int SelectIdOfConducteur(Conducteur c);
    //public Conducteur SelectConducteurOfTaxi(Taxi taxi)
    //public void getAllConducteurs();
    public void conducteurOfATaxi(String matricule);

}
