var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for (var i=0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',

   data: {
    labels: labelData,
    datasets: [{
      backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
      data: numericData
    }]
  },

   options: {
	   plugins: {
		   title: {
            display: true,
            text: 'Project Statuses'
        }
	   }

    }
});


function decodeHtml(htmlElement){
    var txt = document.createElement("textarea");
    txt.innerHTML = htmlElement;
    return txt.value;
}