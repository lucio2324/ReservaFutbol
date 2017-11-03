CLUB = {};

CLUB.modificar = function () {
    data = {};
    data.id_club = window.localStorage.getItem("id_club");
    data.nombre_Club = document.querySelector("#nombre").value;
    data.direccion_Club = document.querySelector("#direccion").value;
    data.mail_Club = document.querySelector("#sitioWeb").value;

    var json = JSON.stringify(data);

    var xhr = ajaxHeader("PUT", "../Manejador");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            var inputs = document.querySelectorAll("#perfilClub form input[type=text]");
            for (i = 0; i < inputs.length; i++) {
                inputs[i].setAttribute("disabled", "disabled");
            }
            btnModificar.setAttribute("disabled", "disabled");
            alert("Cambio guardados!!!");
        }
    };
    xhr.send(json);

};

CLUB.verPerfil = function () {

    var xhr = ajaxHeader("GET", "../Manejador?id_club=" + window.localStorage.getItem("id_club"));
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {

            resp = JSON.parse(xhr.responseText);
            var nombre = resp.nombre_Club;
            var direccion_Club = resp.direccion_Club;
            var mail_Club = resp.mail_Club;
            document.querySelector("#nombre").value = nombre;
            document.querySelector("#direccion").value = direccion_Club;
            document.querySelector("#sitioWeb").value = mail_Club;
        }
    };
    xhr.send();
};


frontCancha = {};

frontCancha.habilitarInput = function () {
    var inputs = document.querySelectorAll("#perfilClub form input");
    for (i = 0; i < inputs.length; i++) {
        inputs[i].removeAttribute("disabled");
    }
    btnModificar.removeAttribute("disabled");

};

//SELECTOR DEL DOM
var btnEditar = document.querySelector("#editar");
var btnModificar = document.querySelector("#modificar");


//EVENTOS ASIGNADOS
btnEditar.addEventListener("click", function () {
    frontCancha.habilitarInput();
}, false);
btnModificar.addEventListener("click", function () {
    CLUB.modificar();
}, false);

document.body.onload = function () {
    CLUB.verPerfil();

};


