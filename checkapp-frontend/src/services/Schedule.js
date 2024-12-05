import axios from 'axios';

class Schedule {
  static async createSchedule(scheduleData) {
    const response = await axios.post(`${process.env.VUE_APP_CHKPP_URL}schedule`, scheduleData, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json"
      }
    });
    return response.data;
  }

  static async getAllSchedules() {
    try {
      const response = await axios.get(`${process.env.VUE_APP_CHKPP_URL}schedule`);

      return response.data;
    } catch (error) {
      throw new Error(error.response.data.message);
    }
  }

  static async getUnitById(unitId) {
    try {
      const response = await axios.get(`${process.env.VUE_APP_CHKPP_URL}unit/${unitId}`);

      return response.data;
    } catch (error) {
      throw new Error(error.response.data.message);
    }
  }
}

export default Schedule;