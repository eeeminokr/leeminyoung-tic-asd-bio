Ext.application({
	name: 'mysss',
	launch: function() {
		var root = am5.Root.new("chartdiv");

		root.setThemes([
			am5themes_Animated.new(root)
		]);

		var chart = root.container.children.push(
			am5xy.XYChart.new(root, {
				panX: false,
				panY: false,
				wheelX: "none",
				wheelY: "none"
				, layout: root.verticalLayout
			})
		);

		var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));
		cursor.lineY.set("visible", false);

		var xRenderer = am5xy.AxisRendererX.new(root, { minGridDistance: 30 });
		xRenderer.labels.template.setAll({ text: "{realName}" });

		var xAxis = chart.xAxes.push(
			am5xy.CategoryAxis.new(root, {
				maxDeviation: 0,
				categoryField: "category",
				renderer: xRenderer,
				tooltip: am5.Tooltip.new(root, {
					labelText: "{realName}"
				})
			})
		);


		var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
			maxDeviation: 0.3,
			maxPrecision: 0,
			renderer: am5xy.AxisRendererY.new(root, {})
		}));


		var barColors = ['#1a98fc', '#fac555', '#fc6d4d', '#3bc0ab'];



		var series = chart.series.push(
			am5xy.ColumnSeries.new(root, {
				name: barColors,
				xAxis: xAxis,
				yAxis: yAxis,
				valueYField: "value",
				sequencedInterpolation: true,
				categoryXField: "category",
				tooltip: am5.Tooltip.new(root, {
					labelText: "{provider} {realName}: {valueY}"
				})
			})
		);

		series.columns.template.setAll({
			fillOpacity: 0.9,
			strokeOpacity: 0,
			templateField: "columnSettings"

		});
		series.bullets.push(function() {
			return am5.Bullet.new(root, {
				locationY: 0.1,
				locationY: 0.5,
				sprite: am5.Label.new(root, {
					centerY: am5.p100,
					centerX: am5.p50,
					text: "{valueY}",
					populateText: true
				})
			});
		});





		var legend = chart.children.push(am5.Legend.new(root, {
			nameField: "name",
			fillField: "color",
			strokeField: "color",
			centerX: am5.percent(60),
			x: am5.percent(60),
			y: am5.percent(98)
			/*	   layout: root.verticalLayout*/
		}));





		legend.data.setAll([{
			name: "비약물군",
			color: am5.color(barColors[0])
		}, {
			name: "약물(단기)",
			color: am5.color(barColors[1])
		}, {
			name: "약물(장기)",
			color: am5.color(barColors[2])
		}, {
			name: "TOTAL",
			color: am5.color(barColors[3])
		}

		]);




		series.columns.template.adapters.add("stroke", (stroke, target) => {
			return chart.get("colors").getIndex(series.columns.indexOf(target));
		});

		var lineSeries = chart.series.push(
			am5xy.LineSeries.new(root, {
				name: "Series 2",
				xAxis: xAxis,
				yAxis: yAxis,
				valueYField: "quantity",
				sequencedInterpolation: true,
				stroke: am5.color('#3bc0ab'),
				fill: am5.color('#3bc0ab'),
				categoryXField: "category",
				tooltip: am5.Tooltip.new(root, {
					labelText: "{valueY}"
				})
			})
		);

		lineSeries.strokes.template.set("strokeWidth", 2);

		lineSeries.bullets.push(function() {
			return am5.Bullet.new(root, {
				locationY: 1,
				locationX: undefined,
				sprite: am5.Circle.new(root, {
					radius: 5,
					fill: lineSeries.get("fill")
				})
			});
		});



		var yyyyArr = [];
		var ptc03Arr = [];
		var ptc01Arr = [];
		var ptc02Arr = [];
		var chartData = [];
		var data = [];
		var yearData = [];
		var barChartListStore = Ext.create('Ext.data.Store', {
			storeId: 'barChartListStore',
			autoLoad: true,
			proxy: {
				type: 'ajax',
				extraParams: {
					classCdDtl: 'DS003'
				},
				url: GLOBAL_CONTEXT_PATH + '/medical/main/selectDashboardBarData.do',
				reader: {
					type: 'json',
					root: 'result'
				}
			},
			listeners: {
				load: function(store) {
					if (store.getTotalCount() === 0) {
						console.error("No data available.");
						return;
					}
					for (var i = 0; i < store.getTotalCount(); i++) {
						var rec = store.getAt(i).data;
						console.log(rec)
						// Extracting and processing data
						if (yyyyArr.indexOf(rec.yyyy) === -1) {
							yyyyArr.push(rec.yyyy);
						}

						if (rec.classCdDtl.indexOf('비약물군') !== -1) {
							ptc03Arr.push(parseInt(rec.pcount));
						} else if (rec.classCdDtl.indexOf('단기') !== -1) {
							ptc01Arr.push(parseInt(rec.pcount));
						} else if (rec.classCdDtl.indexOf('장기') !== -1) {
							ptc02Arr.push(parseInt(rec.pcount));
						}
					}



					for (var i = 0; i < yyyyArr.length; i++) {
						data[yyyyArr[i]] = {
							// category: yyyyArr[i],
							"비약물군": ptc03Arr[i], 
							"단기": ptc01Arr[i],
							"장기": ptc02Arr[i],
							quantity: ptc03Arr[i] + ptc01Arr[i] + ptc02Arr[i],
						};
					}

					console.log(data);

					for (var providerName in data) {
						var providerData = data[providerName];
						console.log(providerData)
						var barColor = ['#1a98fc', '#fac555', '#fc6d4d'];
						var tempArray = [];
						var count = 0;
						var i = 0;
						// add items
						for (var itemName in providerData) {
							console.log(itemName)
							if (itemName != "quantity") {
								count++;
								i += 0;
								console.log(barColor[count])
								tempArray.push({
									category: providerName + "_" + itemName,
									realName: itemName,
									value: providerData[itemName],
									provider: providerName
								});
								console.log(tempArray)
							}
						}
						console.log(tempArray)
						var barColor = ['#1a98fc', '#fac555', '#fc6d4d'];
						for (var i = 0; i < tempArray.length; i++) {
							tempArray[i].columnSettings = {
								fill: am5.color(barColor[i])
							};
						}
	

						var lineSeriesDataIndex = Math.floor(count / 2);
						tempArray[lineSeriesDataIndex].quantity = providerData.quantity;
						tempArray[lineSeriesDataIndex].count = count;

	
						am5.array.each(tempArray, function(item) {
							chartData.push(item);
						});


						var range = xAxis.makeDataItem({});
						xAxis.createAxisRange(range);

						range.set("category", tempArray[0].category);
						range.set("endCategory", tempArray[tempArray.length - 1].category);

						var label = range.get("label");

						label.setAll({
							text: tempArray[0].provider,
							dy: 30,
							fontWeight: "bold",
							tooltipText: tempArray[0].provider
						});

						var tick = range.get("tick");
						tick.setAll({ visible: true, strokeOpacity: 1, length: 50, location: 0 });

						var grid = range.get("grid");
						grid.setAll({ strokeOpacity: 1 });
					}


					var range = xAxis.makeDataItem({});
					xAxis.createAxisRange(range);
					range.set("category", chartData[chartData.length - 1].category);

					var tick = range.get("tick");
					tick.setAll({ visible: true, strokeOpacity: 1, length: 50, location: 1 });

					var grid = range.get("grid");
					grid.setAll({ strokeOpacity: 1, location: 1 });

					xAxis.data.setAll(chartData);
					series.data.setAll(chartData);
					lineSeries.data.setAll(chartData);


					series.appear(1000);
					chart.appear(1000, 100);
				}
			}
		});
	}
});
