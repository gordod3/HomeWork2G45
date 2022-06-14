package kg.geektech.homework145;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditFragment extends Fragment {
    private Button button;
    private EditText editText;
    private String text;
    private int num;

    public EditFragment(@Nullable String text, int num) {
        this.text = text;
        this.num = num;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.fragment_edit_button);
        editText = view.findViewById(R.id.fragment_edit_editText);
        editText.setText(text);
        num++;
        requireActivity().setTitle("Fragment " + num);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num != 5) {
                    if (!editText.getText().toString().isEmpty())
                        requireActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.activity_main_container, new EditFragment(editText.getText().toString(), num)).commit();
                    else editText.setError("Please write anything");
                }
            }
        });
    }
}