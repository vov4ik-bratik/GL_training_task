package lessons.vs.petersonapps.fsm.fsm.state;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class AlarmDisarmedDriverUnlockedTest {
    @Mock
    FSM fsm;
    @Mock
    State state;

    AlarmDisarmedDriverUnlocked alarmDisarmedDriverUnlocked;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        alarmDisarmedDriverUnlocked = new AlarmDisarmedDriverUnlocked(fsm);
    }

    @Test
    public void test_lock() {
        when(fsm.getAlarmDisarmedAllLocked()).thenReturn(state);

        alarmDisarmedDriverUnlocked.lock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_lockX2() {
        when(fsm.getAlarmArmedAllLocked()).thenReturn(state);

        alarmDisarmedDriverUnlocked.lockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlock() {
        when(fsm.getAlarmDisarmedDriverUnlocked()).thenReturn(state);

        alarmDisarmedDriverUnlocked.unlock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlockX2() {
        when(fsm.getAlarmDisarmedDriverUnlocked()).thenReturn(state);

        alarmDisarmedDriverUnlocked.unlockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_toString() {
        assertEquals("AlarmDisarmed_DriverUnlocked", alarmDisarmedDriverUnlocked.toString());
    }

    @After
    public void tearDown() {
        alarmDisarmedDriverUnlocked = null;
    }
}

