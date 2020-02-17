var agora = new Date();
var diferenca = 30 * 60 * 1000;//valor default, será socrescreito por uma chamada de alguma página
//alert(diferenca);
var dataFinal = new Date(agora.getTime() + diferenca);
var urlLogoutRedirect = "";
var compTempo = 'tempoLogout';
var ultimoUcpShake = new Date();

function two(x) {
    return ((x > 9) ? "" : "0") + x
}
function three(x) {
    return ((x > 99) ? "" : "0") + ((x > 9) ? "" : "0") + x
}
function minutes(ms) {
    var sec = Math.floor(ms / 1000);
    var min = Math.floor(sec / 60);
    var hrs = Math.floor(min / 60);
    var days = Math.floor(hrs / 24);
    sec = (sec % 60).toString();
    if (sec.length < 2)
    {
        sec = "0" + sec;
    }
    min = (min % 60).toString();
    if (min.length < 2)
    {
        min = "0" + min;
    }
    hrs = (hrs % 24).toString();
    if (hrs.length < 2)
    {
        hrs = "0" + hrs;
    }
    var counter = (hrs * 60) + min + (sec / 60);



    return counter;
}
function time(ms) {
    var sec = Math.floor(ms / 1000);
    var min = Math.floor(sec / 60);
    var hrs = Math.floor(min / 60);
    var days = Math.floor(hrs / 24);
    sec = (sec % 60).toString();
    if (sec.length < 2)
    {
        sec = "0" + sec;
    }
    min = (min % 60).toString();
    if (min.length < 2)
    {
        min = "0" + min;
    }
    hrs = (hrs % 24).toString();
    if (hrs.length < 2)
    {
        hrs = "0" + hrs;
    }

    days = (days).toString();

    var counter = /*days + ":" +*/ hrs + ":" + min + ":" + sec;

    return counter;
}

function startCountdown() {

    var data = new Date();
    var options = {weekday: "long", year: "numeric", month: "long", day: "numeric"};
    $("#dataHoje").html(data.toLocaleDateString("pt-BR", options));
    $("#horaAgora").html(data.toLocaleTimeString("pt-BR", {hour: '2-digit', minute:'2-digit'}));

    var numberCountdown = document.getElementById(compTempo);
    agora = new Date();
    diferenca = dataFinal.getTime() - agora.getTime();

    //alert(dataFinal + " " + agora);
    var texto = time(diferenca);
    //alert(texto);
    //alert(diferenca);
    if (diferenca > 0) {
        if (document.all) {
            numberCountdown.innerText = texto;
        } else {
            numberCountdown.textContent = texto;
        }
        setTimeout("startCountdown()", 500);
    } else {
        numberCountdown.innerText = "Aguarde, redirecionando...";
        logoutRemote();
    }

    //---------------------- Calcular shake ucp
    diferenca = agora.getTime() - ultimoUcpShake.getTime();
    var ucp = document.getElementById('fmLay:panelGeralUCP');
    if (ucp != null) {
        if (minutes(diferenca) >= 1) {
            ucp.className = ucp.className + ' shakeThat';
        ultimoUcpShake = agora;
        }else if (minutes(diferenca) >= 0.5) {
            ucp.className = ucp.className.replace(' shakeThat', '');
    }
    }
}

function resetTime() {
    var tmp = new Date();
    dataFinal = new Date(tmp.getTime() + (maxInactiveInterval * 1000));    
}
