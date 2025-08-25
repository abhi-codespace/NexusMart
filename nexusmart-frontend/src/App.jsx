import { useState } from 'react'
import './App.css'
import Header from './Components/Header/Header'
import Footer from './Components/Footer/footer'
import HomePage from './Components/Body/HomePage'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <Header/>
      <HomePage />
      <Footer/>
    </div>
  )
}

export default App
