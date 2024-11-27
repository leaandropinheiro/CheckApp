<template>
  <v-hover>
    <template v-slot:default="{ isHovering, props }">
      <v-card
        class="mx-auto card"
        v-bind="props"
        :prepend-avatar="logo"
        :color="isHovering ? '#fff' : undefined"
        :elevation="isHovering ? 10 : 0"
        :style="{
          transform: isHovering ? 'scale(1.01)' : 'scale(1)',
          transition: 'transform 0.3s ease',
          cursor: 'pointer',
        }"
        border="opacity-50 sm "
      >
        <template v-slot:title>
          <div class="title-rating">
            <div class="text-container d-flex flex-column">
              <span class="text-h6">
                {{ title }}
              </span>
              <span class="font-weight-thin text-subtitle-2">
                {{ subtitle }}
              </span>
            </div>

            <div
              class="rating d-flex flex-column ga-2"
              v-if="hasAverageReviews"
            >
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
          </div>
        </template>

        <v-divider></v-divider>
        <v-card-text>
          <v-list v-if="hasComments" lines="one" class="list-comments">
            <v-list-item
              v-for="(comment, index) in comments"
              :key="index"
              class="list-comments-item"
            >
              <v-list-item-subtitle>{{ comment }}</v-list-item-subtitle>
            </v-list-item>
          </v-list>
        </v-card-text>

        <v-container v-if="hasLocality">
          <v-container class="border-sm rounded">
            <v-row no-gutters>
              <v-col cols="1" class="d-flex justify-center align-center">
                <v-icon color="black">mdi-map-marker</v-icon>
              </v-col>
              <v-col
                cols="7"
                lg="8"
                md="8"
                sm="9"
                class="d-flex justify-left align-center"
              >
                <p class="text-subtitle-2 font-weight-medium locality">
                  {{ locality }}
                </p>
              </v-col>
              <v-col
                cols="4"
                lg="3"
                md="3"
                sm="2"
                class="d-flex justify-center align-center"
              >
                <v-btn
                  color="black"
                  text
                  @click="verMais"
                  class="text-capitalize"
                >
                  Ver mais
                </v-btn>
              </v-col>
            </v-row>
          </v-container>
        </v-container>
      </v-card>
    </template>
  </v-hover>
</template>

<script>
import { defineComponent } from "vue";
import emitter from "@/plugins/eventBus";

export default defineComponent({
  name: "VCards",
  components: {},
  props: {
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
      const clinicData = {
        title: this.title,
        subtitle: this.subtitle,
        locality: this.locality,
        servicesProvided: this.services,
        totalReviews: this.totalReviews,
        averageReviews: this.averageReviews,
        comments: this.comments,
        logo: this.logo,
      };

      // console.log("👉 clinicData => ", clinicData);

      emitter.emit("clinic-details", clinicData);
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
</style>
