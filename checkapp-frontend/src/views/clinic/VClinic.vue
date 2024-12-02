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
  mounted() {},
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

.v-tabs-containers {
  background-color: #f5f5f5;
}

.v-clinic-info-container {
  background-color: #f5f5f5;
}
</style>
