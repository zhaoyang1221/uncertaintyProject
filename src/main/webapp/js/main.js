require.config({
    paths: {
        "d3": "../bower_components/d3/d3.min",
        "jquery": "../bower_components/jquery/dist/jquery.min",
        "tooltipster": "../bower_components/tooltipster/dist/js/tooltipster.bundle",
        "handlebars": "../bower_components/handlebars/handlebars"
    }
});

require(['d3','jquery','handlebars', 'tooltipster'], function (d3, $, Handlebars) {
    $("#dataInputButton").click(function () {
        $.getJSON("RService/dimensionSummary", function (data) {
            console.log(data);
            var source = $("#dimensionSummaryTemplate").html();
            var template = Handlebars.compile(source);
            var html = template(data);
            $("#dimensionSummaryDisplay").html(html);

            parallelVis();

            $(".fa-info-circle").tooltipster({
                side: 'right',
                theme: 'tooltipster-shadow',
                functionInit: function (instance, helper) {
                    var content = instance.content();
                    var dimensionSummary = JSON.parse(content);
                    // console.log(dimensionSummary);

                    var source = $("#tooltipsterTemplate").html();
                    var template = Handlebars.compile(source);
                    var html = template(dimensionSummary);
                    instance.content(html);
                },
                contentAsHTML: true
            });

        })
    });

    function parallelVis() {
        console.log('hello');

        var traits = ["G","MP","FG","FGA","X3P","X3PA","FT","FTA","ORB","DRB","AST","STL","BLK","TOV","PF","PTS"];
        var w = $("#parallelContainer").width,
            h = $("#parallelContainer").height;
        var y = {};
        var line = d3.svg.line(),
            axis = d3.svg.axis().orient("left");
        var svg = d3.select("#parallelContainer").append("svg:svg")
            .attr("width", w)
            .attr("height", h)
            .append("svg:g")

    }

    Handlebars.registerHelper('toJson', function (data) {
        return JSON.stringify(data);
    })
});