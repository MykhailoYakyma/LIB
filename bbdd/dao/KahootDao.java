package LIB.bbdd.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import LIB.bbdd.entity.Admin;
import LIB.bbdd.entity.Kahoot;
import LIB.bbdd.entity.Questions;
import LIB.bbdd.util.HibernateUtil;

public class KahootDao {

	public void saveKahoot(Kahoot kahoot) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// operation 1
			Object object = session.save(kahoot);

			// operation 2
			session.get(Kahoot.class, (Serializable) object);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateKahoot(Kahoot kahoot) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the Kahoot object

			session.saveOrUpdate(kahoot);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Kahoot getKahoot(int id) {

		Transaction transaction = null;
		Kahoot Kahoot2 = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an Kahoot object
			Kahoot2 = session.get(Kahoot.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Kahoot2;
	}

	public List<Kahoot> getKahoots() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Kahoot", Kahoot.class).list();
		}
	}

	public List<Kahoot> getKahootsByAdmin(Admin admin) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createCriteria(Kahoot.class).add(Restrictions.eqOrIsNull("admin", admin)).list();
		}
	}
}