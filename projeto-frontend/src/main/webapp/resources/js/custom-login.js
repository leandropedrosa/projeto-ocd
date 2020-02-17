$(document).ready(function(e) {

    if (navigator.userAgent.indexOf("AppleWebKit/") > -1 && jQuery.browser.smallMobile) {
        var webkitVersion = (navigator.userAgent).split("AppleWebKit/");
        webkitVersion = webkitVersion[1];
        webkitVersion = (webkitVersion.split(" "));
        webkitVersion = webkitVersion[0];
        webkitVersion = parseFloat(webkitVersion);

        if (webkitVersion > 537.00) {
            jQuery("#sidepage").css("top","-webkit-calc(100% - 40px)")
        } else {
            var alturaB = (jQuery("body").height()) - 40;
            jQuery("#sidepage").css("top",alturaB + "px")
        }
    }

    $('form').keypress(function(e) {
        if (e.which == 13) {
            msgPanAguarde();
            valida();
            return false;
        }
    });
    $('input').keypress(function(e) {
        if(jQuery.browser.mobile) {
            $(".abrePan").animate({"background-color":"#28476f"}, 250)
        } else {
            $(".abrePan").removeClass("btn-danger").html(msgLoginJS[0]);
        }
    });
    $(".abrePan").click(function() {
        msgPanAguarde();
        valida();
    });

    jQuery(".rememberMe").on({"touchstart" : function(){
        var check = jQuery(".checkLembrar");
        if(check.attr("selected") == "selected"){
            check.removeAttr("selected");
            jQuery(this).removeClass("ativado");
        } else {
            check.attr("selected", "selected");
            jQuery(this).addClass("ativado");
        }
    }});

    if(jQuery.browser.smallMobile) {
        jQuery('#sidepage .toggleSliderLogin').on({ 'touchstart' : function(){
            jQuery("#sidepage").toggleClass("abreLogin");
        }});
        $("body").swipe( {
            //Generic swipe handler for all directions
            swipeUp:function(event, direction, distance, duration, fingerCount) {
                jQuery("input").blur();
                jQuery("#sidepage").addClass("abreLogin");

            },
            swipeDown:function(event, direction, distance, duration, fingerCount) {
                jQuery("input").blur();
                jQuery("#sidepage").removeClass("abreLogin");
            },
            //Default is 75px, set to 0 for demo so any distance triggers swipe
            threshold:75
        });
        var alturaTela = jQuery(window).height();
        if (alturaTela < 360) {
            jQuery(".fields input").addClass("light");
            jQuery(".rememberMe").addClass("light");
            jQuery("#botaoLoginTab").addClass("light");
        }
        jQuery("body").css("height",alturaTela).css("overflow","hidden");
    }

    if((jQuery(window).width() - 300) < 1620) {
        var volta = ((1620/2)-((jQuery(window).width()-300)/2))*(-1);
        jQuery(".videoWelcome").css("margin-left",volta+"px");
    }

    if((jQuery(window).height()) < 1080) {
        var volta = ((1080/2)-((jQuery(window).height())/2))*(-1);
        jQuery(".videoWelcome").css("margin-top",volta+"px");
    }

    jQuery(".fields input").on("blur", function() {
        //chromeMala();
    });
});

function abrePanModulos(msg) {
    if(jQuery.browser.smallMobile) {
        jQuery("#sidepage").removeClass("abreLogin").animate({top: "100%"}, 600, function(){
            jQuery("#right-panel").animate({top: "40%"}, 500);
        });
        jQuery("#coverAllBlack").stop().css("display", "block").animate({opacity: 0.6}, 500);
        jQuery(".abrePan").animate({"background-color":"#487645"}, 250).html("<i class='fa-icon-ok'></i>");
        jQuery("#sidepage input").attr("disabled",true);
        jQuery("body").swipe("disable");
        return false;
    } else if(jQuery.browser.mobile && ((window.innerHeight > window.innerWidth) && (window.innerWidth < 767))) {
        $("#right-panel").animate({top: 65}, 500);
        $("#coverAllBlack").stop().css("display", "block").animate({opacity: 0.6}, 500);
        $(".abrePan").animate({"background-color":"#487645"}, 250).html("<i class='fa-icon-ok'></i>");
        return false;
    } else  {
        $("#right-panel").animate({right: 300}, 500);
        $("#coverAllBlack").stop().css("display", "block").animate({opacity: 0.6}, 500);
        $(".abrePan").html(msg);
        return false;
    }
}

function msgPanAguarde(){
    if(jQuery.browser.mobile) {
        $(".abrePan").animate({"background-color":"#e9a828"}, 250).html("<i class='fa-icon-refresh fa-icon-spin'></i>");
    } else {
        $(".abrePan").html("<i class='fa-icon-refresh fa-icon-spin'></i> " + msgLoginJS[1]);
    }
}

function valida() {
    var chaveContainer = $(".usrChave");
    var usrContainer = $(".usrName");
    var passContainer = $(".usrPass");

    var chaveTxt = $(".chave");
    var usrTxt = $(".userNameTreino");
    var passTxt = $(".pwdTreino");

    var chave = chaveTxt.val();
    var user = usrTxt.val();
    var senha = passTxt.val();
    if ((chave == "" || user == "" || senha == "") || (chave == undefined || user == undefined || senha == undefined)) {
        if (chave == "" || chave == undefined) {
            chaveContainer.css("border-color","#f55");
            chaveTxt.css("color","#f55");

            chaveTxt.on("focus",function(){
                jQuery(this).removeAttr("style");
                jQuery(this).parent(chaveContainer).removeAttr("style");
            });
        }
        if (user == "" || user == undefined) {
            usrContainer.css("border-color","#f55");
            usrTxt.css("color","#f55");

            usrTxt.on("focus",function(){
                jQuery(this).removeAttr("style");
                jQuery(this).parent(usrContainer).removeAttr("style");
            });
        }
        if (senha == "" || senha == undefined) {
            passContainer.css("border-color","#f55");
            passTxt.css("color","#f55");

            passTxt.on("focus",function(){
                jQuery(this).removeAttr("style");
                jQuery(this).parent(passContainer).removeAttr("style");
            });
        }
        dadosIncorretos(msgLoginJS[2]);
    } else {
        vaiLogar();
    }
}

function dadosIncorretos(msg,err) {
    if(jQuery.browser.mobile) {
        $(".abrePan").animate({"background-color":"#da2d3d"}, 250).html("<i class='fa-icon-remove-sign'></i>");
    } else {
        $(".abrePan").addClass("btn-danger").html("<i class='fa-icon-remove-sign'></i> " + msg);
    }

    if (err == "errUsrPass") {
        var usrContainer = $(".usrName");
        var passContainer = $(".usrPass");

        var usrTxt = $(".userNameTreino");
        var passTxt = $(".pwdTreino");

        usrContainer.css("border-color","#f55");
        usrTxt.css("color","#f55");

        usrTxt.on("focus",function(){
            jQuery(this).removeAttr("style");
            jQuery(this).parent(usrContainer).removeAttr("style");
        });

        passContainer.css("border-color","#f55");
        passTxt.css("color","#f55");

        passTxt.on("focus",function(){
            jQuery(this).removeAttr("style");
            jQuery(this).parent(passContainer).removeAttr("style");
        });
    } else if (err == "errChave") {
        var chaveContainer = $(".usrChave");
        var chaveTxt = $(".chave");

        chaveContainer.css("border-color","#f55");
        chaveTxt.css("color","#f55");

        chaveTxt.on("focus",function(){
            jQuery(this).removeAttr("style");
            jQuery(this).parent(chaveContainer).removeAttr("style");
        });
    }
}

function redireciona(url) {    
    var newUrl = window.location.protocol + "//" + window.location.host + rootPath + "/" + url;
    document.location.href = newUrl;
}
// OUTRAS FUNCS
/**
  * jQuery.browser.mobile (http://detectmobilebrowser.com/)
  * jQuery.browser.mobile will be true if the browser is a mobile device
  **/
(function(a){jQuery.browser.mobile=/android|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(ad|hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|symbian|tablet|treo|up\.(browser|link)|vodafone|wap|webos|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|e\-|e\/|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(di|rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|xda(\-|2|g)|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))})(navigator.userAgent||navigator.vendor||window.opera);
/**
  * jQuery.browser.mobile (http://detectmobilebrowser.com/)
  * jQuery.browser.mobile will be true if the browser is a mobile device
  **/
(function(a){jQuery.browser.smallMobile=/android.+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|e\-|e\/|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(di|rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|xda(\-|2|g)|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))})(navigator.userAgent||navigator.vendor||window.opera);