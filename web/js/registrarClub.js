/* global peticion_http */

CLUB = {};

CLUB.registrar = function(){
		var clubDatos = CLUB.datos();
		if ( clubDatos === undefined ) {
		console.log("todo mal");
		}else {
			AJAX("fitraFecha","POST", CLUB.respuesta, clubDatos);
		console.log("Se envio");
    }
	
}

CLUB.respuesta = function() {
  if(peticion_http.readyState === 4 && peticion_http.status === 200) {
  	
  	/*SPAN*/
       var respRegistro = document.querySelector("#respRegistro");   
        /****AQUI VA LA RESPUESTA DEL SERVIDOR*/
  		respRegistro.innerHTML = peticion_http.responseText;
    }
};

CLUB.datos =  function(){
	var club = {}; 
	/*club.nombreClub = inputNombreClub.value;
	club.direccionClub = inputDireccionClub.value;
	club.telefonoClub = inputTelefonoClub.value;
	club.administradorClub = inputAdministradorClub.value; 
	club.claveClub = inputClaveClub.value;*/
    
        club.dia_fecha = "2";
        club.mes_fecha = "11";
        club.ano_fecha = "2017";
	var clubJSON = JSON.stringify(club);
	return clubJSON;
};


/*INPUT*/
var inputNombreClub =document.querySelector("#nombreClub");
var inputDireccionClub = document.querySelector("#direccionClub");
var inputTelefonoClub = document.querySelector("#telefonoClub");
var inputAdministradorClub = document.querySelector("#administradorClub");
var inputClaveClub = document.querySelector("#claveClub");

/*SPAN*/
var respRegistro = document.querySelector("#respRegistro");

/*EVENTOS  DE LOS BOTONES*/
var btnRegistrar = document.querySelector("#btnRegistrar");
btnRegistrar.addEventListener("click", CLUB.registrar);
