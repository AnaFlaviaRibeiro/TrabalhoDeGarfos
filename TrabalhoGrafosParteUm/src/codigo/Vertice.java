package codigo;

public class Vertice {

    private ABB<Aresta> arestas;
    private final int id;
    private boolean visitado;

    public Vertice(int id) {
        this.id = id;
        this.arestas = new ABB<Aresta>();
        this.visitado = false;
    }

    public int getId() {
        return this.id;
    }

    public ABB<Aresta> getArestas() {
        return this.arestas;
    }

    public void addAresta(int destino) {
        this.arestas.add(destino, new Aresta(0, destino));
    }

    public boolean delAresta(int destino) {
        if (this.arestas.find(destino) == null)
            return false;

        this.arestas.remove(destino);
        return true;
    }

    public Aresta existeAresta(int destino) {
        return this.arestas.find(destino);

    }

    public int grau() {
        return this.arestas.size();
    }

    public void visitar() {
        this.visitado = true;
    }

    public void limparVisita() {
        this.visitado = false;
    }

    public boolean visitado() {
        return this.visitado;
    }
}
