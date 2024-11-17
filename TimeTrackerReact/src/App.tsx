import React, { useState } from "react";
import styles from "./App.module.css";
import ActivityAddForm from "./components/ActivityAddForm";
import DataAnalysisWeek from "./components/DataAnalysisWeek";
import DataViewWeek from "./components/DataViewWeek";
import Event from "./components/Event"

const App: React.FC = () => {
  // State to track active tab
  const [activeTab, setActiveTab] = useState<"addActivity" | "analysis">("addActivity");
  const [EventArray, setEventArray] = useState<Event[]>([]);

  let today = new Date();
  if (today.getDay() > 0) {
    today.setDate(today.getDate() + 1);
  }

  const [currentMonday, setCurrentMonday] = useState<Date>(today);

  // Handlers for tab switches
  const handleTabClick = (tab: "addActivity" | "analysis") => {
    setActiveTab(tab);
  };

  const addEvent = (event: Event) => {
    setEventArray((prev) => [...prev, event]);
  };

  const changeWeek = (num: number) => {
    today.setDate(today.getDate() + (num * 7));
    setCurrentMonday(today);
  }

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
          {activeTab === "addActivity" && <ActivityAddForm addEvent={addEvent} currentMonday={currentMonday} />}
          {activeTab === "analysis" && <DataAnalysisWeek currentMonday={currentMonday} />}
        </div>
        <div className={styles.side}>
          <DataViewWeek currentMonday={currentMonday} EventArray={EventArray} changeWeek={changeWeek} />
        </div>
      </div>
    </>
  );
};

export default App;
