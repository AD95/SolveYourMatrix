package com.ad95.solveyourmatrix;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity {
    public Button e1,e2,e3,e4,e5,e6,e7,e8,e9,t1,t2,t3,t4,t5,t6,t7,t8,t9;
    public TextView c;
    public int counter=1,ei=0;
    Button o=null;

    void check(final String[] i){
        c.setText(String.valueOf(counter));
        final String[] ij={e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),e7.getText().toString(),e8.getText().toString(),e9.getText().toString()};
        for(int j=0;j<9;j++)
            if(ij[j].matches("")) {
                ei = j;
            }
        if(ei==0) o=e1;
        else if(ei==1) o=e2;
        else if(ei==2) o=e3;
        else if(ei==3) o=e4;
        else if(ei==4) o=e5;
        else if(ei==5) o=e6;
        else if(ei==6) o=e7;
        else if(ei==7) o=e8;
        else if(ei==8) o=e9;
        if(     e1.getText().toString().matches(t1.getText().toString())&
                e2.getText().toString().matches(t2.getText().toString())&
                e3.getText().toString().matches(t3.getText().toString())&
                e4.getText().toString().matches(t4.getText().toString())&
                e5.getText().toString().matches(t5.getText().toString())&
                e6.getText().toString().matches(t6.getText().toString())&
                e7.getText().toString().matches(t7.getText().toString())&
                e8.getText().toString().matches(t8.getText().toString())&
                e9.getText().toString().matches(t9.getText().toString()))
        {
            final AlertDialog.Builder alertDialog =new AlertDialog.Builder(this) {
                @NonNull
                @Override
                public AlertDialog create() {
                    setTitle("Solved!");
                    setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent exit=new Intent(Main2Activity.this,MainActivity.class);
                            exit.putExtra("exit",1);
                            exit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(exit);
                            finish();
                        }
                    });
                    setNegativeButton("Solve again?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset(i);
                            dialog.dismiss();
                        }
                    });
                    setMessage("Congrats! Solved in " + counter + " steps.");
                    return super.create();
                }
            };
        alertDialog.show();
        }
    }
    void reset(String[] i) {
        counter=1;
        c.setText(String.valueOf(counter));
        e1.setText(i[0]);
        e2.setText(i[1]);
        e3.setText(i[2]);
        e4.setText(i[3]);
        e5.setText(i[4]);
        e6.setText(i[5]);
        e7.setText(i[6]);
        e8.setText(i[7]);
        e9.setText(i[8]);
        check(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();
        final String[] i=bundle.getStringArray("input");
        final String[] j=bundle.getStringArray("output");
        ei=bundle.getInt("emptyinit");
        final int ef=bundle.getInt("emptyfin");
        c=(TextView)findViewById(R.id.textView);
        e1=(Button)findViewById(R.id.button1);
        e2=(Button)findViewById(R.id.button2);
        e3=(Button)findViewById(R.id.button3);
        e4=(Button)findViewById(R.id.button4);
        e5=(Button)findViewById(R.id.button5);
        e6=(Button)findViewById(R.id.button6);
        e7=(Button)findViewById(R.id.button7);
        e8=(Button)findViewById(R.id.button8);
        e9=(Button)findViewById(R.id.button9);
        t1=(Button)findViewById(R.id.button10);
        t2=(Button)findViewById(R.id.button11);
        t3=(Button)findViewById(R.id.button12);
        t4=(Button)findViewById(R.id.button13);
        t5=(Button)findViewById(R.id.button14);
        t6=(Button)findViewById(R.id.button15);
        t7=(Button)findViewById(R.id.button16);
        t8=(Button)findViewById(R.id.button17);
        t9=(Button)findViewById(R.id.button18);
        c.setText(String.valueOf(counter));
        e1.setText(i[0]);
        e2.setText(i[1]);
        e3.setText(i[2]);
        e4.setText(i[3]);
        e5.setText(i[4]);
        e6.setText(i[5]);
        e7.setText(i[6]);
        e8.setText(i[7]);
        e9.setText(i[8]);
        t1.setText(j[0]);
        t2.setText(j[1]);
        t3.setText(j[2]);
        t4.setText(j[3]);
        t5.setText(j[4]);
        t6.setText(j[5]);
        t7.setText(j[6]);
        t8.setText(j[7]);
        t9.setText(j[8]);
        check(i);
        View.OnClickListener listen=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button l=null,r=null,u=null,d=null;

                if(ei==0) {o=e1;l=null;r=e2;u=null;d=e4;}
                else if(ei==1) {o=e2;l=e1;r=e3;u=null;d=e5;}
                else if(ei==2) {o=e3;l=e2;r=null;u=null;d=e6;}
                else if(ei==3) {o=e4;l=null;r=e5;u=e1;d=e7;}
                else if(ei==4) {o=e5;l=e4;r=e6;u=e2;d=e8;}
                else if(ei==5) {o=e6;l=e5;r=null;u=e3;d=e9;}
                else if(ei==6) {o=e7;l=null;r=e8;u=e4;d=null;}
                else if(ei==7) {o=e8;l=e7;r=e9;u=e5;d=null;}
                else if(ei==8) {o=e9;l=e8;r=null;u=e6;d=null;}

                if(v==l){
                    o.setText(l.getText());
                    l.setText("");
                    counter++;
                    check(i);
                }
                else if(v==r){
                    o.setText(r.getText());
                    r.setText("");
                    counter++;
                    check(i);
                }
                else if(v==u){
                    o.setText(u.getText());
                    u.setText("");
                    counter++;
                    check(i);
                }
                else if(v==d) {
                    o.setText(d.getText());
                    d.setText("");
                    counter++;
                    check(i);
                }
            }
        };
        e1.setOnClickListener(listen);
        e2.setOnClickListener(listen);
        e3.setOnClickListener(listen);
        e4.setOnClickListener(listen);
        e5.setOnClickListener(listen);
        e6.setOnClickListener(listen);
        e7.setOnClickListener(listen);
        e8.setOnClickListener(listen);
        e9.setOnClickListener(listen);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(Main2Activity.this) {
                    @NonNull
                    @Override
                    public AlertDialog create() {
                        setCancelable(false);
                        setTitle(R.string.reset);
                        setMessage("Sure you want to reset to intial matrix?");
                        setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset(i);
                            }
                        });
                        return super.create();
                    }
                };
                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
                    TextView myMsg = new TextView(Main2Activity.this);
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
        if(id==R.id.exit) {
            final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this) {
                @NonNull
                @Override
                public AlertDialog create() {
                    setTitle("Do you want to exit?");
                    setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent exit=new Intent(Main2Activity.this,MainActivity.class);
                            exit.putExtra("exit",1);
                            exit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(exit);
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
}
