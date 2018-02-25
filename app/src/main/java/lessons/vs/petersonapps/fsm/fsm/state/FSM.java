package lessons.vs.petersonapps.fsm.fsm.state;

/**
 * Created by vs on 25.02.2018.
 */

public class FSM {

    public State alarmDisarmedAllUnlocked;
    public State alarmArmedAllLocked;
    public State alarmDisarmedAllLocked;
    public State alarmDisarmedDriverUnlocked;

    State state;

    public FSM() {
        alarmDisarmedAllUnlocked = new AlarmDisarmedAllUnlocked(this);
        alarmArmedAllLocked = new AlarmArmedAllLocked(this);
        alarmDisarmedAllLocked = new AlarmDisarmedAllLocked(this);
        alarmDisarmedDriverUnlocked = new AlarmDisarmedDriverUnlocked(this);

        state = alarmDisarmedAllUnlocked;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "state: " + state;
    }

    public void unlock() {
        state.unlock();
    }

    public void unlockX2() {
        state.unlockX2();
    }

    public void lock() {
        state.lock();
    }

    public void lockX2() {
        state.lockX2();
    }

    public State getAlarmDisarmedAllUnlocked() {
        return alarmDisarmedAllUnlocked;
    }

    public State getAlarmArmedAllLocked() {
        return alarmArmedAllLocked;
    }

    public State getAlarmDisarmedAllLocked() {
        return alarmDisarmedAllLocked;
    }

    public State getAlarmDisarmedDriverUnlocked() {
        return alarmDisarmedDriverUnlocked;
    }
}
