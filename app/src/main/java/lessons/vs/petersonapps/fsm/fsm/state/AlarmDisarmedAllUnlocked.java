package lessons.vs.petersonapps.fsm.fsm.state;
/**
 * Created by vs on 24.02.2018.
 */
public class AlarmDisarmedAllUnlocked implements State {

    FSM finiteStateMachine;

    public AlarmDisarmedAllUnlocked(FSM finiteStateMachine) {
        this.finiteStateMachine = finiteStateMachine;
    }

    @Override
    public void lock() {
        finiteStateMachine.setState(finiteStateMachine.getAlarmDisarmedAllLocked());
    }

    @Override
    public void lockX2() {
        finiteStateMachine.setState(finiteStateMachine.getAlarmArmedAllLocked());
    }

    @Override
    public void unlock() {
        finiteStateMachine.setState(finiteStateMachine.getAlarmDisarmedAllUnlocked());
    }

    @Override
    public void unlockX2() {
        finiteStateMachine.setState(finiteStateMachine.getAlarmDisarmedAllUnlocked());
    }

    @Override
    public String toString() {
        return "AlarmDisarmed_AllUnlocked";
    }
}
