/**
 * Created by wilsoncampusano on 12/31/16.
 */

$(document).ready(function(){
    $('#areacomunautocomplete').autocomplete({
        source: function (request, response) {
            $.ajax("/api/areacomun/buscar?palabra="+request.term, {
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
        response: function (event, ui) {
            if (ui.content.length <= 0) {
                ui.content.push({label: "No se encontraron resultados"});
            }
        },
        select: function (event, ui) {
        }
    });
});