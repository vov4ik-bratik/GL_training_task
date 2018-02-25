package lessons.vs.petersonapps.fsm.fsm.state;

/**
 * Created by vs on 24.02.2018.
 */
public interface State {
    public void lock();
    public void lockX2();
    public void unlock();
    public void unlockX2();
}
