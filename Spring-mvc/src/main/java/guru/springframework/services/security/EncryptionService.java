package guru.springframework.services.security;

public interface EncryptionService {
	String encrpytString(String input);
	boolean checkPassword(String plainPassword, String encryptedPassword);

}
