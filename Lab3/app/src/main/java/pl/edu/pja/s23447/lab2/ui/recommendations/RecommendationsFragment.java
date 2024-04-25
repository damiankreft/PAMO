package pl.edu.pja.s23447.lab2.ui.recommendations;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.edu.pja.s23447.lab2.R;

public class RecommendationsFragment extends Fragment {

    public static RecommendationsFragment newInstance() {
        return new RecommendationsFragment();
    }

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView bmiTextView;

    private RecommendationsViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommendations, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendationsViewModel.class);
        // TODO: Use the ViewModel
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);

        heightEditText =
                (EditText) getView().findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(valueChangedTextWatcher);

        weightEditText =
                (EditText) getView().findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(valueChangedTextWatcher);
    }

    private void calculate() {
        String heightString = heightEditText.getText().toString();
        String weightString = weightEditText.getText().toString();
        if (!heightString.isEmpty() && !weightString.isEmpty())
        {
            double height = Double.parseDouble(heightString);
            double weight = Double.parseDouble(weightString);
            double bmi = weight / Math.pow(height, 2);
            bmiTextView.setText(numberFormat.format(bmi));
        }
    }

    private final TextWatcher valueChangedTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
}