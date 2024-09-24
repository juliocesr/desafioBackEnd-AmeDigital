package api.Repository;

import api.DTO.PlanetasDTO;
import api.Service.Service;
import api.Service.SwipeService;
import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class RepositoryTest {
    @InjectMocks
    Repository repository;
    @Mock
    SwipeService swipeService;
    @Mock
    JdbcTemplate jdbcTemplate;
    private Service service;


    @Test
    @DisplayName("Quando ListarTudo for chamado deve retornar uma lista de PlanetasDTO")
    void testeListarTudo() {
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class))).thenAnswer(invocationOnMock -> {
            RowMapper<PlanetasDTO> planetasDTORowMapper = invocationOnMock.getArgument(2);

            PlanetasDTO planetasDTO = new PlanetasDTO();
            planetasDTO.setNome("teste");
            planetasDTO.setClima("teste");
            planetasDTO.setTerreno("teste");
            planetasDTO.setQtdAparicao(1);

            return List.of(planetasDTO);
        });

        List<PlanetasDTO> planetasDTOList = repository.listarTudo();

        assertEquals(1, planetasDTOList.size());
    }
}
