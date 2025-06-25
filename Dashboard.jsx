import { useEffect, useState } from "react";
import axios from "axios";
import Cart from "./Cart";

function Dashboard() {
  const [books, setBooks] = useState([]);
  const [cart, setCart] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8081/books")
      .then((res) => {
        console.log("Books from API:", res.data);
        setBooks(res.data);
      })
      .catch((err) => {
        console.error("Error fetching books:", err);
      });
  }, []);

  const handleAddToCart = (book) => {
    setCart([...cart, book]);
  };

  return (
    <div>
      {/* Logout Button */}
      <button
        onClick={() => {
          localStorage.removeItem("isLoggedIn");
          window.location.href = "/";
        }}
        style={{
          position: "absolute",
          top: "20px",
          right: "20px",
          padding: "8px 12px",
          backgroundColor: "#ff4d4d",
          color: "white",
          border: "none",
          borderRadius: "5px",
          cursor: "pointer",
        }}
      >
        Logout
      </button>

      {/* Dashboard Content */}
      <div style={{ padding: "20px" }}>
        <h2>Welcome to Dashboard 📚</h2>
        <div style={{ display: "flex", justifyContent: "space-around", marginTop: "30px" }}>
          <div>
            <h3>Available Books</h3>
            {books.length === 0 ? (
              <p>No books available</p>
            ) : (
              <ul>
                {books.map((book) => (
                  <li key={book.id}>
                    {book.title} - ₹{book.price}
                    <button style={{ marginLeft: "10px" }} onClick={() => handleAddToCart(book)}>
                      Add to Cart
                    </button>
                  </li>
                ))}
              </ul>
            )}
          </div>

          <Cart cartItems={cart} />
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
