package salárioprofessorfaculdade;

public class Categoria {

    private String nomeCategoria;

    private float valorHora;

    public Categoria(String nomeCategoria, float valorHora) {
        this.nomeCategoria = nomeCategoria;
        this.valorHora = valorHora;
    }

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }
    
    public float reajuste(float reajuste){
        valorHora = reajuste;
        return valorHora;
    }
    
    public float valorHora(){
        return valorHora;
    }
}
