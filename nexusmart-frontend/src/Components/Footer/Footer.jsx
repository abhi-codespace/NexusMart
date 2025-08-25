import React from 'react'

function Footer() {
  return (
    <footer className="bg-gray-900 text-gray-300 py-10 mt-10">
      <div className="max-w-7xl mx-auto px-6 grid grid-cols-2 sm:grid-cols-2 md:grid-cols-4 gap-8 cursor-pointer">
        
        {/* Brand */}
        <div className="col-span-2 md:col-span-1">
          <h1 className="font-bold text-2xl text-white">NexusMart</h1>
          <p className="text-sm mt-3 text-gray-300">
            Smart shopping. Simple management. Secure payments.
          </p>
        </div>

        {/* Shop */}
        <div>
          <h3 className="font-semibold text-white mb-3">Shop</h3>
          <ul className="space-y-2 text-sm">
            <li>Products</li>
            <li>Categories</li>
            <li>Offers</li>
          </ul>
        </div>

        {/* Support */}
        <div>
          <h3 className="font-semibold text-white mb-3">Support</h3>
          <ul className="space-y-2 text-sm">
            <li>Help Center</li>
            <li>Returns</li>
            <li>FAQs</li>
          </ul>
        </div>

        {/* Company */}
        <div>
          <h3 className="font-semibold text-white mb-3">Company</h3>
          <ul className="space-y-2 text-sm">
            <li>About Us</li>
            <li>Careers</li>
            <li>Contact</li>
          </ul>
        </div>
      </div>

      {/* Bottom Bar */}
      <div className="mt-10 border-t border-gray-700 pt-5 text-center text-sm text-gray-400">
        © {new Date().getFullYear()} NexusMart. All rights reserved.
      </div>
    </footer>
  )
}

export default Footer
