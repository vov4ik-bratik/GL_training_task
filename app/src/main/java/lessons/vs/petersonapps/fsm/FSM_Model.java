package lessons.vs.petersonapps.fsm;

/**
 * Created by vs on 13.08.2017.
 */

public class FSM_Model {

    private boolean alarmArmed;
    private int lockedState;
    public FSM_Model() {
    }

    public FSM_Model(boolean alarmState, int lockedState) {
        alarmArmed = alarmState;
        this.lockedState = lockedState;
    }

    boolean isAlarmArmed() {
        return alarmArmed;
    }

    void setAlarmArmed(boolean alarmArmed) {
        this.alarmArmed = alarmArmed;
    }

    int getLockedState() {
        return lockedState;
    }

    void setLockedState(int lockedState) {
        this.lockedState = lockedState;
    }

    void lock() {
        if (!isAlarmArmed() && getLockedState() == 3)
            setAlarmArmed(true);

        setLockedState(3);
    }

    void unlock() {
        setAlarmArmed(false);

        if (getLockedState() == 3)
            setLockedState(2);
    }

    void lockX2() {
        setAlarmArmed(true);
        setLockedState(3);
    }

    void unlockX2() {
        setAlarmArmed(false);

        if (getLockedState() != 2)
            setLockedState(1);
    }

}
