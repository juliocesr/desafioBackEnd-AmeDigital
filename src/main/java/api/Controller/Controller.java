package api.Controller;

import api.DTO.PlanetasDTO;
import api.DTO.RespostaPadraoDTO;
import api.Service.Service;
import api.Service.SwipeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/desafio")
public class Controller {

    private Service service;
    private SwipeService swipeService;

    public Controller(Service service, SwipeService swipeService) {
        this.service = service;
        this.swipeService = swipeService;
    }

    @GetMapping("/listar-planetas")
    @Cacheable("cache")
    public List<PlanetasDTO> listarPlanetas() {
        List<PlanetasDTO> dados = new ArrayList<>();
        try {
            dados = service.listarPlanetas();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dados;
    }
    @GetMapping("/listar-porID")
    @Cacheable("cache")
    public List<PlanetasDTO> listarPlanetasPorID(@RequestParam(name = "id") int id) {
        List<PlanetasDTO> dados = new ArrayList<>();
        try {
            dados = service.listarPlanetasPorID(id);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dados;
    }
    @GetMapping("/listar-por-nome")
    @Cacheable("cache")
    public List<PlanetasDTO> listarPlanetasPorNome(@RequestParam(name = "nome") String nome) {
        List<PlanetasDTO> dados = new ArrayList<>();
        try {
            dados = service.listarPlanetasPorNome(nome);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dados;
    }
    @PostMapping("/adicionar-planeta")
    public RespostaPadraoDTO adicionarPlaneta(@RequestBody PlanetasDTO planeta) {
        return service.adicionarPlaneta(planeta);
    }

    @DeleteMapping("/remover-planeta")
    public RespostaPadraoDTO removerPlaneta(@RequestParam(name = "id") int id) {
        return service.removerPlaneta(id);
    }

    @GetMapping("/aparicao")
    @Cacheable
    public int aparicao(String nome) {
        return swipeService.getPlanets(nome);
    }
}
