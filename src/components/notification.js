import React, { useEffect, useState } from "react";
import axios from "axios";

const NotificationList = () => {
  const [list, setList] = useState([]);
  const [loading, setLoading] = useState(true);
  const userId = localStorage.getItem("user_id");

  // ⭐ Image formatter function
  const getImageSrc = (img) => {
    if (!img) return "/default.png";

    // Full URL
    if (img.startsWith("http://") || img.startsWith("https://")) {
      return img;
    }

    // Base64
    if (img.length > 50 && !img.includes(".")) {
      return `data:image/jpeg;base64,${img}`;
    }

    // Backend folder path
    return `http://localhost:8080/${img}`;
  };

  useEffect(() => {
    if (!userId) {
      console.error("No user_id found");
      setLoading(false);
      return;
    }
    axios
      .get("http://localhost:8080/gets/all")
      .then((res) => {
        let data = res.data;
        let userNotifications = data.filter(
          (n) => n.userEntity?.user_id == userId
        );
        setList(userNotifications);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, [userId]);

  if (loading) return <h2>Loading...</h2>;
  if (list.length === 0) return <h2>No notifications found</h2>;

  return (
    <div style={{ padding: "40px" }}>
      <h1 style={{ color: "green" }}>Notifications</h1>
      {list.map((item) => (
        <div
          key={item.notification_id}
          style={{
            display: "flex",
            alignItems: "center",
            border: "2px solid green",
            borderRadius: "20px",
            padding: "20px",
            marginBottom: "20px",
          }}
        >
          {/* Image */}
          <img
            src={getImageSrc(item.image)}  // ⭐ Updated
            alt="notification"
            style={{
              width: "140px",
              height: "140px",
              borderRadius: "10px",
              objectFit: "cover",
              marginRight: "20px",
            }}
          />

          {/* Text Section */}
          <div style={{ flex: 1 }}>
            <h2>{item.title}</h2>
            <p style={{ fontSize: "18px", color: "#444" }}>{item.message}</p>
            <div
              style={{
                backgroundColor: "#0a8a2a",
                color: "white",
                padding: "8px 20px",
                borderRadius: "30px",
                display: "inline-block",
                marginTop: "10px",
              }}
            >
              {item.is_read === "0" ? "New" : "Read"}
            </div>
          </div>

          {/* Date */}
          <div style={{ width: "150px", textAlign: "center" }}>
            {item.created_at}
          </div>

          {/* Button */}
          <div style={{ textAlign: "center" }}>
            <p style={{ color: "green", fontWeight: "bold" }}>
              {item.is_read === "0" ? "Unread" : "Read"}
            </p>
            <button
              onClick={() =>
                (window.location.href = `/notifications/${item.notification_id}`)
              }
              style={{
                backgroundColor: "green",
                color: "white",
                padding: "10px 20px",
                borderRadius: "25px",
                border: "none",
                cursor: "pointer",
                fontSize: "16px",
              }}
            >
              View
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default NotificationList;
