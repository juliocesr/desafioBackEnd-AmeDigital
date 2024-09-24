package api.Controller;

import api.DTO.PlanetasDTO;
import api.DTO.RespostaPadraoDTO;
import api.Service.Service;
import api.Service.SwipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Mock
    private Service service;
    @Mock
    private SwipeService swipeService;
    @InjectMocks
    private Controller controller;

    @BeforeEach
    public void setUp() {
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
        when(service.listarPlanetas()).thenReturn(planetasDTO);
        List<PlanetasDTO> response = controller.listarPlanetas();

        //THEN
        assertNotNull(response);
    }
    @Test
    @DisplayName("Quando listarPlanetasPorID for chamado deve retoranar uma lista de PlanetasDTO")
    public void testeListarPlanetasPorId() {
        //GIVEN
        List<PlanetasDTO> planetasDTO = Arrays.asList(
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1),
                new PlanetasDTO("teste", "teste", "teste", 1));

        //WHEN
        when(service.listarPlanetasPorID(1)).thenReturn(planetasDTO);
        List<PlanetasDTO> response = controller.listarPlanetasPorID(1);

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
        when(service.listarPlanetasPorNome("teste")).thenReturn(planetasDTO);
        List<PlanetasDTO> response = controller.listarPlanetasPorNome("Teste");

        //THEN
        assertNotNull(response);
    }

    @Test
    @DisplayName("Quando listarPlanetas for chamado deve retoranar Excetpion")
    public void testeListarPlanetasCenarioDeErro() throws Exception {
        //GIVEN
        Thread thread = new Thread(() -> controller.listarPlanetas());
        List<PlanetasDTO> response = controller.listarPlanetas();

        //WHEN
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();

        //THEN
        assertTrue(response.isEmpty());

    }

    @Test
    @DisplayName("Quando listarPlanetasPorID for chamado deve retoranar Excetpion")
    public void testeListarPlanetasPorIdCenarioDeErro() throws Exception {
        //GIVEN
        Thread thread = new Thread(() -> controller.listarPlanetasPorID(1));
        List<PlanetasDTO> response = controller.listarPlanetasPorID(1);

        //WHEN

        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();

        //THEN
        assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("Quando listarPlanetasNome for chamado deve retoranar Excetpion")
    public void testeListarPlanetasPorNomeCenarioDeErro() throws Exception {
        //GIVEN
        Thread thread = new Thread(() -> controller.listarPlanetasPorNome("Teste"));
        List<PlanetasDTO> response = controller.listarPlanetasPorNome("Teste");

        //WHEN
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();

        //THEN

        assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("Quando adicionarPlanetas for chamado deve retoranar uma respostaPadrão")
    public void testeAdicionarPlaneta() {
        //GIVEN
        PlanetasDTO planetasDTO = new PlanetasDTO("teste", "teste", "teste", 1);
        RespostaPadraoDTO esperado = new RespostaPadraoDTO("Planeta cadastrado com sucesso");
        //WHEN
        when(service.adicionarPlaneta(planetasDTO)).thenReturn(esperado);
        RespostaPadraoDTO resposta = controller.adicionarPlaneta(planetasDTO);
        //THEN
        assertEquals(resposta, esperado);
    }

    @Test
    @DisplayName("Quando removerPlanetas for chamado deve retoranar uma respostaPadrão")
    public void testeRemoverPlaneta() {
        //GIVEN
        RespostaPadraoDTO esperado = new RespostaPadraoDTO("Planeta removido com sucesso");
        //WHEN
        when(service.removerPlaneta(1)).thenReturn(esperado);
        RespostaPadraoDTO resposta = controller.removerPlaneta(1);
        //THEN
        assertEquals(resposta, esperado);
    }

    @Test
    @DisplayName("Quando aparicao for chamado deve retoranar a quantidade de aparicoes")
    public void testeAparicao() {
        //GIVEN
        int aparicoes = 3;
        //WHEN
        when(swipeService.getPlanets("teste")).thenReturn(aparicoes);
        int resposta = controller.aparicao("teste");
        //THEN
        assertEquals(resposta, aparicoes);
    }
}
