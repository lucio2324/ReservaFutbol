CANCHA = {};

CANCHA.insertar = function(){
    data = {};
    data.nombre = document.querySelector("#nombre").value;
    data.dirreccion = document.querySelector("#direccion").value;
    data.sitioWeb =document.querySelector("#sitioWeb").value;
    var json = JSON.stringify(data);
    
    var xhr = ajaxHeader("POST", "../prueba");
    xhr.onreadystatechange  =function(){
        if(xhr.readyState === 4 && xhr.status === 200 ){
            console.log(xhr.responseText);
            var inputs = document.querySelectorAll("#perfilClub form input");
            for(i =0 ; i < inputs.length; i++){
                inputs[i].setAttribute("disabled", "disabled");
            }
        }
    };
    xhr.send(json);
    
};

CANCHA.verPerfil = function(){
    
    var id = "4";
    var xhr = ajaxHeader("GET", "../prueba?id=" + id);
    xhr.onreadystatechange = function(){
        var resp = JSON.parse(xhr.responseText);
                
//        EL PRIMERO COMPLETA CON EL VALUE
        var inputs = document.querySelectorAll("#perfilClub form input");
            for(i =0 ; i < inputs.length; i++){
                inputs[i].value = resp;
            }
//          EL SEGUNDO LOS DESHABILITA PAR ANO SER MODIFICADO  
        var inputs = document.querySelectorAll("#perfilClub form input");
            for(i =0 ; i < inputs.length; i++){
                inputs[i].setAttribute("disabled", "disabled");
            }
        
    };
    xhr.send();
    
    //IMPLEMENTACION TOKEN
//    var JWT = "token";
//    var xhr = ajaxHeaderJWT("GET", "../prueba", JWT);
//    xhr.onreadystatechange  =function(){
//        if(xhr.readyState === 4 && xhr.status === 200 ){
//            console.log(xhr.responseText);
//            
//        }
//    };
//    xhr.send();
    
};

frontCancha = {};

frontCancha.habilitarInput = function(){
    var inputs = document.querySelectorAll("#perfilClub form input");
    for(i =0 ; i < inputs.length; i++){
        inputs[i].removeAttribute("disabled");
    }
    
            document.querySelector("#nombre").value = "larrazabal";

};

//SELECTOR DEL DOM
var btnEditar = document.querySelector("#editar");
var btnModificar = document.querySelector("#modificar");


//EVENTOS ASIGNADOS
btnEditar.addEventListener("click", function(){frontCancha.habilitarInput();}, false);
btnModificar.addEventListener("click", function(){CANCHA.insertar();}, false);