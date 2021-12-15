import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Interface mInterface = new Interface();

        mInterface.start(50, 5);
        mInterface.start(50, 10);
        mInterface.start(50, 50);
        mInterface.start(50, 100);
        mInterface.start(50, 1000);
        mInterface.start(50, 10000);

    }
}
