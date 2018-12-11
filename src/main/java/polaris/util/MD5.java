package polaris.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class MD5 {
	private MD5() {
	}

	public static String getMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] b = str.getBytes();
			byte[] data = md.digest(b);
			return new BASE64Encoder().encode(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getRandomSalt() {
		UUID id = UUID.randomUUID();
		return id.toString().replaceAll("-", "").substring(5, 25);
	}

	public static void main(String[] args) {
		String salt = getRandomSalt();
		System.out.println(salt);
		String md5 = getMD5("123456" + salt);
		System.out.println(md5);
	}
}
