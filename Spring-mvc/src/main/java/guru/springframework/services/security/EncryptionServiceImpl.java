package guru.springframework.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {
	
	@Autowired
	StrongPasswordEncryptor passwordEncryptor;
	
//	StrongPasswordEncryptor passwordEncryptor= new StrongPasswordEncryptor();
	
	

	@Override
	public String encrpytString(String input) {		
		return passwordEncryptor.encryptPassword(input);
	}

	@Override
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
	}

}
