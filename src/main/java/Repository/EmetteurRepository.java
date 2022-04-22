package bns.transactiion.Repository;

import bns.transactiion.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmetteurRepository extends JpaRepository<Emetteur, Long> {

    Emetteur findByIdemetteur(String idemetteur);
    Emetteur findByPv(String pv);

    Optional<Emetteur> findOneByIdemetteur(String idEmmetteur);

    @Modifying
    @Transactional
    @Query("DELETE from Emetteur e where e.idemetteur=:IdEmetteur")
    public void deleteEmetteurByIdemetteur(String IdEmetteur);

    @Modifying
    @Transactional
    @Query("DELETE from Emetteur e where e.pv=:PV")
    public void deleteEmetteurByPv(String PV);



}
