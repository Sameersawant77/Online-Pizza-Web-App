const btn = document.getElementById("btn");
const cart = document.getElementById("cart");
const cancel = document.getElementById("cancel");

btn.addEventListener('click', () => {
  cart.classList.add("cart-updated");
});

cancel.addEventListener('click', () => {
  cart.classList.remove("cart-updated");
});  

