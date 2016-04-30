function showContentCount(url)
{
            var date = document.getElementById("dp2").value;
/*  var content_type = document.getElementById('content_type').value;
    document.getElementById("wait").innerHTML = "Please Wait....";*/
    var xmlhttp;

    if (window.XMLHttpRequest)
    {
        xmlhttp = new XMLHttpRequest();
    }
    else
    {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            document.getElementById("wait").innerHTML = xmlhttp.responseText;
        }
    }
    /*xmlhttp.open("GET", "allCatAjax?cat=" + cat_type + "&content_type=" + content_type, true);*/
   // xmlhttp.open("GET", url+"/" + date, true);
    xmlhttp.open("GET",  url+"/"+date, true);
    xmlhttp.send();
}
