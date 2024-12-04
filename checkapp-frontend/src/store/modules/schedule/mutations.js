export const mutations = {
  SET_SCHEDULE(state, schedule) {
    state.schedule = schedule;
  },
  SET_LOADING(state, loading) {
    state.loading = loading;
  },
  SET_ERROR(state, error) {
    state.error = error;
  },
  SET_SCHEDULES(state, schedules) {
    state.schedules = schedules;
  }
};
