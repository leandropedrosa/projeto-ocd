package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.Atendimento;
import br.ufg.api.ocd.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AvaliacaoClinicaService avaliacaoClinicaService;

    @Autowired
    private DiagnosticoService diagnosticoService;

    @Autowired
    private EncaminhamentoService encaminhamentoService;

    public List<Atendimento> geByNomePaciente(String nome) {
        return repository.findAllByPaciente_Nome(nome);
    }


    public Atendimento salvar(Atendimento atendimento) {

        diagnosticoService.salvarTodos(atendimento.getDiagnosticos());
        avaliacaoClinicaService.salvarTodos(atendimento.getAvaliacaoClinicas());
        encaminhamentoService.salvarTodos(atendimento.getEncaminhamentos());
        pacienteService.salvar(atendimento.getPaciente());

        return repository.save(atendimento);
    }
}
