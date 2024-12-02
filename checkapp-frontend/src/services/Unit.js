import axios from 'axios';
console.log('Connection String:', process.env.VUE_APP_AZURE_STORAGE_CONNECTION_STRING);


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

  static async uploadUnitImage(file, unitId) {
    const accountName = process.env.VUE_APP_STORAGE_ACCOUNT_NAME;
    const accountKey = process.env.VUE_APP_STORAGE_ACCOUNT_KEY;
    const containerName = 'checkapp';
    const blobName = `unidade-${unitId}-${Date.now()}.png`;

    const url = `https://${accountName}.blob.core.windows.net/${containerName}/${blobName}`;

    const response = await axios.put(url, file, {
      headers: {
        'x-ms-blob-type': 'BlockBlob',
        'Content-Type': 'image/png',
        'x-ms-version': '2020-04-08',
        'x-ms-date': new Date().toUTCString(),
        'Authorization': `SharedKey ${accountName}:${accountKey}`
      }
    });

    return url;
  }


  static async getUnitImage(unitId) {
    const accountName = process.env.VUE_APP_STORAGE_ACCOUNT_NAME || 'fso2024checkapp';
    const containerName = 'unidades';
    const blobName = `unidade-${unitId}`;

    return `https://${accountName}.blob.core.windows.net/${containerName}/${blobName}`;
  }

}

export default Unit;
