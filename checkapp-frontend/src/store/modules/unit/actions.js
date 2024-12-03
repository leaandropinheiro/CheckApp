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
  },

  async addExamsToUnit({ commit }, { unitId, exams }) {
    commit('SET_LOADING', true);
    try {
      const response = await Services.Unit.addExamsToUnit(unitId, exams);
      return response;
    } catch (error) {
      commit('SET_ERROR', error);
    } finally {
      commit('SET_LOADING', false);
    }
  },

  async getUnitById({ commit }, unitId) {
    commit('SET_LOADING', true);
    try {
      const response = await Services.Unit.getUnitById(unitId);
      commit('SET_UNIT', response);
      commit('SET_ERROR', null);
      return response;
    } catch (error) {
      commit('SET_ERROR', error);
    } finally {
      commit('SET_LOADING', false);
    }
  },

  async getAllUnits({ commit }) {
    commit('SET_LOADING', true);
    try {
      const response = await Services.Unit.getAllUnits();
      commit('SET_UNITS', response);
      commit('SET_ERROR', null);
      return response;
    } catch (error) {
      commit('SET_ERROR', error);
    } finally {
      commit('SET_LOADING', false);
    }
  },

  async addExamToUnit({ commit }, { unitId, examData }) {
    commit('SET_LOADING', true);
    try {
      const response = await Services.Unit.addExamToUnit(unitId, examData);
      return response;
    } catch (error) {
      commit('SET_ERROR', error);
    } finally {
      commit('SET_LOADING', false);
    }
  },

  async getUnitExams({ commit }, unitId) {
    try {
      const data = await Services.Unit.getUnitExams(unitId)
      commit('setUnitExams', data)
      return data
    } catch (error) {
      console.error('Error fetching unit exams:', error)
      throw error
    }
  }
};
