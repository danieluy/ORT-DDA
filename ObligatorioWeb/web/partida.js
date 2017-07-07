var estado = {
    tamanoVisible: true,
    esperaVisible: false,
    tableroVisible: false
}

var partida = {
    init: function () {
        this.cacheDOM();
    },
    cacheDOM: function () {
        this.titulo = document.getElementById('titulo');
        this.tamano = document.getElementById('tamano');
        this.espera = document.getElementById('espera');
        this.tablero = document.getElementById('tablero');
        this.infoTablero = document.getElementById('info-tablero');
        this.casillerosTablero = document.getElementById('casilleros-tablero');
        this.btnTamano = document.getElementById('btn-tamano');
        this.txtTamano = document.getElementById('txt-tamano');
        this.tiempo = document.getElementById('tiempo');
        this.saldo = document.getElementById('saldo');
        this.pozo = document.getElementById('pozo');
        this.juega = document.getElementById('juega');
        this.turno = document.getElementById('turno');
        this.total = document.getElementById('total');
        this.txtApuesta = document.getElementById('txt-apuesta');
        this.btnApostar = document.getElementById('btn-apostar');
        this.btnPagar = document.getElementById('btn-pagar');
        this.btnSubir = document.getElementById('btn-subir');
        this.setListeners();
    },
    setListeners: function () {
        this.btnTamano.addEventListener('click', (function () {
            $.post('partida', { tamano: this.txtTamano.value });
        }).bind(this), false);

        this.btnApostar.addEventListener('click', (function () {
            $.post('partida', { apostar: this.txtApuesta.value });
        }).bind(this), false);

        this.btnPagar.addEventListener('click', (function () {
            $.post('partida', { pagar: this.txtApuesta.value });
        }).bind(this), false);

        this.btnSubir.addEventListener('click', (function () {
            $.post('partida', { subir: this.txtApuesta.value });
        }).bind(this), false);
    },
    setCasillerosListeners: function () {
        var casilleros = document.getElementsByClassName('casillero');
        for (var i = 0; i < casilleros.length; i++)
            casilleros[i].addEventListener('click', function (evt) {
                var selectedIndex = evt.target.getAttribute('data-index');
                $.post('partida', { destapar: selectedIndex });
            })
    },
    render: {
        titulo: function (texto) {
            document.title = texto;
            this.titulo.innerHTML = texto;
        },
        espera: function (mensaje) {
            if (!estado.esperaVisible) {
                this.tamano.classList.add('hidden');
                this.espera.classList.remove('hidden');
                this.tablero.classList.add('hidden');
                estado = {
                    tamanoVisible: false,
                    esperaVisible: true,
                    tableroVisible: false
                }
            }
            this.espera.innerHTML = mensaje;
        },
        tablero: function (casilleros) {
            if (!estado.tableroVisible) {
                this.tamano.classList.add('hidden');
                this.espera.classList.add('hidden');
                this.tablero.classList.remove('hidden');
                estado = {
                    tamanoVisible: false,
                    esperaVisible: false,
                    tableroVisible: true
                }
            }
            var ladoTablero = parseInt(Math.sqrt(casilleros.length)) * 100;
            this.casillerosTablero.style.width = ladoTablero + "px";
            this.casillerosTablero.innerHTML = '';
            var i = 0;
            casilleros.forEach(function (casillero) {
                var boton = document.createElement('button');
                boton.classList.add('casillero');
                boton.setAttribute('data-index', i++);
                boton.style.background = 'rgb(' + casillero.color + ')';
                boton.innerHTML = casillero.mina ? casillero.mina : '';
                this.casillerosTablero.appendChild(boton);
            }, this);
            this.setCasillerosListeners();
        },
        datos: function (datos) {
            this.render.titulo(datos.tituloPartida);
            this.juega.innerHTML = datos.turno;
            this.turno.innerHTML = datos.numeroTurno;
            this.tiempo.innerHTML = datos.tiempoTurno;
            this.saldo.innerHTML = datos.saldo;
            this.pozo.innerHTML = datos.pozo;
        },
        error: function (error) {
            Materialize.toast(error, 5000, 'red lighten-2');
        },
        mensaje: function (mensaje) {
            Materialize.toast(mensaje, 5000, 'teal lighten-2');
        }
    }
}
// apuestaActual: "0.0"
// numeroTurno: "1"
// pozo: "20.0"
// saldo: "125.0"
// tiempoTurno: "0"
// tituloPartida: "Tyler Durden vs. Robert Paulson"
// turno: "Juegas tu"
var eventos = {
    init: function () {
        this.eventos = new EventSource("partida?accion=new");// (servlet_name?accion=new)
        this.setListeners();
    },
    setListeners: function () {
        this.eventos.onerror = (function (evt) {
            Materialize.toast("Sin conexion con el servidor", 5000, 'red lighten-2');
            this.eventos.close();
            document.location = "/partida/";
        }).bind(this);

        this.eventos.addEventListener("setTitulo", function (evt) {
            partida.render.titulo.call(partida, evt.data);
        }, false);

        this.eventos.addEventListener("mostrarError", function (evt) {
            partida.render.error.call(partida, evt.data);
            console.error(evt.data);
        }, false);

        this.eventos.addEventListener("mostarMensaje", function (evt) {
            partida.render.mensaje.call(partida, evt.data);
            console.log(evt.data);
        }, false);

        this.eventos.addEventListener("mostrarEspera", function (evt) {
            partida.render.espera.call(partida, evt.data);
        }, false);

        this.eventos.addEventListener("mostrarTablero", function (evt) {
            partida.render.tablero.call(partida, JSON.parse(evt.data));
        }, false);

        this.eventos.addEventListener("mostrarDatos", function (evt) {
            partida.render.datos.call(partida, JSON.parse(evt.data));
        }, false);

        this.eventos.addEventListener("cerrar", function (evt) {
            window.close();
        }, false);
    }
}

partida.init();
eventos.init();

window.addEventListener("beforeunload", function (e) {
    partida.render.error("La partida se cerrará");
    var confirmationMessage = "La partida se cerrará";
    e.returnValue = confirmationMessage;
    return confirmationMessage;
});