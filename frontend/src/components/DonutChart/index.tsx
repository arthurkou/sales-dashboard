import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

type ChartData = {
    labels: string[],
    series: number[]
}

const DonutChart = () => {

    /* hook = useState - Manter estado no componente */
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    /* hook = useEffect - Executar algo na instanciação ou destruição do componente, observar estado */
    useEffect(() => {

        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then( resp => {
                const data : SaleSum[] = resp.data;
                const myLabels = data.map(x => x.sellerName);
                const muSeries = data.map(x => x.sum);
    
                setChartData({ labels: myLabels, series: muSeries });
            });
    }, []);

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={ chartData.series }
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;