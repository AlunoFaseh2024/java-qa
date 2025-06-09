package com.cleberleao.oficina.springboot.service;

import com.cleberleao.oficina.springboot.entity.User;
import com.cleberleao.oficina.springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException; // Adicione esta linha

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void criar_DeveSalvarUsuarioComSenhaCriptografada() {
        User user = new User(null, "João", "joao@email.com", "123456");

        when(repository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            assertNotEquals("123456", savedUser.getPassword());
            assertTrue(passwordEncoder.matches("123456", savedUser.getPassword()));
            return savedUser;
        });

        User saved = userService.criar(user);

        assertEquals("joao@email.com", saved.getEmail());
        verify(repository).save(any(User.class));
    }

    @Test
    void alterar_DeveAtualizarDadosSemCriptografarNovaSenha() {
        User userToUpdate = new User(1L, "Novo Nome", "novo@email.com", "novaSenha");
        User existingUserInDb = new User(1L, "Antigo", "antigo@email.com", passwordEncoder.encode("antigaSenha"));

        when(repository.findById(1L)).thenReturn(Optional.of(existingUserInDb));
        when(repository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User updated = userService.alterar(userToUpdate);

        assertEquals("novo@email.com", updated.getEmail());
        assertEquals("Novo Nome", updated.getNome());
        assertEquals("novaSenha", updated.getPassword());
        verify(repository).save(any(User.class));
    }

    @Test
    void apagar_DeveRemoverUsuarioExistente() {
        User user = new User(1L, "Nome", "email", "senha");

        when(repository.findById(1L)).thenReturn(Optional.of(user));
        doNothing().when(repository).delete(user);

        User apagado = userService.apagar(1L);

        assertEquals(1L, apagado.getId());
        verify(repository).delete(user);
    }

    @Test
    void apagar_DeveLancarExcecao_SeNaoEncontrar() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.apagar(99L));
    }

    @Test
    void buscarUsuario_DeveRetornarUsuario() {
        User user = new User(2L, "Nome", "email", "senha");

        when(repository.findById(2L)).thenReturn(Optional.of(user));

        User resultado = userService.buscarUsuario(2L);

        assertEquals("email", resultado.getEmail());
    }

    @Test
    void buscarUsuario_DeveLancarExcecao_SeNaoEncontrar() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.buscarUsuario(999L));
    }

    @Test
    void buscarTodos_DeveRetornarLista() {
        User u1 = new User(1L, "Um", "um@email.com", "senha");
        User u2 = new User(2L, "Dois", "dois@email.com", "senha");
        when(repository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<User> lista = userService.buscarTodos();

        assertEquals(2, lista.size());
        assertEquals("Um", lista.get(0).getNome());
    }

    @Test
    void buscarTodos_DeveRetornarListaVazia() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<User> lista = userService.buscarTodos();

        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }
}