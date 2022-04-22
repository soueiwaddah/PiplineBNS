package bns.transactiion.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Emetteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Statut_Emetteur")
    private String statut;
    @Column(name = "ID_Emetteur")
    private String idemetteur;
    @Column(name = "Matricule_Fiscal")
    private String matriculeF;
    @Column(name = "PV")
    private String pv;

}
