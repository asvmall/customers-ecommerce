import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const CartPage = () => {
  const userId = 1; // static for now

  const [cartItems, setCartItems] = useState([]);

  const fetchCart = () => {
    axios
      .get(`http://localhost:8080/cart/${userId}`)
      .then((res) => setCartItems(res.data))
      .catch((err) => console.error("Error fetching cart:", err));
  };

  useEffect(() => {
    fetchCart();
  }, []);

  const updateQuantity = (item, newQty) => {
    if (newQty < 1) return;
    axios
      .post(
        `http://localhost:8080/cart/${userId}/${item.product.product_id}/${newQty}`
      )
      .then(() => fetchCart())
      .catch((err) => console.error("Error updating quantity:", err));
  };

  const handleRemove = (cartId) => {
    axios
      .delete(`http://localhost:8080/cart/${cartId}`)
      .then(() => {
        setCartItems((prev) => prev.filter((item) => item.cart_id !== cartId));
      })
      .catch((err) => console.error("Error removing item:", err));
  };

  // Pricing using discounted price
  const totalPrice = cartItems.reduce(
    (total, item) => total + item.product.offerPrice * item.quantity,
    0
  );

  if (cartItems.length === 0)
    return (
      <div style={{ textAlign: "center", padding: "50px" }}>
        <h2>Your Cart is Empty</h2>
        <Link to="/">
          <button
            style={{
              padding: "10px 15px",
              background: "#2196f3",
              color: "#fff",
              border: "none",
              borderRadius: "6px",
              cursor: "pointer",
            }}
          >
            Go Shopping
          </button>
        </Link>
      </div>
    );

  return (
    <div style={{ padding: "20px", maxWidth: "900px", margin: "auto" }}>
      <h2 style={{ marginBottom: "20px" }}>🛒 Your Cart</h2>

      {cartItems.map((item) => (
        <div
          key={item.cart_id}
          style={{
            display: "flex",
            alignItems: "center",
            padding: "15px",
            border: "1px solid #ddd",
            borderRadius: "12px",
            marginBottom: "20px",
            gap: "20px",
          }}
        >
          <img
            src={item.product.image_url}
            alt={item.product.name}
            style={{
              width: "90px",
              height: "90px",
              borderRadius: "10px",
              objectFit: "cover",
              border: "1px solid #ccc",
            }}
          />

          <div style={{ flexGrow: 1 }}>
            <h3>{item.product.name}</h3>

            {/* Discount UI */}
            <p style={{ margin: "3px 0" }}>
              <span style={{ textDecoration: "line-through", color: "gray" }}>
                ₹{item.product.price}
              </span>
            </p>

            <p style={{ margin: "3px 0", fontWeight: "bold", color: "green" }}>
              ₹{item.product.offerPrice}
            </p>

            <p style={{ margin: "3px 0", color: "crimson", fontSize: "13px" }}>
              {item.product.offerPercentage}% OFF
            </p>

            {/* Quantity Controls */}
            <div style={{ display: "flex", alignItems: "center" }}>
              <button
                style={{
                  padding: "4px 10px",
                  marginRight: "5px",
                  cursor: "pointer",
                }}
                onClick={() => updateQuantity(item, item.quantity - 1)}
              >
                -
              </button>

              <span style={{ padding: "0 10px" }}>{item.quantity}</span>

              <button
                style={{
                  padding: "4px 10px",
                  marginLeft: "5px",
                  cursor: "pointer",
                }}
                onClick={() => updateQuantity(item, item.quantity + 1)}
              >
                +
              </button>
            </div>
          </div>

          <button
            style={{
              background: "red",
              color: "#fff",
              border: "none",
              padding: "8px 15px",
              borderRadius: "6px",
              cursor: "pointer",
            }}
            onClick={() => handleRemove(item.cart_id)}
          >
            Remove
          </button>
        </div>
      ))}

      {/* Total Price */}
      <h3 style={{ marginTop: "20px" }}>
        Total: <span style={{ color: "green" }}>₹{totalPrice}</span>
      </h3>
    </div>
  );
};

export default CartPage;
