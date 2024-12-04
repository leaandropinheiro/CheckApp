<template>
  <v-container max-width="inherit" class="container1">
    <v-card elevation="0">
      <v-container max-width="inherit">
        <v-col class="container2 rounded-xl">
          <div class="header-container d-flex flex-column">
            <span class="font-weight-black text-h5">Clinicas disponíveis</span>
            <span class="font-weight-thin">
              Clínicas próximas disponíveis.
            </span>
          </div>
        </v-col>
      </v-container>

      <v-container max-width="inherit" class="container3">
        <v-col class="cards-container rounded-xl">
          <v-row class="cardsss">
            <v-col
              v-for="clinic in displayedCliniques"
              :key="clinic.unitId"
              cols="12"
              lg="4"
              md="6"
              sm="12"
              xs="12"
              class="d-flex"
            >
              <VCards
                :unitId="clinic.unitId"
                :logo="clinic.unitImage"
                :title="clinic.unitName"
                :subtitle="clinic.specialty"
                :locality="clinic.region"
                :services="{ services: clinic.services }"
                :totalReviews="clinic.reviews?.total || 0"
                :averageReviews="clinic.reviews?.average || 0"
                :comments="clinic.reviews?.comments || []"
                @clinic-details="selectedClinic"
              />
            </v-col> </v-row
        ></v-col>
      </v-container>
      <v-col class="text-center">
        <v-btn
          v-if="visibleCliniques"
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
</template>

<script>
import VCards from "@/components/VCard/VCards.vue";
import emitter from "@/plugins/eventBus";
import { mapGetters } from "vuex";

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
    };
  },

  async mounted() {
    await this.getExams();
    emitter.on("clinic-details", this.selectedClinic);

    await this.$store.dispatch("unit/getAllUnits");
  },

  beforeUnmount() {
    emitter.off("clinic-details", this.selectedClinic);
  },

  computed: {
    ...mapGetters("unit", ["getAllUnits"]),

    displayedCliniques() {
      return this.getAllUnits.slice(0, this.visibleCliniques);
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

    selectedClinic(clinicData) {
      this.$router.push({
        name: "Clinica",
        query: {
          unitId: clinicData.unitId,
          title: clinicData.title,
          subtitle: clinicData.subtitle,
          locality: clinicData.locality,
          servicesProvided: JSON.stringify(clinicData.servicesProvided),
        },
      });
    },
  },
};
</script>

<style scoped>
.cards-container,
.container2 {
  background-color: #f5f5f5;
}

.container2 {
  padding: 1rem;
}
</style>
