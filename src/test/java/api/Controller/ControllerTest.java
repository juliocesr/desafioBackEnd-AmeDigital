package api.Controller;

import api.DTO.PlanetasDTO;
import api.Service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private Service service;
    @Autowired
    private Controller controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testeListarPlanetas() throws Exception {
       List<PlanetasDTO> planetasDTO = Arrays.asList(
               new PlanetasDTO("teste", "teste", "teste", 1),
               new PlanetasDTO("teste", "teste", "teste", 1),
               new PlanetasDTO("teste", "teste", "teste", 1));

       when(service.listarPlanetas()).thenReturn(planetasDTO);

       mockMvc.perform(get("/api/desafio/listar-planetas").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}
