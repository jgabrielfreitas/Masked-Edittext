package com.github.pinball83.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.github.pinball83.maskededittext.MaskedMaterialEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MaskedMaterialEditText maskedEditText = (MaskedMaterialEditText) this.findViewById(R.id.masked_edit_text);
        maskedEditText.setMaskIconCallback(new MaskedMaterialEditText.MaskIconCallback() {
            @Override
            public void onIconPushed() {
                System.out.println("clear text");
                maskedEditText.setMaskedText("          ");
            }
        });

        final MaskedMaterialEditText maskedEditText1 = new MaskedMaterialEditText(this,
                "8 (***) *** **-**",
                "*",
                getResources().getDrawable(R.drawable.ic_account_circle));
        maskedEditText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        maskedEditText1.setMaskIconCallback(new MaskedMaterialEditText.MaskIconCallback() {
            @Override
            public void onIconPushed() {
                System.out.println("Icon pushed");
                Toast.makeText(MainActivity.this, "Unmasked text " + maskedEditText1.getUnmaskedText(), Toast.LENGTH_SHORT).show();
            }
        });

        MaskedMaterialEditText editText1 = new MaskedMaterialEditText(this, "8 (***) *** **-**", "*");
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText1.setEnabled(false);
        editText1.setMaskedText("1234567891");
        editText1.setFormat("[1][2][3] [4][5][6]-[7][8]-[10][9]");
//        final String format = editText1.getUnmaskedText();
//        System.out.println("format = " + format);

        MaskedMaterialEditText editText2 = new MaskedMaterialEditText(this, "8 (***) *** **-**", "*");
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText2.setEnabled(false);
        editText2.setMaskedText("9263998787");

        MaskedMaterialEditText secondEditText = new MaskedMaterialEditText(this, "Q***************", "*");

        MaskedMaterialEditText secondEditText1 = new MaskedMaterialEditText(this, "**-****-*********", "*");

        MaskedMaterialEditText thirdEditText = new MaskedMaterialEditText(this, "*****", "*");
        thirdEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        MaskedMaterialEditText thirdEditText1 = new MaskedMaterialEditText(this, "***4***", "*");
        thirdEditText1.setMaskedText("888488");
        thirdEditText1.setInputType(InputType.TYPE_CLASS_NUMBER);

        MaskedMaterialEditText fordEditText = new MaskedMaterialEditText(this, "TSH***************", "*");
        fordEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        // check without mask
        MaskedMaterialEditText fordEditText1 = new MaskedMaterialEditText(this);
        fordEditText1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        MaskedMaterialEditText fordEditText2 = new MaskedMaterialEditText(this);
        fordEditText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        MaskedMaterialEditText fordEditText3 = new MaskedMaterialEditText(this);
        fordEditText3.setInputType(InputType.TYPE_CLASS_NUMBER);

        LinearLayout layout = (LinearLayout) findViewById(R.id.container);
        layout.addView(maskedEditText1);
        layout.addView(editText1);
        layout.addView(editText2);
        layout.addView(secondEditText);
        layout.addView(secondEditText1);
        layout.addView(thirdEditText);
        layout.addView(thirdEditText1);
        layout.addView(fordEditText);
        layout.addView(fordEditText1);
        layout.addView(fordEditText2);
        layout.addView(fordEditText3);
    }
}
