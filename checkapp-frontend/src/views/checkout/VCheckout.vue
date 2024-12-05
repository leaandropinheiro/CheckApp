<template>
  <v-container max-width="inherit" class="container1">
    <v-row cols="12" lg="12" md="12" sm="12" xs="12">
      <v-col cols="12" lg="8" md="8" sm="12" class="d-flex flex-column ga-5">
        <v-container
          class="checkout-column-container d-flex flex-column ga-5 rounded-xl"
        >
          <v-card elevation="0" class="rounded-xl">
            <v-container class="checkout-header-container">
              <span class="font-weight-bold text-h6">
                Informações do agendamento
              </span>
            </v-container>
            <v-divider></v-divider>
            <v-container>
              <v-row cols="12">
                <v-col col="4">
                  <v-card elevation="0" class="rounded-xl">
                    <v-container>
                      <div class="clinic-info-container d-flex flex-column">
                        <span class="font-weight-thin text-body-2">
                          Nome completo
                        </span>
                        <span class="font-weight-black text-body-2">
                          {{ currentUser.name }}
                        </span>
                      </div>
                    </v-container>
                  </v-card>
                </v-col>
                <v-col col="4">
                  <v-card elevation="0" class="rounded-xl">
                    <v-container>
                      <div class="clinic-info-container d-flex flex-column">
                        <span class="font-weight-thin text-body-2">
                          Email
                        </span>
                        <span class="font-weight-black text-body-2">
                          {{ currentUser.username }}
                        </span>
                      </div>
                    </v-container>
                  </v-card>
                </v-col>
                <v-col col="4">
                  <v-card elevation="0" class="rounded-xl">
                    <v-container>
                      <div class="clinic-info-container d-flex flex-column">
                        <span class="font-weight-thin text-body-2">
                          Data do agendamento
                        </span>
                        <v-menu v-model="menu" :close-on-content-click="false">
                          <template v-slot:activator="{ props }">
                            <v-text-field
                              v-model="formattedDate"
                              label="Data do agendamento"
                              prepend-icon="mdi-calendar"
                              v-bind="props"
                              readonly
                            ></v-text-field>
                          </template>
                          <VLocaleProvider locale="pt">
                            <v-date-picker
                              :title="'Selecione uma data'"
                              :header="'Calendário'"
                              v-model="due"
                              :modelValue="due"
                              @update:modelValue="due = $event"
                              locale="pt"
                              :first-day-of-week="1"
                            ></v-date-picker>
                          </VLocaleProvider>
                        </v-menu>
                      </div>
                    </v-container>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </v-card>
        </v-container>
      </v-col>
      <v-col cols="12" lg="4" md="4" sm="12" class="d-flex flex-column ga-5">
        <v-container
          class="checkout-column-container d-flex flex-column ga-5 rounded-xl"
        >
          <v-card elevation="0" class="rounded-xl">
            <v-container class="checkout-header-container">
              <span class="font-weight-bold text-h6"> Resumo </span>
            </v-container>
            <v-divider></v-divider>

            <v-container>
              <v-card elevation="0" class="rounded-xl">
                <v-container class="d-flex flex-column ga-5">
                  <div class="clinic-info-container d-flex flex-column">
                    <span class="font-weight-black text-body-2">
                      Serviços selecionados
                    </span>
                    <div
                      v-for="exam in cartExams"
                      :key="exam.examCode"
                      class="clinic-info-container"
                    >
                      <span class="font-weight-thin text-body-2">
                        {{ exam.examName }}
                      </span>
                      <span class="font-weight-black text-body-2">
                        R$ {{ exam.examValue }},00
                      </span>
                    </div>
                    <v-divider></v-divider>
                    <div
                      class="total-cart-container d-flex flex-row justify-space-between"
                    >
                      <span
                        class="d-flex justify-end font-weight-black text-body-2"
                      >
                        TOTAL
                      </span>
                      <span
                        class="d-flex justify-end font-weight-black text-body-2"
                      >
                        {{ formatCurrency(cartTotal) }}
                      </span>
                    </div>
                  </div>
                </v-container>
              </v-card>
            </v-container>
          </v-card>
        </v-container>
        <v-container class="checkout-column-container rounded-xl">
          <v-card elevation="0" class="rounded-xl">
            <v-container>
              <v-card elevation="0" class="d-flex flex-column ga-5 pa-5">
                <span class="font-weight-thin text-body-2">
                  Revise os detalhes do seu agendamento antes de concluir.
                  Certifique-se de que todas as informações estão corretas para
                  garantir um atendimento eficiente.
                </span>

                <v-btn
                  variant="flat"
                  block
                  class="checkout-button text-capitalize"
                  @click="handleSchedule"
                >
                  agendar
                </v-btn>
              </v-card>
            </v-container>
          </v-card>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { defineComponent, getCurrentInstance } from "vue";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "VCheckout",
  components: {},
  setup() {
    const { proxy } = getCurrentInstance();
    return { proxy };
  },
  data() {
    return {
      due: null,
      menu: false,
    };
  },
  mounted() {},
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
      currentUser: "auth/currentUser",
      userPhoto: "auth/userPhoto",
      userDetails: "auth/userDetails",
      cartExams: "cart/cartExams",
      cartTotal: "cart/cartTotal",
      cartPayment: "cart/cartPayment",
      schedule: "schedule/schedule",
      loading: "schedule/loading",
    }),

    minDate() {
      return new Date().toISOString().substring(0, 10);
    },

    formattedDate() {
      if (!this.due) return "";
      const date = new Date(this.due);
      return date.toLocaleDateString("pt-BR", {
        day: "2-digit",
        month: "2-digit",
        year: "numeric",
      });
    },
  },
  methods: {
    ...mapActions("cart", ["clearCart"]),

    formatCurrency(value) {
      return value.toLocaleString("pt-BR", {
        style: "currency",
        currency: "BRL",
      });
    },

    async handleSchedule() {
      try {
        if (!this.due) {
          this.proxy.$snack.notify({
            position: "bottom-center",
            type: "warning",
            duration: 5000,
            title: "Atenção!",
            message: "Selecione uma data para o agendamento.",
          });
          return;
        }

        await this.$store.dispatch(
          "schedule/createSchedule",
          new Date(this.due).toISOString()
        );

        await this.$store.dispatch("cart/clearCart");

        this.proxy.$snack.notify({
          position: "bottom-center",
          type: "success",
          duration: 5000,
          title: "Sucesso!",
          message: "Agendamento realizado com sucesso.",
        });

        this.$router.push("/meus-agendamentos");
      } catch (error) {
        console.error("Error ao realizar o agendamento.", error);
      }
    },
  },
};
</script>

<style scoped>
.checkout-column-container {
  background-color: #f5f5f5 !important;
}

.checkout-header-container {
  padding: 24px !important;
}

.clinic-info-container {
  display: flex !important;
  justify-content: space-between !important;
}

.checkout-button {
  background: var(
    --gradients-gradinet-02,
    linear-gradient(176deg, rgba(169, 180, 229, 0) 53.56%, #a9b4e5 174.26%),
    linear-gradient(135deg, #a9b4e5 -19.17%, #723ab3 58.89%)
  ) !important;
  color: white !important;
}
</style>
