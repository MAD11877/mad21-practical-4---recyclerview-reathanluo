package sg.edu.np.s10205205;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Random myRandom = new Random();
        for(int i=0;i<20;i++){
            String uName = "Name" + String.valueOf(myRandom.nextInt());
            String uDes = "Description " + String.valueOf(myRandom.nextInt());
            int id = i;
            boolean followed = myRandom.nextBoolean();
            userList.add(new User(uName,uDes,id,followed));
        }
        rv = findViewById(R.id.rv);
        UsersAdapter adapter = new UsersAdapter(this, userList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

//        ImageView imageView = findViewById(R.id.imageInList);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showAlertDialog(v);
//            }
//        });
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
