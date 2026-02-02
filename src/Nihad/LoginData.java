package Nihad;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name="loginData")
    public static Object[][] userData(){
        Object[][] users = {
                {"admin","Admin123"}
        };
        return users;
    }

}
