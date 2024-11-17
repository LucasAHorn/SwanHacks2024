import React, { useState } from "react";
import styles from "./ActivityAddForm.module.css";
import Event from "../Event"

interface ActivityFormProps {
    addEvent: (event: Event) => void;
    currentMonday: Date;
}

const ActivityForm: React.FC<ActivityFormProps> = ({ addEvent }) => {
    const [title, setTitle] = useState("");
    const [startDate, setStartDate] = useState("");
    const [numWeeks, setNumWeeks] = useState(0); // Added end date
    const [startTime, setStartTime] = useState("");
    const [endTime, setEndTime] = useState("");
    const [selectedColor, setSelectedColor] = useState("");
    const [selectedDays, setSelectedDays] = useState<string[]>([]);
    const [index, setIndex] = useState(0);

    const colors = [
        "#FF5733", "#33FF57", "#3357FF", "#FF33A1", 
        "#FF8C33", "#33FFF8", "#8D33FF", "#FFE733", 
        "#B833FF", "#33FFBE"
    ];

    const daysOfWeek = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

    const handleDayToggle = (day: string) => {
        setSelectedDays((prev) =>
            prev.includes(day) ? prev.filter((d) => d !== day) : [...prev, day]
        );
    };

    const givenDayisSelectedDay = (date: Date) => {
        for (let index = 0; index < selectedDays.length; index++) {
            if (daysOfWeek[date.getDay()] == selectedDays[index]) {
                return true;
            }
        }
        return false;
    }

    const createID = () => {
        return Math.floor(Math.random() * (4_000_000_000)) - 2_000_000_000;
    }

    const addEventToApp = async (Day: Date, StartTime: string, EndTime: string, ID_Number: number) => {
        const activity = { 
            "Activity": title, 
            "Date": Day.getFullYear() + "-" + Day.getMonth() + "-" + Day.getDate(), 
            "StartTime": StartTime, 
            "EndTime": EndTime, 
            "Color": selectedColor,
            "ID_Number": ID_Number,
        }

        try {
            const response = await fetch('http://localhost:8080/api/addEvent', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(activity), // Convert activity object to JSON
            });
    
            if (!response.ok) {
                throw new Error('Failed to send activity to the backend');
            } else {
                // TODO: create a new event and add it to the array
                
            }

        } catch (error) {
            console.error("Error posting activity:", error);
        }
    }

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        
        
        if (selectedDays.length < 1) {
            alert("Select the Days of the week please");
            return;
        }
        if (numWeeks > 10 && !confirm("Add event for more than 10 weeks?")) {
            return;
        }
        if (selectedColor.length < 5) {
            setSelectedColor(colors[index]);
            setIndex((index + 1) % colors.length);
        }
        
        var day = new Date(startDate);

        for (let index = 0; index < numWeeks * 7; index++) {
            
            if (givenDayisSelectedDay(day)) {   
                if (startTime < endTime) {  // 1 object
                    addEventToApp(day, startTime, endTime, createID()); // TODO implement getting a random int
                    day.setDate(day.getDate() + 1);
                } else {                    // 2 objects
                    var ID_Number = createID();
                    addEventToApp(day, startTime, "23:59", ID_Number);
                    day.setDate(day.getDate() + 1);
                    addEventToApp(day, "00:00", endTime, ID_Number);
                }
            } else {
                day.setDate(day.getDate() + 1);
            }
        }

        // Reset form
        setTitle("");
        setStartDate("");
        setNumWeeks(0);
        setStartTime("");
        setEndTime("");
        setSelectedColor("");
        setSelectedDays([]);
    };

    const handleCancel = () => {
        // Reset form
        setTitle("");
        setStartDate("");
        setNumWeeks(0);
        setStartTime("");
        setEndTime("");
        setSelectedColor("");
        setSelectedDays([]);
    };

    return (
        <form className={styles.form} onSubmit={handleSubmit}>
            <div>
                <label className={styles.label} htmlFor="title">Activity Title</label>
                <input
                    type="text"
                    id="title"
                    className={styles.input}
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    required
                />
            </div>

            <div>
                <label className={styles.label} htmlFor="startDate">Start Date</label>
                <input
                    type="date"
                    id="startDate"
                    className={styles.input}
                    value={startDate}
                    onChange={(e) => setStartDate(e.target.value)}
                    required
                />
            </div>

            <div>
                <label className={styles.label} htmlFor="numWeeks">Number of Weeks</label>
                <input
                    type="number"
                    id="numWeeks"
                    className={styles.input}
                    value={numWeeks}
                    onChange={(e) => setNumWeeks(Number(e.target.value))}
                    required
                />
            </div>

            <div>
                <label className={styles.label} htmlFor="startTime">Start Time</label>
                <input
                    type="time"
                    id="startTime"
                    className={styles.input}
                    value={startTime}
                    onChange={(e) => setStartTime(e.target.value)}
                    required
                />
            </div>

            <div>
                <label className={styles.label} htmlFor="endTime">End Time</label>
                <input
                    type="time"
                    id="endTime"
                    className={styles.input}
                    value={endTime}
                    onChange={(e) => setEndTime(e.target.value)}
                    required
                />
            </div>

            <div>
                <label className={styles.label}>Select Color</label>
                <div className={styles.colorPicker}>
                    {colors.map((color) => (
                        <div
                            key={color}
                            className={`${styles.colorOption} ${
                                selectedColor === color ? styles.selected : ""
                            }`}
                            style={{ backgroundColor: color }}
                            onClick={() => setSelectedColor(color)}
                        ></div>
                    ))}
                </div>
            </div>

            <div>
                <label className={styles.label}>Days of the Week</label>
                <div className={styles.checkboxGroup}>
                    {daysOfWeek.map((day) => (
                        <label key={day} className={styles.checkboxLabel}>
                            <input
                                type="checkbox"
                                checked={selectedDays.includes(day)}
                                onChange={() => handleDayToggle(day)}
                            />
                            {day}
                        </label>
                    ))}
                </div>
            </div>

            <div className={styles.buttonGroup}>
                <button type="submit" className={`${styles.button} ${styles.add}`}>
                    Add
                </button>
                <button type="button" className={`${styles.button} ${styles.cancel}`} onClick={handleCancel}>
                    Cancel
                </button>
            </div>
        </form>
    );
};

export default ActivityForm;
