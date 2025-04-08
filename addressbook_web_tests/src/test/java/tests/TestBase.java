package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
        app.initial(System.getProperty("browser", "chrome"));
    }

    public static String randomString(int n){
        var result = "";
        var random = new Random();
        for (int i = 0; i<n; i++){
            result = result + (char)('a'+random.nextInt(26));
        }
        return result;
    }


}
