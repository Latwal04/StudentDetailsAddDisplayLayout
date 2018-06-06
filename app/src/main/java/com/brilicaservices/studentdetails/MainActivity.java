package com.brilicaservices.studentdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Student
{
    String name,address,college;
    int phone;
    Student(String name,String address,String college,int phone)
    {
        this.name=name;
        this.address=address;
        this.college=college;
        this.phone=phone;
    }
}

public class MainActivity extends AppCompatActivity {
    TextView user_name, user_address,user_college,user_phone,display,message ;
    EditText enter_user_name, enter_user_address, enter_user_college,enter_user_phone;
    Button add_button, display_button;
    ArrayList<Student> std=new ArrayList<>();
    String name,address,college;
    int phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message=(TextView)findViewById(R.id.student_txt_view);
        display=(TextView)findViewById(R.id.student_disp);
        user_phone=(TextView) findViewById(R.id.phone_txtview);
        user_name = (TextView) findViewById(R.id.name_txtview);
        user_address = (TextView) findViewById(R.id.address_txtview);
        user_college = (TextView) findViewById(R.id.college_txtview);
        enter_user_name = (EditText) findViewById(R.id.name_edit_text);
        enter_user_address = (EditText) findViewById(R.id.address_edit_text);
        enter_user_college = (EditText) findViewById(R.id.college_edit_text);
        enter_user_phone=(EditText)findViewById(R.id.phone_edit_text);
        add_button = (Button) findViewById(R.id.sb_btn);
        display_button = (Button) findViewById(R.id.disp_btn);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    name=String.valueOf(enter_user_name.getText());
                    address=String.valueOf(enter_user_address.getText());
                    college=String.valueOf(enter_user_college.getText());
                    phone=Integer.parseInt(enter_user_phone.getText().toString());
                    std.add(new Student(name,address,college,phone));
                }
                catch(NumberFormatException e){


                }

            }
        });
        display_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<std.size();i++)
                {
                    display.setText(display.getText() +"\n" +std.get(i).name);
                    display.setText(display.getText( )+"\n" +std.get(i).address);
                    display.setText(display.getText() +"\n" +std.get(i).college);
                    display.setText(display.getText() +"\n" +std.get(i).phone);
                    display.setText(display.getText() +"\n******");
                }

            }
        });
    }
}
