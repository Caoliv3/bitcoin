package br.com.alura.repository;

import br.com.alura.adpaters.outbound.OrdemRepository;
import br.com.alura.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class OrdemRepositoryTest {

    @InjectMock
    OrdemRepository ordemRepository;

    @Test
    public void testarListaALLRetornaOrdensCorretas(){
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();
        List<Ordem> ordens = new ArrayList<>();

        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        Mockito.when(ordemRepository.listAll()).thenReturn(ordens);

        Assertions.assertSame(segundaOrdem,ordemRepository.listAll().get(1));

    }
}
