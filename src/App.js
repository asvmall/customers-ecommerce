import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from "./Pages/Register";
import OtpVerify from "./Pages/OtpVerify";
import AddUser from "./Pages/AddUser";
import Categories from "./Pages/Categories";
import ProductDetails from "./Pages/ProductDetails";
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Register />} />
        <Route path="/otp-verify" element={<OtpVerify />} />
        <Route path="/add-user" element={<AddUser />} />
        <Route path="/categories" element={<Categories />} />
        <Route path="/products/:id" element={<ProductDetails />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
