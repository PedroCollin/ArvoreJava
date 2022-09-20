
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore;
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializaArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	void deveRetornarVerdadeiroEhVazia() {
		arvore = builder.montaArvoreVazia();

		assertTrue(arvore.ehVazia());
	}

	@Test
	void deveRetornarFalsoEhVazia() {
		arvore = builder.montaArvoreSoRaiz();

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.quantidadeSubNos(arvore.getRaiz()));
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.quantidadeSubNos(arvore.getRaiz()));
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreUmFilhoDireito();
		assertEquals(2, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		assertEquals(2, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisFilhos();
		assertEquals(3, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		assertEquals(4, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		assertEquals(4, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		assertEquals(5, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreCheia();
		assertEquals(6, arvore.quantidadeSubNos(arvore.getRaiz()));

	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.altura(arvore.getRaiz()));
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.altura(arvore.getRaiz()));
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreUmFilhoDireito();
		assertEquals(1, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		assertEquals(1, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisFilhos();
		assertEquals(1, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreCheia();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

	}
	
	
	@Test
	void inserirNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(5);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(5));
		assertNull(arvore.getRaiz().getDireito());
		assertNull(arvore.getRaiz().getEsquerdo());
	}
	
	@Test
	void inserirNoArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		
		arvore.adicionarNo(7);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(7));
		assertTrue(arvore.pegarNoArvore(7).ehFolha());

	}
	
	
	@Test
	void inserirNoArvoreComElementosSoFilhoDireito() {
		
		arvore = builder.montaArvoreUmFilhoDireito();
		arvore.adicionarNo(3);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(3));
		assertTrue(arvore.pegarNoArvore(3).ehFolha());
		assertEquals(3, arvore.quantidadeNosArvore());
		
	}
	
	@Test
	void inserirNoArvoreComElementosSoFilhoEsquerdo() {
		
		arvore = builder.montaArvoreUmFilhoEsquerdo();
		arvore.adicionarNo(7);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(7));
		assertTrue(arvore.pegarNoArvore(7).ehFolha());
		assertEquals(3, arvore.quantidadeNosArvore());
	}
	
	@Test
	void inserirNoArvoreComElementosDoisFilhosDireitoEsquerdo() {
		arvore = builder.montaArvoreCheia();
		
		arvore.adicionarNo(10);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(10));
		assertTrue(arvore.pegarNoArvore(10).ehFolha());
		assertEquals(7, arvore.quantidadeNosArvore());
		assertEquals(3, arvore.alturaArvore());
		
	}
	
	@Test
	void exclusaoEhVazia() {
		arvore = builder.montaArvoreVazia();
		assertThrows(IllegalArgumentException.class, () -> arvore.remover(1));
	}
	
	@Test
	void exclusao…raiz() {
		arvore = builder.montaArvoreSoRaiz();
		arvore.remover(5);
		assertTrue(arvore.ehVazia());
	}
	
	@Test
	void exclusaoHaveElemments() {
		arvore = builder.montaArvoreUmFilhoDireito();
		arvore.remover(7);
		assertEquals(1, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreUmFilhoEsquerdo();
		arvore.remover(3);
		assertEquals(1, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreDoisFilhos();
		arvore.remover(3);
		assertEquals(2, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		arvore.remover(1);
		assertEquals(3, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		arvore.remover(3);
		assertEquals(3, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		arvore.remover(1);
		assertEquals(4, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreCheia();
		arvore.remover(1);
		assertEquals(5, arvore.quantidadeNosArvore());
		
		
	}
	
	
	
	
	

}
