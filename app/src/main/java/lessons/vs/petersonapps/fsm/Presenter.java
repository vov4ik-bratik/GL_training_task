package lessons.vs.petersonapps.fsm;


public class Presenter {

    private MainMVPView mainMVPView;
    private FSM_Model model;

    public Presenter(MainMVPView mainMVPView, FSM_Model model) {
        this.mainMVPView = mainMVPView;
        this.model = model;
    }


    public void initialStart() {
        model.setAlarmArmed(false);
        model.setLockedState(1);
        mainMVPView.onStart(model.isAlarmArmed(), model.getLockedState());
    }

    public void lock() {
        model.lock();
        mainMVPView.onLockResult(model.isAlarmArmed(), model.getLockedState());
    }

    public void unlock() {
        model.unlock();
        mainMVPView.onUnLockResult(model.isAlarmArmed(), model.getLockedState());
    }

    public void lockX2() {
        model.lockX2();
        mainMVPView.onLockX2Result(model.isAlarmArmed(), model.getLockedState());
    }

    public void unLockX2() {
        model.unlockX2();
        mainMVPView.onUnLockX2Result(model.isAlarmArmed(), model.getLockedState());
    }
}
