import { createStore } from "vuex";

export default createStore({
  state: {
    Authorization: localStorage.getItem("Authorization")
      ? localStorage.getItem("Authorization")
      : "",
  },
  getters: {},
  mutations: {
    changeLogin(state, data) {
      state.Authorization = data.Authorization;
      localStorage.setItem("Authorization", data.Authorization);
    },
  },
  actions: {},
  modules: {},
});
