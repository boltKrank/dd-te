import java.util.Random;

class Revhash {

    String[] randomWords = {"tom", "jack", "fred", "earth", "answer", "pizzazz", "included"};

    public String revHashEncrypt(String orignalString) {

        Random ran = new Random();
        int wordPos = ran.nextInt(6);

        String randWord = randomWords[wordPos];
        
        StringBuilder hashreverser = new StringBuilder();
        hashreverser.append(orignalString);
        hashreverser.reverse();
        hashreverser.replace(randWord.length(), randWord.length()+1, randWord.substring(0, 1));

        String password = randWord + orignalString.charAt((orignalString.length()-randWord.length())-1);
        
        return "Encrypted hash is: " + hashreverser + " Password is: " + password;
    }

    public String revHashDecrypt(String encryptedHash, String password) {

        StringBuilder hashDecrypter = new StringBuilder();
        hashDecrypter.append(encryptedHash);
        hashDecrypter.replace(password.length()-1, password.length(), password.substring(password.length()-1, password.length()));
        hashDecrypter.reverse();

        return "Decrypted hash is: " + hashDecrypter;
    }
    

    public static void main(String[] args) {

        if(args.length == 2 && args[0].equals("encrypt")){
            if(args[1].length() != 32){
                System.out.println("Hash is wrong length");
                System.exit(0);
            }

            Revhash rh = new Revhash();
            System.out.println(rh.revHashEncrypt(args[1]));        

        }
        else if(args.length == 3 && args[0].equals("decrypt")){
            if(args[1].length() != 32){
                System.out.println("Hash is wrong length");
                System.exit(0);
            }

            Revhash rh = new Revhash();
            System.out.println(rh.revHashDecrypt(args[1],args[2]));        
        }
        else {
            System.out.println("Usage:  Revhash < encrpt | decrypt> hash [password]");
            System.out.println("Password is needed for decrypt");
        }
    }
}