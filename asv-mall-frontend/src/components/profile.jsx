import React, { useEffect, useState } from "react";
import axios from "axios";
import "./profile.css";

export default function Profile() {
  const [profile, setProfile] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    let mounted = true;
    axios
      .get("http://localhost:8080/profile/1")
      .then((res) => {
        if (!mounted) return;
        setProfile(res.data);
        setLoading(false);
      })
      .catch((err) => {
        if (!mounted) return;
        setError("Could not load profile");
        setLoading(false);
      });
    return () => {
      mounted = false;
    };
  }, []);

  if (loading) {
    return (
      <div className="profile-page">
        <div className="card card-loading">
          <div className="avatar shimmer" />
          <div className="shimmer line short" />
          <div className="shimmer line medium" />
          <div className="shimmer line long" />
        </div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="profile-page">
        <div className="card">
          <p className="error">{error}</p>
        </div>
      </div>
    );
  }

  // Safe defaults in case some fields are missing
  const name = profile?.name || "Unknown";
  const mobile = profile?.mobile || "Not provided";
  const address = profile?.address || "Not provided";
  const avatar =
    profile?.avatar ||
    `https://ui-avatars.com/api/?name=${encodeURIComponent(name)}&background=ddd&color=555&size=128`;

  return (
    <div className="profile-page">
      <div className="card">
        <div className="card-top">
          <img className="avatar" src={avatar} alt={name} />
          <div className="name-block">
            <h2 className="name">{name}</h2>
            <p className="role">{profile?.role || "User"}</p>
          </div>
        </div>

        <div className="info">
          <div className="info-row">
            <span className="label">Mobile</span>
            <span className="value">{mobile}</span>
          </div>

          <div className="info-row">
            <span className="label">Address</span>
            <span className="value">{address}</span>
          </div>
        </div>

        <div className="card-actions">
          <button
            className="btn"
            onClick={() => {
              // simple example — open edit prompt (you'll replace with modal/page)
              const newMobile = prompt("Edit mobile number", mobile);
              if (newMobile !== null) {
                // optional: do API PATCH/PUT here, but for demo we'll local-update
                setProfile((p) => ({ ...p, mobile: newMobile }));
                // Example API call:
                // axios.patch('http://localhost:8080/profile/1', { mobile: newMobile })
                //   .then(...)
              }
            }}
          >
            Edit Profile
          </button>
        </div>
      </div>
    </div>
  );
}
