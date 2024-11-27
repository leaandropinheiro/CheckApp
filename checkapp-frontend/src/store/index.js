import { createStore } from "vuex";
import exams from "./modules/exams";
import cart from "./modules/ui/cart";


export default createStore({
  modules: {
    exams,
    cart,
  },
});



