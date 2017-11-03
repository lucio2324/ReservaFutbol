CANCHA = {};
CANCHA.obtenerCanchasId = function(){
    var cancha = document.querySelector("#selectCanchas");
    var canchaSeleccionada = cancha.options[cancha.selectedIndex];
    var canchaId = canchaSeleccionada.id;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "../GuardarCancha?id_cancha=" + canchaId );
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.dir(xhr.responseText);
       var json = JSON.parse(xhr.responseText);
       console.dir(json);
       var horas = json.Array_horasDisponibles[0].disponibleAlquiler_cancha;
       var ArrayHora = horas.split(",");
       
       
       for(var i=0; i < ArrayHora.length-1; i++){
           var selector =  ArrayHora[i];
           var celdas = document.getElementById(selector);
           celdas.className = "checked";
           
       }
       
       
        }  
    };
    xhr.send();
};

SERVICIO = {};
SERVICIO.calendarioSemanal = function () {

    var cancha = document.querySelector("#selectCanchas");
    var cancha_id = cancha.options[cancha.selectedIndex].value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "../prueba?id_club=" + localStorage.getItem("id_club"));
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            var l = 0;
            var seleccionaCancha =`<option value="" disabled selected>Seleccione una opcion</option>`;
          
            var json2 = JSON.parse(xhr.responseText);
            
               for(var i in json2.Array_cancha){
                   seleccionaCancha += `<option id="${json2.Array_cancha[i].id_cancha}">${json2.Array_cancha[i].tamanio_cancha}</option>`;
               }
               
            
            var output = `<div class="scrollTable">
                           <table>                                
                                <thead>
                                    <tr>
                                    <th>dia/hora</th>`;

            for (var i in json2.Array_dia) {
                output += `<th>${json2.Array_dia[i].valor_dia}</th>`;
            }

            output += `</tr>
           </thead>
           <tbody id="hora">
           `;

            for (var k  in json2.Array_hora) {


                output += ` <tr><td value="">${json2.Array_hora[k].valor_hora}</td>`;

                for (var j = 0; j <= 6; j++) {

                    output += `<td id="${json2.Array_horarios[l].id}"></td>`;
                    l++;

                }
                output += ` </tr>`;
            }
            ;

            output +=
                    `</tbody>
                            </table>
                        </div>`;

            cancha.innerHTML = seleccionaCancha;
            document.querySelector("#calendario").innerHTML = output;
            var elementos = document.querySelector('table tbody');  
elementos.addEventListener('click', function(){ FUNCIONEScliente.seleccionarCelda(event);}, false);

        }
        ;
    };
    xhr.send();
};

SERVICIO.TraerServicios = function(){
    
};

SERVICIO.agregarServicio = function () {

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "../prueba");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
        }
    };

    var cancha = document.querySelector("#selectCanchas");
    var canchaSeleccionada = cancha.options[cancha.selectedIndex].id;

    var servicio = document.querySelector("#servicios");
    var servicioSeleccionado = servicio.options[servicio.selectedIndex].value;

    datos = {};
    datos.cancha_id = canchaSeleccionada;
    datos.descripcion = servicioSeleccionado;


    var tags_td = document.querySelectorAll("table tbody .checked");
    var horario = [];
    for (i = 0; i < tags_td.length; i++) {
        horario[i] = tags_td[i].id;
    }

    datos.horario_id = horario;

    var json = JSON.stringify(datos);

    xhr.send(json);

};

SERVICIO.eliminarServicio = function(){
    
};

FUNCIONEScliente = {};

FUNCIONEScliente.seleccionarCelda = function (celda) {
    var cancha = document.querySelector("#selectCanchas");
    var canchaSeleccionada = cancha.options[cancha.selectedIndex].value;
    if (canchaSeleccionada === "") {
        alert("Seleccione una cancha");
    } else {
        if (celda.target.className === "checked") {
            celda.target.removeAttribute("class");
        } else if (celda.target.className === "") {
            celda.target.className = "checked";
        } else if (celda.className !== "checked") {
            alert("esta ocupada");
        }
    }
};

FUNCIONEScliente.seleccionarHorario = function () {
    var cancha = document.querySelector("#selectCanchas");
    var canchaSeleccionada = cancha.options[cancha.selectedIndex].value;
    if (canchaSeleccionada === "") {
        alert("Seleccione una cancha");
    } else {
        postTareas.style.display = 'block';
        confirmacion.style.display = 'flex';
        tareas.style.display = "none";
    }
};

FUNCIONEScliente.cancelarSeleccionHorarios = function () {

//            LIMPIAR LAS CELDAS
    var tags_td = document.querySelectorAll(".checked");
    for (i = 0; i < tags_td.length; i++) {
        tags_td[i].className = tags_td[i].className.replace(/\bchecked\b/g, "");
    }
//////////////////////////////////    
    tareas.style.display = "flex";
    postTareas.style.display = "none";
    confirmacion.style.display = "none";
};

//SELECTOR DEL DOM y y EVENTOS AGREGADOS

var tareas = document.querySelector("#tareas");
var postTareas = document.querySelector("#postTareas");
var confirmacion = document.querySelector("#confirmacion");

var seleccionarCancha = document.querySelector("#selectCanchas");
seleccionarCancha.addEventListener("change",CANCHA.obtenerCanchasId,false)
//var traer_servicios = document.querySelector("#canchas");
//traer_servicios.addEventListener("change", SERVICIO.obtenerServicioCanchaId, false);


var agregarServicio = document.querySelector("#agregarServicio");
agregarServicio.addEventListener("click", FUNCIONEScliente.seleccionarHorario, false);


var confirmar =document.querySelector("#confirmar");
confirmar.addEventListener("click", SERVICIO.agregarServicio, false);

var cancelar = document.querySelector("#cancelar");
cancelar.addEventListener("click", FUNCIONEScliente.cancelarSeleccionHorarios, false);
/////////////////

window.onload = function () {
    SERVICIO.calendarioSemanal();
};