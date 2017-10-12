function updateImageDisplay() {
    
    var tamaño = document.querySelector("#tamaño").value;
        
    OBJETO = {};
    
    OBJETO.tamaño = tamaño;
    
    console.log(OBJETO);
    var json = JSON.stringify(OBJETO);
    console.log(json);
    
//    var file = document.querySelector("#image_uploads");
//    var archivo = file.files[0];    
//    console.log(archivo);

};

CANCHA = {};
var idCancha = 1;
CANCHA.registrar = function(){
    var idClub =1;
    data = {};
    data.id_club = idClub;
    data.nombre = document.querySelector("#tamaño").value;
    var json = JSON.stringify(data);
    
    var xhr = ajaxHeader("POST", "../GuardarCancha");
    xhr.onreadystatechange = function(){
        console.log(xhr.responseText);
    };
    xhr.send(json);
};

//SELECTOR DEL DOM
var btnRegistrar = document.querySelector("#registrarCancha");

//ASIGNAR EVENTO
btnRegistrar.addEventListener("click", function(){CANCHA.registrar();}, false);

