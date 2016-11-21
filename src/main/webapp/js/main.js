require.config({
    paths: {
        "jquery" : "../bower_components/jquery/dist/jquery.min",
        "d3" : "../bower_components/d3/d3.min"
    }
});

require(['jquery'], function ($) {
   $("#dataInputButton").click(function () {
       $.getJSON()
   })
});