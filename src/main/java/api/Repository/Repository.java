package api.Repository;

import api.DTO.PlanetasDTO;
import api.Model.Planetas;
import api.Service.SwipeService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private final JdbcTemplate jdbcTemplate;
    private final SwipeService swipeService;

    public Repository(JdbcTemplate jdbcTemplate, SwipeService swipeService) {
        this.jdbcTemplate = jdbcTemplate;
        this.swipeService = swipeService;
    }

    private final String ADICIONAR_PLANETA = "INSERT INTO PLANETAS (NOME, CLIMA, TERRENO) VALUES (?, ?, ?)";
    private final String LISTAR_PLANETA = "SELECT * FROM PLANETAS";
    private final String LISTAR_PLANETA_POR_ID = "SELECT * FROM PLANETAS WHERE ID = ?";
    private final String LISTAR_PLANETA_POR_NOME = "SELECT * FROM PLANETAS WHERE NOME = ?";
    private final String REMOVER_PLANETA = "DELETE FROM PLANETAS WHERE ID = ?";

    public List<PlanetasDTO> listarTudo() {
        return jdbcTemplate.query(LISTAR_PLANETA, new Object[]{},(rs, rowNum) -> {
            PlanetasDTO planetasDTO = new PlanetasDTO();
            planetasDTO.setNome(rs.getString("nome"));
            planetasDTO.setClima(rs.getString("clima"));
            planetasDTO.setTerreno(rs.getString("terreno"));
            planetasDTO.setQtdAparicao(swipeService.getPlanets(planetasDTO.getNome()));
            return planetasDTO;
        });
    }

    public List<PlanetasDTO> listarPorId(int id) {
        return jdbcTemplate.query(LISTAR_PLANETA_POR_ID, new Object[]{id},(rs, rowNum) -> {
            PlanetasDTO planetasDTO = new PlanetasDTO();
            planetasDTO.setNome(rs.getString("nome"));
            planetasDTO.setClima(rs.getString("clima"));
            planetasDTO.setTerreno(rs.getString("terreno"));
            planetasDTO.setQtdAparicao(swipeService.getPlanets(planetasDTO.getNome()));
            return planetasDTO;
        });
    }

    public List<PlanetasDTO> listarPorNome(String nome) {
        return jdbcTemplate.query(LISTAR_PLANETA_POR_NOME, new Object[]{nome},(rs, rowNum) -> {
            PlanetasDTO planetasDTO = new PlanetasDTO();
            planetasDTO.setNome(rs.getString("nome"));
            planetasDTO.setClima(rs.getString("clima"));
            planetasDTO.setTerreno(rs.getString("terreno"));
            int id = Integer.parseInt(rs.getString("id"));
            planetasDTO.setQtdAparicao(swipeService.getPlanets(nome));
            return planetasDTO;
        });
    }

    public void adicionarPlaneta(PlanetasDTO planeta) {
        Planetas model = new Planetas();
        model.setNome(planeta.getNome());
        model.setClima(planeta.getClima());
        model.setTerreno(planeta.getTerreno());
        jdbcTemplate.update(ADICIONAR_PLANETA, model.getNome(), model.getClima(), model.getTerreno());
    }

    public void removerPlaneta(int id) {
        jdbcTemplate.update(REMOVER_PLANETA, id);
    }
}
