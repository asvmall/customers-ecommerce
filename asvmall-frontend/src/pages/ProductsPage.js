import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const ProductsPage = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/products")
      .then(res => setProducts(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Products</h2>

      <div
        style={{
          display: "flex",
          flexWrap: "wrap",
          gap: "20px",
          justifyContent: "center",
        }}
      >
        {products.map((product) => (
          <div
            key={product.product_id}
            style={{
              position: "relative",
              border: "1px solid #ccc",
              width: "220px",
              padding: "15px",
              borderRadius: "10px",
              textAlign: "center",
              background: "#fff",
              boxShadow: "0 2px 8px rgba(0,0,0,0.1)",
            }}
          >
            {/* Offer Badge */}
            {product.offerPercentage > 0 && (
              <div
                style={{
                  position: "absolute",
                  top: "10px",
                  right: "10px",
                  background: "crimson",
                  color: "white",
                  padding: "3px 8px",
                  borderRadius: "6px",
                  fontSize: "12px",
                  fontWeight: "bold",
                }}
              >
                {product.offerPercentage}% OFF
              </div>
            )}

            <img
              src={product.image_url}
              alt={product.name}
              style={{
                width: "100%",
                height: "150px",
                objectFit: "cover",
                borderRadius: "8px",
              }}
            />

            <h4 style={{ margin: "12px 0 6px 0" }}>{product.name}</h4>

            {/* Price Section */}
            {product.offerPercentage > 0 ? (
              <>
                <p style={{ margin: 0 }}>
                  <span style={{ textDecoration: "line-through", color: "gray" }}>
                    ₹{product.price}
                  </span>
                </p>
                <p
                  style={{
                    margin: "4px 0 10px 0",
                    fontWeight: "bold",
                    color: "green",
                  }}
                >
                  ₹{product.offerPrice}
                </p>
              </>
            ) : (
              <p
                style={{
                  margin: "4px 0 12px 0",
                  fontWeight: "bold",
                  color: "#333",
                }}
              >
                ₹{product.price}
              </p>
            )}

            <Link to={`/products/${product.product_id}`}>
              <button
                style={{
                  backgroundColor: "#2e7d32",
                  width: "100%",
                  color: "white",
                  padding: "8px",
                  border: "none",
                  borderRadius: "6px",
                  cursor: "pointer",
                }}
              >
                View Details
              </button>
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductsPage;
