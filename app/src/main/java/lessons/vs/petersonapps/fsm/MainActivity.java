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

        presenter = new Presenter(this, new FSM_Model());
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
    public void onLockResult(boolean alarmArmed, int lockState) {
        setScreenFields(alarmArmed, lockState);

    }

    private void setScreenFields(boolean alarmArmed, int lockState) {
        tvAlarmState.setText(getStringAlarmArmed(alarmArmed));
        tvAlarmState.setBackgroundColor(alarmArmedColor(alarmArmed));
        tvLockState.setText(getStringLockState(lockState));

        ivAlarmState.setImageResource(getResIDAlarmState(alarmArmed));
        ivLockState.setImageResource(getResIDLockState(lockState));
    }

    @Override
    public void onStart(boolean alarmArmed, int lockedState) {
        setScreenFields(alarmArmed, lockedState);
    }

    @Override
    public void onUnLockResult(boolean alarmArmed, int lockedState) {
        setScreenFields(alarmArmed, lockedState);
    }

    @Override
    public void onLockX2Result(boolean alarmArmed, int lockedState) {
        setScreenFields(alarmArmed, lockedState);
    }

    @Override
    public void onUnLockX2Result(boolean alarmArmed, int lockedState) {
        setScreenFields(alarmArmed, lockedState);
    }

    private int getResIDLockState(int lockState) {
        switch (lockState) {
            case 1:
                return R.drawable.ic_lock_open;
            case 2:
                return R.drawable.ic_driver_unlocked;
            case 3:
                return R.drawable.ic_lock;
        }
        return R.drawable.ic_close;
    }

    private int getResIDAlarmState(boolean alarmArmed) {
        if (alarmArmed)
            return R.drawable.ic_alarm_on;
        else
            return R.drawable.ic_alarm_off;
    }

    private int alarmArmedColor(boolean alarmArmed) {
        if (alarmArmed)
            return Color.RED;
        else
            return Color.GREEN;
    }

    private int getStringAlarmArmed(boolean alarmArmed) {

        if (alarmArmed)
            return R.string.alarm_armed;
        else
            return R.string.alarm_disarmed;

    }

    public String getStringLockState(int lockState) {

        switch (lockState) {
            case 1:
                return getString(R.string.all_unlocked);
            case 2:
                return getString(R.string.driver_unlocked);
            case 3:
                return getString(R.string.all_locked);
        }
        return "error, wrong lockState";
    }
}
