package com.jwchuang.androidcolorpickertest;

import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.jwchuang.colorpickerdialog.ColorPickerDialogListener;
import com.jwchuang.colorpickerdialog.SimpleColorPickerDialog;

/**
 * a simple demo
 */
public class MainActivity extends AppCompatActivity {

    private AppCompatButton btn;
    private int DIALGE_ID = 0;
    public static final int[] MY_COLORS = {
            0xFFE91E63, // PINK 500
            0xFFFF2C93, // LIGHT PINK 500
            0xFF3F51B5, // INDIGO 500
            0xFF2196F3, // BLUE 500
            0xFF03A9F4, // LIGHT BLUE 500
            0xFF00BCD4, // CYAN 500
            0xFF009688, // TEAL 500
            0xFF4CAF50, // GREEN 500
            0xFF8BC34A, // LIGHT GREEN 500
            0xFFCDDC39, // LIME 500
            0xFFFFEB3B, // YELLOW 500
            0xFFFFC107, // AMBER 500
            0xFFFF9800, // ORANGE 500
            0xFF795548, // BROWN 500
            0xFF9C27B0, // PURPLE 500
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
    }

    private void initView() {
        btn = (AppCompatButton) findViewById(R.id.btnColor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showColorDialog();
            }
        });
    }

    private void showColorDialog() {
        SimpleColorPickerDialog colorPickerDialog = SimpleColorPickerDialog.newBuilder()
                //set default color
                .setColor(0xFFFFEB3B)
                //set titile
                .setDialogTitle(R.string.app_name)
                //set presets / custom mode
                .setDialogType(SimpleColorPickerDialog.TYPE_PRESETS)
                //show alpha slider
                .setShowAlphaSlider(true)
                //set callbasck id
                .setDialogId(DIALGE_ID)
                //set if enable custom
                .setAllowCustom(true)
                //set preset colors
                .setPresets(MY_COLORS)
                //set preset enabled
                .setAllowPresets(false)
                .create();

        colorPickerDialog.setColorPickerDialogListener(pickerDialogListener);
        colorPickerDialog.show(getFragmentManager(), "color-dialog");
    }


    /**
     * callback for select event
     */
    private ColorPickerDialogListener pickerDialogListener = new ColorPickerDialogListener() {
        @Override
        public void onColorSelected(int dialogId, @ColorInt int color) {
            if (dialogId == DIALGE_ID) {
                Toast.makeText(MainActivity.this, Integer.toString(color), Toast.LENGTH_LONG);
            }
        }

        @Override
        public void onDialogDismissed(int dialogId) {
            if (dialogId == DIALGE_ID) {
                Toast.makeText(MainActivity.this, "dismiss", Toast.LENGTH_LONG);
            }
        }
    };
}
