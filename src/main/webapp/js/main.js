require.config({
    paths: {
        "jquery" : "../bower_components/jquery/dist/jquery.min",
        "d3" : "../bower_components/d3/d3.min",
        "handlebars" : "../bower_components/handlebars/handlebars"
    }
});

require(['jquery','handlebars'], function ($, Handlebars) {
   $("#dataInputButton").click(function () {
       $.getJSON("RService/dimensionSummary", function (data) {

           console.log(data);
           console.log(data.hasOwnProperty('BLK'));
           var source = $("#dimensionSummaryTemplate").html();
           var template = Handlebars.compile(source);
           var html = template(data);
           $("#dimensionSummaryDisplay").html(html);
       })
   })
});