import { useNavigate } from "react-router-dom";
import FavoriteIcon from "@mui/icons-material/Favorite";

export default function Navbar() {
  const navigate = useNavigate();

  return (
    <div className="navbar">
      {<h2>WhishList</h2>}
      <FavoriteIcon 
        style={{ fontSize: 32, cursor: "pointer", color: "green" }}
        onClick={() => navigate("/wishlist")}
      />
    </div>
  );
}
