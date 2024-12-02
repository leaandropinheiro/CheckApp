export default {
  isAuthenticated: (state) => state.isAuthenticated,
  currentUser: (state) => state.user,
  userPhoto: (state) => state.userPhoto,
  userDetails: (state) => state.userDetails,
  token: (state) => state.token,
};
