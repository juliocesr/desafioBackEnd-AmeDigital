package api.Service;

import api.DTO.PlanetasDTO;
import api.DTO.RespostaPadraoDTO;
import api.Repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<PlanetasDTO> listarPlanetas() {
        return repository.listarTudo();
    }

    public List<PlanetasDTO> listarPlanetasPorID(int id) {
        return repository.listarPorId(id);
    }

    public List<PlanetasDTO> listarPlanetasPorNome(String nome) {
        return repository.listarPorNome(nome);
    }

    public RespostaPadraoDTO adicionarPlaneta(PlanetasDTO planeta) {
        repository.adicionarPlaneta(planeta);
        return new RespostaPadraoDTO("Planeta cadastrado com sucesso");
    }

    public RespostaPadraoDTO removerPlaneta(int id) {
        repository.removerPlaneta(id);
        return new RespostaPadraoDTO("Planeta removido com sucesso");
    }
}
