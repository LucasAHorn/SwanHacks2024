import React from "react";
// import Dashboard from "./pages/Dashboard";
import ActivityAddForm from "./components/ActivityAddForm";
import DataViewWeek from "./components/DataViewWeek";
import styles from "./App.module.css";

const App: React.FC = () => {

  async function getData() {
    
  }



    return (<>
      <div className="header">
        <h1>Daily Activity Tracker</h1>
        <h2>Find out how you truly spend your time!</h2>
      </div>
      <div className={styles.side}>
        {/* this will have tabs to determine what will be shown */}
        {/* use z index and alter the width of them individually */}
        
        
        <ActivityAddForm />
        {/* data analysis */}
      </div>
      <div className={styles.side}>
        <DataViewWeek />
      </div>
    </>);
};

export default App;
