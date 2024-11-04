import { createStore } from "vuex";
import exams from "./modules/exams";

export default createStore({
  modules: {
    exams,
  },
});
