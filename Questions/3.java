//if we encounter a character "i" the string they are writing suddenly reverses
class ReverseString {
    public static String reverse(String b) {
        StringBuilder c = new StringBuilder(); 
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == 'i') {
                c.reverse(); // Reverse StringBuilder
            } else {
                c.append(b.charAt(i));
            }
        }
        return c.toString(); // Convert StringBuilder to String before returning
    }
}

public class Main {
    public static void main(String[] args) {
        String b = "strings";
        System.out.println(ReverseString.reverse(b));
    }
}
