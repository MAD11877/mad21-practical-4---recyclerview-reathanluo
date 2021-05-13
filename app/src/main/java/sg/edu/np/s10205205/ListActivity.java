package sg.edu.np.s10205205;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView imageView = findViewById(R.id.imageInList);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(v);
            }
        });
    }


    public void showAlertDialog(View v) {

        Random myRandom = new Random();
        String txt = String.valueOf(myRandom.nextInt());
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Profile");
        alert.setMessage("MADness");
        alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(ListActivity.this,MainActivity.class);
                intent1.putExtra("random",txt);
                startActivity(intent1);
            }
        });
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.create().show();
    }
}
