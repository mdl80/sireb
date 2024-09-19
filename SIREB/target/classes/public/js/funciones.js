var contador = 0;


//con esta función mandamos al pie el pie.
function confAlturaMain() {
    var menu = $('#header');
    var	pie = $('#footer');
    var	principal = $('.main');
    var	altura = 0;
    if(contador === 0){
        altura = ($(window).height() - menu.outerHeight() - pie.outerHeight()) -252;
        principal.css('min-height', altura);
        contador++;
    }else{
        altura = ($(window).height() - menu.outerHeight() - pie.outerHeight());
        principal.css('min-height', altura);                    
    }
};

confAlturaMain();


//con esta función mandamos el pie al al pie, cuando redimensione la ventana.
$(window).resize(function() {
	confAlturaMain();
});

//con esta función comprobamos que la variable exista y que esté definida
function esNullYUndef(variable) {
    return (variable !== null && variable !== undefined);
}

function validarSesion(llave,pagina) {
    $.ajax({
        url: "/enSesion/validar/"+llave,
        type: "GET",
        dataType: "json",
        headers: {'SIREBToken':''},
        beforeSend: function () {
        },
        success: function (respuesta) {
            var path = location.pathname.substring(1);
            if (respuesta === true) {
                if(path === ""){
                    $(location).attr("href", pagina);
                }
            }else if(respuesta === false && path !== ""){
                $(location).attr("href", "/");
            }
        },
        error: function () {
            console.log("Atencion, contactar a Kike.");
        }
    });
}

