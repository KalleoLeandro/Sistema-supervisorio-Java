package supervisorio.backingbean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import supervisorio.bean.Exibicao;
import supervisorio.bean.TempoLigado;
import supervisorio.controller.TempoLigadoController;
import supervisorio.util.JSFUtil;
import supervisorio.util.Valida;

@ManagedBean(name = "resumeBacking")
@ViewScoped
public class AnualResumeBacking implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private PieChartModel pieModel;
	private String ano;
	private double janeiro=0;
	private double fevereiro=0;
	private double marco=0;
	private double abril=0;
	private double maio=0;
	private double junho=0;
	private double julho=0;
	private double agosto=0;
	private double setembro=0;
	private double outubro=0;
	private double novembro=0;
	private double dezembro=0;
	private double montante=0;
	private boolean render;
	private String preco;
	
	public ArrayList<Exibicao> lista;
	private Exibicao elemento;
	
	private ArrayList<TempoLigado> tempos;
	
	public AnualResumeBacking()
	{
		tempos = new ArrayList<TempoLigado>(new TempoLigadoController().buscarTodos());			
		setRender(false);
		createPieModel();
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public double getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(double janeiro) {
		this.janeiro = janeiro;
	}

	public double getFevereiro() {
		return fevereiro;
	}

	public void setFevereiro(double fevereiro) {
		this.fevereiro = fevereiro;
	}

	public double getMarco() {
		return marco;
	}

	public void setMarco(double marco) {
		this.marco = marco;
	}

	public double getAbril() {
		return abril;
	}

	public void setAbril(double abril) {
		this.abril = abril;
	}

	public double getMaio() {
		return maio;
	}

	public void setMaio(double maio) {
		this.maio = maio;
	}

	public double getJunho() {
		return junho;
	}

	public void setJunho(double junho) {
		this.junho = junho;
	}

	public double getJulho() {
		return julho;
	}

	public void setJulho(double julho) {
		this.julho = julho;
	}

	public double getAgosto() {
		return agosto;
	}

	public void setAgosto(double agosto) {
		this.agosto = agosto;
	}

	public double getSetembro() {
		return setembro;
	}

	public void setSetembro(double setembro) {
		this.setembro = setembro;
	}

	public double getOutubro() {
		return outubro;
	}

	public void setOutubro(double outubro) {
		this.outubro = outubro;
	}

	public double getNovembro() {
		return novembro;
	}

	public void setNovembro(double novembro) {
		this.novembro = novembro;
	}

	public double getDezembro() {
		return dezembro;
	}

	public void setDezembro(double dezembro) {
		this.dezembro = dezembro;
	}

	public double getMontante() {
		return montante;
	}

	public void setMontante(double montante) {
		this.montante = montante;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public ArrayList<TempoLigado> getTempos() {
		return tempos;
	}

	public void setTempos(ArrayList<TempoLigado> tempos) {
		this.tempos = tempos;
	}
	
	public void anoPesquisar()
	{		
			limpaCampos();
			if(Validar())
			{
				for(TempoLigado t: tempos)
				{				
					if(comparaAno(t.getData(),ano))
					{
						if(comparaMes(t.getData(), 1))
						{
							janeiro += t.getTempo();
							montante += t.getTempo();
						}
						else if(comparaMes(t.getData(), 2))
						{
							fevereiro += t.getTempo();
							montante += t.getTempo();
						}
						else if(comparaMes(t.getData(), 3))
						{
							marco += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 4))
						{
							abril += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 5))
						{
							maio += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 6))						
						{							
							junho += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 7))
						{
							julho += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 8))
						{
							agosto += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 9))
						{
							setembro += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 10))
						{
							outubro += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 11))
						{
							novembro += t.getTempo();
							montante += t.getTempo();
						}
						if(comparaMes(t.getData(), 12))
						{
							dezembro += t.getTempo();
							montante += t.getTempo();
						}						
					}
				}
				if(montante > 0)
				{				
					setPieModel();
					setRender(true);
					lista = getListaExibicao();
					
				}
				else
				{
					limpaCampos();
					JSFUtil.addInfoMessage("Resumo Anual", "Não há lançamentos para o ano informado");
					setRender(false);
				}
			}
	}
	
	private void limpaCampos()
	{
		setJaneiro(0);
		setFevereiro(0);
		setMarco(0);
		setAbril(0);
		setMaio(0);
		setJunho(0);
		setJulho(0);
		setAgosto(0);
		setSetembro(0);
		setOutubro(0);
		setNovembro(0);
		setDezembro(0);
		setMontante(0);		
		setLista(null);
	}	
	
	private ArrayList<Exibicao> getListaExibicao()
	{
		lista = new ArrayList<Exibicao>();
		elemento = new Exibicao();
		elemento.setData("Janeiro");
		elemento.setValor((400 * janeiro) /3600000);
		elemento.setCusto((400 * janeiro) /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Fevereiro");
		elemento.setValor((400 * fevereiro) /3600000);
		elemento.setCusto((400 * fevereiro) / 3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Março");
		elemento.setValor((400 * marco) / 3600000);
		elemento.setCusto((400 * marco) / 3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Abril");
		elemento.setValor((400 * abril) /3600000);
		elemento.setCusto((400 * abril) / 3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Maio");
		elemento.setValor((400 * maio) /3600000);
		elemento.setCusto((400 * maio) / 3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Junho");
		elemento.setValor((400 * junho) /3600000);
		elemento.setCusto((400 * junho) / 3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Julho");
		elemento.setValor((400 * julho) /3600000);
		elemento.setCusto((400 * julho) /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Agosto");
		elemento.setValor((400 * agosto) /3600000);
		elemento.setCusto((400 * agosto)  /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Setembro");
		elemento.setValor((400 * setembro) /3600000);
		elemento.setCusto((400 * setembro) /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Outubro");
		elemento.setValor((400 * outubro) /3600000);
		elemento.setCusto((400 * outubro) /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Novembro");
		elemento.setValor((400 * novembro) /3600000);
		elemento.setCusto((400 * novembro) /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();
		elemento.setData("Dezembro");
		elemento.setValor((400 * dezembro) /3600000);
		elemento.setCusto((400 * dezembro) /3600000 * Double.parseDouble(preco));
		lista.add(elemento);
		elemento = new Exibicao();		
		return lista;
	}
	
	public ArrayList<Exibicao> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Exibicao> lista) {
		this.lista = lista;
	}

	private boolean comparaAno(String a, String b) {
		
		try {
			String ano[] = a.split("/");
			if(Integer.parseInt(ano[2]) == Integer.parseInt(b))
			{					
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return false;
	}
	private boolean comparaMes(String a, int b) {
		
		try {
			String mes[] = a.split("/");
			if(Integer.parseInt(mes[1]) == b)
			{				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean Validar()
	{
		if (Valida.isEmptyOrNull(ano) || Valida.isEmptyOrNull(preco)) {
			// exibe uma mensagem de erro
			JSFUtil.addErrorMessage("Resumo Anual", "Favor preencher os campos");
			return false;
		}
		else if (!Valida.isInteger(ano)) {
			// exibe uma mensagem de erro
			JSFUtil.addErrorMessage("Resumo Anual", "O ano deve ser um número inteiro");
			return false;
		}
		else if (Valida.isIntZero(Integer.parseInt(ano))) {
			// exibe uma mensagem de erro
			JSFUtil.addErrorMessage("Resumo Anual", "Ano menor ou igual a zero!");
			return false;
		}		
		else if (!Valida.isDouble(preco)) {
			// exibe uma mensagem de erro
			JSFUtil.addErrorMessage("Resumo Anual", "O preço deve ser um número real!");
			return false;
		}
		else if (Valida.isDoubleZero(Double.parseDouble(preco))) {
			// exibe uma mensagem de erro
			JSFUtil.addErrorMessage("Resumo Anual", "Preço menor ou igual a zero!");
			return false;
		}
		return true;
	}
	
	private void setPieModel()
	{
        pieModel.set("Janeiro", janeiro);
        pieModel.set("Fevereiro", fevereiro);
        pieModel.set("Março", marco);
        pieModel.set("Abril", abril);
        pieModel.set("Maio", maio);
        pieModel.set("Junho", junho);
        pieModel.set("Julho", julho);
        pieModel.set("Agosto", agosto);
        pieModel.set("Setembro", setembro);
        pieModel.set("Outubro", outubro);
        pieModel.set("Novembro", novembro);
        pieModel.set("Dezembro", dezembro);
        pieModel.setTitle("Resumo " + ano);
	}
	
	private void createPieModel() 
	{
        pieModel = new PieChartModel();
 	        
        pieModel.setShadow(true);
    }
}
