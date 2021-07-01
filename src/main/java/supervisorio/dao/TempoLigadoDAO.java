package supervisorio.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import supervisorio.bean.TempoLigado;
import supervisorio.util.HibernateUtil;

public class TempoLigadoDAO extends GenericDAO 
{
    @SuppressWarnings("unchecked")
    public ArrayList<TempoLigado> buscarTodos() throws Exception {

        ArrayList<TempoLigado> listaRetorno = new ArrayList<TempoLigado>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(TempoLigado.class);
        criteria.addOrder(Order.asc("id"));
        listaRetorno = (ArrayList<TempoLigado>) criteria.list();
        sessao.close();

        return listaRetorno;
    }
}
