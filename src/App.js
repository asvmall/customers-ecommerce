import './App.css';

import Wishlist from './components/wishlist';


import Navigations from './pages/navigation';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import WishlistById from './pages/wishlistById';
import WishlistUser from './pages/wishlistById';
import { useEffect } from 'react';
import NotificationList from './components/notification';

function App() {
  useEffect(() => {
localStorage.setItem("user_id", 1);
}, []);
return ( <div className="App"> <BrowserRouter> <Routes>


      <Route path="/" element={<Navigations />} />
      <Route path="/wishlist" element={<Wishlist />} />
      <Route path="/wishlist/:id" element={<WishlistById />} />
<Route path="/user/wishlist" element={<WishlistUser />} />
<Route path="/user/notifications" element={<NotificationList />} />

      
      

    </Routes>
  </BrowserRouter>
</div>


);
}

export default App;
