import React, { useEffect, useState } from "react";
import styles from "./DataAnalysisWeek.module.css";

const DataAnalysisWeek: React.FC = () => {
  // State to store the fetched data
  const [data, setData] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    // Fetch data from Spring Boot backend
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/data"); // Adjust endpoint as needed
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const result = await response.json(); // Assuming the response is JSON
        setData(result.message); // Replace `message` with the actual field you want to display
        setLoading(false);
      } catch (error: any) {
        setError(error.message);
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  // Render loading state, error state, or the data
  return (
    <div className={styles.container}>
      {loading && <p>Loading...</p>}
      {error && <p>Error: {error}</p>}
      {data && <p>{data}</p>} {/* Display the fetched data */}
    </div>
  );
};

export default DataAnalysisWeek;
