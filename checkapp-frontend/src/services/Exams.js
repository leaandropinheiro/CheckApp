import axios from "axios";

class Exams {
  static async getAllExams(search = "", page = 1, perPage = 10, featured = false) {
    try {
      const result = await axios.get(`${process.env.VUE_APP_URL}exams/`, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
          Accept: "*/*",
        },
        params: {
          page: page,
          per_page: perPage,
          search: search,
          featured: featured,
        },
      });

      return result.data;
    } catch (error) {
      console.error("Error fetching exams:", error);
      throw error;
    }
  }
}

export default Exams;
