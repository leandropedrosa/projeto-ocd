package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.FatorDeRisco;
import lombok.Getter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;

@Getter
public class FatoresDeRiscoDTO {

    private ModelMapper modelMapper = new ModelMapper();

    private Integer id;
    @NotBlank(message = "{fatoresDeRisco.nome.not.blank}")
    private String nome;

    public FatoresDeRiscoDTO(Integer id,  String nome) {
        this.id = id;
        this.nome = nome;
    }

    private FatoresDeRiscoDTO convertToDto(FatorDeRisco post) {
        FatoresDeRiscoDTO postDto = modelMapper.map(post, FatoresDeRiscoDTO.class);
        return postDto;
    }
    private FatorDeRisco convertToEntity(FatoresDeRiscoDTO postDto) throws ParseException {
        FatorDeRisco post = modelMapper.map(postDto, FatorDeRisco.class);
        return post;
    }
}
