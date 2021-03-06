package LIB.bbdd.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import LIB.bbdd.entity.Answers;
import LIB.bbdd.entity.Questions;
import LIB.bbdd.util.HibernateUtil;

public class AnswersDao {

	public void saveAnswers(Answers answers) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// operation 1
			Object object = session.save(answers);

			// operation 2
			session.get(Answers.class, (Serializable) object);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateAnswers(Answers answers) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the Answers object

			session.saveOrUpdate(answers);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Answers getAnswers(int id) {

		Transaction transaction = null;
		Answers Answers2 = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an Answers object
			Answers2 = session.get(Answers.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Answers2;
	}

	public List<Answers> getAnswers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Answers", Answers.class).list();
		}
	}
	
	public List<Answers> getAnswersByQuestion(Questions question) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createCriteria(Answers.class).add(Restrictions.eqOrIsNull("questions", question)).list();
		}
	}
}