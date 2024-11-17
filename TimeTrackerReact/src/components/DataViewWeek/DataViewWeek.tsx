import React from "react";
import styles from "./DataViewWeek.module.css";

interface DataViewWeekProps {
    currentMonday: Date;
    EventArray: Event[];
    changeWeek: (num: number) => void;
}

const DataViewWeek: React.FC<DataViewWeekProps> = () => {
    const daysOfWeek = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

    return (<>
        <div className={styles.weekContainer}>
            {daysOfWeek.map((daysOfTheWeek) => (
                <div key={daysOfTheWeek} className={styles.daysOfTheWeek}>
                    {daysOfTheWeek}
                </div>
            ))}
        </div>

        <div className={styles.weekEventContainer}>
            {daysOfWeek.map((daysOfTheWeek) => (
                <div key={daysOfTheWeek} className={styles.dayEventContainer}>
                    Events on {daysOfTheWeek}
                </div>
            ))}
        </div>
    </>);
};

export default DataViewWeek;