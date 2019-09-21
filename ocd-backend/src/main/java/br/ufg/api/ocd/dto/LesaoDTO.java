package br.ufg.api.ocd.dto;

import br.ufg.api.ocd.model.FatorDeRisco;
import br.ufg.api.ocd.model.Lesao;
import lombok.Getter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;

@Getter
public class LesaoDTO {

    private ModelMapper modelMapper = new ModelMapper();

    private Integer id;
    @NotBlank(message = "{lesao.nome.not.blank}")
    private String nome;

    public LesaoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    private LesaoDTO convertToDto(Lesao post) {
        LesaoDTO postDto = modelMapper.map(post, LesaoDTO.class);
        return postDto;
    }
    private Lesao convertToEntity(LesaoDTO postDto) throws ParseException {
        Lesao post = modelMapper.map(postDto, Lesao.class);
        return post;
    }
}
