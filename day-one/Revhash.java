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

        // Change originalString charPlace wordPos with first letter of newHashWord + replaced letter at end of password
        return "New hash is: " + hashreverser + " Password is: "+ password + " randword length is: " + randWord.length();

    }

    public String revHashDecrypt(String encryptedHash, String password) {

        String testHash = "844dc96pcf878f5e4e576221772329b6";
        String testPassword = "pizzazz7";

        StringBuilder hashDecrypter = new StringBuilder();
        hashDecrypter.append(testHash);
        //hashreverser.replace(randWord.length(), randWord.length()+1, randWord.substring(0, 1));
        hashDecrypter.reverse();

        // replace testHash.chat at testPassword.length -1 with charAt(0)
        // reverse testHash
        // return newHash

        return "Decrypted hash is: " + hashDecrypter;

    }
    

    public static void main(String[] args) {

        // add rev and unrev

        // get hash, change character at position
        // password length shows position, first letter of password is correct character

        //Check usage:
        System.out.println(args.length);

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
            // Print usage
            System.out.println("Usage:  Revhash < encrpt | decrypt> hash [password]");
            System.out.println("Password is needed for decrypt");
        }

    }

}