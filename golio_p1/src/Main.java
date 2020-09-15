public class Main {
    public static void main(String[] args) {
        Encrypter enc = new Encrypter();
        String encrypted = enc.encrypt("0034");

        System.out.println(encrypted);
    }
}
