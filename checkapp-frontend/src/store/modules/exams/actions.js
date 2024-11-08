import Services from "../../../services/index";

export const actions = {
  async fetchExams(
    { commit },
    { search = "", page = 1, perPage = 20, featured = false }
  ) {
    console.log("👉 search =>", search);
    commit("setLoading", true);
    try {
      const exams = await Services.Exams.getAllExams(
        search,
        page,
        perPage,
        featured
      );

      commit("setExams", exams);
      return exams;
    } catch (error) {
      commit("setError", error);
      console.error("Error fetching exams:", error);
      throw error;
    } finally {
      commit("setLoading", false);
    }
  },
};
