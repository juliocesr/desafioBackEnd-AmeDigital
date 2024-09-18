package api.DTO;

public class PlanetasDTO {
    String nome;
    String clima;
    String terreno;
    int qtdAparicao;

    public PlanetasDTO() {}

    public PlanetasDTO(String nome, String clima, String terreno, int qtdAparicao) {
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
        this.qtdAparicao = qtdAparicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getQtdAparicao() {
        return qtdAparicao;
    }

    public void setQtdAparicao(int qtdAparicao) {
        this.qtdAparicao = qtdAparicao;
    }
}
