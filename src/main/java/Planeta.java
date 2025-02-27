import Recursos.Recurso;
import java.util.List;

public class Planeta {
    private int posicao;
    private List<Recurso> recursos;

    public Planeta(int posicao, List<Recurso> recursos){
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int getValorTotal(){
        int valorTotal = 0;
        for(Recurso recurso: recursos){
            valorTotal += recurso.getValor();
        }

        return valorTotal;
    }

    public int getValorPorPeso(){
        int valorPorPeso = 0;
        for(Recurso recurso: recursos){
            valorPorPeso += recurso.getValor() / recurso.getPeso();
        }

        return valorPorPeso;
    }

    public int getPosicao(){
        return this.posicao;
    }

    public List<Recurso> getRecursos(){
        return this.recursos;
    }
}
