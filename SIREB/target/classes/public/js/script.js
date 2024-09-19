var sesion = Cookies.get('SIREB');
var listagrados = "";
var direccionCuartel = "";
var objetoCuartel = "";
var objetoBomberos = "";
var objetoMoviles = "";
var interVer = "";
var interFin = "";

function nuevaIntervencion(){
    date = new Date();
    var random = Math.floor(Math.random()*date.getTime());
    
    var ventana = "nuevaIntervencion-"+random;
    var cuerpoNuevaIntervencion = `
                                                             <div class="row">
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="nombreAlertante-${random}" class="control-label">Nombre Alertante</label>
                                                                        <input type="text" class="form-control" id="nombreAlertante-${random}" name="nombreAlertante-${random}" required="required">
                                                                        <span class="fa fa-user-circle-o form-control-feedback" onclick="javascript:$('#nombreAlertante-${random}').focus()"></span>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="apellidoAlertante-${random}" class="control-label">Apellido Alertante</label>
                                                                        <input type="text" class="form-control" id="apellidoAlertante-${random}" name="apellidoAlertante-${random}" required="required">
                                                                        <span class="fa fa-users form-control-feedback" onclick="javascript:$('#apellidoAlertante-${random}').focus()"></span>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="contactoAlertante-${random}" class="control-label">Contacto Alertante</label>
                                                                        <input type="text" class="form-control" id="contactoAlertante-${random}" name="contactoAlertante-${random}" required="required">
                                                                        <span class="fa fa-phone form-control-feedback" onclick="javascript:$('#contactoAlertante-${random}').focus()"></span>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="direccion-${random}" class="control-label">Dirección</label>
                                                                        <input type="text" class="form-control" id="direccion-${random}" name="direccion-${random}" required="required">
                                                                        <span class="fa fa-phone form-control-feedback" onclick="javascript:$('#direccion-${random}').focus()"></span>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="aviso-${random}" class="control-label">Aviso</label>
                                                                        <div id="aviso-${random}"></div>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="barrioZona-${random}" class="control-label">Barrio / Zona</label>
                                                                        <div id="barrioZona-${random}"></div>
                                                                    </div>
                                                                 </div>
                                                                <div class="col-md-4">
                                                                </div>
                                                                <div class="col-md-4"><span>&nbsp;</span>
                                                                </div>    
                                                                <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="jefeBrigada-${random}" class="control-label">Jefe Brigada</label>
                                                                        <div id="jefeBrigada-${random}"></div>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="tipoIntervencion-${random}" class="control-label">Tipo Intervencion</label>
                                                                        <div id="tipoIntervencion-${random}"></div>
                                                                    </div>
                                                                 </div>
                                                                 <div class="col-md-4">
                                                                    <div class="form-group has-feedback">
                                                                        <label for="movilRespuesta-${random}" class="control-label">Movil Respuesta</label>
                                                                        <div id="movilRespuesta-${random}"></div>
                                                                    </div>
                                                                 </div> 
                                                                <div class="col-md-4">
  
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <input type="button" id="ok" value="Agregar" />
                                                                    <input type="button" id="cancel" value="Cancel" />
                                                                </div>
                                                             </div>
    `;
    $( "<div id='"+ventana+"' class='intervencionVentanaVista'><div><b>Nueva Intervencion</b></div><div>"+cuerpoNuevaIntervencion+"</div></div>" ).appendTo( "#contenedorGeneral" );
    $("#"+ventana).jqxWindow({ height:300, width: 550, theme: 'energyblue', showCloseButton: true });
                var dataTipoAviso = objetoCuartel.tipoAviso;
                    var sourceTipoAviso =
                {
                    datatype: "json",
                    datafields: [
                        { name: 'idTipoAviso' },
                        { name: 'avisoTipo' },
                        { name: 'descripcion' },
                    ],
                    localdata: dataTipoAviso
                };
                var adaptadorTipoAviso = new $.jqx.dataAdapter(sourceTipoAviso);
                
                $("#aviso-"+random).jqxDropDownList({
                    selectedIndex: 0, source: adaptadorTipoAviso, theme: 'energyblue', displayMember: "avisoTipo", valueMember: "idTipoAviso", width: 140, height: 30
                });

                var dataBarrioZona = objetoCuartel.BarrioZonas;
                    var sourceBarrioZona =
                {
                    datatype: "json",
                    datafields: [
                        { name: 'idBarrioZona' },
                        { name: 'barrioZona' },
                        { name: 'jurisdiccion' }
                        
                    ],
                    localdata: dataBarrioZona
                };
                var adaptadorBarrioZona = new $.jqx.dataAdapter(sourceBarrioZona);
                
                $("#barrioZona-"+random).jqxDropDownList({
                    selectedIndex: 0, source: adaptadorBarrioZona, theme: 'energyblue', displayMember: "barrioZona", valueMember: "idBarrioZona", width: 140, height: 30
                });


                var dataBomberos = objetoBomberos;
                    var sourceBomberos =
                {
                    datatype: "json",
                    datafields: [
                        { name: 'idBombero' },
                        { name: 'nombre1' },
                        { name: 'nombre2' },
                        { name: 'apellido' }
                    ],
                    localdata: dataBomberos
                };
                var adaptadorBomberos = new $.jqx.dataAdapter(sourceBomberos);
                
                $("#jefeBrigada-"+random).jqxDropDownList({
                    selectedIndex: 0, source: adaptadorBomberos, theme: 'energyblue', displayMember: "nombre1", valueMember: "idBombero", width: 140, height: 30, renderer: function (index, label, value) {
                    var nombre2 = adaptadorBomberos.records[index].nombre2 ? adaptadorBomberos.records[index].nombre2 : "";
                    return adaptadorBomberos.records[index].nombre1 + " " +nombre2+ " " + adaptadorBomberos.records[index].apellido;
                }
                });

                var dataTipoIntervencion = objetoCuartel.tipoIntervencion;
                    var sourceTipoIntervencion =
                {
                    datatype: "json",
                    datafields: [
                        { name: 'idTipoIntervencion' },
                        { name: 'codigo' },
                        { name: 'descripcion' }
                        
                    ],
                    localdata: dataTipoIntervencion
                };
                var adaptadorTipoIntervencion = new $.jqx.dataAdapter(sourceTipoIntervencion);
                
                $("#tipoIntervencion-"+random).jqxDropDownList({
                    selectedIndex: 0, source: adaptadorTipoIntervencion, theme: 'energyblue', displayMember: "codigo", valueMember: "idTipoIntervencion", width: 140, height: 30
                });

    
                var dataMovilRespuesta = objetoMoviles;
                var sourceMovilRespuesta =
                {
                    datatype: "json",
                    datafields: [
                        { name: 'idMovil' },
                        { name: 'numeroMovil' },
                        { name: 'marca' },
                        { name: 'modelo' }
                        
                    ],
                    localdata: dataMovilRespuesta
                };
                var adaptadorMovilRespuesta = new $.jqx.dataAdapter(sourceMovilRespuesta);
                
                $("#movilRespuesta-"+random).jqxDropDownList({
                    selectedIndex: 0, source: adaptadorMovilRespuesta, theme: 'energyblue', displayMember: "numeroMovil", valueMember: "idMovil", width: 140, height: 30
                });
    
    
                $('#'+ventana+' #cancel').jqxButton({ width: '65px' });
                $('#'+ventana+' #cancel').mousedown(function () { $('#'+ventana).jqxWindow('close'); });
                $('#'+ventana+' #ok').jqxButton({ width: '65px' });
                $('#'+ventana+' #ok').mousedown(function () {
                    $("#mensajeAlerta").remove();
                    $( "<div id='mensajeAlerta' class='alert alert-success text-center mensajeRespuesta' role='alert'></div>").appendTo( "#contenedorGeneral" );
                var aviso = $("#aviso-"+random).jqxDropDownList('getSelectedItem');
                var idAvisoData = aviso.value;
                var barrioZona = $("#barrioZona-"+random).jqxDropDownList('getSelectedItem');
                var idBarrioZonaData = barrioZona.value;
                var jefeBrigada = $("#jefeBrigada-"+random).jqxDropDownList('getSelectedItem');
                var idJefeBrigadaData = jefeBrigada.value;
                var tipoIntervencion = $("#tipoIntervencion-"+random).jqxDropDownList('getSelectedItem');
                var idTipoIntervencionData = tipoIntervencion.value;
                var movilRespuesta =  $("#movilRespuesta-"+random).jqxDropDownList('getSelectedItem');
                var idMovilRespuestaData = movilRespuesta.value;
                var nombreAlertanteData = $("#nombreAlertante-"+random).val();
                var apellidoAlertanteData = $("#apellidoAlertante-"+random).val();
                var contactoAlertanteData = $("#contactoAlertante-"+random).val();
                var direccionData =  $("#direccion-"+random).val();
                
                                       var data = {
                                           idTipoAviso : idAvisoData,
                                           idBarrioZona : idBarrioZonaData,
                                           idJefeBrigada : idJefeBrigadaData,
                                           idTipoIntervencion : idTipoIntervencionData,
                                           idMovilRespuesta : idMovilRespuestaData,
                                           nombreAlertante : nombreAlertanteData,
                                           apellidoAlertante : apellidoAlertanteData,
                                           contactoAlertante : contactoAlertanteData,
                                           direccion1 : direccionData,
                                           idEstado : 0
                       };
                      var formData = JSON.stringify(data);
                       var mensajeAlerta = "Se agrego una intervencion.";
                       $.ajax({
                           url: "/intervencion/guardar",
                           type: "POST",
                           dataType: "json",
                           data: formData,
                           contentType: 'application/json',
                           headers: { 'SIREBToken': sesion },
                           beforeSend: function () {
                           },
                           success: function (respuesta) {
                               var res = respuesta.resultado;
                               var mod = respuesta.modulo;
                               if(res == false && mod == "ServicioSesion"){
                                   cerrarSesion();
                               }else{                    
                                   if (respuesta.resultado == true) {
                                       $('#'+ventana).jqxWindow('close');
                                       $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                                       $("#listaIntervenciones").jqxGrid('updatebounddata');
                                   }else{
                                       $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(3000).fadeOut();
                                   }
                               }
                           },
                           error: function (request, error) {
                               errorSistema(request, error,"intervencion");
                           }
                       });
                
                
                });
    
    $("#"+ventana+" .jqx-window-content").css({'overflow-x':'hidden'});
    $("#"+ventana+" .jqx-window-content").css({'overflow-y':'hidden'});
    $("#"+ventana).on('close', function (event) { 
        $("#"+ventana).remove();
    });
};


function verIntervencion(idIntervencion,tipo){
    if(interVer === idIntervencion){
        return null;
    }
    interVer = idIntervencion;
    var ventana = "jqxwindow-"+idIntervencion;
    if (!$("#"+ventana).length > 0){
        var cargando = $('<div style="margin:0 0 0 25%; z-index: 10000; position: absolute; top: 5px; left: 60%;" id="cargandoDatos"><span>Cargando...<i class="fa fa-refresh fa-spin"></i></span></div>');
        $("#dockingLayout").append(cargando);
        $.ajax({
            url: "/intervencion/buscarId/"+idIntervencion+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (intervencion) {
                interVer = 0;
                $("#cargandoDatos").remove();
                var mostrarTipoIntervencion = "";
                var mostrarTipoAviso = "";
                var mostrarjefeBrigada = "";
                var mostrarBarrioZona = "";
                var mostrarDireccion = "";
                var listaMovilesDesplegados = "";
                var mostrarHora = "";
                var mostrarTranscurrido = "";
                var mostrarAlertante = "";
                $.each(objetoCuartel.tipoIntervencion, function (index, tipoIntervencion) {
                    if(tipoIntervencion.idTipoIntervencion == intervencion.idTipoIntervencion){
                        mostrarTipoIntervencion = tipoIntervencion.codigo+" <i class='fa fa-info-circle' style='font-size:10pt; color: blue; display:inline-block;' aria-hidden='true' data-toggle='tooltip' data-placement='top' title='"+tipoIntervencion.descripcion+"'></i>";
                    }
                });

                $.each(objetoCuartel.tipoAviso, function (index, tipoAviso) {
                    if(tipoAviso.idTipoAviso == intervencion.idTipoAviso){
                        mostrarTipoAviso = tipoAviso.avisoTipo;
                    }
                });

                $.each(objetoCuartel.BarrioZonas, function (index, barrioZona) {
                    if(barrioZona.idBarrioZona == intervencion.idBarrioZona){
                        mostrarBarrioZona = barrioZona.barrioZona;
                    }
                });

                $.each(objetoBomberos, function (index, bombero) {
                    if(bombero.idBombero == intervencion.idJefeBrigada){
                        var nombre2 = bombero.nombre2 ? bombero.nombre2 : "";
                        mostrarjefeBrigada = bombero.nombre1 +" "+ nombre2 +" "+ bombero.apellido;
                    }
                });

                $.each(intervencion.despliegueMoviles, function (index, movilDesplegado) {
                    $.each(objetoMoviles, function (index, movil) {
                        if(movil.idMovil == movilDesplegado.idMovil){
                            if(tipo == 'activa'){
                                listaMovilesDesplegados += "<li class='list-group-item movil"+movilDesplegado.idDespliegueMovil+"' onclick='leerBomberosDesplegados("+idIntervencion+","+JSON.stringify(movilDesplegado.despliegueBomberos)+","+movilDesplegado.idDespliegueMovil+",\""+intervencion.ticket+"\",\"Objeto\",\"activa\");'><strong>Num. "+movil.numeroMovil+"</strong> "+movil.marca+" "+movil.modelo+"</li>";
                            }else if(tipo == 'historico'){
                                listaMovilesDesplegados += "<li class='list-group-item movil"+movilDesplegado.idDespliegueMovil+"' onclick='leerBomberosDesplegados("+idIntervencion+","+JSON.stringify(movilDesplegado.despliegueBomberos)+","+movilDesplegado.idDespliegueMovil+",\""+intervencion.ticket+"\",\"Objeto\",\"historico\");'><strong>Num. "+movil.numeroMovil+"</strong> "+movil.marca+" "+movil.modelo+"</li>";
                            }
                        }
                    });
                });
                
                mostrarHora = intervencion.horaInicio;
                var formattedDate = new Date(mostrarHora);
                var fechaActual = new Date();
                var diferencia = (fechaActual - formattedDate)/1000;
                var d = ('0' + formattedDate.getDate()).slice(-2);
                var m =  ('0' + (formattedDate.getMonth()+1)).slice(-2);
                var horas = ('0'+formattedDate.getHours()).slice(-2);
                var minutos = ('0'+formattedDate.getMinutes()).slice(-2);
                var segundos = ('0'+formattedDate.getSeconds()).slice(-2);
                var y = formattedDate.getFullYear();
                var fecha = "";
                if (diferencia < 3600){
                    fecha = new Date(diferencia * 1000).toISOString().substring(14, 19);
                }else{
                    fecha = new Date(diferencia * 1000).toISOString().substring(11, 19);
                }
                mostrarHora = d + "/" + m + "/"+ y + " "+horas+":"+minutos+":"+segundos;
                mostrarTranscurrido = fecha;
                if(tipo == 'activa'){
                setInterval(function(){ 
                    var fechaActual = new Date();
                    var diferencia = (fechaActual - formattedDate)/1000;
                    if (diferencia < 3600){
                        fecha = new Date(diferencia * 1000).toISOString().substring(14, 19);
                    }else{
                        fecha = new Date(diferencia * 1000).toISOString().substring(11, 19);
                    }
                    mostrarTranscurrido = fecha;
                    $("#tiempoTranscurrido-"+idIntervencion).html(mostrarTranscurrido);
                }, 1000);
                }
                var direccion2 = intervencion.direccion2 ? " y "+intervencion.direccion2 : "";
                mostrarDireccion = intervencion.direccion1 +""+direccion2;
                mostrarAlertante = intervencion.nombreAlertante + " " + intervencion.apellidoAlertante + " <span class='fa fa-phone'></span> "+ intervencion.contactoAlertante;
                var listaMovilesDesplegados = listaMovilesDesplegados ? listaMovilesDesplegados : "Ninguno";
                var tituloMovilesDesplegados = "";
                var tituloTranscurrido = "";
                if(tipo == 'activa'){
                    var altura = 300;
                    var informe = "";
                    tituloMovilesDesplegados = '<div class="panel-heading"><button type="button" class="btn btn-primary agregarMovilDesplegado" data-toggle="modal" data-target="#desplegarMovil" id="agregarMovilDesplegado" style="display: inline; padding: 2px;">Agregar <i class="fa fa-plus"></i></button> Moviles Desplegados:</div>';
                    tituloTranscurrido = "Transcurrido";
                }else if(tipo == 'historico'){
                    tituloMovilesDesplegados = '<div class="panel-heading">Moviles Desplegados:</div>';
                    tituloTranscurrido = "Finalizacion";
                    var altura = 450;
                    var mostrarInformeIntervencion = intervencion.informeIntervencion;
                    var informe = `
                                                     <div class='col-md-10'>
                                                         <div>
                                                             <span class='fa fa-info form-control-feedback' ></span> <label class='control-label'>Informe</label> 
                                                                    <textarea id='informe-${idIntervencion}'>${mostrarInformeIntervencion}</textarea>
                                                         </div>
                                                     </div>`;
                    var formattedDateFin = new Date(intervencion.horaFin);

                    formattedDateFin = changeTimezone(formattedDateFin, 'America/Sao_Paulo');
                    function changeTimezone(date, ianatz) {
                        var invdate = new Date(date.toLocaleString('en-US', {
                            timeZone: ianatz
                        }));
                        var diff = date.getTime() - invdate.getTime();
                        return new Date(date.getTime() - diff);
                    }
                      
                var dF = ('0' + formattedDateFin.getDate()).slice(-2);
                var mF =  ('0' + (formattedDateFin.getMonth()+1)).slice(-2);
                var horasF = ('0'+formattedDateFin.getHours()).slice(-2);
                var minutosF = ('0'+formattedDateFin.getMinutes()).slice(-2);
                var segundosF = ('0'+formattedDateFin.getSeconds()).slice(-2);
                var yF = formattedDateFin.getFullYear();
                var mostrarHoraFinal = dF + "/" + mF + "/"+ yF + " "+horasF+":"+minutosF+":"+segundosF;
                    mostrarTranscurrido = mostrarHoraFinal;
                }
                
                var mostrarDespliegueMoviles =`
                                                <div class="panel panel-primary" id="movilesDesplegados">
                                                    ${tituloMovilesDesplegados}
                                                    <div class="panel-body">
                                                        <ul class="list-group">
                                                            ${listaMovilesDesplegados}
                                                        </ul>
                                                    </div>
                                                </div>
                            `;

                var cuerpoVentanaIntervencion = `
                                                 <div class='row'>
                                                     <div class='col-md-6'>
                                                         <div>
                                                              <span class='fa fa-fire form-control-feedback'></span> <label class='control-label'>Tipo</label> 
                                                                   ${mostrarTipoIntervencion} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-phone form-control-feedback'></span> <label class='control-label'>Aviso</label> 
                                                                   ${mostrarTipoAviso} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-angle-double-up form-control-feedback'></span> <label class='control-label'>Jefe Brigada</label> 
                                                                   ${mostrarjefeBrigada} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-map-o form-control-feedback'></span> <label class='control-label'>Barrio / Zona</label> 
                                                                   ${mostrarBarrioZona} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-map-marker form-control-feedback'></span> <label class='control-label'>Direccion</label> 
                                                                   ${mostrarDireccion} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-clock-o form-control-feedback'></span> <label class='control-label'>Inicio</label> 
                                                                   ${mostrarHora} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-user form-control-feedback'></span> <label class='control-label'>Alertante</label> 
                                                                   ${mostrarAlertante} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-clock-o form-control-feedback' ></span> <label class='control-label'>${tituloTranscurrido}</label> 
                                                                   <span id='tiempoTranscurrido-${idIntervencion}'> ${mostrarTranscurrido} </span>
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6' id="listadoMovilesDesplegados-${idIntervencion}">
                                                                   ${mostrarDespliegueMoviles} 
                                                     </div>
                                                     <div class='col-md-6' id="despliegueBomberos-${idIntervencion}">
                                                     </div>
                ${informe}
                                                 </div>`;
                if(tipo == 'activa'){
                var modalNuevoDespliegueMovil = `
                                                 <div id="modalNuevoMovil-${idIntervencion}" style="display: none;">
                                                     <div>Seleccione los moviles</div>
                                                     <div>
                                                        <div id="listadoMovilesDisponibles-${idIntervencion}">
                                                        </div>
                                                        <div>
                                                            <div style="float: right; margin-top: 15px;">
                                                               <input type="button" id="ok" value="Agregar" />
                                                               <input type="button" id="cancel" value="Cancel" />
                                                            </div>
                                                        </div>
                                                     </div>
                                                 </div>`;
                }else if(tipo == 'historico'){
                    var modalNuevoDespliegueMovil = "";
                }
                
                $( "<div id='"+ventana+"' class='intervencionVentanaVista'><div><b>Detalle Intervencion <span style='color: #ff0000;'> "+intervencion.ticket+"</span></b></div><div>"+cuerpoVentanaIntervencion+"</div></div>"+modalNuevoDespliegueMovil).appendTo( "#contenedorGeneral" );
                $("#"+ventana).jqxWindow({ height:altura, width: 650, theme: 'energyblue', showCloseButton: true });
                if(tipo == 'historico'){
                $("#informe-"+idIntervencion).jqxTextArea({height: 100, width: 640, minLength: 1, disabled: true});
                }
                $("#"+ventana+" .jqx-window-content").css({'overflow-x':'hidden'});
                $("#"+ventana+" .jqx-window-content").css({'overflow-y':'hidden'});
                if(tipo == 'activa'){
                $('#modalNuevoMovil-'+idIntervencion).jqxWindow({
                    maxHeight: 300, maxWidth: 350, minHeight: 30, minWidth: 300, height: 250, width: 300,
                    resizable: false, isModal: true, modalOpacity: 0.3, autoOpen: false, cancelButton: $('#modalNuevoMovil-'+idIntervencion+' #cancel'),
                    initContent: function () {
                        var movilesAdaptador = new $.jqx.dataAdapter({
                            beforeSend: function (peticion, cfg) {
                                peticion.setRequestHeader('SIREBToken', sesion);
                            },
                            dataType: "json",
                            dataFields: [
                                { name: 'idMovil', type: 'integer' },
                                { name: 'numeroMovil', type: 'integer' },
                                { name: 'marca', type: 'string' },
                                { name: 'modelo', type: 'string' }
                            ],
                            url: "moviles/mostrarMoviles"
                        });
                        
                        $("#listadoMovilesDisponibles-"+idIntervencion).jqxListBox({ source: movilesAdaptador, 
                            renderer: function (index, label, value) {
                                return movilesAdaptador.records[index].numeroMovil +" "+movilesAdaptador.records[index].marca + " " + movilesAdaptador.records[index].modelo;
                            },
                            multiple: true, displayMember: "numeroMovil", valueMember: "idMovil", width: 280, height: 150});
                        $('#modalNuevoMovil-'+idIntervencion+' #cancel').jqxButton({ width: '65px' });
                        $('#modalNuevoMovil-'+idIntervencion+' #ok').jqxButton({ width: '65px' });
                        $('#modalNuevoMovil-'+idIntervencion+' #cancel').mousedown( function () { 
                            $('#modalNuevoMovil-'+idIntervencion).jqxWindow('close'); 
                        });
                        $('#modalNuevoMovil-'+idIntervencion+' #ok').mousedown( function () {
                            var items = $("#listadoMovilesDisponibles-"+idIntervencion).jqxListBox('getSelectedItems');
                            $.each(items, function (index, evento) {
                                var mensajeAlerta = "Se agrego movil a intervencion.";
                                $.ajax({
                                    url: "/intervencion/agregarMovil/"+idIntervencion+"/"+evento.value+"",
                                    type: "POST",
                                    contentType: 'application/json',
                                    headers: { 'SIREBToken': sesion },
                                    beforeSend: function () {
                                    },
                                    success: function (respuesta) {
                                        var res = respuesta.resultado;
                                        var mod = respuesta.modulo;
                                        if(res == false && mod == "ServicioSesion"){
                                            cerrarSesion();
                                        }else{
                                            if (respuesta.resultado == true) {
                                                leerMovilesDesplegados(idIntervencion);
                                                $('#modalNuevoMovil-'+idIntervencion).jqxWindow('close');
                                            }else{
                                                alert(JSON.stringify(respuesta));
                                            }
                                        }
                                    },
                                    error: function (request, error) {
                                        errorSistema(request, error,"intervencion");
                                    }
                                });
                            });
                        });
                    }
                });
                $('#agregarMovilDesplegado').mousedown(function () {
                    $('#modalNuevoMovil-'+idIntervencion).jqxWindow('open');
                });
            }
                $("#"+ventana).on('close', function (event) { 
                    $("#"+ventana).remove();
                });
            },
            error: function (request, error) {
                errorSistema(request, error,"intervencion");
            }
        });
    }
}

function finIntervencion(idIntervencion){
    var cerrarVentanaVerint = "jqxwindow-"+idIntervencion;
    if($('#'+cerrarVentanaVerint).length > 0){$('#'+cerrarVentanaVerint).jqxWindow('close');}
    if(interFin === idIntervencion){
        return null;
    }
    interFin = idIntervencion;
    var ventana = "ventanaFinIntervencion-"+idIntervencion;
    if (!$("#"+ventana).length > 0){
        var cargando = $('<div style="margin:0 0 0 25%; z-index: 10000; position: absolute; top: 5px; left: 60%;" id="cargandoDatos"><span>Cargando...<i class="fa fa-refresh fa-spin"></i></span></div>');
        $("#dockingLayout").append(cargando);
        $.ajax({
            url: "/intervencion/buscarId/"+idIntervencion+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (intervencion) {
                interFin = 0;
                $("#cargandoDatos").remove();
                var mostrarTipoIntervencion = "";
                var mostrarTipoAviso = "";
                var mostrarjefeBrigada = "";
                var mostrarBarrioZona = "";
                var mostrarDireccion = "";
                var mostrarHora = "";
                var mostrarHoraFin = "";
                var mostrarTranscurrido = "";
                var mostrarAlertante = "";
                $.each(objetoCuartel.tipoIntervencion, function (index, tipoIntervencion) {
                    if(tipoIntervencion.idTipoIntervencion == intervencion.idTipoIntervencion){
                        mostrarTipoIntervencion = tipoIntervencion.codigo+" <i class='fa fa-info-circle' style='font-size:10pt; color: blue; display:inline-block;' aria-hidden='true' data-toggle='tooltip' data-placement='top' title='"+tipoIntervencion.descripcion+"'></i>";
                    }
                });

                $.each(objetoCuartel.tipoAviso, function (index, tipoAviso) {
                    if(tipoAviso.idTipoAviso == intervencion.idTipoAviso){
                        mostrarTipoAviso = tipoAviso.avisoTipo;
                    }
                });

                $.each(objetoCuartel.BarrioZonas, function (index, barrioZona) {
                    if(barrioZona.idBarrioZona == intervencion.idBarrioZona){
                        mostrarBarrioZona = barrioZona.barrioZona;
                    }
                });

                $.each(objetoBomberos, function (index, bombero) {
                    if(bombero.idBombero == intervencion.idJefeBrigada){
                        var nombre2 = bombero.nombre2 ? bombero.nombre2 : "";
                        mostrarjefeBrigada = bombero.nombre1 +" "+ nombre2 +" "+ bombero.apellido;
                    }
                });

               
                mostrarHora = intervencion.horaInicio;
                var formattedDate = new Date(mostrarHora);
                var fechaActual = new Date();

                
                var diferencia = (fechaActual - formattedDate)/1000;
                var d = ('0' + formattedDate.getDate()).slice(-2);
                var m =  ('0' + (formattedDate.getMonth()+1)).slice(-2);
                var horas = ('0'+formattedDate.getHours()).slice(-2);
                var minutos = ('0'+formattedDate.getMinutes()).slice(-2);
                var segundos = ('0'+formattedDate.getSeconds()).slice(-2);
                var y = formattedDate.getFullYear();
                var fecha = "";
                if (diferencia < 3600){
                    fecha = new Date(diferencia * 1000).toISOString().substring(14, 19);
                }else{
                    fecha = new Date(diferencia * 1000).toISOString().substring(11, 19);
                }
                mostrarHora = d + "/" + m + "/"+ y + " "+horas+":"+minutos+":"+segundos;
                mostrarTranscurrido = fecha;

                var dFin = ('0' + fechaActual.getDate()).slice(-2);
                var mFin =  ('0' + (fechaActual.getMonth()+1)).slice(-2);
                var horasFin = ('0'+fechaActual.getHours()).slice(-2);
                var minutosFin = ('0'+fechaActual.getMinutes()).slice(-2);
                var segundosFin = ('0'+fechaActual.getSeconds()).slice(-2);
                var yFin = fechaActual.getFullYear();

                mostrarHoraFin = dFin + "/" + mFin + "/"+ yFin + " "+horasFin+":"+minutosFin+":"+segundosFin;

                var direccion2 = intervencion.direccion2 ? " y "+intervencion.direccion2 : "";
                mostrarDireccion = intervencion.direccion1 +""+direccion2;
                mostrarAlertante = intervencion.nombreAlertante + " " + intervencion.apellidoAlertante + " <span class='fa fa-phone'></span> "+ intervencion.contactoAlertante;

                var ayudas = [];
                ayudas.push(''+intervencion.nombreAlertante+'');
                ayudas.push(''+intervencion.apellidoAlertante+'');
                ayudas.push(''+intervencion.contactoAlertante+'');
                ayudas.push(''+mostrarjefeBrigada+'');
                ayudas.push(''+mostrarBarrioZona+'');
                ayudas.push(''+mostrarTipoAviso+'');
                ayudas.push(''+mostrarDireccion+'');
                
                var cuerpoVentanaIntervencion = `
                                                 <div class='row'>
                                                     <div class='col-md-6'>
                                                         <div>
                                                              <span class='fa fa-fire form-control-feedback'></span> <label class='control-label'>Tipo</label> 
                                                                   ${mostrarTipoIntervencion} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-phone form-control-feedback'></span> <label class='control-label'>Aviso</label> 
                                                                   ${mostrarTipoAviso} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-angle-double-up form-control-feedback'></span> <label class='control-label'>Jefe Brigada</label> 
                                                                   ${mostrarjefeBrigada} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-map-o form-control-feedback'></span> <label class='control-label'>Barrio / Zona</label> 
                                                                   ${mostrarBarrioZona} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-map-marker form-control-feedback'></span> <label class='control-label'>Direccion</label> 
                                                                   ${mostrarDireccion} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-clock-o form-control-feedback'></span> <label class='control-label'>Inicio</label> 
                                                                   ${mostrarHora} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-user form-control-feedback'></span> <label class='control-label'>Alertante</label> 
                                                                   ${mostrarAlertante} 
                                                         </div>
                                                     </div>
                                                     <div class='col-md-5'>
                                                         <div>
                                                             <span class='fa fa-clock-o form-control-feedback' ></span> <label class='control-label'>Transcurrido</label> 
                                                                   <span id='tiempoTranscurrido-${idIntervencion}'> ${mostrarTranscurrido} </span>
                                                         </div>
                                                     </div>
                                                     <div class='col-md-6'>
                                                     </div>
                                                     <div class='col-md-6'>
                                                         <div>
                                                             <span class='fa fa-clock-o form-control-feedback' ></span> <label class='control-label'>Finalizacion</label> 
                                                                   <span id='tiempoTranscurrido-${idIntervencion}'> ${mostrarHoraFin} </span>
                                                         </div>
                                                     </div>
                                                     <div class='col-md-10' id="informeIntervencion-${idIntervencion}">
                                                             <span class='fa fa-info form-control-feedback' ></span> <label class='control-label'>Informe Intervencion:</label> 
                                                                <textarea id="textoInformeIntervencion-${idIntervencion}"></textarea>
                                                     </div>
                                                     <div class='col-md-4'>
                                                    </div>
                                                      <div class='col-md-8'>                                                            
                                                            <div style="float: center; margin-top: 15px;"><table><tr>
                                                               <td style='padding: 0px 10px 0px 0px;'><button id="finalizar-${idIntervencion}">Finalizar</button></td>
                                                               <td><button id="cancel-${idIntervencion}">Cancelar</button></td>
                </tr>
                </table>
                                                            </div>
                </div>
                                                 </div>`;
                
                $( "<div id='"+ventana+"' class='intervencionVentanaVista'><div><b><span style='color: #ff0000;'>Finalizar</span> Intervencion <span style='color: #ff0000;'> "+intervencion.ticket+"</span></b></div><div>"+cuerpoVentanaIntervencion+"</div></div>").appendTo( "#contenedorGeneral" );
                $("#"+ventana).jqxWindow({ height:350, width: 600, theme: 'energyblue', showCloseButton: true });
                $('#textoInformeIntervencion-'+idIntervencion).jqxTextArea({ placeHolder: 'Escriba el informe aqui', theme: 'energyblue', height: 120, width: 580, minLength: 1, source: ayudas });
                $('#'+ventana+' #cancel-'+idIntervencion).jqxButton({ width: '90px',  imgPosition: 'left', textPosition: 'left', imgSrc: 'img/cancelico.png', textImageRelation: 'imageBeforeText' });
                $('#'+ventana+' #finalizar-'+idIntervencion).jqxButton({ width: '90px',  imgPosition: 'left', textPosition: 'left', imgSrc: 'img/acceptico.png', textImageRelation: 'imageBeforeText'});
                $('#'+ventana+' #cancel-'+idIntervencion).mousedown( function () { 
                    interFin = 0;
                    $('#'+ventana).jqxWindow('close'); 
                });
                $("#"+ventana+" .jqx-window-content").css({'overflow-x':'hidden'});
                $("#"+ventana+" .jqx-window-content").css({'overflow-y':'hidden'});
                $("#"+ventana).on('close', function (event) {
                    interFin = 0;
                    $("#"+ventana).remove();
                });
                $("#"+ventana+' #finalizar-'+idIntervencion).mousedown( function () {
                    $("#mensajeAlerta").remove();
                    $( "<div id='mensajeAlerta' class='alert alert-success text-center mensajeRespuesta' role='alert'></div>").appendTo( "#contenedorGeneral" );
                    var infoIntervencion = $("#textoInformeIntervencion-"+idIntervencion).val();
                    //var infoIntervencion = new Blob([infoIntervencion], {
                    //    type: 'text/plain'});
                    var fechaActual = restarHoras(3, fechaActual);
                    function restarHoras(cantHoras, date = new Date()) {
                        date.setHours(date.getHours() - cantHoras);
                        return date;
                    }
                    var mensajeAlerta = "Se agrego movil a intervencion.";
                                       var data = {
                                           idIntervencion : intervencion.idIntervencion,
                                           ticket : intervencion.ticket,
                                           fecha : intervencion.fecha,
                                           horaInicio: intervencion.horaInicio,
                                           horaFin: fechaActual,
                                           horaLlamado: intervencion.horaLlamado,
                                           nombreAlertante : intervencion.nombreAlertante,
                                           apellidoAlertante : intervencion.apellidoAlertante,
                                           contactoAlertante : intervencion.contactoAlertante,
                                           direccion1 : intervencion.direccion1,
                                           direccion2 : intervencion.direccion2,
                                           informeIntervencion : infoIntervencion,
                                           idTipoAviso : intervencion.idTipoAviso,
                                           idEstado : 1,
                                           idBarrioZona : intervencion.idBarrioZona,
                                           idJefeBrigada : intervencion.idJefeBrigada,
                                           idTipoIntervencion : intervencion.idTipoIntervencion,
                                           idMovilRespuesta : intervencion.idMovilRespuesta
                       };
                      var formData = JSON.stringify(data);
                    $.ajax({
                        url: "/intervencion/actualizar/"+idIntervencion+"",
                        type: "PUT",
                        dataType: "json",
                        data: formData,
                        contentType: 'application/json',
                        headers: { 'SIREBToken': sesion },
                        beforeSend: function () {
                            
                        },
                        success: function (respuesta) {
                            var res = respuesta.resultado;
                            var mod = respuesta.modulo;
                            if(res == false && mod == "ServicioSesion"){
                                cerrarSesion();
                            }else{
                                if (respuesta.resultado == true) {
                                       $('#'+ventana).jqxWindow('close');
                                       $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                                       $("#listaIntervenciones").jqxGrid('updatebounddata');
                                }else{
                                    alert(JSON.stringify(respuesta));
                                }
                            }
                        },
                        error: function (request, error) {
                            errorSistema(request, error,"intervencion");
                        }
                    });
                });
            },
            error: function (request, error) {
                errorSistema(request, error,"intervencion");
            }
        });
    }
}

function leerBomberosDesplegados(idIntervencion, bomberos, idDespliegueMovil, ticket, tipo, origen){
    if(tipo == "Ajax"){
        var bomberos = "";
        $.ajax({
            url: "/intervencion/buscarId/"+idIntervencion+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (intervencion) {
                despliegueMoviles = intervencion.despliegueMoviles;
                $.each(despliegueMoviles, function (index, movilDesplegado) {
                    if(movilDesplegado.idDespliegueMovil == idDespliegueMovil){
                        bomberos = movilDesplegado.despliegueBomberos;
                    }
                });
            }});
        $(document).ajaxStop(function(){
            leeBombDesplegado(idIntervencion, bomberos, idDespliegueMovil, ticket, tipo, origen);
            $(this).unbind("ajaxStop");
        });
    }
    else if(tipo == "Objeto"){
        leeBombDesplegado(idIntervencion, bomberos, idDespliegueMovil, ticket, tipo, origen);
    }

    function leeBombDesplegado(idIntervencion, bomberos, idDespliegueMovil, ticket, tipo, origen){
        $(".movil"+idDespliegueMovil+"").removeAttr('onclick');
        $(".movil"+idDespliegueMovil+"").off();
        $(".movil"+idDespliegueMovil+"").on('click', function () {
            leerBomberosDesplegados(idIntervencion, bomberos, idDespliegueMovil, ticket, 'Objeto', origen);
        });
        var listaBomberosDesplegados ="";
        $.each(bomberos, function (index, bomberoDesplegado) {
            $.each(objetoBomberos, function (index, bombero) {
                if(bombero.idBombero == bomberoDesplegado.idBombero){
                    var nombre2 = bombero.nombre2 ? bombero.nombre2 : "";
                    listaBomberosDesplegados += "<li class='list-group-item'>"+bombero.nombre1+" "+nombre2+" "+bombero.apellido+"</li>";
                }
            });
        });
        $("#bomberosDesplegados-"+idIntervencion).remove();
        $("#modalNuevoBombero-"+idIntervencion).remove();
        var tituloBomberosDesplegados = ""
        if(origen == 'activa'){
            var tituloBomberosDesplegados = '<div class="panel-heading"><button type="button" class="btn btn-primary agregarBomberoDesplegado" id="agregarBomberoDesplegado" style="display: inline; padding: 2px;">Agregar <i class="fa fa-plus"></i></button> Bomberos en Movil:</div>';
        }else if(origen == 'historico'){
            var tituloBomberosDesplegados = '<div class="panel-heading">Bomberos en Movil:</div>';
        }
        var despliegueBomberos = `<div class="panel panel-info" id="bomberosDesplegados-${idIntervencion}">
                                        ${tituloBomberosDesplegados}
                                        <div class="panel-body">
                                            <ul class="list-group">
                                                ${listaBomberosDesplegados}
                                            </ul>
                                        </div>
                                  </div>`;
        if(origen == 'activa'){
        var modalNuevoDespliegueBombero = `<div id="modalNuevoBombero-${idIntervencion}" style="display: none;">
                                                <div>Seleccione los bomberos</div>
                                                <div>
                                                    <div id="listadoBomberosDisponibles-${idIntervencion}">
                                                    </div>
                                                    <div>
                                                        <div style="float: right; margin-top: 15px;">
                                                            <input type="button" id="ok" value="Agregar" />
                                                            <input type="button" id="cancel" value="Cancel" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>`;
        }else if(origen == 'historico'){
            var modalNuevoDespliegueBombero = "";
        }
            $("#despliegueBomberos-"+idIntervencion).html(despliegueBomberos+modalNuevoDespliegueBombero);
         if(origen == 'activa'){
        $('#modalNuevoBombero-'+idIntervencion).jqxWindow({
            maxHeight: 300, maxWidth: 350, minHeight: 30, minWidth: 300, height: 250, width: 300,
            resizable: false, isModal: true, modalOpacity: 0.3, autoOpen: false, cancelButton: $('#modalNuevoBombero-'+idIntervencion+' #cancel'),
            initContent: function () {
                var bomberosAdaptador = new $.jqx.dataAdapter({
                    beforeSend: function (peticion, cfg) {
                        peticion.setRequestHeader('SIREBToken', sesion);
                    },
                    dataType: "json",
                    dataFields: [
                                    { name: 'idBombero', type: 'integer' },
                                    { name: 'nombre1', type: 'string' },
                                    { name: 'nombre2', type: 'string' },
                                    { name: 'apellido', type: 'string' }
                                ],
                    url: "bomberos/mostrarBomberos"
                });
                $("#listadoBomberosDisponibles-"+idIntervencion).jqxListBox({ source: bomberosAdaptador, 
                    renderer: function (index, label, value) {
                        var nombre2 = bomberosAdaptador.records[index].nombre2 ? bomberosAdaptador.records[index].nombre2 : "";
                        return bomberosAdaptador.records[index].nombre1 + " " +nombre2+ " " + bomberosAdaptador.records[index].apellido;
                    },
                    multiple: true, displayMember: "nombre1", valueMember: "idBombero", width: 280, height: 150});
                $('#modalNuevoBombero-'+idIntervencion+' #cancel').jqxButton({ width: '65px' });
                $('#modalNuevoBombero-'+idIntervencion+' #cancel').mousedown(function () { $('#modalNuevoBombero-'+idIntervencion).jqxWindow('close'); });
                $('#modalNuevoBombero-'+idIntervencion+' #ok').jqxButton({ width: '65px' });
                $('#modalNuevoBombero-'+idIntervencion+' #ok').mousedown(function () {
                    var items = $("#listadoBomberosDisponibles-"+idIntervencion).jqxListBox('getSelectedItems');
                    var idBomberos = "";
                    $.each(items, function (index, evento) {
                        idBomberos += evento.value+",";
                    });
                    idBomberos = idBomberos.slice(0,-1);
                    var mensajeAlerta = "Se agrego bombero a movil.";
                    $.ajax({
                        url: "/intervencion/agregarBombero/"+idIntervencion+"/"+idBomberos+"/"+idDespliegueMovil+"",
                        type: "POST",
                        contentType: 'application/json',
                        headers: { 'SIREBToken': sesion },
                        beforeSend: function () {
                        },
                        success: function (respuesta) {
                            var res = respuesta.resultado;
                            var mod = respuesta.modulo;
                            if(res == false && mod == "ServicioSesion"){
                                cerrarSesion();
                            }else{
                                if (respuesta.resultado == true) {
                                    leerBomberosDesplegados(idIntervencion, null, idDespliegueMovil, ticket, 'Ajax', origen);
                                    $('#modalNuevoBombero-'+idIntervencion).jqxWindow('close');
                                }else{
                                    alert(JSON.stringify(respuesta));
                                }
                            }
                        },
                        error: function (request, error) {
                            errorSistema(request, error,"intervencion");
                        }
                    });
                });
            }
        });
        $('#agregarBomberoDesplegado').mousedown(function () {
            $('#modalNuevoBombero-'+idIntervencion).jqxWindow('open');
        });
    }
    }
};



function leerMovilesDesplegados(idIntervencion){
                        $.ajax({
                        url: "/intervencion/buscarId/"+idIntervencion+"",
                        type: "GET",
                        headers: { 'SIREBToken': sesion },
                        beforeSend: function () {
                            
                        },
                        success: function (intervencion) {
                            $("#cargandoDatos").remove();
                            var listaMovilesDesplegados = "";


                            $.each(intervencion.despliegueMoviles, function (index, movilDesplegado) {
                                $.each(objetoMoviles, function (index, movil) {
                                    if(movil.idMovil == movilDesplegado.idMovil){
                                        listaMovilesDesplegados += "<li class='list-group-item movil"+movilDesplegado.idDespliegueMovil+"' onclick='leerBomberosDesplegados("+idIntervencion+","+JSON.stringify(movilDesplegado.despliegueBomberos)+","+movilDesplegado.idDespliegueMovil+",\""+intervencion.ticket+"\",\"Objeto\", \"activa\");'><strong>Num. "+movil.numeroMovil+"</strong> "+movil.marca+" "+movil.modelo+"</li>";
                                    }
                                });
                            });

                            var listaMovilesDesplegados = listaMovilesDesplegados ? listaMovilesDesplegados : "Ninguno";
                            var mostrarDespliegueMoviles =`
                                                            <div class="panel panel-primary" id="movilesDesplegados">
                                                                <div class="panel-heading"><button type="button" class="btn btn-primary agregarMovilDesplegado" data-toggle="modal" data-target="#desplegarMovil" id="agregarMovilDesplegado" style="display: inline; padding: 2px;">Agregar <i class="fa fa-plus"></i></button> Moviles Desplegados:</div>
                                                                <div class="panel-body">
                                                                    <ul class="list-group">
                                                                        ${listaMovilesDesplegados}
                                                                    </ul>
                                                                </div>
                                                            </div>
                            `;
                            $("#listadoMovilesDesplegados-"+idIntervencion).html(mostrarDespliegueMoviles);
                        },
            error: function () {
            console.log("Atencion, contactar a Kike.");
        }
    });
}


//Esta función es para acer la paginación del listado de los bomberos, actualmente
//no está implementada, es una característica a desarrollar, por ende, no está
//probada completamente.
function paginador(pagtotales, pagactual) {
    var listapaginas = "";
    if (pagtotales > 1) {
        pagactual = parseInt(pagactual);
        listapaginas += `<ul class="paginador justify-content-center">`;
        const classPrevia = pagactual == 1 ? " disabled" : "";
        listapaginas += `<li class="page-item${classPrevia}"><a class="page-link" href="#" data-page="${pagactual - 1}">Anterior</a></li>`;
        for (let p = 1; p <= pagtotales; p++) {
            const classActiva = pagactual == p ? " active" : "";
            listapaginas += `<li class="page-item${classActiva}"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
        }
        const classSiguiente = pagactual == pagtotales ? " disabled" : "";
        listapaginas += `<li class="page-item${classSiguiente}"><a class="page-link" href="#" data-page="${pagactual + 1}">Siguiente</a></li>`;
        listapaginas += `</ul>`;
    }
    $("#paginador").html(listapaginas);
}

//Esta función necesita mejorarse, se trata de una función para cerrar la sesión
//iniciada por el usuario, por ahora solo elimina la cookie SIREB, pero luego
//llamará a un endpoint encargado de cerrar la sesión en el servidor también.
function cerrarSesion(){
    Cookies.remove('SIREB');
    Cookies.remove('SIREBCuartel');
    $(location).attr("href", "/");
}

//Esta función se encarga de hacer una llamada al endpoint listarEventos
//y listar los eventos del tipo que recibe por parámetro la función.
//Lo que hace es recibir un json, y procesa cada entrada del jeson con la función
//leerEvento que recibe un objeto Evento, y así va creando el código html.
function leerEventosTipo(tipo){
    $.ajax({
        url: "/eventos/listarEventos/"+tipo,
        type: "GET",
        dataType: "json",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
            $("#listaEventos").html("Cargando...<i class='fa fa-refresh fa-spin'></i>");
        },
        success: function (respuesta) {
            var res = respuesta.resultado;
            var mod = respuesta.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                eventos = "";
                if (respuesta) {
                    $.each(respuesta, function (index, evento) {
                        eventos += leerEvento(evento);
                    });
                    $("#listaEventos").html(eventos);
                }
            }
        },
        error: function () {
            console.log("Atencion, contactar a Kike.");
        }
    });
}
//Esta función recibe un objeto de tipo evento, y lo procesa para luego mostrarlo en un listado
//con código html, tiene algunos detalles para procesar la fecha. 
function leerEvento(evento){
    if(evento){
        //Acá acomodo la fecha, además, agrego el 0 delante del día y del mes. Toda una parafernalia. (mejorar?)
        var fecha = new Date(evento.fecha);
        var fecha = ('0' + fecha.getDate()).slice(-2)+"-"+('0' + (fecha.getMonth()+1)).slice(-2)+"-"+fecha.getFullYear()+" "+('0' + fecha.getHours()).slice(-2)+":"+('0' + fecha.getMinutes()).slice(-2)+":"+('0' + fecha.getSeconds()).slice(-2);
        eventoHtml = "<tr><td>"+fecha+"&nbsp;</td><td>"+evento.mensaje+"</td></tr>";
    }
    return eventoHtml;
}
//Esta función actualiza los eventos de tipo Sesión, que son mostrados en la página
//principal. Se utiliza para llamarlo desde un timer, que está en la propia página
//principal y además, para el botón de actualizar que está en el título de 
//Últimos eventos.
function actualizarEventos(){
    var listaEventos = $("#listaEventos");
    if(!listaEventos.length == 0){
        $("#listaEventos").jqxGrid('updatebounddata');
    }
}

// Esta función recibe un objeto bombero, y en base a eso, crea codigo html con los datos
// de dicho bombero. Para luego mostrarlo en el listado de la página de bomberos.
function leerbomberorow(bombero) {
    var bomberoRow = "";
    if (bombero) {
        const fotobombero = bombero.genero ? bombero.genero : "x";
        var Grado = elegirGrado(bombero.idGrado);
        var nombre2 = bombero.nombre2 ? bombero.nombre2 : "";
        bomberoRow = `<tr>
          <td class="align-middle"><img src="/img/generos/${fotobombero}.png" class="img-thumbnail rounded float-left"></td>
          <td class="align-middle">${bombero.nombre1} ${nombre2}</td>
          <td class="align-middle">${bombero.apellido}</td>
          <td class="align-middle">${Grado}</td>
          <td class="align-middle">
            <a href="#" class="btn btn-info mr-3 perfil" data-toggle="modal" data-target="#perfilModal"
              title="Perfil" data-id="${bombero.dni}"><i class="fa fa-address-card-o" aria-hidden="true"></i></a>
            <a href="#" class="btn btn-warning mr-3 edituser" data-toggle="modal" data-target="#ventanabombero"
              title="Editar" data-id="${bombero.dni}"><i class="fa fa-pencil-square-o fa-lg"></i></a>
            <a href="#" class="btn btn-danger borrarbombero" data-toggle="modal" data-target="#borrarModal" 
              title="Borrar" data-id="${bombero.dni}"><i
                class="fa fa-trash-o fa-lg"></i></a>
          </td>
        </tr>`;
    }
    return bomberoRow;
}

//Con esta función, llamo a la lista de los bomberos, haciendo una petición
//al endpoint motrarBomberos, que devuelve una lista json, con todos los bomberos
//(por ahora sin paginar) y cada bombero es un objeto, que es procesado por la función
//leerbomberorow (la cual recibe un objeto bombero y devuelve codigo html parseado)
function leerbomberos() {

    var pageno = $("#pagactual").val();
    $.ajax({
        url: "/bomberos/mostrarBomberos",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
            $("#capaSuperpuesta").fadeIn();
        },
        success: function (rows) {
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    var listabomberos = "";
                    $.each(rows, function (index, bombero) {
                        listabomberos += leerbomberorow(bombero);
                    });
                    $("#tablabomberos tbody").html(listabomberos);
                    let totalbomberos = rows.count;
                    let pagtotales = Math.ceil(parseInt(totalbomberos) / 10);
                    const pagactual = $("#pagactual").val();
                    paginador(pagtotales, pagactual);
                    $("#capaSuperpuesta").fadeOut();
                }
            }
        },
        error: function (request, error) {
                    errorSistema(request, error,"bombero");
        }
    });
}

//Con esta funcion elijo asocio el idGrado a un grado en particular, y retorno 
//un String con el nombre del Grado.
function elegirGrado(idGrado) {
    return $('#Grado option[value="' + idGrado + '"]').html();
}

function leerGrado(grado){
    var gradoRow = "";
    if (grado) {
        gradoRow = `<option value="${grado.idGrado}">${grado.grado}</option>`;
    }
    return gradoRow;
}



function leerbarriozonarow(barriozona) {
    var barriozonaRow = "";
    const jurisdiccion = barriozona.jurisdiccion ? "Si" : "No";
    const color = barriozona.jurisdiccion ? "barrioEsJurisdiccion" : "barrioNoEsJurisdiccion";
    if (barriozona) {
        barriozonaRow = `<tr class="${color}">
          <td class="align-middle">${barriozona.barrioZona}</td>
          <td class="align-middle">${jurisdiccion}</td>
          <td class="align-middle" style="text-align:center;">
            <a href="#" class="btn btn-warning mr-3 editarBarrioZona" data-toggle="modal" data-target="#ventanabarriozona"
              title="Editar" data-id="${barriozona.idBarrioZona}"><i class="fa fa-pencil-square-o fa-lg"></i></a>
            <a href="#" class="btn btn-danger borrarBarrioZona" data-toggle="modal" data-target="#borrarBarriozona" 
              title="Borrar" data-id="${barriozona.idBarrioZona}"><i
                class="fa fa-trash-o fa-lg"></i></a>
          </td>
        </tr>`;
    }
    return barriozonaRow;
}


function leerbarrioszonas() {
    var nombreClass ="";
    $.ajax({
        url: "/barrioszonas/mostrarTodas",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
            var cargando = $('<div style="margin:0 0 0 25%;" id="cargandoDatos"><span>Cargando...<i class="fa fa-refresh fa-spin"></i></span></div>');
            $("#contenedorBarriosZonas").append(cargando);
        },
        success: function (rows) {
            $("#cargandoDatos").remove();
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    var listabarrioszonas = "";
                    $.each(rows, function (index, barriozona) {
                        listabarrioszonas += leerbarriozonarow(barriozona);
                    });
                    $("#tablabarrioszonas tbody").html(listabarrioszonas);
                    $('#tablabarrioszonas tr').hover(function() {
                    nombreClass = $(this).attr("class");
                    $(this).addClass('barrioZonasOver');
                    $(this).removeClass(nombreClass);
                }, function() {
                    $(this).removeClass('barrioZonasOver');
                    $(this).addClass(nombreClass);
                });
            }
        }
        },
        error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
    });
}


// Esta función recibe un objeto movil, y en base a eso, crea codigo html con los datos
// de dicho movil. Para luego mostrarlo en el listado de la página de moviles.
function leermovilrow(movil) {
    var movilRow = "";
    if (movil) {
                var tipoMovil = elegirTipoMovil(movil.idTipoMovil);
                var estadoMovil = elegirEstado(movil.idEstadoMovil);
                var titleTipoMovil = elegirTitleTipoMovil(movil.idTipoMovil);

        movilRow = `<tr class="backMovilTr-${movil.idEstadoMovil}" title="${titleTipoMovil}">
          <td class="align-middle"><img src="/img/moviles/movil${movil.idTipoMovil}.png" class="img-thumbnail rounded float-left"></td>
          <td class="align-middle">${movil.numeroMovil}</td>
          <td class="align-middle">${movil.marca}</td>
          <td class="align-middle">${movil.modelo}</td>
          <td class="align-middle">${tipoMovil}</td>
          <td class="align-middle">${estadoMovil}</td>
          <td class="align-middle">
            <a href="#" class="btn btn-info mr-3 detalleMovil" data-toggle="modal" data-target="#detalleMovilModal"
              title="Detalle" data-id="${movil.idMovil}"><i class="fa fa-address-card-o" aria-hidden="true"></i></a>
            <a href="#" class="btn btn-warning mr-3 editarMovil" data-toggle="modal" data-target="#ventanamovil"
              title="Editar" data-id="${movil.idMovil}"><i class="fa fa-pencil-square-o fa-lg"></i></a>
            <a href="#" class="btn btn-danger borrarMovil" data-toggle="modal" data-target="#borrarModal" 
              title="Borrar" data-id="${movil.idMovil}"><i
                class="fa fa-trash-o fa-lg"></i></a>
          </td>
        </tr>`;
    }
    return movilRow;
    function elegirEstado(idEstadoMovil){
        switch (idEstadoMovil) {
            case 1:
                return "<span class='btn btn-success btn-rounded' style='width:120px; height: 20px; padding:0px;'>En servicio</span>";
                break;
	    case 2:
                return "<span class='btn btn-danger btn-rounded' style='width:120px; height: 20px; padding:0px;'>Fuera de servicio</span>";
                break;
	    case 3:
                return "<span class='btn btn-info btn-rounded' style='width:120px; height: 20px; padding:0px;'>En reparacion</span>";
                break;
	    case 4:
                return "<span class='btn btn-warning btn-rounded' style='width:120px; height: 20px; padding:0px;'>Desperfectos</span>";
                break;
            default:
                return "<span class='btn-success btn-rounded' style='width:120px; height: 20px; padding:0px;'>En servicio</span>";
        }
    }

}

function elegirTipoMovil(idMovil) {
    return $('#tipoMovil option[value="' + idMovil + '"]').html();
}

function elegirTitleTipoMovil(idMovil) {
    return $('#tipoMovil option[value="' + idMovil + '"]').attr('title');
}
function leerTipoMovil(tipomovil){
    var tipomovilRow = "";
    if (tipomovil) {
        tipomovilRow = `<option value="${tipomovil.idTipoMovil}" title="${tipomovil.descripcion}">${tipomovil.tipo}</option>`;
    }
    return tipomovilRow;
}
//Con esta función, llamo a la lista de los moviles, haciendo una petición
//al endpoint mostrarMoviles, que devuelve una lista json, con todos los moviles
//(por ahora sin paginar) y cada movil es un objeto, que es procesado por la función
//leermovilrow (la cual recibe un objeto movil y devuelve codigo html parseado)
function leermoviles() {

    var pageno = $("#pagactual").val();
    $.ajax({
        url: "/moviles/mostrarMoviles",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
            $("#capaSuperpuesta").fadeIn();
        },
        success: function (rows) {
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    var listamoviles = "";
                    $.each(rows, function (index, movil) {
                        listamoviles += leermovilrow(movil);
                    });
                    $("#tablamoviles tbody").html(listamoviles);
                    let totalmoviles = rows.count;
                    let pagtotales = Math.ceil(parseInt(totalmoviles) / 10);
                    const pagactual = $("#pagactual").val();
                    paginador(pagtotales, pagactual);
                    $("#capaSuperpuesta").fadeOut();
                }
            }
        },
        error: function (request, error) {
                                errorSistema(request, error,"moviles");
                }
    });
}


 $(document).on("click", "a.editarBarrioZona", function () {
        $("#formEditarBarrioZona")[0].reset();
        var reset = $("#formEditarBarrioZona").validate();
        reset.resetForm();
        $('#formEditarBarrioZona .form-control').removeClass('error');
        var pid = $(this).data("id");
        $.ajax({
            url: "/barrioszonas/mostrar/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (barrioZona) {
            var res = barrioZona.resultado;
            var mod = barrioZona.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (barrioZona) {
                    $("#barrioZona").val(barrioZona.barrioZona);
                    const jurisdiccion = barrioZona.jurisdiccion ? "true" : "false";
                    $("#jurisdiccion").val(jurisdiccion);
                    $("#idBarrioZona").val(barrioZona.idBarrioZona);

                }
            }
            },
            error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });
    });

    $(document).on("submit", "#formEditarBarrioZona", function (event) {
        event.preventDefault();
        var idBarrioZona = $('#idBarrioZona').val();
        var barrioZona = $('#barrioZona').val();
        var jurisdiccion = $('#jurisdiccion').val();
        if($("#idBarrioZona").val().length > 0){
        var data = {
            idBarrioZona : idBarrioZona,
            barrioZona : barrioZona,
            jurisdiccion : jurisdiccion,
        };

        var formData = JSON.stringify(data);
        var mensajeAlerta = "Barrio / zona actualizado.";
        $.ajax({
                url: "/barrioszonas/actualizar/"+idBarrioZona+"",
                type: "PUT",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta.resultado == true) {
                            $("#ventanabarriozona").modal("hide");
                            $("#formEditarBarrioZona")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leerbarrioszonas();
                            $('.modal-backdrop').remove();
                        }else{
                            $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(3000).fadeOut();                        
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });
    }else{
        var data = {
            barrioZona : barrioZona,
            jurisdiccion : jurisdiccion
        };

        var formData = JSON.stringify(data);
        var mensajeAlerta = "Se agrego Barrio / zona.";
        $.ajax({
                url: "/barrioszonas/agregar",
                type: "POST",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{                    
                        if (respuesta.resultado == true) {
                            $("#ventanabarriozona").modal("hide");
                            $("#formEditarBarrioZona")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leerbarrioszonas();
                            $('.modal-backdrop').remove();
                        }else{
                            $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(3000).fadeOut();                        
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });

        
    }
    });

    $(document).on("click", "a.borrarBarrioZona", function (e) {
        e.preventDefault();
        var pid = $(this).data("id");


        $.ajax({
            url: "/barrioszonas/mostrar/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (barrioZona) {
                var res = barrioZona.resultado;
                var mod = barrioZona.modulo;
                if(res == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{                
                    if (barrioZona) {
                        nombrebarrioZona = barrioZona.barrioZona;
                        idBarrioZona = barrioZona.idBarrioZona;
                        mensaje = `Esta seguro de querer eliminar a ${nombrebarrioZona}?`;
                        $("#borrar").html(mensaje);
                        $("#eliminarDialog").off();
                        $(document).on("click", "#eliminarDialog", function () {
                        $.ajax({
                            url: "/barrioszonas/eliminar/"+idBarrioZona+"",
                            type: "DELETE",
                            dataType: "json",
                            headers: { 'SIREBToken': sesion },
                            beforeSend: function () {
                            },
                            success: function (res) {
                                var resu = res.resultado;
                                var mod = res.modulo;
                                if(resu == false && mod == "ServicioSesion"){
                                    cerrarSesion();
                                }else{
                                    if (res) {
                                        $("#borrar").html("");
                                        $("#borrarBarriozona").modal("hide");
                                        $("#formEditarBarrioZona")[0].reset();
                                        $(".mensajeRespuesta").html("Se elimino correctamente el barrio/Zona!").fadeIn().delay(500).fadeOut();
                                        leerbarrioszonas();
                                    }
                                }
                            },
                            error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
                        });
                    });
                }
            }
            },
            error: function (request, error) {
                errorSistema(request, error,"cuartel");
            }
        });
    });

$(document).on("click", "a.editarMovil", function () {
        $("#formEditarMovil")[0].reset();
        var reset = $("#formEditarMovil").validate();
        reset.resetForm();
        $('#formEditarMovil .form-control').removeClass('error');
        var pid = $(this).data("id");
        $.ajax({
            url: "/moviles/mostrarMovilesPorNumero/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (movil) {
            var res = movil.resultado;
            var mod = movil.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (movil) {
                    if(movil.idTipoBomba){
                        $("#grupoTipoBomba").show();
                        $("#tipoBomba").val(movil.idTipoBomba);
                    }else{
                        $("#grupoTipoBomba").hide();
                    }
                    $("#formEditarMovil #id").val(movil.idMovil);
                    $("#marca").val(movil.marca);
                    $("#modelo").val(movil.modelo);
                    $("#plaza").val(movil.plaza);
                    $("#tipoMovil").val(movil.idTipoMovil);
                    $("#numeroMovil").val(movil.numeroMovil);
                    $("#estado").val(movil.idEstadoMovil);
                    }
            }
            },
            error: function (request, error) {
                                errorSistema(request, error,"moviles");
                }
        });
    });

    $(document).on("submit", "#formEditarMovil", function (event) {
        event.preventDefault();
        var idMovil = $("#formEditarMovil #id").val();
        var modelo = $('#modelo').val();
        var marca = $('#marca').val();
        var plaza = $('#plaza').val();
        var numeroMovil = $('#numeroMovil').val();
        var idTipoBomba = $('#tipoBomba').val();
        var idEstadoMovil = $('#estado').val();
        var idTipoMovil = $('#tipoMovil').val();
        if($("#formEditarMovil #id").val().length > 0){
        var data = {
            idMovil : idMovil,
            numeroMovil : numeroMovil,
            marca : marca,
            modelo : modelo,
            plaza : plaza,
            idTipoBomba : idTipoBomba,
            idEstadoMovil : idEstadoMovil,
            idTipoMovil : idTipoMovil
        };

        var formData = JSON.stringify(data);
        var mensajeAlerta = "Movil actualizado.";
        $.ajax({
                url: "/moviles/actualizarMoviles/"+idMovil+"",
                type: "PUT",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta.resultado == true) {
                            $(".mensajeRespuesta").removeClass("alert-danger");
                            $(".mensajeRespuesta").addClass("alert-success");
                            $("#ventanamovil").modal("hide");
                            $("#formEditarMovil")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leermoviles();
                            $('.modal-backdrop').remove();
                        }else{
                            $(".mensajeRespuesta").removeClass("alert-success");
                            $(".mensajeRespuesta").addClass("alert-danger");
                            $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(5000).fadeOut();                        
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });
    }else{
        var data = {
            numeroMovil : numeroMovil,
            marca : marca,
            modelo : modelo,
            plaza : plaza,
            idTipoBomba : idTipoBomba,
            idEstadoMovil : idEstadoMovil,
            idTipoMovil : idTipoMovil
        };

        var formData = JSON.stringify(data);
        var mensajeAlerta = "Se agrego movil.";
        $.ajax({
                url: "/moviles/guardarMoviles/",
                type: "POST",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{                    
                        if (respuesta.resultado == true) {
                            $("#ventanamovil").modal("hide");
                            $("#formEditarMovil")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leermoviles();
                            $('.modal-backdrop').remove();
                        }else{
                            $("#ventanamovil").modal("hide");
                            $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(3000).fadeOut();                        
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });

        
    }
    });


// leer detalle movil
$(document).on("click", "a.detalleMovil", function () {
        var pid = $(this).data("id");
        $.ajax({
            url: "/moviles/mostrarMovilesPorNumero/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            success: function (movil) {
                var resu = movil.resultado;
                var mod = movil.modulo;
                if(resu == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{
                    if (movil) {

                var tipoMovil = elegirTipoMovil(movil.idTipoMovil);
                var estadoMovil = elegirEstado(movil.idEstadoMovil);
                var titleTipoMovil = elegirTitleTipoMovil(movil.idTipoMovil);
                var tipoBomba = $('#tipoBomba option[value="' + movil.idTipoBomba + '"]').html();
        movilRow = `<tr class="backMovilTr-${movil.idEstadoMovil}" title="${titleTipoMovil}">
          <td class="align-middle"><img src="/img/moviles/movil${movil.idTipoMovil}.png" class="img-thumbnail rounded float-left"></td>`;
                        
                    const detalleMovil = `<div class="row">
                <div class="col-sm-4 col-md-3">
                  <img src="/img/moviles/movil${movil.idTipoMovil}.png" class="img-thumbnail rounded float-left" style="width: 200px !important;">
                        <span style="font-size: 12pt; position:absolute; top:30px; left: 160px; color:#000000; text-shadow: 0 3px 3px #cdcdb1;"><b>${movil.numeroMovil}</b></span>
                  <p class="text-secondary">
                        <i class="fa fa-truck" aria-hidden="true"></i><b> Marca ${movil.marca} ${movil.modelo}</b>
                  </p>
                  <p class="text-secondary">
                        Intervenciones: 451
                  </p>

                </div>
                <div class="col-sm-4 col-md-3">
                    <h4 class="text-primary">&nbsp;</h4>
                  <p class="text-secondary">
                    <i class="fa fa-cogs" aria-hidden="true"></i> Estado ${estadoMovil}
                  </p>                  
                  <p class="text-secondary">
                   <i class="fa fa-fire" aria-hidden="true"></i> Tipo ${tipoMovil} (${titleTipoMovil})
                  </p>
                  <p class="text-secondary">
                   <i class="fa fa-fire-extinguisher" aria-hidden="true"></i> Bomba ${tipoBomba}
                  </p>
                  <p class="text-secondary">
                   <i class="fa fa-users" aria-hidden="true"></i> Plazas ${movil.plaza}
                  </p>

                </div>
              </div>`;
                    $("#detalleMovil").html(detalleMovil);
                }
            }
            },
            error: function (request, error) {
                                errorSistema(request, error,"moviles");
                            }
        });
 
    function elegirEstado(idEstadoMovil){
        switch (idEstadoMovil) {
            case 1:
                return "<span class='btn btn-success btn-rounded' style='width:120px; height: 20px; padding:0px;'>En servicio</span>";
                break;
	    case 2:
                return "<span class='btn btn-danger btn-rounded' style='width:120px; height: 20px; padding:0px;'>Fuera de servicio</span>";
                break;
	    case 3:
                return "<span class='btn btn-info btn-rounded' style='width:120px; height: 20px; padding:0px;'>En reparacion</span>";
                break;
	    case 4:
                return "<span class='btn btn-warning btn-rounded' style='width:120px; height: 20px; padding:0px;'>Desperfectos</span>";
                break;
            default:
                return "<span class='btn-success btn-rounded' style='width:120px; height: 20px; padding:0px;'>En servicio</span>";
        }
    }

});



    $(document).on("click", "a.borrarMovil", function (e) {
        e.preventDefault();
        var pid = $(this).data("id");


        $.ajax({
            url: "/moviles/mostrarMovilesPorNumero/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (movil) {
                var res = movil.resultado;
                var mod = movil.modulo;
                if(res == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{                
                    if (movil) {
                        nombremovil = movil.numeroMovil;
                        idMovil = movil.idMovil;
                        mensaje = `Esta seguro de querer eliminar a ${nombremovil}?`;
                        $("#borrar").html(mensaje);
                        $("#eliminarDialog").off();
                        $(document).on("click", "#eliminarDialog", function () {
                        $.ajax({
                            url: "/moviles/borrarMoviles/"+idMovil+"",
                            type: "DELETE",
                            dataType: "json",
                            headers: { 'SIREBToken': sesion },
                            beforeSend: function () {
                            },
                            success: function (res) {
                                var resu = res.resultado;
                                var mod = res.modulo;
                                if(resu == false && mod == "ServicioSesion"){
                                    cerrarSesion();
                                }else{
                                    if (res) {
                                        $("#borrar").html("");
                                        $("#borrarModal").modal("hide");
                                        $("#formEditarMovil")[0].reset();
                                        $(".mensajeRespuesta").html("Se elimino correctamente el movil!").fadeIn().delay(500).fadeOut();
                                        leermoviles();
                                    }
                                }
                            },
                            error: function (request, error) {
                                errorSistema(request, error,"moviles");
                }
                        });
                    });
                }
            }
            },
            error: function (request, error) {
                errorSistema(request, error,"moviles");
            }
        });
    });

function leergradorow(grado) {
    var gradoRow = "";
    if (grado) {
        gradoRow = `<tr class="barrioEsJurisdiccion">
          <td class="align-middle">${grado.grado}</td>
          <td class="align-middle" style="text-align:center;">
            <a href="#" class="btn btn-warning mr-3 editarGrado" data-toggle="modal" data-target="#ventanagrado"
              title="Editar" data-id="${grado.idGrado}"><i class="fa fa-pencil-square-o fa-lg"></i></a>
            <a href="#" class="btn btn-danger borrarGrado" data-toggle="modal" data-target="#borrarGrado" 
              title="Borrar" data-id="${grado.idGrado}"><i
                class="fa fa-trash-o fa-lg"></i></a>
          </td>
        </tr>`;
    }
    return gradoRow;
}



function leergrados() {
    var nombreClass ="";
    $.ajax({
        url: "/grados/mostrarGrados",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
            var cargando = $('<div style="margin:0 0 0 25%;" id="cargandoDatos"><span>Cargando...<i class="fa fa-refresh fa-spin"></i></span></div>');
            $("#contenedorGrados").append(cargando);
        },
        success: function (rows) {
            $( "#cargandoDatos" ).remove();
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    objGrados = objetoCuartel.Grados;
                    var jsonString = JSON.stringify(rows);
                    jsonString = JSON.parse(jsonString);
                    objetoCuartel.Grados = jsonString;
                    listagrados = "";
                    $.each(objetoCuartel.Grados, function (index, grados) {
                        listagrados += leerGrado(grados);
                    });
                    var listagradosrow = "";
                    $.each(rows, function (index, grado) {
                        listagradosrow += leergradorow(grado);
                    });
                    $("#tablagrados tbody").html(listagradosrow);
                    $('#tablagrados tr').hover(function() {
                        nombreClass = $(this).attr("class");
                        $(this).addClass('barrioZonasOver');
                        $(this).removeClass(nombreClass);
                    }, function() {
                        $(this).removeClass('barrioZonasOver');
                        $(this).addClass(nombreClass);
                    });
                }
            }
        },
        error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
    });
}

 $(document).on("click", "a.editarGrado", function () {
        $("#formEditarGrado")[0].reset();
        var reset = $("#formEditarGrado").validate();
        reset.resetForm();
        $('#formEditarGrado .form-control').removeClass('error');
        var pid = $(this).data("id");
        $.ajax({
            url: "/grados/mostrar/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (grado) {
                var res = grado.resultado;
                var mod = grado.modulo;
                if(res == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{
                    if (grado) {
                        $("#grado").val(grado.grado);
                        $("#idGrado").val(grado.idGrado);
                    }
                }
            },
            error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });
    });

    $(document).on("submit", "#formEditarGrado", function (event) {
        event.preventDefault();
        var idGrado = $('#idGrado').val();
        var grado = $('#grado').val();
        if($("#idGrado").val().length > 0){
        var data = {
            idGrado : idGrado,
            grado : grado
        };

        var formData = JSON.stringify(data);
        var mensajeAlerta = "Grado actualizado.";
        $.ajax({
                url: "/grados/actualizarGrado",
                type: "PUT",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta.resultado == true) {
                            objIndex = objetoCuartel.Grados.findIndex((grado => grado.idGrado == idGrado));
                            objetoCuartel.Grados[objIndex].grado = grado;
                            $("#ventanagrado").modal("hide");
                            $("#formEditarGrado")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leergrados();
                            $('.modal-backdrop').remove();
                        }else{
                            $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(3000).fadeOut();                        
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });
    }else{
        var data = {
            grado : grado
        };

        var formData = JSON.stringify(data);
        var mensajeAlerta = "Se agrego Grado.";
        $.ajax({
                url: "/grados/guardarGrado",
                type: "POST",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta.resultado == true) {
                            $("#ventanagrado").modal("hide");
                            $("#formEditarGrado")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leergrados();
                            $('.modal-backdrop').remove();
                        }else{
                            $(".mensajeRespuesta").html("Ocurrio un error:"+respuesta.mapaErrores).fadeIn().delay(3000).fadeOut();                        
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
        });

        
    }
    });

    $(document).on("click", "a.borrarGrado", function (e) {
        e.preventDefault();
        var pid = $(this).data("id");
        $.ajax({
            url: "/grados/mostrar/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (grado) {
                var res = grado.resultado;
                var mod = grado.modulo;
                if(res == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{
                    if (grado) {
                        nomGrado = grado.grado;
                        idGrado = grado.idGrado;
                        mensaje = `Esta seguro de querer eliminar a ${nomGrado}?`;
                        $("#borrarContenedor").html(mensaje);
                        $("#eliminarDialog").off();
                        $(document).on("click", "#eliminarDialog", function () {
                            $.ajax({
                                url: "/grados/eliminarGrado/"+idGrado+"",
                                type: "DELETE",
                                dataType: "json",
                                headers: { 'SIREBToken': sesion },
                                beforeSend: function () {
                                },
                                success: function (res) {
                                    var resu = res.resultado;
                                    var mod = res.modulo;
                                    if(resu == false && mod == "ServicioSesion"){
                                        cerrarSesion();
                                    }else{
                                        if (res) {
                                            $("#borrar").html("");
                                            $("#borrarGrado").modal("hide");
                                            $("#formEditarGrado")[0].reset();
                                            $(".mensajeRespuesta").html("Se elimino correctamente el grado.").fadeIn().delay(500).fadeOut();
                                            leergrados();
                                        }
                                    }
                                },
                                error: function (request, error) {
                                    errorSistema(request, error,"cuartel");
                                }
                            });
                        });
                    }
                }
            },
            error: function (request, error) {
                errorSistema(request, error,"cuartel");
            }
        });
    });


//Esta funcion inicializara el frontend con la configuracion
//propia del cuartel en particular idCuartel
function inicializarFE(idCuartel){
        $.ajax({
        url: "/variablesWeb/leer/"+idCuartel,
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
        },
        success: function (cfg) {
            var res = cfg.resultado;
            var mod = cfg.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (cfg) {
                    objetoCuartel = cfg;
                    confAlturaMain();
                    $.each(cfg, function (index, confg) {
                        if(index === "Cuartel"){
                            direccionCuartel = confg[0].direccion;
                            logo = confg[0].logo;
                            $("#titDireccion").html(direccionCuartel);
                            $('#logoCuartel').attr("src",logo);
                        }else if (index === "Grados"){
                            $.each(confg, function (index, grado) {
                                listagrados += leerGrado(grado);
                            });
                        }
                    });
                    $("#Grado").html(listagrados);
                }
            }
        },
        error: function (request, error) {
            errorSistema(request, error,"inicializar");
        }
    });
}
//Creo un objeto temporal para la convercion de la imagen, esto lo debo mejorar
var logoTran=document.createElement("a"); 

   function imagenABase64(esto) {
       var archivo = esto.files[0];
       var lector = new FileReader();
       lector.onloadend = function() {
         $("#logoTran").attr("href",lector.result);
         $("#logoTran").text(lector.result);
         $("#logo").attr("src", lector.result);
       }
       lector.readAsDataURL(archivo);
       return lector.result;
     }
     
     
function errorSistema(request, error, tipo){
                    var mensajeAlerta = "";
                    if(tipo == "bombero"){
                        $("#ventanabombero").modal("hide");
                        $("#formAgregar")[0].reset();
                        $("#capaSuperpuesta").fadeOut();
                    }else if(tipo == "cuartel"){
                        $("#borrar").html("");
                        $("#borrarGrado").modal("hide");
                        $("#formEditarGrado")[0].reset();
                        $("#ventanagrado").modal("hide");
                        $("#borrarBarriozona").modal("hide");
                        $("#formEditarBarrioZona")[0].reset();
                        $("#ventanabarriozona").modal("hide");
                    } else if (tipo == "moviles"){
                        $("#capaSuperpuesta").fadeOut();
                    }
                        $(".mensajeRespuesta").removeClass("alert-success");
                        $(".mensajeRespuesta").addClass("alert-danger");
                        $('.modal-backdrop').remove();
                    
                    resp = request.responseJSON;
                    if(resp){
                        if(resp.error > 0){
                            mensajeAlerta = "Codigo: "+resp.status+" Error: "+resp.error+" Mensaje: "+resp.message+" "+resp.path;                        
                        }else if (resp.resultado == false){
                            mensajeAlerta = "Modulo: "+resp.modulo+" Tipo: "+resp.tipo+" Errores: "+JSON.stringify(resp.mapaErrores)+" Fecha: "+resp.fecha;
                        }else {
                            mensajeAlerta = "No se pudo completar la accion, error inesperado.";                        
                        }
                    } else {
                        if(request.status != 200){
                            mensajeAlerta = "Codigo: "+request.status+" Error: "+request.statusText+" Mensaje: "+request.responseText;                        
                        }else {
                            mensajeAlerta = "Error general.";    
                        }
                    }
                    $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(9000).fadeOut( function(){$(".mensajeRespuesta").addClass("alert-success"); $(".mensajeRespuesta").removeClass("alert-danger");});    
}
//Esta es una función general de jquery, que lo que hace es validar que el 
//documento se ha cargado completamente, y luego ejecuta todo el código que está en su interior.
$(document).ready(function () {
   
    var idCuartel = Cookies.get('SIREBCuartel');
    var sesion = Cookies.get('SIREB');
    
    if(esNullYUndef(sesion)){
        validarSesion(sesion,"/");
    }else{
        cerrarSesion();
        $(location).attr("href", "/");
    };
   
    inicializarFE(idCuartel);
    //Le agregamos un monitor con jquery al submit del form Agregar, que es parte del
    //alta y actualización de bombero, para ejecutar el código que tiene en su interior
    //cuando se haga click en él.
    $(document).on("submit", "#formAgregar", function (event) {
        event.preventDefault();
        var idBombero = $('#id').val();
        var idCuartel = $('#idCuartel').val();
        var nombre1 = $('#nombre1').val();
        var nombre2 = $('#nombre2').val();
        if(nombre2 === ""){
            nombre2 = null;
        }
        var apellido = $('#apellido').val();
        var telefonoCasa = parseInt($('#telefonoCasa').val());
        if(telefonoCasa === ""){
            telefonoCasa = null;
        }
        var telefonoCelular = parseInt($('#telefonoMovil').val());
        var factorSanguineo = $('#factorSanguineo').val();
        var genero = $('#genero').val();
        var edad = $('#edad').val();
        var fechaBaja = null;
        var fechaAlta = $('#fechaAlta').val();
        var fechaNacimiento = $('#fechaNacimiento').val();
        var idMotivoBaja = null;
        var dni = $('#dni').val();
        var direccion = $('#direccion').val();
        var idGrado = $('#Grado').val();
        var data = {
            idBombero : idBombero,
            nombre1 : nombre1,
            nombre2 : nombre2,
            apellido : apellido,
            telefonoCasa: telefonoCasa,
            telefonoCelular: telefonoCelular,
            direccion : direccion,
            fechaNacimiento : fechaNacimiento,
            edad : edad,
            factorSanguineo : factorSanguineo,
            genero : genero,
            fechaAlta : fechaAlta,
            fechaBaja : fechaBaja,
            idMotivoBaja : idMotivoBaja,
            idGrado : idGrado,
            dni : dni,
            idCuartel : idCuartel
        };
        var formData = JSON.stringify(data);
        var mensajeAlerta = $("#id").val().length > 0 ? "Bombero actualizado." : "Se ha agregado un nuevo bombero";
        if($("#id").val().length > 0){
            var idper = parseInt($("#id").val());
            var data = {
                idBombero : idBombero,
                nombre1 : nombre1,
                nombre2 : nombre2,
                apellido : apellido,
                telefonoCasa: telefonoCasa,
                telefonoCelular: telefonoCelular,
                direccion : direccion,
                fechaNacimiento : fechaNacimiento,
                edad : edad,
                factorSanguineo : factorSanguineo,
                genero : genero,
                fechaAlta : fechaAlta,
                fechaBaja : fechaBaja,
                idMotivoBaja : idMotivoBaja,
                idGrado : idGrado,
                idCuartel : idCuartel,
                dni : dni
            };
            var formData = JSON.stringify(data);
            $.ajax({
                url: "/bomberos/actualizarBombero/"+idBombero+"",
                type: "PUT",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                   // $("#capaSuperpuesta").fadeIn();
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta) {
                            $("#ventanabombero").modal("hide");
                            $("#formAgregar")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leerbomberos();
                            $('.modal-backdrop').remove();
                        }
                    }
                },
                error: function (request, error) {
                    errorSistema(request, error,"bombero");
                }
            });
        }else{
            $.ajax({
                url: "/bomberos/guardarBombero/",
                type: "POST",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                    $("#capaSuperpuesta").fadeIn();
                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta) {
                            $("#ventanabombero").modal("hide");
                            $("#formAgregar")[0].reset();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            leerbomberos();
                            $("#capaSuperpuesta").fadeOut();
                            $('.modal-backdrop').remove();
                        }
                    }
                },
                error:  function (request, error) {
                    errorSistema(request, error,"bombero");
                }
            });
        };
    });

    
    // Esta función aún no está implementada, es parte del paginador, para cuando 
    // traigamos una lista de bomberos paginada. 
    $(document).on("click", "ul.paginador li a", function (e) {
        e.preventDefault();
        var $this = $(this);
        const numeropagina = $this.data("page");
        $("#pagactual").val(numeropagina);
        leerbomberos();
        $this.parent().siblings().removeClass("active");
        $this.parent().addClass("active");
    });
    
    // Se llama a esta función, cuando se hace click en el botón de 
    //nuevo Bombero, lo que hace es limpiar el formulario y llevarlos a 
    //valores por defecto, remueve cualquier advertencia de error que haya
    //quedado escrita en el código html de pantalla. 
     $(document).on("click", "#botonNuevo", function () {
        $("#formAgregar")[0].reset();
        $("#idbombero").val("");
        $("#idCuartel").val(idCuartel);        
        var reset = $("#formAgregar").validate();
        reset.resetForm();
        $('#formAgregar .form-control').removeClass('error');
    });


    
    // Aquí se agrega un monitor al botón de editar bombero, lo que hace es leer
    //en pantalla el dni de bombero, y envía al endpoint buscar por dni, devuelve 
    //un bombero y este es mostrado en pantalla, parseando los datos json (edituser, hay nombres
    //en ingles y en español, porque primero no estaba definido si el código iba a utilizar
    //todo ingles o español, se utilizó español.. quedó mitad y mitad.)
    $(document).on("click", "a.edituser", function () {
        $("#formAgregar")[0].reset();
        $("#idbombero").val("");
        var reset = $("#formAgregar").validate();
        reset.resetForm();
        $('#formAgregar .form-control').removeClass('error');
        var pid = $(this).data("id");
        $.ajax({
            url: "/bomberos/mostrarBomberoPorDni/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (bombero) {
                var res = bombero.resultado;
                var mod = bombero.modulo;
                if(res == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{
                    if (bombero) {
                        var fNacA = bombero.fechaNacimiento.split('T');
                        var fNac = fNacA[0].split('-');
                        var fechaNacimiento = fNac[0]+"-"+fNac[1]+"-"+fNac[2];
                        var fAlA = bombero.fechaAlta.split('T');
                        var fAlt = fAlA[0].split('-');
                        var fechaAlta = fAlt[0]+"-"+fAlt[1]+"-"+fAlt[2];
                        $("#nombre1").val(bombero.nombre1);
                        $("#nombre2").val(bombero.nombre2);
                        $("#edad").val(bombero.edad);
                        $("#direccion").val(bombero.direccion);
                        $("#apellido").val(bombero.apellido);
                        $("#telefonoCasa").val(bombero.telefonoCasa);
                        $("#telefonoMovil").val(bombero.telefonoCelular);
                        $("#fechaNacimiento").val(fechaNacimiento);
                        $("#Grado").val(bombero.idGrado);
                        $("#genero").val(bombero.genero);
                        $("#factorSanguineo").val(bombero.factorSanguineo);
                        $("#biografia").val(bombero.biografia);
                        $("#id").val(bombero.idBombero);
                        $("#idCuartel").val(bombero.idCuartel);
                        $("#dni").val(bombero.dni);
                        $("#fechaAlta").val(fechaAlta);
                    }
                }
            },
            error: function (request, error) {
                    errorSistema(request, error,"bombero");
                }
        });
    });
    
    // borrar bombero
    $(document).on("click", "a.borrarbombero", function (e) {
        e.preventDefault();
        var dni = $(this).data("id");


        $.ajax({
            url: "/bomberos/mostrarBomberoPorDni/"+dni+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            beforeSend: function () {
            },
            success: function (bombero) {
                var res = bombero.resultado;
                var mod = bombero.modulo;
                if(res == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{
                    if (bombero) {
                        var nombre2 = bombero.nombre2 ? bombero.nombre2 : "";
                        nombreBombero = bombero.nombre1+" "+nombre2+" "+bombero.apellido;
                        dniBombero = bombero.dni;
                        mensaje = `Esta seguro de querer eliminar a ${nombreBombero}, DNI: ${dniBombero}?`;
                        $("#borrar").html(mensaje);
                        $("#eliminarDialog").off();
                        $(document).on("click", "#eliminarDialog", function () {
                            $.ajax({
                                url: "/bomberos/borrarBomberoPorDni/"+dniBombero+"",
                                type: "DELETE",
                                dataType: "json",
                                headers: { 'SIREBToken': sesion },
                                beforeSend: function () {
                                },
                                success: function (res) {
                                    var resu = res.resultado;
                                    var mod = res.modulo;
                                    if(resu == false && mod == "ServicioSesion"){
                                        cerrarSesion();
                                    }else{
                                        if (res) {
                                            $("#borrar").html("");
                                            $("#borrarModal").modal("hide");
                                            $(".mensajeRespuesta").html("El bombero se elimino correctamente!").fadeIn().delay(500).fadeOut();
                                            leerbomberos();
                                        }
                                    }
                                },
                                error: function (request, error) {
                                    errorSistema(request, error,"bombero");
                                }
                            });
                        });
                    }
                }
            },
            error: function (request, error) {
                                errorSistema(request, error,"bombero");
                            }
        });
    });
    
    // leer perfil
    $(document).on("click", "a.perfil", function () {
        var pid = $(this).data("id");
        $.ajax({
            url: "/bomberos/mostrarBomberoPorDni/"+pid+"",
            type: "GET",
            headers: { 'SIREBToken': sesion },
            success: function (bombero) {
                var resu = bombero.resultado;
                var mod = bombero.modulo;
                if(resu == false && mod == "ServicioSesion"){
                    cerrarSesion();
                }else{
                    if (bombero) {
                        const fotobombero = bombero.foto ? bombero.foto : "sin_foto";
                        telefono = "";
                        if(bombero.telefonoCasa !== null){
                            telefono += '<br /><i class="fa fa-phone" aria-hidden="true"></i> ' +bombero.telefonoCasa;
                        }
                        if(bombero.telefonoCelular !== null){
                            telefono += '<br /><i class="fa fa-phone" aria-hidden="true"></i> ' +bombero.telefonoCelular;
                        }
                                var nombre2 = bombero.nombre2 ? bombero.nombre2 : "";

                    const perfil = `<div class="row">
                <div class="col-sm-4 col-md-3">
                  <h4 class="text-primary">${bombero.nombre1} ${nombre2} ${bombero.apellido}</h4>
                  <p class="text-secondary">
                    <i class="fa fa-fire" aria-hidden="true"></i> ${elegirGrado(bombero.idGrado)}
                     ${telefono}
                  </p>
                </div>
                <div class="col-sm-4 col-md-3">
                    <h4 class="text-primary">&nbsp;</h4>
                  <p class="text-secondary">
                    <i class="fa fa-home" aria-hidden="true"></i> ${bombero.direccion}
                  </p>
                </div>
              </div>`;
                    $("#perfil").html(perfil);
                }
            }
            },
            error: function (request, error) {
                                errorSistema(request, error,"bombero");
                            }
        });
    });
    
    // buscador
    $("#inputBuscar").on("keyup", function () {
        const buscarText = $(this).val();
        if (buscarText.length > 1) {
            $.ajax({
                url: "/bomberos/buscar/"+buscarText+"",
                type: "GET",
                headers: { 'SIREBToken': sesion },
                success: function (bomberos) {
                    var res = bomberos.resultado;
                    var mod = bomberos.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (bomberos) {
                            var listabomberos = "";
                            $.each(bomberos, function (index, bombero) {
                                listabomberos += leerbomberorow(bombero);
                            });
                            $("#tablabomberos tbody").html(listabomberos);
                            $("#paginador").hide();
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"bombero");
                }
            });
        } else {
            leerbomberos();
            $("#paginador").show();
        }
    });
    //Aquí se lee el path donde está el navegador, para definri en qué sección
    //se encuentra del Sistema, si está en la sección de administración de bomberos
    //se cargan el menuprincipal, pie de página, tema y se llama a funciones de
    //leer variables de la página, utilizadas por el administrador de bomberos, además
    //por último se llama a la lista de bomberos. Si se está en la sección principal,
    //solo se carga la información básica, menuprincipal, pie y tema. 
    function cargarSeccion(seccion){
        $( ".jqx-menu-wrapper" ).remove();
        $( ".jqx-rc-all" ).remove();
	switch (seccion) {
	    case "bomberos":
    		$("#contenedorGeneral").load("bomberos.html"); 
    		$(document).ajaxStop(function(){
                    cargarMenu();
                    if(!$('#Grado').has('option').length > 0 ) {
                        $("#Grado").html(listagrados);
                    }
                    leerbomberos();
                    cargarValidador(seccion);
        	    $(this).unbind("ajaxStop");
		});	    
	    break;
	    case "cuartel":
    		$("#contenedorGeneral").load("cuartel.html"); 
    		$(document).ajaxStop(function(){
                    cargarMenu();
                    seccionCuartel();
        	    $(this).unbind("ajaxStop");
    		});
	    break;
	    case "principal":
                 $("#capaSuperpuesta").fadeIn();
		seccionPrincipal();
                 $("#capaSuperpuesta").fadeOut();
	    break;
	    case "moviles":
    		$("#contenedorGeneral").load("moviles.html"); 
    		$(document).ajaxStop(function(){
                    cargarMenu();
                    seccionMoviles();
        	    $(this).unbind("ajaxStop");
    		});
	    break;
            default:
                 $("#capaSuperpuesta").fadeIn();
		seccionPrincipal();
                 $("#capaSuperpuesta").fadeOut();                
	}
    }
    
function cargarMenu(){
    $("#botPrincipal").off();
    $("#botLogo").off();
    $("#botBomberos").off();
    $("#botBomberosSub").off();
    $("#botCuartel").off();
    $("#botMoviles").off();
    $("#botPrincipal").click(function(){cargarSeccion("principal"); ocultarMenu(this);});
    $("#botLogo").click(function(){cargarSeccion("principal"); ocultarMenu(this);});
    $("#botBomberos").click(function(){cargarSeccion("bomberos"); ocultarMenu(this);});
    $("#botBomberosSub").click(function(){cargarSeccion("bomberos"); ocultarMenu(this);});
    $("#botCuartel").click(function(){cargarSeccion("cuartel"); ocultarMenu(this);});
    $("#botMoviles").click(function(){cargarSeccion("moviles"); ocultarMenu(this);});
}

function ocultarMenu(esto){
    var menu = $(esto).closest(".dropdown-menu");
    $(menu).css('display','none');
    setTimeout(function(){
        $(menu).css('display','');
    },200);
}


    var path = location.hash.substring(1);

    if(path === "bomberos"){
	cargarSeccion("bomberos");
    }

    if(path === "cuartel"){
	cargarSeccion("cuartel");
    }

    if(path === "moviles"){
	cargarSeccion("moviles");
    }

    if(path === "principal"){
	cargarSeccion("principal");
    }
    
    if(path === "" || path === null){
	cargarSeccion("principal");
    }
    
function seccionCuartel(){
    $('#formCuartel').off('submit');
    $("#secBarriosZonas").off();
    $("#secBarriosZonas").click(function(){leerbarrioszonas();});
    $("#secGrados").off();
    $("#secGrados").click(function(){leergrados();});
    $("#botonNuevoGrado").off();
    $("#botonNuevoGrado").click(function(){
    $("#formEditarGrado")[0].reset();
        $("#idGrado").val("");
        var reset = $("#formEditarGrado").validate();
        reset.resetForm();
    });
    $("#botonNuevoBarrioZona").off();    
    $("#botonNuevoBarrioZona").click(function(){
    $("#formEditarBarrioZona")[0].reset();
        $("#idBarrioZona").val("");
        var reset = $("#formEditarBarrioZona").validate();
        reset.resetForm();
    });
    cargarValidador("cuartel");

    $.ajax({
        url: "/bomberos/mostrarBomberos",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
        },
        success: function (rows) {
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    var listaOpciones = "";
                    $.each(rows, function (index, bombero) {
                        listaOpciones += "<option value="+bombero.idGrado+">"+bombero.nombre1+" "+bombero.nombre2+" "+bombero.apellido+"</option>";
                    });
                    $("#jefeCuartel").html(listaOpciones);
                    parsearObjetoCuartel();
                }
            }
        },
        error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
    });
    
    function parsearObjetoCuartel(){
                if (objetoCuartel) {
                    confAlturaMain();
                    $.each(objetoCuartel, function (index, confg) {
                        if(index === "Cuartel"){
                            logo = confg[0].logo;
                            direccionCuartel = confg[0].direccion;
                            jefeCuartel = confg[0].jefeCuartel;
                            cuartelNumero = confg[0].cuartelNumero;
                            regionalNumero = confg[0].regionalNumero;
                            elegirJefeCuartel(jefeCuartel);
                            $("#logo").attr("src", ""+logo+"");
                            $("#direccion").val(direccionCuartel);
                            $("#regionalNumero").val(regionalNumero);
                            $("#cuartelNumero").val(cuartelNumero);
                        }else if (index === "Grados"){
                            listagrados = "";
                            $.each(confg, function (index, grado) {
                                listagrados += leerGrado(grado);
                            });
                        }
                    });
                    $("#Grado").html(listagrados);
                }
        function elegirJefeCuartel(idJefeCuartel) {
            return $('#jefeCuartel').val(idJefeCuartel);
        }
    }

    $("#formCuartel").submit(function (event) { 
        event.preventDefault();
        var direccionCuartel = $("#direccion").val();
        var regionalNumero = parseInt($("#regionalNumero").val());
        var cuartelNumero =  parseInt($("#cuartelNumero").val());
        var direccion =  $("#direccion").val();
        var jefeCuartel = parseInt($("#jefeCuartel").find(":selected").val());
        var logo =  $("#logo").attr('src');
        var idCuartelL = parseInt(idCuartel);
        var data = {
            idCuartel : idCuartelL,
            regionalNumero : regionalNumero,
            cuartelNumero : cuartelNumero,
            direccion : direccionCuartel,
            jefeCuartel : jefeCuartel,
            logo : logo
        };
        var mensajeAlerta = "";
            var formData = JSON.stringify(data);
            $.ajax({
                url: "/cuartel/actualizar/"+idCuartel+"",
                type: "PUT",
                dataType: "json",
                data: formData,
                contentType: 'application/json',
                headers: { 'SIREBToken': sesion },
                beforeSend: function () {
                    $("#formCuartel :input").prop("disabled", true);
                    $("#formCuartel :button").prop("disabled", true);
                    $("#CargandoCambios").show();

                },
                success: function (respuesta) {
                    var res = respuesta.resultado;
                    var mod = respuesta.modulo;
                    if(res == false && mod == "ServicioSesion"){
                        cerrarSesion();
                    }else{
                        if (respuesta) {
                            $("#CargandoCambios").hide();
                            mensajeAlerta = "Se actualizo correctamente el cuartel.";
                            objetoCuartel.Cuartel[0].regionalNumero = regionalNumero;
                            objetoCuartel.Cuartel[0].cuartelNumero = cuartelNumero;
                            objetoCuartel.Cuartel[0].direccion = direccion;
                            objetoCuartel.Cuartel[0].jefeCuartel = jefeCuartel;
                            objetoCuartel.Cuartel[0].logo = logo;
                            $('#logoCuartel').attr("src",logo);
                            $("#titDireccion").html(direccionCuartel);
                            seccionCuartel();
                            $(".mensajeRespuesta").html(mensajeAlerta).fadeIn().delay(500).fadeOut();
                            $("#formCuartel :input").prop("disabled", false);
                            $("#formCuartel :button").prop("disabled", false);
                        }
                    }
                },
                error: function (request, error) {
                                errorSistema(request, error,"cuartel");
                }
            });
    });
}

function seccionMoviles(){
        function parsearObjetoCuartel(){
                if (objetoCuartel) {
                    confAlturaMain();
                    $.each(objetoCuartel, function (index, confg) {
                        if(index === "TipoMovil"){
                            listamoviles = "";
                            $.each(confg, function (index, tipomovil) {
                                listamoviles += leerTipoMovil(tipomovil);
                            });
                        }
                    });
                    $("#tipoMovil").html(listamoviles);
                }
    }
    parsearObjetoCuartel();
    leermoviles();



}



function seccionPrincipal(){
    $.ajax({
        url: "/bomberos/mostrarBomberos",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
        },
        success: function (rows) {
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    objetoBomberos = rows;
                }
            }
        },
        error: function (request, error) {
                                errorSistema(request, error,"principal");
                }
    });

    $.ajax({
        url: "/moviles/mostrarMoviles",
        type: "GET",
        headers: { 'SIREBToken': sesion },
        beforeSend: function () {
        },
        success: function (rows) {
            var res = rows.resultado;
            var mod = rows.modulo;
            if(res == false && mod == "ServicioSesion"){
                cerrarSesion();
            }else{
                if (rows) {
                    objetoMoviles = rows;
                }
            }
        },
        error: function (request, error) {
                                errorSistema(request, error,"principal");
                }
    });    
    
    
    //$("#contenedorGeneral").load("principal.html"); 
    $("#contenedorGeneral").load("principal.html", function() {
        $(document).ajaxStop(function(){
            cargarMenu();
        ////en formato json, por si queremos guardar los paneles en la 
        ////db y traerlos con un endpoint

            var columns =
                    [
                        { text: 'Tipo', columngroup: 'Eventos', datafield: 'tipo', width: 100},
                        { text: 'Fecha', columngroup: 'Eventos', datafield: 'fecha', width: 180, cellsformat: 'HH:mm - dd/MM/yyyy'},
                        { text: 'Mensaje', columngroup: 'Eventos', datafield: 'mensaje'}
                    ];
            
            var adapter = new $.jqx.dataAdapter({
                beforeSend: function (peticion, cfg) {
                    peticion.setRequestHeader('SIREBToken', sesion);
                },
                dataType: "json",
		dataFields: [
				{ name: 'tipo', type: 'string' },
				{ name: 'fecha', type: 'date', format: "yyyy-MM-ddTHH:mm:ss-HH:mm" },
				{ name: 'mensaje', type: 'string' }
                            ],
                url: "eventos/listarEventos/Sesion"
            });

            var cellsrenderer = function (row, column, value ) {
                var boton = '<a class="btn icon-btn btn-info" onclick="verIntervencion('+value+',\'activa\'); " href="#" style="padding:1px 5px 2px 0px; margin: 3px 0px 0px 0px;" data-toggle="tooltip" title="Detalle Intervencion"><span class="glyphicon btn-glyphicon glyphicon-check img-circle text-success"></span>Detalle</a><a class="btn icon-btn btn-success" onclick="finIntervencion('+value+');" href="#" style="padding:1px 5px 2px 0px; margin: 3px 0px 0px 0px;" data-toggle="tooltip" title="Finalizar Intervencion"><span class="glyphicon btn-glyphicon glyphicon-check img-circle text-success"></span>Finalizar</a>';
                return boton;
            };
            
            var intervencionesColumns =
                                  [
                                        { text: '<b>Ticket</b>', columngroup: 'Intervenciones', datafield: 'ticket', width: 100},
                                        { text: '<b>Hora Inicio</b>', columngroup: 'Intervenciones', datafield: 'horaInicio', width: 180, cellsformat: 'HH:mm - dd/MM/yyyy'},
                                        { text: '<b>Barrio / Zona</b>', columngroup: 'Intervenciones', datafield: 'idBarrioZona'},            
                                        { text: '<center><b>Accion</b></center>', filtertype: 'input',datafield: 'idIntervencion', cellsrenderer: cellsrenderer, width: 180, filterable: false}
                                    ];
            var intervencionesAdaptador = new $.jqx.dataAdapter({
                beforeSend: function (peticion, cfg) {
                    peticion.setRequestHeader('SIREBToken', sesion);
                },
                dataType: "json",
                dataFields: [
                                { name: 'ticket', type: 'string' },
                                { name: 'horaInicio', type: 'date', format: "yyyy-MM-ddTHH:mm:ss-HH:mm" },
                                { name: 'idBarrioZona', type: 'string' },
                                { name: 'idIntervencion', type: 'integer' }
                            ],
                url: "intervencion/mostrar/0",
                beforeLoadComplete: function (registrosIntervenciones) {
                    var nuevoArreglo = new Array();
                    for (var i = 0; i < registrosIntervenciones.length; i++) {
                        var intervencion = registrosIntervenciones[i];
                        $.each(objetoCuartel.BarrioZonas, function (index, barrioZonas) {
                            if(barrioZonas.idBarrioZona == intervencion.idBarrioZona){
                                intervencion.idBarrioZona = barrioZonas.barrioZona;
                            }
                        });
                        nuevoArreglo.push(intervencion);
                    }
                    return nuevoArreglo;
                }
            });

            var cellsrendererHistorico = function (row, column, value ) {
                var boton = '<a class="btn icon-btn btn-info" onclick="verIntervencion('+value+',\'historico\'); " href="#" style="padding:1px 5px 2px 0px; margin: 3px 0px 0px 0px;" data-toggle="tooltip" title="Detalle Intervencion"><span class="glyphicon btn-glyphicon glyphicon-check img-circle text-success"></span>Detalle</a>';
                return boton;
            };

            var historicoColumns =
                                  [
                                        { text: '<b>Ticket</b>', columngroup: 'Intervenciones', datafield: 'ticket', width: 100},
                                        { text: '<b>Hora Inicio</b>', columngroup: 'Intervenciones', datafield: 'horaInicio', width: 180, cellsformat: 'HH:mm - dd/MM/yyyy'},
                                        { text: '<b>Barrio / Zona</b>', columngroup: 'Intervenciones', datafield: 'idBarrioZona'},            
                                        { text: '<center><b>Accion</b></center>', filtertype: 'input',datafield: 'idIntervencion', cellsrenderer: cellsrendererHistorico, width: 180, filterable: false}
                                    ];
            var historicoAdaptador = new $.jqx.dataAdapter({
                beforeSend: function (peticion, cfg) {
                    peticion.setRequestHeader('SIREBToken', sesion);
                },
                dataType: "json",
                dataFields: [
                                { name: 'ticket', type: 'string' },
                                { name: 'horaInicio', type: 'date', format: "yyyy-MM-ddTHH:mm:ss-HH:mm" },
                                { name: 'idBarrioZona', type: 'string' },
                                { name: 'idIntervencion', type: 'integer' }
                            ],
                url: "intervencion/mostrar",
                beforeLoadComplete: function (registrosIntervenciones) {
                    var nuevoArreglo = new Array();
                    for (var i = 0; i < registrosIntervenciones.length; i++) {
                        var intervencion = registrosIntervenciones[i];
                        $.each(objetoCuartel.BarrioZonas, function (index, barrioZonas) {
                            if(barrioZonas.idBarrioZona == intervencion.idBarrioZona){
                                intervencion.idBarrioZona = barrioZonas.barrioZona;
                            }
                        });
                        nuevoArreglo.push(intervencion);
                    }
                    return nuevoArreglo;
                }
            });



        var layout = [{
                type: 'layoutGroup',
                orientation: 'horizontal',
                items: [{
                    type: 'tabbedGroup',
                    alignment: 'left',
                    width: '16%',
                    unpinnedWidth: '15%',
                    pinnedWidth: '6%',
                    popupContentSize: '185px',
                    allowClose: false,
                    items: [{
                        type: 'layoutPanel',
                        title: '<b>Acciones</b>',
                        contentContainer: 'acciones',
                        allowClose: false
                    }]
                }, {
                    type: 'layoutGroup',
                    orientation: 'vertical',
                    width: '84%',
                    items: [{
                        type: 'documentGroup',
                        height: '60%',
                        minHeight: 200,
                        items: [{
                            type: 'documentPanel',
                            title: '<b>Intervenciones activas</b>',
                            contentContainer: 'intervencionesActivas',
                                                initContent: () => {
                        jqwidgets.createInstance('#listaIntervenciones', 'jqxGrid', { source: intervencionesAdaptador, columns: intervencionesColumns, width: "99%", height: "99%", rowsheight: 40 });
                    }
                        }, {
                            type: 'documentPanel',
                            title: 'Historico',
                            contentContainer: 'historicoListado',
                                            initContent: () => {
                        jqwidgets.createInstance('#listaHistoricoIntervenciones', 'jqxGrid', { source: historicoAdaptador, columns: historicoColumns, width: "99%", height: "99%", rowsheight: 40 });
                    }
                        }]
                    }, {
                        type: 'tabbedGroup',
                        height: '40%',
                        pinnedHeight: 30,
                        allowClose: false,

                        items: [{
                            type: 'layoutPanel',
                            title: 'Bomberos de guardia',
                            contentContainer: 'listaBomberos'
                        },{
                            type: 'layoutPanel',
                            title: 'Eventos de sistema',
                            contentContainer: 'listaEventos',
                                                initContent: () => {
                        jqwidgets.createInstance('#listaEventos', 'jqxGrid', { source: adapter, columns: columns, width: "99%", height: "99%" });
                    }
                        }
                    
                                ]
                    }]
                }]
            }];
            $('#dockingLayout').jqxDockingLayout({ width: "100%", height: 450, layout: layout, contextMenu: true, theme: 'energyblue'});
            $("#cajaHerramientas").jqxDocking({ width: "100%", theme: 'classic' });
            $('#cajaHerramientas').jqxDocking('hideAllCloseButtons');
          
            $("#listaIntervenciones").on("rowdoubleclick", function (value) {
                var idIntervencion = value.args.row.bounddata.idIntervencion;
                verIntervencion(idIntervencion, 'activa');
            });
            

        setInterval(actualizarEventos, 60000);
            $(this).unbind("ajaxStop");
        });
    }
);}
//Se llama a la librería validate, que funciona en conjunto con jquery
//se encarga de validar los datos del formulario (formAgregar) que es el mismo
//que se utiliza para actualizar datos. Dentro de cada campo se especifica los
//requisitos mínimos de cada campo (falta una especificación más precisa.)
function cargarValidador(seccion){
    switch (seccion) {
        case "bomberos":
            valBomberos();
            break;
        case "cuartel":
             valCuartel();
            break;
        case "principal":
            break;
        default:
    }
    
    function valBomberos(){
        $("#formAgregar").validate({
            rules: {
                nombre1: {
                    required: true,
                    lettersonly: true
                },
                nombre2: {
                    required: false,
                    lettersonly: true
                },
                apellido: {
                    required: true,
                    lettersonly: true
                },
                direccion: {
                    required: true
                },
                telefonoCasa: {
                    required: false,
                    number: true,
                    maxlength: 13
                },
                telefonoMovil: {
                    required: true,
                    number: true,
                    maxlength: 13
                },
                dni: {
                    required: true,
                    number: true,
                    maxlength: 13
                },
                edad: {
                    required: true,
                    number: true,
                    maxlength: 3
                },         
                rango: 'required'
            },
            messages: {
                nombre1: 'Se necesita un nombre solo letras.',
                nombre2: 'Se necesita un nombre solo letras.',
                apellido: 'Se necesita un apellido solo letras.',
                direccion: 'Se necesita un nombre solo letras.',        
                telefonoCasa: 'Ingrese un telefono valido solo numeros.',
                telefonoMovil: 'Ingrese un telefono valido solo numeros.',
                dni: 'Ingrese un dni valido solo numeros.',        
                edad: 'Ingrese una edad valida solo numeros.',
                rango: 'Ingrese un rango'
            }
        });
    }


    function valCuartel(){
        $("#formCuartel").validate({
            rules: {
                direccion: {
                    required: true
                },
//                telefono: {
//                    required: false,
//                    number: true,
//                    maxlength: 13
//                },
                regionalNumero: {
                    required: true,
                    number: true,
                    maxlength: 5
                },
                cuartelNumero: {
                    required: true,
                    number: true,
                    maxlength: 5
                },
                jefeCuartel: 'required'
            },
            messages: {
                direccion: 'Se necesita una direccion.',        
//                telefono: 'Ingrese un telefono valido solo numeros.',
                regionalNumero: 'Ingrese un numero regional valido solo numeros.',        
                cuartelNumero: 'Ingrese un cuartel valido solo numeros.',
                jefeCuartel: 'Ingrese un jefe de cuartel'
            }
        });

        $("#formEditarBarrioZona").validate({
            rules: {
                barrioZona: {
                    required: true
                }
            },
            messages: {
                barrioZona: 'Se necesita un barrioZona.'
           }
        });    

        $("#formEditarGrado").validate({
            rules: {
                grado: {
                    required: true,
                    lettersonly: true
                }
            },
            messages: {
                grado: 'Se necesita un Grado solo letras.'
           }
        });    
        
    
    }



}

});
