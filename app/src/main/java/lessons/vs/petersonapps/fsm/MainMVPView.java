package lessons.vs.petersonapps.fsm;

/**
 * Created by vs on 13.08.2017.
 */

public interface MainMVPView {

    void onStartApp(String state);

    void onLockResult(String state);

    void onUnLockResult(String state);

    void onLockX2Result(String state);

    void onUnLockX2Result(String state);
}
