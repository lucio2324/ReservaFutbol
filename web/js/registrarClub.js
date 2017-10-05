/* global fecha, club, hora, id */

CLUB = {};

CLUB.registrar = function(){
    
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "fitraFecha");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200) 
        console.log(xhr.responseText);
    };
    
    
    var datos={
        id_cliente : "1",
        id_club : "1",
        id_cancha : "1" , 
        hora_hora : "10",
        disponible_hora : "0", 
        diaSemana : "Sabado",
        dia_fecha : "7",
        mes_fecha : "11",
        ano_fecha : "2017" 
    };
    
    var json = JSON.stringify(datos);
    
    
xhr.send(json);	
};




/*EVENTOS  DE LOS BOTONES*/
var btnRegistrar = document.querySelector("#btnRegistrar");
btnRegistrar.addEventListener("click", CLUB.registrar);
