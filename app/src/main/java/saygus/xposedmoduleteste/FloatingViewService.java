package saygus.xposedmoduleteste;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Build;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FloatingViewService extends Service {

    private static RandomAccessFile raf;
    private WindowManager mWindowManager;
    private FrameLayout frameLayout;
    private RelativeLayout collapse_view;
    private LinearLayout expanded_container;
    private ImageView close_btn, close_button;
    private Button btnClose, btn1, btn2,btn3, btn4, btn5, btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24;
    private SeekBar sb1,sb2,sb3,sb4,sb5,sb6,sb7;
    private TextView txtUsuarioValidade, sb_text1,sb_text2,sb_text3,sb_text4,sb_text5,sb_text6,sb_text7;


    private void setupMenu(){
        frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams fraLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        frameLayout.setLayoutParams(fraLayoutParams);

        RelativeLayout root_container = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        root_container.setLayoutParams(relativeLayoutParams);

        collapse_view = new RelativeLayout(this);
        collapse_view.setLayoutParams(relativeLayoutParams);

        ImageView collapsed_iv = new ImageView(this);
        close_btn = new ImageView(this);
        LinearLayout.LayoutParams collapsed_ivparams = new LinearLayout.LayoutParams(dp(60), dp(60));
        collapsed_ivparams.topMargin = dp(15);
        LinearLayout.LayoutParams close_btnparams = new LinearLayout.LayoutParams(dp(30), dp(30));

        close_btnparams.leftMargin = dp(55);
        close_btnparams.topMargin = dp(10);
        collapsed_iv.setLayoutParams(collapsed_ivparams);
        collapsed_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_men));
        close_btn.setLayoutParams(close_btnparams);
        close_btn.setImageDrawable(getResources().getDrawable(R.drawable.iconi_close));



        collapse_view.addView(collapsed_iv);
        collapse_view.addView(close_btn);


        expanded_container = new LinearLayout(this);
        LinearLayout.LayoutParams expanded_containerParams = new LinearLayout.LayoutParams(dp(200), LinearLayout.LayoutParams.WRAP_CONTENT);
        expanded_container.setLayoutParams(expanded_containerParams);
        expanded_container.setOrientation(LinearLayout.VERTICAL);
        expanded_container.setBackgroundColor(Color.parseColor("#414040"));
        expanded_container.setVisibility(View.GONE);

        LinearLayout fechar_expanded_imageview = new LinearLayout(this);
        LinearLayout.LayoutParams fechar_expanded_imageviewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(30));
        fechar_expanded_imageview.setLayoutParams(fechar_expanded_imageviewParams);
        fechar_expanded_imageview.setGravity(Gravity.RIGHT);


        /*
         *
         *   REGIÃO ONDE ESTARÁ TUDO QUE APARECE QUANDO CLICA NO ÍCONE FLUTUANTE
         *
         * */

        LinearLayout linearLayoutPrincipal = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParamsLinearLayoutPrincipal = new LinearLayout.LayoutParams(dp(200), LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayoutPrincipal.setLayoutParams(layoutParamsLinearLayoutPrincipal);
        linearLayoutPrincipal.setBackgroundColor(Color.parseColor("#414040"));
        linearLayoutPrincipal.setOrientation(LinearLayout.VERTICAL);
        //linearLayoutPrincipal.setPadding(dp(5),0,dp(5),0);

        TextView platinmodsTV = new TextView(this);
        LinearLayout.LayoutParams platinmodsTV_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        platinmodsTV_Params.gravity = Gravity.CENTER_HORIZONTAL;
        platinmodsTV_Params.topMargin = dp(15);
        platinmodsTV_Params.bottomMargin = dp(5);
        platinmodsTV.setLayoutParams(platinmodsTV_Params);
        platinmodsTV.setText("Telegram JuniorModz ");
        platinmodsTV.setTypeface(null, Typeface.BOLD);
        platinmodsTV.setTextColor(Color.parseColor("#ffffff"));

        txtUsuarioValidade = new TextView(this);
        LinearLayout.LayoutParams txtUsuario_param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        txtUsuario_param.leftMargin = dp(10);
        txtUsuario_param.bottomMargin = dp(10);
        txtUsuarioValidade.setLayoutParams(txtUsuario_param);
        txtUsuarioValidade.setTypeface(null, Typeface.BOLD);
        txtUsuarioValidade.setTextColor(Color.parseColor("#ffffff"));



        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams scrollView_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(152));
        scrollView.setLayoutParams(scrollView_Params);


        /// LINEARLAYOUT COM OS BOTÕES DE FATO


        LinearLayout linearLayout_com_botoes = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayout__com_botoes_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout_com_botoes.setLayoutParams(linearLayout__com_botoes_Params);
        linearLayout_com_botoes.setOrientation(LinearLayout.VERTICAL);

        // params padrão dos bottoes
        LinearLayout.LayoutParams btns_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(33));
        btns_params.topMargin = dp(5);
        btns_params.leftMargin = dp(5);
        btns_params.rightMargin = dp(5);
        int backgroundColor = Color.parseColor("#e90909");
        int bold = Typeface.BOLD;
        int textSize = 12;
        int textColor = Color.parseColor("#ffffff");
        // params padrão dos bottoes

        //params padrão dos seekbar
        LinearLayout.LayoutParams seekbar_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        seekbar_params.topMargin = dp(5);
        seekbar_params.leftMargin = dp(5);
        seekbar_params.rightMargin = dp(5);
        //params padrão dos seekbar

        //params padrão dos textview
        LinearLayout.LayoutParams txt_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        txt_params.leftMargin = dp(5);
        txt_params.rightMargin = dp(5);
        //


        btn1 = new Button(this);
        btn1.setLayoutParams(btns_params);
        btn1.setTextSize(textSize);
        btn1.setTypeface(null, bold);
        btn1.setBackgroundColor(backgroundColor);
        btn1.setTextColor(textColor);
        btn1.setText("Céu preto OFF");

        sb_text1 = new TextView(this);
        sb_text1.setLayoutParams(txt_params);
        sb_text1.setText("Aim Spot : Desativado");
        sb_text1.setTextSize(textSize);
        sb_text1.setTypeface(null, bold);
        sb_text1.setTextColor(textColor);
        sb1 = new SeekBar(this); //Aimbot Spot
        sb1.setMax(3);
        sb1.setLayoutParams(seekbar_params);


        sb_text2 = new TextView(this);
        sb_text2.setLayoutParams(txt_params);
        sb_text2.setText("Aim - FOV : 0");
        sb_text2.setTextSize(textSize);
        sb_text2.setTypeface(null, bold);
        sb_text2.setTextColor(textColor);
        sb2 = new SeekBar(this); //Aim - FOV
        sb2.setMax(500);
        sb2.setLayoutParams(seekbar_params);


        btn2 = new Button(this); // Aim por Tiro
        btn2.setLayoutParams(btns_params);
        btn2.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn2.setTypeface(null, bold);
        btn2.setBackgroundColor(backgroundColor);
        btn2.setTextColor(textColor);
        btn2.setText("No Paraquedas OFF");

        btn3 = new Button(this);
        btn3.setLayoutParams(btns_params);
        btn3.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn3.setTypeface(null, bold);
        btn3.setBackgroundColor(backgroundColor);
        btn3.setTextColor(textColor);
        btn3.setText("Todos Feminino OFF"); //Aim - Ignorar Derrubados

        btn4 = new Button(this);
        btn4.setLayoutParams(btns_params);
        btn4.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn4.setTypeface(null, bold);
        btn4.setBackgroundColor(backgroundColor);
        btn4.setTextColor(textColor);
        btn4.setText("Dispersao OFF"); // Aim Lock

        btn5 = new Button(this);
        btn5.setLayoutParams(btns_params);
        btn5.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn5.setTypeface(null, bold);
        btn5.setBackgroundColor(backgroundColor);
        btn5.setTextColor(textColor);
        btn5.setText("Atirar na agua OFF"); // Aim Semi

        btn6 = new Button(this);
        btn6.setLayoutParams(btns_params);
        btn6.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn6.setTypeface(null, bold);
        btn6.setBackgroundColor(backgroundColor);
        btn6.setTextColor(textColor);
        btn6.setText("Speed Hack OFF"); // WallHack v1

        btn7 = new Button(this);
        btn7.setLayoutParams(btns_params);
        btn7.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn7.setTypeface(null, bold);
        btn7.setBackgroundColor(backgroundColor);
        btn7.setTextColor(textColor);
        btn7.setText("Medkit 3s OFF"); // WallHack v2

        btn8 = new Button(this);
        btn8.setLayoutParams(btns_params);
        btn8.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn8.setTypeface(null, bold);
        btn8.setBackgroundColor(backgroundColor);
        btn8.setTextColor(textColor);
        btn8.setText("Speed Fire OFF"); // WallHack v3

        btn9 = new Button(this);
        btn9.setLayoutParams(btns_params);
        btn9.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn9.setTypeface(null, bold);
        btn9.setBackgroundColor(backgroundColor);
        btn9.setTextColor(textColor);
        btn9.setText("Visao de Aguia OFF"); // WallHack v4

        btn10 = new Button(this);
        btn10.setLayoutParams(btns_params);
        btn10.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn10.setTypeface(null, bold);
        btn10.setBackgroundColor(backgroundColor);
        btn10.setTextColor(textColor);
        btn10.setText("Chuva de Balas OFF"); // GhostHack

        btn11 = new Button(this);
        btn11.setLayoutParams(btns_params);
        btn11.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn11.setTypeface(null, bold);
        btn11.setBackgroundColor(backgroundColor);
        btn11.setTextColor(textColor);
        btn11.setText("Walhack V3 OFF"); // Telekill

        sb_text3 = new TextView(this);
        sb_text3.setLayoutParams(txt_params);
        sb_text3.setText("Chuva de Balas : 0");
        sb_text3.setTextSize(textSize);
        sb_text3.setTypeface(null, bold);
        sb_text3.setTextColor(textColor);
        sb3 = new SeekBar(this); //Chuva de balas
        sb3.setMax(25);
        sb3.setLayoutParams(seekbar_params);


        btn12 = new Button(this);
        btn12.setLayoutParams(btns_params);
        btn12.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn12.setTypeface(null, bold);
        btn12.setBackgroundColor(backgroundColor);
        btn12.setTextColor(textColor);
        btn12.setText("Walhack V4 OFF"); // Speed Hack Baixo

        sb_text4 = new TextView(this);
        sb_text4.setLayoutParams(txt_params);
        sb_text4.setText("Speed Hack : 0");
        sb_text4.setTextSize(textSize);
        sb_text4.setTypeface(null, bold);
        sb_text4.setTextColor(textColor);
        sb4 = new SeekBar(this); //Speed Hack : 0
        sb4.setMax(155);
        sb4.setLayoutParams(seekbar_params);

        btn13 = new Button(this);
        btn13.setLayoutParams(btns_params);
        btn13.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn13.setTypeface(null, bold);
        btn13.setBackgroundColor(backgroundColor);
        btn13.setTextColor(textColor);
        btn13.setText("Medkit Correndo OFF"); // Super Pulo Baixo

        sb_text5 = new TextView(this);
        sb_text5.setLayoutParams(txt_params);
        sb_text5.setText("Super Pulo : 0");
        sb_text5.setTextSize(textSize);
        sb_text5.setTypeface(null, bold);
        sb_text5.setTextColor(textColor);
        sb5 = new SeekBar(this); //Super Pulo : 0
        sb5.setMax(350);
        sb5.setLayoutParams(seekbar_params);


        sb_text6 = new TextView(this);
        sb_text6.setLayoutParams(txt_params);
        sb_text6.setText("Boneco Grande : 0");
        sb_text6.setTextSize(textSize);
        sb_text6.setTypeface(null, bold);
        sb_text6.setTextColor(textColor);
        sb6 = new SeekBar(this); //Boneco Grande : 0
        sb6.setMax(99);
        sb6.setLayoutParams(seekbar_params);

        btn14 = new Button(this);
        btn14.setLayoutParams(btns_params);
        btn14.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn14.setTypeface(null, bold);
        btn14.setBackgroundColor(backgroundColor);
        btn14.setTextColor(textColor);
        btn14.setText("RemoverMira OFF"); //Boneco Branco

        btn15 = new Button(this);
        btn15.setLayoutParams(btns_params);
        btn15.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn15.setTypeface(null, bold);
        btn15.setBackgroundColor(backgroundColor);
        btn15.setTextColor(textColor);
        btn15.setText("GhosthackV3 OFF"); //Antena Hack

        btn16 = new Button(this);
        btn16.setLayoutParams(btns_params);
        btn16.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn16.setTypeface(null, bold);
        btn16.setBackgroundColor(backgroundColor);
        btn16.setTextColor(textColor);
        btn16.setText("CorpoGigante OFF"); //Remover Neblina

        btn17 = new Button(this);
        btn17.setLayoutParams(btns_params);
        btn17.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn17.setTypeface(null, bold);
        btn17.setBackgroundColor(backgroundColor);
        btn17.setTextColor(textColor);
        btn17.setText("nofog OFF"); //finaizarmos o modmenu até aqui os outros de baixo é ilusao ate que coloque o codigo a baixo..assim buguei ksksks

        sb_text7 = new TextView(this);
        sb_text7.setLayoutParams(txt_params);
        sb_text7.setText("No Recoil : 0");
        sb_text7.setTextSize(textSize);
        sb_text7.setTypeface(null, bold);
        sb_text7.setTextColor(textColor);
        sb7 = new SeekBar(this); //No Recoil : 0
        sb7.setMax(500);
        sb7.setLayoutParams(seekbar_params);

        btn18 = new Button(this);
        btn18.setLayoutParams(btns_params);
        btn18.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn18.setTypeface(null, bold);
        btn18.setBackgroundColor(backgroundColor);
        btn18.setTextColor(textColor);
        btn18.setText("No Elimine OFF"); //Remover mira

        btn19 = new Button(this);
        btn19.setLayoutParams(btns_params);
        btn19.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn19.setTypeface(null, bold);
        btn19.setBackgroundColor(backgroundColor);
        btn19.setTextColor(textColor);
        btn19.setText("Aim Lock OFF"); //MedKit Correndo

        btn20 = new Button(this);
        btn20.setLayoutParams(btns_params);
        btn20.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn20.setTypeface(null, bold);
        btn20.setBackgroundColor(backgroundColor);
        btn20.setTextColor(textColor);
        btn20.setText("Aim Semi OFF"); //Visão de Águia

        btn21 = new Button(this);
        btn21.setLayoutParams(btns_params);
        btn21.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn21.setTypeface(null, bold);
        btn21.setBackgroundColor(backgroundColor);
        btn21.setTextColor(textColor);
        btn21.setText("HIt Party Body OFF"); //Ícone Invisível

        btn22 = new Button(this);
        btn22.setLayoutParams(btns_params);
        btn22.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn22.setTypeface(null, bold);
        btn22.setBackgroundColor(backgroundColor);
        btn22.setTextColor(textColor);
        btn22.setText("Bypass MTP OFF"); //IMEI

        btn23 = new Button(this);
        btn23.setLayoutParams(btns_params);
        btn23.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn23.setTypeface(null, bold);
        btn23.setBackgroundColor(backgroundColor);
        btn23.setTextColor(textColor);
        btn23.setText("Anti-Logs OFF"); //MEID

        btn24 = new Button(this);
        btn24.setLayoutParams(btns_params);
        btn24.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn24.setTypeface(null, bold);
        btn24.setBackgroundColor(backgroundColor);
        btn24.setTextColor(textColor);
        btn24.setText("semfunction OFF"); //SERIAL*/

        /*btn25 = new Button(this);
        btn25.setLayoutParams(btns_params);
        btn25.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        btn25.setTypeface(null, bold);
        btn25.setBackgroundColor(backgroundColor);
        btn25.setTextColor(textColor);
        btn25.setText("SAIR DA PARTIDA OFF"); //SAIR DA PARTIDA*/

        linearLayout_com_botoes.addView(btn1);
       // linearLayout_com_botoes.addView(sb_text1);
        //linearLayout_com_botoes.addView(sb1);
        //linearLayout_com_botoes.addView(sb_text2);
        //linearLayout_com_botoes.addView(sb2);
        linearLayout_com_botoes.addView(btn2);
        linearLayout_com_botoes.addView(btn3);
        linearLayout_com_botoes.addView(btn4);
        linearLayout_com_botoes.addView(btn5);
        linearLayout_com_botoes.addView(btn6);
        linearLayout_com_botoes.addView(btn7);
        linearLayout_com_botoes.addView(btn8);
        linearLayout_com_botoes.addView(btn9);
        linearLayout_com_botoes.addView(btn10);
        linearLayout_com_botoes.addView(btn11);
        //linearLayout_com_botoes.addView(sb_text3);
        //linearLayout_com_botoes.addView(sb3);
        linearLayout_com_botoes.addView(btn12);
        //linearLayout_com_botoes.addView(sb_text4);
        //linearLayout_com_botoes.addView(sb4);
        linearLayout_com_botoes.addView(btn13);
        //linearLayout_com_botoes.addView(sb_text5);
        //linearLayout_com_botoes.addView(sb5);
        //linearLayout_com_botoes.addView(sb_text6);
        //linearLayout_com_botoes.addView(sb6);
        linearLayout_com_botoes.addView(btn14);
        linearLayout_com_botoes.addView(btn15);
        linearLayout_com_botoes.addView(btn16);
        linearLayout_com_botoes.addView(btn17);
        //linearLayout_com_botoes.addView(sb_text7);
        //linearLayout_com_botoes.addView(sb7);
        linearLayout_com_botoes.addView(btn18);
        linearLayout_com_botoes.addView(btn19);
        linearLayout_com_botoes.addView(btn20);
        linearLayout_com_botoes.addView(btn21);
        linearLayout_com_botoes.addView(btn22);
        linearLayout_com_botoes.addView(btn23);
        linearLayout_com_botoes.addView(btn24);
        //linearLayout_com_botoes.addView(btn25);




        /*
         *
         *   REGIÃO ONDE ESTARÁ TUDO QUE APARECE QUANDO CLICA NO ÍCONE FLUTUANTE
         *
         * */


        /*
         *
         * TEXTVIEW COM NOME DO JOGO E VERSÃO
         *
         * */
        TextView nomeJogoVersao = new TextView(this);
        LinearLayout.LayoutParams nomeJogoVersao_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        nomeJogoVersao_Params.gravity = Gravity.CENTER;
        nomeJogoVersao_Params.topMargin = dp(12);
        nomeJogoVersao_Params.bottomMargin = dp(12);
        nomeJogoVersao.setLayoutParams(nomeJogoVersao_Params);
        nomeJogoVersao.setText("Free Fire v1.39.0");
        nomeJogoVersao.setTextColor(Color.parseColor("#ffffff"));
        /*
         *
         * TEXTVIEW COM NOME DO JOGO E VERSÃO
         *
         * */

        /*
         *
         *   BOTÃO PARA FECHAR O MENU
         *
         * */
        btnClose =new Button(this);
        LinearLayout.LayoutParams btnClose_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, dp(33));
        btnClose.setLayoutParams(btnClose_params);
        btnClose.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        btnClose.setTypeface(null, bold);
        btnClose.setBackgroundColor(backgroundColor);
        btnClose.setTextColor(textColor);
        btnClose.setText("CLOSE"); //SAIR DA PARTIDA




        /*
         *
         *   BOTÃO PARA FECHAR O MENU
         *
         * */

        scrollView.addView(linearLayout_com_botoes);
        linearLayoutPrincipal.addView(platinmodsTV);
        linearLayoutPrincipal.addView(txtUsuarioValidade);
        linearLayoutPrincipal.addView(scrollView);
        linearLayoutPrincipal.addView(nomeJogoVersao);
        linearLayoutPrincipal.addView(btnClose);

        // expanded_container.addView(fechar_expanded_imageview);
        expanded_container.addView(linearLayoutPrincipal);


        root_container.addView(collapse_view);
        root_container.addView(expanded_container);
        frameLayout.addView(root_container);
    }

    @Override
    public void onCreate() {
        super.onCreate();
       /* SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String usuario = sharedPreferences.getString("menu.login", null);
        String senha = sharedPreferences.getString("menu.senha", null);

        String validade = sharedPreferences.getString("menu.validade", null);
        String infoUsuario = String.format("Usuário: %s\nValidade: %s", usuario, validade);*/
        //txtUsuarioValidade.setText(infoUsuario);
        setupMenu();
        collapse_view.setAlpha(0.8f);
        expanded_container.setAlpha(0.8f);
        int flag;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1){
            flag = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        else {
            flag = WindowManager.LayoutParams.TYPE_PHONE;
        }

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,flag, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(frameLayout, params);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = null;
                AlertDialog alertBuilder = new AlertDialog.Builder(getBaseContext())
                        .setMessage("\n\tDeseja fechar?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FloatingViewService.this.stopSelf();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();

                int flag;
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1){
                    flag = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
                }
                else {
                    flag = WindowManager.LayoutParams.TYPE_PHONE;
                }
                alertBuilder.getWindow().setType(flag);
                alertBuilder.show();


            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapse_view.setVisibility(View.VISIBLE);
                expanded_container.setVisibility(View.GONE);
            }
        });

        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);
                        if (Xdiff < 10 && Ydiff < 10) {
                            if (isViewCollapsed()) {
                                collapse_view.setVisibility(View.GONE);
                                expanded_container.setVisibility(View.VISIBLE);
                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(frameLayout, params);
                        return true;
                }
                return false;
            }
        });


        try {
            raf = new RandomAccessFile("/sdcard/sound_tisk.config", "rw");
        } catch (FileNotFoundException e) {
            Toast.makeText(getBaseContext(), "Arquivo do jogo não encontrado abra o jogo primeiro!", Toast.LENGTH_LONG).show();

        }

        btn1.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("cp1");
                    btn1.setText("Céu preto ON");
                    btn1.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("cp0");
                    btn1.setText("Céu preto OFF");
                    isActive = true;
                    btn1.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("np1");
                    btn2.setText("No Paraquedas ON");
                    btn2.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("np0");
                    btn2.setText("No Paraquedas OFF");
                    isActive = true;
                    btn2.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("isfe1");
                    btn3.setText("Todos Feminino ON");
                    btn3.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("isfe0");
                    btn3.setText("Todos Feminino OFF");
                    isActive = true;
                    btn3.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("lsrl1");
                    btn4.setText("Dispersao ON");
                    btn4.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("lsrl0");
                    btn4.setText("Dispersao OFF");
                    isActive = true;
                    btn4.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("cwf1");
                    btn5.setText("Atirar na agua ON");
                    btn5.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("cwf0");
                    btn5.setText("Atirar na agua OFF");
                    isActive = true;
                    btn5.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("srs1");
                    btn6.setText("Speed Hack ON");
                    btn6.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("srs0");
                    btn6.setText("Speed Hack OFF");
                    isActive = true;
                    btn6.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("ess1");
                    btn7.setText("Medkit 3s ON");
                    btn7.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("ess0");
                    btn7.setText("Medkit 3s OFF");
                    isActive = true;
                    btn7.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("sf1");
                    btn8.setText("Speed Fire ON");
                    btn8.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("sf0");
                    btn8.setText("Speed Fire OFF");
                    isActive = true;
                    btn8.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("va1");
                    btn9.setText("Visao de Aguia ON");
                    btn9.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("va0");
                    btn9.setText("Visao de Aguia OFF");
                    isActive = true;
                    btn9.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("cv1");
                    btn10.setText("Chuva de Balas ON");
                    btn10.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("cv0");
                    btn10.setText("Chuva de Balas OFF");
                    isActive = true;
                    btn10.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("v31");
                    btn11.setText("Walhack V3 ON");
                    btn11.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("v30");
                    btn11.setText("Walhack V3 OFF");
                    isActive = true;
                    btn11.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("v41");
                    btn12.setText("Walhack V4 ON");
                    btn12.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("v40");
                    btn12.setText("Walhack V4 OFF");
                    isActive = true;
                    btn12.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("mk1");
                    btn13.setText("Medkit Correndo ON");
                    btn13.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("mk0");
                    btn13.setText("Medkit Correndo OFF");
                    isActive = true;
                    btn13.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("rm1");
                    btn14.setText("RemoverMirao ON");
                    btn14.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("rm0");
                    btn14.setText("RemoverMira OFF");
                    isActive = true;
                    btn14.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("g31");
                    btn15.setText("GhosthackV3 ON");
                    btn15.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("g30");
                    btn15.setText("GhosthackV3 OFF");
                    isActive = true;
                    btn15.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("cg1");
                    btn16.setText("CorpoGigante ON");
                    btn16.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("cg0");
                    btn16.setText("CorpoGigante OFF");
                    isActive = true;
                    btn16.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn17.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("nf1");
                    btn17.setText("No Fog ON");
                    btn17.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("nf0");
                    btn17.setText("No Fog OFF");
                    isActive = true;
                    btn17.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("nc1");
                    btn18.setText("No elimine ON");
                    btn18.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("nc0");
                    btn18.setText("No Elimine OFF");
                    isActive = true;
                    btn18.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn19.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("aiml1");
                    btn19.setText("Aim Lock ON");
                    btn19.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("aiml0");
                    btn19.setText("Aim lock OFF");
                    isActive = true;
                    btn19.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("aims1");
                    btn20.setText("Aim Semi ON");
                    btn20.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("aims0");
                    btn20.setText("Aim Semi OFF");
                    isActive = true;
                    btn20.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn21.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("hitp1");
                    btn21.setText("HIt Party Body ON");
                    btn21.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("hitp0");
                    btn21.setText("HIt Party Body OFF");
                    isActive = true;
                    btn21.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("mtp1");
                    btn22.setText("Bypass MTP ON");
                    btn22.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("mtp0");
                    btn22.setText("Bypass MTP OFF");
                    isActive = true;
                    btn22.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

        btn23.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;
            @Override
            public void onClick(View v) {
                if (isActive){

                    writeMod("ilog1");
                    btn23.setText("Anti-Logs ON");
                    btn23.setBackgroundColor(Color.parseColor("#FF378BB7"));
                    isActive = false;
                }
                else {
                    writeMod("ilog0");
                    btn23.setText("Anti-Logs OFF");
                    isActive = true;
                    btn23.setBackgroundColor(Color.parseColor("#FFE90909"));
                }
            }
        });

    }

    private boolean isViewCollapsed() {
        return frameLayout == null || collapse_view.getVisibility() == View.VISIBLE;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (frameLayout != null) this.mWindowManager.removeView(frameLayout);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private int dp(int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    private void writeMod(String hex) {
        try {
            raf.seek(0);
            raf.write(hex.getBytes());
            Log.i("Easy Log", "writeMod: "+ raf.readUTF());
        } catch (IOException paramString1) {
            paramString1.printStackTrace();
        }
    }
}
