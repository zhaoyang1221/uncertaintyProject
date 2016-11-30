require.config({
    paths: {
        "jquery": "../bower_components/jquery/dist/jquery.min",
        "d3": "../bower_components/d3/d3.min",
        "tooltipster" : "../bower_components/tooltipster/dist/js/tooltipster.bundle",
        "handlebars": "../bower_components/handlebars/handlebars"
    }
});

require(['jquery','d3', 'handlebars', 'tooltipster'], function ($, d3, Handlebars) {
    $("#dataInputButton").click(function () {
        $.getJSON("RService/dimensionSummary", function (data) {
            console.log(data);
            var source = $("#dimensionSummaryTemplate").html();
            var template = Handlebars.compile(source);
            var html = template(data);
            $("#dimensionSummaryDisplay").html(html);

            $(".fa-info-circle").tooltipster({
                side : 'right',
                theme : 'tooltipster-shadow',
                functionInit : function (instance, helper) {
                    console.log("hello");
                    var content = instance.content();
                    var dimensionSummary = JSON.parse(content);
                    console.log(dimensionSummary);

                    var source = $("#tooltipsterTemplate").html();
                    var template = Handlebars.compile(source);
                    var html = template(dimensionSummary);
                    instance.content(html);
                },
                contentAsHTML : true
            })
        })
    });

    Handlebars.registerHelper('toJson', function(data) {
        return JSON.stringify(data);
    })



});