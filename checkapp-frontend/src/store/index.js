import { createStore } from "vuex";
import exams from "./modules/exams";
import cart from "./modules/ui/cart";
import auth from "./modules/auth";
import unit from "./modules/unit";
import schedule from "./modules/schedule";

export default createStore({
  modules: {
    exams,
    cart,
    auth,
    unit,
    schedule
  },
});
