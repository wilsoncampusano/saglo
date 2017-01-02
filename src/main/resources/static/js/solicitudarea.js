/**
 * Created by wilsoncampusano on 12/31/16.
 */
$(document).ready(function(){
    $('#autocomplete-areacomun').autocomplete({
        source: function (request, response) {
            var criterio = this.term;

            $.ajax("/api/areacomun/buscar", {
                global: false,
                success: function (areaComunResponse) {
                    response($.map(areaComunResponse, function (elem, idx) {
                        return {
                            label: elem.nombre,
                            name: elem.nombre,
                            code: elem.codigo
                        }
                    }));
                }
            });
        },
        response: function (event, ui) {
            if (ui.content.length <= 0) {
                ui.content.push({label: "No se encontraron resultados"});
            }
        },
        select: function (event, ui) {

        }
    });

});