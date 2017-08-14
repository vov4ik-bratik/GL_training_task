package lessons.vs.petersonapps.fsm;

/**
 * Created by vs on 13.08.2017.
 */

public interface MainMVPView {

    void onLockResult(boolean alarmArmed, int lockState);

    void onStart(boolean alarmArmed, int lockedState);

    void onUnLockResult(boolean alarmArmed, int lockedState);

    void onLockX2Result(boolean alarmArmed, int lockedState);

    void onUnLockX2Result(boolean alarmArmed, int lockedState);
}
