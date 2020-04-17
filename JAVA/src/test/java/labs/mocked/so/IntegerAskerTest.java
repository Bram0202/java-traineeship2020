package labs.mocked.so;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static labs.mocked.so.IntegerAsker.getBoundIntegerFromUser;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class IntegerAskerTest {

    @Test
    public void getsIntegerWhenWithinBoundsOfOneToTen() throws Exception {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(3);

        assertEquals(3, getBoundIntegerFromUser(asker));
        //assertEquals(getBoundIntegerFromUser(asker), 33);
    }

//    @Test
//    public void getsIntegerWhenWithinBoundsOfOneToTen2() throws Exception {
//        IntegerAsker asker = Mockito.mock(IntegerAsker.class);
//        Mockito.when(asker.ask(Mockito.anyString())).thenReturn(3);
//
//        assertEquals(3, asker.getBoundIntegerFromUser(asker));
//        //assertEquals(getBoundIntegerFromUser(asker), 33);
//    }
//    @Test
//    public void asksForNewIntegerWhenOutsideBoundsOfOneToTen() throws Exception {
//        IntegerAsker asker = mock(IntegerAsker.class);
//        when(asker.ask("Give a number between 1 and 10")).thenReturn(99);
//        when(asker.ask("Wrong number, try again.")).thenReturn(3);
//
//        getBoundIntegerFromUser(asker);
//
//        verify(asker).ask("Wrong number, try again.");
//    }
}
