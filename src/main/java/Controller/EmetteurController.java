package bns.transactiion.Controller;


import bns.transactiion.DTO.EmetteurDto;
import bns.transactiion.Entities.Emetteur;
import bns.transactiion.Mapper.EmetteurMapper;
import bns.transactiion.Repository.EmetteurRepository;

import bns.transactiion.Services.IEmetteurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emetteur")
public class EmetteurController {

    @Autowired
    EmetteurMapper emetteurmapper;
    @Autowired
    EmetteurRepository emetteurrepo;
    @Autowired
    IEmetteurService emetteurservice;


    // http://localhost:8084/retrieve-all-emetteurs
    @GetMapping("/retrieve-all-emetteurs")
    public List<EmetteurDto> getAllEmetteurs()
    {

        return emetteurservice.retrieveAllEmetteurs();
    }


    // http://localhost:8084/retrieve-Idemetteur/{emetteur-Idemetteur}
    @GetMapping ("/retrieve-Idemetteur/{emetteur-Idemetteur}")
    public Emetteur retrieveEmetteurByIdEmetteur(@PathVariable ("emetteur-Idemetteur") String IdEmetteur)
    {
        return emetteurservice.getEmetteurByIdEmetteur(IdEmetteur);
    }


    // http://localhost:8084/retrieve-PvEmetteur/{emetteur-PV}
    @GetMapping ("/retrieve-PvEmetteur/{emetteur-PV}")
    public Emetteur retrieveEmetteurByPv(@PathVariable ("emetteur-PV") String EmetteurPv)
    {
        return emetteurservice.getEmetteurByPv(EmetteurPv);
    }


    // http://localhost:8084/add-emetteur
    @PostMapping("/add-emetteur")
    @ResponseBody
    public ResponseEntity<EmetteurDto> addEmetteur(@RequestBody EmetteurDto emetteurdto)
    {
        try {
            log.info("emetteur ajouté avec succés");
            return new ResponseEntity<>(emetteurservice.ajouterEmetteur(emetteurdto), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("emetteur non ajouter");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    // http://localhost:8084/modify-emetteur
    @PutMapping("/modify-emetteur")
    public ResponseEntity<EmetteurDto> modifyEmetteur(@RequestBody EmetteurDto emetteurdto)
    {
        try {
            log.info("emetteur modifié avec succés");
            return new ResponseEntity<>(emetteurservice.mettreAjourEmetteur(emetteurdto), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("emetteur non modifier");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    // http://localhost:8084/remove-emetteur-idemetteur/{emetteur-idemetteur}
    @DeleteMapping("remove-emetteur-idemetteur/{emetteur-idemetteur}")
    public void removeEmetteurByIdEmetteur(@PathVariable("emetteur-idemetteur") String IdEmetteur)
    {
        emetteurservice.deleteEmetteurByIdEmetteur(IdEmetteur);
    }


    // http://localhost:8084/remove-emetteur-pv/{emetteur-PV}
    @DeleteMapping("remove-emetteur-pv/{emetteur-PV}")
    public void removeEmetteurByPv(@PathVariable("emetteur-PV") String EmetteurPv)
    {
        emetteurservice.deleteEmetteurByPv(EmetteurPv);
    }


}
