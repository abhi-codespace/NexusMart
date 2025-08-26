import { useState } from 'react'
import './App.css'
import Header from './Components/Header/Header'
import Footer from './Components/Footer/footer'
import HomePage from './Components/Body/HomePage'
// import AppRoutes from './Components/AppRoutes/AppRoutes'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <Header/>
      {/* All routes come here*/}
      {/* <AppRoutes/> */}
      <HomePage />
      <Footer/>
    </div>
  )
}

export default App
