
public class ArvoreBinariaBuilder {

	private ArvoreBinariaBusca arvore;

	public ArvoreBinariaBusca montaArvoreVazia() {
		this.arvore = new ArvoreBinariaBusca();
		return this.arvore;
	}

	public ArvoreBinariaBusca montaArvoreSoRaiz() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreUmFilhoDireito() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(7);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreUmFilhoEsquerdo() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(3);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreDoisFilhos() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(7);
		arvore.adicionarNo(3);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreUmDireitoDoisEsquerdos() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(7);
		arvore.adicionarNo(3);
		arvore.adicionarNo(1);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreDoisDireitoUmEsquerdos() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(7);
		arvore.adicionarNo(8);
		arvore.adicionarNo(3);

		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreDoisDireitoDoisEsquerdos() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(7);
		arvore.adicionarNo(8);
		arvore.adicionarNo(3);
		arvore.adicionarNo(1);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreCheia() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionarNo(5);
		arvore.adicionarNo(7);
		arvore.adicionarNo(8);
		arvore.adicionarNo(3);
		arvore.adicionarNo(4);
		arvore.adicionarNo(1);

		return arvore;
	}

}
