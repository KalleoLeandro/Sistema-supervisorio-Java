package supervisorio.controller;

import java.util.ArrayList;

import supervisorio.bean.Lampadas;
import supervisorio.dao.LampadasDAO;

public class LampadasController 
{
		public ArrayList<Lampadas> buscarTodos()
		{
			ArrayList<Lampadas> retorno = new ArrayList<Lampadas>();        
	        try
	        {
	        	retorno = new LampadasDAO().buscarTodos();        	
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
			return retorno;
		}
}
