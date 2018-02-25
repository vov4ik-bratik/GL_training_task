package lessons.vs.petersonapps.fsm;

import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lessons.vs.petersonapps.fsm.fsm.state.FSM;

public class MainActivity extends AppCompatActivity
        implements MainMVPView {

    @BindView(R.id.tvAlarmState_AM)
    TextView tvAlarmState;
    @BindView(R.id.tvLockState_AM)
    TextView tvLockState;

    @BindView(R.id.ivAlarmState_AM)
    ImageView ivAlarmState;
    @BindView(R.id.ivLockState_AM)
    ImageView ivLockState;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this, new FSM());
        presenter.initialStart();
    }

    @OnClick(R.id.btnLock_AM)
    void onClickLock() {
        presenter.lock();
    }

    @OnClick(R.id.btnUnLock_AM)
    void onClickUnLock() {
        presenter.unlock();
    }

    @OnClick(R.id.btnLockX2_AM)
    void onClickLockX2() {
        presenter.lockX2();
    }

    @OnClick(R.id.btnUnLockX2_AM)
    void onClickUnLockX2() {
        presenter.unLockX2();
    }

    @Override
    public void onStartApp(String state) {
        setScreenFields(state);
    }

    @Override
    public void onLockResult(String state) {
        setScreenFields(state);
    }

    @Override
    public void onUnLockResult(String state) {
        setScreenFields(state);
    }

    @Override
    public void onLockX2Result(String state) {
        setScreenFields(state);
    }

    @Override
    public void onUnLockX2Result(String state) {
        setScreenFields(state);
    }

    private void setScreenFields(String state) {
        String[] parts = state.split("_");
        String alarmState = parts[0];
        String lockState = parts[1];

        tvAlarmState.setText(alarmState);
        tvLockState.setText(lockState);

        tvAlarmState.setBackgroundColor(alarmArmedColor(alarmState));

        ivAlarmState.setImageResource(getResIDAlarmState(alarmState));
        ivLockState.setImageResource(getResIDLockState(lockState));
    }

    private int alarmArmedColor(String alarmArmed) {
        if (alarmArmed.equalsIgnoreCase("alarmarmed"))
            return Color.RED;
        else
            return Color.GREEN;
    }

    private int getResIDAlarmState(String alarmArmed) {
        if (alarmArmed.equalsIgnoreCase("alarmarmed"))
            return R.drawable.ic_alarm_on;
        else
            return R.drawable.ic_alarm_off;
    }

    private int getResIDLockState(String lockState) {
        switch (lockState) {
            case "AllLocked":
                return R.drawable.ic_lock;
            case "DriverUnlocked":
                return R.drawable.ic_driver_unlocked;
            case "AllUnlocked":
                return R.drawable.ic_lock_open;
        }
        return R.drawable.ic_close;
    }
}
