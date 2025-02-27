import Recursos.Recurso;

import java.util.ArrayList;
import java.util.List;

public class Nave {
    final int POSICAO_INICIAL = 0;
    private int combustivelLitros;
    private int posicao;

    public Nave(int combustivel){
         this.combustivelLitros = combustivel;
         this.posicao = POSICAO_INICIAL;
    }

    public int getQuantidadeDeCombustivel(){
        return this.combustivelLitros;
    }

    public List<Recurso> explorar(Planeta planeta){
        boolean chegouAoDestino = tentarChegarAoDestino(planeta.getPosicao());
        List<Recurso> recursosObtidos = new ArrayList<>();

        if(chegouAoDestino){
            boolean conseguiuRetornar = tentarRetornarAPosicaoInicial();
            if(conseguiuRetornar){
                recursosObtidos.addAll(planeta.getRecursos());
            }
        }

        return recursosObtidos;
    }

    public List<Recurso> explorar(List<Planeta> planetas){
        List<Recurso> recursosObtidos = new ArrayList<>();

        for(Planeta planeta: planetas){
            boolean chegouAoDestino = tentarChegarAoDestino(planeta.getPosicao());
            if(chegouAoDestino){
                recursosObtidos.addAll(planeta.getRecursos());
            } else {
                break;
            }
        }

        boolean conseguiuRetornar = tentarRetornarAPosicaoInicial();
        return conseguiuRetornar ? recursosObtidos : new ArrayList<>();
    }

    private boolean tentarChegarAoDestino(int destino){
        boolean chegouAoDestino = false;

        while (this.combustivelLitros >= 3){
            this.posicao += 1;
            this.combustivelLitros -= 3;

            if(this.posicao == destino){
                chegouAoDestino = true;
                break;
            }
        }

        return chegouAoDestino;
    }

    private boolean tentarRetornarAPosicaoInicial(){
        boolean conseguiuRetornar = false;

        while (this.combustivelLitros >= 3){
            this.posicao -= 1;
            this.combustivelLitros -= 3;

            if(this.posicao == POSICAO_INICIAL){
                conseguiuRetornar = true;
                break;
            }
        }

        return conseguiuRetornar;
    }

    public int getPosicao(){
        return this.posicao;
    }
}
