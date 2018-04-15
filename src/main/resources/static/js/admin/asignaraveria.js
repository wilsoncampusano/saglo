(function (solicitudAreaCode) {

    solicitudAreaCode(window.jQuery, window, document);
}(function($, window, document){

    $(function () {
        // init
    });


    function changeSelecpickerTipoTecnico() {
        $.ajax( {
            url: '/admin/locales/solicitudes/averia/ajax/tecnicos',
            method: 'POST',
            type:'POST',
            data: $("#registrarForm").serialize()
        }).success(function(HTML){
            var $tecnicos = $("#tecnicos");
            $tecnicos.html('<option value="">Seleccione</option>');
            $tecnicos.append(HTML);
        });
    }



    function configurarListaTipoTecnico() {
        $("#selectTipoTecnico").change(changeSelecpickerTipoTecnico);
    }

}));