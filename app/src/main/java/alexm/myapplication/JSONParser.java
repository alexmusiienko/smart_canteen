package alexm.myapplication;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexm on 12/18/2016.
 */

public class JSONParser {

    private static String loadJSONFromAsset(Context ctx) {
        String json = null;
        try {
            InputStream is = ctx.getAssets().open("menu.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static List<Dish> loadMenu(Context ctx) {
        List<Dish> dishes = new ArrayList<>();

        try {
            JSONObject json = new JSONObject(loadJSONFromAsset(ctx));
            JSONArray menu = json.getJSONArray("food");

            for (int i = 0; i < menu.length(); i++) {
                JSONObject element = menu.getJSONObject(i);
                String name = element.getString("name");
                String portion = element.getString("portion");
                String price = element.getString("price");
                Dish dish = new Dish(name, portion, price);
                dishes.add(dish);
            }
            return dishes;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
