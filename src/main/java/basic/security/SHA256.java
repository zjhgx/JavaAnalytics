package basic.security;

import javax.crypto.Mac;

import javax.crypto.spec.SecretKeySpec;

import java.util.*;

public class SHA256 {

	private final static String secret_key = "41ecb7b8af26504afbe1cccc929fa499";

	private static String sha256_HMAC(String message, String secret) {

		String hash = "";

		try {

			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

			SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");

			sha256_HMAC.init(secret_key);

			byte[] bytes = sha256_HMAC.doFinal(message.getBytes());

			hash = byteArrayToHexString(bytes);

			System.out.println(hash);

		} catch (Exception e) {

			System.out.println("Error HmacSHA256 ===========" + e.getMessage());

		}

		return hash;

	}

	private static String byteArrayToHexString(byte[] b) {

		StringBuilder hs = new StringBuilder();

		String stmp;

		for (int n = 0; b != null && n < b.length; n++) {

			stmp = Integer.toHexString(b[n] & 0XFF);

			if (stmp.length() == 1)

				hs.append('0');

			hs.append(stmp);

		}

		return hs.toString().toLowerCase();

	}

	public static void main(String[] args) {
		SHA256.sha256_HMAC("EMAWfQVSUiR01GzZBjvpri0mFYF1iCNjroOV2kOaNVhFGIkkBKCJFsLczDbhXWnZCiqZA5XC6sglHu8XsEK5Hvbk4NXwwwUznj8QA2pHMtwZDZD", "41ecb7b8af26504afbe1cccc929fa499");
	}
}
