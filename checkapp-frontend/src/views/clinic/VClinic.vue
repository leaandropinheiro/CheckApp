<template>
  <v-container max-width="inherit" class="d-flex flex-column ga-5">
    <v-card elevation="0" class="v-clinic-info-container d-flex rounded-xl">
      <v-col>
        <v-row class="">
          <v-col cols="12" lg="12" md="12" sm="12" xs="12" class="d-flex">
            <v-card width="100%" elevation="0" class="rounded-xl">
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
      <v-col cols="12">
        <v-list class="ainda rounded-xl">
          <v-list-item
            v-for="exam in exams"
            :key="exam.examId"
            class="v-tabs-item-list-container"
          >
            <v-table class="v-tabs-item-list">
              <tbody>
                <tr>
                  <td class="table-td-title">{{ exam.examName }}</td>
                  <td class="table-td-price">R$ {{ exam.examValue }},00</td>
                  <td class="table-td-button">
                    <v-btn
                      density="compact"
                      icon="mdi-cart-plus"
                      size="large"
                      color="#723ab3"
                      variant="tonal"
                      elevation="0"
                      @click="handleExamSelection(exam)"
                    ></v-btn>
                  </td>
                </tr>
              </tbody>
            </v-table>
          </v-list-item>
        </v-list>
      </v-col>
    </v-card>
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "VClinic",
  components: {},
  data() {
    return {
      exams: [],
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
      return this.unitExams && Object.keys(this.unitExams).length > 0;
    },
  },

  methods: {
    ...mapActions({
      fetchUnitExams: "unit/getUnitExams",
      addExamToCart: "cart/addExamToCart",
    }),

    async handleExamSelection(exam) {
      console.log("👉 exam => ", exam);
      await this.addExamToCart(exam);
    },
  },

  async mounted() {
    const unitId = Number(this.$route.query.unitId);

    if (unitId) {
      await this.fetchUnitExams(unitId);
    }
    const exams = await this.fetchUnitExams(unitId);
    console.log("👉 exams => ", exams);

    if (unitId) {
      this.exams = await this.fetchUnitExams(unitId);
      console.log("👉 this.exams => ", this.exams);
    }
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

.ainda {
  padding: 10px !important;
}

.v-tabs-containers {
  background-color: #f5f5f5;
}

.v-clinic-info-container {
  background-color: #f5f5f5;
}

.v-list-item {
  padding: 0 !important;
  margin: 0 !important;
}

.table-td-title,
.table-td-price,
.table-td-button {
  padding: 0 !important;
  margin: 0 !important;
}

:deep(.table-td-title) {
  width: 60% !important;
  text-align: left;
  font-weight: semi-bold;
  font-size: 1rem;
}

:deep(.table-td-price) {
  width: 20% !important;
  text-align: left;
  font-weight: semi-bold;
  font-size: 1rem;
}

:deep(.table-td-button) {
  width: 10% !important;
  text-align: right;
}

:deep(.mdi-cart-plus) {
  font-size: 1.1rem;
  /* color: #723ab3; */
}

:deep(.v-expansion-panel) {
  border-radius: 8px !important;
}

.v-tabs-item-list {
  padding: 0 15px 0 15px !important;
  border-radius: 8px !important;
  width: 100% !important;
  max-width: 100% !important;
}

.v-tabs-item-list:hover {
  background-color: #f5f5f5;
  border-radius: 8px !important;
}

.v-tabs-item-list-container {
  width: 100% !important;
  max-width: 100% !important;
}
</style>
