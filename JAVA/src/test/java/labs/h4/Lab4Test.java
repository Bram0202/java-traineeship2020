package labs.h4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lab4Test {
    private Lab4 target;

    @BeforeEach
    void init() {
        target = new Lab4();
    }

    @Test
    void isGetalGeldigInElevenProofTest() {
        // given

        // when
        boolean test = target.elevenProof(123456789);

        // then
        Assertions.assertEquals(true, test);
    }
}


