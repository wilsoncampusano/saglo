package equipo.once.elizabeth.richard.wilson.controllers.view.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created on 4/10/2018.
 */
public class DateUtil {


    public  static String toString(Date date){
        if(Objects.isNull(date)) return "";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
