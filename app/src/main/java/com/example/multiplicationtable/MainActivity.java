package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private EditText number_text,limit_text;
    private Button generatebutton;
    ArrayList<String>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        generatebutton = (Button) findViewById(R.id.generate);
        number_text = (EditText)findViewById(R.id.edtnum);
        limit_text = (EditText)findViewById(R.id.edtlimit);
        list=new ArrayList<>();
        generatebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (number_text.getText().toString().trim().isEmpty() && limit_text.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please Enter Any Number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    int getnum = Integer.parseInt(number_text.getText().toString().trim());
                    int getlimit = Integer.parseInt(limit_text.getText().toString().trim());
                    if (!list.isEmpty())
                    {
                        list.clear();
                        printTable(getnum,getlimit);
                    }
                    else
                    {
                        list.clear();
                        printTable(getnum,getlimit);
                    }

                }
            }
        });
    }
    private void printTable(int number,int limit)
    {
        for(int i=1;i<=limit;i++)
        {
            String result = number+"   X   "+i+"   =   "+number*i;
            list.add(result);

            final ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.custom_table_list,R.id.texttable,list);
            listview.setAdapter(adapter);
        }
    }
}
