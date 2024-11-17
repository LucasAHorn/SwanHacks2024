import React, { useEffect, useState } from "react";
import styles from "./DataAnalysisWeek.module.css";

interface DataAnalysisWeekProps {
  currentMonday: Date;
}

const DataAnalysisWeek: React.FC<DataAnalysisWeekProps> = () => {
  // State to store the fetched data, like it will be displayed
  const [CommonData, setCommonData] = useState<String[]>([]);
  const [UncommonData, setUncommonData] = useState<String[]>([]);
  const [HighestEventCounts, setHighestEventCounts] = useState<String[]>([]);


  useEffect(() => {
    // Fetch data from Spring Boot backend
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/analysis"); // Adjust endpoint as needed
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const result = await response.json(); // Assuming the response is JSON
        console.log(result);

        var CommonEventDescriptions: string[] = result.CommonEvents.Descriptions || [];
        var CommonEventHours: string[] = result.CommonEvents.Hours || [];

        var CommonArr: string[] = [];
        for (let index = 0; index < CommonEventDescriptions.length; index++) {
          CommonArr.push(CommonEventDescriptions[index] + " for " + CommonEventHours[index] + " hrs.");
        }
        setCommonData(CommonArr);

        var UncommonEventsDescriptions: string[] = result.UncommonEvents.Descriptions || [];
        var UncommonEventsHours: string[] = result.UncommonEvents.Hours || [];
        
        var UncommonArr: string[] = [];
        for (let index = 0; index < UncommonArr.length; index++) {
          UncommonArr.push(UncommonEventsDescriptions[index] + " for " + UncommonEventsHours[index] + " hrs.");
        }
        setUncommonData(UncommonArr);

        var HighEventCountsDescription = result.HighestCount.Descriptions;
        var HighEventCountNumEvents = result.HighestCount.numEvents;

        var HighEventCounts: string[] = [];
        for (let index = 0; index < HighEventCountsDescription.length; index++) {
          HighEventCounts.push(HighEventCountsDescription[index] + " had " + HighEventCountNumEvents[index] + " occourances.");
        }
        setHighestEventCounts(HighEventCounts);

      } catch (error: any) {
        
      }
    };

    fetchData();
  }, []);

  // Render loading state, error state, or the data
  return (
    <div className={styles.container}>
      <h1>Common Activities</h1>
      <ul>
        {CommonData.map((activity, index) => (
          <li key={index}>{activity}</li>
        ))}
      </ul>

      <h1>Uncommon Activities</h1>
      <ul>
        {UncommonData.map((activity, index) => (
          <li key={index}>{activity}</li>
        ))}
      </ul>

      <h1>High Occourance Activities</h1>
      <ul>
        {HighestEventCounts.map((activity, index) => (
          <li key={index}>{activity}</li>
        ))}
      </ul>
    </div>

  );
};

export default DataAnalysisWeek;
