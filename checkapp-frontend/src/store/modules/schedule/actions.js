import Services from '@/services';

export const actions = {
  async createSchedule({ commit, rootGetters }, scheduleData) {
    commit('SET_LOADING', true);
    try {
      const cartExams = rootGetters['cart/cartExams'];
      const cartTotal = rootGetters['cart/cartTotal'];

      const payload = {
        scheduleId: crypto.randomUUID(),
        exams: cartExams.map(exam => ({
          examId: crypto.randomUUID(),
          examCode: exam.examCode,
          examName: exam.examName,
          examValue: exam.examValue,
          examType: exam.examType || "COLETA"
        })),
        payment: {
          paymentId: crypto.randomUUID(),
          type: "CARTAO",
          value: cartTotal,
          status: "PAYMENT_PENDING"
        },
        scheduleDate: scheduleData,
        unitId: cartExams[0].unitId
      };


      const response = await Services.Schedule.createSchedule(payload);
      commit('SET_SCHEDULE', response);
      return response;
    } catch (error) {
      commit('SET_ERROR', error);
      throw error;
    } finally {
      commit('SET_LOADING', false);
    }
  }
};