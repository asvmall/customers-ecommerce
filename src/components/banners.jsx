import React, { useEffect, useState } from "react";
import axios from "axios";
import "./Banner.css";

const Banner = () => {
  const [banner, setBanner] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/banner/getall")
      .then((res) => setBanner(res.data))
      .catch((err) => console.log(err));
  }, []);

 /* return (
    <div>
      {banner.map((value, index) => (
        <div key={index} className="banner-container">
          <div className="banner-left">
            <h1 className="title">
              {value.bannerTitle} <br />
              <span>{value.bannerDescription}</span>
            </h1>

            <button className="shop-btn">Shop Now</button>
          </div>

          <div className="banner-right">
            <img src={value.ImageUrl} className="banner-img" alt="banner" />
          </div>
        </div>
      ))}
    </div>
  )*/

return (
  <div className="auto-slider">
    <div className="auto-track">
      {banner.map((value, index) => (
        <div key={index} className="banner-container">
          <div className="banner-left">
            <h1 className="title">
              {value.bannerTitle} <br />
              <span>{value.bannerDescription}</span>
            </h1>

            <button className="shop-btn">Shop Now</button>
          </div>

          <div className="banner-right">
            <img src={value.ImageUrl} className="banner-img" alt="banner" />
          </div>
        </div>
      ))}
    </div>
  </div>
)
};

export default Banner;
