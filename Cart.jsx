function Cart({ cartItems }) {
  const total = cartItems.reduce((sum, item) => sum + item.price, 0);

  return (
    <div>
      <h3>Your Cart 🛒</h3>
      {cartItems.length === 0 ? (
        <p>Cart is empty</p>
      ) : (
        <ul>
          {cartItems.map((item, index) => (
            <li key={index}>
              {item.title} - ₹{item.price}
            </li>
          ))}
        </ul>
      )}
      <h4>Total: ₹{total}</h4>
    </div>
  );
}

export default Cart;
