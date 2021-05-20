package fpt.gstpro.testcustomdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import fpt.gstpro.testcustomdialog.databinding.DialogCustomBinding;

public class CustomDialog extends Dialog {

    DialogCustomBinding binding;
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.dialog_custom, null, false);
        setContentView(binding.getRoot());
        binding.btnClose.setOnClickListener(view -> {
            dismiss();
        });
    }
}
