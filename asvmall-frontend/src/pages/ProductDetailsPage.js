import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const ProductDetailsPage = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const userId = 1;

  const [product, setProduct] = useState(null);
  const [mainImage, setMainImage] = useState("");
  const [quantity, setQuantity] = useState(1);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/products/${id}`)
      .then((response) => {
        setProduct(response.data);

        if (response.data.images && response.data.images.length > 0) {
          setMainImage(response.data.images[0].imageUrl);
        } else {
          setMainImage(response.data.image_url);
        }
      })
      .catch(() => alert("Failed to load product"));
  }, [id]);

  const handleAddToCart = async () => {
    try {
      await axios.post(
        `http://localhost:8080/cart/${userId}/${product.product_id}/${quantity}`
      );
      alert("Added to cart!");
    } catch (error) {
      alert("Failed to add!");
    }
  };

  const handleBuyNow = async () => {
    try {
      await axios.post(
        `http://localhost:8080/cart/${userId}/${product.product_id}/${quantity}`
      );
      navigate("/cart");
    } catch (error) {
      alert("Error!");
    }
  };

  if (!product) return <h2>Loading...</h2>;

  return (
    <div style={{ padding: "30px", width: "100%", display: "flex", justifyContent: "center" }}>
      <div style={{ display: "flex", gap: "50px", width: "100%", maxWidth: "1200px" }}>

        {/* IMAGE SECTION */}
        <div style={{ flex: "1", position: "relative" }}>

          {/* Main Image with Zoom */}
          <div
            style={{
              width: "100%",
              height: "400px",
              overflow: "hidden",
              borderRadius: "10px",
              border: "1px solid #ccc",
              cursor: "zoom-in",
            }}
          >
            <img
              src={mainImage}
              alt={product.name}
              style={{
                width: "100%",
                height: "100%",
                objectFit: "contain",
                transition: "transform 0.3s ease-in-out",
              }}
              className="zoom-image"
            />
          </div>

          {/* Arrow Controls */}
          {product.images && product.images.length > 1 && (
            <>
              <button
                onClick={() => {
                  const currentIndex = product.images.findIndex(img => img.imageUrl === mainImage);
                  const newIndex = currentIndex > 0 ? currentIndex - 1 : product.images.length - 1;
                  setMainImage(product.images[newIndex].imageUrl);
                }}
                style={{
                  position: "absolute",
                  top: "45%",
                  left: "10px",
                  background: "#ffffffcc",
                  border: "none",
                  fontSize: "24px",
                  cursor: "pointer",
                  padding: "4px 10px",
                  borderRadius: "50%",
                }}
              >
                ‹
              </button>

              <button
                onClick={() => {
                  const currentIndex = product.images.findIndex(img => img.imageUrl === mainImage);
                  const newIndex = currentIndex < product.images.length - 1 ? currentIndex + 1 : 0;
                  setMainImage(product.images[newIndex].imageUrl);
                }}
                style={{
                  position: "absolute",
                  top: "45%",
                  right: "10px",
                  background: "#ffffffcc",
                  border: "none",
                  fontSize: "24px",
                  cursor: "pointer",
                  padding: "4px 10px",
                  borderRadius: "50%",
                }}
              >
                ›
              </button>
            </>
          )}

          {/* Thumbnail Strip */}
          <div
            style={{
              display: "flex",
              gap: "10px",
              marginTop: "10px",
              justifyContent: "center",
            }}
          >
            {(product.images || []).map((img, index) => (
              <img
                key={index}
                src={img.imageUrl}
                alt="thumb"
                onClick={() => setMainImage(img.imageUrl)}
                style={{
                  width: "70px",
                  height: "70px",
                  objectFit: "cover",
                  borderRadius: "6px",
                  cursor: "pointer",
                  border: img.imageUrl === mainImage ? "3px solid green" : "1px solid #ddd",
                }}
              />
            ))}
          </div>
        </div>

        {/* PRODUCT DETAILS SECTION */}
        <div style={{ flex: "1" }}>
          <h2>{product.name}</h2>
          <p><strong>Category:</strong> {product.category}</p>

          <p style={{ fontSize: "20px", marginTop: "10px" }}>
            <span style={{ textDecoration: "line-through", color: "gray" }}>
              ₹{product.price}
            </span> &nbsp;
            <span style={{ color: "green", fontWeight: "bold" }}>
              ₹{product.offerPrice}
            </span>
          </p>

          <p style={{ color: "crimson", fontWeight: "bold" }}>{product.offerPercentage}% OFF</p>
          <p>{product.description}</p>

          {/* Quantity */}
          <div style={{ marginBottom: "15px" }}>
            <button onClick={() => setQuantity(Math.max(1, quantity - 1))}>-</button>
            <span style={{ padding: "0 10px" }}>{quantity}</span>
            <button onClick={() => setQuantity(quantity + 1)}>+</button>
          </div>

          <button
            style={{
              background: "#2e7d32",
              color: "#fff",
              padding: "10px 18px",
              marginRight: "10px",
              cursor: "pointer",
              borderRadius: "5px",
              border: "none",
            }}
            onClick={handleAddToCart}
          >
            Add to Cart
          </button>

          <button
            style={{
              background: "#ff9800",
              color: "#fff",
              padding: "10px 18px",
              cursor: "pointer",
              borderRadius: "5px",
              border: "none",
            }}
            onClick={handleBuyNow}
          >
            Buy Now
          </button>
        </div>
      </div>

      {/* ZOOM STYLE */}
      <style>
        {`
          .zoom-image:hover {
            transform: scale(1.3);
          }
        `}
      </style>
    </div>
  );
};

export default ProductDetailsPage;
