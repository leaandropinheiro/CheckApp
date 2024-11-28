export const getters = {
  isDrawerOpen: state => state.drawer.isOpen,
  isRailMode: state => state.drawer.rail,
  cartExams: state => state.cart.exams,
  cartPayment: state => state.cart.payment,
  isCartEmpty: state => state.cart.exams.length === 0,
  cartTotal: state => state.cart.exams.reduce((total, exam) => total + Number(exam.examValue), 0)
};