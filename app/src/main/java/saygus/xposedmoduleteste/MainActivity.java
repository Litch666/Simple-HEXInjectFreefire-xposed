package saygus.xposedmoduleteste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 111;
    Button btn1,btn2, btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {

            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION);
        } else {
            init();
        }
        btn1 = findViewById(R.id.btnCeuPreto);
        btn2 = findViewById(R.id.btnBonecoBranco);
        btn3 = findViewById(R.id.btnParaquedas);
        btn4 = findViewById(R.id.btnNoFog);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            if (resultCode == RESULT_OK) {
                init();
            } else {
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void init(){
        startService(new Intent(this, FloatingViewService.class));
        finish();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCeuPreto:
                startService(new Intent(MainActivity.this, FloatingViewService.class));
                break;
        }
    }

}
