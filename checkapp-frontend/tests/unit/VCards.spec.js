import { shallowMount } from "@vue/test-utils";
import VCards from "@/components/VCard/VCards.vue";
import { createVuetify } from "vuetify";

const vuetify = createVuetify();

describe("VCards.vue", () => {
  it("Should render component", () => {
    const wrapper = shallowMount(VCards, {
      global: {
        plugins: [vuetify],
      },
    });
    expect(wrapper.exists()).toBe(true);
  });
});
