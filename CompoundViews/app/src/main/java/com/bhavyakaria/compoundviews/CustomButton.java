package com.bhavyakaria.compoundviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomButton extends LinearLayout {

    TextView buttonTitle;
    ProgressBar progressBar;
    Button uploadButton;
    TypedArray typedArray;
    public ClickListener listener;

    String title = "";
    int id = 100;

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public CustomButton(Context context) {
        super(context);
        initializeViews(context);
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.CustomButton);
        title = typedArray.getText(R.styleable.CustomButton_buttonTitle).toString();
        id = typedArray.getResourceId(R.styleable.CustomButton_buttonId, 0);
        typedArray.recycle();
        initializeViews(context);
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.CustomButton);
        title = typedArray.getText(R.styleable.CustomButton_buttonTitle).toString();
        id = typedArray.getResourceId(R.styleable.CustomButton_buttonId, 0);
        typedArray.recycle();
        initializeViews(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.CustomButton);
        title = typedArray.getText(R.styleable.CustomButton_buttonTitle).toString();
        id = typedArray.getResourceId(R.styleable.CustomButton_buttonId, 0);
        typedArray.recycle();
        initializeViews(context);
    }

    private void initializeViews(Context context) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.layout_for_custom_button, this);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        buttonTitle = findViewById(R.id.text_view_profile_pic);
        buttonTitle.setText(title);

        uploadButton = findViewById(R.id.btn_upload_profile_pic);

        uploadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onUploadButtonClicked(view, id);
                }
            }
        });

    }
}
