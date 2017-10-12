ADMINISTRADOR = {};

ADMINISTRADOR.obtenerAdministrador = function(){
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "...servlet...");
    xhr.setRequestHeader("Content-type", "applicationx-www-form-urlencoded");
    xhr.onreadystatechange= function(){
        var respuesta = xhr.responseText();
        if(respuesta === "ok"){
            
        }
    };
    var json = FUNCIONES.recogerDatosJson();
    xhr.send(json);
};

FUNCIONES = {};
FUNCIONES.recogerDatosJson = function(){
//SELECTOR DEL DOM
    var inptEmail = document.querySelector("#email").value;
    var inptClave = document.querySelector("#clave").value;

    objeto = {};
    objeto.email = inptEmail;
    objeto.clave = inptClave;
    var json = JSON.stringify(objeto);
    return json;
};

//ACCIONES DE LA PAGINA
    //SELECTORES DEL DOM
var btnRegistrar = document.querySelector("#registrar");

    //EVENTOS AGREGADOS A LOS SELECTORES
btnRegistrar.addEventListener("click", function(){ADMINISTRADOR.obtenerAdministrador();}, false);


//METODO PARA PROBAR FUNCIONES
ADMINISTRADOR.prueba = function(){
    
    console.log("prueba");
};
