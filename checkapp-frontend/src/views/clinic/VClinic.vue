<template>
  <v-container max-width="inherit" class="d-flex flex-column ga-5">
    <v-card elevation="0" class="v-clinic-info-container d-flex rounded-xl">
      <v-col>
        <v-row class="">
          <v-col cols="12" lg="12" md="12" sm="12" xs="12" class="d-flex">
            <v-card width="100%" elevation="0">
              <v-card-title>
                {{ clinic.title }}
              </v-card-title>
              <v-card-subtitle>
                {{ clinic.subtitle }}
              </v-card-subtitle>
              <v-card-text>
                {{ clinic.locality }}
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-card>
    <v-card class="v-tabs-containers rounded-xl" elevation="0">
      <v-container class="v-tabs-container">
        <v-row>
          <v-col cols="12">
            <VTabs
              v-if="isServicesValid"
              :services="clinic.servicesProvided"
              @select-exam="handleExamSelection"
            />
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>
import VTabs from "@/components/VTabs/VTabs.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "VClinic",
  components: {
    VTabs,
  },
  data() {
    return {
      clinic: {
        title: this.$route.query.title || "",
        subtitle: this.$route.query.subtitle || "",
        locality: this.$route.query.locality || "",
        servicesProvided: JSON.parse(
          this.$route.query.servicesProvided || "{}"
        ),
      },
    };
  },

  computed: {
    ...mapGetters("unit", {
      unitExams: "getUnitExams",
    }),

    isServicesValid() {
      return (
        this.clinic?.servicesProvided &&
        Object.keys(this.clinic.servicesProvided).length > 0
      );
    },
  },

  methods: {
    ...mapActions({
      fetchUnitExams: "unit/getUnitExams",
      addExamToCart: "cart/addExamToCart",
    }),

    async handleExamSelection(exam) {
      await this.addExamToCart(exam);
    },
  },

  async mounted() {
    const unitId = Number(this.$route.query.unitId);

    if (unitId) {
      await this.fetchUnitExams(unitId);
    }
    const exames = await this.fetchUnitExams(unitId);
  },
};
</script>

<style scoped>
.container-router-view {
  max-width: auto !important;
}

.v-tabs-container {
  max-width: 100% !important;
}

.v-tabs-containers {
  background-color: #f5f5f5;
}

.v-clinic-info-container {
  background-color: #f5f5f5;
}
</style>
