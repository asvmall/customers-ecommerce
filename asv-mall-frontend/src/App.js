import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Profile from './components/profile';

function App() {
  const [showComponent,setShowComponent] = useState(false);
  const handleShowComponent = ()=>{
    setShowComponent(true);
  };
  return (
    <div>
      <BrowserRouter>
      <Routes>
        <Route path="/profile" element={<Profile />} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
