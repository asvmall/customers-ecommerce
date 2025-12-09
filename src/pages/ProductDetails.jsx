// ProductDetails.js
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

export default function ProductDetails() {
    const { id } = useParams();
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/products/products-categories/${id}`)
            .then(res => setProducts(res.data))
            .catch(err => console.log("ERROR:", err));
    }, [id]);

    return (
        <div style={{ padding: "20px" }}>
            <h2>Products in Category ID: {id}</h2>

            {products.length === 0 ? (
                <p>No products found.</p>
            ) : (
                products.map(p => (
                    <div 
                        key={p.product_id}
                        style={{
                            marginBottom: "25px",
                            padding: "15px",
                            border: "1px solid #ddd",
                            borderRadius: "10px",
                            width: "300px"
                        }}
                    >
                        <h3>{p.name}</h3>

                        {/* 🔥 IMAGE DISPLAY */}
                        <img 
                            src={p.image || p.image || p.productImage} 
                            alt={p.name}
                            style={{
                                width: "250px",
                                height: "200px",
                                objectFit: "cover",
                                borderRadius: "10px",
                                marginBottom: "10px"
                            }}
                        />

                        <p>{p.description}</p>
                        <p>Price: ₹{p.price}</p>
                        <p>Stock: {p.stock}</p>
                    </div>
                ))
            )}
        </div>
    );
}
