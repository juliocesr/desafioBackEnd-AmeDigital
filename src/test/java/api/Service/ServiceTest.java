package api.Service;

import api.DTO.PlanetasDTO;
import api.DTO.RespostaPadraoDTO;
import api.Repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {
    @InjectMocks
    Service service;
    @Mock
    Repository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Quando listarPlanetas for chamado deve retoranar uma lista de PlanetasDTO")
    public void testeListarPlanetas() {
        //GIVEN
        List<PlanetasDTO> planetasDTO = Arrays.asList(
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1));

        //WHEN
        when(repository.listarTudo()).thenReturn(planetasDTO);
        List<PlanetasDTO> response = service.listarPlanetas();

        //THEN
        assertNotNull(response);
    }

    @Test
    @DisplayName("Quando listarPlanetasPorID for chamado deve retoranar uma lista de PlanetasDTO")
    public void testeListarPlanetasPorID() {
        //GIVEN
        List<PlanetasDTO> planetasDTO = Arrays.asList(
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1));

        //WHEN
        when(repository.listarPorId(1)).thenReturn(planetasDTO);
        List<PlanetasDTO> response = service.listarPlanetasPorID(1);

        //THEN
        assertNotNull(response);
    }

    @Test
    @DisplayName("Quando listarPlanetasPorNome for chamado deve retoranar uma lista de PlanetasDTO")
    public void testeListarPlanetasPorNome() {
        //GIVEN
        List<PlanetasDTO> planetasDTO = Arrays.asList(
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1));

        //WHEN
        when(repository.listarPorNome("teste")).thenReturn(planetasDTO);
        List<PlanetasDTO> response = service.listarPlanetasPorNome("teste");

        //THEN
        assertNotNull(response);
    }

    @Test
    @DisplayName("Quando adicionarPlaneta for chamado deve retoranar uma resposta padrão")
    public void testeAdicionarPlaneta() {
        //GIVEN
        PlanetasDTO planetasDTO = new PlanetasDTO("teste", "teste", "teste", 1);

        //WHEN
        RespostaPadraoDTO resposta = service.adicionarPlaneta(planetasDTO);

        //THEN
        assertNotNull(resposta);
    }

    @Test
    @DisplayName("Quando removerPlaneta for chamado deve retoranar uma resposta padrão")
    public void testeRemoverPlaneta() {
        //GIVEN
        RespostaPadraoDTO esperado = new RespostaPadraoDTO("Planeta removido com sucesso");

        //WHEN
        RespostaPadraoDTO resposta = service.removerPlaneta(1);

        //THEN
        assertNotNull(resposta);
    }
}
