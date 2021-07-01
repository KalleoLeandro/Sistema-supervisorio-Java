package supervisorio.controller;

import java.util.ArrayList;

import supervisorio.bean.TempoLigado;
import supervisorio.dao.TempoLigadoDAO;

public class TempoLigadoController 
{
		public ArrayList<TempoLigado> buscarTodos()
		{
			ArrayList<TempoLigado> retorno = new ArrayList<TempoLigado>();        
	        try
	        {
	        	retorno = new TempoLigadoDAO().buscarTodos();        	
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
			return retorno;
		}
		
		public void salvar(TempoLigado tempo)
		{
			try
			{
				new TempoLigadoDAO().salvar(tempo);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}