import React, { useEffect, useState } from "react";
import axios from "axios";

const WishlistUser = () => {
  const [list, setList] = useState([]);
  const [loading, setLoading] = useState(true);

  const userId = localStorage.getItem("user_id");

  useEffect(() => {
    if (!userId) {
      console.error("No user_id found in localStorage");
      setLoading(false);
      return;
    }

    axios
      .get("http://localhost:8080/wish/all")
      .then((res) => {
        let data = res.data;
        let userItems =
          data.filter((i) => i.user_id == userId) ||
          data.filter((i) => i.userId == userId) ||
          data.filter((i) => i.user?.user_id == userId) ||
          data.filter((i) => i.userEntity?.userId == userId);

        setList(userItems);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, [userId]);

  if (loading) return <h2>Loading...</h2>;
  if (list.length === 0) return <h2>No items found</h2>;

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
        <div>Product</div>
        <div style={{ textAlign: "center" }}>Price</div>
        <div style={{ textAlign: "center" }}>Date Added</div>
        <div style={{ textAlign: "center" }}>Stock Status</div>
        <div style={{ textAlign: "center" }}>Action</div>
      </div>

      {/* Wishlist Items */}
      {list.map((item) => {
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
            {/* Product Section */}
            <div style={{ display: "flex", alignItems: "center", gap: "20px" }}>
              <img
                src={product?.image}
                alt="product"
                style={{
                  width: "150px",
                  height: "150px",
                  borderRadius: "15px",
                  objectFit: "cover",
                }}
              />

              <div>
                <h2>{product?.name}</h2>

                {/* Weight Button */}
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
                  {product?.weight || "1kg"}
                </button>
              </div>
            </div>

            {/* Price Section */}
            <div style={{ textAlign: "center", fontSize: "22px" }}>
              MRP. {product?.price}/-
            </div>

            {/* Date Section */}
            <div style={{ textAlign: "center", fontSize: "22px" }}>
              {item.createdDate || item.added_at}
            </div>

            {/* Stock Section */}
            <div
              style={{
                textAlign: "center",
                fontSize: "22px",
                color: product?.stock > 0 ? "green" : "red",
                fontWeight: "600",
              }}
            >
              {product?.stock > 0 ? "In Stock" : "Out of Stock"}
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
      })}
    </div>
  );
};

export default WishlistUser;
