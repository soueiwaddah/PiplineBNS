package bns.transactiion.Services;

import bns.transactiion.DTO.EmetteurDto;
import bns.transactiion.Entities.Emetteur;
import bns.transactiion.Exception.AlreadyExistingEmetteur;
import bns.transactiion.Mapper.EmetteurMapper;
import bns.transactiion.Repository.EmetteurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class EmetteurServiceImpl implements IEmetteurService{

    @Autowired
    EmetteurRepository emetteurrepo;
    @Autowired
    EmetteurMapper emetteurmapper;


    @Override
    public List<EmetteurDto> retrieveAllEmetteurs() {
        return emetteurrepo.findAll().stream()
                .map(emetteurmapper::toEmmDto)
                .collect(toList());
    }

    @Override
    public Emetteur getEmetteurByIdEmetteur(String IdEmetteur) {
        return emetteurrepo.findByIdemetteur(IdEmetteur);
    }

    @Override
    public Emetteur getEmetteurByPv(String EmetteurPv) {
        return emetteurrepo.findByPv(EmetteurPv);
    }


    @Override
    public EmetteurDto ajouterEmetteur(EmetteurDto emetteurdto) {

        log.info("debut ajout");

        checkAlreadyUsedIdEmetteur(emetteurdto);

        Emetteur emetteur = emetteurrepo.save(Emetteur.builder()
                .idemetteur(emetteurdto.getIdemetteurDto())
                .matriculeF(emetteurdto.getMatriculeFDto())
                .pv(emetteurdto.getPvDto())
                .statut(emetteurdto.getStatutDto())
                .build());

        log.info("l'ajout est realisé avec succés, fin methode ajouterEmetteur");

        return emetteurmapper.toEmmDto(emetteur);
    }

    @Override
    public EmetteurDto mettreAjourEmetteur(EmetteurDto emetteurdto) {
        log.info("debut modification");



        Emetteur emetteur = emetteurrepo.save(Emetteur.builder()
                .idemetteur(emetteurdto.getIdemetteurDto())
                .matriculeF(emetteurdto.getMatriculeFDto())
                .pv(emetteurdto.getPvDto())
                .statut(emetteurdto.getStatutDto())
                .build());

        log.info("la modification est realisé avec succés, fin methode mettreAjourEmetteur");

        return emetteurmapper.toEmmDto(emetteur);
    }

    @Override
    public String deleteEmetteurByIdEmetteur(String IdEmetteur) {
        String msg="";
        try {

            emetteurrepo.deleteEmetteurByIdemetteur(IdEmetteur);
            log.info("Finding Emetteur with ID = %s"+IdEmetteur);
            log.info("Emetteur Deleted Successfuly ");
            msg="Delete Done";
        }
        catch (Exception e){
            log.error("The Emetteur with ID = %s does not Exist"+IdEmetteur);
            msg="error";
        }


         return msg;
    }

    @Override
    public String deleteEmetteurByPv(String EmetteurPv) {
        String msg="";
        try {
            log.info("Finding Emetteur with PV = %s"+EmetteurPv);
            emetteurrepo.deleteEmetteurByPv(EmetteurPv);
            log.info("Emetteur Deleted Successfuly ");
            msg="Delete Done";
        }
        catch (Exception e){
            log.error("The Emetteur with PV = %s does not Exist"+EmetteurPv);
            msg="error";
        }


        return msg;
    }


    @Override
    public void checkAlreadyUsedIdEmetteur(EmetteurDto emetteurdto) {

        emetteurrepo.findOneByIdemetteur(emetteurdto.getIdemetteurDto()).ifPresent(existingEmetteur ->{
            try {
                throw new AlreadyExistingEmetteur(emetteurdto.getIdemetteurDto());
            } catch (AlreadyExistingEmetteur alreadyExistingEmetteur){
                alreadyExistingEmetteur.printStackTrace();
            }
        });

    }
}
