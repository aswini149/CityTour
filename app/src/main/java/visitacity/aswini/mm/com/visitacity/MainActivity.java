package visitacity.aswini.mm.com.visitacity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, R.layout.row_grid));

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridview.setLayoutAnimation(controller);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
    }

}
