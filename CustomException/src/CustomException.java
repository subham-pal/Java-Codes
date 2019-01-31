class ZeroStringLengthException extends Exception{

}

public class CustomException {

    private static String reverse(String str) throws ZeroStringLengthException{
        if(str.length() == 0){
            throw new ZeroStringLengthException();
        }
        String newString = "";
        for(int i = str.length() - 1; i >= 0; --i){
            newString += str.charAt(i);
        }
        return newString;
    }

    public static void main(String[] args) {
        String str = "";
        try {
            System.out.println(reverse(str));
        }
        catch (Exception c){
            System.out.println("Handled");
            c.printStackTrace();
        }
        finally{
            System.out.println("Main finished");
        }
    }
}
