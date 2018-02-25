package lessons.vs.petersonapps.fsm;


import lessons.vs.petersonapps.fsm.fsm.state.FSM;

public class Presenter {

    private MainMVPView mainMVPView;
    private FSM finiteStateMachine;

    public FSM getFiniteStateMachine() {
        return finiteStateMachine;
    }

    public Presenter(MainMVPView mainMVPView, FSM finiteStateMachine) {
        this.mainMVPView = mainMVPView;
        this.finiteStateMachine = finiteStateMachine;
    }


    public void initialStart() {
        finiteStateMachine.setState(finiteStateMachine.getAlarmDisarmedAllUnlocked());
        mainMVPView.onStartApp(finiteStateMachine.getState().toString());
    }

    public void lock() {
        finiteStateMachine.lock();
        mainMVPView.onLockResult(finiteStateMachine.getState().toString());
    }

    public void unlock() {
        finiteStateMachine.unlock();
        mainMVPView.onUnLockResult(finiteStateMachine.getState().toString());
    }

    public void lockX2() {
        finiteStateMachine.lockX2();
        mainMVPView.onLockX2Result(finiteStateMachine.getState().toString());
    }

    public void unLockX2() {
        finiteStateMachine.unlockX2();
        mainMVPView.onUnLockX2Result(finiteStateMachine.getState().toString());
    }
}
