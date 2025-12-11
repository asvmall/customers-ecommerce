import React from "react";
import { useNavigate } from "react-router-dom";

function Navigations() {
  const navigate = useNavigate();

  // Common circle button style
  const iconButton = {
    width: "80px",
    height: "80px",
    borderRadius: "50%",
    backgroundColor: "green",
    border: "none",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    cursor: "pointer",
    marginRight: "25px",
  };

  const iconStyle = {
    fontSize: "40px",
    color: "white",
  };

  return (
    <div style={{ padding: "20px", display: "flex", alignItems: "center" }}>
      
      {/* Wishlist (Love / Heart icon) */}
      <button style={iconButton} onClick={() => navigate("/user/wishlist")}>
        <span style={iconStyle}>🤍</span>
      </button>

      {/* Notifications (Bell icon) */}
      <button style={iconButton} onClick={() => navigate("/user/notifications")}>
        <span style={iconStyle}>🔔</span>
      </button>

    </div>
  );
}

export default Navigations;
