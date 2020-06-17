import java.util.HashMap;

public class TinyURL {
    //https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/254145/Java-Solutions
    public class Codec {

        private String baseURL = "tinyurl.com/";
        private HashMap<String, String> map = new HashMap<>();


        // Encodes a URL to a shortened URL.
        // i cant's use the hashcode to decode, so can store the
        // riginal
        public String encode(String longUrl) {
            // add a base url.
            // use the who longurl to create a hashcode
            // String shortUrl = BASE_HOST + longUrl.hashCode();
            String shortU = baseURL + longUrl.hashCode();
            map.put(shortU, longUrl);
            return shortU;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            // retrieve original from map
            return map.get(shortUrl);

        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}

