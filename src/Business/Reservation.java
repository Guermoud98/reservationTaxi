package Business;

import java.sql.Time;
import java.util.Date;

public class Reservation {
    private Client client;
    private Conducteur conducteur;
    private String lieuSource;
    private String lieuDestination;

    private String typePaiement;
    private float tarif;

    private Date d;
    private Time heure;

    public Reservation(String lieuSource, String lieuDestination, float tarif, Date d, Time heure) {
        this.lieuSource = lieuSource;
        this.lieuDestination = lieuDestination;
        this.tarif = tarif;
        this.d = d;
        this.heure = heure;
    }

    public String getLieuSource() {
        return lieuSource;
    }

    public void setLieuSource(String lieuSource) {
        this.lieuSource = lieuSource;
    }

    public String getLieuDestination() {
        return lieuDestination;
    }

    public void setLieuDestination(String lieuDestination) {
        this.lieuDestination = lieuDestination;
    }

    public float getTarif() {
        return tarif;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public java.sql.Date getD() {
        return (java.sql.Date) d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }
    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "client=" + client +
                ", conducteur=" + conducteur +
                ", lieuSource='" + lieuSource + '\'' +
                ", lieuDestination='" + lieuDestination + '\'' +
                ", typePaiement='" + typePaiement + '\'' +
                ", tarif=" + tarif +
                ", d=" + d +
                ", heure=" + heure +
                '}';
    }
}
