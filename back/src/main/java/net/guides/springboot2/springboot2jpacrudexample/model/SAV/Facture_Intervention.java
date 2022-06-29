package net.guides.springboot2.springboot2jpacrudexample.model.SAV;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Facture_Intervention")
public class Facture_Intervention {

    @javax.persistence.Id
    @Column(name = "Id_intervention")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_intervention ;

    @Column(name = "Etat")
    private String Etat ;


    @Column(name = "Id_Client")
    Long Id_Client ;

    @Column(name = "Description")
    String Description ;

    @Column(name = "Rapport_Intervention")
    String Rapport_Intervention ;

    @Column(name = "Total_HT_Brut")
    private double Total_HT_Brut = 0;

    @Column(name = "Total_Remise")
    private double Total_Remise = 0;

    @Column(name = "Total_HT_Net")
    private double Total_HT_Net = 0;

    @Column(name = "Total_Fodec")
    private double Total_Fodec = 0;

    @Column(name = "Total_Tva")
    private double Total_Tva = 0;

    @Column(name = "Total_TTC")
    private double Total_TTC = 0;

    @Column(name = "Frais_Intervention")
    private double Frais_Intervention = 0;

    @Lob
    private byte[] Detail;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

}
