<template>
  <v-container max-width="inherit" class="container1">
    <v-row cols="12" lg="12" md="12" sm="12" xs="12">
      <v-col cols="12" class="d-flex flex-column ga-5">
        <v-container
          class="checkout-column-container d-flex flex-column ga-5 rounded-lg"
          max-width="inherit"
        >
          <v-card elevation="0" class="rounded-lg">
            <v-container class="checkout-header-container" max-width="inherit">
              <span class="font-weight-bold text-h6">Novo exame</span>
            </v-container>
            <v-divider></v-divider>
            <v-container max-width="inherit">
              <v-form @submit.prevent="handleCreateExam" v-model="valid">
                <v-container max-width="inherit">
                  <v-row>
                    <v-col cols="12" lg="12" md="12" sm="12">
                      <v-select
                        v-model="selectedUnit"
                        :items="units"
                        item-title="unitName"
                        item-value="unitId"
                        label="Selecione uma unidade"
                        class="new-unit-input"
                        required
                      >
                      </v-select>
                    </v-col>
                    <v-col cols="12" lg="6" md="6" sm="12">
                      <v-text-field
                        class="new-unit-input"
                        v-model="name"
                        label="Nome"
                        :rules="[rules.required, rules.minLength]"
                        required
                      ></v-text-field>
                    </v-col>

                    <v-col cols="12" lg="6" md="6" sm="12">
                      <v-text-field
                        class="new-unit-input"
                        v-model="value"
                        label="Valor"
                        required
                        type="number"
                      >
                      </v-text-field>
                    </v-col>
                  </v-row>
                  <v-row>
                    <v-col cols="12" class="d-flex justify-center">
                      <v-card-actions>
                        <v-btn
                          color="white"
                          text="Criar exame"
                          size="large"
                          variant="flat"
                          @click="handleCreateExam"
                          class="checkout-button text-capitalize"
                        >
                        </v-btn>
                      </v-card-actions>
                    </v-col>
                  </v-row>
                </v-container>
              </v-form>
            </v-container>
          </v-card>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { defineComponent, getCurrentInstance } from "vue";
import { mapActions, mapGetters } from "vuex";

export default defineComponent({
  name: "NewExam",
  setup() {
    const { proxy } = getCurrentInstance();
    return { proxy };
  },
  data() {
    return {
      valid: false,
      name: "",
      value: "",
      specialty: "",
      services: "",
      imageFile: null,
      unitImage: null,
      selectedUnit: null,
      currentUnitId: null,
      rules: {
        required: (value) => !!value || "Campo obrigatório",
        minLength: (value) => value.length >= 3 || "Mínimo de 3 caracteres",
      },
    };
  },

  computed: {
    ...mapGetters("unit", ["isLoading", "getError", "getAllUnits"]),

    units() {
      return this.getAllUnits || [];
    },
  },

  async mounted() {
    await this.$store.dispatch("unit/getAllUnits");
  },

  methods: {
    ...mapActions("unit", ["createUnit", "addExamToUnit"]),

    async handleCreateExam() {
      if (!this.selectedUnit) return;

      const examData = [
        {
          examName: this.name,
          examCode: 0,
          unitId: this.selectedUnit,
          examValue: this.value,
        },
      ];

      await this.addExamToUnit({
        unitId: this.selectedUnit,
        examData,
      });

      if (!this.getError) {
        this.proxy.$snack.notify({
          position: "bottom-center",
          type: "success",
          duration: 5000,
          title: "Sucesso!",
          message: "Exame criado com sucesso.",
        });
        this.$router.push("/");
      } else {
        this.proxy.$snack.notify({
          position: "top-center",
          type: "error",
          duration: 3000,
          title: "Erro!",
          message: "Erro ao criar exame.",
        });
      }
    },
  },
});
</script>

<style scoped>
.checkout-column-container {
  background-color: #f5f5f5;
}

.checkout-header-container {
  padding: 24px !important;
}

.clinic-info-container {
  display: flex !important;
  justify-content: space-between !important;
}

:deep(.v-field--active) {
  border-radius: 24px !important;
}

.checkout-button {
  background: var(
    --gradients-gradinet-02,
    linear-gradient(176deg, rgba(169, 180, 229, 0) 53.56%, #a9b4e5 174.26%),
    linear-gradient(135deg, #a9b4e5 -19.17%, #723ab3 58.89%)
  ) !important;
  color: white !important;
}

:deep(.v-field__input) {
  color: #723ab3 !important;
}
</style>
