package com.apsara.foodmanduassignment.ui.More;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.apsara.foodmanduassignment.R;

public class SendFragmentActivity extends Fragment {

    private TextView txtmore, txtfirst, txtsecond, txtthird, txtfourth;
    private Button btnlogin;

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        sendViewModel =
//                ViewModelProviders.of(this).get(SendViewModel.class);
       View view = inflater.inflate(R.layout.fragment_send, container, false);
//        final TextView textView = root.findViewById(R.id.text_send);
//        sendViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        txtmore = view.findViewById(R.id.txtmore);
        txtfirst = view.findViewById(R.id.txtfirst);
        txtsecond = view.findViewById(R.id.txtSecond);
        txtthird = view.findViewById(R.id.txtthird);
        txtfourth = view.findViewById(R.id.txtfourth);
        btnlogin = view.findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}