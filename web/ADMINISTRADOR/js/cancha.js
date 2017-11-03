IMAGEN = {};
IMAGEN.previsualizacion = function () {

    var curFiles = archivo.files;
    if (curFiles.length === 0) {
        previsualizacion.removeChild(previsualizacion.firstElementChild);
    } else {

        for (var i = 0; i < curFiles.length; i++) {
            var image = document.createElement('img');
            image.src = window.URL.createObjectURL(curFiles[i]);
            previsualizacion.appendChild(image);
        }

    }
};

//IMAGEN.imgBig = function(){
//  
//    var clon = imgExpander.cloneNode(true);
//    console.log(clon);
//    var caja = document.createElement("div");
//    caja.setAttribute("class", "imgBig");
//
//    caja.appendChild(clon);
//
//    var cerrar = document.createElement("div");
//    cerrar.textContent = "X";
//    cerrar.setAttribute("class", "boton-cerrar");
//    cerrar.setAttribute("onclick", "eliminarModal()");
//
//    caja.appendChild(cerrar);
//
//
//    var lista = document.createElement('div');
//    lista.setAttribute("class", "modal");
//
//
//    lista.appendChild(caja);
//    document.body.appendChild(lista);
//    
//};


function eliminarModal() {
    var child = document.querySelector(".modal");
    document.body.removeChild(child);
};

//SELECTOR DEL DOM
var archivo = document.querySelector("#archivo");
var previsualizacion = document.querySelector(".previsualizacion");
//var imgExpander = document.querySelector("img");


//ASIGNAR EVENTO
archivo.addEventListener("change", function () {IMAGEN.previsualizacion();}, false);

//imgExpander.addEventListener("click", function(){IMAGEN.imgBig();},false);
document.querySelector("#canchasResultado").addEventListener("click", function(evt){
    if(evt.toElement.tagName === "IMG"){
        
        
          var clon = evt.toElement.cloneNode(true);

    var caja = document.createElement("div");
    caja.setAttribute("class", "imgBig");

    caja.appendChild(clon);

    var cerrar = document.createElement("div");
    cerrar.textContent = "X";
    cerrar.setAttribute("class", "boton-cerrar");
    cerrar.setAttribute("onclick", "eliminarModal()");

    caja.appendChild(cerrar);


    var lista = document.createElement('div');
    lista.setAttribute("class", "modal");


    lista.appendChild(caja);
    document.body.appendChild(lista);
    
      
    }else{
        console.log("esta mal comparado");
    }
    
});


CANCHA = {};
CANCHA.registrar = function () {

    var select = document.querySelector("#tamanio");
    var tamanio = select.options[select.selectedIndex];
    var superficie = document.querySelector("#superficie");
    var archivo = document.querySelector("#archivo");
    var data = new FormData();
    data.append("tamanio", tamanio.value);
    data.append("superficie", superficie.value);
    data.append("idClub", localStorage.getItem("id_club"));
    data.append("imagen", archivo.files[0]);

    var xhr = ajaxFile("POST", "../resivrFoto");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var resp = "ok";
            if (resp === "ok") {


                superficie.value = "";
                select.selectedIndex = 0;
                archivo.value = "";
                previsualizacion.removeChild(previsualizacion.firstElementChild);

                alert("registro exitoso");
              CANCHA.obtenerCanchas();

            } else {
                alert("fallo el registro");
            }
                    }
        ;
    };

    xhr.send(data);
};

CANCHA.obtenerCanchas = function () {
    var xhr = ajaxHeader("GET", "../resivrFoto?id_club=" + localStorage.getItem("id_club"));
    xhr.onreadystatechange = function () {
        if(xhr.status === 200 && xhr.readyState ===4){
            
        console.log(JSON.parse(xhr.responseText));
        var canchas = JSON.parse(xhr.responseText);
        var template = document.querySelector("#canchasTemplate").innerHTML;
        document.querySelector("#canchasResultado").innerHTML = eval(template);
        }
        };
    xhr.send();

};

CANCHA.eliminarCancha = function (id, nombreFoto) {
   var xhr = ajaxHeader("DELETE", "../resivrFoto?id_cancha="+id+"&nombreFoto="+nombreFoto);
   
   xhr.onreadystatechange = function(){
       if(xhr.readyState ===4 && xhr.status ===200){
           console.log(xhr.responseText);
           CANCHA.obtenerCanchas();
       };
   };
   
   xhr.send();

};

//SELECTOR DEL DOM
var btnRegistrar = document.querySelector("#registrarCancha");

//ASIGNAR EVENTO
btnRegistrar.addEventListener("click", function () {CANCHA.registrar();}, false);

window.onload = function(){
    CANCHA.obtenerCanchas();
};