package alexm.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by alexm on 11/28/2016.
 */

public class ListAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater inflater;

    ListAdapter(Context context) {
        ctx = context;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return DiningRoom.rooms.length;
    }

    @Override
    public Object getItem(int i) {
        return DiningRoom.rooms[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View aView = view;
        if (aView == null) {
            aView = inflater.inflate(R.layout.list_layout, viewGroup, false);
        }

        DiningRoom room =(DiningRoom) getItem(i);
        ((TextView) aView.findViewById(R.id.title)).setText(room.title);
        ((TextView) aView.findViewById(R.id.details)).setText(room.workingHours);

        return aView;
    }
}
