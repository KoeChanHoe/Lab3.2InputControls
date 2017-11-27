package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import static my.edu.tarc.lab32inputcontrols.R.string.male;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private double basicPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.age,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);

        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TODO : calculate basic premium according to age group
        switch (position){
            case 0:
                basicPremium = 50;


                break;
            case 1:
                basicPremium = 55;
                break;
            case 2:
                basicPremium = 60;
                break;
            case 3:
                basicPremium = 70;
                break;
            case 4:
                basicPremium = 120;
                break;
            case 5:
                basicPremium = 160;
                break;
            case 6:
                basicPremium = 200;
                break;
            case 7:
                basicPremium = 250;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int ageIndex = spinnerAge.getSelectedItemPosition();

        RadioGroup radioGender = (RadioGroup)findViewById(R.id.radioGender);

        //Identify radio button selected by user
        int gender = radioGender.getCheckedRadioButtonId();

        if(gender == R.id.radioButtonMale){
            boolean male = radioButtonMale.isChecked();

        }
        else {
            boolean female =radioButtonFemale.isChecked();
        }

        boolean smoker = checkBoxSmoker.isChecked();


    }



}
