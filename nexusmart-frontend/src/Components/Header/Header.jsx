import { useState } from "react";
import { Menu, X } from "lucide-react";
// import logo from "../../assets/nexusmart-logo.png";

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <header className="bg-blue-600 text-white shadow-md">
      <div className="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
        {/* Logo */}
        <div className="flex items-center gap-2 cursor-pointer">
         
          {/* <img className="w-12 h-12" src={logo} alt="NexusMart Logo" /> */}
         
          <span className="text-xl font-bold">NexusMart</span>
        </div>

        {/*  Search bar */}
        <div className="flex-1 mx-4">
          <input
            type="search"
            placeholder="Search for products..."
            className="w-full px-3 py-2 rounded-lg text-black bg-white focus:outline-none focus:ring-2 focus:ring-yellow-400"
          />
        </div>

        {/* Desktop Menu */}
        <ul className="hidden md:flex gap-6 font-medium">
          <li className="hover:text-gray-200 cursor-pointer">Home</li>
          <li className="hover:text-gray-200 cursor-pointer">About</li>
          <li className="hover:text-gray-200 cursor-pointer">Services</li>
          <li className="hover:text-gray-200 cursor-pointer">Contact</li>
          <li className="hover:text-gray-200 cursor-pointer">Sign in</li>
        </ul>

        {/* Mobile Hamburger Button */}
        <button
          className="md:hidden p-2 rounded-lg hover:text-gray-300 transition"
          onClick={() => setIsOpen(!isOpen)}
        >
          {isOpen ? <X size={28} /> : <Menu size={28} />}
        </button>
      </div>

      {/* Mobile Side Menu */}
      {isOpen && (
        <div className="fixed top-0 right-0 h-full w-3/4 bg-gray-900 shadow-lg p-6 md:hidden z-50 flex flex-col">
          {/* Close Button */}
          <button
            className="self-end mb-6 hover:text-red-500"
            onClick={() => setIsOpen(false)}
          >
            <X size={28} />
          </button>

          {/* Menu Links */}
          <ul className="flex flex-col gap-6 font-medium">
            <li className="hover:text-gray-300 cursor-pointer">Home</li>
            <li className="hover:text-gray-300 cursor-pointer">About</li>
            <li className="hover:text-gray-300 cursor-pointer">Services</li>
            <li className="hover:text-gray-300 cursor-pointer">Contact</li>
            <li className="hover:text-gray-300 cursor-pointer">Sign in</li>
          </ul>
        </div>
      )}
    </header>
  );
};

export default Header;
