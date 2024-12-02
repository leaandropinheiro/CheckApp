import services from "@/services";

export default {
  async login({ commit }, msalInstance) {
    const { account, userPhoto, token } = await services.Auth.login(msalInstance);

    const photoBlob = await fetch(userPhoto).then(r => r.blob());
    const reader = new FileReader();
    reader.readAsDataURL(photoBlob);

    reader.onloadend = () => {
      const base64Photo = reader.result;
      localStorage.setItem('userPhotoData', base64Photo);
      commit("setUserPhoto", base64Photo);
    };

    localStorage.setItem('user', JSON.stringify(account));
    localStorage.setItem('token', token);
    localStorage.setItem('isAuthenticated', 'true');

    commit("setUser", account);
    commit("setToken", token);
    commit("setAuthenticated", true);

    return account;
  },

  checkAuth({ commit }) {
    const token = localStorage.getItem('token');
    const user = JSON.parse(localStorage.getItem('user'));
    const photoData = localStorage.getItem('userPhotoData');
    const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';

    if (isAuthenticated && user && token) {
      commit("setUser", user);
      commit("setToken", token);

      if (photoData) {
        commit("setUserPhoto", photoData);
      }
      commit("setAuthenticated", true);
      return true;
    }
    return false;
  },

  async logout({ commit }, msalInstance) {
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    localStorage.removeItem('userPhotoData');
    localStorage.removeItem('isAuthenticated');

    commit("setUser", null);
    commit("setToken", null);
    commit("setUserPhoto", null);
    commit("setAuthenticated", false);

    return msalInstance.logout();
  },
};
