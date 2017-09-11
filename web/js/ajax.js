
function guardar(){
var correo = document.querySelector("#mail").value;
var usuario = document.querySelector("#usuario").value;
var clave = document.querySelector("#clave").value;
var selected = document.querySelector("#tipo");
var tipo = selected.options[selected.selectedIndex].text;
   
 // var usu = btoa(usuario);
 // var cla = btoa(clave);
 var data = {
     "usuario":usuario,
     "clave":clave,
     "tipo":tipo,
     "correo":correo
 } ;
 
     $.ajax({
                data:  data,
                url:   'Manejador',
                type:  'post',
                beforeSend: function () {
                        $("#resultado").html("Procesando, espere por favor...");
                },
                success:  function (response) {      
                    $("#resultado").html(response);
                }
        });
}
document.querySelector('#registrar').addEventListener('click', function() {
  lock.show();
});

/*var lock = new Auth0Lock('woW-s7td9inz-ASCva2sQXmvtwp7CELx', 'luciogayoso.auth0.com', {
    auth: {
      redirectUrl: 'https://localhost8080/ResercaFutbol/callbackServlet',
      responseType: 'code',
      params: {
        scope: 'openid email' // Learn about scopes: https://auth0.com/docs/scopes
      }
    }
  });*/
var lock = new Auth0Lock(
  'P2NWWuLnv8GQJC9ZjMXiWTItN6NoCzA8',
  'luciogayoso.auth0.com'
); 
lock.on("authenticated", function(authResult) {
  lock.getUserInfo(authResult.accessToken, function(error, profile) {
    if (error) {
        console.log("Ocurrion un error");
      return;
    }

    document.getElementById('nick').textContent = profile.nickname;

    localStorage.setItem('accessToken', authResult.accessToken);
    localStorage.setItem('profile', JSON.stringify(profile));
  });
});
    
/*function registrarse(){
    
var usuario = document.querySelector("#usuario").value;
var clave = document.querySelector("#clave").value;

//var usu = btoa(usuario);
// var cla = btoa(clave);
 var data = {
     "usuario":usuario,
     "clave":clave
 };
// var data = JSON.stringify(data1);
 
     $.ajax({
                data:  data,
                url:"Manejador",
                type:"get",
                beforeSend: function () {
                        $("#resultado").html("Procesando, espere por favor...");
                },
                success:  function (response) { 
                    $("#resultado").html(response);
                }
        });
}*/


