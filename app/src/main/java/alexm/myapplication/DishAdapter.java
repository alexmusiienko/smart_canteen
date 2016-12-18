package alexm.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alexm on 12/18/2016.
 */

public class DishAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater inflater;
    private List<Dish> dishes;

    DishAdapter(Context context) {
        ctx = context;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dishes = JSONParser.loadMenu(context);
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int i) {
        return dishes.get(i);
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

        Dish dish = (Dish) getItem(i);
        ((TextView) aView.findViewById(R.id.title)).setText(dish.name);
        ((TextView) aView.findViewById(R.id.details)).setText(dish.portion + "\n" + dish.price);

        return aView;
    }
}

