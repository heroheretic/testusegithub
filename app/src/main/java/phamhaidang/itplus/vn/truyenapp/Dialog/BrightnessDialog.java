package phamhaidang.itplus.vn.truyenapp.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;

import phamhaidang.itplus.vn.truyenapp.R;

/**
 * Created by heroh on 11/30/2017.
 */

public class BrightnessDialog extends Dialog {
    SeekBar seekbar_brightness;
    Button button;
    public BrightnessDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_changebrightness_readmanga);
        seekbar_brightness=(SeekBar)findViewById(R.id.seekbar_brightness);
        button=(Button)findViewById(R.id.btaccept_dialogbrightness);
        Setevent();
    }
    private void Setevent(){
        seekbar_brightness.setMax(255);
        seekbar_brightness.setKeyProgressIncrement(1);
        seekbar_brightness.setProgress(ScreenSetting.Get_current_ScreenBrightness(getContext()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        seekbar_brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ScreenSetting.Set_ScreenBrightness(getContext(),i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
