package sg.edu.np.s10205205;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User("SHIAO", "It's me", 1);

        Button follow_button = findViewById(R.id.follow_button);
        Context context = getApplicationContext();
        follow_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("debug", "Follow Button Pressed");
                if (user.isFollowed()){
                    follow_button.setText("FOLLOW");
                    user.setFollowed(false);
                    Toast setunfollow = Toast.makeText(context, "Unfollowed!", Toast.LENGTH_SHORT);
                    setunfollow.show();
                }
                else{
                    follow_button.setText("UNFOLLOW");
                    user.setFollowed(true);
                    Toast setFollow = Toast.makeText(context, "Followed!", Toast.LENGTH_SHORT);
                    setFollow.show();
                }
            }
        });

        Intent receiver = getIntent();
        String message = receiver.getStringExtra("random");
        TextView textView1 = findViewById(R.id.textView);
        textView1.setText("MAD " + message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug","start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug","destory");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug","restart");

    }
}