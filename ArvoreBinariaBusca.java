
public class ArvoreBinariaBusca {

	private No raiz;
	static final int COUNT = 5;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int quantidadeSubNos(No noRef) {
		if (noRef == null) {
			return 0;
		} else {
			return quantidadeSubNos(noRef.getEsquerdo()) + 1 + quantidadeSubNos(noRef.getDireito());
		}
	}

	public int quantidadeNosArvore() {
		return quantidadeSubNos(raiz);
	}

	public int altura(No noRef) {
		if (ehVazia()) {
			return 0;
		} else {
			return percorreAltura(noRef) - 1;
		}
	}

	private int percorreAltura(No noRef) {
		if (noRef == null) {
			return 0;
		}
		int alturaDireita = percorreAltura(noRef.getDireito());
		int alturaEsquerda = percorreAltura(noRef.getEsquerdo());

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int alturaArvore() {
		return altura(raiz);
	}

	public int profundidade(No noRef) {

		if (ehVazia()) {
			return 0;
		} else {
			return percorreProfundidade(raiz, noRef) - 1;
		}
	}

	private int percorreProfundidade(No noRef, No noBuscado) {
		if (noRef == null) {
			return 0;
		} else {
			if (noBuscado.getValor() == noRef.getValor()) {
				return 1;
			}

			if (noBuscado.getValor() < noRef.getValor()) {
				return 1 + percorreProfundidade(noRef.getEsquerdo(), noBuscado);
			} else {
				return 1 + percorreProfundidade(noRef.getDireito(), noBuscado);
			}
		}
	}

	private No percorreBuscaArvore(No noRef, int valorBuscado) {

		if (noRef == null) {
			return null;
		}

		if (valorBuscado == noRef.getValor()) {
			return noRef;
		}

		if (valorBuscado < noRef.getValor()) {
			return percorreBuscaArvore(noRef.getEsquerdo(), valorBuscado);
		} else {
			return percorreBuscaArvore(noRef.getDireito(), valorBuscado);
		}
	}

	public No pegarNoArvore(int valorBuscado) {

		return percorreBuscaArvore(raiz, valorBuscado);
	}

	public boolean contem(int valorBuscado) {
		if (percorreBuscaArvore(raiz, valorBuscado) != null) {
			return true;
		}
		return false;
	}

	private void print2DUtil(No noRef, int space) {
		if (noRef == null) {
			return;
		}
		space += COUNT;
		print2DUtil(noRef.getDireito(), space);

		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(noRef.getValor() + "\n");

		print2DUtil(noRef.getEsquerdo(), space);
	}

	public void imprimir2DArvore() {
		print2DUtil(raiz, 0);
	}

	public void adicionarNo(int valorAdicionado) {
		if (ehVazia()) {
			raiz = new No(valorAdicionado, null, null);
		} else {
			percorreInsereArvore(raiz, valorAdicionado);
		}
	}

	private void percorreInsereArvore(No noRef, int valorAdicionado) {
		if (noRef != null) {
			if (valorAdicionado < noRef.getValor()) {
				if (noRef.getEsquerdo() == null) {
					No novoNo = new No(valorAdicionado, null, null);
					noRef.setEsquerdo(novoNo);
				} else {
					percorreInsereArvore(noRef.getEsquerdo(), valorAdicionado);
				}
			} else {
				if (noRef.getDireito() == null) {
					No novoNo = new No(valorAdicionado, null, null);
					noRef.setDireito(novoNo);
				} else {
					percorreInsereArvore(noRef.getDireito(), valorAdicionado);
				}
			}
		}
	}

	public void remover(int valorRemover) {

		if (ehVazia()) {
			throw new IllegalArgumentException("arvore vazia");
		} else {
			raiz = percorreRemoveArvore(raiz, valorRemover);
		}
	}

	private boolean somenteFilhoDireita(No noRef) {
		return (noRef.getDireito() != null && noRef.getEsquerdo() == null);
	}

	private boolean somenteFilhoEsquerda(No noRef) {
		return (noRef.getEsquerdo() != null && noRef.getDireito() == null);
	}
	
	private int pegaMenorValor (No noRef) {
		if ( noRef.getEsquerdo() == null) {
			return noRef.getValor();
		}
		else {
			return pegaMenorValor(noRef.getEsquerdo());
		}
	}

	private No percorreRemoveArvore(No noRef, int valorRemover) {
		if (noRef == null) {
			return null;
		} else {
			if (noRef.getValor() == valorRemover) {
				if (noRef.ehFolha()) {
					return null;
				} else if (somenteFilhoDireita(noRef)) {
					return noRef.getDireito();
				} else if (somenteFilhoEsquerda(noRef)) {
					return noRef.getEsquerdo();
				} else {
					int menorValor = pegaMenorValor(noRef.getDireito());
					noRef.setValor(menorValor);
					noRef.setDireito(percorreRemoveArvore(noRef.getDireito(), menorValor));
				}
			}
			if (valorRemover < noRef.getValor()) {
				noRef.setEsquerdo(percorreRemoveArvore(noRef.getEsquerdo(), valorRemover));
				return noRef;
			} else {
				noRef.setDireito(percorreRemoveArvore(noRef.getDireito(), valorRemover));
				return noRef;
			}
		}
	}

}
