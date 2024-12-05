<template>
  <v-dialog max-width="500">
    <template v-slot:activator="{ props: activatorProps }">
      <v-btn
        v-bind="activatorProps"
        color="#723ab3"
        text="Editar"
        variant="flat"
        class="text-capitalize"
      ></v-btn>
    </template>

    <template v-slot:default="{ isActive }">
      <v-card>
        <div class="d-flex justify-space-between align-center px-5 py-2">
          <v-card-title>Alterar data do agendamento</v-card-title>
          <v-icon icon="mdi-close" @click="isActive.value = false"></v-icon>
        </div>

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

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            text="Salvar"
            class="checkout-button text-capitalize"
            @click="handleUpdateSchedule"
          ></v-btn>
        </v-card-actions>
      </v-card>
    </template>
  </v-dialog>
</template>

<script>
export default {
  name: "VModalUpdateSchedule",
  props: {
    schedule: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      due: null,
      menu: false,
    };
  },
  computed: {
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
    async handleUpdateSchedule() {
      try {
        await this.$store.dispatch("schedule/updateSchedule", {
          scheduleId: this.schedule.scheduleId,
          newDate: new Date(this.due).toISOString(),
        });

        this.$emit("update-success");
        this.isActive.value = false;
      } catch (error) {
        console.error("Error updating schedule:", error);
      }
    },
  },
};
</script>

<style>
.checkout-button {
  background: var(
    --gradients-gradinet-02,
    linear-gradient(176deg, rgba(169, 180, 229, 0) 53.56%, #a9b4e5 174.26%),
    linear-gradient(135deg, #a9b4e5 -19.17%, #723ab3 58.89%)
  ) !important;
  color: white !important;
}
</style>
