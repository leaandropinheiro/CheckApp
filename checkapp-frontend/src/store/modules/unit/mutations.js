export const mutations = {
  SET_LOADING(state, payload) {
    state.loading = payload;
  },

  SET_ERROR(state, payload) {
    state.error = payload;
  },

  SET_UNIT(state, payload) {
    state.units.push(payload);
  },

  setUnitExams(state, exams) {
    state.unitExams = exams
  },

  SET_UNITS(state, payload) {
    state.units = payload;
  },

  SET_TOAST(state, payload) {
    state.toast = payload;
  }
};
