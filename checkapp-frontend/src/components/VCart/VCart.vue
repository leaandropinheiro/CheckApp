<template>
  <v-card elevation="0">
    <v-layout>
      <v-navigation-drawer
        :model-value="drawer.isOpen"
        :rail="drawer.rail"
        permanent
        location="right"
        class="cart-drawer"
        width="300"
        fixed
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
        <v-container v-if="!drawer.rail" class="cart-exams-container">
          <div class="exams-scroll-container">
            <transition-group name="fade-slide" v-if="exams.length > 0">
              <v-card
                v-for="exam in cartExamsWithUnitInfo"
                :key="exam.services"
                elevation="0"
                class="card-exams mx-auto exam-card mb-3 rounded-xl"
              >
                <v-container class="cart-exams-header-container">
                  <v-chip color="primary">
                    {{ exam.specialty }}
                  </v-chip>
                  <v-icon
                    size="small"
                    class="close-icon"
                    @click="handleExamRemoval(exam.examCode)"
                  >
                    mdi-close
                  </v-icon>
                </v-container>
                <v-container class="cart-exams-body-container">
                  <span class="font-weight-normal">
                    {{ exam.examName }}
                  </span>
                  <span class="font-weight-black text-h6">
                    R$ {{ exam.examValue }},00
                  </span>
                </v-container>
              </v-card>
            </transition-group>
            <div v-else class="empty-cart-container">
              <transition name="fade-slide">
                <img
                  src="@/assets/empty-cart.svg"
                  class="empty-cart-image"
                  alt=""
                />
              </transition>
            </div>
          </div>
        </v-container>
        <!-- //? CHECKOUT CART -->
        <v-container
          class="cart-checkout-container border-t"
          v-if="!drawer.rail"
        >
          <v-card
            width="100%"
            height="100%"
            elevation="0"
            class="cart-checkout-card d-flex flex-column justify-space-between"
          >
            <div class="cart-checkout-header d-flex justify-space-between">
              <span class="font-weight-black text-h6">Total</span>
              <span class="font-weight-black text-h6">
                {{ formatCurrency(cartTotal) }}
              </span>
            </div>
            <v-card-actions>
              <v-btn
                color="white"
                text="Ir para checkout"
                block
                size="large"
                variant="flat"
                @click="handleCheckout"
                class="checkout-button text-capitalize"
              >
              </v-btn>
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
  async mounted() {
    await this.$store.dispatch("unit/getAllUnits");
  },
  computed: {
    ...mapState("cart", ["drawer", "cart"]),
    ...mapGetters("cart", ["cartTotal"]),
    ...mapGetters("unit", ["getAllUnits"]),

    cartExamsWithUnitInfo() {
      return this.cart.exams.map((exam) => {
        const unit = this.getAllUnits.find(
          (u) => u.unitId === Number(exam.unitId)
        );
        return {
          ...exam,
          unitName: unit?.unitName,
          region: unit?.region,
          specialty: unit?.specialty,
          services: unit?.services,
        };
      });
    },

    isMenuOpen() {
      return this.drawer.rail ? "mdi-cart" : "mdi-close";
    },

    exams() {
      return this.cart.exams;
    },

    isCartEmpty() {
      return this.cart.exams.length === 0;
    },

    formattedExamValue() {
      return this.cart.exams.map((exam) => {
        return {
          ...exam,
          examValue: this.formatCurrency(exam.examValue),
        };
      });
    },
  },
  methods: {
    ...mapActions("cart", ["toggleDrawer", "removeExam"]),

    handleExamRemoval(examCode) {
      this.removeExam(examCode);
    },

    formatCurrency(value) {
      return value.toLocaleString("pt-BR", {
        style: "currency",
        currency: "BRL",
      });
    },

    handleCheckout() {
      this.$router.push({ name: "Checkout" });
    },
  },
};
</script>

<style scoped>
.cart-drawer .v-navigation-drawer__content {
  min-width: 51px !important;
}

.cart-exams-header-container {
  display: flex;
  padding: 0.5rem;
  justify-content: space-between;
}

.cart-exams-body-container {
  display: flex;
  flex-direction: column;
  padding: 0 1rem 1rem 1rem;
  justify-content: space-between;
}

.cart-exams-container {
  height: calc(80vh - 136px);
  padding: 16px;
  position: relative;
  background-color: #f5f5f5;
}

.close-icon:hover {
  cursor: pointer;
  color: #723ab3;
  transition: 600ms ease;
  rotate: 180deg;
}

.cart-checkout-card {
  background-color: #f5f5f5;
}

.cart-checkout-container {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 20vh;
  position: relative;
  box-shadow: 0 0 50px 50px #f5f5f5;
  background-color: #f5f5f5;
}

.exams-scroll-container {
  height: 100%;
  overflow-y: auto;
}

.exam-card {
  min-height: inherit;
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

.checkout-button {
  background: var(
    --gradients-gradinet-02,
    linear-gradient(176deg, rgba(169, 180, 229, 0) 53.56%, #a9b4e5 174.26%),
    linear-gradient(135deg, #a9b4e5 -19.17%, #723ab3 58.89%)
  ) !important;
  color: white !important;
}

.fade-slide-enter-active {
  animation: fadeInUp 0.4s ease-in-out;
}

.fade-slide-leave-active {
  animation: fadeOutDown 0.4s ease-in-out;
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes fadeOutDown {
  from {
    opacity: 1;
    transform: translateY(0);
  }
  to {
    opacity: 0;
    transform: translateY(20px);
  }
}

.empty-cart-container {
  display: flex;
  align-content: center;
  height: 100%;
}

.empty-cart-image {
  width: 100%;
  transition: all 0.8s ease-in-out !important;
}
</style>
