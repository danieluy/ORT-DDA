package contador;

public class Contador {

    private int value;

    public void plus() {
//        value++;
//        ahora quiero sumar de a 2
        value += 2;
    }

    public void minus() {
//        value--;
//        ahora el valor no puede ser inferior a cero
        if (value > 0) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
