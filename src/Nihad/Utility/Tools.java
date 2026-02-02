package Nihad.Utility;

public class Tools {

    public static void Wait (int sn){
        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
