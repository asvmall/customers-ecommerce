import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import FormLayout from "./FormLayout";
export default function OtpVerify() {
  const [otp, setOtp] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const mobile = localStorage.getItem("mobile");
  useEffect(() => {
    if (!mobile) navigate("/");
  }, [mobile, navigate]);
  const handleVerify = async () => {
    if (!otp.trim()) {
      alert("Enter OTP");
      return;
    }
    setLoading(true);
    try {
      const response = await axios.post(
        `http://localhost:8080/otp/verify?mobile=${mobile}&otp=${otp}`
      );
      alert(response.data);
      if (response.data.toLowerCase().includes("verified")) {
        navigate("/add-user");
      }
    } catch (error) {
      alert("OTP verification failed");
    } finally {
      setLoading(false);
    }
  };
  return (
    <FormLayout title="OTP Verification">
      <div style={{ width: "100%", marginTop: "10px" }}>
        <input
          type="text"
          className="input"
          placeholder="Enter OTP"
          value={otp}
          onChange={(e) => setOtp(e.target.value)}
        />
        <button className="btn" onClick={handleVerify} disabled={loading}>
          {loading ? "Verifying..." : "Verify OTP"}
        </button>
      </div>
    </FormLayout>
  );
}
