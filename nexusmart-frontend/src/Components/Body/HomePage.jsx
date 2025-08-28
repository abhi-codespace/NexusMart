import React from "react";

function HomePage() {
  return (
    <main className="max-w-7xl mx-auto px-6 py-10">
      {/* Hero Section */}
      <section className="relative rounded-2xl overflow-hidden h-[250px] flex items-center justify-center text-center">
        

        {/* Dark Overlay */}
        <div className="absolute inset-0 bg-black bg-opacity-40"></div>

        {/* Center Text */}
        <div className="relative z-10">
          <h1 className="text-4xl md:text-5xl text-white font-bold">
            Welcome to NexusMart
          </h1>
          <p className="mt-3 text-[12px] text-white font-extralight">
            Shop smarter. Discover deals every day.
          </p>
          <button className="mt-4 px-4 py-2 rounded-2xl hover:bg-yellow-400 hover:text-red-800 bg-yellow-300 text-indigo-800 font-bold text-sm">
            Shop Now
          </button>
        </div>
      </section>

      {/* Categories */}
      <section className="mt-16">
        <h2 className="mb-6 font-bold text-2xl">Shop by Category</h2>
        <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-5 gap-6">
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Electronics</div>
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Accessories</div>
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Fashion</div>
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Grocery</div>
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Home</div>
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Beauty</div>
          <div className="bg-gray-100 p-6 rounded-lg border font-extrabold text-center cursor-pointer">Sports</div>
        </div>
      </section>

      {/* About Section */}
      <section className="mt-20 text-center">
        <h2 className="text-2xl font-bold mb-4">About NexusMart</h2>
        <p className="text-gray-600 max-w-3xl mx-auto">
          NexusMart is your one-stop online shopping destination. 
          From electronics and fashion to groceries and home essentials, 
          we bring everything you need in one place. Our mission is to provide 
          a seamless shopping experience with unbeatable deals, fast delivery, 
          and secure payments.
        </p>
        <p className="text-gray-600 mt-4 max-w-3xl mx-auto">
          Whether you're upgrading your gadgets, refreshing your wardrobe, 
          or stocking up on daily essentials, NexusMart has got you covered. 
          Join thousands of happy customers who shop smarter with us every day!
        </p>
      </section>
    </main>
  );
}

export default HomePage;
