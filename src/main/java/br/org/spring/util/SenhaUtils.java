package br.org.spring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	
	
	/**
	 * Gera um hash utilizando o BCrypt
	 *@param senha
	 *@return String
	 */
	public static String geraBCrypt(String senha) {
		if (senha == null) {
			return senha;
		}
		
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
		
	}
	
	/**
	 * Verifica se a senha é valida
	 *@param senha
	 *@param senhaEncoded
	 *@return String
	 */
	public static boolean senhaValida(String senha, String senhaEncoded) {
		BCryptPasswordEncoder bCryptEncoded = new BCryptPasswordEncoder();
		return bCryptEncoded.matches(senha, senhaEncoded);
		
	}
	
}
