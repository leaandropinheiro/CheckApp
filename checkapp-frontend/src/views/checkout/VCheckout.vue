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
                        <span class="font-weight-thin text-caption">
                          Nome completo
                        </span>
                        <span class="font-weight-black text-caption">
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
                        <span class="font-weight-thin text-caption">
                          Email
                        </span>
                        <span class="font-weight-black text-caption">
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
                        <span class="font-weight-thin text-caption">
                          Data do agendamento
                        </span>
                        <span class="font-weight-black text-caption">
                          01/01/2021
                        </span>
                      </div>
                    </v-container>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </v-card>
          <v-card elevation="0" class="rounded-xl">
            <v-container class="checkout-header-container">
              <span class="font-weight-bold text-h6"> Forma de pagamento </span>
            </v-container>
            <v-divider></v-divider>
          </v-card>
        </v-container>
      </v-col>
      <v-col cols="12" lg="4" md="4" sm="12">
        <v-container
          class="checkout-column-container d-flex flex-column ga-5 rounded-xl"
        >
          <v-card elevation="0" class="rounded-xl">
            <v-container class="checkout-header-container">
              <span class="font-weight-bold text-h6"> Resumo </span>
            </v-container>
            <v-divider></v-divider>
            <!-- //! Total do agendamento -->
            <!-- //! Local do agendamento -->
            <!-- //! Local do agendamento -->
            <!-- //! Detalhes dos valores -->
            <v-container>
              <v-card elevation="0" class="rounded-xl">
                <v-container class="d-flex flex-column ga-2">
                  <div class="clinic-info-container">
                    <span class="font-weight-thin text-caption">
                      Serviços agendados
                    </span>
                    <span class="font-weight-black text-caption">
                      Rua, dos bobos, 0
                    </span>
                  </div>
                  <div class="clinic-info-container">
                    <span class="font-weight-thin text-caption"> Local </span>
                    <span class="font-weight-black text-caption">
                      Rua, dos bobos, 0
                    </span>
                  </div>
                  <div class="clinic-info-container">
                    <span class="font-weight-thin text-caption"> Local </span>
                    <span class="font-weight-black text-caption">
                      Rua, dos bobos, 0
                    </span>
                  </div>
                  <div class="clinic-info-container">
                    <span class="font-weight-thin text-caption"> Local </span>
                    <span class="font-weight-black text-caption">
                      Rua, dos bobos, 0
                    </span>
                  </div>
                </v-container>
              </v-card>
            </v-container>
          </v-card>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "VCheckout",
  components: {},
  data() {
    return {};
  },
  mounted() {},
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
      currentUser: "auth/currentUser",
      userPhoto: "auth/userPhoto",
      userDetails: "auth/userDetails",
    }),
  },
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
</style>
