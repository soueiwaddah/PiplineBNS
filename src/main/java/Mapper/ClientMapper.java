package bns.transactiion.Mapper;

import bns.transactiion.DTO.ClientDto;
import bns.transactiion.Entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDto toDto(Client client) {
        return ClientDto.builder()
        .idDto(client.getId())
        .cinDto(client.getCin())
        .matriculeFsDto(client.getMatriculeFs())
        .nomDto(client.getNom())
        .passeportDto(client.getPasseport())
        .prenomDto(client.getPrenom())
        .rneDto(client.getRne())
                .build();
    }

}
