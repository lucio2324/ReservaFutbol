USUARIO = {};

USUARIO.registrar = function(){
 data = {};
 data.nombre_usuario = document.querySelector("#nombre").value;
 data.email_usuario = document.querySelector("#pass").value;
 data.clave_usuario = document.querySelector("#claveRegistro").value;
 var rol = document.querySelector("#rol");
 data.rol_usuario = rol.options[rol.selectedIndex].value;
 var json = JSON.stringify(data);
 
// METODO AJAX
 var xhr = ajaxHeader("POST","Manejador");
 xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.responseText);
           
            if(xhr.responseText == "Ok"){
               
             document.querySelector("#nombre").value = " ";
             document.querySelector("#pass").value = " ";
             document.querySelector("#claveRegistro").value = "";
             document.querySelector("#rol").selected;
           
         }else{
           alert("Este usuario ya existe");
            }
        }
 };
 xhr.send(json);
};

USUARIO.ingresar = function(){
    data = {};
    data.nombre_usuario = document.querySelector("#email").value;
    data.clave_usuario = document.querySelector("#claveIngreso").value;
    var json = JSON.stringify(data);
    
//    METODO AJAX
    var xhr = ajaxHeader("POST", "Manejador");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.responseText);
            document.location.href = "ADMINISTRADOR/inicioClub.html";
                
        }
    };
    xhr.send(json);
};

//SELECTOR DEL DOM
var registrar = document.querySelector("#registrar");
var ingresar = document.querySelector("#ingresar");

//EVENTOS ASIGNADOS
registrar.addEventListener("click", function(){USUARIO.registrar();}, false );
ingresar.addEventListener("click", function(){USUARIO.ingresar();}, false);