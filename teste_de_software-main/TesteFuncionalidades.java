import static org.junit.jupiter.api.Assertions.*;

import java.lang.invoke.VarHandle;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

class TesteFuncionalidades {

	
	public Sistema  sistema = new Sistema();
	
	
	
	// REQUISTO FUNCIONAL 1 - CADASTRO DE USUÁRIO
	@Test()
	public void validaUsuario() {
		// cadastro inválido
		assertNull(sistema.cadastraUsuario("", "", ""));
		assertNull(sistema.cadastraUsuario("Lucas Vieira", "lllllllll", "aaaaaaaaaaaaa"));
		assertNull(sistema.cadastraUsuario("Lílian Honório", "111111", "abababababababa"));
		assertNull(sistema.cadastraUsuario("Ialy Sousa", "ialysousa@gmail", "ndndndndnd"));
		
	}
	@Test()
	public void criacaoDoUsuario() {
		//Cadastro válido
		assertNotNull(sistema.cadastraUsuario("Mirna", "mirna@gmail.com", "abcd1234!@#$ABCD"));
	}
	
	// REQUISITO FUNCIONAL 2 - FUNÇÃO DO SEGUNDO GRAU
	@Test()
	public void validaFuncaoSegundoGrau() {
		// Não possui raiz
		assertNull(sistema.calculaFuncaoSegundoGrau(1, 1, 1)); // não possui raiz
		assertNull(sistema.calculaFuncaoSegundoGrau(1, 2, 15)); // não possui raiz
		assertNull(sistema.calculaFuncaoSegundoGrau(-1, -2, -3));
	}
	
	@Test()
	public void funcaoSegundoGrau() {
		var resposta = sistema.calculaFuncaoSegundoGrau(1, 2, -15);
		assertNotNull(resposta);
	}
	
	//REQUISITO FUNCIONAL 3 - É TRIANGULO
	
	@Test()
	public void ehTriangulo() {
        assertFalse(sistema.ehTriangulo(0, 0, 0)); // NÃO É TRIANGULO - ZERO
        assertFalse(sistema.ehTriangulo(-1, -1, -1)); // NÃO É TRIANGULO - MENOR QUE ZERO
        assertFalse(sistema.ehTriangulo(180, 180, 180)); // NÃO É TRIANGULO - EXTREMOS
        
        assertFalse(sistema.ehTriangulo(0, 0, 180)); // NÃO É TRIANGULO 
        assertFalse(sistema.ehTriangulo(180, 0, 0)); // NÃO É TRIANGULO 
        assertFalse(sistema.ehTriangulo(0, 180, 0)); // NÃO É TRIANGULO 
        
        assertTrue(sistema.ehTriangulo(50, 80, 50)); // É TRIANGULO
        assertTrue(sistema.ehTriangulo(20, 10, 150)); // É TRIANGULO
        assertTrue(sistema.ehTriangulo(1, 79, 100)); // É TRIANGULO
	}
	
	@Test()
	public void classificaTriangulo() {
		var mensagemDeErro = "sem classificação";
		assertEquals(sistema.classificaTriangulo(0, 0, 0), mensagemDeErro);
		assertEquals(sistema.classificaTriangulo(180, 180, 180), mensagemDeErro);
		assertEquals(sistema.classificaTriangulo(-1, -1, -1), mensagemDeErro);
		
		assertTrue(sistema.classificaTriangulo(90, 45, 45).contains("retângulo"));
        assertTrue(sistema.classificaTriangulo(70, 70, 40).contains("acutângulo"));
        assertTrue(sistema.classificaTriangulo(100, 40, 40).contains("obtusângulo"));
		
		
	}
	
	@Test()
    public void ehTrianguloRetangulo() {
        assertFalse(sistema.ehTrianguloRetangulo(0, 0, 0));
        assertFalse(sistema.ehTrianguloRetangulo(10, 5, 5));
        assertTrue(sistema.ehTrianguloRetangulo(10, 8, 6));
	}
	
	@Test()
    public void ehRetangulo() {
        assertTrue(sistema.ehRetangulo(90, 90, 90, 90));
        assertFalse(sistema.ehRetangulo(0, -10, 1233123123, 331293));
	}
	
    @Test()
    public void perimetroRetangulo() {
        assertNotNull(sistema.perimetroRetangulo(200, 19));
        assertNotNull(sistema.perimetroRetangulo(-100, -10000.123));
    }

    @Test()
    public void areaRetangulo() {
        assertNotNull(sistema.areaRetangulo(12, 12));
        assertNotNull(sistema.areaRetangulo(-10, -1000));
    }

    @Test()
    public void validacaoCalculadora() {
        assertEquals(sistema.calculadora("bola + caixa"), "Insira uma expressão válida");
        assertEquals(sistema.calculadora("123 + caixa"), "Insira uma expressão válida");
        assertEquals(sistema.calculadora("caixa+123"), "Insira uma expressão válida");
        assertEquals(sistema.calculadora("1 mais 2"), "expressão invalida, insira uma expressão correta"); //?
        // Estouro matemático
        assertThrows(AssertionFailedError.class, () -> {
            assertEquals(sistema.calculadora("1000000000000000000000000 + 1"), "1000000000000000000000001.00");
        });
    }

    @Test()
    public void calculadora() {
        assertEquals(sistema.calculadora("1 + 1"), "2");
        assertEquals(sistema.calculadora("1 / 0"),"∞");
        assertEquals(sistema.calculadora("1 + 0"), "1.00");
        assertEquals(sistema.calculadora("1 * 0"), "0.00");
        assertEquals(sistema.calculadora("1 + -20"), "-19.00");
        assertEquals(sistema.calculadora("1 / 2"), "0.50");
        assertEquals(sistema.calculadora("0000000 - 2"), "-2.00");
        assertEquals(sistema.calculadora("0000000.1 - 0"), "0.10");
        assertEquals(sistema.calculadora("2 ** 2"), "4.00");
        assertEquals(sistema.calculadora("1000000000 - 1"), "999999999.00");
    }

    @Test
    public void areaCirculo() {
        assertEquals(sistema.areaCirculo(10), 314.1592653589793);
        assertEquals(sistema.areaCirculo(0), 0);
    }

    @Test
    public void perimetroCirculo() {
        // talvez truncar o resultado em menos casas decimais
        assertEquals(sistema.perimetroCirculo(10), 62.83185307179586);
        assertEquals(sistema.perimetroCirculo(0), 0);
    }

    @Test
    public void distanciaEntreDoisPontos() {
        assertEquals(sistema.distanciaEntreDoisPontos(0, 0, 0, 10), 10);
        assertEquals(sistema.distanciaEntreDoisPontos(0, 0, 100, 0), 100);
        assertEquals(sistema.distanciaEntreDoisPontos(0, 0, 90000000, 0), 90000000);
    }

}
