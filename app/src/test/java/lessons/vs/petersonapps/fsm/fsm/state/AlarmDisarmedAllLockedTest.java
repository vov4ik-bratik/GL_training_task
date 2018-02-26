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
public class AlarmDisarmedAllLockedTest {
    @Mock
    FSM fsm;
    @Mock
    State state;

    AlarmDisarmedAllLocked alarmDisarmedAllLocked;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        alarmDisarmedAllLocked = new AlarmDisarmedAllLocked(fsm);
    }

    @Test
    public void test_lock() {
        when(fsm.getAlarmArmedAllLocked()).thenReturn(state);

        alarmDisarmedAllLocked.lock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_lockX2() {
        when(fsm.getAlarmArmedAllLocked()).thenReturn(state);

        alarmDisarmedAllLocked.lockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlock() {
        when(fsm.getAlarmDisarmedDriverUnlocked()).thenReturn(state);

        alarmDisarmedAllLocked.unlock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlockX2() {
        when(fsm.getAlarmDisarmedAllUnlocked()).thenReturn(state);

        alarmDisarmedAllLocked.unlockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_toString() {
        assertEquals("AlarmDisarmed_AllLocked", alarmDisarmedAllLocked.toString());
    }

    @After
    public void tearDown() {
        alarmDisarmedAllLocked = null;
    }
}
