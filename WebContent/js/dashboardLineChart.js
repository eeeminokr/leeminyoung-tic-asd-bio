
Ext.application({
	name: 'mysss',
	launch: function() {


		var root2 = am5.Root.new("chartdiv2");


		root2.setThemes([
			am5themes_Animated.new(root2)
		]);


		var chart2 = root2.container.children.push(
			am5xy.XYChart.new(root2, {
				panX: true,
				panY: true,
				wheelX: "panX",
				wheelY: "zoomX",
				layout: root2.verticalLayout,
				pinchZoomX: true
			})
		);


		var cursor2 = chart2.set("cursor", am5xy.XYCursor.new(root2, {
			behavior: "none"
		}));
		cursor2.lineY.set("visible", false);



		var yyyyArrLine = [];
		var ptc03ArrLine = [];
		var ptc01ArrLine = [];
		var ptc02ArrLine = [];

		var v1;
		var v2;
		var v3;
		var v4;

		var data = [];
		//라인그래프
		lineChartListStore = Ext.create('Ext.data.Store', {
			storeId: 'Staging',
			autoLoad: true,
			proxy: {
				type: 'ajax',
				extraParams: {
					classCdDtl: 'DS001'
				},
				url: GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardData.do',
				reader: {
					type: 'json',
					root: 'result',
					totalProperty: 'total'
				}

			},
			listeners: {
				load: function(store) {


					if (store.getTotalCount() == 0) {
						yyyyArrLine = ['2020'];
						ptc03ArrLine = [0];
						ptc01ArrLine = [0];
						ptc02ArrLine = [0];
						v3 = '50';
						v4 = '10';
					} else {

						for (var i = 0; i < store.getTotalCount(); i++) {
							var rec = store.getAt(i);
							console.log(rec)
							yyyyArrLine.push(rec.get("yyyy"));
							ptc03ArrLine.push(parseInt(rec.get("ptc03")));
							ptc01ArrLine.push(parseInt(rec.get("ptc01")));
							ptc02ArrLine.push(parseInt(rec.get("ptc02")));


						}


						for (var i = 0; i < yyyyArrLine.length; i++) {
							data[i] = {
								"year": yyyyArrLine[i],
								"ptc03": ptc03ArrLine[i],
								"ptc01": ptc01ArrLine[i],
								"ptc02": ptc02ArrLine[i]
							};


						}


						var rec2 = store.getAt(0);
						v3 = rec2.get("yValue3");
						v4 = rec2.get("yValue4");

						console.log(data)
					}


					// Create axes

					var xRenderer2 = am5xy.AxisRendererX.new(root2, {
						minorGridEnabled: true
					});
					xRenderer2.grid.template.set("location", 0.5);
					xRenderer2.labels.template.setAll({
						location: 0.5,
						multiLocation: 0.5
					});

					var xAxis2 = chart2.xAxes.push(
						am5xy.CategoryAxis.new(root2, {
							categoryField: "year",
							renderer: xRenderer2,
							tooltip: am5.Tooltip.new(root2, {})
						})
					);

					xAxis2.data.setAll(data);

					var yAxis2 = chart2.yAxes.push(
						am5xy.ValueAxis.new(root2, {
							maxPrecision: 0,

							renderer: am5xy.AxisRendererY.new(root2, {
								// inversed: true
							})
						})
					);



					function createSeries(name, field, color) {
						var series = chart2.series.push(
							am5xy.LineSeries.new(root2, {
								name: name,
								xAxis: xAxis2,
								yAxis: yAxis2,
								valueYField: field,
								fill: color,
								stroke: color,
								categoryXField: "year",
								tooltip: am5.Tooltip.new(root2, {
									pointerOrientation: "horizontal",
									labelText: "[bold]{name}[/]\n{categoryX}: {valueY}"
								})
							})
						);


						series.bullets.push(function() {
							return am5.Bullet.new(root2, {
								sprite: am5.Circle.new(root2, {
									radius: 6,
									fill: series.get("fill")
								})
							});
						});
						series.strokes.template.setAll({
							strokeWidth: 4
						});

						series.set("setStateOnChildren", true);
						series.states.create("hover", {});

						series.mainContainer.set("setStateOnChildren", true);
						series.mainContainer.states.create("hover", {});

						series.strokes.template.states.create("hover", {
							strokeWidth: 6
							, radius: 8
						});

						series.data.setAll(data);
						series.appear(1000);
					}



					var color1 = '#1a98fc';
					var color2 = '#fac555';
					var color3 = '#fc6d4d';

					createSeries("비약물군", "ptc03", color1);
					createSeries("단기약물군치료", "ptc01", color2);
					createSeries("장기약물군치료", "ptc02", color3);

					chart2.set("scrollbarX", am5.Scrollbar.new(root2, {
						orientation: "horizontal",
						marginBottom: 20
					}));

					var legend2 = chart2.children.push(
						am5.Legend.new(root2, {
							centerX: am5.p50,
							x: am5.p50,
							y: am5.percent(98)
						})
					);


					legend2.itemContainers.template.states.create("hover", {});

					legend2.itemContainers.template.events.on("pointerover", function(e) {
						e.target.dataItem.dataContext.hover();
					});
					legend2.itemContainers.template.events.on("pointerout", function(e) {
						e.target.dataItem.dataContext.unhover();
					});

					legend2.data.setAll(chart2.series.values);


					chart2.appear(1000, 100);

				}



			}
		});



	} //launch load End Line

}); // ext.application End Line