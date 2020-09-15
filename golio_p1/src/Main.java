public class Main {
    public static void main(String[] args) {
        Encrypter enc = new Encrypter();
        Decrypter dec = new Decrypter();

        String encrypted = enc.encrypt("1234");

        System.out.println(encrypted);

        String decrypted = dec.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(decrypted);
        
    }
}
