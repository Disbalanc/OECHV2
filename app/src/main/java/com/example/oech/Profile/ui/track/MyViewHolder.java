package com.example.oech.Profile.ui.track;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oech.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewTitle;
    TextView textViewTitle;
    EditText editTextOne;
    EditText editTextTwo;
    EditText editTextThree;
    EditText editTextFour;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewTitle = itemView.findViewById(R.id.imageViewPointS);
        textViewTitle = itemView.findViewById(R.id.textTitle);

        editTextOne = itemView.findViewById(R.id.editTextAddressPointS);
        editTextTwo = itemView.findViewById(R.id.editTextCountryPointS);
        editTextThree = itemView.findViewById(R.id.editTextPhoneNumberPointS);
        editTextFour = itemView.findViewById(R.id.editTextOthersPointS);
    }
}
