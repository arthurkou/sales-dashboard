import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccess } from "types/sale";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[];
}

const BarChart = () => {

    /* hook = useState - Manter estado no componente */
    const [barChartData, setBarChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "% Sucesso",
                data: []
            }
        ]
    });

    /* hook = useEffect - Executar algo na instanciação ou destruição do componente, observar estado */
    useEffect(() => {

        axios.get(`${BASE_URL}/sales/success-sales`)
            .then(resp => {
                const data: SaleSuccess[] = resp.data;
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => round(100.0 * x.deals / x.visited, 1));

                setBarChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Success",
                            data: mySeries
                        }
                    ]
                });
            });
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: barChartData.labels }}
            series={barChartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;