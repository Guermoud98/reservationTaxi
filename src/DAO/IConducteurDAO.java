package DAO;

public interface IConducteurDAO extends IPersonneDAO {
    //public Conducteur SelectConductParId(int id );
    public String selectRandomMatricule();
    public void updateTaxiStatus();
    //public int SelectIdOfConducteur(Conducteur c);
    //public Conducteur SelectConducteurOfTaxi(Taxi taxi)

}
