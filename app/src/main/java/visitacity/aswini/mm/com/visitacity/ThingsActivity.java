package visitacity.aswini.mm.com.visitacity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;

public class ThingsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.things);
        setupWindowAnimations();

        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[] { "Royal Castle of Munich", "Memorial Site", "Great Wall of China",
                "Lake Zurich", "Simati West", "Mutaniyu Mountains", "Opera House", "Forbidden City"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final ListViewAdapter adapter = new ListViewAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

    }
    private void setupWindowAnimations() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        getWindow().setEnterTransition(slide);
    }
}
