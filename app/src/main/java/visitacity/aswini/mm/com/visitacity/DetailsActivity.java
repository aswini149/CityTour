package visitacity.aswini.mm.com.visitacity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private LinearLayout linearLayoutMap;
    private LinearLayout linearLayoutThings;
    private LinearLayout linearLayoutSight;
    private LinearLayout linearLayoutTips;
    private String title = " Travel Guide";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.details_activity);
        setupWindowAnimations();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        ConstraintLayout constraintLayout = findViewById(R.id.root_layout);
        constraintLayout.setBackgroundResource(ImageAdapter.DataClass.mThumbIds[position]);
        title = ImageAdapter.DataClass.mTextds[position] + title;

        linearLayoutMap = findViewById(R.id.map);
        linearLayoutSight = findViewById(R.id.eye);
        linearLayoutThings = findViewById(R.id.things);
        linearLayoutTips = findViewById(R.id.tips);

        linearLayoutMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutMap.setBackgroundResource(R.drawable.ripple_effect);
                startActivity(new Intent(getApplicationContext(), MapActivity.class), ActivityOptions.makeSceneTransitionAnimation(DetailsActivity.this).toBundle());
            }
        });

        linearLayoutSight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutSight.setBackgroundResource(R.drawable.ripple_effect);
                startActivity(new Intent(getApplicationContext(), SightActivity.class), ActivityOptions.makeSceneTransitionAnimation(DetailsActivity.this).toBundle());
            }
        });

        linearLayoutThings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutThings.setBackgroundResource(R.drawable.ripple_effect);
                startActivity(new Intent(getApplicationContext(), ThingsActivity.class), ActivityOptions.makeSceneTransitionAnimation(DetailsActivity.this).toBundle());
            }
        });

        linearLayoutTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Currently there are no tips available, Please come back later !", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        linearLayoutMap.setBackgroundColor(getResources().getColor(R.color.white));
        linearLayoutSight.setBackgroundColor(getResources().getColor(R.color.white));
        linearLayoutThings.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setupWindowAnimations() {
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        return super.onCreateOptionsMenu(menu);
    }
}
