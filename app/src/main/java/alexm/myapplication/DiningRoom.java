package alexm.myapplication;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by alexm on 11/28/2016.
 */

public class DiningRoom {

//    MarkerOptions corpus5 = new MarkerOptions()
//            .position(new LatLng(49.835199, 24.0084904))
//            .title("Їдальня 5 Корпус")
//            .snippet("8:30-16:30");
//
//    MarkerOptions corpus1 = new MarkerOptions()
//            .position(new LatLng(49.83536678, 24.01015341))
//            .title("Їдальня 1 Корпус")
//            .snippet("8:30-16:30");

    LatLng coordinate;
    String title;
    String workingHours;

    DiningRoom(LatLng coordinate, String title, String workingHours) {
        this.coordinate = coordinate;
        this.title = title;
        this.workingHours = workingHours;
    }

    MarkerOptions marker() {
        return new MarkerOptions().
                position(coordinate)
                .title(title)
                .snippet(workingHours);
    }

    static DiningRoom[] rooms = new DiningRoom[]{
            new DiningRoom(new LatLng(49.835199, 24.0084904), "Їдальня 5 Корпус", "8:30-16:30"),
            new DiningRoom(new LatLng(49.83536678, 24.01015341), "Їдальня 1 Корпус", "8:30-16:30")
    };
}
