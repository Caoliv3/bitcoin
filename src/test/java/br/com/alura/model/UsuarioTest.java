package br.com.alura.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
public class UsuarioTest {

    @Test
    public void testarFindByIdOptionalRetornaUsuarioCorreto(){
        PanacheMock.mock(Usuario.class);

        Usuario user = new Usuario();
        Optional<PanacheEntityBase> usuario = Optional.of(user);

        Mockito.when(Usuario.findByIdOptional(12)).thenReturn(usuario);

        Assertions.assertSame(user, Usuario.findByIdOptional(12).get());
    }

}
