import Recursos.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class NaveTest {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        int combustivelEsperado = 1;
        Nave milleniumFalcon = new Nave(10);
        Planeta tatooine = new Planeta(4, new ArrayList<>());

        List<Recurso> recursos = milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        Assert.assertTrue(recursos.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        int valorEsperado = 0;

        Planeta tatooine = new Planeta(4, new ArrayList<>());

        Assert.assertEquals(valorEsperado, tatooine.getValorTotal());
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        int valorEsperado = 210;

        List<Recurso> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());

        Planeta tatooine = new Planeta(4, recursos);

        Assert.assertEquals(valorEsperado, tatooine.getValorTotal());
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        int valorEsperado = 0;

        Planeta tatooine = new Planeta(4, new ArrayList<>());

        Assert.assertEquals(valorEsperado, tatooine.getValorPorPeso());
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        int valorEsperado = 18;

        List<Recurso> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());

        Planeta tatooine = new Planeta(4, recursos);

        Assert.assertEquals(valorEsperado, tatooine.getValorPorPeso());
    }

    @Test
    public void deveRetornarComRecursosSeTiverCombustivel() {
        Nave milleniumFalcon = new Nave(30);

        List<Recurso> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());
        Planeta tatooine = new Planeta(4, recursos);

        List<Recurso> recursosObtidos = milleniumFalcon.explorar(tatooine);

        Assert.assertEquals(recursos, recursosObtidos);
    }

    @Test
    public void deveRetornarComRecursosSeTiverCombustivelParaExplorarMaisDeUmPlaneta() {
        Nave milleniumFalcon = new Nave(50);

        List<Recurso> recursosTatooine = new ArrayList<>();
        recursosTatooine.add(new Agua());
        recursosTatooine.add(new Ferro());
        Planeta tatooine = new Planeta(4, recursosTatooine);

        List<Recurso> recursosJupiter = new ArrayList<>();
        recursosJupiter.add(new Ouro());
        recursosJupiter.add(new Silicio());
        Planeta jupiter = new Planeta(8, recursosJupiter);

        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);
        planetas.add(jupiter);

        List<Recurso> recursosEsperados = new ArrayList<>();
        recursosEsperados.addAll(recursosTatooine);
        recursosEsperados.addAll(recursosJupiter);

        List<Recurso> recursosObtidos = milleniumFalcon.explorar(planetas);

        Assert.assertEquals(recursosEsperados, recursosObtidos);
    }
}
