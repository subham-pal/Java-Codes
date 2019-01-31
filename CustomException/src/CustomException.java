class ZeroStringLengthExceotion extends Exception{

}

public class CustomException {

    private static String reverse(String str) throws ZeroStringLengthExceotion{
        if(str.length() == 0){
            throw new ZeroStringLengthExceotion();
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
        }
        finally{
            System.out.println("Main finished");
        }
    }
}
