package api.DTO;

public class RespostaPadraoDTO {
    private String mensagem;

    public RespostaPadraoDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
