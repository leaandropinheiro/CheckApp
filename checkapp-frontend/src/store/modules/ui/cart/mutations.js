import { saveCartToLocalStorage, saveDrawerStateToLocalStorage } from './helpers';

export const mutations = {
  SET_DRAWER_STATE(state, payload) {
    state.drawer.isOpen = payload;
    saveDrawerStateToLocalStorage(state.drawer);
  },

  SET_RAIL_STATE(state, payload) {
    state.drawer.rail = payload;
    saveDrawerStateToLocalStorage(state.drawer);
  },

  TOGGLE_DRAWER(state) {
    state.drawer.rail = !state.drawer.rail;
    saveDrawerStateToLocalStorage(state.drawer);
  },

  ADD_EXAM_TO_CART(state, exam) {
    const formattedExam = {
      examCode: exam.examCode,
      examName: exam.examName,
      examValue: exam.examValue,
      examType: exam.examType,
      unitId: exam.unitId
    };

    state.cart.exams.push(formattedExam);
    saveCartToLocalStorage(state.cart);
  },

  REMOVE_EXAM_FROM_CART(state, examCode) {
    const index = state.cart.exams.findIndex(item => item.examCode === examCode);

    if (index !== -1) {
      state.cart.exams.splice(index, 1);
      saveCartToLocalStorage(state.cart);
    } else {
      console.error("Exam not found in cart:", examCode);
    }
  },
};
