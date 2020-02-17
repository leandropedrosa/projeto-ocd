                                            var chart;
                                            var legend;
                                            var selected;
                                            var types;
                                            function generateChartData(jsonMetaOcupacao) {
                                                types = jsonMetaOcupacao;
                                                var chartData = [];
                                                for (var i = 0; i < types.length; i++) {
                                                    if (i === selected) {
                                                        for (var x = 0; x < types[i].subs.length; x++) {
                                                            chartData.push({
                                                                label: types[i].subs[x].label,
                                                                valor: types[i].subs[x].valor,
                                                                cor: types[i].cor,
                                                                pulled: true
                                                            });
                                                        }
                                                    }
                                                    else {
                                                        chartData.push({
                                                            label: types[i].label,
                                                            valor: types[i].valor,
                                                            cor: types[i].cor,
                                                            id: i
                                                        });
                                                    }
                                                }
                                                return chartData;
                                            }
                                            


