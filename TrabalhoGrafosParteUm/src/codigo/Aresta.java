package codigo;

public class Aresta {
    private int peso;
    private int destino;
    private boolean visitada;
   
    public Aresta() {
    }
    public Aresta(int peso, int destino) {
        this.peso = peso;
        this.destino = destino;
        this.visitada = false;
    }
	public int getPeso() {
		return this.peso;
	}
	public int getDestino() {
		return this.destino;
	}

	public boolean isVisitada() {
		return this.visitada;
	}
    public void limparVisita() {
        this.visitada = false;
    }
    public void visitar() {
        this.visitada = true;
    }
    public boolean add(int destino, Aresta aresta) {
        return false;
    }
}
