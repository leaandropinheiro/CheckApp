export default {
  setUser(state, user) {
    state.user = user;
  },
  setUserDetails(state, details) {
    state.userDetails = details;
  },
  setToken(state, token) {
    state.token = token;
  },
  setAuthenticated(state, value) {
    state.isAuthenticated = value;
  },
  setUserPhoto(state, photo) {
    state.userPhoto = photo;
  },
};
