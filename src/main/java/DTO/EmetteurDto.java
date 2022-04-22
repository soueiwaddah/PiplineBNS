package bns.transactiion.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Builder

public class EmetteurDto {

    private long idDto;
    private String statutDto;
    private String idemetteurDto;
    private String matriculeFDto;
    private String pvDto;

}
