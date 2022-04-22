package bns.transactiion.Controller;

import bns.transactiion.DTO.ClientDto;
import bns.transactiion.Mapper.ClientMapper;
import bns.transactiion.Services.IClientService;
import bns.transactiion.Entities.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import bns.transactiion.Repository.ClientRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;
    @Autowired
    ClientRepository clientrepo;
    @Autowired
    ClientMapper clientmapper;


    // http://localhost:8084/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<ClientDto> getAllClients()
    {

        return clientService.retrieveAllClients();
    }

    // http://localhost:8084/retrieve-clientCIN/{client-CIN}
    //recherche a partir du service
    @GetMapping ("/retrieve-clientCIN/{client-CIN}")
    public Client retrieveClientByCIN(@PathVariable ("client-CIN") int ClientCIN)
    {
        return clientService.getClientByCIN(ClientCIN);
    }

    // http://localhost:8084/retrieve-clientPassword/{client-password}
    @GetMapping ("/retrieve-clientPassword/{client-password}")
    public Client retrieveClientByPassport(@PathVariable ("client-password") String ClientPassport)
    {
        return clientService.getClientByPasseport(ClientPassport);
    }

    // http://localhost:8084/retrieve-clientRNE/{client-RNE}
    // recherche a partir du repository
    @GetMapping ("/retrieve-clientRNE/{client-RNE}")
    public Client retrieveClientByRNE(@PathVariable ("client-RNE") String ClientRNE)
    {
        return clientrepo.findByRne(ClientRNE);
    }


    // http://localhost:8084/add-client
    @PostMapping ("/add-client")
    @ResponseBody
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientdto)
    {
        try {
            log.info("client ajouté avec succés");
            return new ResponseEntity<>(clientService.ajouterClient(clientdto),HttpStatus.OK) ;
        }
        catch (Exception e) {
            log.error("client non ajouter");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }

    // http://localhost:8084/modify-client
    @PutMapping("/modify-client")
    public ResponseEntity<ClientDto> modifyClient(@RequestBody ClientDto clientdto )
    {
        try {
            log.info("client modifié avec succés");
            return new ResponseEntity<>(clientService.mettreAjourClient(clientdto), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("client non modifier");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    // http://localhost:8084/remove-client-cin/{client-CIN}
    @DeleteMapping("remove-client-cin/{client-CIN}")
    public void removeClientByCIN(@PathVariable("client-CIN") int ClientCIN)
    {
        clientService.deleteClientByCIN(ClientCIN);
    }


    // http://localhost:8084/remove-client-passeport/{client-passeport}
    @DeleteMapping("remove-client-passeport/{client-passeport}")
    public void removeClientByPassport(@PathVariable("client-passeport") String ClientPassport)
    {
        clientService.deleteClientByPasseport(ClientPassport);
    }


    // http://localhost:8084/remove-client-rne/{client-RNE}
    @DeleteMapping("remove-client-rne/{client-RNE}")
    public void removeClientByRNE(@PathVariable("client-RNE") String ClientRNE)
    {
        clientrepo.deleteClientByRNE(ClientRNE);
    }

}
