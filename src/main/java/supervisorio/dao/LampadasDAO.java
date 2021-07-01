package supervisorio.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import supervisorio.bean.Lampadas;
import supervisorio.util.HibernateUtil;

public class LampadasDAO extends GenericDAO 
{
    @SuppressWarnings("unchecked")
    public ArrayList<Lampadas> buscarTodos() throws Exception {

        ArrayList<Lampadas> listaRetorno = new ArrayList<Lampadas>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Lampadas.class);
        criteria.addOrder(Order.asc("id"));
        listaRetorno = (ArrayList<Lampadas>) criteria.list();
        sessao.close();

        return listaRetorno;
    }
}
