export function loadCartFromLocalStorage() {
  return JSON.parse(localStorage.getItem('cart')) || {
    exams: [],
    payment: {
      paymentId: null,
      paymentType: "",
      value: 0,
    },
    scheduleDate: null,
  };
}

export function loadDrawerStateFromLocalStorage() {
  return JSON.parse(localStorage.getItem('drawerState')) || {
    isOpen: true,
    rail: true
  };
}

export function saveCartToLocalStorage(cart) {
  localStorage.setItem('cart', JSON.stringify(cart));
}

export function saveDrawerStateToLocalStorage(drawerState) {
  localStorage.setItem('drawerState', JSON.stringify(drawerState));
}