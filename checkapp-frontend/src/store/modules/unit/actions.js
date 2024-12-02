import Services from "@/services";

export default {
  async createUnit({ commit }, { name, region, specialty, services }) {
    commit('SET_LOADING', true);
    try {
      const response = await Services.Unit.createUnit(name, region, specialty, services);
      commit('SET_UNIT', response);
      commit('SET_ERROR', null);
      return response;
    } catch (error) {
      commit('SET_ERROR', error);
    } finally {
      commit('SET_LOADING', false);
    }
  }
};
