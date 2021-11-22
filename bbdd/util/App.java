package bbdd.util;

import bbdd.dao.AdminDao;
import bbdd.dao.AnswersDao;
import bbdd.dao.KahootDao;
import bbdd.dao.QuestionsDao;
import bbdd.dao.UserDao;
import bbdd.entity.Admin;
import bbdd.entity.Answers;
import bbdd.entity.Kahoot;
import bbdd.entity.Questions;
import bbdd.entity.User;

public class App {
	public static void main(String[] args) {

		// Insert Admins
		AdminDao adminDao = new AdminDao();
		Admin admin = new Admin("Ram", "contraseña12");
		Admin admin1 = new Admin("Marta", "gato1234");
		Admin admin2 = new Admin("Laura", "burro5678");
		Admin admin3 = new Admin("Carmen", "camello0987");
		adminDao.saveAdmin(admin);
		adminDao.saveAdmin(admin1);
		adminDao.saveAdmin(admin2);
		adminDao.saveAdmin(admin3);

		admin.setName("Ram");

		// Insert Users
		UserDao userDao = new UserDao();
		User user = new User("usu1", "contraseña12");
		User user2 = new User("usu2", "gato1234");
		User user3 = new User("usu3", "burro5678");
		User user4 = new User("usu4", "camello0987");
		userDao.saveUser(user4);
		userDao.saveUser(user);
		userDao.saveUser(user3);
		userDao.saveUser(user2);

//kahoot edad media
		Kahoot k = new Kahoot("HISTORIA");
		KahootDao kdao = new KahootDao();
		k.setAdminName(admin3);
		kdao.saveKahoot(k);

//Pregunta 1 kahoot edad media
		QuestionsDao qdao = new QuestionsDao();
		Questions preg = new Questions();
		preg.setKahoot(k);
		preg.setQuestion("¿Cuáles fueron las principales civilizaciones de la Edad Antigua?");
		qdao.saveQuestions(preg);

//Respuestas pregunta 1
		AnswersDao adao = new AnswersDao();
		Answers ans1 = new Answers();
		ans1.setAnswer("Egipto, Francia y Roma");
		ans1.setCorrect(false);
		ans1.setQuestions(preg);
		adao.saveAnswers(ans1);

//Respuestas pregunta 1
		Answers ans3 = new Answers();
		ans3.setAnswer("Egipto, España y Roma");
		ans3.setCorrect(false);
		ans3.setQuestions(preg);
		adao.saveAnswers(ans3);
//Respuestas pregunta 1
		Answers ans4 = new Answers();
		ans4.setAnswer("Egipto, India y Roma");
		ans4.setCorrect(false);
		ans4.setQuestions(preg);
		adao.saveAnswers(ans4);

//Respuestas pregunta 1
		Answers ans2 = new Answers();
		ans2.setAnswer("Egipto, Grecia y Roma");
		ans2.setCorrect(true);
		ans2.setQuestions(preg);
		adao.saveAnswers(ans2);

	}
}