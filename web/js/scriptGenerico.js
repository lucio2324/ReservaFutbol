/*VALIDAR INPUTS*/

function validarNombre(nombre){
  var regUsuario = /^[a-zA-Z0-9_]{1,16}$/;
    if ( !regUsuario.test(nombre) ){
      return "Posee caracteres invalidos o esta vacio";
    }else{
      return true;
    }
	}

function validarEmail(email){

	var regEmail = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
	if ( regEmail.test(email) ){
		return true;
	}else {
		return "Ingrese un email valido";
	}
}

function validarContrasena(contrasena){
  var regEspacios =  /\s+/;
  if ( contrasena.length < 4 ){
    return "Contraseña mayor a 4 caracteres";
      if( regEspacios.test(contrasena) ){
        return "no se admite espacios en blanco";
      }
  }else {
    if( regEspacios.test(contrasena) ){
      return "no se admite espacios en blanco";
    }else {
      return true;
    }
  }
}


/* Agregar un nuevo evento a cualquier elemento */
function nuevoEvento(elemento, evento, funcion) {
    // para cualquier navegador
    try {
        if (elemento.addEventListener)
            elemento.addEventListener(evento, funcion, false);

        // para IE
        else
            elemento.attachEvent("on" + evento, funcion);
    } catch(e) {
        alert("No se pudo agregar el eventon" + e.name + " - " + e.message);
    }
}

// codigo javascript no intrusivo que asigna al evento onload una funcion
function addLoadEvent(func) {
    var oldonload = window.onload;
    if (typeof window.onload !== 'function')
        window.onload = func;
    else {
        window.onload = function() {
            if (oldonload)
            oldonload();
            func();
        }
    }
}

/*FUNCION GENERICA DE AJAX*/
function AJAX(url, metodo, funcion, json) {
  peticion_http = inicializa_xhr();
 
  if(peticion_http) {
    peticion_http.open(metodo, url);
 	  peticion_http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    peticion_http.onreadystatechange = funcion;
    peticion_http.send( json );
  }
}

function inicializa_xhr() {
  if(window.XMLHttpRequest) {
    return new XMLHttpRequest();
  }
  else if(window.ActiveXObject) {
    return new ActiveXObject("Microsoft.XMLHTTP");
  }
}