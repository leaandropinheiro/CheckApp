import { shallowMount } from "@vue/test-utils";
import VCards from "@/components/VCard/VCards.vue";
import vuetify from "@/plugins/vuetify";

describe("VCards.vue", () => {
  it("Should render component", () => {
    const wrapper = shallowMount(VCards, {
      vuetify,
    });
    expect(wrapper.exists()).toBe(true);
  })
})
