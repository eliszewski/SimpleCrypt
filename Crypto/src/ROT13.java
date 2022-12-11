import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character cs;
    Character cf;


    ROT13(Character cs, Character cf) {
        this.cf = cf;
        this.cs = cs;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String s = "";
        for (Character c : text.toCharArray()
             ) {
            String temp = c.toString();
            if(temp.matches("[a-z]")) s += (char)(((c - (97 - (this.cf - this.cs))) % 26) + 97);
            if (temp.matches("[A-Z]")) s += (char) (((c - (65 - (this.cf - this.cs))) % 26) + 65);
            if (!temp.matches("[a-zA-Z]")) s += temp;
        }
        return s;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        return s.substring(s.indexOf(c)) + s.substring(0,s.indexOf(c));
    }

}
