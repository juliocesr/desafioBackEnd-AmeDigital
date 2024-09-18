package api.Service;

import api.DTO.PlanetasDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwipeService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public SwipeService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }
    public int getPlanets(String nome) {
        String url = "https://swapi.dev/api/planets/?search=" + nome;
        String resposta = restTemplate.getForObject(url, String.class);
        try {
            JsonNode root = objectMapper.readTree(resposta);
            JsonNode planetasArray = root.path("results");
            if (planetasArray.size() > 0) {
                JsonNode planeta = planetasArray.get(0);
                return planeta.path("films").size();
            }
            int filmes = planetasArray.size();
            return filmes;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
