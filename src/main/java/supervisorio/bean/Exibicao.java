/**
 * 
 */
package supervisorio.bean;

/**
 * Programa
 * @author Kalleo Leandro dos Santos Leal
 * @since
 * @version
 */
public class Exibicao 
{	
	private String data;
	private double valor;
	private double custo;
	
	public Exibicao()
	{
		
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
}
