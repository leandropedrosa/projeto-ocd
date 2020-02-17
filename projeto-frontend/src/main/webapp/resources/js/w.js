var token = "";
url = "https://wiki.pactosolucoes.com.br/content/api.php";
rtype = "jsonp";

 $.ajax({
    type: "POST",
    data: {
        action: "login",
        lgname: "zillyonweb",
        lgpassword: "xq7J4m3n",
        format:"json"
    },
    url: url,
    dataType: rtype,
    timeout: 1000,
    success: function(obj) {
        token = obj.login.token;
        $.ajax({
            type: "POST",
            data: {
                action: "login",
                lgname: "zillyonweb",
                lgpassword: "xq7J4m3n",
                lgtoken: token,
                format:"json"
            },
            url: url,
            dataType: rtype,
            timeout: 1000,
            success: function(obj2) {
//                alert(obj2.login.result);
                setFlagLoginWiki();
            }
        });
    }
});
