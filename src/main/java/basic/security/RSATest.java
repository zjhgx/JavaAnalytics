package basic.security;

public class RSATest {
	private String privateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDZXjVa7OakqPfpQPkv9G+nTsqL1GZc8zkh79iDRsw5VY9Ls6uo5gS6OMBe9fx6HKgG+sy4OCQvx/S4QqNFP5T0wWM39ua8IAix4nTn7XrWFrTvndpPIhdKqsaazkkX8FlhMAqS5fp0o5GMZ3noVhDzDaGC/S/2/1OakqYSddsc3wWPzef4G7Rl7lbNs+/em80A/zCcT/gs6omT47bKiN6Mr6Y5j4RnqlEkMlkSDPA3A1JLIYPI/INsslspVNWwoQvOgWbdf78p+7IyP116kQ1OiNgRRkvcfgWJP5gDl/jjW7qz/Vrgdry9yr2fSgitfg5eRu9LD8CUwaLq2sJqDS0PAgMBAAECggEALd0W3OyHbc7JIEo5SckFlgOl8QML5ijbsTFuOaTCioZnCc4LNkPyU2iODntQnmNVgMOCVoxh9kL2e7pzwLS9tTbovHI4FRGdRAtIJ3eQJ4P7AWQJIBFNYM/Pv/IusgJgmYUNdhlYUywAFePvcPpX8TC7F2xcpn0RItg2ekaryNdSNFEjbYGw0ZkAH1vFULvSWIVKi8K0XerluVqVqqJPbrrr++ZVQ/3el4o5Xv6SsLpbUt3EwCMS8UtOOJQwP4UvIK8FQwHQ+UJY//SlmN50iaIHI60Ou7DIbggSHCWT9u8hTXCAfk4D0IC8SDcnVm4U+T2L5JHYuhYQxxQbQ8lIIQKBgQD0nl4AGmX40bVjU6biD4+m3kMsKAK//3GeEM3fC/TgR4lcoJSjNMyXh9cY3tnduklJtnsZe46HAhGHQskSNV/fr9byUZf798L6JhNe7NnZv8TOPZgZZp/CxNiSx/FOBV2YbKXLO8VdV/YsNn7w57rP8LeXatzBKN9vRczRFg17BQKBgQDje0Li7fsTtv5X9aWXBNzYq5coDd0Z8999USsKOc1YhWI4SoPt933tWPQUHbmrMlvDd4bzMMZGF5LXPC4lT3aD6WHY/5e2QQtuUpDAUkAZRHGHiWbp8vO73X87qF25OVD+kyN3YEu7sd9KhfsDYPNjnWzjRxml0ad/v+tRFIaMAwKBgQCjsKH4cbHQ+gvmRqEC3yTiphLPJosIjdgqzNXmruqTdmtd13r/Z6KMt/LhCqdBr5nBQOJJIBw1DdZK7A7/J0ZbuiAdESqiCp6no/kMaXQyORhqZl80iC7aN70xI6i+6+pAyFt9jya4Gtd5qJHzhS3GXi+MnI7SlxZFMLEpLReiPQKBgQCAgTsxsrppUrCvw8b9XvPbOmOzbtF+PbP8uQOVTT3hSchIgF+y6GKs19laG8itG0+XRkhnzR/UrLB5AjgXP6J1tjteOFTd0jTA58d5vX0USQPRSx9l/acOc3vSmbQIVIaaqUgZwb5Gk57OHI3GRNh5Z48BfULR13PFyQcH0I6JPQKBgQDAauW1F1KXynhc7GkkYxRZZ49kjZD0D1iN5p1YL4raqZM5dROCPMbkbMkUrp73lyHUMyep+146IFqLOlA8G994iOhNxhy1gOa8222MzaWhIN11CEkVWNXFb2L52BauvA+if30OOmV742BBMfYUvZoVNcUOoG2FqunTM1/4kT9PKw==";

	/**
	 * 对信息生成数字签名（用私钥）
	 */
//	public static String sign(byte[] data, String keyString) throws Exception {
//		Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(keyString, false);
//		Key key = RSAUtil.getKey(keyAndFactoryMap);
//
//		PrivateKey privateKey = (PrivateKey) key;
//
//		// 用私钥对信息生成数字签名
//		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//		signature.initSign(privateKey);
//		signature.update(data);
//		return Base64.encodeBase64String(signature.sign());
//	}
//	
//	/**
//	 * 生成钥匙
//	 */
//	public static Map<String, Object> generateKeyAndFactory(String keyString, boolean isPublic) throws Exception {
//		byte[] keyBytes = Base64.decodeBase64(keyString);
//		KeyFactory keyFactory = KeyFactory.getInstance(ENCRYPTION_ALGORITHM);
//		Key key = null;
//		if (isPublic) {
//			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
//			key = keyFactory.generatePublic(x509KeySpec);
//		} else {
//			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//			key = keyFactory.generatePrivate(pkcs8KeySpec);
//		}
//
//		Map<String, Object> keyAndFactoryMap = new HashMap<String, Object>(2);
//		keyAndFactoryMap.put("key", key);
//		keyAndFactoryMap.put("keyFactory", keyFactory);
//
//		return keyAndFactoryMap;
//	}	
}
