package Ex_2_Verifying_Interactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Ex_1_Mocking_and_Stubbing.ExternalApi; 
import Ex_1_Mocking_and_Stubbing.MyService;   

public class ExternalServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mock = mock(ExternalApi.class);
        when(mock.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mock);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
        verify(mock).getData();
    }
}