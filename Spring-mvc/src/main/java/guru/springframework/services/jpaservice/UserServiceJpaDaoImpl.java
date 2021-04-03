package guru.springframework.services.jpaservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import guru.springframework.services.security.EncryptionService;

@Repository
@Transactional
@Profile("jpa")
public class UserServiceJpaDaoImpl implements UserService {
	
	@Autowired
	EncryptionService encryptionService;

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<User> listAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User getById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User saveOrUpdate(User user) {
		
		if (user.getPassword() != null) {
			String encrpytString = encryptionService.encrpytString(user.getPassword());
//			System.out.println("plainPassword : "+user.getPassword());
//			System.out.println("encrpytedPassword : "+encrpytString);
			user.setEncryptedPassword(encrpytString);
		}		
		return entityManager.merge(user);
	}

	@Override
	public void delete(Integer id) {
		entityManager.remove(entityManager.find(User.class, id));

	}

}
