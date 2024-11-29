class Auth {
  static async login(msalInstance) {
    const loginResponse = await msalInstance.loginPopup({
      scopes: ["User.Read"],
      prompt: "select_account",
    });

    const userPhoto = await Auth.getUserPhoto(loginResponse.accessToken);
    const account = msalInstance.getAllAccounts()[0];

    return { account, userPhoto, token: loginResponse.accessToken };
  }

  static async getUserPhoto(token) {
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
      return URL.createObjectURL(blob);
    }
    return null;
  }

  static async logout(msalInstance) {
    return msalInstance.logout();
  }
}

export default Auth;
