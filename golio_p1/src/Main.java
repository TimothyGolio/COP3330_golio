public class Main
{
    public static void main(String[] args)
    {
        // Tests code.

        Encrypter enc = new Encrypter();
        Decrypter dec = new Decrypter();

        String encrypted = enc.encrypt("0013");

        System.out.println(encrypted);

        String decrypted = dec.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}