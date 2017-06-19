package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommercebackend.model.Carts;

@Repository("cartsDAO")
public class CartsDAOImpl implements CartsDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	public CartsDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Carts> list() {
	List<Carts> listCategory = (List<Carts>)sessionFactory.getCurrentSession()
					.createCriteria(Carts.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return listCategory;
		}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Carts> get(int userId) {
		String hql = "from"+" Carts"+" where userId="+userId+"and status='C'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Carts> list = (List<Carts>)query.list();
		return list;
	}
	@Transactional
	public void saveOrUpdate(Carts cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}
	@Transactional
	public void delete(int cartid) {
		Carts cart = new Carts();
		cart.setId(cartid);
		sessionFactory.getCurrentSession().delete(cart);
	}
	@Transactional
	public long CartPrice(int userId) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Carts.class);
		c.add(Restrictions.eq("userid", userId));
		c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.sum("price"));
		Long l= (Long) c.uniqueResult();
		return l;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Carts getitem(int cartId) {
		String hql = "from"+" Carts"+" where id="+cartId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Carts> list = (List<Carts>) query.list();
		if (list!= null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Carts getitem(int prodId, int userId) {
		String hql = "from"+" Carts"+" where Status='C'and userid="+userId+" and productid="+"+prodId+";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Carts> list = (List<Carts>) query.list();
		if (list!= null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	@Transactional
	public long cartsize(int userId) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Carts.class);
		c.add(Restrictions.eq("userid", userId));
		c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.count("userid"));
		long count=(Long) c.uniqueResult();
		return count;
	}
	@Transactional
	public void pay(int userId) {
		String hql="update Carts set status='P' where userid="+userId;	
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}
	public CartsDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}


