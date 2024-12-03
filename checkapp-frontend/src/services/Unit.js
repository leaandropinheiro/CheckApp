import axios from 'axios';

class Unit {
  static async createUnit(name, region, specialty, services) {
    try {
      const params = new URLSearchParams({
        name,
        region,
        specialty,
        services
      });

      const result = await axios.post(`${process.env.VUE_APP_CHKPP_URL}unit?${params}`, null, {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json"
        }
      });

      return result.data;
    } catch (error) {
      console.error("Error creating unit:", error);
      throw error;
    }
  }

  static async getUnitById(unitId) {
    try {
      const result = await axios.get(`${process.env.VUE_APP_CHKPP_URL}unit/${unitId}`);
      return result.data;
    } catch (error) {
      console.error("Error getting unit:", error);
      throw error;
    }
  }

  static async getAllUnits() {
    try {
      const result = await axios.get(`${process.env.VUE_APP_CHKPP_URL}unit`);
      return result.data;
    } catch (error) {
      console.error("Error getting all units:", error);
      throw error;
    }
  }

  static async addExamsToUnit(unitId, exams) {
    try {
      const result = await axios.patch(`${process.env.VUE_APP_CHKPP_URL}unit/${unitId}`, exams);
      return result.data;
    } catch (error) {
      console.error("Error adding exams to unit:", error);
      throw error;
    }
  }

  static async getUnitExams(unitId) {
    try {
      const result = await axios.get(`${process.env.VUE_APP_CHKPP_URL}unit/${unitId}/unitExams`, {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json"
        }
      });

      console.log('👉 result.data => ', result.data);
      return result.data;
    } catch (error) {
      console.error("Error getting unit exams:", error);
      throw error;
    }
  }


  static async addExamToUnit(unitId, examData) {
    try {
      const result = await axios.patch(`${process.env.VUE_APP_CHKPP_URL}unit/${unitId}`, examData, {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json"
        }
      });
      return result.data;
    } catch (error) {
      console.error("Error adding exam to unit:", error);
      throw error;
    }
  }
}

export default Unit;
