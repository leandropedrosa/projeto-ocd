package br.ufg.api.ocd.service;

import br.ufg.api.ocd.model.ScriptsMobile;
import br.ufg.api.ocd.repository.ScriptsMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScriptsMobileService {

    @Autowired
    private ScriptsMobileRepository repository;

    public List<ScriptsMobile> findAll() {
        return repository.findAll();
    }

    public List<ScriptsMobile> findByVersaoBanco(String versaoBanco) {
        return repository.findByVersaoBanco_Descricao(versaoBanco);
    }
}
