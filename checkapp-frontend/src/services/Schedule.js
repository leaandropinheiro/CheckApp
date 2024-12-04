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
}

export default Schedule;