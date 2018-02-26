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
public class AlarmDisarmedAllUnlockedTest {
    @Mock
    FSM fsm;
    @Mock
    State state;

    AlarmDisarmedAllUnlocked alarmDisarmedAllUnlocked;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        alarmDisarmedAllUnlocked = new AlarmDisarmedAllUnlocked(fsm);
    }

    @Test
    public void test_lock() {
        when(fsm.getAlarmDisarmedAllLocked()).thenReturn(state);

        alarmDisarmedAllUnlocked.lock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_lockX2() {
        when(fsm.getAlarmArmedAllLocked()).thenReturn(state);

        alarmDisarmedAllUnlocked.lockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlock() {
        when(fsm.getAlarmDisarmedAllUnlocked()).thenReturn(state);

        alarmDisarmedAllUnlocked.unlock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlockX2() {
        when(fsm.getAlarmDisarmedAllUnlocked()).thenReturn(state);

        alarmDisarmedAllUnlocked.unlockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_toString() {
        assertEquals("AlarmDisarmed_AllUnlocked", alarmDisarmedAllUnlocked.toString());
    }

    @After
    public void tearDown() {
        alarmDisarmedAllUnlocked = null;
    }
}

