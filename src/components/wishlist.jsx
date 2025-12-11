import React, { useEffect, useState } from "react";
import axios from "axios";

const Wishlist = () => {
  const [wishlist, setWishlist] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/wish/all")
      .then((res) => setWishlist(res.data))
      .catch((err) => console.error("Error loading wishlist:", err));
  }, []);

  return (
    <div style={{ padding: "40px" }}>
      <h1 style={{ textAlign: "center", color: "green", fontSize: "40px" }}>
        Wishlist
      </h1>

      {/* Header Row */}
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "3fr 1fr 1fr 1fr 1fr",
          fontSize: "24px",
          fontWeight: "600",
          margin: "40px 0 20px 0",
          color: "black",
        }}
      >
        <div style={{ textAlign: "left" }}>Product</div>
        <div style={{ textAlign: "center" }}>Price</div>
        <div style={{ textAlign: "center" }}>Date Added</div>
        <div style={{ textAlign: "center" }}>Stock Status</div>
        <div style={{ textAlign: "center" }}>Action</div>
      </div>

      {/* Items */}
      {wishlist.length === 0 ? (
        <h3 style={{ textAlign: "center" }}>No items in wishlist</h3>
      ) : (
        wishlist.map((item) => {
          const product = item.productEntity;

          return (
            <div
              key={item.wishlist_id}
              style={{
                border: "3px solid green",
                borderRadius: "20px",
                padding: "20px",
                marginBottom: "20px",
                display: "grid",
                gridTemplateColumns: "3fr 1fr 1fr 1fr 1fr",
                alignItems: "center",
              }}
            >
              {/* Product Block */}
              <div
                style={{
                  display: "flex",
                  alignItems: "center",
                  gap: "20px",
                }}
              >
                <img
                  src={product.image}
                  alt={product.name}
                  style={{
                    width: "150px",
                    height: "150px",
                    borderRadius: "15px",
                    objectFit: "cover",
                  }}
                />

                <div>
                  <h2 style={{ margin: 0 }}>{product.name}</h2>
                  <button
                    style={{
                      background: "#1c8c2f",
                      padding: "10px 25px",
                      borderRadius: "40px",
                      color: "white",
                      marginTop: "10px",
                      fontSize: "18px",
                      border: "none",
                    }}
                  >
                    {product.weight}
                  </button>
                </div>
              </div>

              {/* Price */}
              <div style={{ textAlign: "center", fontSize: "22px" }}>
                ₹ {product.price}/-
              </div>

              {/* Date */}
              <div style={{ textAlign: "center", fontSize: "22px" }}>
                {item.added_at}
              </div>

              {/* Stock */}
              <div
                style={{
                  textAlign: "center",
                  fontSize: "22px",
                  color: product.stock > 0 ? "green" : "red",
                  fontWeight: "600",
                }}
              >
                {product.stock > 0 ? "In Stock" : "Out of Stock"}
              </div>

              {/* Add to Cart */}
              <div style={{ textAlign: "center" }}>
                <button
                  style={{
                    padding: "14px 30px",
                    background: "green",
                    color: "white",
                    borderRadius: "40px",
                    border: "none",
                    cursor: "pointer",
                    fontSize: "20px",
                  }}
                >
                  Add to Cart
                </button>
              </div>
            </div>
          );
        })
      )}
    </div>
  );
};

export default Wishlist;
