package com.example.calculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculator3.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onClicks();
    }

    public void onClicks() {

       // binding.btn2.setOnClickListener(this::onClick);
        binding.btn5.setOnClickListener(this::onClick);
        binding.btn6.setOnClickListener(this::onClick);
        binding.btn7.setOnClickListener(this::onClick);
        binding.btn9.setOnClickListener(this::onClick);
        binding.btn10.setOnClickListener(this::onClick);
        binding.btn11.setOnClickListener(this::onClick);
        binding.btn13.setOnClickListener(this::onClick);
        binding.btn14.setOnClickListener(this::onClick);
        binding.btn15.setOnClickListener(this::onClick);
        binding.btn17.setOnClickListener(this::onClick);
        binding.btn18.setOnClickListener(this::onClick);


        binding.btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textCal = getCaltext();
                if (textCal.contains("-")) {
                    String[] calData = binding.text1.getText().toString().split("-");
                    if(calData.length==2)
                    {
                        startCal(Double.parseDouble(calData[0]),'-',Double.parseDouble(calData[1]));
                    }
                }
                else if (textCal.contains("/"))
                {
                    String [] calData=binding.text1.getText().toString().split("/");
                    if(calData.length==2)
                    {
                        startCal(Double.parseDouble(calData[0]),'/',Double.parseDouble(calData[1]));
                    }
                }
                else if(textCal.contains("+"))
                {
                    String[] calData = binding.text1.getText().toString().split("\\+");
                    if(calData.length==2)
                    {
                        startCal(Double.parseDouble(calData[0]),'+',Double.parseDouble(calData[1]));
                    }
                }
                else if(textCal.contains("*"))
                {
                    String[] calData = binding.text1.getText().toString().split("\\*");
                    if(calData.length==2)
                    {
                        startCal(Double.parseDouble(calData[0]),'*',Double.parseDouble(calData[1]));
                    }
                }
                else if(textCal.contains("%"))
                {
                    String[] calData = binding.text1.getText().toString().split("%");
                    if(calData.length==2)
                    {
                        startCal(Double.parseDouble(calData[0]),'%',Double.parseDouble(calData[1]));
                    }
                }
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOP(binding.btn3);
            }
        });

        binding.btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOP(binding.btn16);
            }
        });
        binding.btn12.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleOP(binding.btn12);
            }
        }));
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOP(binding.btn8);
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOP(binding.btn4);
            }
        });
    }
    private void handleOP(MaterialButton materialButton)
    {
        String c = binding.text1.getText().toString();

            char ch = c.charAt(c.length() - 1);
            if (ch != '-' && ch != '+' && ch != '/' && ch != '%'&& ch!='*') {
                binding.text1.append(materialButton.getText().toString());

            }
    }
    private void startCal(double first,char op,double second)
    {
        if(op=='+')
        {
            binding.text1.setText((first+second)+"");
        }
        else if(op=='-')
        {
            binding.text1.setText((first-second)+"");
        }
        else if(op=='*')
        {
            binding.text1.setText((first*second)+"");
        }

        else if(op=='/'&& second==0)
        {
            binding.text1.setText("Can not divided by zero!");
        }
        else if(op=='/'&& second!=0)
        {
            binding.text1.setText((first/second)+"");
        }
        else if(op=='%')
        {
            binding.text1.setText((first%second)+"");
        }

    }
    private String getCaltext()
    {
        return binding.text1.getText().toString().trim();
    }
    private void clear()
    {
        binding.text1.setText("");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    @Override
    public void onClick(View view) {
        MaterialButton btn = (MaterialButton) view;
        binding.text1.append(btn.getText().toString());
    }

}


