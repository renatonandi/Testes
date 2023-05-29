package repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import enums.EnumSexo;
import models.Pessoa;

public class BancoDadosTest {
   
    private BancoDados bd = new BancoDados();
    
    @BeforeEach
    void intit() {
        bd.clearData();
        Pessoa p1 = new Pessoa("Pessoa 1", 10, EnumSexo.MASCULINO);
        Pessoa p2 = new Pessoa("Pessoa 2", 15, EnumSexo.FEMININO);
        Pessoa p3 = new Pessoa("Pessoa 3", 20, EnumSexo.MASCULINO);
        Pessoa p4 = new Pessoa("Pessoa 4", 25, EnumSexo.FEMININO);
        bd.add(p1);
        bd.add(p2);
        bd.add(p3);
        bd.add(p4);
        
    }
    
    @Test
    @DisplayName("Testa método buscar por ID")    
    void findByIdTest() {
        List<Pessoa> cad = bd.listAll();
        bd.findById(4);
        assertEquals(4, cad.get(3).getId());
    }
    @Test
    @DisplayName("Testa método buscar por ID passando valor inválido")
    void findByIdNullTest() {
        List<Pessoa> cad = bd.listAll();
        bd.findById(5);
        assertTrue(cad.size() < 5);
        
    }
    
    @Test
    @DisplayName("Testa listar todos")    
    void listAllTest() {
        List<Pessoa> cad = bd.listAll();
        assertEquals(4, cad.size());
        assertEquals("Pessoa 1", cad.get(0).getNome());
        bd.add(new Pessoa("Pesosa 5", 30, EnumSexo.MASCULINO));
        cad = bd.listAll();
        assertEquals(5, cad.size());
        assertEquals(5, cad.get(4).getId());
    }
    @Test
    @DisplayName("Teste buscar por sexo")
    void findBySexoTest() {
        List<Pessoa> cad = bd.findBySexo(EnumSexo.FEMININO);
        assertEquals(2, cad.size());
    }
    @Test
    @DisplayName("Teste buscar por idade entre")
    void findByIdadeBetweenTest() {
        List<Pessoa> cad = bd.findByIdadeBetween(9, 21);
        assertEquals(3, cad.size());
    }
    
    

}
