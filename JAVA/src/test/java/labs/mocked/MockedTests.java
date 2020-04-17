package labs.mocked;

import labs.mocked.so.IntegerAsker;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static labs.mocked.App.UserInputToAllCaps;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;

public class MockedTests {

//    private App target;
//
//    @BeforeEach
//    void init() {
//        target = new App();
//    }

    @Test
    public void mockTest() {
        CustomScanner customScanner = Mockito.mock(CustomScanner.class);
        Mockito.when(customScanner.nextLine(Mockito.anyString())).thenReturn("test");

        assertEquals("TEST", App.UserInputToAllCaps());
    }
}
