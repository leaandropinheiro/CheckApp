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
              <span class="font-weight-bold text-h6">Nova unidade</span>
            </v-container>
            <v-divider></v-divider>
            <v-container max-width="inherit">
              <v-form @submit.prevent="handleCreateUnit" v-model="valid">
                <v-container max-width="inherit">
                  <v-row>
                    <v-col cols="12" lg="6" md="6" sm="12">
                      <v-text-field
                        class="new-unit-input"
                        v-model="name"
                        label="Nome da unidade"
                        :rules="[rules.required, rules.minLength]"
                        required
                      ></v-text-field>
                    </v-col>

                    <v-col cols="12" lg="6" md="6" sm="12">
                      <v-text-field
                        class="new-unit-input"
                        v-model="region"
                        label="Localidade"
                        :rules="[rules.required, rules.minLength]"
                        required
                      >
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" lg="6" md="6" sm="12">
                      <v-text-field
                        class="new-unit-input"
                        v-model="specialty"
                        label="Especialidade da unidade"
                        :rules="[rules.required, rules.minLength]"
                        required
                      ></v-text-field>
                    </v-col>

                    <v-col cols="12" lg="6" md="6" sm="12">
                      <v-text-field
                        class="new-unit-input"
                        v-model="services"
                        label="Serviços oferecidos"
                        :rules="[rules.required, rules.minLength]"
                        required
                      >
                      </v-text-field>
                    </v-col>
                  </v-row>
                  <v-row>
                    <v-col cols="12" class="d-flex justify-center">
                      <v-card-actions>
                        <v-btn
                          color="white"
                          text="Criar unidade"
                          size="large"
                          variant="flat"
                          @click="handleCreateUnit"
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
import { mapActions, mapGetters } from "vuex";

export default {
  name: "NewUnit",
  data() {
    return {
      valid: false,
      name: "",
      region: "",
      specialty: "",
      services: "",
      imageFile: null,
      unitImage: null,
      currentUnitId: null,
      rules: {
        required: (value) => !!value || "Campo obrigatório",
        minLength: (value) => value.length >= 3 || "Mínimo de 3 caracteres",
      },
    };
  },

  async mounted() {},

  computed: {
    ...mapGetters("unit", ["isLoading", "getError"]),

    formIsValid() {
      return this.name.length >= 3 && this.region.length >= 3;
    },
  },

  methods: {
    ...mapActions("unit", ["createUnit"]),

    handleImageSelect(event) {
      this.imageFile = event.target.files[0];
    },

    async handleCreateUnit() {
      if (!this.formIsValid) return;

      await this.createUnit({
        name: this.name,
        region: this.region,
        specialty: this.specialty,
        services: this.services,
      });

      if (!this.getError) {
        this.$router.push("/");
      }
    },
  },

  watch: {},
};
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
