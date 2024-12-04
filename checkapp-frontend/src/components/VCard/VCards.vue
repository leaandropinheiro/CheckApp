<template>
  <v-hover>
    <template v-slot:default="{ isHovering, props }">
      <v-card
        class="mx-auto card rounded-xl"
        v-bind="props"
        :style="{
          transform: isHovering ? 'scale(1.01)' : 'scale(1)',
          transition: 'transform 0.3s ease',
          cursor: 'pointer',
          background: isHovering ? '#FFFFF' : '#fff',
          opacity: isHovering ? 1 : 1,
        }"
        @click="verMais"
      >
        <v-container class="d-flex justify-space-between">
          <div class="clinic-info-container d-flex ga-5">
            <div
              class="logo-container d-flex align-center"
              v-if="logo?.length > 0"
            >
              <img :src="logo" alt="logo-clnica" class="logo" width="50" />
            </div>
            <div class="clinic-info-container d-flex flex-column">
              <span class="font-weight-black text-h6">{{ title }}</span>
              <span class="font-weight-thin"> {{ subtitle }} </span>
            </div>
          </div>
          <div class="rating-container" v-if="averageReviews > 0">
            <v-rating
              :model-value="averageReviews"
              color="amber"
              density="compact"
              size="small"
              half-increments
              readonly
            ></v-rating>
            <v-card-subtitle class="avaliacoes">
              {{ averageReviews }} ({{ totalReviews }})
            </v-card-subtitle>
          </div>
        </v-container>
        <v-container>
          <v-card
            prepend-icon="mdi-map-marker"
            append-icon="mdi-open-in-new"
            :subtitle="locality"
            @click="verMais"
            elevation="0"
          >
          </v-card>
        </v-container>
      </v-card>
    </template>
  </v-hover>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "VCards",
  emits: ["clinic-details"],
  components: {},
  props: {
    unitId: {
      type: Number,
      required: true,
    },
    logo: {
      type: String,
      default: "",
    },
    title: {
      type: String,
      default: "",
    },
    subtitle: {
      type: String,
      default: "",
    },
    locality: {
      type: String,
      default: "",
    },
    services: {
      type: Object,
      required: true,
    },
    totalReviews: {
      type: Number,
      required: true,
    },
    averageReviews: {
      type: Number,
      required: false,
      default: 0,
    },
    comments: {
      type: Array,
      default: () => [],
    },
    data() {
      return {
        isHovering: false,
      };
    },
  },
  mounted() {},

  computed: {
    hasComments() {
      return this.comments.length > 0;
    },

    hasAverageReviews() {
      return this.averageReviews > 0;
    },

    hasLocality() {
      return this.locality.length > 0;
    },
  },

  methods: {
    verMais() {
      this.$emit("clinic-details", {
        unitId: this.unitId,
        title: this.title,
        subtitle: this.subtitle,
        locality: this.locality,
        servicesProvided: this.services,
        totalReviews: this.totalReviews,
        averageReviews: this.averageReviews,
        comments: this.comments,
        logo: this.logo,
      });
    },
  },
});
</script>

<style>
.card {
  height: auto !important;
  width: 100% !important;
}
.v-img__img--cover {
  width: 100% !important;
  height: 100% !important;
  object-fit: contain;
}

.v-img__img .v-img__img--cover {
  width: 1rem !important;
  height: 1rem !important;
}

.v-responsive {
  height: 100% !important;
  width: 100% !important;
}

.v-avatar.v-avatar--density-default {
  height: none !important;
  width: none !important;
  border-radius: 0;
}

.title-rating {
  display: flex;
  justify-content: space-between;
  align-items: end;
}
.avaliacoes {
  padding: 0 !important;
}
.card-footer {
  padding: 0 8px 0 5px !important;
}

.list-comments {
  display: flex;
  flex-direction: column;
}

.list-comments-item {
  padding: 1px 15px 1px 15px !important;
  min-height: 0px !important;
}

.v-card-item .v-card-subtitle {
  padding: 0;
}
</style>
