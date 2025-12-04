import React, { useEffect, useState } from "react";
import axios from "axios";
import "./AboutUs.css";

// Local images
import aboutImg from "./about-image.png";
import freeShippingIcon from "./shipping.png";
import paymentIcon from "./payments.png";
import supportIcon from "./support.png";

const AboutUs = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/api/about")
      .then(res => setData(res.data))
      .catch(err => console.log(err));
  }, []);

  if (!data) return <h3>Loading...</h3>;

  return (
    <div className="about-section">

      {/* Section Title */}
      <h3 className="section-title">
        <span>About</span> Us
      </h3>

      <div className="about-container">
        
        {/* LEFT Image */}
        <div className="about-left">
          <img src={data.imageUrl} alt="About" />
        </div>

        {/* RIGHT Details */}
        <div className="about-right">
          <h1>{data.title}</h1>
          <p className="tagline">{data.subtitle}</p>
          <button className="more-info-btn">More Info</button>
        </div>
      </div>

      {/* Description */}
      <p className="about-description">{data.description}</p>

      {/* Feature Cards */}
      <div className="feature-boxes">
        <div className="feature-card">
          <img src={freeShippingIcon} className="icon" alt="shipping" />
          <h3>{data.feature1Title}</h3>
          <p>{data.feature1Desc}</p>
        </div>

        <div className="feature-card">
          <img src={paymentIcon} className="icon" alt="payment" />
          <h3>{data.feature2Title}</h3>
          <p>{data.feature2Desc}</p>
        </div>

        <div className="feature-card">
          <img src={supportIcon} className="icon" alt="support" />
          <h3>{data.feature3Title}</h3>
          <p>{data.feature3Desc}</p>
        </div>
      </div>
    </div>
  );
};

export default AboutUs;
