export const mutations = {
  setExams(state, exams) {
    state.exams = exams;
  },
  setError(state, error) {
    state.error = error;
  },
  setLoading(state, isLoading) {
    state.isLoading = isLoading;
  },
};
