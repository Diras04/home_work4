import com.start.util.LogService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    public void isCorrectLogPath(){
        String logPath  = "D:\\java\\Start\\OnlineSchool\\Log.txt";
        assertEquals(logPath, LogService.logFile);


    }
    @Test
    public void isInitCorrect(){
        assertTrue(LogService.init.contains("Level =OFF")
                ||LogService.init.contains("DEBUG")
                ||LogService.init.contains("INFO")||
                LogService.init.contains("WARNING")||
                LogService.init.contains("ERROR"));


    }
}
