import Navbar from "components/Navbar";
import Footer from "components/footer";
import DataTable from "components/DataTable";
import BarChart from "components/BarChart";
import DonutChart from "components/DonutChart";

const Dashboard = () => {
    return (
        <>
            <Navbar />
            <div className="container">
                <h1 className="text-primary py-3">Sales Management</h1>

                <div className="row px-3">
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">All Sales</h5>

                        <BarChart />

                    </div>

                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">All Sales</h5>

                        <DonutChart />

                    </div>
                </div>

                <div className="py-3">
                    <h2 className="text-primary">All Sales</h2>
                </div>

                <DataTable />
            </div>
            <Footer />
        </>
    );
}

export default Dashboard;