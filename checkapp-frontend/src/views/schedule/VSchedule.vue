<template>
  <v-container max-width="inherit">
    <v-card elevation="0">
      <v-container max-width="inherit">
        <v-col class="header-section rounded-xl">
          <div class="d-flex flex-column pa-4">
            <span class="font-weight-black text-h5">Meus agendamentos</span>
            <span class="font-weight-thin">
              Acompanhe e gerencie seus agendamentos.
            </span>
          </div>
        </v-col>
      </v-container>

      <v-container max-width="inherit">
        <v-col class="content-section rounded-xl">
          <div
            v-for="(schedulesInMonth, month) in groupByMonth(schedules)"
            :key="month"
          >
            <div
              class="month-header py-2 px-4 font-weight-bold text-h6 text-capitalize"
            >
              {{ month }}
            </div>

            <v-expansion-panels class="my-4" variant="popout" elevation="0">
              <v-expansion-panel
                class="rounded-xl mb-2"
                v-for="schedule in schedulesInMonth"
                :key="schedule.scheduleId"
              >
                <v-expansion-panel-title>
                  <v-row no-gutters cols="12">
                    <div class="date-container">
                      <span class="weekday text-capitalize">
                        {{ formatDate(schedule.scheduleDate).weekday }}
                      </span>
                      <span class="day">
                        {{ formatDate(schedule.scheduleDate).day }}
                      </span>
                    </div>

                    <div class="unit-name-container text-h6">
                      <span class="font-weight-bold">
                        {{ schedule.unit.unitName }}
                      </span>
                    </div>
                  </v-row>
                </v-expansion-panel-title>

                <v-expansion-panel-text>
                  <v-row>
                    <v-col cols="12">
                      <div class="font-weight-bold mb-2">Exames:</div>
                      <div
                        class="d-flex flex-wrap gap-2"
                        v-for="exam in schedule.exams"
                        :key="exam.examId"
                      >
                        <span class="font-weight-bold">
                          {{ exam.examName }}
                        </span>
                      </div>
                    </v-col>
                    <v-col cols="12" class="mt-4">
                      <div class="d-flex justify-space-between">
                        <span class="font-weight-bold">Valor Total:</span>
                        <span class="font-weight-bold">
                          {{ formatCurrency(schedule.payment.value) }}
                        </span>
                      </div>
                    </v-col>
                  </v-row>
                </v-expansion-panel-text>
              </v-expansion-panel>
            </v-expansion-panels>
          </div>
        </v-col>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "VSchedule",

  data() {
    return {
      tab: null,
    };
  },

  computed: {
    ...mapGetters({
      schedules: "schedule/schedules",
    }),

    formattedDate() {
      return this.formatDate(this.date);
    },
  },

  mounted() {
    this.fetchSchedules();
  },

  methods: {
    async fetchSchedules() {
      await this.$store.dispatch("schedule/getAllSchedules");
    },

    formatDate(date) {
      const optionsDay = { weekday: "short" };
      const optionsDate = { day: "2-digit", month: "2-digit", year: "numeric" };
      const optionsOnlyDay = { day: "2-digit" };

      const weekday = new Date(date)
        .toLocaleDateString("pt-BR", optionsDay)
        .replace(".", "");
      const formattedDate = new Date(date).toLocaleDateString(
        "pt-BR",
        optionsDate
      );
      const day = new Date(date).toLocaleDateString("pt-BR", optionsOnlyDay);

      return { weekday, formattedDate, day };
    },

    groupByMonth(schedules) {
      return schedules.reduce((acc, schedule) => {
        const month = new Date(schedule.scheduleDate)
          .toLocaleDateString("pt-BR", {
            month: "short",
          })
          .replace(".", "");

        if (!acc[month]) {
          acc[month] = [];
        }
        acc[month].push(schedule);

        return acc;
      }, {});
    },

    formatCurrency(value) {
      return value.toLocaleString("pt-BR", {
        style: "currency",
        currency: "BRL",
      });
    },

    getStatusColor(status) {
      return this.statusConfig[status]?.color || "grey";
    },

    getStatusTextColor(status) {
      return this.statusConfig[status]?.color === "warning" ? "black" : "white";
    },

    formatStatus(status) {
      return this.statusConfig[status]?.text || status;
    },
  },
};
</script>

<style scoped>
.header-section,
.content-section {
  background-color: #f5f5f5;
}

.empty-state-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  min-height: 50vh;
  padding: 2rem;
}

.empty-state-image {
  max-width: 300px;
  height: auto;
}

.exam-item {
  margin: 4px 0;
}

:deep(.v-data-table) {
  background-color: transparent !important;
}

.date-container {
  display: flex;
  padding: 5px 15px 5px 15px;
  flex-direction: column;
  align-items: center;
  gap: 4px;
  width: 10%;
}

.unit-name-container {
  display: flex;
  padding: 5px 15px 5px 15px;
  justify-content: flex-start;
  align-items: center;
  width: 75%;
}

.chip-status-conatiner {
  display: flex;
  padding: 5px 15px 5px 15px;
  justify-content: center;
  align-items: center;
  gap: 4px;
  width: 15%;
}

.weekday {
  font-size: 1em;
  font-weight: bold;
  color: #757575;
}

.day {
  font-size: 2.5em;
  font-weight: bold;
  color: #723ab3;
}

.date {
  font-size: 1em;
  color: #757575;
}

:deep(.v-expansion-panel-title__overlay) {
  background-color: #723ab3;
}
</style>
