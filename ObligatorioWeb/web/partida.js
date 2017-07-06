var titulo = document.getElementById('titulo');
var tamano = document.getElementById('tamano');
var espera = document.getElementById('espera');
var tablero = document.getElementById('tablero');
var infoTablero = document.getElementById('info-tablero');
var casillerosTablero = document.getElementById('casilleros-tablero');
var btnTamano = document.getElementById('btn-tamano');
var txtTamano = document.getElementById('txt-tamano');



var eventos = new EventSource("partida?accion=new");// (servlet_name?accion=new)

eventos.onerror = function (evt) {
    Materialize.toast("Sin conexion con el servidor", 5000, 'red lighten-2');
    eventos.close();
    document.location = "/partida/";
};

eventos.addEventListener("setTitulo", function (evt) {
    render.titulo(evt.data);
}, false);

eventos.addEventListener("mostrarError", function (evt) {
    Materialize.toast(evt.data, 5000, 'red lighten-2');
    console.error(evt.data);
}, false);

eventos.addEventListener("mostrarEspera", function (evt) {
    render.espera(evt.data);
}, false);

eventos.addEventListener("mostrarTablero", function (evt) {
    render.tablero(JSON.parse(evt.data));
}, false);

btnTamano.addEventListener('click', function () {
    $.post('partida', { tamano: txtTamano.value });
}, false);



var render = {
    titulo: function (texto) {
        document.title = texto;
        titulo.innerHTML = texto;
    },
    espera: function (mensaje) {
        tamano.classList.add('hidden');
        espera.classList.remove('hidden');
        tablero.classList.add('hidden');
        espera.innerHTML = mensaje;
    },
    tablero: function (casilleros) {
        tamano.classList.add('hidden');
        espera.classList.add('hidden');
        tablero.classList.remove('hidden');
        var ladoTablero = parseInt(Math.sqrt(casilleros.length)) * 100;
        casillerosTablero.style.width = ladoTablero + "px";
        casillerosTablero.innerHTML = '';
        casilleros.forEach(function (casillero) {
            var boton = document.createElement('button');
            boton.classList.add('casillero');
            boton.style.background = 'rgb(' + casillero.color + ')';
            boton.innerHTML = casillero.mina ? casillero.mina : '';
            casillerosTablero.appendChild(boton);
        }, this);
    }
}