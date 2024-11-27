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
        <!-- Contêiner dos exames com rolagem -->
        <v-container
          v-if="!drawer.rail"
          class="cart-exams-container bg-grey-lighten-4"
        >
          <div class="exams-scroll-container">
            <v-card
              v-for="exam in exams"
              :key="exam.examId"
              border="opacity-50 sm"
              elevation="0"
              class="exam-card mb-3"
            >
              <template #title>
                {{ exam.examName }}
              </template>
              <template #subtitle>
                {{ exam.examType }}
              </template>
              <template #text>
                {{ exam.examValue }}
              </template>
              <v-btn
                icon
                class="ms-auto"
                @click="handleExamRemoval(exam.examId)"
              >
                <v-icon>mdi-delete-outline</v-icon>
              </v-btn>
            </v-card>
          </div>
        </v-container>
        <v-divider></v-divider>
      </v-navigation-drawer>
      <v-main class="h-screen sidebar"></v-main>
    </v-layout>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "VCart",
  mounted() {
    console.log("👉 this.cart.exams => ", this.cart.exams);
    console.log("👉 this.cart.exams => ", this.cart.exams);
  },
  computed: {
    ...mapState("cart", ["drawer", "cart"]),
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
  },
};
</script>

<style scoped>
.cart-drawer .v-navigation-drawer__content {
  min-width: 51px !important;
}

.cart-exams-container {
  height: calc(
    100vh - 120px
  ); /* altura total menos espaço para cabeçalho/rodapé */
  padding: 16px;
  position: relative;
}

.exams-scroll-container {
  height: 100%;
  overflow-y: auto;
  padding-right: 8px;
}

.exam-card {
  min-height: 150px; /* altura mínima fixa para cada card */
  margin-bottom: 16px;
}

/* Estilização da barra de rolagem */
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
</style>
