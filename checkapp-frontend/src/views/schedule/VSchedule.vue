<template>
  <v-container max-width="inherit" class="container1">
    <h1>schedule</h1>
  </v-container>
</template>

<script>
export default {
  name: "ScheduleView",
  data() {
    return {};
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
