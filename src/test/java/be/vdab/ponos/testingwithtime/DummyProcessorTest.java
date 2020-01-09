package be.vdab.ponos.testingwithtime;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DummyProcessorTest {

    @InjectMocks
    private DummyProcessor dummyProcessor;

    @Test
    public void givenNewProcessor_whenGetDummyInstance_thenIdIsCorrect() {
        DummyClass dummyInstance = dummyProcessor.getDummyInstance();

        assertThat(dummyInstance.getIdentifier()).isEqualTo("ID");
    }

    @Test
    public void givenNewProcessor_whenGetDummyInstance_thenTimestampIsCorrect() {
        DummyClass dummyInstance = dummyProcessor.getDummyInstance();

        //Test the timestamp
    }
}