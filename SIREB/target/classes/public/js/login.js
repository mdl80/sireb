$('document').ready(function(){
    var sesion = Cookies.get('SIREB');
    
    if(esNullYUndef(sesion)){
        validarSesion(sesion,"sistema.html#principal");
    };
    
    $("#iniciosesion").validate({
        rules:{
	    inputUsuario: {
		required: true
	    },
	    inputClave: {
		required: true
	    }
	},
	messages:{
	    inputUsuario:{
		required: "Ingrese su usuario"
	    },
	    inputClave: "Ingrese su clave"
	},
	submitHandler: submitForm
    });

    function submitForm(){
        var usuario = $('#inputUsuario').val();
        var clave = $('#inputClave').val();
	var data = {
		usuario : usuario,
		contrase\u00f1a : clave
		};
        var formData = JSON.stringify(data);
	
        $.ajax({
	    type : 'POST',
	    url  : '/sesion/validar',
		dataType: "json",
		data: formData,
		contentType: 'application/json',
                headers: {'SIREBToken':''},
	    beforeSend: function(){
		$("#error").fadeOut();
		$("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; enviando ...');
	    },
	    success :  function(response){
		if(response.Correcto == 1){
		    $("#btn-login").html('<img src="btn-ajax-loader.gif" width="25" height="25" /> &nbsp; Iniciando Sesion ...');
		    $("#inputUsuario").attr('disabled', 'disabled');
		    $("#inputClave").attr('disabled', 'disabled');
                    Cookies.set('SIREB',response.Key);
                    Cookies.set('SIREBCuartel',response.idCuartel);
		    setTimeout(' window.location.href = "sistema.html#principal"; ',2000);
		}
		else{
		    $("#error").fadeIn(1000, function(){      
			$("#error").html('<div class="alert alert-danger"> <span class="glyphicon glyphicon-info-sign"></span> &nbsp; Inicio incorrecto !</div>');
			$("#btn-login").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Iniciar');
		    });
                }
            }
        });
        return false;
    }
});
