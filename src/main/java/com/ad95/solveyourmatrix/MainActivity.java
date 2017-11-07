package com.ad95.solveyourmatrix;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    public EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        if(intent.getIntExtra("exit",0)==1)
            finish();
        checkFirstRun();
        final Bundle bundle=new Bundle();
        Button button=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        e6=(EditText)findViewById(R.id.editText6);
        e7=(EditText)findViewById(R.id.editText7);
        e8=(EditText)findViewById(R.id.editText8);
        e9=(EditText)findViewById(R.id.editText9);
        e10=(EditText)findViewById(R.id.editText10);
        e11=(EditText)findViewById(R.id.editText11);
        e12=(EditText)findViewById(R.id.editText12);
        e13=(EditText)findViewById(R.id.editText13);
        e14=(EditText)findViewById(R.id.editText14);
        e15=(EditText)findViewById(R.id.editText15);
        e16=(EditText)findViewById(R.id.editText16);
        e17=(EditText)findViewById(R.id.editText17);
        e18=(EditText)findViewById(R.id.editText18);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String[] ij={e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),e7.getText().toString(),e8.getText().toString(),e9.getText().toString()};
                                          String[] oj ={e10.getText().toString(),e11.getText().toString(),e12.getText().toString(),e13.getText().toString(),e14.getText().toString(),e15.getText().toString(),e16.getText().toString(),e17.getText().toString(),e18.getText().toString()};
                                          int b=0,c=0,k=0,l=0,a=0,d=0;
                                          for(int j=0;j<9;j++)
                                              if(ij[j].matches("")) {
                                                  b += 1;
                                                  k = j;
                                              }
                                          for(int j=0;j<9;j++) {
                                              if (oj[j].matches("")) {
                                                  c += 1;
                                                  l = j;
                                              }
                                          }
                                          for(int i=0;i<9;i++)
                                              for(int j=0;j<9;j++) {
                                                  if (ij[i].matches(oj[j])) {
                                                      a++;
                                                      break;
                                                  }
                                              }
                                          for(int i=0;i<9;i++)
                                              for(int j=0;j<9;j++) {
                                                  if (oj[i].matches(ij[j])) {
                                                      d++;
                                                      break;
                                                  }
                                              }
                                          if(b==1 & c==1 & a==9 & d==9) {
                                              bundle.putStringArray("input",ij);
                                              bundle.putStringArray("output",oj);
                                              bundle.putInt("emptyinit", k);
                                              Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                                              intent.putExtras(bundle);
                                              startActivity(intent);
                                          }
                                          else if(b==0 | c==0)
                                              Toast.makeText(MainActivity.this, "Need atleast one empty space!", Toast.LENGTH_LONG).show();
                                          else if(b>1 | c>1)
                                              Toast.makeText(MainActivity.this, "Number of empty spaces cannot be more than one!", Toast.LENGTH_LONG).show();
                                          else if(a!=9 | d!=9)
                                              Toast.makeText(MainActivity.this, "Matrix numbers are not identical!", Toast.LENGTH_LONG).show();
                                          else
                                              Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
                                      }
                                  }
        );
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                e7.setText("");
                e8.setText("");
                e9.setText("");
                e10.setText("");
                e11.setText("");
                e12.setText("");
                e13.setText("");
                e14.setText("");
                e15.setText("");
                e16.setText("");
                e17.setText("");
                e18.setText("");
                Toast.makeText(MainActivity.this, "Reset!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id==R.id.help){
            final AlertDialog.Builder alertDialog= new AlertDialog.Builder(this) {
                @NonNull
                @Override
                public AlertDialog create() {
                    setTitle("How it works!");
                    setMessage(R.string.helptext);
                    setCancelable(true);
                    setNeutralButton("Set sample values!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            e1.setText("1");
                            e2.setText("2");
                            e3.setText("3");
                            e4.setText("4");
                            e5.setText("6");
                            e6.setText("8");
                            e7.setText("7");
                            e8.setText("5");
                            e9.setText("");
                            e10.setText("1");
                            e11.setText("2");
                            e12.setText("3");
                            e13.setText("4");
                            e14.setText("5");
                            e15.setText("6");
                            e16.setText("7");
                            e17.setText("");
                            e18.setText("8");
                        }
                    });
                    return super.create();
                }
            };
            alertDialog.show();
        }
        if(id==R.id.about){
            final AlertDialog.Builder alertDialog1= new AlertDialog.Builder(this){
                @NonNull
                @Override
                public AlertDialog create() {
                    setTitle("Creators :");
                    TextView myMsg = new TextView(MainActivity.this);
                    myMsg.setText(R.string.abouttext);
                    myMsg.setTextIsSelectable(true);
                    myMsg.setTextSize(45);
                    myMsg.setBackgroundColor(Color.rgb(0, 40, 0));
                    myMsg.setTextColor(Color.rgb(178,150,0));
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    setView(myMsg);
                    setCancelable(true);
                    return super.create();
                }
            };
            alertDialog1.show();
        }
        if(id==R.id.exit){
            final AlertDialog.Builder alertDialog2= new AlertDialog.Builder(this){
                @NonNull
                @Override
                public AlertDialog create() {
                    setTitle("Do you want to exit?");
                    setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    return super.create();
                }
            };
            alertDialog2.show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            final AlertDialog.Builder alertDialog= new AlertDialog.Builder(this) {
                @NonNull
                @Override
                public AlertDialog create() {
                    setTitle("How it works!");
                    setMessage(R.string.helptext + "\nYou can find this in option->help.");
                    setCancelable(true);
                    setNeutralButton("Set sample values!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            e1.setText("1");
                            e2.setText("2");
                            e3.setText("3");
                            e4.setText("4");
                            e5.setText("6");
                            e6.setText("8");
                            e7.setText("7");
                            e8.setText("5");
                            e9.setText("");
                            e10.setText("1");
                            e11.setText("2");
                            e12.setText("3");
                            e13.setText("4");
                            e14.setText("5");
                            e15.setText("6");
                            e16.setText("7");
                            e17.setText("");
                            e18.setText("8");
                        }
                    });
                    return super.create();
                }
            };
            alertDialog.show();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }
}
