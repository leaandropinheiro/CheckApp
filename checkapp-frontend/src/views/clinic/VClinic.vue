<template>
  <v-container max-width="inherit" class="d-flex flex-column ga-5">
    <!-- //? Aqui é onde renderiza as informações da clínica -->
    <v-card elevation="0" border="opacity-50 sm" class="d-flex">
      <v-container max-width="inherit">
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
      </v-container>
    </v-card>
    <!-- //? aqui sera exibido um menu tabs com os exames, vacinas e consultas da clinica -->
    <v-card elevation="0" border="opacity-50 sm">
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
import { mapActions } from "vuex";

export default {
  name: "VClinic",
  components: {
    VTabs,
  },
  computed: {
    isServicesValid() {
      return (
        this.clinic?.servicesProvided &&
        Object.keys(this.clinic.servicesProvided).length > 0
      );
    },
  },
  data() {
    const queryData = this.$route.query;
    let servicesProvided = {};

    try {
      servicesProvided = JSON.parse(queryData.servicesProvided || "{}");
    } catch (e) {
      console.warn("Services data parsing failed");
    }

    return {
      exams: [],
      clinic: {
        title: queryData.title || "",
        subtitle: queryData.subtitle || "",
        locality: queryData.locality || "",
        servicesProvided,
        totalReviews: queryData.totalReviews,
        averageReviews: queryData.averageReviews,
        comments: queryData.comments,
        logo: queryData.logo,
      },
    };
  },
  mounted() {
    console.log("👉 clinic data => ", this.clinic);
  },
  methods: {
    ...mapActions("cart", ["addExamToCart"]),

    handleExamSelection(exam) {
      this.addExamToCart(exam);
    },
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
</style>
