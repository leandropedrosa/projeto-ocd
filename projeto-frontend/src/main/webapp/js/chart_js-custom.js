$(function () {

    var lineData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                label: "Example dataset",
                fillColor: "rgba(1,168,254,0.5)",
                strokeColor: "rgba(1,168,254,1)",
                pointColor: "rgba(1,168,254,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(1,168,254,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "Example dataset",
                fillColor: "rgba(103,197,246,0.5)",
                strokeColor: "rgba(103,197,246,0.7)",
                pointColor: "rgba(103,197,246,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(103,197,246,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };

    var lineOptions = {
        scaleShowGridLines: true,
        scaleGridLineColor: "rgba(255,255,255,.05)",
        scaleGridLineWidth: 1,
        bezierCurve: true,
        bezierCurveTension: 0.4,
        pointDot: true,
        pointDotRadius: 4,
        pointDotStrokeWidth: 1,
        pointHitDetectionRadius: 20,
        datasetStroke: true,
        datasetStrokeWidth: 2,
        datasetFill: true,
        responsive: true,
        scaleFontColor:'#949ba2'
    };


    var ctx = document.getElementById("lineChart").getContext("2d");
    var myNewChart = new Chart(ctx).Line(lineData, lineOptions);

    var barData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(1,168,254,0.5)",
                strokeColor: "rgba(1,168,254,0.8)",
                highlightFill: "rgba(1,168,254,0.75)",
                highlightStroke: "rgba(1,168,254,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "My Second dataset",
                fillColor: "rgba(103,197,246,0.5)",
                strokeColor: "rgba(103,197,246,0.8)",
                highlightFill: "rgba(103,197,246,0.75)",
                highlightStroke: "rgba(103,197,246,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };

    var barOptions = {
        scaleBeginAtZero: true,
        scaleShowGridLines: true,
        scaleGridLineColor: "rgba(255,255,255,.05)",
        scaleGridLineWidth: 1,
        barShowStroke: true,
        barStrokeWidth: 2,
        barValueSpacing: 5,
        barDatasetSpacing: 1,
        responsive: true,
        scaleFontColor:'#949ba2'
    };


    var ctx = document.getElementById("barChart").getContext("2d");
    var myNewChart = new Chart(ctx).Bar(barData, barOptions);

    var polarData = [
        {
            value: 300,
            color: "#01a8fe",
            highlight: "#01a8fe",
            label: "App"
        },
        {
            value: 140,
            color: "#9ed7f4",
            highlight: "#01a8fe",
            label: "Software"
        },
        {
            value: 200,
            color: "#66b5dd",
            highlight: "#01a8fe",
            label: "Laptop"
        }
    ];

    var polarOptions = {
        scaleShowLabelBackdrop: true,
        scaleBackdropColor: "rgba(255,255,255,0.75)",
        scaleBeginAtZero: true,
        scaleBackdropPaddingY: 1,
        scaleBackdropPaddingX: 1,
        scaleShowLine: true,
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 2,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true

    };

    var ctx = document.getElementById("polarChart").getContext("2d");
    var myNewChart = new Chart(ctx).PolarArea(polarData, polarOptions);

    var doughnutData = [
        {
            value: 300,
            color: "#01a8fe",
            highlight: "#01a8fe",
            label: "App"
        },
        {
            value: 50,
            color: "#4ebbf4",
            highlight: "#01a8fe",
            label: "Software"
        },
        {
            value: 100,
            color: "#9ed7f4",
            highlight: "#01a8fe",
            label: "Laptop"
        }
    ];

    var doughnutOptions = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 2,
        percentageInnerCutout: 45, // This is 0 for Pie charts
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true
    };


    var ctx = document.getElementById("doughnutChart").getContext("2d");
    var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);


});


