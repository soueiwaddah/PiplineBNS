package bns.transactiion.Repository;

import bns.transactiion.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    Client findByCin(int cin);
    Client findByPasseport(String passeport);
    Client findByRne(String rne);
    Optional<Client> findOneByCin(int cin);

    @Modifying
    @Transactional
    @Query("DELETE from Client c where c.cin=:ClientCIN")
    public void deleteClientByCIN(int ClientCIN);

    @Modifying
    @Transactional
    @Query ("DELETE from Client c where c.passeport=:ClientPasseport")
    public void deleteClientByPasseport(String ClientPasseport);

    @Modifying
    @Transactional
    @Query ("DELETE from Client c where c.rne=:ClientRNE")
    public void deleteClientByRNE(String ClientRNE);




}

