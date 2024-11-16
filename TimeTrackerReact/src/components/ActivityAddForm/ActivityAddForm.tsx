import React, { useState } from "react";
import styles from "./ActivityAddForm.module.css";

const ActivityForm: React.FC = () => {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [startTime, setStartTime] = useState("");
    const [endTime, setEndTime] = useState("");
    const [selectedColor, setSelectedColor] = useState("");
    const [selectedDays, setSelectedDays] = useState<string[]>([]);

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

    // TODO: add the dingle 
    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const activity = { title, description, startTime, endTime, selectedColor, selectedDays };
        console.log("Activity:", activity);
        // Reset form
        setTitle("");
        setDescription("");
        setStartTime("");
        setEndTime("");
        setSelectedColor("");
        setSelectedDays([]);
    };

    const handleCancel = () => {
        // Reset form
        setTitle("");
        setDescription("");
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
                <label className={styles.label} htmlFor="description">Description</label>
                <textarea
                    id="description"
                    className={styles.input}
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    rows={3}
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