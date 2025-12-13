import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import FormLayout from "./FormLayout";
export default function Register() {
  const [mobile, setMobile] = useState("");
  const navigate = useNavigate();
  const handleRegister = async () => {
    if (!mobile.trim()) {
      alert("Enter mobile number");
      return;
    }
    try {
      const response = await axios.post(
        `http://localhost:8080/otp/register?mobile=${mobile}`
      );
      alert(response.data);
      localStorage.setItem("mobile", mobile);
      navigate("/otp-verify");
    } catch (error) {
      console.error(error);
      alert("Failed to send OTP");
    }
  };
  return (
    <FormLayout title="Registration">
      <div style={{ width: "100%", marginTop: "10px" }}>
        <input
          type="text"
          className="input"
          placeholder="Enter mobile number"
          value={mobile}
          onChange={(e) => setMobile(e.target.value)}
        />
        <button className="btn" onClick={handleRegister}>
          Register Now
        </button>
      </div>
    </FormLayout>
  );
}
