package model;

import java.util.ArrayList;
import java.util.List;

public class Operacao {
	
	private enum TipoComando{
		ZERAR,NUMERO,DIVIDIR,PONTO,MULTIPLICAR,SOMAR,SUBTRAIR,IGUAL;
	}
	
	private static final Operacao instanca =new Operacao();
	private String textoAtual="";
	private String textoBuffers="";
	private boolean substituir=false;
	private final List<Observador> observadores = new ArrayList<>();
	private TipoComando ultimoComando=null;
	
	public Operacao() {}

	public static Operacao getInstanca() {
		return instanca;
	}
	
	public void adicionarObservador(Observador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty()? "0" : textoAtual;
	}
	
	public void processaComando(String texto) {
		TipoComando tipoComando = detectaComando(texto);
		if(tipoComando==null) {
			return;
		}else if(tipoComando==TipoComando.ZERAR) {
			textoAtual="";
		}else if(tipoComando==TipoComando.NUMERO || tipoComando==TipoComando.PONTO){
			textoAtual = substituir ?texto :textoAtual+texto;
			substituir = false;
		}else {
			substituir=true;
			textoAtual=obterResultadoOpercao();
			textoBuffers =textoAtual;
			ultimoComando=tipoComando;
		}
		
		observadores.forEach(o->o.valorAlterado(getTextoAtual()));
	}

	private String obterResultadoOpercao() {
		if(ultimoComando==null ||ultimoComando==TipoComando.IGUAL) {
			return textoAtual;
		}
		
		double numeroBuffer = Double.parseDouble(textoBuffers);
		double numeroAtual= Double.parseDouble(textoAtual);
		
		double resultado = 0;
		
		if(ultimoComando== TipoComando.SOMAR) {
			resultado = numeroBuffer + numeroAtual;
		}else if(ultimoComando == TipoComando.SUBTRAIR) {
			resultado = numeroBuffer - numeroAtual;
		}else if(ultimoComando == TipoComando.MULTIPLICAR) {
			resultado = numeroBuffer * numeroAtual;
		}else if(ultimoComando == TipoComando.DIVIDIR) {
			resultado = numeroBuffer / numeroAtual;
		}
		
		String resultadoString = Double.toString(resultado);
		boolean inteiro = resultadoString.endsWith(".0");
		return inteiro ? resultadoString.replace(".0", "") : resultadoString;
		
	}

	private TipoComando detectaComando(String texto) {
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			if(texto.equals("AC")) {
				return TipoComando.ZERAR;
			}else if(texto.equals("+")) {
				return TipoComando.SOMAR;
			}else if(texto.equals("-")) {
				return TipoComando.SUBTRAIR;
			}else if(texto.equals("*")) {
				return TipoComando.MULTIPLICAR;
			}else if(texto.equals("/")) {
				return TipoComando.DIVIDIR;
			}else if(texto.equals("=")) {
				return TipoComando.IGUAL;
			}else if(texto.equals(".")&& !textoAtual.contains(".")) {
				return TipoComando.PONTO;
			}
		}
		return null;
		
	}

	
}
