import axios from "axios";
class Exams {
  static async getAllExams(
    search = "",
    page = 1,
    per_page = 10,
    featured = false
  ) {
    try {
      const result = await axios.get(`${process.env.VUE_APP_LABI_URL}exams/`, {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
          Accept: "*/*",
        },
        params: {
          page,
          per_page,
          search,
          featured,
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
