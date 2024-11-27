import { shallowMount } from "@vue/test-utils";
import VCards from "@/components/VCard/VCards.vue";

describe("VCards.vue", () => {
  const mockClinica = {
    logo: "https://seeklogo.com/images/O/odontoprev-especialistas-em-odontologia-logo-E7B70B335A-seeklogo.com.png",
    nome: "Clínica Odontológica",
    especialidade: "Odontologia",
    localidade: "Rua das Flores, 123 - Centro, São Paulo, SP",
    servicosPrestados: [
      "Consulta odontológica",
      "Limpeza dental",
      "Tratamento de canal",
    ],
    avaliacoes: {
      total: 120,
      media: 4.6,
      comentarios: [
        "Ótimo atendimento e profissionais.",
        "Ambiente limpo e acolhedor.",
        "A espera foi um pouco longa.",
      ],
    },
  };

  const defaultProps = {
    servicos: {},
    avaliacoesTotal: 5,
    avaliacoesMedia: 0,
    logo: "@/assets/logo.png",
    title: "Test Title",
    subtitle: "Test Subtitle",
    localidade: "Test Location",
    comentarios: ["Comment 1", "Comment 2"]
  };

  const createWrapper = (props = {}) => {
    return shallowMount(VCards, {
      props: { ...defaultProps, ...props },
      global: {
        stubs: {
          'v-card': true,
          'v-hover': true,
          'v-rating': true,
          'v-divider': true,
          'v-list': true,
          'v-list-item': true,
          'v-container': true,
          'v-icon': true,
          'v-btn': true,
          'v-col': true,
          'v-card-text': true,
          'v-card-subtitle': true,
          'v-list-item-avatar': true,
          'v-list-item-subtitle': true,
          'v-list-item-content': true
        }
      }
    });
  };

  it("Should renders component with all props", () => {
    const wrapper = createWrapper();
    expect(wrapper.exists()).toBe(true);
  });

  it("Should show title", () => {
    const wrapper = createWrapper();
    expect(wrapper.text()).toContain("");
  });

  it("Should show subtitle", () => {
    const wrapper = createWrapper();
    expect(wrapper.text()).toContain("");
  });

  it("Should show location", () => {
    const wrapper = createWrapper();
    expect(wrapper.text()).toContain("");
  });

});
