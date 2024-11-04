<template>
  <v-container max-width="inherit">
    <v-card elevation="5">
      <v-container max-width="inherit">
        <v-card-title class="font-weight-black">
          Clinicas disponíveis
        </v-card-title>
        <v-card-subtitle>Clínicas próximas disponíveis.</v-card-subtitle>
      </v-container>

      <v-divider border="black thin"></v-divider>
      <v-container max-width="inherit">
        <v-col
          ><v-row class="">
            <v-col
              v-for="clinica in mockClinicas"
              :key="clinica.id"
              cols="12"
              lg="4"
              md="6"
              sm="12"
              xs="12"
              class="d-flex"
            >
              <VCards
                :logo="clinica.logo"
                :title="clinica.nome"
                :subtitle="clinica.especialidade"
                :localidade="clinica.localidade"
                :servicos="clinica.servicosPrestados"
                :avaliacoesTotal="clinica.avaliacoes.total"
                :avaliacoesMedia="clinica.avaliacoes.media"
                :comentarios="clinica.avaliacoes.comentarios"
              />
            </v-col> </v-row
        ></v-col>
      </v-container>
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
        <v-col
          ><v-row class="">
            <v-col
              v-for="exam in exams"
              :key="exam.id"
              cols="12"
              lg="4"
              md="6"
              sm="12"
              xs="12"
              class="d-flex"
            >
              <VCards :logo="logo" :title="exam.title" :subtitle="exam.slug" />
            </v-col> </v-row
        ></v-col>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>
import VCards from "../../components/VCard/VCards.vue";

export default {
  name: "VHome",
  components: {
    VCards,
  },
  data() {
    return {
      exams: [],
      mockClinicas: [
        {
          id: 1,
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
        },
        {
          id: 2,
          logo: "https://seeklogo.com/images/S/salud-psicologia-y-nutricion-logo-171368388B-seeklogo.com.png",
          nome: "Clínica de Psicologia",
          especialidade: "Psicologia",
          localidade: "Av. da Liberdade, 456 - Bela Vista, São Paulo, SP",
          servicosPrestados: [
            "Terapia individual",
            "Terapia de casal",
            "Psicoterapia infantil",
          ],
          avaliacoes: {
            total: 80,
            media: 4.8,
            comentarios: [
              "Profissionais muito competentes.",
              "Ambiente acolhedor e seguro.",
              "Amo a equipe!",
            ],
          },
        },
        {
          id: 3,
          logo: "https://seeklogo.com/images/L/laboratorio-oswaldo-cruz-analises-clinicas-logo-7CF2F2EE8A-seeklogo.com.png",
          nome: "Laboratório de Análises Clínicas",
          especialidade: "Laboratório de Exames",
          localidade: "Praça da Paz, 789 - Jardim América, São Paulo, SP",
          servicosPrestados: [
            "Exames de sangue",
            "Exames de urina",
            "Exames de fezes",
          ],
          avaliacoes: {
            total: 150,
            media: 4.4,
            comentarios: [
              "Rápido e eficiente.",
              "Bom atendimento no agendamento.",
              "Os resultados saíram no prazo.",
            ],
          },
        },
        {
          id: 4,
          logo: "https://seeklogo.com/images/U/unna-odontoprev-logo-7A758003EE-seeklogo.com.png",
          nome: "Clínica de Odontologia",
          especialidade: "Odontologia",
          localidade: "Rua da Esperança, 234 - Vila Mariana, São Paulo, SP",
          servicosPrestados: [
            "Ortodontia",
            "Implantes dentários",
            "Estética dental",
          ],
          avaliacoes: {
            total: 95,
            media: 4.7,
            comentarios: [
              "Excelente experiência!",
              "Atendimento muito bom.",
              "Recomendo!",
            ],
          },
        },
        {
          id: 5,
          logo: "https://seeklogo.com/images/C/clinica-san-pablo-logo-D4F126FD81-seeklogo.com.png",
          nome: "Clínica de Psicologia",
          especialidade: "Psicologia",
          localidade: "Av. das Nações, 567 - Moema, São Paulo, SP",
          servicosPrestados: [
            "Psicoterapia para adultos",
            "Terapia de grupo",
            "Avaliação psicológica",
          ],
          avaliacoes: {
            total: 70,
            media: 4.5,
            comentarios: [
              "Ótimos profissionais!",
              "Me ajudaram muito.",
              "Ambiente confortável.",
            ],
          },
        },
        {
          id: 6,
          logo: "https://seeklogo.com/images/C/clinica-internacional-logo-C4FB888440-seeklogo.com.png",
          nome: "Laboratório de Exames Rápidos",
          especialidade: "Laboratório de Exames",
          localidade: "Rua do Sol, 678 - Vila Olímpia, São Paulo, SP",
          servicosPrestados: [
            "Exames laboratoriais completos",
            "Exames de imagem",
            "Teste rápido de glicemia",
          ],
          avaliacoes: {
            total: 110,
            media: 4.6,
            comentarios: [
              "Fui muito bem atendido!",
              "Rápido e prático.",
              "Resultados precisos.",
            ],
          },
        },
        {
          id: 7,
          logo: "https://seeklogo.com/images/C/Clinica_Sorrir-logo-6A4C956ABB-seeklogo.com.png",
          nome: "Clínica de Odontologia",
          especialidade: "Odontologia",
          localidade: "Av. do Trabalho, 890 - Jardim Paulista, São Paulo, SP",
          servicosPrestados: [
            "Clareamento dental",
            "Aparelhos ortodônticos",
            "Tratamento de gengiva",
          ],
          avaliacoes: {
            total: 60,
            media: 4.3,
            comentarios: [
              "Atendimento muito bom.",
              "Excelente profissional.",
              "Recomendo a todos.",
            ],
          },
        },
        {
          id: 8,
          logo: "https://seeklogo.com/images/C/clinica-sao-vicente-logo-5E2ABB7ACC-seeklogo.com.png",
          nome: "Clínica de Psicologia",
          especialidade: "Psicologia",
          localidade: "Rua do Progresso, 345 - Tatuapé, São Paulo, SP",
          servicosPrestados: [
            "Terapia cognitivo-comportamental",
            "Terapia para adolescentes",
            "Aconselhamento psicológico",
          ],
          avaliacoes: {
            total: 85,
            media: 4.7,
            comentarios: [
              "Excelente equipe!",
              "Mudou minha perspectiva.",
              "Muito satisfeita.",
            ],
          },
        },
        {
          id: 9,
          logo: "https://seeklogo.com/images/C/clinica_valle_del_lili-logo-08A84BDD28-seeklogo.com.png",
          nome: "Laboratório de Análises Clínicas",
          especialidade: "Laboratório de Exames",
          localidade:
            "Av. das Américas, 321 - Barra da Tijuca, Rio de Janeiro, RJ",
          servicosPrestados: [
            "Exames de sangue",
            "Exames hormonais",
            "Exames de colesterol",
          ],
          avaliacoes: {
            total: 40,
            media: 4.4,
            comentarios: [
              "Rápido e confiável.",
              "Ótimo atendimento.",
              "Sempre retornam os resultados no prazo.",
            ],
          },
        },
      ],
    };
  },
  async mounted() {
    try {
      const response = await this.$store.dispatch("fetchExams", { search: "" });
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
};
</script>

<style scoped>
.container-router-view {
  max-width: auto !important;
}
</style>
