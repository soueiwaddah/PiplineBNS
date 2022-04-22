package bns.transactiion.Services;

import java.util.List;

import bns.transactiion.DTO.ClientDto;
import bns.transactiion.Entities.Client;

public interface IClientService {
    List<ClientDto> retrieveAllClients();
    public Client getClientByCIN(int ClientCIN);
    public Client getClientByPasseport(String ClientPasseport);
    public ClientDto ajouterClient(ClientDto clientdto);
    public ClientDto mettreAjourClient(ClientDto clientdto);
    public String deleteClientByCIN(int ClientCIN);
    public String deleteClientByPasseport(String ClientPasseport);
    public void checkAlreadyUsedCin(ClientDto clientdto);
}
