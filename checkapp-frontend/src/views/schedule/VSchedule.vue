<template>
  <v-container max-width="inherit" class="container1">
    <v-card elevation="0">
      <v-container max-width="inherit">
        <v-col class="container2 rounded-xl">
          <div class="header-container d-flex flex-column">
            <span class="font-weight-black text-h5">Meus agendamentos</span>
            <span class="font-weight-thin">
              Acompanhe e gerencie seus agendamentos.
            </span>
          </div>
        </v-col>
      </v-container>

      <v-container max-width="inherit" class="container3">
        <v-col class="cards-container rounded-xl">
          <v-row class="cardsss" v-if="schedule.lenght > 0"> </v-row>
          <v-row class="cardsss" v-else>
            <v-container class="empty-cart-container">
              <img
                src="@/assets/empty-schedule.svg"
                alt=""
                class="empty-cart-image"
              />
            </v-container>
          </v-row>
        </v-col>
      </v-container>
      <v-col class="text-center"> </v-col>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "VSchedule",
  components: {},
  data() {
    return {
      schedule: [],
    };
  },

  async mounted() {},

  computed: {},

  methods: {},
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

.empty-cart-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 70vh !important;
}

.empty-cart-image {
  width: 500px;
  height: 500px;
  padding: 20px;
}
</style>
