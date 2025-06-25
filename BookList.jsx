import { useEffect, useState } from "react";
import axios from "axios";

function BookList({ onAddToCart }) {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8081/books")
      .then((res) => {
        setBooks(res.data);
      })
      .catch((err) => {
        console.error("Error fetching books:", err);
      });
  }, []);

  return (
    <div>
      <h2>Available Books</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {book.title} - ₹{book.price}
            <button style={{ marginLeft: "10px" }} onClick={() => onAddToCart(book)}>
              Add to Cart
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookList;
