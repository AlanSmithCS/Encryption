import java.util.HashMap;
import java.util.Map;
import Tools.Tools;

public class Substitution_Cipher {
    public static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static HashMap<Character, Character> getCaesarCipher(int offset) {
        HashMap<Character, Character> cipher = new HashMap<>();

        for (int i=0; i<alphabet.length; i++) {
            int index = i + offset;
            if (index < 0) {
                index = 26-i;
            } else if (index>=26) {
                index = index-26;
            }

            cipher.put(alphabet[i], alphabet[index]);
        }
        return cipher;
    }

    public static String encrypt(String unencrypted, int offset) {
        HashMap<Character, Character> cipher = getCaesarCipher(offset);

        char[] encrypted = new char[unencrypted.length()];

        int j=0;
        for (char c : unencrypted.toCharArray()) {
            encrypted[j] = cipher.getOrDefault(c, c);
            j++;
        }
        return new String(encrypted);
    }
    public static String decrypt(String encrypted, int offset) {
        HashMap<Character, Character> cipher = getCaesarCipher(offset);

        Map<Character, Character> reverse_cipher = new HashMap<>();
        for(Map.Entry<Character, Character> entry : cipher.entrySet()){
            reverse_cipher.put(entry.getValue(), entry.getKey());
        }

        char[] decrypted = new char[encrypted.length()];

        int j=0;
        for (char c : encrypted.toCharArray()) {
            decrypted[j] = reverse_cipher.getOrDefault(c, c);
            j++;
        }
        return new String(decrypted);
    }
    public static void main(String[] args) {
        int offset = Tools.getInputInt("Enter the offset of the alphabet:");
        String content = Tools.getInputStr("Enter the content you want to convert: (all 1 line)").toLowerCase();

        Tools.messageBox("Converted msg: "+encrypt(content, offset));

        Tools.messageBox("Message after decryption: "+decrypt(encrypt(content, offset), offset));
    }
}
