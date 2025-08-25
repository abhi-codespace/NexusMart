import { useState } from "react";
import { Menu, X } from "lucide-react";
// import logo from "../../assets/nexusmart-logo.png"

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
          className="md:hidden p-2 rounded-lg hover:text-black transition"
          onClick={() => setIsOpen(!isOpen)}
        >
          {isOpen ? <X size={28} /> : <Menu size={28} />}
        </button>

      </div>

      {/* Mobile Side Menu */}
      {isOpen && (
        <div className="fixed top-0 right-0 h-full min-w-10/19 bg-gray-900 shadow-lg p-6 md:hidden z-50 flex flex-col">
          {/* Close Button */}
          <button className="self-end mb-6 hover:text-red-700" onClick={() => setIsOpen(false)}>
            <X size={28} />
          </button>

          {/* Menu Links */}
          <ul className="flex flex-col gap-6 font-medium">
            <li className="hover:text-gray-300 cursor-pointer">Home</li>
            <li className="hover:text-gray-300 cursor-pointer">About</li>
            <li className="hover:text-gray-300 cursor-pointer">Services</li>
            <li className="hover:text-gray-300 cursor-pointer">Contact</li>
            <li className="hover:text-gray-200 cursor-pointer">Sign in</li>
          </ul>
        </div>
      )}
    </header>
  );
};

export default Header;
