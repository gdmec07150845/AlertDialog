package cn.gdmec.alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView1);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        TextView.OnClickListener listener = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }

        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);

    }
    //两个按钮的对话框
    private void dialog1() {
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");//对话框的标题
        dialog.setMessage("确定退出吗？");//对话框的内容
        dialog.setIcon(android.R.drawable.ic_dialog_alert);//对话框的图标
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if (which == DialogInterface.BUTTON_NEUTRAL){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"退出",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listenter);
        dialog.show();
    }
    //三个按钮的对话框
    private void dialog2() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("今天你忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "不忙";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listenter);
        dialog.show();
    }
    //输入框的对话框
    public void dialog3(){
            dialog = new AlertDialog.Builder(this).create();
            dialog.setTitle("请输入");
            dialog.setMessage("你平时忙吗？");
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            final EditText tEdit = new EditText(this);
            dialog.setView(tEdit);
            DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv1.setText("输入的是："+tEdit.getText().toString());
                }
            };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
            dialog.show();
        }
    //多选框的对话框
    public void dialog4(){
        final String item[] = new String[] {"茂名","深圳","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListenter);
        dialog = builder.create();
        dialog.setTitle("请选择城市");
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for (int i = 0;i < bSelect.length;i++){
                    if (bSelect[i]){
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }
    //复选框的对话框
    public void dialog5(){
        final String item[] = new String[] {"茂名","深圳","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sLis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which] = true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sLis);
        dialog = builder.create();
        dialog.setTitle("请选择城市");
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }
    //列表框的对话框
    public void dialog6(){
        final String item[] = new String[] {"茂名","深圳","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sLis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了："+item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,sLis);
        dialog = builder.create();
        dialog.setTitle("请选择程序");
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"取消",lis);
        dialog.show();
    }
    //输入框的对话框
    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.editText1);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入想要的文字");
        dialog.setView(layout);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis);
        dialog.show();
    }

}
