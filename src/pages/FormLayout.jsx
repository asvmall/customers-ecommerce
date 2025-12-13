import React from "react";
export default function FormLayout({ title, children }) {
  return (
    <div
      style={{
        minHeight: "100vh",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        background: "linear-gradient(135deg, #3b82f6, #2563eb)",
        padding: "20px",
      }}
    >
      <div
        style={{
          display: "flex",
          alignItems: "center",
          gap: "60px",
          flexWrap: "wrap",
          justifyContent: "center",
          maxWidth: "1000px",
        }}
      >
        {/* White Card */}
        <div
          style={{
            background: "#fff",
            padding: "40px",
            width: "380px",
            borderRadius: "14px",
            boxShadow: "0 12px 30px rgba(0,0,0,0.15)",
          }}
        >
          <h2
            style={{
              marginBottom: "25px",
              fontSize: "26px",
              fontWeight: "700",
              color: "#111",
              textAlign: "center",
            }}
          >
            {title}
          </h2>
          <div style={{ width: "100%" }}>{children}</div>
        </div>
        {/* Right Side Text */}
        <h1
          style={{
            fontSize: "48px",
            fontWeight: "800",
            color: "white",
            lineHeight: "1.1",
            maxWidth: "330px",
          }}
        >
          Beautiful  
          <br />
          Sign Up  
          <br />
          Form
        </h1>
      </div>
    </div>
  );
}
