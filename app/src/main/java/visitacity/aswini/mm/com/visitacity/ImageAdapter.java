package visitacity.aswini.mm.com.visitacity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int layoutResourceId;


    public ImageAdapter(Context c, int layoutResourceId) {
        this.mContext = c;
        this.layoutResourceId = layoutResourceId;
    }

    public int getCount() {
        return DataClass.mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder;
        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = row.findViewById(R.id.item_text);
            holder.imageItem = row.findViewById(R.id.item_image);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        holder.txtTitle.setText(DataClass.mTextds[position]);
        holder.imageItem.setImageResource(DataClass.mThumbIds[position]);
        return row;

    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
    }

    public static class DataClass {
        public static Integer[] mThumbIds = {
                R.drawable.mumbai, R.drawable.munich,
                R.drawable.paris, R.drawable.berlin,
                R.drawable.sydney, R.drawable.vienna,
                R.drawable.zurich, R.drawable.beijing,
                R.drawable.barcelona, R.drawable.amsterdam,
        };

        public static String[] mTextds = {
                "Mumbai", "Munich",
                "Paris", "Berlin",
                "Sydney", "Vienna",
                "Zurich", "Beijing",
                "Barcelona", "Amsterdam",
        };
    }
}