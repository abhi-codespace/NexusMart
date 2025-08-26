import { useState, useRef, useEffect } from "react";
import { Menu, X, Search, ShoppingCart,User } from "lucide-react";
import { Link } from "react-router-dom";

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);
  const menuRef = useRef(null);

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (menuRef.current && !menuRef.current.contains(event.target)) {
        setIsOpen(false);
      }
    };
    if (isOpen) {
      document.addEventListener("mousedown", handleClickOutside);
    } else {
      document.removeEventListener("mousedown", handleClickOutside);
    }
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, [isOpen]);

  return (
    <header className="bg-blue-600 text-white shadow-md">
      <div className="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center gap-2">

        {/* Logo */}
        <div className="flex items-center gap-2 cursor-pointer">
          <span className="text-xl font-bold">NexusMart</span>
        </div>

        {/* Search Bar */}
        <form className="relative flex items-center w-full max-w-md shadow-lg bg-white text-black rounded-2xl mx-4">
          <input
            className="w-full pl-10 pr-10 py-2 text-gray-700 focus:outline-none"
            type="search"
            placeholder="Search..."
          />
          <button type="submit" className="absolute right-3 text-gray-500 hover:text-blue-600 cursor-pointer">
            <Search className="h-5 w-5" />
          </button>
        </form>

        {/* Nav Links + Cart */}
        <div className="hidden md:flex items-center gap-6">
          <Link to="/" className="hover:text-gray-200">Home</Link>
          <Link to="/about" className="hover:text-gray-200">About</Link>
          <Link to="/services" className="hover:text-gray-200">Services</Link>
          <Link to="/contact" className="hover:text-gray-200">Contact</Link>

          {/* Sign In Icon */}
          <Link to="/signin" className="hover:text-gray-200 p-4 flex gap-1">
          <User size={24} className="rounded-2xl bg-blue-500 text-white hover:text-black  hover:bg-white"/>
          <span className=" font-extralight text-sm text-white hover:text-black">Login</span>
          </Link>

          {/* Shopping Cart */}
          <button className="text-white relative">
            <ShoppingCart size={28} />
            <span className="absolute -top-2 -right-2 bg-red-500 text-xs w-5 h-5 rounded-full flex items-center justify-center">
              3
            </span>
          </button>
        </div>

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
        <div
          ref={menuRef}
          className="fixed top-0 right-0 h-full w-2/3 sm:w-1/2 md:w-1/4 bg-gray-900 shadow-lg p-6 z-50 flex flex-col transition-transform transform duration-300 ease-in-out"
        >
          <button
            className="self-end mb-6 hover:text-red-700"
            onClick={() => setIsOpen(false)}
          >
            <X size={28} />
          </button>

          <ul className="flex flex-col gap-4 font-medium">
            <Link to="/" className="hover:text-gray-300">Home</Link>
            <Link to="/about" className="hover:text-gray-300">About</Link>
            <Link to="/services" className="hover:text-gray-300">Services</Link>
            <Link to="/contact" className="hover:text-gray-300">Contact</Link>
            <Link to="/signin" className="hover:text-gray-300"></Link>
          </ul>
        </div>
      )}
    </header>
  );
};

export default Header;
