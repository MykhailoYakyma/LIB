package LIB.bbdd.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import LIB.bbdd.entity.Contest;
import LIB.bbdd.entity.Participant;
import LIB.bbdd.entity.Questions;
import LIB.bbdd.util.HibernateUtil;

public class ParticipantDao {

	public void saveParticipant(Participant participant) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// operation 1
			Object object = session.save(participant);

			// operation 2
			session.get(Participant.class, (Serializable) object);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateParticipant(Participant participant) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the Participant object

			session.saveOrUpdate(participant);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Participant getParticipant(int id) {

		Transaction transaction = null;
		Participant Participant2 = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an Participant object
			Participant2 = session.get(Participant.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Participant2;
	}

	public List<Participant> getParticipants() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Participant", Participant.class).list();
		}
	}

	public Participant getParticipantByName(String name) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (Participant) session.createCriteria(Participant.class).add(Restrictions.eq( "alias", name ));

		}
		
	}
}