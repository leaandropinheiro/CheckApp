<template>
  <v-container max-width="inherit" class="container1">
    <v-card elevation="0">
      <v-container max-width="inherit" class="container2">
        <v-card-title class="font-weight-black">
          Clinicas disponíveis
        </v-card-title>
        <v-card-subtitle>Clínicas próximas disponíveis.</v-card-subtitle>
      </v-container>

      <v-divider border="black thin"></v-divider>
      <v-container max-width="inherit" class="container3">
        <v-col>
          <v-row class="cardsss">
            <v-col
              v-for="clinic in displayedCliniques"
              :key="clinic.id"
              cols="12"
              lg="4"
              md="6"
              sm="12"
              xs="12"
              class="d-flex"
            >
              <VCards
                :logo="clinic.logo"
                :title="clinic.name"
                :subtitle="clinic.specialty"
                :locality="clinic.locality"
                :services="clinic.servicesProvided"
                :totalReviews="clinic.reviews.total"
                :averageReviews="clinic.reviews.average"
                :comments="clinic.reviews.comments"
              />
            </v-col> </v-row
        ></v-col>
      </v-container>
      <v-col class="text-center">
        <v-btn
          v-if="visibleCliniques < mockClinicas.length"
          color="primary"
          class="mr-2 text-capitalize"
          @click="loadMore"
          variant="flat"
        >
          Ver mais
        </v-btn>

        <v-btn
          v-if="visibleCliniques > increment"
          color="secondary"
          class="mr-2 text-capitalize"
          @click="verMenos"
          variant="flat"
        >
          Ver menos
        </v-btn>
      </v-col>
    </v-card>
  </v-container>
  <v-container max-width="inherit">
    <v-card elevation="5">
      <v-container max-width="inherit">
        <v-card-title>Exames disponíveis</v-card-title>
        <v-card-subtitle
          >Todos os exames disponíveis estão listados aqui.</v-card-subtitle
        >
      </v-container>

      <v-divider border="black thin"></v-divider>
      <v-container max-width="inherit">
        <v-col>
          <v-row class="">
            <v-col
              v-for="exam in exams"
              :key="exam.id"
              cols="8"
              lg="4"
              md="6"
              sm="12"
              xs="12"
              class="d-flex"
            >
              <VCards
                :title="exam.title"
                :subtitle="exam.slug"
                :services="{}"
                :totalReviews="0"
              />
            </v-col>
          </v-row>
        </v-col>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>
import VCards from "@/components/VCard/VCards.vue";
import emitter from "@/plugins/eventBus";

export default {
  name: "VHome",
  components: {
    VCards,
  },
  data() {
    return {
      exams: [],
      visibleCliniques: 6,
      increment: 6,
      mockClinicas: [
        {
          id: 1,
          logo: "https://seeklogo.com/images/O/odontoprev-especialistas-em-odontologia-logo-E7B70B335A-seeklogo.com.png",
          name: "Clínica Odontológica",
          specialty: "Odontologia",
          locality: "Rua das Flores, 123 - Centro, São Paulo, SP",
          servicesProvided: {
            consultas: [
              {
                id: 101,
                title: "Consulta odontológica",
                price: "200",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Limpeza dental",
                price: "150",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            tratamentos: [
              {
                id: 201,
                title: "Tratamento de canal",
                price: "800",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            cirurgias: [
              {
                id: 301,
                title: "Extração de siso",
                price: "500",
                category: "Cirurgias",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 120,
            average: 4.6,
            comments: [
              "Ótimo atendimento e profissionais.",
              "Ambiente limpo e acolhedor.",
              "A espera foi um pouco longa.",
            ],
          },
        },
        {
          id: 2,
          logo: "https://seeklogo.com/images/S/salud-psicologia-y-nutricion-logo-171368388B-seeklogo.com.png",
          name: "Clínica de Psicologia",
          specialty: "Psicologia",
          locality: "Av. da Liberdade, 456 - Bela Vista, São Paulo, SP",
          servicesProvided: {
            terapias: [
              {
                id: 301,
                title: "Terapia individual",
                price: "250",
                category: "Terapias",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 302,
                title: "Terapia de casal",
                price: "400",
                category: "Terapias",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 303,
                title: "Psicoterapia infantil",
                price: "300",
                category: "Terapias",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            consultas: [
              {
                id: 101,
                title: "Consulta psicológica",
                price: "200",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Avaliação psicológica",
                price: "300",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            tratamentos: [
              {
                id: 201,
                title: "Tratamento de ansiedade",
                price: "600",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 202,
                title: "Tratamento de depressão",
                price: "700",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 80,
            average: 4.8,
            comments: [
              "Profissionais muito competentes.",
              "Ambiente acolhedor e seguro.",
              "Amo a equipe!",
            ],
          },
        },
        {
          id: 3,
          logo: "https://seeklogo.com/images/L/laboratorio-oswaldo-cruz-analises-clinicas-logo-7CF2F2EE8A-seeklogo.com.png",
          name: "Laboratório de Análises Clínicas",
          specialty: "Laboratório de Exames",
          locality: "Praça da Paz, 789 - Jardim América, São Paulo, SP",
          servicesProvided: {
            exames: [
              {
                id: 101,
                title: "Hemograma completo",
                price: "100",
                category: "Exames",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Teste de glicemia",
                price: "50",
                category: "Exames",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 103,
                title: "Teste de colesterol",
                price: "70",
                category: "Exames",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            vacinas: [
              {
                id: 201,
                title: "Vacina contra gripe",
                price: "100",
                category: "Vacinas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 202,
                title: "Vacina contra febre amarela",
                price: "150",
                category: "Vacinas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            checkups: [
              {
                id: 301,
                title: "Check-up completo",
                price: "300",
                category: "Check-ups",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 150,
            average: 4.4,
            comments: [
              "Rápido e eficiente.",
              "Bom atendimento no agendamento.",
              "Os resultados saíram no prazo.",
            ],
          },
        },
        {
          id: 4,
          logo: "https://seeklogo.com/images/U/unna-odontoprev-logo-7A758003EE-seeklogo.com.png",
          name: "Clínica de Odontologia",
          specialty: "Odontologia",
          locality: "Rua da Esperança, 234 - Vila Mariana, São Paulo, SP",
          servicesProvided: {
            consultas: [
              {
                id: 101,
                title: "Consulta odontológica",
                price: "200",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Limpeza dental",
                price: "150",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            tratamentos: [
              {
                id: 201,
                title: "Tratamento de canal",
                price: "800",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            cirurgias: [
              {
                id: 301,
                title: "Extração de siso",
                price: "500",
                category: "Cirurgias",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 95,
            average: 4.7,
            comments: [
              "Excelente experiência!",
              "Atendimento muito bom.",
              "Recomendo!",
            ],
          },
        },
        {
          id: 5,
          logo: "https://seeklogo.com/images/C/clinica-san-pablo-logo-D4F126FD81-seeklogo.com.png",
          name: "Clínica de Psicologia",
          specialty: "Psicologia",
          locality: "Av. das Nações, 567 - Moema, São Paulo, SP",
          servicesProvided: {
            terapias: [
              {
                id: 301,
                title: "Terapia individual",
                price: "250",
                category: "Terapias",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 302,
                title: "Terapia de casal",
                price: "400",
                category: "Terapias",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 303,
                title: "Psicoterapia infantil",
                price: "300",
                category: "Terapias",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            consultas: [
              {
                id: 101,
                title: "Consulta psicológica",
                price: "200",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Avaliação psicológica",
                price: "300",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            tratamentos: [
              {
                id: 201,
                title: "Tratamento de ansiedade",
                price: "600",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 202,
                title: "Tratamento de depressão",
                price: "700",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 70,
            average: 4.5,
            comments: [
              "Ótimos profissionais!",
              "Me ajudaram muito.",
              "Ambiente confortável.",
            ],
          },
        },
        {
          id: 7,
          logo: "https://seeklogo.com/images/C/Clinica_Sorrir-logo-6A4C956ABB-seeklogo.com.png",
          name: "Clínica de Odontologia",
          specialty: "Odontologia",
          locality: "Av. do Trabalho, 890 - Jardim Paulista, São Paulo, SP",
          servicesProvided: {
            consultas: [
              {
                id: 101,
                title: "Consulta odontológica",
                price: "200",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Limpeza dental",
                price: "150",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            tratamentos: [
              {
                id: 201,
                title: "Tratamento de canal",
                price: "800",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            cirurgias: [
              {
                id: 301,
                title: "Extração de siso",
                price: "500",
                category: "Cirurgias",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 60,
            average: 4.3,
            comments: [
              "Atendimento muito bom.",
              "Excelente profissional.",
              "Recomendo a todos.",
            ],
          },
        },
        {
          id: 8,
          logo: "https://seeklogo.com/images/C/clinica-sao-vicente-logo-5E2ABB7ACC-seeklogo.com.png",
          name: "Clínica de Psicologia",
          specialty: "Psicologia",
          locality: "Rua do Progresso, 345 - Tatuapé, São Paulo, SP",
          servicesProvided: {
            consultas: [
              {
                id: 101,
                title: "Consulta odontológica",
                price: "200",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
              {
                id: 102,
                title: "Limpeza dental",
                price: "150",
                category: "Consultas",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            tratamentos: [
              {
                id: 201,
                title: "Tratamento de canal",
                price: "800",
                category: "Tratamentos",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
            cirurgias: [
              {
                id: 301,
                title: "Extração de siso",
                price: "500",
                category: "Cirurgias",
                max_quantity: 1,
                stock_status: "instock",
              },
            ],
          },
          reviews: {
            total: 85,
            average: 4.7,
            comments: [
              "Excelente equipe!",
              "Mudou minha perspectiva.",
              "Muito satisfeita.",
            ],
          },
        },
      ],
    };
  },

  async mounted() {
    await this.getExams();
    emitter.on("clinic-details", this.selectedClinic);
  },

  beforeUnmount() {
    emitter.off("clinic-details", this.selectedClinic);
  },

  computed: {
    displayedCliniques() {
      return this.mockClinicas.slice(0, this.visibleCliniques);
    },
  },

  methods: {
    async getExams() {
      try {
        const response = await this.$store.dispatch("fetchExams", {
          search: "",
        });
        this.exams = response.items.map((item) => ({
          id: item.id,
          title: item.title,
          price: item.price,
          slug: item.slug,
          synonymous: item.synonymous,
        }));
      } catch (error) {
        console.error("Erro ao buscar exames:", error);
      }
    },

    loadMore() {
      this.visibleCliniques += this.increment;
    },

    verMenos() {
      this.visibleCliniques = this.increment;
    },

    // ? Método para receber o evento do VCards para exibir detalhes da clínica on componente VClinic
    selectedClinic(clinicData) {
      this.$router.push({
        name: "Clinica",
        query: {
          ...clinicData,
          servicesProvided: JSON.stringify(clinicData.servicesProvided),
        },
      });
    },
  },
};
</script>

<style scoped></style>
