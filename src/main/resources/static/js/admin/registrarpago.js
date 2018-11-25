/**
 * Created by wilsoncampusano on 11/25/18.
 */
function configurarFechas() {
    $(".fechas").datepicker({
        dateFormat: 'dd/mm/yy',
        autoclose: true,
        todayHighlight: false
    });
}


configurarFechas();