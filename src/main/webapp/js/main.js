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

            parallelVis();

        })
    });

    function parallelVis() {
        var traits = ["G","MP","FG","FGA","X3P","X3PA","FT","FTA","ORB","DRB","AST","STL","BLK","TOV","PF","PTS"];
        var margin = {top:30, right: 10, bottom: 10, left:10},
            width = $("#parallelContainer").width() - margin.left - margin.right,
            height = $("#parallelContainer").height() - margin.top - margin.bottom;
        console.log(width);
        console.log(height);

        var x = d3.scaleOrdinal().range([0, width], 1),
            y = {},
            dragging = {};

        var svg = d3.select("#parallelContainer").append("svg")
            .attr("width", width +　margin.left +　margin.right)
            .attr("height", height + margin.top +　margin.bottom)
            .append("g")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    }

    Handlebars.registerHelper('toJson', function (data) {
        return JSON.stringify(data);
    })
});