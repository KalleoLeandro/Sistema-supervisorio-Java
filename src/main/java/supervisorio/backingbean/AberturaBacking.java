

package supervisorio.backingbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fazecast.jSerialComm.*;

import supervisorio.bean.Lampadas;
import supervisorio.bean.TempoLigado;
import supervisorio.controller.TempoLigadoController;



@ManagedBean(name = "aberturaBacking")
@SessionScoped
public class AberturaBacking implements Serializable 
{
	private static final long serialVersionUID = 1L;	
	
	public static SerialPort firstAvailableComPort;	
	
	private Lampadas lampada;
	
	private TempoLigado tempo;
	
	final AtomicBoolean terminate = new AtomicBoolean(false);
	
	private boolean lampada1Status= false;
	private boolean lampada2Status= false;
	private boolean lampada3Status= false;
	private boolean lampada4Status= false;
	
	private Date ligar1;
	private Date ligar2;
	private Date ligar3;
	private Date ligar4;
	
	private Date dataGravacao;
	
	//
		
	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	private String lampada1="";
	private String lampada2="";
	private String lampada3="";
	private String lampada4="";
	
	public String cor1="black";
	public String cor2="black";
	public String cor3="black";
	public String cor4="black";
	
	public boolean alerta = false;
		
	public Lampadas getLampada() {
		return lampada;
	}

	public void setLampada(Lampadas lampada) {
		this.lampada = lampada;
	}

	public boolean isLampada1Status() {
		return lampada1Status;
	}

	public boolean isAlerta() {
		return alerta;
	}

	public void setAlerta(boolean alerta) {
		this.alerta = alerta;
	}

	public Date getLigar1() {
		return ligar1;
	}

	public void setLigar1(Date ligar1) {
		this.ligar1 = ligar1;
	}

	public Date getLigar2() {
		return ligar2;
	}

	public void setLigar2(Date ligar2) {
		this.ligar2 = ligar2;
	}

	public Date getLigar3() {
		return ligar3;
	}

	public void setLigar3(Date ligar3) {
		this.ligar3 = ligar3;
	}

	public Date getLigar4() {
		return ligar4;
	}

	public void setLigar4(Date ligar4) {
		this.ligar4 = ligar4;
	}

	public void setLampada1Status(boolean lampada1Status) {
		this.lampada1Status = lampada1Status;
	}

	public boolean isLampada2Status() {
		return lampada2Status;
	}

	public void setLampada2Status(boolean lampada2Status) {
		this.lampada2Status = lampada2Status;
	}

	public boolean isLampada3Status() {
		return lampada3Status;
	}

	public void setLampada3Status(boolean lampada3Status) {
		this.lampada3Status = lampada3Status;
	}

	public boolean isLampada4Status() {
		return lampada4Status;
	}

	public void setLampada4Status(boolean lampada4Status) {
		this.lampada4Status = lampada4Status;
	}

	public String getLampada1() {
		return lampada1;
	}

	public void setLampada1(String lampada1) {
		this.lampada1 = lampada1;
	}

	public String getLampada2() {
		return lampada2;
	}

	public void setLampada2(String lampada2) {
		this.lampada2 = lampada2;
	}

	public String getLampada3() {
		return lampada3;
	}

	public void setLampada3(String lampada3) {
		this.lampada3 = lampada3;
	}

	public String getLampada4() {
		return lampada4;
	}

	public void setLampada4(String lampada4) {
		this.lampada4 = lampada4;
	}

	public boolean logado;
	
	
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}


	public String getCor1() {
		return cor1;
	}

	public void setCor1(String cor1) {
		this.cor1 = cor1;
	}

	public String getCor2() {
		return cor2;
	}

	public void setCor2(String cor2) {
		this.cor2 = cor2;
	}

	public String getCor3() {
		return cor3;
	}

	public void setCor3(String cor3) {
		this.cor3 = cor3;
	}

	public String getCor4() {
		return cor4;
	}

	public void setCor4(String cor4) {
		this.cor4 = cor4;
	}

	public ArrayList<Lampadas> getListaLampadas() {
		return listaLampadas;
	}

	public void setListaLampadas(ArrayList<Lampadas> listaLampadas) {
		this.listaLampadas = listaLampadas;
	}

	public ArrayList<Lampadas> listaLampadas;
	
	//Função de Controle de funcionamento do sistema
	public void abertura()
	{		
		if(!logado)
		{	
			logado = true;
			try 
			{	
				terminate.set(false);
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");				
				new Thread(r,"T").start();			
			}
			catch (Exception e) 
			{							
				e.printStackTrace();
			}
		}
		else
		{
			logado = false;	
			try 
			{				
				firstAvailableComPort.closePort();				
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");				
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
		}
	}	
	
	//Função para gravar no Banco de Dados o tempo ligado de uma lampada
	public void gravarLampada(int numLamp, Date dataLigado) {

		
		try 
		{
			tempo = new TempoLigado();
			dataGravacao = new Date();
			int seconds = (int) ((dataGravacao.getTime() - dataLigado.getTime())/1000);
			System.out.println(seconds);
			String data = getDateToString(dataGravacao);
			lampada = new Lampadas();
			lampada.setIdLampadas(numLamp);
			tempo.setLampadasidLampadas(lampada);
			tempo.setTempo(seconds);			
			tempo.setData(data);
			new TempoLigadoController().salvar(tempo);			
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}
	}
	
	private String getDateToString(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(data);
	}
		
	//Thread de comunicação com Arduino
	Runnable r = new Runnable() 
	{		  
		   @Override
		   public void run() 
		   {
			   try
			   {
				   while(!terminate.get())
				   {
					   //Procura portas seriais e com nome Arduino
					    SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();
					    
					    for(SerialPort eachComPort:allAvailableComPorts)
					    {
					    	if(eachComPort.getDescriptivePortName().contains("Arduino"))
					    	{
					    		firstAvailableComPort = eachComPort;
					    	}
					    }
					    
					    firstAvailableComPort.setBaudRate(9600);

					    //Abrindo a porta de comunicação serial
					    
					    firstAvailableComPort.openPort();			    
					
					    			    
					    System.out.println("Porta Serial aberta em: " + firstAvailableComPort.getDescriptivePortName());		    
					    			    
					    firstAvailableComPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);			    
					    
						Scanner data = new Scanner(firstAvailableComPort.getInputStream());
						String texto = "";		
						
						while(data.hasNextLine() && logado)
						{
								/*Este loop fica recebendo as informações do arduino em texto e faz os testes lógicos para exibição
								  dos valores em tela
								*/
								texto = data.nextLine();
								String array[] = texto.split("-");			
								if(array[0].equals("1") && (array[1].equals("Ligado") || array[1].equals("Desligado")))
								{						
									lampada1 = array[1];									
									
									if(array[1].equals("Ligado"))
									{
										cor1="#00FF00";
										if(lampada1Status == false)
										{
											lampada1Status = true;
											ligar1 = new Date();
											
										}										
									}
									else if(array[1].equals("Desligado"))
									{
										cor1="#FF0000";
										if(lampada1Status == true)
										{
											gravarLampada(1,ligar1);
											lampada1Status = false;
										}
									}
								}
								else if(array[0].equals("2") && (array[1].equals("Ligado") || array[1].equals("Desligado")))
								{
									lampada2 = array[1];
									
									if(array[1].equals("Ligado"))
									{
										cor2="#00FF00";
										if(lampada2Status == false)
										{
											lampada2Status = true;
											ligar2 = new Date();
											
										}
									}
									else if(array[1].equals("Desligado"))
									{
										cor2="#FF0000";
										if(lampada2Status == true)
										{
											gravarLampada(2,ligar2);
											lampada2Status = false;
										}
									}
								}
								else if(array[0].equals("3") && (array[1].equals("Ligado") || array[1].equals("Desligado")))
								{
									lampada3 = array[1];
									
									if(array[1].equals("Ligado"))
									{
										cor3="#00FF00";
										if(lampada3Status == false)
										{
											lampada3Status = true;
											ligar3 = new Date();
											
										}
									}
									else if(array[1].equals("Desligado"))
									{
										cor3="#FF0000";
										if(lampada3Status == true)
										{
											gravarLampada(3,ligar3);
											lampada3Status = false;
										}
									}
								}
								else if(array[0].equals("4") && (array[1].equals("Ligado") || array[1].equals("Desligado")))
								{
									lampada4 = array[1];
									
									if(array[1].equals("Ligado"))
									{
										cor4="#00FF00";
										if(lampada4Status == false)
										{
											lampada4Status = true;
											ligar4 = new Date();
											
										}
									}
									else if(array[1].equals("Desligado"))
									{
										cor4="#FF0000";
										if(lampada4Status == true)
										{
											gravarLampada(4,ligar4);
											lampada4Status = false;
										}
									}
								}
								//Controle de fluxo para interrupção do sistema(incluindo arduino) em caso de logout
								if(logado=true)
								{
									PrintWriter out = new PrintWriter(firstAvailableComPort.getOutputStream());
									out.print('L');
									out.flush();					
								}
								else
								{
									PrintWriter out = new PrintWriter(firstAvailableComPort.getOutputStream());
									out.print('D');
									out.flush();
								}							
								if(lampada1.equals("Desligado") || lampada2.equals("Desligado") || lampada3.equals("Desligado") || lampada4.equals("Desligado"))
								{
									alerta = true;
								}
								else
								{
									alerta = false;
								}
					   }
				   }
				   
				}catch(Exception e)
				{
				  e.printStackTrace();
				}
		 }
	};
	
		
}
