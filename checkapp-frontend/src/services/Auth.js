class Auth {
  static async login(msalInstance) {
    try {
      await msalInstance.clearCache();
      const accounts = msalInstance.getAllAccounts();
      if (accounts.length > 0) {
        accounts.forEach(account => {
          msalInstance.removeAccount(account);
        });
      }

      const loginResponse = await msalInstance.loginPopup({
        scopes: [
          "User.Read",
          "User.ReadBasic.All",
          "Mail.Read",
          "Presence.Read"
        ],
        prompt: "select_account",
      });

      const token = loginResponse.accessToken;
      const account = msalInstance.getAllAccounts()[0];

      const userPhoto = await Auth.getUserPhoto(token);
      const userDetails = await Auth.getUserDetails(token);
      const contacts = await Auth.getUserAdresses(token);

      return { account, userDetails, contacts, userPhoto, token };
    } catch (error) {
      if (error.errorCode === "interaction_in_progress") {
        await msalInstance.clearCache();
        return Auth.login(msalInstance);
      }
      throw error;
    }
  }

  static async getUserPhoto(token) {
    try {
      const response = await fetch(
        "https://graph.microsoft.com/v1.0/me/photo/$value",
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.ok) {
        const blob = await response.blob();
        const photoUrl = URL.createObjectURL(blob);
        // Store the blob data as base64 string
        const reader = new FileReader();
        reader.readAsDataURL(blob);
        reader.onloadend = () => {
          localStorage.setItem('userPhotoData', reader.result);
        }
        return photoUrl;
      }
      return null;
    } catch (error) {
      console.error("Error fetching user photo:", error);
      return null;
    }
  }

  static async getUserAdresses(token) {
    try {
      const response = await fetch(
        "https://graph.microsoft.com/v1.0/me/contacts",
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.ok) {
        const data = await response.json();
        return data.value;
      }

      throw new Error("Failed to fetch user addresses");
    } catch (error) {
      console.error("Error fetching user addresses:", error);
      throw error;
    }
  }

  static async getUserDetails(token) {
    try {
      const response = await fetch("https://graph.microsoft.com/v1.0/me", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      if (response.ok) {
        const data = await response.json();
        return data;
      }
      return null;
    } catch (error) {
      console.error("Error fetching user details:", error);
      return null;
    }
  }

  static async logout(msalInstance) {
    return msalInstance.logout();
  }
}

export default Auth;
