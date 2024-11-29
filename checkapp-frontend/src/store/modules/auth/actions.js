import services from "@/services";

export default {
  async login({ commit }, msalInstance) {
    const { account, userPhoto, token } = await services.Auth.login(
      msalInstance
    );
    commit("setUser", account);
    commit("setToken", token);
    commit("setUserPhoto", userPhoto);
    commit("setAuthenticated", true);
    return account;
  },

  async logout({ commit }, msalInstance) {
    await services.Auth.logout(msalInstance);
    commit("setUser", null);
    commit("setToken", null);
    commit("setUserPhoto", null);
    commit("setAuthenticated", false);
  },
};
