import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
export default function Categories() {
  const [categories, setCategories] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    axios
      .get("http://localhost:8080/products-categories/all")
      .then((res) => setCategories(res.data))
      .catch((err) => console.error("Failed to fetch categories:", err));
  }, []);
  const handleCategoryClick = (id) => {
    navigate(`/products/${id}`);
  };
  return (
    <div style={{ padding: "20px", maxWidth: "600px", margin: "auto" }}>
      <h2>All Categories</h2>
      {categories.length === 0 ? (
        <p>No categories found.</p>
      ) : (
        categories.map((cat) => (
          <div
            key={cat.category_id}
            onClick={() => handleCategoryClick(cat.category_id)}
            style={{
              cursor: "pointer",
              padding: "12px",
              margin: "8px 0",
              border: "1px solid #ccc",
              borderRadius: "8px",
              backgroundColor: "#f9f9f9",
              transition: "background-color 0.2s",
            }}
            onMouseEnter={(e) => (e.currentTarget.style.backgroundColor = "#e0f7fa")}
            onMouseLeave={(e) => (e.currentTarget.style.backgroundColor = "#f9f9f9")}
          >
            {cat.name}
          </div>
        ))
      )}
    </div>
  );
}
