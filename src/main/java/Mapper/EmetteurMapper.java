package bns.transactiion.Mapper;

import bns.transactiion.DTO.EmetteurDto;
import bns.transactiion.Entities.Emetteur;
import org.springframework.stereotype.Component;

@Component
public class EmetteurMapper {
    public EmetteurDto toEmmDto(Emetteur emetteur){
        return EmetteurDto.builder()
                .idDto(emetteur.getId())
                .idemetteurDto(emetteur.getIdemetteur())
                .matriculeFDto(emetteur.getMatriculeF())
                .pvDto(emetteur.getPv())
                .statutDto(emetteur.getStatut())
                .build();
    }
}
