package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import au.usyd.elec5619.domain.admin_product_history;
import au.usyd.elec5619.domain.product_prices;

@Service(value="productDao")
@Transactional
public class ProductDAOImplementation implements ProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImplementation.class);
	private SessionFactory sessionFactory;
//	private HttpServletRequest request;
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public List<product_prices> getProductsDAO(String name) {
		
		
		return this.sessionFactory.getCurrentSession().createQuery("from product_prices where product_name='"+name+"'").list();
	}
	
	@Override
	public void storeSearchHistoryDAO(admin_product_history searched_product) {
		this.sessionFactory.getCurrentSession().save(searched_product);
	}
	
	@Override
	public List<String> getProductsList(String query) {
		
		return this.sessionFactory.getCurrentSession().createQuery("SELECT DISTINCT product_name FROM product_prices").list(); 
	}
	
}
