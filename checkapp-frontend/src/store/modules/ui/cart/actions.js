export const actions = {
  toggleDrawer({ commit }) {
    commit('TOGGLE_DRAWER')
  },

  setDrawerState({ commit }, payload) {
    commit('SET_DRAWER_STATE', payload)
  },

  addExamToCart({ commit }, exam) {
    commit("ADD_EXAM_TO_CART", exam);
  },

  removeExam({ commit }, examCode) {
    commit("REMOVE_EXAM_FROM_CART", examCode);
  },

  clearCart({ commit }) {
    commit("CLEAR_CART");
  }
}
