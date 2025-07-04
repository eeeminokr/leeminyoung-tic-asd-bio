Ext.application({
  name: 'mysss',
  launch: function () {

/**
 * ---------------------------------------
 * This demo was created using amCharts 5.
 * 
 * For more information visit:
 * https://www.amcharts.com/
 * 
 * Documentation is available at:
 * https://www.amcharts.com/docs/v5/
 * ---------------------------------------
 */

// Create root element
// https://www.amcharts.com/docs/v5/getting-started/#Root_element
var root = am5.Root.new("chartdiv");


// Set themes
// https://www.amcharts.com/docs/v5/concepts/themes/
root.setThemes([
  am5themes_Animated.new(root)
]);


// Generate random data
var value = 100;
		var yyyyArrLine = [];
		var ptc03ArrLine = [];
		var ptc01ArrLine = [];
		var ptc02ArrLine = [];
function generateChartData() {
  var chartData = [];
  var firstDate = new Date();
  firstDate.setDate(firstDate.getDate() - 1000);
  firstDate.setHours(0, 0, 0, 0);

	lineChartListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			extraParams : {
				classCdDtl : 'DS001'
			},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardData.do',
			reader : {
				type : 'json',
				root : 'result',
				totalProperty: 'total'
			}

		},
		listeners : {
			load :  function(store) {
				
			
				if(store.getTotalCount() == 0){
					yyyyArrLine = ['2020'];
					ptc03ArrLine = [0];
					ptc01ArrLine = [0];
					ptc02ArrLine = [0];
					v3 = '50';
					v4 = '10';
				}else{
				
				for( var i=0; i<store.getTotalCount();i++){
					var rec = store.getAt(i);
					console.log(rec)
					yyyyArrLine.push(rec.get("yyyy"));
					ptc03ArrLine.push(parseInt(rec.get("ptc03")));
					ptc01ArrLine.push(parseInt(rec.get("ptc01")));
					ptc02ArrLine.push(parseInt(rec.get("ptc02")));
				}
				
	
				var rec2 = store.getAt(0);
				v3 = rec2.get("yValue3");
				v4 = rec2.get("yValue4");
				
				console.log(ptc01ArrLine)
				}
				
	
			}
		}
	});

	for(var i=0; i< yyyyArrLine.length; i++){
		
			
			value+= ptc03ArrLine[i]
			console.log(value)
		      chartData.push({
		      date: yyyyArrLine[i],
		      value: value
    });
		
		
	}



  for (var i = 0; i < 16; i++) {
    var newDate = new Date(firstDate);
    newDate.setDate(newDate.getDate() + i);

    value += (Math.random() < 0.5 ? 1 : -1) * Math.random() * 10;
	console.log("value"+"["+i+"]:  "+value)
    chartData.push({
      date: newDate.getTime(),
      value: value
    });
  }
  return chartData;
}

var data = generateChartData();


// Create chart
// https://www.amcharts.com/docs/v5/charts/xy-chart/
var chart = root.container.children.push(am5xy.XYChart.new(root, {
  focusable: true,
  panX: true,
  panY: true,
  wheelX: "panX",
  wheelY: "zoomX"
}));

var easing = am5.ease.linear;


// Create axes
// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
  maxDeviation: 0.5,
  extraMin: -0.1,
  extraMax: 0.1,
  groupData: false,
  baseInterval: {
    timeUnit: "day",
    count: 1
  },
  renderer: am5xy.AxisRendererX.new(root, {
    minorGridEnabled: true,
    minGridDistance: 60
  }),
  tooltip: am5.Tooltip.new(root, {})
}));

var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
  renderer: am5xy.AxisRendererY.new(root, {})
}));


// Add series
// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
var series = chart.series.push(am5xy.LineSeries.new(root, {
  minBulletDistance: 10,
  name: "Series 1",
  xAxis: xAxis,
  yAxis: yAxis,
  valueYField: "value",
  valueXField: "date",
  tooltip: am5.Tooltip.new(root, {
    pointerOrientation: "horizontal",
    labelText: "{valueY}"
  })
}));
series.data.setAll(data);

series.bullets.push(function () {
  return am5.Bullet.new(root, {
    locationX: undefined,
    sprite: am5.Circle.new(root, {
      radius: 4,
      fill: series.get("fill")
    })
  })
});


// Add cursor
// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
  xAxis: xAxis
}));
cursor.lineY.set("visible", false);


// Update data every second
setInterval(function () {
  addData();
}, 1000)


function addData() {
  var lastDataItem = series.dataItems[series.dataItems.length - 1];
  var lastValue = lastDataItem.get("valueY");
  var newValue = value + ((Math.random() < 0.5 ? 1 : -1) * Math.random() * 6);
  var lastDate = new Date(lastDataItem.get("valueX"));
  var time = am5.time.add(new Date(lastDate), "day", 1).getTime();
  series.data.removeIndex(0);
  series.data.push({
    date: time,
    value: newValue
  })

  var newDataItem = series.dataItems[series.dataItems.length - 1];
  newDataItem.animate({
    key: "valueYWorking",
    to: newValue,
    from: lastValue,
    duration: 600,
    easing: easing
  });

  var animation = newDataItem.animate({
    key: "locationX",
    to: 0.5,
    from: -0.5,
    duration: 600
  });
  if (animation) {
    var tooltip = xAxis.get("tooltip");
    if (tooltip && !tooltip.isHidden()) {
      animation.events.on("stopped", function () {
        xAxis.updateTooltip();
      })
    }
  }
}


// Make stuff animate on load
// https://www.amcharts.com/docs/v5/concepts/animations/
chart.appear(1000, 100);



  }
});
