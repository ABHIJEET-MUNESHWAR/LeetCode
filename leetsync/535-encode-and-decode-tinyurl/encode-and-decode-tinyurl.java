public class Codec {

    Map<String, String> codeDb = new HashMap<>(), urlDb = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i] = chars.charAt((int) (Math.random() * 62));
        }
        return "http://tinyurl.com/" + String.valueOf(code);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(urlDb.containsKey(longUrl)){
            return urlDb.get(longUrl);
        }
        String code = getCode();
        while(codeDb.containsKey(code)){
            code = getCode();
        }
        codeDb.put(code, longUrl);
        urlDb.put(longUrl, code);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeDb.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));