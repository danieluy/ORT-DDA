package pkg20170321_pares_impares;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logic l = new Logic();
        l.setLength(5);
        l.addNumber(1);
        l.addNumber(2);
        l.addNumber(3);
        l.addNumber(2);
        l.addNumber(0);
        l.addNumber(3);
        l.addNumber(3);
        l.addNumber(3);
        System.out.println(l.complete());
        System.out.println(l.getResult());
    }
    
}
