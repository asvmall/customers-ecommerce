import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import FormLayout from "./FormLayout";
export default function AddUser() {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const navigate = useNavigate();
  const handleSave = async () => {
    const mobile = localStorage.getItem("mobile");
    if (!mobile) {
      alert("Mobile not found");
      return;
    }
    if (!name.trim() || !address.trim()) {
      alert("Enter all details");
      return;
    }
    try {
      const response = await axios.post(
        `http://localhost:8080/otp/addUser?mobile=${mobile}&name=${name}&address=${address}`
      );
      alert(response.data);
      localStorage.removeItem("mobile");
      navigate("/categories");
    } catch (error) {
      alert("Failed to save user");
    }
  };
  return (
    <FormLayout title="Add User Details">
      <div style={{ width: "100%", marginTop: "10px" }}>
        <input
          type="text"
          className="input"
          placeholder="Enter Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          className="input"
          placeholder="Enter Address"
          value={address}
          onChange={(e) => setAddress(e.target.value)}
        />
        <button className="btn" onClick={handleSave}>
          Save User
        </button>
      </div>
    </FormLayout>
  );
}
