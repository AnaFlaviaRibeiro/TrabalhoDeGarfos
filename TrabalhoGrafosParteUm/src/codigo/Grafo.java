package codigo;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	public final String nome;
	public ABB<Vertice> vertice;
	public ABB<Aresta> aresta;

	public Grafo(String nome) {
		this.nome = nome;
		this.vertice = new ABB<>();
	}

	/* Método para adicionar vertices 
	 * 
	 */
	public void addVertice(int id) {
		Vertice novo = new Vertice(id);
		this.vertice.add(id, novo);
	}
	/*
	 * Verificar se existe vertice 
	 */
	public Vertice existeVertice(int idVertice) {
		return this.vertice.find(idVertice);
	}
	
	/* 
	 * Método para adicionar arestas
	 */
	public boolean addAresta(int origem, int destino) {
		boolean adicionou = false;
		Vertice saida = this.existeVertice(origem);
		Vertice chegada = this.existeVertice(destino);
		if (saida != null && chegada != null) {
			saida.addAresta(destino);
			chegada.addAresta(origem);
			adicionou = true;
		}

		return adicionou;
	}
	/* 
	 * Método para verificar se existe aresta
	 */
	public boolean existeAresta(int verticeA, int verticeB) {
        var vertice = this.vertice.find(verticeA);
        if (vertice == null)
            return false;

        return vertice
                .getArestas()
                .find(verticeB) != null;
    }
	/* 
	 * Método para checar a quantidade de vertices
	 */
    public int quantidadeDeVertices() {
        return this.vertice.size();
    }
    private static String representacao(int origem, int destino) {
        if (origem < destino)
            return String.format("%d|%d", origem, destino);

        return String.format("%d|%d", destino, origem);
    }
	/* 
	 * Método para checar a quantidade de arestas
	 */
    public int numArestas() {
        Set<String> arestas = new HashSet<>();

        for (var vertice : vertice)
            for (var aresta : vertice.getArestas()) {
                int origem = vertice.getId();
                int destino = aresta.getDestino();
                arestas.add(representacao(origem, destino));
            }

        return arestas.size();
    }
    public boolean completo() {
        int totalArestas = this.numArestas();
        int n = this.vertice.size();

        return (n * (n - 1)) / 2 == totalArestas;
    }


}