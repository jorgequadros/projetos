package model;
@FunctionalInterface
public interface Observador {
	public void valorAlterado(String novoValor);
}
