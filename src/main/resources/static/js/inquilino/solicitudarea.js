(function (solicitudAreaCode) {

    solicitudAreaCode(window.jQuery, window, document);
    configurarFechas();
}(function ($, window, document) {
        $(function () {
            $('#menu_inquilino_areacomun').addClass("active");
            configurarAutoCompleteAreaComun({onResponse: onResponseSearchAreacomun, onSelect: onSelectAreaComun});
            configurarFechaSolicitud();
        });

        function configurarAutoCompleteAreaComun(config) {
            $('#areacomunautocomplete').autocomplete({
                source: function (request, response) {
                    $.ajax("/api/areacomun/buscar?palabra=" + request.term, {
                        global: false,
                        success: function (areaComunResponse) {
                            response($.map(areaComunResponse.areasComunes, function (elem, idx) {
                                return {
                                    label: elem.nombre,
                                    name: elem.nombre,
                                    code: elem.codigo
                                }
                            }));
                        }
                    });
                },
                response: config.onResponse,
                select: config.onSelect
            });
        }

        function onResponseSearchAreacomun(e, ui) {
            if (ui.content.length <= 0) {
                ui.content.push({label: "No se encontraron resultados"});
            }
        }

        function onSelectAreaComun(e, ui) {
            $("#form_areaComun_codigo").val(ui.item.code);
        }

        function configurarFechaSolicitud() {
            $("#fechaSolicitud").change(function () {
                $.ajax( {
                    url: '/inquilino/solicitudes/ajax/verificar',
                    method: 'POST',
                    type:'POST',
                    data: $("#registrarForm").serialize()
                }).success(function(HTML){
                    $("#solicitudAreaFragment").html(HTML);
                    configurarFechas();
                });
            });
        }

        function configurarFechas() {
            $(".datepicker").datepicker({
                format: 'dd/mm/yyyy',
                autoclose: true,
                todayHighlight: false
            });
        }
    }
));