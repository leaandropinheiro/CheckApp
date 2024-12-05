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
  },
  UPDATE_SCHEDULE(state, updatedSchedule) {
    const index = state.schedules.findIndex(s => s.scheduleId === updatedSchedule.scheduleId);
    if (index !== -1) {
      state.schedules[index] = updatedSchedule;
    }
  }

};
