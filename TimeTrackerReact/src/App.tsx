import React, { useState } from "react";
import ActivityAddForm from "./components/ActivityAddForm";
import styles from "./App.module.css";
import DataAnalysisWeek from "./components/DataAnalysisWeek";

const App: React.FC = () => {
  // State to track active tab
  const [activeTab, setActiveTab] = useState<"addActivity" | "analysis">("addActivity");

  // Handlers for tab switches
  const handleTabClick = (tab: "addActivity" | "analysis") => {
    setActiveTab(tab);
  };

  return (
    <>
      <div className={styles.title}>
        <h1>Daily Activity Tracker</h1>
        <h2>Find out how you truly spend your time!</h2>
      </div>

      <div className={styles.mainContent}>
        <div className={styles.side}>
          <div className={styles.tabs}>
            {/* Buttons with dynamic classes based on activeTab */}
            <button
              className={activeTab === "addActivity" ? styles.active : styles.inactive}
              onClick={() => handleTabClick("addActivity")}
            >
              Add Activity Form
            </button>
            <button
              className={activeTab === "analysis" ? styles.active : styles.inactive}
              onClick={() => handleTabClick("analysis")}
            >
              Activity Analysis
            </button>
          </div>

          {/* Content toggled based on active tab */}
          {activeTab === "addActivity" && <ActivityAddForm />}
          {activeTab === "analysis" && <p>Analysis Content Placeholder</p>}
        </div>
        <div className={styles.side}>
          <DataAnalysisWeek />
        </div>
      </div>
    </>
  );
};

export default App;
