package codigo;

public class GrafoMatriz extends Grafo {

	public GrafoMatriz(String nome) {
		super(nome);
	}
	
	public void GrafoMatrizAdj() {
		for (int i = 1; i <= vertice.size(); i++)
			System.out.printf("%d ", i);

		for (int i = 1; i <= vertice.size(); i++)
			System.out.printf("--");

		System.out.printf("---\n");

		for (int i = 0; i < vertice.size(); i++) {
			for (int j = 0; j < vertice.size(); j++) {
				var resultado = this.existeAresta(i, j) ? 1 : 0;
				var space = j == vertice.size() - 1 ? String.format(" | %d", i + 1) : " ";
				System.out.printf("%d%s", resultado, space);
			}
			System.out.println();
		}
	}
}