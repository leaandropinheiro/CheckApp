<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer
        :model-value="drawer.isOpen"
        :rail="drawer.rail"
        permanent
        border="opacity-50 sm"
        location="right"
        class="cart-drawer"
        width="300"
      >
        <v-list density="compact" nav>
          <v-list-item-action class="d-flex justify-end">
            <v-btn
              :icon="isMenuOpen"
              size="small"
              @click="toggleDrawer"
              elevation="0"
            ></v-btn>
          </v-list-item-action>
        </v-list>
        <v-divider></v-divider>
        <v-container
          v-if="!drawer.rail"
          class="cart-exams-container bg-grey-lighten-4"
        >
          <div class="exams-scroll-container">
            <v-card
              v-for="exam in exams"
              :key="exam.examId"
              border="opacity-50 sm"
              class="mx-auto exam-card mb-3"
            >
              <v-card-title
                >{{ exam.examName }}
                <v-tooltip activator="parent" location="top">
                  {{ exam.examName }}
                </v-tooltip>
              </v-card-title>
              <v-card-title>R$ {{ exam.examValue }},00</v-card-title>
              <v-card-actions class="d-flex justify-end">
                <v-btn variant="text" @click="handleExamRemoval(exam.examId)">
                  <v-icon size="x-large">mdi-delete-outline</v-icon>
                  <v-tooltip activator="parent" location="top">
                    Remover
                  </v-tooltip>
                </v-btn>
              </v-card-actions>
            </v-card>
          </div>
        </v-container>
        <v-divider></v-divider>
        <!-- //? CHECKOUT CART -->
        <v-container
          class="cart-checkout-container bg-grey-lighten-4"
          v-if="!drawer.rail"
        >
          <v-card
            width="100%"
            height="100%"
            elevation="0"
            class="cart-checkout-card d-flex flex-column justify-space-between bg-grey-lighten-4"
          >
            <div class="cart-checkout-header d-flex justify-space-between">
              <v-card-title>Total</v-card-title>
              <v-card-title>{{ formatCurrency(cartTotal) }}</v-card-title>
            </div>
            <v-card-actions>
              <v-btn
                color="deep-purple-lighten-2"
                text="Efetuar agendamento"
                block
                border
              ></v-btn>
            </v-card-actions>
          </v-card>
        </v-container>
      </v-navigation-drawer>
      <v-main class="h-screen sidebar"></v-main>
    </v-layout>
  </v-card>
</template>

<script>
import { mapActions, mapState, mapGetters } from "vuex";

export default {
  name: "VCart",
  mounted() {},
  computed: {
    ...mapState("cart", ["drawer", "cart"]),
    ...mapGetters("cart", ["cartTotal"]),

    isMenuOpen() {
      return this.drawer.rail ? "mdi-cart" : "mdi-close";
    },
    exams() {
      return this.cart.exams;
    },
    isCartEmpty() {
      return this.cart.exams.length === 0;
    },
  },
  methods: {
    ...mapActions("cart", ["toggleDrawer", "removeExam"]),

    handleExamRemoval(examId) {
      this.removeExam(examId);
    },

    formatCurrency(value) {
      return value.toLocaleString("pt-BR", {
        style: "currency",
        currency: "BRL",
      });
    },
  },
};
</script>

<style scoped>
.cart-drawer .v-navigation-drawer__content {
  min-width: 51px !important;
}

.cart-exams-container {
  height: calc(80vh - 136px);
  padding: 16px;
  position: relative;
}

.cart-checkout-container {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 20vh;
  position: relative;
  border-top: #555 solid 1px;
  box-shadow: 0 0 50px 50px #f5f5f5;
}

.exams-scroll-container {
  height: 100%;
  overflow-y: auto;
}

.exam-card {
  min-height: 150px;
  margin-bottom: 16px;
}

.exams-scroll-container::-webkit-scrollbar {
  width: 6px;
}

.exams-scroll-container::-webkit-scrollbar-track {
  background: #f1f1f1;
  border-radius: 3px;
}

.exams-scroll-container::-webkit-scrollbar-thumb {
  background: #888;
  border-radius: 3px;
}

.exams-scroll-container::-webkit-scrollbar-thumb:hover {
  background: #555;
}

.v-card-title {
  font-size: 18px;
  font-weight: semi-bold;
}
</style>
