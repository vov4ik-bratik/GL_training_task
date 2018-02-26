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
public class AlarmArmedAllLockedTest {

    @Mock
    FSM fsm;
    @Mock
    State state;

    AlarmArmedAllLocked alarmArmedAllLocked;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        alarmArmedAllLocked = new AlarmArmedAllLocked(fsm);
    }

    @Test
    public void test_lock() {
        when(fsm.getAlarmArmedAllLocked()).thenReturn(state);

        alarmArmedAllLocked.lock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_lockX2() {
        when(fsm.getAlarmArmedAllLocked()).thenReturn(state);

        alarmArmedAllLocked.lockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlock() {
        when(fsm.getAlarmDisarmedDriverUnlocked()).thenReturn(state);

        alarmArmedAllLocked.unlock();

        verify(fsm).setState(state);
    }

    @Test
    public void test_unlockX2() {
        when(fsm.getAlarmDisarmedAllUnlocked()).thenReturn(state);

        alarmArmedAllLocked.unlockX2();

        verify(fsm).setState(state);
    }

    @Test
    public void test_toString() {
        assertEquals("AlarmArmed_AllLocked", alarmArmedAllLocked.toString());
    }

    @After
    public void tearDown() {
        alarmArmedAllLocked = null;
    }
}
