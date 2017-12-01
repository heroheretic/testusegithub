package phamhaidang.itplus.vn.truyenapp.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import phamhaidang.itplus.vn.truyenapp.Dialog.BrightnessDialog;
import phamhaidang.itplus.vn.truyenapp.Dialog.ScreenSetting;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Chap;
import phamhaidang.itplus.vn.truyenapp.Fragment.ReadComic_Horizontal_Fragment;
import phamhaidang.itplus.vn.truyenapp.Fragment.ReadComic_Vertical_Fragment;
import phamhaidang.itplus.vn.truyenapp.R;

public class ReadManga extends AppCompatActivity  {
    public static final String arg_lst_name = "Link_list_manga";
    public static final String arg_Chap_name = "Chap_data";
    public static final String arg_Manganame_name = "Name_data";
    TextView txtmanganame_readmanga, txtchapname_readmanga;
    ImageView btback_readmanga, btbrightness_readmanga, btreadmode_readmanga, btscreenmode_readmanga;
    Chap chap;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_manga);
        Init();
    }

    private void Init() {
        InitView();
        if (!InitData())
            return;
        txtchapname_readmanga.setText("Chap " + chap.getChap());
        txtmanganame_readmanga.setText(Name);
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontent_readcomic, ReadComic_Vertical_Fragment.newInstance(chap.getImagelist())).commit();
    }

    private void RequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(getApplicationContext())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 200);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private void InitView() {
        btback_readmanga = (ImageView) findViewById(R.id.btback_readmanga);
        btbrightness_readmanga = (ImageView) findViewById(R.id.btbrightness_readmanga);
        btreadmode_readmanga = (ImageView) findViewById(R.id.btreadmode_readmanga);
        btscreenmode_readmanga = (ImageView) findViewById(R.id.btscreenmode_readmanga);
        txtmanganame_readmanga = (TextView) findViewById(R.id.txtmanganame_readmanga);
        txtchapname_readmanga = (TextView) findViewById(R.id.txtchapname_readmanga);
        Set_Event();
    }
    private Boolean InitData() {
        chap = new Chap();
        Name = "";
        Bundle bundle = getIntent().getExtras();
        Name = bundle.getString(arg_Manganame_name);
        chap = (Chap) bundle.getSerializable(arg_Chap_name);
        if (Name.isEmpty() || chap.getImagelist().isEmpty())
            return false;
        return true;
    }
    private void Set_Event() {
        btback_readmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btbrightness_readmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestPermission();
                BrightnessDialog brightnessDialog = new BrightnessDialog(ReadManga.this);
                brightnessDialog.show();
            }
        });
        btreadmode_readmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateDialog_ReadMode();
            }
        });
        btscreenmode_readmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateDialog_ScreenMode();
            }
        });
    }

    private void CreateDialog_ReadMode() {
        final View customview = LayoutInflater.from(ReadManga.this).inflate(R.layout.dialog_readmode_readmanga, null);
        final RadioGroup radioGroup = (RadioGroup) customview.findViewById(R.id.radiogroup_readmode);
        Button btaccept_readmode = (Button) customview.findViewById(R.id.btaccept_dialogreadmode);
        final AlertDialog.Builder builder = new AlertDialog.Builder(ReadManga.this)
                .setView(customview);
        final AlertDialog alertDialog = builder.create();
        btaccept_readmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.checkbox_horizontal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.maincontent_readcomic, ReadComic_Horizontal_Fragment.newInstance(chap.getImagelist())).commit();
                        break;
                    case R.id.checkbox_vertical:
                        getSupportFragmentManager().beginTransaction().replace(R.id.maincontent_readcomic, ReadComic_Vertical_Fragment.newInstance(chap.getImagelist())).commit();
                        break;
                    default:
                        break;
                }
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void CreateDialog_ScreenMode() {
        final View customview = LayoutInflater.from(ReadManga.this).inflate(R.layout.dialog_rotate_readmanga, null);
        final RadioGroup radioGroup = (RadioGroup) customview.findViewById(R.id.radiogroup_screenmode);
        Button btaccept_readmode = (Button) customview.findViewById(R.id.btaccept_screenmode);
        final AlertDialog.Builder builder = new AlertDialog.Builder(ReadManga.this)
                .setView(customview);
        final AlertDialog alertDialog = builder.create();
        btaccept_readmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.checkbox_defaultmode:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                        break;
                    case R.id.checkbox_horizontalmode:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        break;
                    case R.id.checkbox_verticalmode:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        break;
                    default:
                        break;
                }
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}

