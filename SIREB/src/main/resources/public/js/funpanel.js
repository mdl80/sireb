$(function(){
    $('input[type="text"]').keyup(function(){
	var buscarTexto = $(this).val().toUpperCase();
	$('.bombero-contenedor-resultado-ul-tm > li').each(function(){
	    var currentLiText = $(this).text().toUpperCase(),showCurrentLi = currentLiText.indexOf(buscarTexto) !== -1;
	    if(showCurrentLi){
		$(this).addClass('bombero-in-tm').removeClass('bombero-out-tm');
	    }else{
		$(this).addClass('bombero-out-tm').removeClass('bombero-in-tm');
	    }
	});
    });
    $('.campoEditableTexto').editable({
        emptytext: 'Sin datos'
    });
    $('.campoEditableArea').editable({
    placement: 'left',
    emptytext: 'Sin datos'
    });

});
