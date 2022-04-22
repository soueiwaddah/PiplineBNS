package bns.transactiion.DTO;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Builder
public class ClientDto {

    private long idDto;
    private String nomDto;
    private String prenomDto;
    private int cinDto;
    private String passeportDto;
    private String matriculeFsDto;
    private String rneDto;



}
